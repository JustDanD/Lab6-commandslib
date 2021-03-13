package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author Пименов Данила P3130
 * Класс-интерпретатор. Отвечает за считывание команд и их аргументов, вызывает обработчики.
 * Поля:
 * commandsMap - карта комманд, соответствующая шаболну имя_команды - класс_обработчик
 * commandHistory - стэк, содержащий предыдущие команды
 * curCollection - колдекция, с которой взаимодействует пользователь
 * startDate - дата и время инициализации интерпретатора
 * isInteractive - режим работы интерператора
 */
public class Cmd {
    private final HashMap<String, Class<? extends  Command>> commandsMap;
    private final Stack<String> commandHistory;
    private final TreeSet<SpaceMarine> curCollection;
    private final LocalDateTime startDate;
    private final boolean isInteractive;

    /**
     * Констурктор
     * @param col - текущая коллекция
     * @param isInteractive - режим работы
     * @param parent - родительский интепретатор(если есть)
     */
    public Cmd(TreeSet<SpaceMarine> col, boolean isInteractive, Cmd parent) {
        if (isInteractive) {
            System.out.println("Доброго времени суток, уважаемый юзер.\nДобро пожаловать в систему управления вашей коллекцией космических корбалей!\nПриятного пользования!\nДля просмотра существующих команд введите help.");
            startDate = LocalDateTime.now();
            commandHistory = new Stack<>();
        } else {
            startDate = parent.getStartDate();
            commandHistory = parent.getCommandHistory();
        }
        this.isInteractive = isInteractive;
        commandsMap = new HashMap<>();
        commandsMap.put("exit",  ExitCommand.class);
        commandsMap.put("help",  HelpCommand.class);
        commandsMap.put("info",  InfoCommand.class);
        commandsMap.put("show",  ShowCommand.class);
        commandsMap.put("add",  AddCommand.class);
        commandsMap.put("update",  UpdateCommand.class);
        commandsMap.put("remove_by_id",  RemoveCommand.class);
        commandsMap.put("clear",  ClearCommand.class);
        commandsMap.put("save",  SaveCommand.class);
        commandsMap.put("add_if_min",  AddMinCommand.class);
        commandsMap.put("remove_lower",  RemoveLowerCommand.class);
        commandsMap.put("history",  HistoryCommand.class);
        commandsMap.put("print_descending",  PrintDescendingCommand.class);
        commandsMap.put("remove_any_by_chapter",  RemoveByChapterCommand.class);
        commandsMap.put("group_counting_by_heart_count",  GroupCommand.class);
        commandsMap.put("execute_script",  ExecuteScriptCommand.class);
        curCollection = col;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public boolean getIsInteractive() {
        return isInteractive;
    }

    /**
     * Метод, прослушивающий и обрабатывающий пользовательский ввод
     */
    public void listen() {
        Scanner in = new Scanner(System.in);
        String curCom;
        String[] curArgs;
        Class[] params = {String[].class, TreeSet.class, Cmd.class};
        while (true) {
            try {
            curCom = in.next();
            curArgs = in.nextLine().replaceAll(" +", " ").split(" ");

                Class<? extends  Command> command = (commandsMap.get(curCom));
                if (command != null) {
                     Command executedCom = command.getConstructor(params).newInstance(curArgs, curCollection, this);
                    executedCom.execute();
                    commandHistory.push(curCom);
                } else
                    System.out.println("Такой команды не существует");
                if (!in.hasNext()) {
                    System.out.println("Выполнение скрипта завершено");
                    return;
                }
            } catch (Exception e) {
                if (!in.hasNext()) {
                        if (isInteractive) {
                            System.out.println("Входной поток умер. Возможно, вы нажали ctrl + D. Аварийное(не очень) закрытие.");
                            System.exit(-1);
                        }
                    else
                        {
                            System.out.println("Неожиданный конец файла. Выход из скрипта");
                            return;
                        }
                }
                System.out.println(e.getMessage());
            }
        }
    }

    public Stack<String> getCommandHistory() {
        return commandHistory;
    }
}
