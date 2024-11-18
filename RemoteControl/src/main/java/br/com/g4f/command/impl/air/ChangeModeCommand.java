package br.com.g4f.command.impl.air;

import br.com.g4f.command.MenuCommand;
import br.com.g4f.model.Air;
import br.com.g4f.model.Mode;
import br.com.g4f.service.AirService;
import br.com.g4f.view.ConsoleView;

public class ChangeModeCommand implements MenuCommand {
    private final Air air;
    private final AirService service;
    private final ConsoleView view;

    public ChangeModeCommand(Air air, AirService service, ConsoleView view) {
        this.air = air;
        this.service = service;
        this.view = view;
    }

    @Override
    public void execute() {
        view.displayMessage("Choose Mode: (AUTO,COOL,DRY,HEAT)");
        String mode = view.readStringInput().toUpperCase();
        service.changeMode(air, Mode.findCode(mode));
    }

    @Override
    public String getDescription() {
        return "Change Mode";
    }
}
