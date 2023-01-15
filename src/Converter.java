import java.util.HashMap;
import java.util.Map;

class Converter {
    Map<String, String> romanMap = new HashMap<>();


    Converter() {
        romanMap.put("I",    "1");
        romanMap.put("II",   "2");
        romanMap.put("III",  "3");
        romanMap.put("IV",   "4");
        romanMap.put("V",    "5");
        romanMap.put("VI",   "6");
        romanMap.put("VII",  "7");
        romanMap.put("VIII", "8");
        romanMap.put("IX",   "9");
        romanMap.put("X",    "10");
        romanMap.put("XX",   "20");
        romanMap.put("XXX",  "30");
        romanMap.put("XL",   "40");
        romanMap.put("L",    "50");
        romanMap.put("LX",   "60");
        romanMap.put("LXX",  "70");
        romanMap.put("LXXX", "80");
        romanMap.put("XC",   "90");
        romanMap.put("C",    "100");
    }


    String convertToArab (String roman) {
        return romanMap.get(roman);
    }

    String convertToRoman (String arab) {
        int n = Integer.parseInt(arab);
        String result;
        if (n < 10 || n % 10 == 0) {
            result = arabToRoman(arab);
        }
        else {
            String tens = Integer.toString(n - n % 10);
            String ones = Integer.toString(n % 10);
            result = arabToRoman(tens) + arabToRoman(ones);
        }
        return result;
    }

    String arabToRoman (String arab){
        for (Map.Entry<String, String> entry : romanMap.entrySet()) {
            if (arab.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }
}
