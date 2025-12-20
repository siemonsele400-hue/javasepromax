# Java基础进阶Day01：面向对象进阶（一）知识总结

## 一、 static 关键字

`static` 是 Java 中的一个修饰符，表示“静态”。它最重要的特性是：**被类中所有对象共享**。

### 1. static 修饰成员变量（类变量）

* **类变量：** 有 `static` 修饰，属于类，在内存中只有一份，被所有对象共享。
* **实例变量：** 无 `static` 修饰，属于每个对象，每个对象都有一份独立的。

**访问方式：**

* 类变量：`类名.类变量名`（推荐）或 `对象名.类变量名`。
* 实例变量：`对象名.实例变量名`。

**代码示例：**

```java
public class Student {
    // 类变量：全校名称都是一样的，用static共享，节省内存
    static String schoolName = "黑马程序员"; 
    // 实例变量：每个学生的姓名和年龄是不一样的
    String name;
    int age;

    public void show() {
        System.out.println(name + " 在 " + schoolName + " 学习");
    }
}

// 测试类
public class Test {
    public static void main(String[] args) {
        // 直接通过类名修改类变量
        Student.schoolName = "传智教育"; 
        
        Student s1 = new Student();
        s1.name = "张三";
        s1.show(); // 张三 在 传智教育 学习

        Student s2 = new Student();
        s2.name = "李四";
        s2.show(); // 李四 在 传智教育 学习（s1的修改影响了s2）
    }
}

```

### 2. static 修饰成员方法（类方法）

* **类方法：** 有 `static` 修饰，属于类，建议用 `类名.方法名` 调用。
* **实例方法：** 无 `static` 修饰，属于对象，必须创建对象后调用。

**应用场景——工具类：**
如果一个方法只是为了完成某个通用功能（如数组排序、验证码生成），不涉及对象特有的数据，应定义为静态方法。

> **注意：** 工具类的构造器通常建议私有化（`private`），防止他人创建对象浪费内存。

**代码示例：**

```java
public class MyUtils {
    // 私有构造器，不让外界创建对象
    private MyUtils() {}

    // 类方法：生成验证码
    public static String createCode(int n) {
        // 具体实现逻辑...
        return "ABCD";
    }
}

```

### 3. static 的注意事项（高频面试题）

1. **静态方法只能访问静态成员**，不能直接访问实例成员（变量/方法）。
2. **实例方法既可以访问静态成员，也可以访问实例成员。**
3. **静态方法中绝对不能出现 `this` 关键字**，因为 `this` 代表当前对象，而静态方法执行时可能根本没有对象。

---

## 二、 static 应用知识：代码块

代码块是类中与成员变量、方法平级的结构。

1. **静态代码块：** `static { ... }`
* **特点：** 随着类的加载而执行，且**只执行一次**。
* **作用：** 用于对类变量进行初始化赋值。


2. **实例代码块：** `{ ... }`（很少用）
* **特点：** 每次创建对象时都会执行，且在构造器之前执行。



---

## 三、 static 应用知识：单例设计模式

单例模式确保一个类在系统中**永远只有一个实例对象**。

### 1. 饿汉单例

在类加载时对象就已经创建好了。

```java
public class A {
    // 1. 私有化构造器
    private A() {}
    // 2. 定义静态变量存储一个对象
    private static A instance = new A();
    // 3. 提供静态方法返回该对象
    public static A getInstance() {
        return instance;
    }
}

```

### 2. 懒汉单例

第一次调用 `getInstance` 方法时才创建对象。

```java
public class B {
    private static B instance;
    private B() {}
    public static B getInstance() {
        if (instance == null) {
            instance = new B();
        }
        return instance;
    }
}

```

---

## 四、 面向对象特征之二：继承 (Inheritance)

继承是用 `extends` 关键字让子类与父类建立联系。子类可以获得父类的非私有成员。

### 1. 继承的特点与好处

* **好处：** 提高代码复用性，减少冗余。
* **限制：** Java 是**单继承**的（一个类只能有一个直接父类），但支持**多层继承**。
* **Object类：** Java中所有类都是 `Object` 的子类。

### 2. 子类访问成员的特点（就近原则）

在子类中访问成员（变量或方法）的顺序：

1. 子类局部范围
2. 子类成员范围
3. 父类成员范围
4. ...直到 Object 类

* **如果重名：** 使用 `super.成员` 访问父类，`this.成员` 访问子类。

### 3. 方法重写 (@Override)

当父类的方法无法满足子类需求时，子类可以写一个完全一样的方法覆盖父类。

* **建议：** 加上 `@Override` 注解，可以检查重写格式是否正确。

---

## 五、 继承中的构造器（重难点）

### 1. 子类构造器的执行原理

**子类的所有构造器，都会先调用父类的无参构造器，再执行自己。**

* 默认第一行有一句隐式的 `super();`。
* **原因：** 子类初始化时，可能用到父类的数据，必须先确保父类部分初始化完毕。

### 2. super(...) 调用父类有参构造器

**应用场景：** 当父类成员变量是私有的（`private`）时，子类无法直接赋值，必须通过 `super(...)` 调用父类的构造器来完成初始化。

**代码案例：**

```java
class Teacher extends People {
    private String skill;

    public Teacher(String name, int age, String skill) {
        // 调用父类的有参构造器，完成name和age的初始化
        super(name, age); 
        this.skill = skill;
    }
}

```

### 3. this(...) 调用兄弟构造器

在同一个类中，一个构造器可以调用另一个构造器。

* **注意：** `this(...)` 和 `super(...)` 都必须放在第一行，所以**二者不能同时出现**。

**代码演示：**

```java
public class Student {
    private String name;
    private String schoolName;

    public Student(String name) {
        // 借用本类的两个参数构造器，默认给学校赋值
        this(name, "黑马程序员"); 
    }

    public Student(String name, String schoolName) {
        this.name = name;
        this.schoolName = schoolName;
    }
}

```

---

## 总结

1. **static** 是为了**共享**，属于类，不属于对象。
2. **继承** 是为了**复用**，子类“是”一种特殊的父类。
3. **super** 指向父类，**this** 指向当前对象。
4. **构造器执行顺序**：父类永远先于子类初始化。
