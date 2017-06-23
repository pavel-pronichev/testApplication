package ru.tcsbank.tcbpos;

import android.hardware.usb.UsbDevice;
import android.os.RemoteException;

import ru.evotor.devices.drivers.IUsbDriverManagerService;

/**
 * Created by p.pronichev on 22.06.2017.
 */

public class UvcCameraDriverManagerStub extends IUsbDriverManagerService.Stub {

    private UvcCameraDeviceService service;

    public UvcCameraDriverManagerStub(UvcCameraDeviceService service){
        this.service = service;
    }

    @Override
    public int addUsbDevice(UsbDevice usbDevice, String s) throws RemoteException {
        return service.createNewUvcCamera(usbDevice);
    }

    @Override
    public void destroy(int i) throws RemoteException {
        service.destroy(i);
    }
}
