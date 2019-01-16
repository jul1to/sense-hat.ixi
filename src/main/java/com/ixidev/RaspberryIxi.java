package com.ixidev;

import de.larsgrefer.sense_hat.SenseHat;
import de.larsgrefer.sense_hat.SenseHatColor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.iota.ict.ixi.Ixi;
import org.iota.ict.ixi.IxiModule;
import org.iota.ict.network.event.GossipEvent;
import org.iota.ict.network.event.GossipListener;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class RaspberryIxi extends IxiModule {

    private final static Logger LOGGER = LogManager.getLogger(RaspberryIxi.class);

    private SenseHat senseHat;

    @Override
    public void run() {

        //SenseHat library initialisation
        try {
            senseHat = new SenseHat();
        } catch (IOException exception) {
            senseHat = null;
            LOGGER.error("No sense-hat device connected");
        }

        if (senseHat != null) {

            this.ixi.addGossipListener(new GossipListener() {
                @Override
                public void onGossipEvent(GossipEvent gossipEvent) {
                    try {
                        //Clear leds
                        senseHat.fill(SenseHatColor.BLACK);

                        //Display random Green LED
                        int x = ThreadLocalRandom.current().nextInt(0, 8);
                        int y = ThreadLocalRandom.current().nextInt(0, 8);

                        senseHat.setPixel(x, y, SenseHatColor.GREEN);

                    } catch (IOException exception) {
                        LOGGER.error("No sense-hat device connected");
                    }
                }
            });
        }
    }

    public RaspberryIxi(final Ixi ixi) {
        super(ixi);

    }
}
