package br.com.g4f.command.impl.home;

import br.com.g4f.command.MenuCommand;
import br.com.g4f.model.Device;
import br.com.g4f.service.HomeService;

public class RemoveDeviceCommand implements MenuCommand {
    private final HomeService service;
    private final Device device;

    public RemoveDeviceCommand(HomeService service, Device device) {
        this.service = service;
        this.device = device;
    }

    @Override
    public void execute() {
        service.removeDevice(device);
    }

    @Override
    public String getDescription() {
        return "Remove Device";
    }
}
