package kg.attractor.edufood.exception;

public class RestaurantNotFoundException extends RuntimeException {
    public RestaurantNotFoundException() {
    }

    public RestaurantNotFoundException(String message) {
        super(message);
    }
}
