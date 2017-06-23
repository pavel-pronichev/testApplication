package ru.tcsbank.tcbpos;

import android.os.RemoteException;

import ru.evotor.devices.drivers.IScalesDriverService;
import ru.evotor.devices.drivers.scales.Weight;

/**
 * Created by p.pronichev on 23.06.2017.
 */

public class UvcCameraStub extends IScalesDriverService.Stub {
    @Override
    public Weight getWeight(int i) throws RemoteException {
        return null;
    }
}
