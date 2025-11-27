package cd.ac.uea.assessment.legacy;

import org.springframework.web.bind.annotation.*;
import java.sql.SQLException;

@RestController
@RequestMapping("/payments")
public class LegacyPaymentController {

    private final LegacyPaymentProcessor paymentProcessor;

    public LegacyPaymentController(LegacyPaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    @PostMapping
    public String processPayment(@RequestParam Long orderId, @RequestParam double amount) {
        try {
            paymentProcessor.processPayment(orderId, amount);
            return "Payment processed successfully";
        } catch (SQLException e) {
            return "Payment failed: " + e.getMessage();
        }
    }
}