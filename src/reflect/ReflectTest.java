package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Author IVyujie
 * @Date 2020/2/11 0011 11:02
 */
public class ReflectTest {
    public static void main(String[] args) {
        //Class.forName需要捕获异常
        try {
            Class cp = Class.forName("reflect.Person");
            System.out.println(cp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //类名.class
        Class cp2 = Person.class;
        System.out.println(cp2);

        //对象.getClass();
        MyInterface myInterface = new Person();
        Class cp3 = myInterface.getClass();
        System.out.println(cp3);

        //获取接口及方法
        try {
            Class ci = Class.forName("reflect.Person");
            Class[] impls = ci.getInterfaces();
            for (int i = 0; i < impls.length; i++) {
                System.out.println(impls[i] + " " + impls[i].getMethods());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //获取父类
        Class cf = Person.class;
        Class cfc = cf.getSuperclass();
        System.out.println(cfc);

        //获取构造方法
        Constructor[] cons = cf.getConstructors();
        for (Constructor con : cons) {
            System.out.println(con);
        }
        System.out.println("***********");
        //获取属性
        Field[] fields = cp2.getFields();
        System.out.println(fields.length);
        for (Field field : fields) {
            System.out.println(field);
        }

        System.out.println("***********");
        //获取所有公共方法（当前类，父类）
        Method[] methods = cp2.getMethods();
        for (Method method : methods) {
            System.out.println(method);
        }
        System.out.println("*********");
        //获取当前类所有方法
        Method[] methods1 = cp2.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method);
        }
        //获取一个当前类的对象
        try {
            Object object = cp2.newInstance();
            ((Person) object).ImplMethod();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
