import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Optional;

class Principal{
    public static void main(String[] args) throws IOException, CustomCheckedException {
        var errorHandling = new ErrorHandling();
        //IllegalArgumentException
        //errorHandling.handleErrorByThrowingIllegalArgumentException();
        //errorHandling.handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage("This is the detail message.");

        //any checked
        //errorHandling.handleErrorByThrowingAnyCheckedException();
        //errorHandling.handleErrorByThrowingAnyCheckedExceptionWithDetailMessage("This is the detail message.");

        //unchecked
        //errorHandling.handleErrorByThrowingAnyUncheckedException();
        //errorHandling.handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage("This is the detail message.");

        //checked
        //errorHandling.handleErrorByThrowingCustomCheckedException();
        //errorHandling.handleErrorByThrowingCustomCheckedExceptionWithDetailMessage("This is the detail message.");

        //unchecked
        //errorHandling.handleErrorByThrowingCustomUncheckedException();
        //errorHandling.handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage("This is the detail message.");

        Optional<Integer> successfulResult = errorHandling.handleErrorByReturningOptionalInstance("1");
        System.out.println(successfulResult);
        //assertThat(successfulResult).isPresent().hasValue(1);

        Optional<Integer> failureResult = errorHandling.handleErrorByReturningOptionalInstance("a");
        System.out.println(failureResult);
    }
}

class ErrorHandling {

    void handleErrorByThrowingIllegalArgumentException() {
        throw new IllegalArgumentException();
    }

    void handleErrorByThrowingIllegalArgumentExceptionWithDetailMessage(String message) {
        throw new IllegalArgumentException(message);
    }

    //checked
    void handleErrorByThrowingAnyCheckedException() throws IOException {
        throw new IOException();
    }
    void handleErrorByThrowingAnyCheckedExceptionWithDetailMessage(String message) throws IOException {
        throw new IOException(message);
    }

    //unchecked
    void handleErrorByThrowingAnyUncheckedException() {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingAnyUncheckedExceptionWithDetailMessage(String message) {
        throw new CustomUncheckedException(message);
    }

    //checked
    void handleErrorByThrowingCustomCheckedException() throws CustomCheckedException {
        throw new CustomCheckedException();
    }

    void handleErrorByThrowingCustomCheckedExceptionWithDetailMessage(String message) throws CustomCheckedException{
        throw new CustomCheckedException(message);
    }

    //unchecked
    void handleErrorByThrowingCustomUncheckedException() {
        throw new CustomUncheckedException();
    }

    void handleErrorByThrowingCustomUncheckedExceptionWithDetailMessage(String message) {
        throw new CustomUncheckedException(message);
    }

    Optional<Integer> handleErrorByReturningOptionalInstance(String integer) {
        //throw new UnsupportedOperationException("Delete this statement and write your own implementation.");
        //return Optional.of(Integer.parseInt(integer));
        int numero=0;
        try{
            numero =  Integer.parseInt(integer);

        }catch(NumberFormatException e){
            return Optional.empty();
        }
        return Optional.of(numero);
    }

}
