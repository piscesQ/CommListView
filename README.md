# CommListView
a common ListView
### TODO List

v1.0 实现基本功能 <br/>
v2.0 增加自定义Gson解析 <br/>
v3.0 增加网络框架 rxJava + okHttp <br/>
``` 
参考链接： http://tech.youzan.com/android_http/ 
```
|-- v3.1 git pull 和 git fetch 试验 <br/>

v4.0 日志统计 bug 统计框架（面向切面） <br/>
|-- Dexposed 等面向切面的框架



### 目录结构
```
|-- activity            应用交互页面
|-- aop                 面向切面编程(已删除，改成library实现)
|-- base 
|-- commlist            统一列表
|-- gson                自定义Gson解析
|-- net                 网络框架封装
|-- rxjava              rxjava测试
|-- test
|-- utils               工具类
|-- MainApplication     自定义Application类

```

### Charles 配置
1、在`res`目录下增加`xml`目录，并添加文件：`network_security_config.xml` <br/>
2、在AndroidManifest.xml文件中的application标签下增加属性`android:networkSecurityConfig="@xml/network_security_config"` <br/>

**注意：**该方法只需要在sdk版本大于等于24才需要配置， 低版本没有`android:networkSecurityConfig="@xml/network_security_config"`属性 <br/>

### 网络框架
具体参见对应包中的文档

### AspectJ 配置
1、Android 中的 AOP 编程 - github：`https://github.com/hehonghui/android-tech-frontier/blob/master/issue-22/Android%E4%B8%AD%E7%9A%84AOP%E7%BC%96%E7%A8%8B.md` <br/>
2、Android 基于AOP监控之——AspectJ构建指南 ： `https://yq.aliyun.com/articles/58739` <br/>
**注意：** 1、不支持Jack工具链！！！！！！ <br/>

##### AspectJ 教程
1、看AspectJ在Android中的强势插入：`http://blog.csdn.net/eclipsexys/article/details/54425414` <br/>
2、深入理解Android之AOP：`http://blog.csdn.net/innost/article/details/49387395` <br/>
3、：`` <br/>
4、：`` <br/>

**参考链接：** <br/>
|- `http://www.eclipse.org/aspectj/`   <=AspectJ官方网站 <br/>
|- `http://www.eclipse.org/aspectj/doc/released/runtime-api/index.html`  <=AspectJ类库参考文档，内容非常少 <br/>
|- `http://www.eclipse.org/aspectj/doc/released/aspectj5rt-api/index.html`  <=@AspectJ文档，以后我们用Annotation的方式最多 <br/>


### 常见问题
1、sdk版本调整，同时也需要调整依赖中的`appcompat-v7`，`design`等包的版本，尽量和sdk版本保持一致





### 参考链接
1、Android 利用Gradle实现app的环境分离：`http://yifeng.studio/2016/09/06/apk-environment-separate/`
2、事件总线 —— otto的bus和eventbus对比分析：`http://frodoking.github.io/2015/03/30/android-eventbus-otto-analysis/`
3、RxBus真的能替代EventBus吗？：`http://www.jianshu.com/p/669eda5dc5a4`
4、有赞Android客户端网络架构演进：`http://tech.youzan.com/android_http/`
5、！Retrofit+RxJava最佳封装使用：`http://www.jianshu.com/p/566912926427`
6、四种常见的 POST 提交数据方式：`https://imququ.com/post/four-ways-to-post-data-in-http.html`
7、Android 技术选型(持续更新中...)：`https://juejin.im/post/58f61bb55c497d006ca294bb`
8、Java泛型详解：`http://www.jianshu.com/p/c8ee2cfa5b33`