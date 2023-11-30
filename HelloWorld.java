public class HelloWorld {
    public static void main(String[] args) {
        System.out.println(func("2021:1:1", null));
        System.out.println("xxx");
    }

    public static int func(String s1, String s2) {
        try {
            if (s1.compareTo(s2) > 0) {
                return 1;
            } else if (s1.compareTo(s2) < 0) {
                return 2;
            } else {
                return 0;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return -1;
        }
    }
}