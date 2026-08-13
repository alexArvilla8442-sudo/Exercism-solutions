import java.util.Objects;
import java.util.Set;

class Principal{
    public static void main(String[] args) {
        /*var operacion1 = new CalculatorConundrum();
        System.out.println(operacion1.calculate(22, 25, "+"));

        //(378_961, 399_635, "+")).isEqualTo("378961 + 399635 = 778596"
        var operacion2 = new CalculatorConundrum();
        System.out.println(operacion2.calculate(378_961, 399_635, "+"));

        var operacion3 = new CalculatorConundrum();
        System.out.println(operacion3.calculate(3, 21, "*"));

        //72_441, 2_048, "*")).isEqualTo("72441 * 2048 = 148359168");
        var operacion4 = new CalculatorConundrum();
        System.out.println(operacion4.calculate(72_441, 2_048, "*"));

        var operacion5 = new CalculatorConundrum();
        System.out.println(operacion5.calculate(72, 9, "/"));

        var operacion6 = new CalculatorConundrum();
        System.out.println(operacion6.calculate(1_338_800, 83_675, "/"));

        var operacion7 = new CalculatorConundrum();
        System.out.println(operacion7.calculate(3, 78, "**"));*/

        //var operacion8 = new CalculatorConundrum();
        //System.out.println(operacion8.calculate(72, 9, null));

        //var operacion9 = new CalculatorConundrum();
        //System.out.println(operacion9.calculate(34, 324, ""));

        var operacion10 = new CalculatorConundrum();
        System.out.println(operacion10.calculate(33, 0, "/"));
    }
}


class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation){

        if(operation == null){
            throw new IllegalArgumentException("Operation cannot be null");
            //throw new IllegalOperationException("Operation cannot be null");
            //return resultadoFinal;
        }

        boolean isEmpty = operation.isEmpty();
        if(isEmpty){
            throw new IllegalArgumentException("Operation cannot be empty");
        }

        String resultadoFinal = "";
        //boolean isNull = Objects.isNull(operation);
        Set<String> operacionesPermitidas = Set.of("+", "/", "*");
        boolean doesNotContainSimbol = (!operacionesPermitidas.contains(operation));
        //boolean isDividedByZero = operand2 == 0;

        try{
            char operacionChar = operation.charAt(0);
            if(doesNotContainSimbol) {
                throw new IllegalOperationException("Operation '%s' does not exist".formatted(operation));
            }
            /*else if(isDividedByZero){
                throw new IllegalOperationException("Division by zero is not allowed", "ArithmeticException");
            }*/

            //no hay errores
            String resultado = switch (operacionChar){
                case '+' -> this.addition(operand1, operand2) + "";
                case '*' -> this.multiplication(operand1, operand2) + "";
                case '/' -> this.division(operand1, operand2) + "";
                default -> throw new IllegalOperationException("Operation %s does not exist".formatted(operation));
            };
            resultadoFinal = "%d %s %d = %s".formatted(operand1, operation , operand2, resultado);

        }catch (ArithmeticException e) {
            //System.out.println("Division by zero is not allowed");
            throw new IllegalOperationException("Division by zero is not allowed", e);
        }


        return resultadoFinal;
    }

    private int addition(int operand1, int operand2) {
        return operand1 + operand2;
    }

    private int multiplication(int operand1, int operand2) {
        return operand1 * operand2;
    }

    private int division(int operand1, int operand2) {
        return operand1 / operand2;
    }


}
