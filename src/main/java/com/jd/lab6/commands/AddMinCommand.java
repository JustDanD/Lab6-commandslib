package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, добавляющяя элемент, если он меньше всех уже имеющихся
 * Принимает либо JSON, либо пользовательский ввод.
 */
public class AddMinCommand extends Command implements Serializable {
    private static final long serialVersionUID = 2L;
    private final SpaceMarine marineToAdd;

    public AddMinCommand(String[] args, TreeSet<SpaceMarine> trg, boolean isInteractive) {
        super(args, trg, isInteractive);
        if (isInteractive)
            marineToAdd = Generators.marineGenerate();
        else {
            SpaceMarine newMarine = Generators.marineJSONGenerate(arguments.get(1));
            if (newMarine != null)
                marineToAdd = newMarine;
            else {
                marineToAdd = null;
                System.out.println("Битый корабль");
                valid = false;
            }
        }
    }


    @Override
    public synchronized String execute() {
        if (target.size() != 0 && marineToAdd.compareTo((SpaceMarine) (target.stream().findFirst()).orElse(null)) < 0) {
            marineToAdd.setId(marineToAdd.getId());
            target.add(marineToAdd);
            return "Элемент успешно добавлен";
        } else
            return "Элемент не является наименьшим";
    }

    @Override
    public String toString() {
        return "AddMin";
    }
}
