package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, добавляющяя элемент, если он меньше всех уже имеющихся
 * Принимает либо JSON, либо пользовательский ввод.
 */
public class AddMinCommand extends  Command {
    public AddMinCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        SpaceMarine newMarine;
        if (curCMD.getIsInteractive())
            newMarine =  Generators.marineGenerate();
        else
            newMarine =  Generators.marineJSONGenerate(arguments.get(1));
        if (newMarine == null) {
            System.out.println("Broken element");
            return;
        }
        if (target.size() == 0 || newMarine.compareTo(target.first()) < 0) {
            target.add(newMarine);
            System.out.println("Элемент успешно добавлен");
        } else
            System.out.println("Элемент не является наименьшим");
    }
}
