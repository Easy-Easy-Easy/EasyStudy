#静态代理与动态代理学习
##静态代理
1.既然是代理,自然要传入要代理的类,即目标类
2.代理类实现 接口,调用方法即可.(加入其它内容)

##动态代理
1.同静态代理,要使用代理,同样要传入代理类
2.代理类实现InvocationHandler 接口,重写invoke 方法
3.调用Proxy.nerInstance 方法,传入类加载器,interface ,invocationHandler对象,
就能获取到代理类,然后调用对应的方法即可