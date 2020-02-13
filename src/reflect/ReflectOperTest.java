package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author IVyujie
 * @Date 2020/2/11 0011 12:08
 */
public class ReflectOperTest
{
    public static void main(String[] args) {
        //ctrl+alt+v自动补全方法返回值
        try {
            Class<?> aClass = Class.forName("reflect.Person");
            Person person=(Person) (aClass.newInstance());
            Field field=aClass.getDeclaredField("id");
            //默认不能修改private值，必须开启以下操作
            field.setAccessible(true);

            field.set(person,"1001");
            System.out.println(person.getId());
            System.out.println("*********");

            Method mySecretMethod = aClass.getDeclaredMethod("mySecretMethod", null);
            mySecretMethod.setAccessible(true);
            mySecretMethod.invoke(person,null);

            Method myMethod2=aClass.getDeclaredMethod("mySecretMethod",String.class);
            myMethod2.setAccessible(true);
            myMethod2.invoke(person,"DDDDD");

            //用Constructor来构建对象
            Constructor<?> declaredConstructor = aClass.getDeclaredConstructor(String.class,String.class);
            Object newInstance = declaredConstructor.newInstance("1002","张三");
            Person p2=((Person)newInstance);
            System.out.println(p2.getId()+" "+p2.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
