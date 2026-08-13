class Principal{
    public static void main(String[] args) {
        var reverseString = new ReverseString();
        System.out.println(reverseString.reverse(""));
        System.out.println(reverseString.reverse("robot"));
        System.out.println(reverseString.reverse("Ramen"));
        System.out.println(reverseString.reverse("I'm hungry!"));
        System.out.println(reverseString.reverse("racecar"));
        System.out.println(reverseString.reverse("drawer"));


    }
}

class ReverseString {

    String reverse(String inputString) {
        String reverse = new StringBuilder(inputString).reverse().toString();
        return reverse;
    }
  
}
