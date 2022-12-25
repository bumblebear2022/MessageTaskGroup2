package by.itacademy.jd2.messagetask.service.factories;

import by.itacademy.jd2.messagetask.service.StatisticsService;
import by.itacademy.jd2.messagetask.service.api.IStatisticsService;

public class StatisticsServiceSingleton {
    private volatile static IStatisticsService INSTANCE;

    private StatisticsServiceSingleton() {}

    public static IStatisticsService getInstance() {
        if(INSTANCE == null){
            synchronized (StatisticsServiceSingleton.class){
                if(INSTANCE == null){
                    INSTANCE = new StatisticsService();
                }
            }
        }
        return INSTANCE;
    }
}
