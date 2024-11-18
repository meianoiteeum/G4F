package br.com.g4f.menu;

import br.com.g4f.command.MenuCommand;
import br.com.g4f.view.ConsoleView;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class MenuManager {
    private final Map<Integer, MenuCommand> commands;
    private final ConsoleView view;

    public MenuManager(ConsoleView view) {
        this.commands = new LinkedHashMap<>();
        this.view = view;
    }

    public void addCommand(int option, MenuCommand command){
        commands.put(option, command);
    }

    public void removeCommand(int option){
        commands.remove(option);
    }

    public void displayMenu(String title){
        view.displayMessage("==== " + title + " ====");
        commands.forEach((key,command) -> view.displayMessage(key + ". " + command.getDescription()));
        view.displayMessage("0. Back");
    }

    public void executeCommand(int option){
        MenuCommand command = commands.get(option);
        if(Objects.nonNull(command)){
            try{
                command.execute();
            }catch (Exception ex){
                view.displayError(ex.getMessage() + "\n" + ex.getCause().getMessage());
            }
        }
    }
}
