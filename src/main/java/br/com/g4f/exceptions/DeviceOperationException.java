package br.com.g4f.exceptions;

public class DeviceOperationException extends RuntimeException{
    public DeviceOperationException(String message, Throwable cause){
        super(message, cause);
    }
}
