package org.example;

public class TransformString {
    public static void main(String[] args) {
        String lotteryTicket = " 100 usd";
        String result = lotteryTicket
                .replaceAll("[a-z]"," ")
                .strip();

        String res1 = formatNumber(result);
        System.out.println(res1);

        // use transform instead placeholder result and res1 creation
        String res2 = lotteryTicket
                .replaceAll("[a-z]"," ")
                .strip()
                .transform(TransformString::formatNumber);
        System.out.println(res2);
        
    }

    private static String formatNumber(String number){
        if (Integer.parseInt(number)>100){
            return "Nice! You have won: " + number;
        } else {
            return "Great news! You've won: " + number;
        }
    }
}
