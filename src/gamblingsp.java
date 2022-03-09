package com.blz.gambler;

public class Gambler {
    public static final int STAKE=100; // Gambler with the stake
    public static final int BET=1; // Bet value per game
    public static final int PERCENTAGE_50_STAKE=(STAKE/100)*50; // 50% of stake value
    public static final int HIGH_LIMIT=STAKE+PERCENTAGE_50_STAKE;
    public static final int LOW_LIMIT=STAKE-PERCENTAGE_50_STAKE;
    public static final int START_DAY=1;
    public static final int DAYS_IN_MONTH=30;
    public static final int STAKES_PER_DAY=50;
    public static final int START_DOLLARS=0;
    public static String checkWon="won";

    public static void main(String[] args) {
        System.out.println("Welcome to the Gambler Game");
        while (checkWon.equals("won")) {
            checkWon = getGame(checkWon);
            if(checkWon.equals("lost")) {
                System.out.println("Would like to stop Gambling");
            } else {
                System.out.println("Would like to Gamble again");
            }
        }
    }
    private static String getGame(String check){
        int days = START_DAY;
        int totalDollars = START_DOLLARS;

        //for a month,To know gambler's stakes each day
        for (days = START_DAY; days <= DAYS_IN_MONTH; days++) {
            int totalStake = STAKE;

            //Gambler should either earn 150 or loose 50
            while (totalStake < HIGH_LIMIT && totalStake > LOW_LIMIT) {
                //initialising game value by random number
                int luck = (int) (Math.random() * 10) % 2;
                if (luck == 1) {
                    totalStake = totalStake + BET; //Stake will increase as gambler wins the bet
                } else {
                    totalStake = totalStake - BET; //Stake will decrease as gambler lost the bet
                }
            }
            if (totalStake == HIGH_LIMIT) {
                totalDollars += STAKES_PER_DAY;
                System.out.println("Gambler won by " +totalDollars+" dollars on day "+days);
            } else {
                totalDollars -= STAKES_PER_DAY;
                System.out.println("Gambler lost by " +totalDollars+" dollars on day "+days);
            }
        }
        if(totalDollars>=START_DOLLARS){
            check="won";
            System.out.println("Gambler won " +totalDollars);
        } else {
            check="lost";
            System.out.println("Gambler lost " + totalDollars);
        }
        return check;
    }
}
