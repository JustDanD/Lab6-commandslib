package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, выводящая последние 5 введённых команд
 */
public class HistoryCommand extends  Command implements Serializable {
    private static final long serialVersionUID = 7L;
    public HistoryCommand(String[] args, TreeSet<SpaceMarine> trg, boolean isInteractive) {
        super(args, trg, isInteractive);
    }

    @Override
    public String execute() {
        return null;
    }
    public String execute(Stack<String> history) {
        StringBuilder res = new StringBuilder();
        history.stream().limit(5).forEach(x -> res.append(x).append("\n"));
        return res.toString();
    }
    public String toString() {
        return "history";
    }
}