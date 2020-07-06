package payment.model;

import java.util.HashMap;
import java.util.Map;

public class ParagraphDetails {

    private String reverse;
    Map<String, Integer> duplictaes = new HashMap<String, Integer>();

    public void setReverse(String reverse) {
        this.reverse = reverse;
    }

    public void setDuplictaes(Map<String, Integer> duplictaes) {
        this.duplictaes = duplictaes;
    }

    public String getReverse() {
        return reverse;
    }

    public Map<String, Integer> getDuplictaes() {
        return duplictaes;
    }
}
