# 网络框架教程
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
