package com.example.tdd.api.payment;

import com.example.tdd.api.order.OrderReader;
import com.example.tdd.api.order.Orders;
import com.example.tdd.api.orderProduct.OrderProduct;
import com.example.tdd.api.payment.dto.PaymentRequest;
import com.example.tdd.api.product.Product;
import com.example.tdd.api.product.ProductReader;
import com.example.tdd.api.user.UserReader;
import com.example.tdd.api.user.Users;
import com.example.tdd.common.util.CommonReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class PaymentServiceImpl implements PaymentService {

    private final UserReader userReader;
    private final ProductReader productReader;
    private final OrderReader orderReader;
    private final PaymentRepository paymentRepository;

    @Transactional
    @Override
    public boolean balancePay(Long userId, PaymentRequest paymentRequest) {
        Users users = userReader.getUser(userId);
        Orders orders = orderReader.getOrderByOrderNumber(paymentRequest.getOrderNumber());

        // 상품 재고 확인

        // 잔액 확인
        String uuid = CommonReader.getCurrentDateTime() + "-" + UUID.randomUUID();

        if (users.getBalance() < orders.getAmount()) {
            // 재고 롤백 처리
            List<OrderProduct> orderProductList = orders.getOrderProductList();
            for (OrderProduct orderProduct : orderProductList) {
                Product product = productReader.getProduct(orderProduct.getProduct().getProductId());
                product.increaseStock(orderProduct.getCnt());
            }

            // 결제 실패
            paymentRepository.save(Payment.builder()
                    .paymentNumber(uuid)
                    .users(users)
                    .orders(orders)
                    .amount(orders.getAmount())
                    .paymentMethod(Payment.PaymentMethod.BALANCE)
                    .paymentState(Payment.PaymentState.CANCEL)
                    .build());

            orders.updateState(Orders.OrderState.CANCEL);

            return false;
        } else {
            users.useBalance(orders.getAmount());

            paymentRepository.save(Payment.builder()
                    .paymentNumber(uuid)
                    .users(users)
                    .orders(orders)
                    .amount(orders.getAmount())
                    .paymentMethod(Payment.PaymentMethod.BALANCE)
                    .paymentState(Payment.PaymentState.COMPLETE)
                    .build());

            orders.updateState(Orders.OrderState.PAYMENT_COMPLETE);

            return true;
        }
    }
}
