package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.util.Iterator;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда удаления всех элементов меньше данного
 */
public class RemoveLowerCommand extends  Command {
    public RemoveLowerCommand(String[] args, TreeSet<SpaceMarine> trg, Cmd cmd) {
        super(args, trg, cmd);
    }


    @Override
    public void execute() {
        int cnt = 0;
        SpaceMarine newMarine;
        if (curCMD.getIsInteractive())
            newMarine = Generators.marineGenerate();
        else
            newMarine = Generators.marineJSONGenerate(arguments.get(1));
        if (newMarine == null) {
            System.out.println("Broken element");
            return;
        }
        Iterator<SpaceMarine> iterator = target.iterator();
        while (iterator.hasNext()) {
            SpaceMarine elem = iterator.next();
            if (newMarine.compareTo(elem) > 0) {
                iterator.remove();
                cnt++;
            }
        }
        System.out.println("Удалено " + cnt + " элемента(-ов)");
    }
}