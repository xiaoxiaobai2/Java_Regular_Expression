import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 爬取网页  并用正则表达式 获取特定内容
 * @author 张浩
 * @date 2019.09.26
 */
public class WebSpider {
    public static void main(String[] args) {
        String content=getContent("https://www.163.com","网易");
        //指定正则匹配规则
        Pattern pattern=Pattern.compile("(?<=\")(http.+?)(?=\")");
        Matcher matcher=pattern.matcher(content);
        while (matcher.find()){
            //输出每一条符合规则的子串
            System.out.println(matcher.group());
        }
    }

    /**
     * 获取网页内容
     * @param s
     * @param name
     * @return
     */
    public static String getContent(String s,String name){
        StringBuffer content=new StringBuffer();
        //网页内容保存的文件名
        File f=new File(name+".txt");
        try {
            URL url=new URL(s);
            BufferedReader bf=new BufferedReader(new InputStreamReader(url.openStream(),"gbk"));
            String car="";
            BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f),"gbk"));
            while (null!=(car=bf.readLine())){
                content.append(car);
                bw.write(car);
                bw.newLine();
                content.append("\n");
            }
            bw.flush();
            System.out.println(content);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }
}
