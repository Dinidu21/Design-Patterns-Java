## Payment Processing System

Imagine you're building a payment processing system that needs to handle multiple payment methods (Credit Card, PayPal, Stripe, Bank Transfer). Different clients (web app, mobile app, POS systems) need to process payments, but:

1. The payment processing system shouldn't know the specific details of how each payment method works (Dependency Inversion)
2. Payment methods may change or new ones may be added in the future
3. Each payment method has different validation rules and processing flows
4. The system needs to handle different payment flows while keeping the core business logic separate from payment implementation details

Specific requirements that make this a good scenario:
- Each payment method needs to validate payment details differently:
    - Credit Card needs card number, CVV, expiry validation
    - PayPal needs email and PayPal token validation
    - Bank Transfer needs account number and routing number validation
    - Stripe needs Stripe token and customer ID validation

- Each payment has common operations but different implementations:
    - validatePayment()
    - processPayment()
    - refundPayment()
    - getPaymentStatus()

This scenario demonstrates both Factory Pattern and Dependency Inversion because:
1. Factory Pattern: Creates different payment processors without exposing instantiation logic
2. Dependency Inversion: High-level modules (payment processing) depend on abstractions (payment interface), not concrete implementations

The client code should be able to process payments without knowing the specific payment method implementation

This is a real-world scenario because:
- Payment processing is a common requirement
- It has clear separation of concerns
- It demonstrates practical use of interfaces and abstractions
- It's easily extendable for new payment methods
- It reflects actual business requirements in financial systems

Would you like me to provide the implementation for this scenario?