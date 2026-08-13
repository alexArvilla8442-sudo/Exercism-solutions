import java.io.IOException;

class CustomUncheckedException extends RuntimeException {

    CustomUncheckedException() {
        //throw new UnsupportedOperationException("Error programa");
        System.out.println("CustomUncheckedException");
    }

    CustomUncheckedException(String message) {

        //throw new UnsupportedOperationException(message);
        super(message);
    }

}
