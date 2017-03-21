#如何导入AS
###步骤
1、修改工程下的 build.gradle 中的 `com.android.tools.build:gradle:`后面的版本号<br/>
2、修改模块app目录下的 build.gradle 中的`buildToolsVersion`的版本
3、修改工程下gradle/wrapper/gradle-wrapper.properties中的gradle的版本

**注意**<br/>
1、修改过`buildToolsVersion`的版本后，需要重启AS，然后再编译
2、注意工程下的build.gradle中是否有依赖内网中的maven仓库
3、需要注意当前AS版本支持的最低的`gradle`版本和最低的`buildToolsVersion`版本