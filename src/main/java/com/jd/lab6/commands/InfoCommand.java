package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.time.format.DateTimeFormatter;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Команда, выводящая информацию о коллекции
 */
public class InfoCommand extends Command implements Serializable {
    private static final long serialVersionUID = 8L;

    public InfoCommand(String[] args, TreeSet<SpaceMarine> trg) {
        super(args, trg);
    }

    @Override
    public String execute() {
        return "Информация о коллекции:\nДата инициалиазции: " +
                "\nТип коллекции: " + target.getClass() + "\nТип элементов: SpaceMarine" +
                "\nРазмер коллекции: " + target.size();
    }
}