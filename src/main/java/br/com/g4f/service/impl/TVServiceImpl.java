package br.com.g4f.service.impl;

import br.com.g4f.exceptions.DeviceOperationException;
import br.com.g4f.model.TV;
import br.com.g4f.service.TVService;
import br.com.g4f.util.Util;

import java.util.Objects;

public class TVServiceImpl implements TVService {
    @Override
    public void turnOn(TV tv) {
        validateDevice(tv);
        Util.validateTurnOn(tv.isPowered());
        tv.setPowered(turnOnOff(tv.isPowered()));
    }

    @Override
    public void turnOff(TV tv) {
        validateDevice(tv);
        Util.validateTurnOff(tv.isPowered());
        tv.setPowered(turnOnOff(tv.isPowered()));
    }

    @Override
    public void changeChannel(TV tv, int channel) {
        validateDevice(tv);
        try {
            Util.verifyTurnOff(tv.isPowered(), "TV is off");
            tv.setChannel(channel);
        }catch (IllegalStateException ise){
            throw new DeviceOperationException("Failed to change channel", ise);
        }
    }

    @Override
    public void adjustVolume(TV tv, int volume) {
        validateDevice(tv);
        try {
            Util.verifyTurnOff(tv.isPowered(), "TV is off");

            if(!Util.validNumber(0,100, volume))
                throw new IllegalArgumentException("Please, enter a number between 0 and 100");

            tv.setVolume(volume);
        }catch (IllegalStateException ise){
            throw new DeviceOperationException("Failed to adjust volume", ise);
        }
    }

    @Override
    public TV renameBrand(TV tv, String brand) {
        validateDevice(tv);
        tv.renameBrand(brand);
        return tv;
    }

    @Override
    public TV renameModel(TV tv, String model) {
        validateDevice(tv);
        tv.renameModel(model);
        return tv;
    }

    private void validateDevice(TV tv) {
        if(Objects.isNull(tv)){
            throw new IllegalArgumentException("TV cannot be null");
        }
    }
}
