package com.siemonsele.d12_estends_override;

public class Tiger extends  Animal{
    //方法重写：名称和参数列表必须与父类被重写的方法一样
    @Override //重写的校验注解：安全 优雅 可读性好
    public  void run(){
        System.out.println("老虎在跑");
    }
}
