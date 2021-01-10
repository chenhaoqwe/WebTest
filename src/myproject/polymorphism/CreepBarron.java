/**
 * projectName: WebTest
 * fileName: CreepBarron.java
 * packageName: myproject.polymorphism
 * date: 2020-12-26 16:44
 * copyright(c) 2017-2020 xxx公司
 */
package myproject.polymorphism;

/**
 * @version: V1.0
 * @author: LZY
 * @className: CreepBarron
 * @packageName: myproject.polymorphism
 * @description: 这是CreepBarron类，继承了抽象类Creep
 * @data: 2020-12-26 16:44
 **/
public class CreepBarron extends Creep {
    /**
     * CREEP_BARRON_CODENAME CreepBarron的编号名
     */
    private static final String CREEP_BARRON_CODENAME = "creep_barron";

    /**
     * 无参构造函数
     */
    public CreepBarron() {
        super();
    }

    /**
     * 有参构造函数
     * CreepBarron默认状态为正常
     *
     * @param level 等级
     * @param name  名称
     * @param hp    血量
     * @param mp    魔法值
     */
    public CreepBarron(int level, String name, int hp, int mp) {
        super(CREEP_BARRON_CODENAME, level, name, hp, mp, "正常");
    }
}