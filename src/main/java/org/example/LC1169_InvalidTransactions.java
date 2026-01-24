package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC1169_InvalidTransactions {

    class Transaction {
        String name;
        int time;
        int amount;
        String city;
        public Transaction(String line){
            String[] split = line.split(",");
            name = split[0];
            time = Integer.parseInt(split[1]);
            amount = Integer.parseInt(split[2]);
            city = split[3];
        }
    }
    public static void main(String[] args) {
        LC1169_InvalidTransactions prog = new LC1169_InvalidTransactions();
        String[] transactions = new String[]{"alice,20,800,mtv","alice,50,100,beijing"};
        System.out.println(" Invalid Transactions 0 >> " + prog.invalidTransactions(transactions));

        String[] transactions1 = new String[]{"alice,20,800,mtv","alice,50,1200,mtv"};
        System.out.println(" Invalid Transactions 1 >> " + prog.invalidTransactions(transactions1));

        String[] transactions2 = new String[]{"alice,20,800,mtv","bob,50,1200,mtv"};
        System.out.println(" Invalid Transactions 2 >> " + prog.invalidTransactions(transactions2));
    }

    public List<String>  invalidTransactions(String[] arr) {
        List<String> invalid = new ArrayList<>();
        Map<String, List<Transaction>> map = new HashMap<>();

        for(String transaction : arr){
            Transaction t= new Transaction(transaction);
            map.putIfAbsent(t.name, new ArrayList<>());
            map.get(t.name).add(t);
        }

        for(String transaction : arr ){
            Transaction t = new Transaction(transaction);
            if(!isValid(t, map.getOrDefault(t.name, new ArrayList<>()))){
                invalid.add(transaction);
            }
        }

        return invalid;

    }

    public boolean isValid(Transaction t, List<Transaction> list){
        if(t.amount > 1000){
            return false;
        }

        for(Transaction ta : list){
            if(Math.abs(ta.time - t.time) <= 60 && !ta.city.equals(t.city)){
                return false;
            }
        }

        return true;
    }
}
