package br.com.g4f.command.impl.tv;

import br.com.g4f.command.MenuCommand;
import br.com.g4f.model.TV;
import br.com.g4f.service.TVService;
import br.com.g4f.view.ConsoleView;

public class ChangeChannelCommand implements MenuCommand {
    private final TV tv;
    private final TVService tvService;
    private final ConsoleView view;

    public ChangeChannelCommand(TV tv, TVService tvService, ConsoleView view) {
        this.tv = tv;
        this.tvService = tvService;
        this.view = view;
    }

    @Override
    public void execute() {
        int channel = view.readIntInput(0,100, "Enter channel number (0-100): ");
        tvService.changeChannel(tv,channel);
    }

    @Override
    public String getDescription() {
        return "Change TV Channel";
    }
}
