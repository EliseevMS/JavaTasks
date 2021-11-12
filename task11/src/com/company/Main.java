package com.company;
import com.company.Lot;
import com.company.User;
import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Lot lot = new Lot(LocalDateTime.now().plusSeconds(2));
        User user1 = new User("Max", lot);
        User user2 = new User("Bob", lot);
        User user3 = new User("Jenya", lot);
        User user4 = new User("Willi",lot);
        User user5 = new User("Kate",lot);

        lot.start();
        Thread.sleep(1);
        user1.start();
        user2.start();
        user3.start();
        user4.start();
        user5.start();

    }
}