package payment.service;

import org.springframework.stereotype.Service;
import payment.model.ParagraphDetails;

import java.util.LinkedHashMap;

@Service
public class UtilServiceImpl implements UtilService{
    @Override
    public ParagraphDetails getParagraphDetails(String paragraphs) {
        String[] str = paragraphs.split("[,;' ']");
        LinkedHashMap map = new LinkedHashMap();
        for(int i=0;i<str.length;i++){
            String key = str[i].trim();
            if(!(key.equalsIgnoreCase("a") || key.equalsIgnoreCase("an") || key.equalsIgnoreCase("The"))){
                if(map.get(key)==null){
                    map.put(key,1);
                }else{
                    int count = (int) map.get(key);
                    map.put(key, ++count);
                }
            }
        }
        ParagraphDetails  paragraphDetails = new ParagraphDetails();
        paragraphDetails.setDuplictaes(map);
        paragraphDetails.setReverse(new StringBuilder(paragraphs).reverse().toString());
        return paragraphDetails;
    }
}
