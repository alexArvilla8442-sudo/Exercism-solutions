class Principal{
    public static void main(String[] args) {

        var numberToCheck = new ArmstrongNumbers();
        System.out.println(numberToCheck.isArmstrongNumber(0));
        System.out.println(numberToCheck.isArmstrongNumber(5));
        System.out.println(numberToCheck.isArmstrongNumber(10));
        System.out.println(numberToCheck.isArmstrongNumber(153));
        System.out.println(numberToCheck.isArmstrongNumber(100));
        System.out.println(numberToCheck.isArmstrongNumber(9474));
        System.out.println(numberToCheck.isArmstrongNumber(9475));
        System.out.println(numberToCheck.isArmstrongNumber(9926315));
        System.out.println(numberToCheck.isArmstrongNumber(9926314));
    }

}

class ArmstrongNumbers {

    boolean isArmstrongNumber(int numberToCheck) {
        String numberString = String.valueOf(numberToCheck);
        int numeroDigitos = numberString.length();
        int resultado = 0;

        for (int i = 0; i < numberString.length(); i++) {
            char digit = numberString.charAt(i);
            int digito = Integer.parseInt(digit+"");

            double digitoElevadoPotencia = Math.pow(digito, numeroDigitos);
            resultado += (int)digitoElevadoPotencia;
        }

        //System.out.println("Resultado: " + resultado);
        boolean isNumberArmstrong = (resultado == numberToCheck);
        return isNumberArmstrong;
    }

}
