package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, выводящая последние 5 введённых команд
 */
public class HistoryCommand extends  Command implements Serializable {
    private static final long serialVersionUID = 7L;
    public HistoryCommand(String[] args, TreeSet<SpaceMarine> trg) {
        super(args, trg);
    }

    @Override
    public String execute() {
        /*for (int i = 0; i < curCMD.getCommandHistory().size(); i++) {
            System.out.println(curCMD.getCommandHistory().get(i));
            if (i >= 5)
                break;
        }*/
        return "";
    }
}