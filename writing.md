# T4

## 代码注解

 *测试截图在文末*

### 任务一

实现的接口如下：

```Java

    @GetMapping("/hello")
    public String hello() {
        return "Hello World!";
    }

    @PostMapping("/hello")
    public String helloPost() {
        return "Hello POST World";
    }

    @GetMapping("/hello/json")
    public Map<String, String> helloJson() {
        return Map.of("get", "Hello World!", "post", "Hello POST World!");
    }

    @PostMapping("/hello/json")
    public Map<String, String> helloJsonPost() {
        return Map.of("get", "Hello World!", "post", "Hello POST World!");
    }

```

第一二部分实现的是通过`/hello`路径的接口，当用`GET`和`POST`方法交互时，分别输出对应的语句；

第三四部分实现的是通过`/hello/json`路径的接口，用同上的两种方法交互时输出`JSON`类型的数据，由于题目要求同时输出两条语句，因此分别将get和post对应上相应的输出语句。

### 任务二

实现的接口如下：

```Java


    @GetMapping("/hello/name")
    public String helloName(@RequestParam("name") String name) {
        return "Hello," + name + "!";
    }

    @PostMapping("/hello/name")
    public String helloNamePost(@RequestParam("name") String name) {
        return "Hello," + name + "!";
    }

    @PostMapping("/hello/name/json")
    public String helloNameJson(@RequestBody Map<String,String> name) {
        return "Hello," + name.get("name") + "!";
    }
```

前两部分实现的是通过`/hello/name`路径的接口，传入`name`参数时，能输出对应的欢迎信息。

最后一部分实现的是通过`hello/name/json`路径的接口，传入`json`请求体时，能提取出`name`键及其对应的值，并输出对应的欢迎信息。

### 任务三

1. Spring做了什么？
   简单来说，Spring框架为我们提供了一个现成、高效的程序框架，它可以实现客户端与服务器建立联系、交互、接收信息和返回信息等的过程。
   如果没有Spring，这个程序要怎么写？
   如果没有`Spring MVC`这种框架，以及`Tomcat`之类的工具，我们必须从头开始自己写一个与客户端交互的逻辑，包括用`ServerSocket`监听端口、用`Socket`建立联系、接收并处理发送来的请求内容，判断是否有对应实现方法，相应的还要写报错的逻辑，或是自行构建返回信息的结构（响应头和响应体）。
   而我们自己写出来的，往往也不能做到十分的准确与高效。所以，一旦我们把这些都交给Spring处理，我们只负责交给它业务逻辑，不仅效率提升了，也能提升代码的可读性，让我们专注于我们负责的业务逻辑部分。
2. 什么是IoC？
   控制反转(Inversion of Control)，顾名思义，就是将程序的控制权进行“反转”：原本程序运行时，控制权在我们手中，而现在控制权转交给了Spring框架或容器，这里的控制权是一个总称，其内涵包括创建对象、方法传参、调用顺序等等。
   什么是DI？
   依赖注入(Dependency Injection)，可以说是IoC的一种落地方式。
   在我的这个实现接口的程序中，我将我写好的用于实现业务逻辑的代码交给Spring框架后，拿到控制权的框架便也拿到了创建对象、调用方法等的权力。当我需要某个对象来调用某些方法时，有时我并不需要手动去实例化对象，而是我只需要告诉框架我需要它，框架便会自行为我创建这个对象。
   在我的程序中举个例子，当程序开始运行，显然我只创建了`HelloController`这个类，而没有实例化一个对象。那么它的方法是如何被调用的呢，正是被赋予控制权的Spring框架或容器创建了一个对象，从而调用了这些客户端与服务器交互的方法。而如果我的这个类中还有别的元素，导致存在新的依赖关系，则当我们实例化这个类时也可以无需手动使用new关键字创建其依赖的类的实例化对象。
3. 后端开发的基本流程是什么？
   在我看来，后端开发主要分为以下几个阶段：

   - 设计项目：规定好接口的交互方式和，规定好如何与前端交互、如何与数据库交互、设计好实现需求的逻辑等；
   - 配置环境，编写代码：根据设计好的逻辑，下载或启用所需的数据和框架，编写代码实现业务逻辑；
   - 本地测试：在本地测试程序是否存在隐性问题，以及测试程序性能；
   - 启动服务器：将打包好的程序上传至服务端，启动程序，开始web信息传输，开始对用户请求进行回复，提供服务；
   - 后续的维护。

   从我写下一个方法，到别人能用浏览器访问它，中间经历了哪些环节？

   其中大致经历以下环节：

   - 我写下方法后，将这段代码交给Spring框架，让它将其放入框架中适当的位置；
   - 启动服务器后，web数据传输启动，服务器监听端口8080；
   - 用户通过规定好的方式（包括特定的URL、访问方法）访问方法对应的接口，向服务器发送请求；
   - Tomcat服务器接收并处理请求，Spring框架匹配对应的接口；
   - 框架根据需要自行决定是否创建需要的对象，调用相应的方法；
   - Spring框架处理该方法对应的返回值，并编辑HTTP返回信息，返回给客户端。

### 测试截图

curl命令行和Postman工具混着用了，证明两种测试工具我都会

接口一
![屏幕截图 2026-10-22 225144.png · 10](https://img.cdn1.vip/i/6ada2343c7f71_1792680771.png)
接口二
![屏幕截图 2026-10-22 225133.png · 11](https://img.cdn1.vip/i/6ada2344051c9_1792680772.png)
接口三（接口四类似）
![屏幕截图 2026-10-22 224509.png · 152](https://img.cdn1.vip/i/6ada234491bb7_1792680772.webp)
接口五、六
![屏幕截图 2026-10-22 225153.png · 24](https://img.cdn1.vip/i/6ada2343c89dc_1792680771.png)
接口七
![屏幕截图 2026-10-22 225059.png · 148](https://img.cdn1.vip/i/6ada2344f0421_1792680772.webp)