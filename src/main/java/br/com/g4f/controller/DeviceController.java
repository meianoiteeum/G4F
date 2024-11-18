package br.com.g4f.controller;

import br.com.g4f.command.impl.air.TemperatureCommand;
import br.com.g4f.command.impl.air.ChangeModeCommand;
import br.com.g4f.command.impl.home.TurnOnOffCommand;
import br.com.g4f.command.impl.tv.AdjustVolumeCommand;
import br.com.g4f.command.impl.tv.ChangeChannelCommand;
import br.com.g4f.menu.MenuManager;
import br.com.g4f.model.Air;
import br.com.g4f.model.Device;
import br.com.g4f.model.TV;
import br.com.g4f.service.AirService;
import br.com.g4f.service.TVService;
import br.com.g4f.util.Util;
import br.com.g4f.view.ConsoleView;

public class DeviceController {
    private final TVService tvService;
    private final AirService airService;
    private final ConsoleView view;

    public DeviceController(TVService tvService, AirService airService, ConsoleView view) {
        this.tvService = tvService;
        this.airService = airService;
        this.view = view;
    }

    private MenuManager createTvMenu(TV tv){
        MenuManager menu = new MenuManager(view);
        menu.addCommand(1, new TurnOnOffCommand<>(tv, tvService));
        menu.addCommand(2, new ChangeChannelCommand(tv, tvService, view));
        menu.addCommand(3, new AdjustVolumeCommand(tv, tvService, view));

        return menu;
    }

    private MenuManager createAirMenu(Air air){
        MenuManager menu = new MenuManager(view);
        menu.addCommand(1, new TurnOnOffCommand<>(air, airService));
        menu.addCommand(2, new TemperatureCommand(air, airService, view));
        menu.addCommand(3, new ChangeModeCommand(air, airService, view));

        return menu;
    }

    public void start(Device device){
        var run = true;
        while (run){
            try {
                view.displayDeviceStatus(device);

                switch(device){
                    case Air air -> {
                        var airMenu = createAirMenu(air);
                        airMenu.displayMenu("Air Control");
                        int choice = view.readIntInput();
                        run = Util.executeCommand(choice, airMenu);
                    }
                    case TV tv -> {
                        var tvMenu = createTvMenu(tv);
                        tvMenu.displayMenu("TV Control");
                        int choice = view.readIntInput();
                        run = Util.executeCommand(choice, tvMenu);
                    }
                }
            }catch (Exception ex){
                view.displayError(ex.getMessage());
                run = false;
            }
        }
    }


}
