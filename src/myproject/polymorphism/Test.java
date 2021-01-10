package myproject.polymorphism;

/**
 * @title: Test
 * @package myproject.polymorphism
 * @description: 这是多态测试类
 * @author: LZY
 * @date: 2020-12-26 14:37
 * @version: V1.0
 */
public class Test {
    public static void main(String[] args) {
        Hero lux = new HeroLux(1, "ElPs", 100, 100);
        Hero lux2 = new HeroLux(1, "PlayerA", 100, 100);
        System.out.println("lux的技能A描述：" + HeroLux.SKILL_A_DESCRIPTION);
        System.out.println(lux.getName() + "的等级：" + lux.getLevel());
        System.out.println(lux2.getName() + "的状态：" + lux2.getStatus());
        System.out.println(lux.getName() + "的魔法值：" + lux.getMp());
        System.out.println(lux2.getName() + "的生命值：" + lux2.getHp());
        lux.levelUp(3);
        System.out.println(lux.getName() + "的等级：" + lux.getLevel());
        lux.skillA(lux2);
        System.out.println(lux.getName() + "的魔法值：" + lux.getMp());
        System.out.println(lux2.getName() + "的生命值：" + lux2.getHp());
        System.out.println(lux2.getName() + "的状态：" + lux2.getStatus());


        System.out.println("lux对象的Unit种类是：" + lux.getKind());
        Creep barron = new CreepBarron(1, "男爵", 2000, 0);
        System.out.println("barron对象的Unit种类是：" + barron.getKind());
        System.out.println(barron.getName() + "的状态：" + barron.getStatus());
        System.out.println(lux2.getName() + "的魔法值：" + lux2.getMp());
        System.out.println(barron.getName() + "的生命值：" + barron.getHp());
        lux2.skillA(barron);
        System.out.println(barron.getName() + "的状态：" + barron.getStatus());
        System.out.println(lux2.getName() + "的魔法值：" + lux2.getMp());
        System.out.println(barron.getName() + "的生命值：" + barron.getHp());

    }
}

