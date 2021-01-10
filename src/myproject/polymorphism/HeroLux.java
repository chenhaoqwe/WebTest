/**
 * projectName: WebTest
 * fileName: HeroLux.java
 * packageName: myproject.polymorphism
 * date: 2020-12-26 15:56
 * copyright(c) 2017-2020 xxx公司
 */
package myproject.polymorphism;

/**
 * @title: HeroLux
 * @package myproject.polymorphism
 * @description: 这是HeroLux类，继承了抽象类Hero
 * @author: LZY
 * @date: 2020-12-26 15:06
 * @version: V1.0
 */
public class HeroLux extends Hero {
    /**
     * HERO_LUX_CODENAME HeroLux的编号名
     */
    private static final String HERO_LUX_CODENAME = "hero_lux";
    /**
     * SKILL_A_DAMAGE 技能A伤害
     */
    private static final int SKILL_A_DAMAGE = 20;
    /**
     * SKILL_A_MP_CONSUME 技能A耗蓝
     */
    private static final int SKILL_A_MP_CONSUME = 15;
    /**
     * SKILL_A_DAMAGE 技能A对目标施加的debuff种类
     */
    private static final String SKILL_A_DEBUFF_TO_TARGET = "禁锢";
    /**
     * SKILL_A_DESCRIPTION 技能A描述
     */
    public static final String SKILL_A_DESCRIPTION = "光之束缚,消耗15魔法值,对一名敌人造成20伤害,并施加禁锢debuff";

    /**
     * 无参构造函数
     */
    public HeroLux() {
        super();
    }

    /**
     * 有参构造函数
     * HeroLux默认状态为正常
     *
     * @param level 等级
     * @param name  名称
     * @param hp    血量
     * @param mp    魔法值
     */
    public HeroLux(int level, String name, int hp, int mp) {
        super(HERO_LUX_CODENAME, level, name, hp, mp, "正常");
    }

    @Override
    public void skillA(Unit heroB) {
        heroB.setHp(heroB.getHp() - SKILL_A_DAMAGE);
        this.setMp(this.getMp() - SKILL_A_MP_CONSUME);
        heroB.setStatus(SKILL_A_DEBUFF_TO_TARGET);
        StringBuilder sb = new StringBuilder();
        sb.append(this.getName() + " (" + this.getCodeName() + ") " + "使用了光之束缚,");
        sb.append("对" + heroB.getName() + " (" + this.getCodeName() + ") " + "造成了" + SKILL_A_DAMAGE + "点伤害,");
        sb.append("并对其施加了" + SKILL_A_DEBUFF_TO_TARGET + "状态");
        System.out.println(sb.toString());
    }


}
