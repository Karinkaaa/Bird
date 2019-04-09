package org.demo.birds.entities;

/**
 * Bird.
 * <p>
 * Должны быть следущие свойства:
 * <p>
 * name  тип String
 * livingArea тип String
 * size – число с плавающей точкой, может быть незаполненным (Double).
 */
public class Bird {

    private String name;
    private String livingArea;
    double size;

    public Bird(String name, String livingArea, double size) {

        this.name = name;
        this.livingArea = livingArea;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    public String getLivingArea() {
        return livingArea;
    }

    public double getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "\n\nName: " + getName() + "\nLiving area: " + getLivingArea() + "\nSize: " + getSize();
    }
}
