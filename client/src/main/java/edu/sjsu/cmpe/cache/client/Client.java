package edu.sjsu.cmpe.cache.client;

import java.util.ArrayList;

public class Client {

    public static void main(String[] args) throws Exception {
        System.out.println("Starting Cache Client...");

        ArrayList<String> cacheMachines = new ArrayList<String>();
        cacheMachines.add("http://localhost:3000");
        cacheMachines.add("http://localhost:3001");
        cacheMachines.add("http://localhost:3002");

        ConsistentHash<String> consistentHash = new ConsistentHash<String>(new HashFunction(),3,cacheMachines);

        for (int i=1, j=97; i<=10 && j<=106;i++,j++) {
            CacheServiceInterface cache = new DistributedCacheService(consistentHash.get(i));
            cache.put(i,String.valueOf((char)j));
            System.out.println(i+" => "+String.valueOf((char)j));
        }

        System.out.println("Exiting Cache Client...");

    }
}
