package jdk.newfeatures;

import java.text.NumberFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * java 17 新特性的demo
 * <p>
 * 1、文本块
 * 2、switch表达式
 * 3、record关键字
 * 4、sealed classes密封类
 * 5、instanceof模式匹配
 * 6、Helpful NullPointerExceptions
 * 7、日期周期格式化
 * 8、精简数字格式化支持
 * 9、Stream.toList()简化
 */

public class NewTech {
    public static void main(String[] args){
        highVersion();
        withSwitchExpression(Fruit.APPLE);
        lambdaReturn(Fruit.APPLE);
        printTime();
        printNumber();
    }
    private static void highVersion() {
        String text = """   
                {
                  "name": "NewTechDemo",
                  "version": "JDk 17",
                  "desc": "文本块demo"
                  //
                  /
                  \\
                  \' \t \n  这里换行了
                  
                }
                """;
        System.out.println(text);
    }

    public enum Fruit {
        APPLE, PEAR, MANGO, AVOCADO;
    }

    /**
     * @param fruit switch表达式
     *              1、 分支之间用->实现
     *              2、可以有返回值 返回结果的关键字yield
     *              3、老旧两种风格不能混用
     *              4、中间的有几个版本，case 支持表达式，到17移除了
     */
    private static void withSwitchExpression(Fruit fruit) {
        switch (fruit) {
            case APPLE, PEAR -> System.out.println("普通水果");
            case MANGO, AVOCADO -> System.out.println("进口水果");
            default -> System.out.println("未知水果");
        }
    }

    //支持直接赋值打印
    private static void oldStyleWithYield(Fruit fruit) {

        String text = switch (fruit) {
            case APPLE, PEAR:
                yield "普通水果";
            case MANGO, AVOCADO:
                yield "进口水果";
            default:
                yield "未知水果";
        };
        System.out.println(text);

        System.out.println(switch (fruit) {
            case APPLE, PEAR -> {
                yield "普通水果";
            }
            case MANGO, AVOCADO -> {
                yield "进口水果";
            }
            default -> {
                yield "未知水果";
            }
        });
    }

    private static void lambdaReturn(Fruit fruit) {
        System.out.println(switch (fruit) {
            case APPLE, PEAR -> "普通水果";
            case MANGO, AVOCADO -> "进口水果";
            default -> "未知水果";
        });
    }


    /**
     * record关键字 定位，快速定义一个数据载体，作用类似于class,对于属性
     * 能替代部分lombock的功能
     * 一个Record类被初始化后里面的属性是不能改变的，没有Setter方法而是通过全参数构造来初始化数据，天然线程安全
     */


    public class Person {
        private String name;
        private int age;
        private String address;

        public Person(String name, int age, String address) {
            this.name = name;
            this.age = age;
            this.address = address;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    //eg 用record 快速构建一个DTO
    Person p = new Person("recordDemo", 17, "JDK 17路");

    record PersonRecord(String name, int age) {
    }  //可以省去模板代码

    PersonRecord p1 = new PersonRecord(p.getName(), p.getAge());


    /**
     * sealed classes密封类,有关类的继承。限制类的能被哪些类继承
     * <p>
     * 1、蜜封类限制了子类的继承
     * 2、继承的子类必须用no-sealed,sealed或者final修饰
     * 3、子类在被设置为no-sealed class 后可以被继承
     * 4、继承自密封类的非密封子类的修饰只能是final
     */

    public abstract sealed class Animal permits Panda, Tiger, Dog {
    }

    public non-sealed class Panda extends Animal {
    }

    public final class Tiger extends Animal {
    }

    public sealed class Dog extends Animal permits Corgi {
    }

    public non-sealed class Corgi extends Dog {
    }

    //Cat  类不能继承Animal
//    public final class cat extends Animal {
//    }
//    继承自密封类的非密封子类的修饰只能是final
    public final class WhitePanda extends Panda {
    }

    /**
     * instanceof模式匹配代码简洁化
     *方法 oldStyleInstanceof  newStyleInstanceof功能相同
     *
     */

    private static void oldStyleInstanceof(Object o) {
        if (o instanceof Animal) {
            Animal dog = (Dog) o;
            System.out.println("Dog transfer Animal success"+dog.toString());
        }
    }

    private static void newStyleInstanceof(Object o) {
        if (o instanceof Animal dog) {
            System.out.println("Dog transfer Animal success"+dog.toString());
        }
    }


    /**
     * Helpful NullPointerExceptions
     *
     * Person p = new Person();
     * String cityName = p.getAddress().getCity().getName();
     *在以上的链式调用中如果发生空指针，能更精确的定位发生NPE的位置
     *
     */

// * 日期周期格式化
    public static void printTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("B");
        System.out.println(dtf.format(LocalTime.of(8, 0)));
        System.out.println(dtf.format(LocalTime.of(13, 0)));
        System.out.println(dtf.format(LocalTime.of(20, 0)));
        System.out.println(dtf.format(LocalTime.of(23, 0)));
        System.out.println(dtf.format(LocalTime.of(0, 0)));
    }

    // * 精简数字格式化支持
    public static void printNumber(){
        NumberFormat fmt = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.SHORT);
        System.out.println(fmt.format(1000));
        System.out.println(fmt.format(100000));
        System.out.println(fmt.format(1000000));
        NumberFormat fmt1 = NumberFormat.getCompactNumberInstance(Locale.ENGLISH, NumberFormat.Style.LONG);
        System.out.println(fmt1.format(1000));
        System.out.println(fmt1.format(100000));
        System.out.println(fmt1.format(1000000));
        NumberFormat chfmt = NumberFormat.getCompactNumberInstance(Locale.CHINA, NumberFormat.Style.SHORT);
        System.out.println(chfmt.format(1000));
        System.out.println(chfmt.format(100000));
        System.out.println(chfmt.format(1000000));
    }
    // * Stream.toList()简化
    private static void streamBriefToList() {
        Stream<String> stringStream = Stream.of("a", "b", "c");
        //1.8的表达
        List<String> stringList =  stringStream.collect(Collectors.toList());
        for(String s : stringList) {
            System.out.println(s);
        }
        //17新的简洁表达
        List<String> briefStyle =  stringStream.toList();
        for(String s : briefStyle) {
            System.out.println(s);
        }
    }

}
