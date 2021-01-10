/**
 * projectName: WebTest
 * fileName: Creep.java
 * packageName: myproject.polymorphism
 * date: 2020-12-26 16:36
 * copyright(c) 2017-2020 xxx公司
 */
package myproject.polymorphism;

/**
 * @version: V1.0
 * @author: LZY
 * @className: Creep
 * @packageName: myproject.polymorphism
 * @description: 这是怪物抽象类，继承了单位抽象类
 * @data: 2020-12-26 16:36
 **/
public class Creep extends Unit {
    /**
     * CREEP_KIND 怪物类的种类名
     */
    private static final String CREEP_KIND = "creep";

    /**
     * 无参构造函数
     */
    public Creep() {
        super();
    }

    /**
     * 有参构造函数
     *
     * @param codeName 编号名
     * @param level    等级
     * @param name     名称
     * @param hp       血量
     * @param mp       魔法值
     */
    public Creep(String codeName, int level, String name, int hp, int mp, String status) {
        super(CREEP_KIND, codeName, level, name, hp, mp, status);
    }
}