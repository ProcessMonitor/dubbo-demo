import org.junit.jupiter.api.Test;

public class StrUtilT {

    @Test
    void SubStrTest() {
        String str = " hello world ";
        String strNotSame = new String(" hello world ");
        System.out.println(str.substring(str.length() - 2));
        // StarWith
        System.out.println(str.startsWith("he"));
        // trim空格
        System.out.println(str.trim().startsWith("he"));
        System.out.println(str.equals(strNotSame));
        System.out.println(str == strNotSame);
    }
}
