#使用手册
###步骤
1、使用样例如`app`module下的结构即可，可以参考已经内置的类型。
2、如果增加新的样式，则需要在`app/bean`下增加实体类；在`app/render`下增加渲染类;并增加对应的布局文件；
3、修改`app/utils`下的`ItemViewType`文件，增加枚举类型；修改`ListConstant`中与服务端约定的类型；
4、修改`app/utils`下的`ListUtils`文件，增加返回的type和render类型
5、综上，共增加3个文件（bean、render、layout），修改`app/utils`下的3个文件；