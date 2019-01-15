package com.ixidev;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.iota.ict.ixi.Ixi;
import org.iota.ict.ixi.IxiModule;
import org.iota.ict.network.event.GossipEvent;
import org.iota.ict.network.event.GossipListener;
import rpi.sensehat.api.SenseHat;
import rpi.sensehat.api.dto.Color;

import java.util.concurrent.ThreadLocalRandom;

public class RaspberryIxi extends IxiModule {

    private final static Logger LOGGER = LogManager.getLogger(RaspberryIxi.class);

    @Override
    public void run() {

        this.ixi.addGossipListener(new GossipListener() {
            @Override
            public void onGossipEvent(GossipEvent gossipEvent) {
                LOGGER.debug("New event received");

                SenseHat senseHat = new SenseHat();
                //Clear leds
                senseHat.ledMatrix.clear();

                //Display random LED
                int x =  ThreadLocalRandom.current().nextInt(0,8);
                int y =  ThreadLocalRandom.current().nextInt(0,8);

                senseHat.ledMatrix.setPixel(x, y, Color.GREEN);
            }
        });

    }

    public RaspberryIxi(final Ixi ixi) {
        super(ixi);
    }
}
