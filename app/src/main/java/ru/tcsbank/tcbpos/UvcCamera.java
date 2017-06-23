package ru.tcsbank.tcbpos;

import android.content.Context;
import android.hardware.usb.UsbDevice;

import java.net.ContentHandler;

import ru.evotor.devices.drivers.Constants;
import ru.evotor.devices.drivers.cashdrawer.ICashDrawer;
import ru.evotor.devices.drivers.scales.IScales;

/**
 * Created by p.pronichev on 23.06.2017.
 */

public class UvcCamera {

    private Context context;
    private UsbDevice usbDevice;

    public UvcCamera(Context context, UsbDevice usbDevice){
        this.context = context;
        this.usbDevice = usbDevice;
    }

    public void destroy(){

    }



}
