package reflect;

import java.lang.reflect.Field;

/**
 * @Author IVyujie
 * @Date 2020/2/11 0011 14:34
 */
public class PropertiesUtil
{
    public static void setProperty(Object obj,String propName,Object value)
    {
        Class cls=obj.getClass();
        try {
            Field field=cls.getDeclaredField(propName);
            field.setAccessible(true);
            field.set(obj,value);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
