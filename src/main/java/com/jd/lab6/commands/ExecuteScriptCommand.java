package com.jd.lab6.commands;

import com.jd.lab6.data.SpaceMarine;

import java.io.*;
import java.util.*;

/**
 * @author Пименов Данила P3130
 * Команда, исполняющая сторонний скрипт.
 * Содержит в себе стэк с именами уже запущенных "сверху" скриптов.
 */
public class ExecuteScriptCommand extends Command implements Serializable {
    private static Stack<String> executedScripts;
    private static final long serialVersionUID = 3L;
    private ArrayDeque<Command> commandsQueue;

    public ExecuteScriptCommand(String[] args, TreeSet<SpaceMarine> trg, boolean isInteractive) {
        super(args, trg, isInteractive);
        commandsQueue = new ArrayDeque<>();
        InputStream oldIn = System.in;
        if (executedScripts == null)
            executedScripts = new Stack<>();
        if (arguments.size() < 2) {
            System.out.println("Не указано имя скрипта");
            valid = false;
            return;
        }
        if (executedScripts.contains(arguments.get(1))) {
            System.out.println("Не бывать в нашем царстве рекурсии.");
            valid = false;
            return;
        } else
            executedScripts.push(arguments.get(1));
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(arguments.get(1)))) {
            System.setIn(in);
            loadScript();
            executedScripts.pop();
            System.setIn(oldIn);
        } catch (Exception e) {
            System.setIn(oldIn);
            System.out.println("Ошибка загрузки:" + e.getMessage());
            executedScripts.pop();
        }
    }

    public void loadScript() {
        HashMap<String, Class<? extends Command>> commandsMap = new HashMap<>();
        commandsMap.put("exit", ExitCommand.class);
        commandsMap.put("help", HelpCommand.class);
        commandsMap.put("info", InfoCommand.class);
        commandsMap.put("show", ShowCommand.class);
        commandsMap.put("add", AddCommand.class);
        commandsMap.put("update", UpdateCommand.class);
        commandsMap.put("remove_by_id", RemoveCommand.class);
        commandsMap.put("clear", ClearCommand.class);
        commandsMap.put("add_if_min", AddMinCommand.class);
        commandsMap.put("remove_lower", RemoveLowerCommand.class);
        commandsMap.put("history", HistoryCommand.class);
        commandsMap.put("print_descending", PrintDescendingCommand.class);
        commandsMap.put("remove_any_by_chapter", RemoveByChapterCommand.class);
        commandsMap.put("group_counting_by_heart_count", GroupCommand.class);
        commandsMap.put("execute_script", ExecuteScriptCommand.class);

        Scanner in = new Scanner(System.in);
        String curCom = "";
        String[] curArgs;
        Class[] params = {String[].class, TreeSet.class, boolean.class};
        while (true) {
            try {
                curCom = in.next();
                curArgs = in.nextLine().replaceAll(" +", " ").split(" ");
                Class<? extends Command> command = commandsMap.get(curCom);
                if (command != null) {
                    Command executedCom = command.getConstructor(params).newInstance(curArgs, null, false);
                    commandsQueue.add(executedCom);
                }
                if (!in.hasNext()) {
                    return;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public String execute() {
       StringBuilder res = new StringBuilder();
       while (!commandsQueue.isEmpty()) {
           Command currentCommand = commandsQueue.remove();
           currentCommand.setTarget(this.target);
           res.append(currentCommand.execute()).append("\n");
       }
       res.append("Выполнение скрипта завершено");
       return res.toString();
    }

    @Override
    public String toString() {
        return "execute_script";
    }
}