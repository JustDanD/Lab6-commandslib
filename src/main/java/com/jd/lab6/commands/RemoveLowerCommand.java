package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда удаления всех элементов меньше данного
 */
public class RemoveLowerCommand extends  Command implements Serializable {
    private static final long serialVersionUID = 13L;
    private final SpaceMarine newMarine;
    public RemoveLowerCommand(String[] args, TreeSet<SpaceMarine> trg, boolean isInteractive) {
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
    }

    @Override
    public synchronized String execute() {
        int cnt = 0;
        SpaceMarine[] marines = (SpaceMarine[]) target.stream().filter(x -> newMarine.compareTo(x) > 0).toArray();
        for (SpaceMarine marine : marines) {
            marine.clear();
            target.remove(marine);
            cnt++;
        }
        return "Удалено " + cnt + " элемента(-ов)";
    }
    public String toString() {
        return "remove_lower";
    }
}