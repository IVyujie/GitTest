package reflect;

import java.io.FileReader;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Ref;
import java.util.Properties;

/**
 * @Author IVyujie
 * @Date 2020/2/11 0011 14:11
 */
public class ReflectDynamicTest
{
    public static void main(String[] args) {
        try
        {
            Properties properties=new Properties();
            properties.load(new FileReader("E:\\SpringLearningTest\\java_basic_practice\\src\\info.txt"));
            String className=properties.getProperty("classname");
            String methodName=properties.getProperty("methodname");
            Class cls=Class.forName(className);
            Method method=cls.getMethod(methodName);
            method.invoke(cls.newInstance());

            Person person=new Person();
            Student stu=new Student();
            PropertiesUtil.setProperty(person,"id","s1001");
            PropertiesUtil.setProperty(stu,"name","zx");
            System.out.println(person.getId()+"\n"+stu.getName());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }


}
