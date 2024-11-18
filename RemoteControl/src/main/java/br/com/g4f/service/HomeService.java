package br.com.g4f.service;

import br.com.g4f.model.Device;
import br.com.g4f.model.Home;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface HomeService {
    Home addDevice(Device device);
    void removeDevice(Device device);
    List<Device> getAllDevices();
    void turnOnAllDevices();
    void turnOffAllDevices();
    Optional<? extends Device> findAllDevices(UUID id, Class<? extends Device> classe);
}