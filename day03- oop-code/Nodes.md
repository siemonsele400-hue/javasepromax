# Day03 - Java 面向对象进阶（三）：内部类、枚举、泛型与常用API

**日期**：2026年01月27日

**摘要**：今天是面向对象进阶部分的最后一块拼图。主要攻克了几个对于后续框架学习至关重要的概念：**匿名内部类**（Lambda 的前身）、**枚举**（规范的常量管理）、**泛型**（Java 类型系统的基石）以及开发中最常用的 **API**（Object, Integer, Objects）。

---

## 一、 内部类 (Inner Class)

内部类不仅仅是代码位置的变化，它体现了一种**高内聚**的设计思想：当一个类（B）仅仅服务于另一个类（A）时，B 就应该定义在 A 的内部。

### 1.1 成员内部类 (Member Inner Class)

这是最普通的内部类，定义在类中、方法外。

* **核心特性**：它可以无条件访问外部类的所有成员（包括私有的和静态的）。
* **实战痛点**：当外部类和内部类有同名变量时，如何区分？

**演示代码 (`Outer.java` 解析):**

```java
package com.siemonsele.d1_innerclass1;

public class Outer {
    public static String schoolName = "zzuit";
    private int age = 18;

    public static void inAddr(){
        System.out.println("我们在zzuit");
    }

    // 成员内部类
    // 特点：属于外部类的对象，必须先 new 外部类，再 new 内部类
    public class Inner{
        private String name;
        private int age = 20; // 与外部类同名变量

        public void show(){
            // 1. 访问外部类静态成员 -> 直接访问
            System.out.println(schoolName);
            inAddr();

            // 2. 访问外部类实例成员 -> 直接访问
            // 面试题：同名变量访问规则
            System.out.println(age);             // 访问内部类的局部变量/成员变量 (就近原则)
            System.out.println(this.age);        // 明确访问内部类的成员变量
            System.out.println(Outer.this.age);  // ★ 重点：访问外部类的成员变量
        }
    }
}

```

> **知识扩充**：JDK 源码中 `ArrayList` 的迭代器 `Itr` 就是一个典型的成员内部类。因为它需要直接访问 `ArrayList` 内部私有的数组 `elementData` 来遍历元素，定义在内部最方便。

### 1.2 匿名内部类 (Anonymous Inner Class) ★★★

这是本日最核心的语法，它是 Java 函数式编程（Lambda）的基石。

* **定义**：一个没有名字的局部内部类。
* **本质**：它是**继承了该类（父类）或实现了该接口**的**子类匿名对象**。
* **应用场景**：当一个参数需要一个接口对象，而我们只需要用一次，不想专门去写一个实现类时。

**演示代码 (基于接口的匿名内部类):**

```java
package com.siemonsele.d4_innerclass4;

public class Test2 {
    public static void main(String[] args) {
        // 场景：go 方法需要一个 Swimming 接口的实现类对象
        
        // 1. 传统方式（太麻烦）：定义一个 class Student implements Swimming，然后 new Student()
        
        // 2. 匿名内部类方式（高效）：
        // 这里并不是 new 了接口，而是 new 了一个实现接口的“无名类”的对象
        Swimming s1 = new Swimming(){
            @Override
            public void swim(){
                System.out.println("学生：狗刨式游泳~~~");
            }
        };
        go(s1);

        // 3. 极致简洁写法：直接作为参数传递
        go(new Swimming(){
            @Override
            public void swim(){
                System.out.println("老师：专业蛙泳~~~");
            }
        });
    }

    public static void go(Swimming s){
        System.out.println("---比赛开始---");
        s.swim(); // 多态调用
        System.out.println("---比赛结束---");
    }
}

interface Swimming{
    void swim();
}

```

---

## 二、 枚举 (Enum)

以前定义常量我们习惯用 `public static final int CONST = 1;`，但这不够安全（编译器不检查值）。枚举的出现解决了这个问题。

### 2.1 枚举的本质

枚举看似特殊，其实是语法糖。

* 枚举类默认继承自 `java.lang.Enum`。
* 枚举的第一行必须罗列所有实例，它们本质上是 `public static final` 的单例对象。
* **构造器强制私有**：你不能在外部 `new` 枚举。

**演示代码 (`A.java`):**

```java
package com.siemonsele.d5_enum;

public enum A {
    // 1. 必须第一行罗列枚举实例
    X, Y, Z; 
    
    // 2. 枚举里也可以定义成员变量和方法
    private String name;

    // 3. 构造器默认是 private
    A() {
    }

    public String getName() {
        return name;
    }
}

```

### 2.2 枚举的高级应用：做信息标志

使用枚举做参数，可以实现**强类型约束**，避免传入非法值。

**实战演示：**

```java
// 传统常量方式：
// handleDate(3.5, 999); // 编译器不报错，但 999 是非法指令

// 枚举方式：
// handleDate(3.5, Direction.UP); // 只能传枚举里定义好的值，安全！

public static double handleDate(double number, ConstantEnum mode){
    switch (mode){
        case UP:
            return Math.ceil(number);
        case DOWN:
            return Math.floor(number);
        default:
            return number;
    }
}

```

---

## 三、 泛型 (Generics)

泛型是 Java 这种强类型语言为了**兼顾灵活性和安全性**而设计的。如果没有泛型，集合里取出来的都是 `Object`，需要强制类型转换，极易报错。

### 3.1 泛型类

在类定义时使用 `<E>`、`<T>` 等占位符，真正使用类时才确定具体类型。

**演示代码 (模拟 ArrayList):**

```java
package com.siemonsele.d8_genericity_class;

import java.util.ArrayList;

// 定义泛型类，E 代表某种未知的类型
public class MyArrayList<E> {
    private ArrayList list = new ArrayList();

    // 方法参数使用泛型 E
    public boolean add(E e){
        list.add(e);
        return true;
    }

    public boolean remove(E e){
        return list.remove(e);
    }
}

// 使用：
// MyArrayList<String> list = new MyArrayList<>();
// list.add("Java"); // 此时编译器会检查，add 方法只能接收 String
// list.add(123);    // 报错！这就是泛型的安全性

```

### 3.2 泛型方法

如果类不是泛型类，但某个方法想要接收多种类型的参数，可以定义泛型方法。

**语法**：`public <T> 返回值类型 方法名(T t)`

**演示代码:**

```java
public class Test {
    public static void main(String[] args) {
        String[] names = {"张三", "李四"};
        Integer[] nums = {10, 20};
        
        printArray(names); // T 被推导为 String
        printArray(nums);  // T 被推导为 Integer
    }

    // <T> 在返回值 void 之前，声明这是个泛型方法
    public static <T> void printArray(T[] array){
        if(array != null){
            StringBuilder sb = new StringBuilder("[");
            for (int i = 0; i < array.length; i++) {
                sb.append(array[i]).append(i == array.length - 1 ? "" : ", ");
            }
            System.out.println(sb.append("]"));
        }
    }
}

```

---

## 四、 常用 API (工具箱)

### 4.1 Object & Objects

* **`toString()`**: 默认打印地址，开发中必须重写，以打印对象内容。
* **`equals()`**: 默认比较地址（`==`），必须重写，以比较对象内容。
* **`Objects.equals(a, b)`**: **推荐使用！** 它可以处理 `a` 为 `null` 的情况，避免空指针异常。

### 4.2 Integer (包装类)

Java 为了万物皆对象，给 8 种基本数据类型都提供了对应的包装类。

* **自动装箱**：`Integer a = 10;` (基本类型 -> 对象)
* **自动拆箱**：`int b = a;` (对象 -> 基本类型)
* **核心功能**：将字符串转换为数字（Web 开发中接收前端参数必备）。

**演示代码 (`d13_integer/Test.java`):**

```java
public class Test {
    public static void main(String[] args) {
        String ageStr = "23";
        // 1. parseInt 返回 int 基本类型 (效率略高)
        int age = Integer.parseInt(ageStr);
        
        // 2. valueOf 返回 Integer 对象
        Integer ageObj = Integer.valueOf(ageStr);

        System.out.println("明年年龄: " + (age + 1));
        
        // 坑点记录：Integer 缓存池
        Integer a = 127;
        Integer b = 127;
        System.out.println(a == b); // true (在 -128~127 缓存范围内)
        
        Integer c = 129;
        Integer d = 129;
        System.out.println(c == d); // false (超出范围，new 了新对象)
        // 结论：对象比较永远用 equals()！
    }
}

```

---

## 五、 学习总结

今天的学习完成了从“写出程序”到“设计程序”的思维转变。

1. **匿名内部类**让代码更紧凑，是理解后续 Lambda 表达式的关键。
2. **泛型**是阅读 JDK 源码（如 List, Map）的钥匙。
3. **Objects** 和 **Integer** 等工具类的掌握，能让我的代码更健壮（少报 NullPointerException）。

接下来的目标是将这些知识点应用到我的“苍穹外卖”实战项目中，特别是泛型在通用 Result 响应类中的设计。
