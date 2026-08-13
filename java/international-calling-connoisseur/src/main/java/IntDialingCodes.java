import java.util.Map;

public interface IntDialingCodes <Keys, Values>{

    public Map<Keys, Values> getCodes();
    public void setDialingCode(Keys llaves, Values valores);
    public Values getCountry(Keys code);
    public void addNewDialingCode(Keys code, Values country);
    public Keys findDialingCode(Values country);
    public void updateCountryDialingCode(Keys code, Values country);
}
