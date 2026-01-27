package com.siemonsele.d1_innerclass1;

public class People {
    private int heartBeat = 110;
    //成员内部类
    public class Heart{
        private int heartBeat = 89;

        public void show(){
            int heartBeat = 65;
            System.out.println(heartBeat); //65
            System.out.println(this.heartBeat); //89
            System.out.println(People.this.heartBeat); //110
        }
    }
}
