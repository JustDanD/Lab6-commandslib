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
    private SpaceMarine newMarine;
    public RemoveLowerCommand(String[] args, TreeSet<SpaceMarine> trg) {
        super(args, trg);
        newMarine = Generators.marineGenerate();
    }

    @Override
    public String execute() {
        int cnt = 0;
        /*SpaceMarine newMarine;
        if (curCMD.getIsInteractive())
            newMarine = Generators.marineGenerate();
        else
            newMarine = Generators.marineJSONGenerate(arguments.get(1));
        if (newMarine == null) {
            System.out.println("Broken element");
            return;
        }*/
        Iterator<SpaceMarine> iterator = target.iterator();
        while (iterator.hasNext()) {
            SpaceMarine elem = iterator.next();
            if (newMarine.compareTo(elem) > 0) {
                iterator.remove();
                cnt++;
            }
        }
        return "Удалено " + cnt + " элемента(-ов)";
    }
}