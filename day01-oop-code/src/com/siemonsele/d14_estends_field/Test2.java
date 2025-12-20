package com.siemonsele.d14_estends_field;

public class Test2 {
    public static void main(String[] args) {
        //目标：继承后，子类访问成员的特点：就近原则
        zi2 z = new zi2();
        z.run();
        z.go();

    }
}

    class zi2 extends fu2 {
        @Override
        public void run() {
            System.out.println("zileipao");
        }

        public void go() {
            run();//zileipao
            super.run();//fuleipao
        }
    }


    class fu2 {
        public void run() {
            System.out.println("fuleipao");
        }
    }

