package br.com.g4f.command.impl.tv;

import br.com.g4f.command.MenuCommand;
import br.com.g4f.model.TV;
import br.com.g4f.service.TVService;
import br.com.g4f.view.ConsoleView;

public class AdjustVolumeCommand implements MenuCommand {

    private final TV tv;
    private final TVService tvService;
    private final ConsoleView view;

    public AdjustVolumeCommand(TV tv, TVService tvService, ConsoleView view) {
        this.tv = tv;
        this.tvService = tvService;
        this.view = view;
    }

    @Override
    public void execute() {
        int volume = view.readIntInput(0,100,"Enter volume (0-100)");
        tvService.adjustVolume(tv, volume);
    }

    @Override
    public String getDescription() {
        return "Adjust Volume";
    }
}
