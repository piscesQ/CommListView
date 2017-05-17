# 网络框架教程

### 目录结构说明
```
|-- net
    |-- bean  存放使用到的bean
    |-- frame   封装的网络框架 - 该包除了工具类以外与其他类无耦合（重要）
        |-- bean  存放使用到的bean
            |-- BaikeGetRequest  测试类 - get请求测试
            |-- BaseHttpResponse 基类 - 所有Response都需要继承该类
            |-- TreePostRequest  测试类 - post请求测试
        |-- transformer 存放rxjava 的transformer 用来做数据的预处理
        |-- Http 核心类，Http代理层，屏蔽底层实现细节   使用到了StringTransformer做数据的预处理！！
        |-- HttpUtils 工具类，存放Http使用的相关环境等方法
    |-- okhttp  测试 - 测试okhttp
    |-- retrofit  测试 - 测试retrofit
 ```
 
 结论 ： frame 包下的代码是封装后的结果，可以直接拿来使用或参考实现自己的逻辑！！！
 
### 参考链接
1、OkHttp使用教程`http://www.jcodecraeer.com/a/anzhuokaifa/androidkaifa/2015/0106/2275.html`
2、OkHttp超时捕获：`http://blog.csdn.net/do168/article/details/51848895`
3、网络缓存：`http://www.jianshu.com/p/9c3b4ea108a7`
4、 OKHttp3.0的日常及入门：`http://blog.csdn.net/biezhihua/article/details/50603624`
5、Okhttp3.2取消请求：`http://www.zhimengzhe.com/Androidkaifa/47258.html`
```
for(Call call : client.dispatcher().queuedCalls()) {
    if(call.request().tag().equals(tag))
       call.cancel();
}
for(Call call : client.dispatcher().runningCalls()) {
    if(call.request().tag().equals(tag))
       call.cancel();
}
```
6、OkHttp3源码分析[缓存策略]：`http://www.jianshu.com/p/9cebbbd0eeab`
