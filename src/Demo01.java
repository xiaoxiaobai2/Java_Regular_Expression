import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则匹配
 * @author 张浩
 * @date 2019.09.26
 */
public class Demo01 {
    public static void main(String[] args) {
        Pattern pattern=Pattern.compile("\\d+");//1个或多个数字
        Matcher m= pattern.matcher("da as wf wgerh rhta123456das a 1234568753534354");
//        System.out.println(m.find());//匹配所有
//        System.out.println(m.end());
        System.out.println(m.toString());
        System.out.println(m.replaceAll("#"));
    }
}
