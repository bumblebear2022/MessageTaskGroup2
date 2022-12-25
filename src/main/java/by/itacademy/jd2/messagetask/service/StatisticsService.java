package by.itacademy.jd2.messagetask.service;

import by.itacademy.jd2.messagetask.dto.StatisticsDto;
import by.itacademy.jd2.messagetask.listeners.ActiveUserListener;
import by.itacademy.jd2.messagetask.service.api.IMessageService;
import by.itacademy.jd2.messagetask.service.api.IStatisticsService;
import by.itacademy.jd2.messagetask.service.api.IUserService;
import by.itacademy.jd2.messagetask.service.factories.MessageServiceSingleton;
import by.itacademy.jd2.messagetask.service.factories.UserServiceSingleton;

public class StatisticsService implements IStatisticsService {

    private final IMessageService messageService = MessageServiceSingleton.getInstance();
    private final IUserService userService = UserServiceSingleton.getINSTANCE();

    public StatisticsDto getStatistics(){
        int registeredUsers = userService.userQuantity();
        int messages = messageService.userQuantity();
        int activeUserQuantity = ActiveUserListener.getQuantity();
        return new StatisticsDto(registeredUsers,messages,activeUserQuantity);
    }

}
