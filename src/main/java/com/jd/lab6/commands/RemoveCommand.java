package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда удаления элемента коллекции с таким ID.
 */
public class RemoveCommand extends  Command implements Serializable {
    private static final long serialVersionUID = 11L;
    private static long id;
    public RemoveCommand(String[] args, TreeSet<SpaceMarine> trg, boolean isInteractive) {
        super(args, trg, isInteractive);
            try {
                id = Long.parseLong(arguments.get(1));
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ID");
                valid = false;
        }
    }

    @Override
    public synchronized String execute() {
        for (SpaceMarine marine : target) {
            if (marine.getId() == id) {
                marine.clear();
                target.remove(marine);
                return  "Элемент успешно удалён";
            }
        }
        return "Элемент c таким ID не существует";
    }
    public String toString() {
        return "remove_by_id";
    }
}