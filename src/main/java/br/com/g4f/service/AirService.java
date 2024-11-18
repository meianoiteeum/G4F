package br.com.g4f.service;

import br.com.g4f.model.Air;
import br.com.g4f.model.Mode;

public interface AirService extends DeviceService<Air>{
    void adjustTemperature(Air air, int temperature);
    void changeMode(Air air, Mode mode);
}
