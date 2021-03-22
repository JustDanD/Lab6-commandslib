package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.Serializable;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * * Команда добавления элемента в коллекцию.
 * В зависиомсти от сценария прнимает JSON-объект или предлагает пользовательский ввод.
 */
public class AddCommand extends Command implements Serializable {
    private static final long serialVersionUID = 1L;
    private final SpaceMarine marineToAdd;

    public AddCommand(String[] args, TreeSet<SpaceMarine> trg, boolean isInteractive) {
        super(args, trg, isInteractive);
        if (isInteractive)
            marineToAdd = Generators.marineGenerate();
        else {
            SpaceMarine newMarine = Generators.marineJSONGenerate(arguments.get(1));
            if (newMarine != null)
                marineToAdd = newMarine;
            else {
                marineToAdd = null;
                System.out.println("Битый корабль");
                valid = false;
            }
        }
    }

    @Override
    public String execute() {
        if (marineToAdd != null) {
            target.add(marineToAdd);
            return "Элемент успешно добавлен";
        }
        else
            return "Элемент добавить не удалось";
    }

    @Override
    public String toString() {
        return "Add";
    }
}
