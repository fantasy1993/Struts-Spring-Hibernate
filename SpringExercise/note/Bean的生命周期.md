##Bean的生命周期

###初始化

1. 实现org.springframework.beans.factory.InitializingBean接口，覆盖afterPropertiesSet方法

2. 配置<bean >中属性init-method方法

###销毁

1. 实现org.springframework.beans.factory.DisposableBean接口，覆盖destory方法

2. 配置<bean >中属性destory-method方法

###配置初始化和销毁方法的三种形式

1. 通过配置全局默认的初始化、销毁方法:在<beans>标签中设置属性default-init-method和default-destory-method方法

2. 设置<bean>标签的init-method和destory-method属性

3. 实现org.springframework.beans.factory.InitializingBean和org.springframework.beans.factory.DisposableBean接口，重写afterPropertiesSet和destory方法

**Bean的初始化和销毁过程使用到的3中方式结合时需注意：**

 - 在<beans ……>中设置属性default-init-method和default-destory-method方法为可选方法，实际中使用的Bean可以没有这两个方法，但是在<bean ……>中设置的 init-method 和 destory-method 方法在Bean中必须存在，若不存在则会抛出异常

 - 当在<bean ……>中设置的 init-method 和 destory-method 方法时，在<beans ……>中设置的default-init-method和default-destory-method方法会失效
 
 - 如果三种方式同时存在,有第二点可以看出default...属性会失效，则会有同时有两个init和destory方法被执行（implments 和 init-method中设置的方法），并且继承后覆盖的方法先与init-method属性设置的方法执行

