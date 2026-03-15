package bridge;

public class BridgePattern {
    public static void main(String[] args) {
        PaymentGateway razorpay = new RazorPayPaymentGateway();
        PaymentGateway paypal = new PayPalPaymentGateway();
        PaymentGateway stripe = new StripePaymentGateway();

        Payment creditCardPayment = new CreditCardPayment(razorpay);
        creditCardPayment.makePayment(5000);

        System.out.println();

        Payment upiPayment = new UPIPayment(paypal);
        upiPayment.makePayment(1500);

        System.out.println();

        Payment walletPayment= new WalletPayment(stripe);
        walletPayment.makePayment(3400);
    }
}


// Payment Gateway Interface
// Abstraction for the Payment
interface PaymentGateway {
    void processPayment(double amount);
}

// Concrete Payment Gateway Implementation
// Implementation for the gateway - RazorPay, Stripe, PayPal
class RazorPayPaymentGateway implements PaymentGateway{
    @Override
    public void processPayment(double amount) {
        System.out.println(String.format("Processing the Payment For Amount=%s Via RazorPay",amount
        ));
    }
}

// Stripe Payment Gateway Implementation
class StripePaymentGateway implements PaymentGateway{

    @Override
    public void processPayment(double amount) {
        System.out.println(String.format("Processing the Payment For Amount=%s Via Stripe",amount
        ));
    }
}

// PayPal Payment Gateway Implementation
class PayPalPaymentGateway implements PaymentGateway{

    @Override
    public void processPayment(double amount) {
        System.out.println(String.format("Processing the Payment For Amount=%s Via PayPal",amount
        ));
    }
}

// Abstraction for the Payment to be used with Any Payment Gateway
abstract class Payment{
    // Payment Supports any Payment Gateway acting as the bridge
    protected PaymentGateway paymentGateway;

    public Payment(PaymentGateway paymentGateway){
        this.paymentGateway=paymentGateway;
    }

    abstract void makePayment(double amount);
}

// Payment methods to use - CreditCard, UPI, Wallet
class CreditCardPayment extends Payment{

    public CreditCardPayment(PaymentGateway paymentGateway){
        // Calling the payment Abstract class
        super(paymentGateway);
    }

    @Override
    void makePayment(double amount) {
        System.out.println("Payment via CreditCard");
        this.paymentGateway.processPayment(amount);
    }
}

// Payment methods to use - UPI
class UPIPayment extends Payment{
    public UPIPayment(PaymentGateway paymentGateway){
        super(paymentGateway);
    }

    @Override
    void makePayment(double amount) {
        System.out.println("Payment via UPI");
        this.paymentGateway.processPayment(amount);
    }
}

// Payment method to use Wallet
class WalletPayment extends Payment{
    public WalletPayment(PaymentGateway paymentGateway){
        super(paymentGateway);
    }

    @Override
    void makePayment(double amount) {
        System.out.println("Payment via Wallet");
        this.paymentGateway.processPayment(amount);
    }
}