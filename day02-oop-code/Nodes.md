# Day 02 Java面向对象进阶（二）详细实战总结

## 一、多态 (Polymorphism)

多态是面向对象编程中非常灵活的机制，核心在于“**同一个接口，使用不同的实例而执行不同操作**”。

### 1. 多态的代码体现与前提

在代码 `d1_polymorphism` 包中，展示了多态的基础形态。

* **代码解析** (`d1_polymorphism/Test.java`, `Animal.java`, `Cat.java`, `Dog.java`):
```java
// 1. 父类引用指向子类对象 (前提：继承 + 重写)
Animal a1 = new Cat();
Animal a2 = new Dog();

// 2. 行为多态：编译看左边(Animal)，运行看右边(Cat/Dog)
a1.cry(); // 输出：小猫喵喵叫~
a2.cry(); // 输出：小狗汪汪叫~

```


**解析**：这就是多态的魅力，`a1` 和 `a2` 都是 `Animal` 类型，但执行 `cry()` 方法时表现出了具体的子类行为。

### 2. 多态的弊端与类型转换

多态虽然灵活，但父类引用无法直接调用子类的独有方法。解决方案是**强制类型转换**。

* **代码解析** (`d3_polymorphism/Test.java`):
```java
Animal a = new Dog();
a.cry(); // 多态调用

// a.lookDoor(); // 报错！编译看左边，Animal没有lookDoor方法

// 解决方案：强制类型转换 (向下转型)
if (a instanceof Dog) { // 安全检查：判断a是否真的是Dog类型
    Dog d = (Dog) a;
    d.lookDoor(); // 输出：小狗会看门
} else if (a instanceof Cat) {
    Cat c = (Cat) a;
    c.eat();
}

```


**解析**：
* **向上转型** (`Animal a = new Dog()`)：自动完成，安全，但丢失子类特有功能。
* **向下转型** (`Dog d = (Dog) a`)：需要强制转换。
* **`instanceof`**：在强转前必须使用此关键字判断，防止运行时出现 `ClassCastException`。



---

## 二、final 关键字 & 常量

`final` 用于修饰不可改变的内容，在 `d4_final` 包中有详细演示。

### 1. Final 的三种用法

* **修饰类**：该类不能被继承（断子绝孙）。
* **修饰方法**：该方法不能被重写。
* **修饰变量**：只能赋值一次。

### 2. 常量 (Constant)

在实际开发中，`static final` 常用于定义系统配置。

* **代码解析** (`d4_final/Constant.java`):
```java
public class Constant {
    // 常量命名规范：全大写，下划线分隔
    // static：共享，通过类名访问
    // final：不可修改
    public static final String SCHOOL_NAME = "传智教育";
}

```


* **应用场景** (`d4_final/FinalDemo2.java`):
```java
// 代码中凡是需要学校名称的地方，直接使用常量
System.out.println(Constant.SCHOOL_NAME);

```


**解析**：这样做的好处是，如果将来学校改名，只需要修改 `Constant` 类中的一个值，全项目的引用都会自动更新，极大地提高了可维护性。程序编译后会进行**宏替换**，性能无损耗。

---

## 三、抽象类 (Abstract Class) & 模板方法模式

抽象类是“半成品”，主要用于制定规范和复用代码。`d7_abstract_demo2` 包中的案例非常经典。

### 1. 抽象类的定义

* **抽象方法**：`public abstract void run();` (只管定义，不管实现)。
* **抽象类**：包含抽象方法的类必须是抽象类。**不能实例化**。

### 2. 实战：模板方法设计模式

这是抽象类最高频的使用场景。案例模拟了学生和老师写作文《我的爸爸》。

* **父类/模板类** (`d7_abstract_demo2/People.java`):
```java
public abstract class People {
    // 模板方法：定义了通用的执行流程
    // 使用 final 修饰，防止子类修改模板结构
    public final void write(){
        System.out.println("\t\t\t 《我的爸爸》"); // 通用头

        // 易变部分：具体的正文内容，交给子类去实现
        writeMain(); 

        System.out.println("\t有这样的爸爸真好！"); // 通用尾
    }

    // 抽象方法：强制子类去实现正文
    public abstract void writeMain();
}

```


* **子类实现** (`d7_abstract_demo2/Student.java`):
```java
public class Student extends People{
    @Override
    public void writeMain(){
        System.out.println("\t我的爸爸很好..."); // 学生具体的实现
    }
}

```


**解析**：
1. **复用性**：标题和结尾的重复代码全部在父类写好了。
2. **强制性**：父类强制子类必须重写 `writeMain()`，保证了每个子类都有自己的核心逻辑。
3. **安全性**：`write()` 方法加上 `final`，防止子类篡改流程。



---

## 四、接口 (Interface) & 综合案例

接口是比抽象类更彻底的抽象，是Java实现解耦合的关键。`d10_interface_demo` 包展示了一个接近真实开发的案例。

### 1. 接口基础与 JDK 8+ 新特性

* **基本用法**：接口定义行为规范，类通过 `implements` 实现。
* **新特性** (`d12_interface_jdk8/A.java`):
```java
public interface A {
    // 1. 默认方法 (default): 解决接口升级问题，不强制实现类重写
    default void run() {
        go(); // 内部复用私有方法
        System.out.println("跑得快");
    }

    // 2. 私有方法 (private): JDK 9+，服务于默认方法，隐藏逻辑
    private void go() { ... }

    // 3. 静态方法 (static): 工具方法，通过接口名调用
    static void inAddr(){ ... }
}

```



### 2. 综合案例：面向接口编程 (解耦合)

案例需求：实现一个班级学生信息管理模块，要求能灵活切换不同的业务实现方案（方案1：普通打印；方案2：带统计打印）。

* **定义接口 (规范)** (`d10_interface_demo/ClassData.java`):
```java
public interface ClassData {
    void printAllStudentOnfos();         // 打印信息
    void printAllStudentAverageScores(); // 打印平均分
}

```


* **方案一实现** (`d10_interface_demo/ClassDataImpl1.java`):
```java
public class ClassDataImpl1 implements ClassData {
    // ... 简单的遍历打印实现
}

```


* **方案二实现** (`d10_interface_demo/ClassDataipml2.java`):
```java
public class ClassDataipml2 implements ClassData {
    // ... 复杂的实现：统计男女生人数，去掉最高分最低分算平均分
}

```


* **调用端 (灵活切换)** (`d10_interface_demo/Test.java`):
```java
ArrayList<Student> students = ...; // 数据准备

// 关键点：面向接口编程
// 如果想切换方案，只需要改这一行代码（new Impl1 改为 new Impl2）
// 后面的方法调用代码完全不需要动！
ClassData data = new ClassDataImpl1(students); 
// ClassData data = new ClassDataipml2(students); 

data.printAllStudentOnfos();
data.printAllStudentAverageScores();

```


**解析**：
这是接口最大的价值——**解耦合**。`Test` 类（使用者）只依赖 `ClassData` 接口，而不依赖具体的实现类。当业务逻辑发生巨大变化（从方案1变方案2）时，调用者的改动降到了最低。

---

### 总结与建议

今天的学习重点是从“语法”转向“设计”。

1. **多态**让代码更灵活（编译时不确定具体对象）。
2. **抽象类（模板方法）**通过继承复用代码流程。
3. **接口**通过规定标准实现模块间的解耦。

**后续练习建议**：
重点复习 `d10_interface_demo` 包，尝试自己写一个 `ClassDataImpl3`（比如按成绩排序打印），并在 `Test` 中切换使用，亲身体会面向接口编程的好处。
