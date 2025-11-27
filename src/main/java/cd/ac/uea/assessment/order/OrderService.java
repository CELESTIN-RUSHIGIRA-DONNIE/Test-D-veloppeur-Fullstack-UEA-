package cd.ac.uea.assessment.order;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;

    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;
    }

    @Transactional
    public Order placeOrder(Long userId, Long productId) {

        boolean inStock = inventoryClient.checkStock(productId);

        if (!inStock) {
            throw new OutOfStockException(
                "Le produit " + productId + " n'est plus en stock."
            );
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setProductId(productId);
        order.setStatus("PLACED");

        return orderRepository.save(order);
    }
}
