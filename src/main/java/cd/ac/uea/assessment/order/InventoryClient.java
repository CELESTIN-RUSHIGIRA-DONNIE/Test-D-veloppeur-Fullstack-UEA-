package cd.ac.uea.assessment.order;

import org.springframework.stereotype.Component;

@Component
public class InventoryClient {

    public boolean checkStock(Long productId) {
        // Simulating external call
        // In a real scenario, this might call another microservice
        return true; 
    }
}
