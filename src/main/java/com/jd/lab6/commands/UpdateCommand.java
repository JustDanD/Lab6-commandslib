package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, обновляющая элемент с заданым id
 */
public class UpdateCommand extends  Command {
    public UpdateCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        SpaceMarine newMarine;
        if (curCMD.getIsInteractive())
            newMarine = Generators.marineGenerate();
        else
            newMarine = Generators.marineJSONGenerate(arguments.get(2));
        if (newMarine == null) {
            System.out.println("Broken element");
            return;
        }
        for (SpaceMarine marine : target) {
            try {
                if (marine.getId() == Long.parseLong(arguments.get(1))) {

                    marine.clear();
                    target.remove(marine);
                    newMarine.setId(Long.parseLong(arguments.get(1)));
                    target.add(newMarine);
                    System.out.println("Элемент успешно обновлён");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ID");
            }
        }
        System.out.println("Элемент c таким ID не существует");
    }
}