public class principal{
    public static void main(String[] args) {
        DialingCodes dialingCodes = new DialingCodes();
        System.out.println(dialingCodes.getCodes());

        dialingCodes.setDialingCode(679, "Fiji");
        System.out.println(dialingCodes.getCodes());

        dialingCodes.setDialingCode(679, "Unknown");
        dialingCodes.setDialingCode(679, "Fiji");
        System.out.println(dialingCodes.getCodes());

        DialingCodes dialingCodes2 = new DialingCodes();
        dialingCodes2.setDialingCode(60, "Malaysia");
        dialingCodes2.setDialingCode(233, "Retrieving...");
        dialingCodes2.setDialingCode(56, "Chile");
        dialingCodes2.setDialingCode(233, "Ghana");
        System.out.println(dialingCodes2.getCodes());

        DialingCodes dialingCodes3 = new DialingCodes();
        dialingCodes3.setDialingCode(55, "Brazil");
        System.out.println(dialingCodes3.getCountry(55));

        DialingCodes dialingCodes4 = new DialingCodes();
        dialingCodes4.setDialingCode(962, "Retrieving...");
        dialingCodes4.setDialingCode(962, "Jordan");
        System.out.println(dialingCodes4.getCountry(962));

        DialingCodes dialingCodes5 = new DialingCodes();
        dialingCodes5.addNewDialingCode(32, "Belgium");
        dialingCodes5.addNewDialingCode(379, "Vatican City");
        System.out.println(dialingCodes5.getCodes());

        DialingCodes dialingCodes6 = new DialingCodes();
        dialingCodes6.addNewDialingCode(32, "Belgium");
        dialingCodes6.addNewDialingCode(379, "Vatican City");
        dialingCodes6.addNewDialingCode(32, "Other");
        System.out.println(dialingCodes6.getCodes());

        DialingCodes dialingCodes7 = new DialingCodes();
        dialingCodes7.addNewDialingCode(61, "Australia");
        dialingCodes7.addNewDialingCode(1000, "Australia");
        System.out.println(dialingCodes7.getCodes());

        DialingCodes dialingCodes8 = new DialingCodes();
        dialingCodes8.addNewDialingCode(44, "UK");
        System.out.println(dialingCodes8.findDialingCode("UK"));

        DialingCodes dialingCodes9 = new DialingCodes();
        dialingCodes9.addNewDialingCode(44, "UK");
        System.out.println((dialingCodes.findDialingCode("Unlisted")));

        DialingCodes dialingCodes10 = new DialingCodes();
        dialingCodes10.addNewDialingCode(88, "Japan");
        dialingCodes10.updateCountryDialingCode(81, "Japan");
        System.out.println(dialingCodes10.getCodes());


    }
}

 //
   /* public Map<Integer, String> getCodes() {
        throw new UnsupportedOperationException(
                "Delete this statement and write your own implementation.");
    }

    public void setDialingCode(Integer code, String country) {
        throw new UnsupportedOperationException(
                "Delete this statement and write your own implementation.");
    }

    public String getCountry(Integer code) {
        throw new UnsupportedOperationException(
                "Delete this statement and write your own implementation.");
    }

    public void addNewDialingCode(Integer code, String country) {
        throw new UnsupportedOperationException(
                "Delete this statement and write your own implementation.");
    }

    public Integer findDialingCode(String country) {
        throw new UnsupportedOperationException(
                "Delete this statement and write your own implementation.");
    }

    public void updateCountryDialingCode(Integer code, String country) {
        throw new UnsupportedOperationException(
                "Delete this statement and write your own implementation.");
    }

    */