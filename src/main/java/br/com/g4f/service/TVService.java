package br.com.g4f.service;

import br.com.g4f.model.TV;

public interface TVService extends DeviceService<TV>{
    void changeChannel(TV tv, int channel);
    void adjustVolume(TV tv, int volume);
}
