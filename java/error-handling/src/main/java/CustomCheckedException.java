import java.io.IOException;

class CustomCheckedException extends Exception {

    CustomCheckedException() {
        System.out.println("CustomCheckedException");
    }

    CustomCheckedException(String message) {
        super(message);
    }

}
