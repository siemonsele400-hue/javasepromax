## day01作业

#### 重点知识[整理笔记 + 演讲]

1. static可以用来修饰什么？各自有何特点？和应用场景？

* **修饰成员变量（类变量）：**
* **特点**：属于类，内存中仅一份，被所有对象共享 。
* **场景**：适合存储全局共享的数据，如系统在线人数、学校名称 。

* **修饰成员方法（类方法）：**
* **特点**：直接用类名调用，不依赖对象 。
* **场景**：常用于编写工具类方法（如 `Math.abs()`） 。

2. static注意事项有哪些？

* 静态方法只能直接访问静态成员，不能访问实例成员 。

* 实例方法可以访问静态成员，也可以访问实例成员 。

* **静态方法中不能使用 `this` 关键字**，因为静态方法属于类，而 `this` 代表当前对象 。

3. 单例设计模式是什么意思？什么是懒汉式？什么是饿汉式？

* **核心思想**：确保一个类在系统中只有一个实例 。

* **饿汉式**：类加载时就创建好对象，获取对象速度快，但可能浪费内存 。

* **懒汉式**：第一次需要用到时才创建对象，节省内存 。

4. 代码块有几种？分别有何特点和作用？

* **静态代码块**：`static { ... }`，随类加载执行一次。用于初始化类变量 。


* **实例代码块**：`{ ... }`，每次创建对象前执行。用于初始化实例变量 。

5. 继承是什么？为什么要在程序中使用继承？


* **定义**：使用 `extends` 让类与类产生父子关系 。

* **目的**：减少代码冗余，提高代码复用性 。

6. 方法重写和方法重载是什么样的？

* **重写 (Override)**：子类出现与父类完全一样的方法声明，用于覆盖父类行为 。

* **重载 (Overload)**：同一类中方法名相同但参数列表不同 。

7. 子类构造器有什么特点？

* 子类所有构造器默认都会先调用父类的无参构造器（隐式 `super()`），以确保父类数据先初始化 。

8. this和super有哪些作用？

* **this**：代表当前对象。`this(...)` 用于调用本类其他构造器 。

* **super**：代表父类存储空间。`super(...)` 用于调用父类构造器 。
------

**重点代码或案例[上机操作]**

1.系统启动后，要求用户类可以记住自己创建了多少个用户对象

```java
public class User {
    // 静态变量，属于类，所有对象共享
    public static int onlineNumber = 0;

    public User() {
        // 每创建一个对象，计数器加1
        User.onlineNumber++;
    }
}

```

2.定义一个工具类,拥有生成指定位数验证码,和获取2个整数最大值的功能

```java
public class MyUtils {
    private MyUtils() {} // 私有构造，防止创建对象

    public static String createCode(int n) {
        String code = "";
        String data = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < n; i++) {
            int index = (int)(Math.random() * data.length());
            code += data.charAt(index);
        }
        return code;
    }

    public static int getMax(int a, int b) {
        return a > b ? a : b;
    }
}

```

---

3.使用单例设计模式设计student类,保证该类只有一个对象产生


实现单例模式通常需要满足三个关键条件：

1. **构造器私有化**：防止外部通过 `new` 关键字随意创建对象。
2. **定义静态变量**：用于存储类唯一的实例。
3. **提供公共获取方法**：让外部通过该静态方法获取唯一的对象。

---

## 1. 饿汉式单例（Eager Initialization）

这种方式在类加载时就完成了实例的初始化。它的优点是获取对象速度快、线程安全，但如果该对象一直不被使用，会造成内存浪费。

```java
public class Student {
    // 1. 私有化构造器：确保外部不能 new
    private Student() {
    }

    // 2. 在内部定义一个静态变量存储唯一的对象
    // 饿汉式：类加载时直接初始化
    private static Student instance = new Student();

    // 3. 提供一个静态方法返回该对象
    public static Student getInstance() {
        return instance;
    }
}

```

---

## 2. 懒汉式单例（Lazy Initialization）

这种方式在第一次调用获取方法时才创建对象。它的优点是节省内存，只有在需要时才占用空间，但需要注意多线程环境下的安全问题。

```java
public class Student {
    // 1. 私有化构造器
    private Student() {
    }

    // 2. 定义静态变量存储对象（此时不初始化）
    private static Student instance;

    // 3. 提供静态方法返回对象
    public static Student getInstance() {
        // 第一次调用时，instance 为 null，此时创建对象
        if (instance == null) {
            instance = new Student();
        }
        return instance;
    }
}

```

---

## 3. 测试验证

为了验证单例模式是否生效，我们可以通过比较两个变量的**内存地址**来确认。

```java
public class Test {
    public static void main(String[] args) {
        // 通过类名提供的静态方法获取对象
        Student s1 = Student.getInstance();
        Student s2 = Student.getInstance();

        // 打印地址值进行比较
        System.out.println(s1); // 例如：Student@15db9742
        System.out.println(s2); // 地址一定相同：Student@15db9742
        System.out.println(s1 == s2); // 输出：true
    }
}

```

---

### 💡 核心逻辑总结

| 模式 | 创建时机 | 优缺点 |
| --- | --- | --- |
| **饿汉式** | 类加载时即创建 | 速度快，线程安全；但可能浪费内存。 |
| **懒汉式** | 第一次使用时创建 | 延迟加载，省内存；但在高并发下可能产生多个对象。 |

> **提示**：在实际开发中，如果该单例对象占用资源较多，建议使用懒汉式；如果对象较轻且确定会使用，饿汉式是更简单的选择。

4.在黑马的员工管理系统中,需要处理讲师、咨询师的数据
讲师的数据有: 姓名、具备的技能
咨询师的数据有: 姓名、解答问题的总人数

针对黑马员工管理系统的这个需求，我们应当运用**面向对象中的继承（Inheritance）思想**来处理。

通过观察发现，讲师和咨询师都属于“员工”，且都拥有“姓名”这一共同属性。如果分别为两个类定义姓名，会造成代码冗余。因此，我们可以抽取出一个父类来统一管理共有数据。

---

### 1. 架构设计思路

* **父类（Employee）**：存放所有员工共有的属性，如 `name`（姓名）。
* **讲师类（Lecturer）**：继承 `Employee`，并添加独有属性 `skill`（具备的技能）。
* **咨询师类（Consultant）**：继承 `Employee`，并添加独有属性 `count`（解答问题的总人数）。

---

### 2. 代码实现

#### 第一步：定义父类 `Employee`

父类负责初始化所有员工都有的基本信息。

```java
public class Employee {
    private String name; // 共有属性：姓名

    public Employee() {}

    public Employee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

```

#### 第二步：定义子类 `Lecturer`（讲师）

子类通过 `extends` 关键字继承父类，并使用 `super` 调用父类构造器完成姓名的赋值。

```java
public class Lecturer extends Employee {
    private String skill; // 独有属性：技能

    public Lecturer(String name, String skill) {
        // 子类构造器必须先通过 super 初始化父类中的共有属性
        super(name); 
        this.skill = skill;
    }

    public void show() {
        System.out.println(getName() + " 老师具备的技能有：" + skill);
    }
}

```

#### 第三步：定义子类 `Consultant`（咨询师）

咨询师类同样继承父类，管理其特有的业务数据。

```java
public class Consultant extends Employee {
    private int count; // 独有属性：解答人数

    public Consultant(String name, int count) {
        super(name);
        this.count = count;
    }

    public void show() {
        System.out.println(getName() + " 咨询师已解答了 " + count + " 人的问题");
    }
}

```

---

### 3. 测试运行

```java
public class Test {
    public static void main(String[] args) {
        // 创建讲师对象
        Lecturer l = new Lecturer("阿玮", "Java, Python, 微服务");
        l.show();

        // 创建咨询师对象
        Consultant c = new Consultant("张三", 1500);
        c.show();
    }
}

```

---

### 💡 核心知识总结

1. **为什么使用继承？**
* **减少代码冗余**：姓名属性只需在 `Employee` 中写一次，子类自动获得。
* **提高扩展性**：如果以后增加“助教”岗位，只需继承 `Employee` 即可，无需重写姓名相关的代码。


2. **super 关键字的关键作用**：
* 在子类构造器中，由于父类的 `name` 属性通常是私有的（`private`），子类无法直接赋值，必须通过 `super(name)` 调用父类的构造器来完成初始化。

------

#### 代码题：

##### 第一题：分析以下需求，并用代码实现

```tex
1.定义项目经理类 
	属性：
		姓名 工号 工资 奖金
	行为：
		工作work
2.定义程序员类
	属性：
		姓名 工号 工资
	行为：
		工作work
3.要求:向上抽取一个父类,让这两个类都继承这个父类,共有的属性写在父类中，子类重写父类中的方法
	编写测试类:完成这两个类的测试
```

需求的核心在于考察**继承（Inheritance）**的向上抽取能力以及**方法重写（Override）**的应用。

### 1. 需求分析与架构设计

在面向对象设计中，当多个类存在重复代码时，我们应将共性内容抽取到父类中。

* **父类 `Employee`（员工类）**：
* **共有属性**：姓名（name）、工号（id）、工资（salary）。
* **共有行为**：工作（work）。


* **子类 `Manager`（项目经理类）**：
* **继承**：`Employee`。
* **特有属性**：奖金（bonus）。
* **行为重写**：定义项目经理具体的工作内容。


* **子类 `Programmer`（程序员类）**：
* **继承**：`Employee`。
* **行为重写**：定义程序员具体的工作内容。



---

### 2. 代码实现

#### 第一步：编写父类 `Employee`

父类中定义共有的私有成员变量，并提供对应的构造器和 Getter/Setter 方法。

```java
public class Employee {
    private String name;
    private String id;
    private double salary;

    public Employee() {}

    public Employee(String name, String id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    // 所有的员工都要工作，但在父类中仅做通用定义
    public void work() {
        System.out.println("员工正在工作...");
    }

    // Getter 和 Setter 方法用于封装数据
    public String getName() { return name; }
    public String getId() { return id; }
    public double getSalary() { return salary; }
}

```

#### 第二步：编写子类 `Manager`

子类使用 `super` 调用父类构造器来初始化从父类继承下来的属性。

```java
public class Manager extends Employee {
    private double bonus; // 经理特有的奖金

    public Manager(String name, String id, double salary, double bonus) {
        // 子类构造器必须首行调用 super(...) 完成父类空间初始化
        super(name, id, salary);
        this.bonus = bonus;
    }

    @Override
    public void work() {
        System.out.println("工号为 " + getId() + " 的项目经理 " + getName() + 
                           " 正在分配任务，并领取奖金：" + bonus);
    }
}

```

#### 第三步：编写子类 `Programmer`

程序员类不需要额外的奖金属性，直接继承并重写方法即可。

```java
public class Programmer extends Employee {

    public Programmer(String name, String id, double salary) {
        super(name, id, salary);
    }

    @Override
    public void work() {
        System.out.println("工号为 " + getId() + " 的程序员 " + getName() + 
                           " 正在埋头写代码，工资为：" + getSalary());
    }
}

```

---

### 3. 编写测试类 `Test`

验证继承关系及多态行为。

```java
public class Test {
    public static void main(String[] args) {
        // 创建项目经理对象
        Manager m = new Manager("张久海", "001", 15000, 5000);
        m.work();

        // 创建程序员对象
        Programmer p = new Programmer("周星驰", "007", 10000);
        p.work();
    }
}

```

---

### 💡 核心逻辑点拨

1. **向上抽取**：将 `name`、`id`、`salary` 放在父类中，避免了在每个子类中重复定义，符合 **DRY (Don't Repeat Yourself)** 原则。
2. **构造器链**：子类构造器默认会调用 `super()`。当父类没有无参构造器时，子类必须显式通过 `super(参数)` 调用父类的有参构造器。
3. **方法重写的意义**：虽然都是 `work`，但经理是“管人”，程序员是“敲码”。重写允许子类在保留父类方法签名的同时，实现自己独特的逻辑。

------

##### 第二题:  编程题

请使用继承定义以下类:

```java
狗(Dog)
  成员变量: 姓名,颜色,价格
  成员方法: 吃饭,看家

猫(Cat)
  成员变量: 姓名,颜色,价格
  成员方法: 吃饭,抓老鼠
```

将狗和猫相同的内容(姓名,颜色,价格,吃饭)抽取到父类Animal中

编写步骤：

1. 定义父类Animal类,添加姓名,年龄,价格成员变量,添加吃饭方法
2. 定义Dog类继承Animal类,添加看家方法
3. 定义Cat类继承Animal类,添加抓老鼠方法
4. 在测试类中，创建Dog对象,并设置成员变量的值,调用Dog对象的eat,lookHome方法.创建Cat对象,并设置成员变量的值,调用Cat对象的eat,catchMouse方法

利用“继承”的思想来完成这个经典的动物案例。通过将共同特征向上抽取到父类中，不仅减少了代码的冗余，也让程序结构更加符合逻辑。

---

## 🐾 案例分析：动物类的继承体系

在 Java 中，当多个类（如猫、狗）拥有相同的属性和行为时，我们可以定义一个 **父类（Animal）** 来存放这些共性内容。子类通过 `extends` 关键字继承父类，从而自动获取父类的非私有成员。

---

## 🛠️ 代码实现

按照你作业中要求的四个步骤，代码实现如下：

### 第一步：定义父类 `Animal`

父类包含了所有动物共有的属性（姓名、年龄、价格）和行为（吃饭）。

```java
// 父类：动物类
public class Animal {
    // 共有属性
    String name;
    int age;
    double price;

    // 共有行为
    public void eat() {
        System.out.println(name + " 正在开心地吃饭 🍚");
    }
}

```

### 第二步 & 第三步：定义子类 `Dog` 与 `Cat`

子类通过继承获得父类的属性，并扩展自己特有的行为。

```java
// 子类：狗类，继承自 Animal
public class Dog extends Animal {
    // 特有行为：看家
    public void lookHome() {
        System.out.println(name + " 正在忠心地看家 🏠");
    }
}

// 子类：猫类，继承自 Animal
public class Cat extends Animal {
    // 特有行为：抓老鼠
    public void catchMouse() {
        System.out.println(name + " 正在敏捷地抓老鼠 🐭");
    }
}

```

### 第四步：编写测试类

在测试类中，我们创建具体对象，并验证继承的效果。

```java
public class Test {
    public static void main(String[] args) {
        // 1. 创建 Dog 对象并操作
        Dog d = new Dog();
        d.name = "旺财"; // 继承自父类
        d.age = 3;      // 继承自父类
        d.price = 500.0; // 继承自父类
        
        System.out.println("----- 狗狗的信息 -----");
        d.eat();        // 调用父类方法
        d.lookHome();   // 调用子类特有方法

        // 2. 创建 Cat 对象并操作
        Cat c = new Cat();
        c.name = "汤姆";
        c.age = 2;
        c.price = 300.0;
        
        System.out.println("\n----- 猫咪的信息 -----");
        c.eat();        // 调用父类方法
        c.catchMouse(); // 调用子类特有方法
    }
}

```

---

## 💡 深度思考：我的理解与建议

1. **关于成员变量的可见性**：
在实际开发中，我们通常不会像上面代码那样直接使用默认访问权限（即不写 `public` 或 `private`）。为了符合封装原则，建议将成员变量设为 `private`，并提供 `getter/setter` 方法。
2. **构造器的利用**：
目前的写法是先 `new` 对象再逐个给属性赋值。更优雅的做法是利用 **`super(...)`** 构造器，在创建对象的一瞬间就完成初始化，这样代码会更加简洁。
3. **继承的“就近原则”**：
如果在 `Dog` 类中也写了一个 `eat()` 方法，那么调用 `d.eat()` 时会执行子类的方法。这就是**方法重写**，它是实现多态的基础。

------

##### 第三题：【拓展题目，选做题，可不做】	分析以下需求，并用代码实现	

	定义银行卡：主卡和副卡类，完成下列功能
	1、完成银行卡-主卡的存取款方法
	  主卡卡有余额，卡号，户主等属性
	  有存款和取款的方法（取款时候余额不足要有提示）
	2、完成银行卡-副卡的取款方法
	  副卡额外有透支额度属性(副卡可用主卡中余额，且余额不够，可以透支额度)
	  副卡重写取款方法（取款时候余额不足要有提示）
	3、写测试案例，分别测试主卡和副卡的存取款功能（存取款后显示余额） 


这是一个关于**面向对象继承（Inheritance）**与**方法重写（Override）**的典型进阶案例。通过这个需求，我们可以深入理解子类如何在继承父类属性的同时，通过重写方法来扩展或修改业务逻辑。

---

## 🏦 银行卡主副卡系统设计思路

在 Java 中，当两个类（主卡与副卡）具有高度重合的属性（卡号、余额）时，应将共性向上抽取。

* **主卡（MainCard）**：作为父类，定义基础的存取款逻辑。
* **副卡（SubCard）**：作为子类，继承主卡的属性，并添加“透支额度”属性。同时，副卡需要重写取款方法，因为它的取款校验逻辑与主卡不同（需计算透支额度）。

---

## 💻 代码实现

### 1. 定义父类：主卡类（MainCard）

主卡类负责管理基础余额和通用的存取款规则。

```java
public class MainCard {
    private String cardId;   // 卡号
    private String owner;    // 户主
    private double balance;  // 余额

    public MainCard() {}

    public MainCard(String cardId, String owner, double balance) {
        this.cardId = cardId;
        this.owner = owner;
        this.balance = balance;
    }

    // 存款方法
    public void deposit(double money) {
        this.balance += money;
        System.out.println(owner + " 成功存入：" + money + " 元，当前余额为：" + this.balance);
    }

    // 取款方法
    public void withdraw(double money) {
        if (this.balance >= money) {
            this.balance -= money;
            System.out.println(owner + " 成功取出：" + money + " 元，剩余余额：" + this.balance);
        } else {
            System.out.println("取款失败！错误提示：主卡余额不足。");
        }
    }

    // Getter & Setter
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance = balance; }
    public String getOwner() { return owner; }
}

```

### 2. 定义子类：副卡类（SubCard）

副卡继承自主卡，并重写了取款逻辑，引入了透支限额（Overdraft Limit）。

```java
public class SubCard extends MainCard {
    private double limit; // 副卡特有的透支额度

    public SubCard(String cardId, String owner, double balance, double limit) {
        // 通过 super 调用父类构造器完成共有属性初始化
        super(cardId, owner, balance);
        this.limit = limit;
    }

    // 重写取款方法
    @Override
    public void withdraw(double money) {
        // 判断逻辑：(当前余额 + 透支额度) 是否足够支付取款金额
        if (getBalance() + limit >= money) {
            // 更新余额（余额可能变为负数，表示已透支）
            double newBalance = getBalance() - money;
            setBalance(newBalance);
            System.out.println("副卡取款成功！取出：" + money + " 元。当前账户余额：" + getBalance());
        } else {
            System.out.println("取款失败！错误提示：已超过透支额度限制。");
        }
    }
}

```

### 3. 测试案例

编写测试类验证主副卡的不同表现。

```java
public class BankTest {
    public static void main(String[] args) {
        // 1. 测试主卡：余额 1000 元
        MainCard mc = new MainCard("622201", "张大主", 1000.0);
        mc.deposit(500);      // 存款 500
        mc.withdraw(2000);    // 尝试取出 2000（应失败）
        mc.withdraw(800);     // 尝试取出 800（应成功）

        System.out.println("--------------------------------");

        // 2. 测试副卡：余额 500 元，透支额度 2000 元
        SubCard sc = new SubCard("622202", "张小副", 500.0, 2000.0);
        sc.withdraw(1000);    // 余额不够但没超透支额度（应成功）
        sc.withdraw(2000);    // 再次尝试取出 2000（此时余额为-500，再取2000超额，应失败）
    }
}

```

---

## 💡 知识点深度解析

1. **super 的妙用**：在 `SubCard` 的构造器中，我们没有手动写 `this.balance = balance`，而是用了 `super(...)`。这是因为父类的属性通常是 `private` 私有的，子类无法直接操作，必须借助父类的构造器来完成初始化。
2. **方法重写的必要性**：主卡和副卡都有“取款”这个动作，但**规则（逻辑）**变了。副卡不需要改名字，只需通过 `@Override` 重新定义内部逻辑，这样在调用时程序会自动执行子类更具体的实现。
3. **封装的体现**：尽管副卡可以透支，但我们依然通过 `getBalance()` 和 `setBalance()` 来操作数据，而不是直接修改父类变量，这保证了数据的安全性。



