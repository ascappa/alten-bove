package com.alten.probability;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Probability {
    public static void main(String[] args) {
        HashMap<String, Integer> occurrences = new HashMap<>();
        occurrences.put("🦁", 0);
        occurrences.put("🐯", 0);
        occurrences.put("🦅", 0);
        for (int i = 0; i < 100; i++) {
            // full:   ----------
            // leone:  xx--------
            // tigre:  **xxx-----
            // aquila: -----xxxxx
            double randomNumber = Math.random();
            if (randomNumber < 0.2) {
                occurrences.computeIfPresent("🦁", (k, v) -> v + 1);
            } else if (randomNumber < 0.5) {
                occurrences.computeIfPresent("🐯", (k, v) -> v + 1);
            } else {
                occurrences.computeIfPresent("🦅", (k, v) -> v + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : occurrences.entrySet()) {
            System.out.println(entry.getKey() + ": " + "-".repeat(entry.getValue()) + " " + entry.getValue());
        }
    }
}
