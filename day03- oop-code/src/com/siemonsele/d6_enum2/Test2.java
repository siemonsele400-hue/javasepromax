package com.siemonsele.d6_enum2;

public class Test2 {
    public static void main(String[] args) {
        //目标：搞清楚枚举的应用场景：信息标志和信息分类
        //需求：需要你提供一个方法，可以完成向下取整，向上取整，四舍五入，去掉小数部分
        //常量做信息标志和分类：也很优雅，但是参数值不被约束！！
        System.out.println(handleDate(3.654, Constant2.DOWN));
        System.out.println(handleDate(3.654, Constant2.UP));
        System.out.println(handleDate(3.654, Constant2.HALF_UP));
        System.out.println(handleDate(3.654, Constant2.DELETE_LEFT));
    }

    public static double handleDate(double number , Constant2 flag){
        switch (flag){
            case DOWN:
                //向下取整
                number = Math.floor(number);
                break;
            case UP:
                //向上取整
                number = Math.ceil(number);
                break;
            case HALF_UP:
                //四舍五入
                number = Math.round(number);
                break;
            case DELETE_LEFT:
                //去掉小数部分
                number = (int)number;
                break;
        }
        return number;
    }
}
