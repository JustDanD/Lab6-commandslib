package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда удаления элемента коллекции с таким ID.
 */
public class RemoveCommand extends  Command {
    public RemoveCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        for (SpaceMarine marine : target) {
            try {
                if (marine.getId() == Long.parseLong(arguments.get(1))) {
                    marine.clear();
                    target.remove(marine);
                    System.out.println("Элемент успешно удалён");
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ID");
            }
        }
        System.out.println("Элемент c таким ID не существует");
    }
}