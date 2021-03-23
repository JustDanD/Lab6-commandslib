package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, обновляющая элемент с заданым id
 */
public class UpdateCommand extends  Command implements Serializable {
    private static final long serialVersionUID = 16L;
    private final SpaceMarine newMarine;
    private long id;
    public UpdateCommand(String[] args, TreeSet<SpaceMarine> trg, boolean isInteractive) {
        super(args, trg, isInteractive);
        if (isInteractive)
            this.newMarine = Generators.marineGenerate();
        else {
            SpaceMarine newMarine = Generators.marineJSONGenerate(arguments.get(1));
            if (newMarine != null)
                this.newMarine = newMarine;
            else {
                this.newMarine = null;
                System.out.println("Битый корабль");
                valid = false;
            }
        }
        try {
            id = Long.parseLong(arguments.get(1));
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ID");
        }

    }

    @Override
    public synchronized String execute() {
       /* SpaceMarine newMarine;
        if (curCMD.getIsInteractive())
            newMarine = Generators.marineGenerate();
        else
            newMarine = Generators.marineJSONGenerate(arguments.get(2));
        if (newMarine == null) {
            System.out.println("Broken element");
            return;
        }*/
        for (SpaceMarine marine : target) {
                if (marine.getId() == id) {
                    marine.clear();
                    target.remove(marine);
                    newMarine.setId(Long.parseLong(arguments.get(1)));
                    target.add(newMarine);
                    return "Элемент успешно обновлён";

                }
        }
        return "Элемент c таким ID не существует";
    }
    public String toString() {
        return "update";
    }
}