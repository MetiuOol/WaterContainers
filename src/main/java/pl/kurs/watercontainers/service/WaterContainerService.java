package pl.kurs.watercontainers.service;

import pl.kurs.watercontainers.models.WaterContainer;

public class WaterContainerService {

    public static WaterContainer getContainerWithHighestWaterLevel(WaterContainer... containers) {
        WaterContainer highestWaterLevelContainer = containers[0];
        for (WaterContainer container : containers) {
            if (highestWaterLevelContainer.getWaterLevel() < container.getWaterLevel())
                highestWaterLevelContainer = container;
        }
        return highestWaterLevelContainer;
    }

    public static WaterContainer getTheMostFilledContainer(WaterContainer... containers) {
        WaterContainer theMostFilledContainer = containers[0];
        for (WaterContainer container : containers) {
            if ((theMostFilledContainer.getWaterLevel() / theMostFilledContainer.getMaxCapacity()) < (container.getWaterLevel() / container.getMaxCapacity()))
                theMostFilledContainer = container;
        }
        return theMostFilledContainer;
    }

    public static WaterContainer[] getEmptyContainers(WaterContainer... containers) {
        int emptyContainersCounter = 0;
        for (WaterContainer c : containers) {
            if (c.getWaterLevel() == 0) {
                emptyContainersCounter++;
            }

        }
        WaterContainer[] emptyWaterContainersArray = new WaterContainer[emptyContainersCounter];
        int index = 0;
        for (int i = 0; i < containers.length; i++) {
            if (containers[i].getWaterLevel() == 0) {
                emptyWaterContainersArray[index++] = containers[i];
            }

        }
        return emptyWaterContainersArray;
    }

}
