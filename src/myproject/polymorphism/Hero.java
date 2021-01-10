/**
 * projectName: WebTest
 * fileName: Hero.java
 * packageName: myproject.polymorphism
 * date: 2020-12-26 15:56
 * copyright(c) 2017-2020 xxx公司
 */
package myproject.polymorphism;

/**
 * @title: Hero
 * @package myproject.polymorphism
 * @description: 这是英雄抽象类，继承了单位抽象类
 * 英雄具有Unit属性之外，还具有skillA
 * @author: LZY
 * @date: 2020-12-26 15:06
 * @version: V1.0
 */

public abstract class Hero extends Unit {
    /**
     * HERO_KIND 英雄类的种类名
     */
    private static final String HERO_KIND = "hero";
    /**
     * 技能A描述
     */
    private static String SKILL_A_DESCRIPTION;

    /**
     * 技能A
     *
     * @param unitB 技能A施放对象目标B
     */
    public abstract void skillA(Unit unitB);
//
//    /**
//     * 技能B描述
//     */
//    private static String SKILL_B_DESCRIPTION;
//
//    /**
//     * 技能B
//     *
//     * @param unitB 技能B施放对象目标B
//     */
//    public abstract void skillB(Unit unitB);
//    /**
//     * 技能C描述
//     */
//    private static String SKILL_C_DESCRIPTION;
//
//    /**
//     * 技能C
//     *
//     * @param unitB 技能C施放对象目标B
//     */
//    public abstract void skillC(Unit unitB);
//    /**
//     * 技能D描述
//     */
//    private static String SKILL_D_DESCRIPTION;
//
//    /**
//     * 技能D
//     *
//     * @param unitB 技能D施放对象目标B
//     */
//    public abstract void skillD(Unit unitB);

    /**
     * 无参构造函数
     */
    public Hero() {
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
     * @param status   状态
     */
    public Hero(String codeName, int level, String name, int hp, int mp, String status) {
        super(HERO_KIND, codeName, level, name, hp, mp, status);
    }

}
