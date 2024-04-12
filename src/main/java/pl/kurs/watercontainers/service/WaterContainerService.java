package pl.kurs.watercontainers.service;

import pl.kurs.watercontainers.models.WaterContainer;

public class WaterContainerService {

    public static WaterContainer getContainerWithHighestWaterLevel(WaterContainer[] containers) {
        WaterContainer highestWaterLevelContainer = null;
        try {
            highestWaterLevelContainer = containers[0];
            for (WaterContainer container : containers) {
                if (highestWaterLevelContainer.getWaterLevel() < container.getWaterLevel())
                    highestWaterLevelContainer = container;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
            return highestWaterLevelContainer;

    }
}
