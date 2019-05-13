import com.google.gson.Gson;
import com.ql.Dog;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class Test {

    @org.junit.Test
    public void a() {
        Dog dog = new Dog();
        Class c = dog.getClass();
        System.out.println(c.getName());
    }

    @org.junit.Test
    public void b() {
        Class c = Dog.class;
        System.out.println(c.getName());
    }

    @org.junit.Test
    public void c() {
        Class c;
        try {
            c = Class.forName("com.ql.Dog");
            System.out.println(c.getName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @org.junit.Test
    public void d() {
        try {
            Class c = Class.forName("com.ql.Dog");

            System.out.println("-----获取所有公用的构造方法----");
            Constructor[] constructors = c.getConstructors();
            for (Constructor constructor : constructors) {
                System.out.println(constructor);
            }

            System.out.println("-----获取所有的构造方法----");
            Constructor[] declaredConstructors = c.getDeclaredConstructors();
            for (Constructor declaredConstructor : declaredConstructors) {
                System.out.println(declaredConstructor);
            }

            System.out.println("-----获取所有的公共属性----");
            Field[] fields = c.getFields();
            for (Field field : fields) {
                System.out.println(field);
            }

            System.out.println("-----获取所有的属性----");
            Field[] declaredFields = c.getDeclaredFields();
            for (Field field : declaredFields) {
                System.out.println(field);
            }

            Field field = c.getDeclaredField("eye");
            Object obj = c.getConstructor().newInstance();
            field.setAccessible(true);
            field.set(obj, "big");
            Dog dog = (Dog) obj;
            System.out.println(new Gson().toJson(dog));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
