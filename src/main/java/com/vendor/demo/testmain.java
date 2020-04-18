package com.vendor.demo;

import java.util.*;
import java.util.stream.Collectors;

public class testmain {

    public static List<String> popularNFeatures(int numFeatures,
                                                int topFeatures,
                                                List<String> possibleFeatures,
                                                int numFeatureRequests,
                                                List<String> featureRequests) {
        if (numFeatures == 0 || numFeatureRequests == 0) return new ArrayList<>();

        Map<String, Integer> mapOfFeatures = new HashMap<>(numFeatures);
        for (String feature : possibleFeatures) {
            for (String request : featureRequests) {
                if (request.toLowerCase().contains(feature.toLowerCase())) {
                    if (!mapOfFeatures.containsKey(feature)) {
                        mapOfFeatures.put(feature, 1);
                    } else {
                        int num = mapOfFeatures.get(feature);
                        mapOfFeatures.put(feature, num + 1);
                    }
                }
            }
        }
        System.out.println(mapOfFeatures);

        return topOfFeatures(mapOfFeatures, topFeatures);
    }

    private static ArrayList<String> topOfFeatures(Map<String, Integer> mapOfFeatures, int topFeatures) {
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(mapOfFeatures.entrySet());

        Collections.sort(entryList, (a, b) ->
                (b.getValue() - a.getValue()) != 0 ? (b.getValue() - a.getValue()) : a.getKey().compareTo(b.getKey()));

        return (ArrayList<String>) entryList.stream().limit(topFeatures)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {

        int numFeatures = 6;
        int topFeatures = 3;
        List<String> possibleFeatures = Arrays.asList("storage", "battery", "hover", "alexa", "waterproof", "solar");
        int numFeatureRequests = 7;
        List<String> featureRequests = Arrays.asList("I wish my kindle had even more storage",
                "I wish the battery, life on my Kindle lasted 2 years",
                "I read in the bath I would enjoy a waterproof in the kindle",
                "Waterproof and increased BATTERY are my top 2 requests",
                "I wish my kindle was solar charge",
                "I Wish my kindle could have connect with my hover",
                "I wish my kindle had connection with alexa system");
        List<String> result = popularNFeatures(numFeatures, topFeatures, possibleFeatures, numFeatureRequests, featureRequests);
        System.out.println(result);
    }
}
