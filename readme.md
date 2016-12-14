

# java8新特性学习

**```[author]```** 邱俊

1. 允许在接口中有默认方法实现
2. Lambda表达式
3. 函数式接口
4. 方法和构造函数引用
5. Lambda的范围
6. 内置函数式接口
7. Streams
8. Parallel Streams
9. Map
10. Annotations
11. 总结

# 概述

###### 通过简单明了的代码示例，你将会学习到如何使用默认接口方法，Lambda表达式，方法引用和重复注解。看完这篇教程后，你还将对最新推出的API有一定的了解，例如：流控制，函数式接口，map扩展等等。


# 新特性介绍

### 1. 允许在接口中有默认方法实现

Java 8 允许我们使用default关键字，为接口声明添加非抽象的方法实现。这个特性又被称为扩展方法。下面是我们的第一个例子:

```java
interface Formula {  
    double calculate(int a);  
   
    default double sqrt(int a) {  
        return Math.sqrt(a);  
    }  
}  
```
在接口Formula中，除了抽象方法caculate以外，还定义了一个默认方法sqrt。Formula的实现类只需要实现抽象方法caculate就可以了。默认方法sqrt可以直接使用。 

```java
Formula formula = new Formula() {  
    @Override  
    public double calculate(int a) {  
        return sqrt(a * 100);  
    }  
};  
   
formula.calculate(100);     // 100.0  
formula.sqrt(16);           // 4.0  
```

formula对象以匿名对象的形式实现了Formula接口。代码很啰嗦：用了6行代码才实现了一个简单的计算功能：a*100开平方根。我们在下一节会看到，Java 8 还有一种更加优美的方法，能够实现包含单个函数的对象。

### 2. Lambda表达式

让我们从最简单的例子开始，来学习如何对一个string列表进行排序。我们首先使用Java 8之前的方法来实现：

```java
List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");  
   
Collections.sort(names, new Comparator<String>() {  
    @Override  
    public int compare(String a, String b) {  
        return b.compareTo(a);  
    }  
});  
```

静态工具方法Collections.sort接受一个list，和一个Comparator接口作为输入参数，Comparator的实现类可以对输入的list中的元素进行比较。通常情况下，你可以直接用创建匿名Comparator对象，并把它作为参数传递给sort方法。 

除了创建匿名对象以外，Java 8 还提供了一种更简洁的方式，Lambda表达式。

```java
Collections.sort(names, (String a, String b) -> {  
    return b.compareTo(a);  
});  
```

你可以看到，这段代码就比之前的更加简短和易读。但是，它还可以更加简短： 

```java
Collections.sort(names, (String a, String b) -> b.compareTo(a));  
```

只要一行代码，包含了方法体。你甚至可以连大括号对{}和return关键字都省略不要。不过这还不是最短的写法：

```java
Collections.sort(names, (a, b) -> b.compareTo(a));  
```

Java编译器能够自动识别参数的类型，所以你就可以省略掉类型不写。

### 3. 函数式接口

Lambda表达式如何匹配Java的类型系统？每一个lambda都能够通过一个特定的接口，与一个给定的类型进行匹配。一个所谓的函数式接口必须要有且仅有一个抽象方法声明。每个与之对应的lambda表达式必须要与抽象方法的声明相匹配。由于默认方法不是抽象的，因此你可以在你的函数式接口里任意添加默认方法。 

任意只包含一个抽象方法的接口，我们都可以用来做成lambda表达式。为了让你定义的接口满足要求，你应当在接口前加上@FunctionalInterface 标注。编译器会注意到这个标注，如果你的接口中定义了第二个抽象方法的话，编译器会抛出异常。 

举例： 

```java
@FunctionalInterface  
interface Converter<F, T> {  
    T convert(F from);  
}  
   
Converter<String, Integer> converter = (from) -> Integer.valueOf(from);  
Integer converted = converter.convert("123");  
System.out.println(converted);    // 123  
```

注意，如果你不写@FunctionalInterface 标注，程序也是正确的。

上面的代码实例可以通过静态方法引用，使之更加简洁： 

```java
Converter<String, Integer> converter = Integer::valueOf;  
Integer converted = converter.convert("123");  
System.out.println(converted);   // 123  
```

Java 8 允许你通过::关键字获取方法或者构造函数的的引用。上面的例子就演示了如何引用一个静态方法。而且，我们还可以对一个对象的方法进行引用：

```java
class Something {  
    String startsWith(String s) {  
        return String.valueOf(s.charAt(0));  
    }  
}  
   
Something something = new Something();  
Converter<String, String> converter = something::startsWith;  
String converted = converter.convert("Java");  
System.out.println(converted);    // "J"  
```

让我们看看如何使用::关键字引用构造函数。首先我们定义一个示例bean，包含不同的构造方法：

```java
class Person {  
    String firstName;  
    String lastName;  
   
    Person() {}  
   
    Person(String firstName, String lastName) {  
        this.firstName = firstName;  
        this.lastName = lastName;  
    }  
}  
```

然后我们通过构造函数引用来把所有东西拼到一起，而不是像以前一样，通过手动实现一个工厂来这么做。

```java
PersonFactory<Person> personFactory = Person::new;  
Person person = personFactory.create("Peter", "Parker");  
```

我们通过Person::new来创建一个Person类构造函数的引用。Java编译器会自动地选择合适的构造函数来匹配PersonFactory.create函数的签名，并选择正确的构造函数形式。 

### **```Lambda的范围```**

对于lambdab表达式外部的变量，其访问权限的粒度与匿名对象的方式非常类似。你能够访问局部对应的外部区域的局部final变量，以及成员变量和静态变量。 

**访问局部变量** 

我们可以访问lambda表达式外部的final局部变量：

```java
final int num = 1;  
Converter<Integer, String> stringConverter =  
        (from) -> String.valueOf(from + num);  
   
stringConverter.convert(2);     // 3  
```

但是与匿名对象不同的是，变量num并不需要一定是final。下面的代码依然是合法的： 

```java
int num = 1;  
Converter<Integer, String> stringConverter =  
        (from) -> String.valueOf(from + num);  
   
stringConverter.convert(2);     // 3  
```

然而，num在编译的时候被隐式地当做final变量来处理。下面的代码就不合法：

```java
int num = 1;  
Converter<Integer, String> stringConverter =  
        (from) -> String.valueOf(from + num);  
num = 3;  //编译报错
```

在lambda表达式内部企图改变num的值也是不允许的。 

**```访问成员变量和静态变量```**

与局部变量不同，我们在lambda表达式的内部能获取到对成员变量或静态变量的读写权。这种访问行为在匿名对象里是非常典型的。 

```java
class Lambda4 {  
    static int outerStaticNum;  
    int outerNum;  
   
    void testScopes() {  
        Converter<Integer, String> stringConverter1 = (from) -> {  
            outerNum = 23;  
            return String.valueOf(from);  
        };  
   
        Converter<Integer, String> stringConverter2 = (from) -> {  
            outerStaticNum = 72;  
            return String.valueOf(from);  
        };  
    }  
}  
```

### 内置函数式接口

JDK 1.8 API中包含了很多内置的函数式接口。有些是在以前版本的Java中大家耳熟能详的，例如Comparator接口，或者Runnable接口。对这些现成的接口进行实现，可以通过@FunctionalInterface 标注来启用Lambda功能支持。 

此外，Java 8 API 还提供了很多新的函数式接口，来降低程序员的工作负担。有些新的接口已经在[Google Guava](https://code.google.com/p/guava-libraries/)库中很有名了。如果你对这些库很熟的话，你甚至闭上眼睛都能够想到，这些接口在类库的实现过程中起了多么大的作用。 

**Predicates** 

Predicate是一个布尔类型的函数，该函数只有一个输入参数。Predicate接口包含了多种默认方法，用于处理复杂的逻辑动词（and, or，negate）： 

```java
Predicate<String> predicate = (s) -> s.length() > 0;  
   
predicate.test("foo");              // true  
predicate.negate().test("foo");     // false  
   
Predicate<Boolean> nonNull = Objects::nonNull;  
Predicate<Boolean> isNull = Objects::isNull;  
   
Predicate<String> isEmpty = String::isEmpty;  
Predicate<String> isNotEmpty = isEmpty.negate(); 
```




