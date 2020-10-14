public class Main {
    public static void main(String[] args) {
        System.out.println("post" + System.getProperty("testString"));

        String s = "от 749,00 до 2 165,00 р.";
        System.out.println(s.indexOf(" "));
        System.out.println(s.indexOf("до"));
        System.out.println(s.substring(4,s.indexOf("до")));

    }
}
