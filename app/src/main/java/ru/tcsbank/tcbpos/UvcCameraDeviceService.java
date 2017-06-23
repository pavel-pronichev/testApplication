package ru.tcsbank.tcbpos;

import android.app.Service;
import android.content.Intent;
import android.hardware.usb.UsbDevice;
import android.os.IBinder;
import android.support.annotation.Nullable;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import ru.evotor.devices.drivers.Constants;

/**
 * Created by p.pronichev on 22.06.2017.
 */

public class UvcCameraDeviceService extends Service {

    private final Map<Integer, UvcCamera> instances = new HashMap<>();
    private volatile AtomicInteger newDeviceIndex = new AtomicInteger(0);

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        switch (action){
            case Constants.INTENT_FILTER_DRIVER_MANAGER:
                return new UvcCameraDriverManagerStub(UvcCameraDeviceService.this);
            default:
                return null;
        }
    }

    public int createNewUvcCamera(UsbDevice usbDevice){
        int currentIndex = newDeviceIndex.getAndIncrement();
        instances.put(currentIndex, new UvcCamera(getApplicationContext(), usbDevice));
        return currentIndex;
    }

    public UvcCamera getUvcCamera(int instanceId){
        return instances.get(instanceId);
    }

    public void destroy(int instanceId){
        getUvcCamera(instanceId).destroy();
        instances.remove(instanceId);
    }

}
