package cd.ac.uea.assessment.order;
import org.springframework.stereotype.Component;

@Component
public class InventoryClient {

    public boolean checkStock(Long productId) {
        if (productId == 2L) {
            return false;
        }

        return true;
    }
}
