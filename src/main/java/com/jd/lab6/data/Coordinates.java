package com.jd.lab6.data;

/**
 * @author Пименов Данила, P3130
 * Класс, описывающий координаты.
 * Реализует интерфейс Comparable.
 */
public class Coordinates implements Comparable<Coordinates> {
    private long x;
    private Float y;

    public Coordinates(long x, Float y) {
        this.x = x;
        this.y = y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public Float getY() {
        return y;
    }

    public void setY(Float y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "" +
                "x=" + x +
                ", y=" + y;
    }

    /**
     * Сравнение объектов по сумме координат.
     * @param coordinates - объект для сравнения
     */
    @Override
    public int compareTo(Coordinates coordinates) {
        return (int) ((x + y) - (coordinates.x + coordinates.y));
    }
}
