package Hello.core.Order;

public interface OrderService {
    Order createOrder(Long memberId, String ItemName, int itemPrice);
}
