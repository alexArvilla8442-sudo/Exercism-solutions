
class Principal{
    public static void main(String[] args) {
        var raindropConverter = new RaindropConverter();
        System.out.println(raindropConverter.convert(1));
        System.out.println(raindropConverter.convert(3));
        System.out.println(raindropConverter.convert(5));
        System.out.println(raindropConverter.convert(7));
        System.out.println(raindropConverter.convert(6));
        System.out.println(raindropConverter.convert(8));
        System.out.println(raindropConverter.convert(9));
        System.out.println(raindropConverter.convert(10));
        System.out.println(raindropConverter.convert(14));
        System.out.println(raindropConverter.convert(15));
        System.out.println(raindropConverter.convert(21));
        System.out.println(raindropConverter.convert(25));
        System.out.println(raindropConverter.convert(27));
        System.out.println(raindropConverter.convert(35));
        System.out.println(raindropConverter.convert(49));
        System.out.println(raindropConverter.convert(52));
        System.out.println(raindropConverter.convert(105));
        System.out.println(raindropConverter.convert(3125));
    }
}



class RaindropConverter {

    /*
    * is divisible by 3, add "Pling" to the result.
is divisible by 5, add "Plang" to the result.
is divisible by 7, add "Plong" to the result.
is not divisible by 3, 5, or 7, the result should be the number as a string.
    * */
    String convert(int number) {
        boolean esDivisible3 = number % 3 == 0;
        boolean esDivisible5 = number % 5 == 0;
        boolean esDivisible7 = number % 7 == 0;

        StringBuilder rainDropMessage = new StringBuilder();

        if(esDivisible3){
            rainDropMessage.append("Pling");
        }
        if(esDivisible5){
            rainDropMessage.append("Plang");
        }
        if(esDivisible7){
            rainDropMessage.append("Plong");
        }

        if(rainDropMessage.isEmpty()){
            return String.valueOf(number);
        }

        return rainDropMessage.toString();
    }

}
