package reflect;

//123

/**
 * @Author IVyujie
 * @Date 2020/2/11 0011 11:01
 */
public class Person implements MyInterface,MyInterface2
{
    private String id;
    private String name;
    public String testName;

    public Person() {
        this.id = null;
        this.name = null;
    }

    public Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }



    private void pMethod(){

    }

    @Override
    public void ImplMethod() {

    }

    @Override
    public void ImplMethod2() {

    }

    private void mySecretMethod()
    {
        System.out.println("Get out of my secret!!!");
    }

    private void mySecretMethod(String name)
    {
        System.out.println("Get out of my secret:"+name);
    }

    public void sayHi()
    {
        System.out.println("Hello I am a person");
    }
}
