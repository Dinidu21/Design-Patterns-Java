package model;

public class PayPalDetailsDTO {
    private String email;
    private String token;

    public PayPalDetailsDTO(String email, String token) {
        this.email = email;
        this.token = token;
    }

    public boolean isValid() {
        return email != null && email.contains("@") &&
                token != null && !token.trim().isEmpty();
    }
}
