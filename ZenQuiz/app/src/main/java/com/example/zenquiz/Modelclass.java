package com.example.zenquiz;


public class Modelclass {

    String Quetion;
    String oA;
    String oB;
    String oC;
    String oD;
    String ans;
    public Modelclass() {

    }

    public Modelclass(String quetion, String oA, String oB, String oC, String oD, String ans) {
        Quetion = quetion;
        this.oA = oA;
        this.oB = oB;
        this.oC = oC;
        this.oD = oD;
        this.ans = ans;
    }

    public String getQuetion() {
        return Quetion;
    }

    public void setQuetion(String quetion) {
        Quetion = quetion;
    }

    public String getoA() {
        return oA;
    }

    public void setoA(String oA) {
        this.oA = oA;
    }

    public String getoB() {
        return oB;
    }

    public void setoB(String oB) {
        this.oB = oB;
    }

    public String getoC() {
        return oC;
    }

    public void setoC(String oC) {
        this.oC = oC;
    }

    public String getoD() {
        return oD;
    }

    public void setoD(String oD) {
        this.oD = oD;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
}

