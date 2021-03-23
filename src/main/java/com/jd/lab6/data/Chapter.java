package com.jd.lab6.data;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Пименов Данила, P3130
 * Класс, описывающий "часть"
 * Содержит переопределённую логику toString, hasCode, equals, а также набор станадратных геттеров и сеттеров
 */
public class Chapter implements Serializable {
    private String name;
    private String parentLegion;

    /**
     * Констурктор
     *
     * @param name         - название части
     * @param parentLegion - родительское подразделение
     */
    public Chapter(String name, String parentLegion) {
        this.name = name;
        this.parentLegion = parentLegion;
    }

    /**
     * Переопределние ToString
     */
    @Override
    public String toString() {
        return "chapter name='" + name + '\'' +
                ", parent legion='" + parentLegion + '\'';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParentLegion() {
        return parentLegion;
    }

    public void setParentLegion(String parentLegion) {
        this.parentLegion = parentLegion;
    }

    /**
     * Перепопределение equals. Сравнение по обоим полям.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Chapter chapter = (Chapter) o;
        return Objects.equals(name, chapter.name) &&
                Objects.equals(parentLegion, chapter.parentLegion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, parentLegion);
    }
}
