package com.company;

import java.time.LocalDateTime;

public class Lot extends Thread{

    private volatile Double currentPrice = 0.0;

    private volatile String winnerName = "Никто не выиграл";

    private LocalDateTime endOfAuctionTime;

    public Lot(LocalDateTime endOfAuctionTime) {
        this.endOfAuctionTime = endOfAuctionTime;
    }

    @Override
    public void run() {
        while (LocalDateTime.now().isBefore(endOfAuctionTime)) {

        }
        this.interrupt();
        System.out.println("Победитель - " +winnerName + " : " + currentPrice);
    }

    public synchronized void setCurrentPriceAndName(double price, String name) throws InterruptedException {
        {
            if (price > currentPrice || !this.isAlive()) {
                currentPrice = price;
                winnerName = name;
                System.out.println(name + " поставил ставку: " + price);
            }
        }
    }

    public LocalDateTime getEndOfAuction() {
        return endOfAuctionTime;
    }

    public synchronized Double getCurrentPrice() {
        return currentPrice;
    }
}