package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, добавляющяя элемент, если он меньше всех уже имеющихся
 * Принимает либо JSON, либо пользовательский ввод.
 */
public class AddMinCommand extends  Command implements Serializable {
    private static final long serialVersionUID = 2L;
    private final SpaceMarine marineToAdd;
    public AddMinCommand(String[] args, TreeSet<SpaceMarine> trg) {
        super(args, trg);
        marineToAdd = Generators.marineGenerate();
    }


    @Override
    public void execute() {
        if (target.size() != 0 && marineToAdd.compareTo((SpaceMarine) (target.stream().findFirst()).orElse(null)) < 0) {
            target.add(marineToAdd);
            System.out.println("Элемент успешно добавлен");
        } else
            System.out.println("Элемент не является наименьшим");
       }
}
