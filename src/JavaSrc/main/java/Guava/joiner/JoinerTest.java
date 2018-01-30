package JavaSrc.main.java.Guava.joiner;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.Maps;

import java.util.List;
import java.util.Map;

/**
 * Created on 2017/8/15.
 */
public class JoinerTest {
    /**
     * 使用StringBuilder进行对字符串集合，使用delimiter进行拼接
     * @param stringList 字符串集合
     * @param delimiter 拼接的字符
     * @return 拼接后的字符串
     */
    public String buildString(List<String> stringList, String delimiter){
        StringBuilder builder = new StringBuilder();
        for(String s : stringList){
           if(s != null){
                builder.append(s).append(delimiter);
           }
        }

        builder.setLength(builder.length() - delimiter.length());
        return builder.toString();
    }

    public String guavaJoiner(List<String> stringList, String delimiter){
        //return Joiner.on(delimiter).useForNull("*").join(stringList);
        return Joiner.on(delimiter).skipNulls().join(stringList);
    }

    public void test(){
        Joiner joiner = Joiner.on("|").skipNulls();
        StringBuilder stringBuilder = new StringBuilder();
        joiner.appendTo(stringBuilder, "111","222","333");
        System.out.println("...."+stringBuilder);
        Map<String, String> mapString = Maps.newLinkedHashMap();
        mapString.put("陕西","西安");
        mapString.put("山西","太原");
        mapString.put("河南","郑州");
        mapString.put("四川","成都");

        String returnStr = Joiner.on("#").withKeyValueSeparator("-").join(mapString);
        System.out.println(returnStr);

        Joiner stringJoiner = Joiner.on("|").skipNulls();
    //    stringJoiner.useForNull("missing");
        stringJoiner.join("foo","bar",null,"dd");
        System.out.println(stringJoiner.join("foo","bar",null,"dd"));
    }


    public void testMapJoiner(){
        String expectedString = "BeiJing=beijing#HeNan" +
                "=zhengzhou#Shannxi=xi'an#SiChuan=chengdu";
        Map<String, String> testMap = Maps.newLinkedHashMap();
        testMap.put("BeiJing", "beijing");
        testMap.put("HeNan", "zhengzhou");
        testMap.put("Shannxi", "xi'an");
        testMap.put("SiChuan", "chengdu");
        String resultString = Joiner.on("#").withKeyValueSeparator("=").join(testMap);
        System.out.println(resultString+"................");
       // assertThat(reusltString, is(expectedString));
    }

    public void testSplit(){
        String str1 = "Monday;Tuesday;;Thursday;Friday;;";
        String regex = ",|，|;|；|\\s+";
        String[] strArr = str1.split(regex);
        System.out.println(strArr.length);
        for(String s : strArr){
            System.out.println(s+"....");
        }
        String str = "Monday|Tuesday||Thursday|Friday||";
        System.out.println(Splitter.on('|').split(str));
    }
}
