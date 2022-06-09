import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HomeWorkHard {
    private static final String EMAIL_REGEX = "\\s*([a-z\\d-]+)@([a-z\\d-]+)\\.([a-z]{2,6})+\\s*";
    private static final String PHONE_NUMBER_REGEX = "\\s*7(9\\d{9})+\\s*";
    private static final String FULL_NAME_REGEX = "\\s*[А-ЯЁ][-А-яЁё]+\\s+([А-ЯЁ][-А-яЁё]+\\s+){1,5}[А-ЯЁ][-А-яЁё]+\\s*";

    public static void main(String[] args) {
        String beforeAll = "<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client>";
        String beforeFullNamePhoneNumber = "<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client>";
        String beforeNo = "<client>(Какие то данные)<data></data></client>";
        String afterAll = masking(beforeAll);
        String afterFullNamePhoneNumber = masking(beforeFullNamePhoneNumber);
        String afterNo = masking(beforeNo);
        System.out.println(afterAll);
        System.out.println(afterFullNamePhoneNumber);
        System.out.println(afterNo);
    }

    public static String masking(String text) {
        StringBuilder maskingText = new StringBuilder(text);
        Matcher matcherEmail = Pattern.compile(EMAIL_REGEX).matcher(maskingText);
        Matcher matcherPhoneNumber = Pattern.compile(PHONE_NUMBER_REGEX).matcher(maskingText);
        Matcher matcherFullName = Pattern.compile(FULL_NAME_REGEX).matcher(maskingText);
        if (matcherEmail.find()) {
            maskEmail(matcherEmail.group(), maskingText);
        }
        if (matcherPhoneNumber.find()) {
            maskPhoneNumber(matcherPhoneNumber.group(), maskingText);
        }
        if (matcherFullName.find()) {
            maskFullName(matcherFullName.group(), maskingText);
        }
        return maskingText.toString();
    }

    public static void maskEmail(String email, StringBuilder maskingText) {
        StringBuilder stringEmailAfter = new StringBuilder();
        String[] emailArray = email.split("\\s*(\\s|,|@|\\.)\\s*");
        String domainName = emailArray[1];
        stringEmailAfter
                .append(emailArray[0], 0, emailArray[0].length()-1)
                .append("*")
                .append("@")
                .append("*".repeat(domainName.length()))
                .append(".")
                .append(emailArray[2]);
        int start = maskingText.indexOf(email);
        int end = start + email.length();
        maskingText.replace(start, end, stringEmailAfter.toString());
    }

    public static void maskPhoneNumber(String phoneNumber, StringBuilder maskingText) {
        StringBuilder stringPhoneNumber = new StringBuilder(phoneNumber);
        int start = maskingText.indexOf(phoneNumber);
        int end = start + phoneNumber.length();
        maskingText.replace(start, end, stringPhoneNumber.replace(4, 7, "***").toString());
    }

    public static void maskFullName(String fullName, StringBuilder maskingText) {
        StringBuilder stringFullNameAfter = new StringBuilder();
        int start = maskingText.indexOf(fullName);
        int end = start + fullName.length();
        String[] fullNameArray = fullName.split(" ");
        stringFullNameAfter
                .append(fullNameArray[0].charAt(0))
                .append("*".repeat(fullNameArray[0].length()-2))
                .append(fullNameArray[0].charAt(fullNameArray[0].length()-1))
                .append(" ")
                .append(fullNameArray[1])
                .append(" ")
                .append(fullNameArray[2].charAt(0))
                .append(".");
        maskingText.replace(start, end, stringFullNameAfter.toString());
    }
}
