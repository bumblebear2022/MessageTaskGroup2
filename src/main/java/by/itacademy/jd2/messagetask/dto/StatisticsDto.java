package by.itacademy.jd2.messagetask.dto;

public class StatisticsDto {
    int registeredUsers;
    int activeUsers;
    int messageQuantity;

    public StatisticsDto(int registeredUsers, int activeUsers, int messageQuantity) {
        this.registeredUsers = registeredUsers;
        this.activeUsers = activeUsers;
        this.messageQuantity = messageQuantity;
    }

    public int getRegisteredUsers() {
        return registeredUsers;
    }

    public int getActiveUsers() {
        return activeUsers;
    }

    public int getMessageQuantity() {
        return messageQuantity;
    }
}
