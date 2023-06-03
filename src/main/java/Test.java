public class Test {

    public static void main(String[] args) {
        int n = 12;
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";


        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {
            int index
                    = (int) (AlphaNumericString.length()
                    * (Math.random()));
            sb.append(AlphaNumericString
                    .charAt(index));
        }
        System.out.println(sb.toString());
    }
}
