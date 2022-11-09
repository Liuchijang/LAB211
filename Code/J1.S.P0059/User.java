/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package J1.S.P0059;

/**
 *
 * @author E5450
 */
public class User {
    private String name;
    private String addr;
    private double money;

    public User() {
    }

    public User(String name, String addr, double money) {
        this.name = name;
        this.addr = addr;
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return name + ';' + addr + ';' + money;
    }
       
}
