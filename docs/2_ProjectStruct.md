#工程结构
###app模块结构
```
|-- adapter : ListView的适配器
|-- bean : 实体类
|-- render : 渲染类，承担了Adapter中getView方法的部分工作，根据ItemViewType来区分
|-- utils : 工具类，存放一些常量和工具方法
```

###commlistviewlib模块结构
```
|-- adapter : ListView的顶层适配器;
    |-- BaseListAdapter : ListView的Adapter需要继承此类；
|-- bean
    |-- BaseListBean : 顶层实体类，所有的实体需要继承此类；
|-- render
    |-- BaseListRender : 顶层渲染类，所有的实体需要继承此类；
|-- view
    |-- CommListView : 封装的ListView； 
```