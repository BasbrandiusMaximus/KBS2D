// Algoritme gebaseerd op https://www.geeksforgeeks.org/print-all-combinations-of-given-length/
package Applicatie;

import java.util.ArrayList;

public class Combinaties {
    public static ArrayList<String> combinaties = new ArrayList<>();

    public static ArrayList<String> getCombinaties()
    {
        return combinaties;
    }

    static void wrapCombinaties(char[] set, int k)
    {
        int n = set.length;
        getCombinaties(set, "", n, k);
    }

    // Recursie
    static void getCombinaties(char[] set, String prefix, int n, int k)
    {
        if (k == 0)
        {
            combinaties.add(prefix);
            return;
        }

        for (int i = 0; i < n; ++i)
        {

            String newPrefix = prefix + set[i];

            combinaties.add(newPrefix);
            getCombinaties(set, newPrefix, n, k - 1);
        }
    }
}
