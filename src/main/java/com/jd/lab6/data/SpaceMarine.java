package com.jd.lab6.data;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Stack;

/**
 * @author Пименов Данила, P3130
 * Класс, описывающий модель космического корабля
 * Содержит переопределённую логику toString, hasCode, equals, а также набор станадратных геттеров и сеттеров.
 * Реализует интерфейс Comparable.
 */
public class SpaceMarine implements Comparable<SpaceMarine> {
    private Long id;
    private String name;
    private com.jd.lab6.data.Coordinates coordinates;
    private LocalDate creationDate;
    private Double health;
    private long heartCount;
    private boolean loyal;
    private com.jd.lab6.data.MeleeWeapon meleeWeapon;
    private com.jd.lab6.data.Chapter chapter;
    private static Stack<Long> idStack;

    /**
     * Пустой констурктор. Используется SuperCSV.
     */
    public SpaceMarine() {
    }

    /**
     * Конструктор
     * @param name - имя корабля
     * @param coordinates - объект координат
     * @param health - количество здорвоья
     * @param heartCount - количество жизней
     * @param loyal - лояльность
     * @param meleeWeapon - оружие
     * @param chapter - часть
     */
    public SpaceMarine(String name, Coordinates coordinates, Double health, long heartCount, boolean loyal, MeleeWeapon meleeWeapon, Chapter chapter) {
        if (idStack == null)
            initIdStack();
        int i = 0;
        while (idStack.contains(idStack.lastElement() + i))
            i++;
        this.id = idStack.lastElement() + i;
        idStack.push(this.id);
        this.name = name;
        this.coordinates = coordinates;
        this.creationDate = LocalDate.now();
        this.health = health;
        this.heartCount = heartCount;
        this.loyal = loyal;
        this.meleeWeapon = meleeWeapon;
        this.chapter = chapter;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        if (idStack == null)
            initIdStack();
        if (!idStack.contains(id)) {
            this.id = id;
            idStack.push(id);
        } else {
            this.id = idStack.lastElement() + 1;
            idStack.push(this.id);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setCoordinatesX(Long coordinates) {
        this.coordinates.setX(coordinates);
    }

    public void setCoordinatesY(Float coordinates) {
        this.coordinates.setY(coordinates);
    }

    public Date getCreationDate() {
        return Date.from(creationDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = new java.sql.Date(creationDate.getTime()).toLocalDate();
    }

    public void setCreationDateAuto() {
        this.creationDate = LocalDate.now();
    }

    public Double getHealth() {
        return health;
    }

    public void setHealth(Double health) {
        this.health = health;
    }

    public long getHeartCount() {
        return heartCount;
    }

    public void setHeartCount(long heartCount) {
        this.heartCount = heartCount;
    }

    public boolean isLoyal() {
        return loyal;
    }

    public void setLoyal(boolean loyal) {
        this.loyal = loyal;
    }

    public MeleeWeapon getMeleeWeapon() {
        return meleeWeapon;
    }

    public void setMeleeWeapon(String meleeWeapon) {
        this.meleeWeapon = MeleeWeapon.parseMeleeWeapon(meleeWeapon);
    }

    public Chapter getChapter() {
        return chapter;
    }

    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    public void setChapterName(String chapter) {
        this.chapter.setName(chapter);
    }

    public void setLegion(String Legion) {
        this.chapter.setParentLegion(Legion);
    }

    /**
     * Инициализация стэка ID
     */
    private static void initIdStack() {
        idStack = new Stack<>();
        idStack.push(0L);
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", coordinates: " + coordinates +
                ", creationDate=" + creationDate +
                ", health=" + health +
                ", heartCount=" + heartCount +
                ", loyal=" + loyal +
                ", meleeWeapon=" + meleeWeapon +
                ", chapter: " + chapter +
                '\n';
    }

    /**
     * Переопредление метода compareTo. Сравнение по координатам.
     */
    @Override
    public int compareTo(SpaceMarine spaceMarine) {
        return coordinates.compareTo(spaceMarine.coordinates);
    }

    public void clear() {
        idStack.remove(this.id);
    }
}
