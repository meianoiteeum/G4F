package br.com.g4f.command.impl.home;

import br.com.g4f.command.MenuCommand;
import br.com.g4f.service.HomeService;
import br.com.g4f.view.ConsoleView;

public class ListAllDeviceCommand implements MenuCommand {
    private final HomeService service;
    private final ConsoleView view;

    public ListAllDeviceCommand(HomeService service, ConsoleView view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        service.getAllDevices().forEach(view::displayDeviceStatus);
    }

    @Override
    public String getDescription() {
        return "List of All Devices";
    }
}
