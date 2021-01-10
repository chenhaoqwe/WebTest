/**
 * projectName: WebTest
 * fileName: Unit.java
 * packageName: myproject.polymorphism
 * date: 2020-12-26 15:56
 * copyright(c) 2017-2020 xxx公司
 */
package myproject.polymorphism;

/**
 * @title: Unit
 * @package myproject.polymorphism
 * @description: 这是单位抽象类
 * 单位具有编号名，等级,生命值，魔法值属性
 * @author: LZY
 * @date: 2020-12-26 15:05
 * @version: V1.0
 */
public abstract class Unit {
    /**
     * 种类
     */
    private String kind;
    /**
     * 编号名
     */
    private String codeName;
    /**
     * 名称
     */
    private String name;
    /**
     * 等级
     */
    private int level;
    /**
     * 生命值
     */
    private int hp;
    /**
     * 魔法值
     */
    private int mp;
    /**
     * 状态
     */
    private String status;

    /**
     * 无参构造函数
     */
    public Unit() {
        this.kind = null;
        this.codeName = null;
        this.level = 0;
        this.name = null;
        this.hp = 0;
        this.mp = 0;
        this.status = null;
    }

    /**
     * 有参构造函数
     *
     * @param kind     种类
     * @param codeName 编号名
     * @param level    等级
     * @param name     名称
     * @param hp       血量
     * @param mp       魔法值
     * @param status   状态
     */
    public Unit(String kind, String codeName, int level, String name, int hp, int mp, String status) {
        this.kind = kind;
        this.codeName = codeName;
        this.level = level;
        this.name = name;
        this.hp = hp;
        this.mp = mp;
        this.status = status;
    }

    /**
     * 升级level个等级
     *
     * @param level 升级的级数
     */
    public final void levelUp(int level) {
        this.setLevel(this.getLevel() + level);
        System.out.println(this.getName() + " (" + this.getCodeName() + ") 升级了" + level + "级");
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCodeName() {
        return codeName;
    }

    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
