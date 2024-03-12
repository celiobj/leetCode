
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.

Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.

Return any permutation of s that satisfies this property.

 

Example 1:

Input:  order = "cba", s = "abcd" 

Output:  "cbad" 

Explanation: "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c", "b", and "a".

Since "d" does not appear in order, it can be at any position in the returned string. "dcba", "cdba", "cbda" are also valid outputs.

Example 2:

Input:  order = "bcafg", s = "abcd" 

Output:  "bcad" 

Explanation: The characters "b", "c", and "a" from order dictate the order for the characters in s. The character "d" in s does not appear in order, so its position is flexible.

Following the order of appearance in order, "b", "c", and "a" from s should be arranged as "b", "c", "a". "d" can be placed at any position since it's not in order. The output "bcad" correctly follows this rule. Other arrangements like "bacd" or "bcda" would also be valid, as long as "b", "c", "a" maintain their order.

 

Constraints:

1 <= order.length <= 26
1 <= s.length <= 200
order and s consist of lowercase English letters.
All the characters of order are unique.

https://leetcode.com/problems/custom-sort-string/description/

*/
package problems;

import java.util.Arrays;
import java.util.HashMap;

/**
 *
 * @author celio.junior
 */
public class customSortString {

    public String customSortString(String order, String s) {
        int sSize = s.length();
        String retorno = "";
        String sobra = "";
        HashMap<Integer, String> ordem = new HashMap();
        for (int i = 0; i < order.length(); i++) {
            ordem.put(i, Character.toString(order.charAt(i)));
        }
        int indice = 0;
        do {

            String posicao = ordem.get(indice);
            if (posicao != null && s.contains(posicao)) {
                do {
                    retorno = retorno + posicao;
                    s = s.replaceFirst(posicao, "");
                } while (s.contains(posicao));
            } else {
                if (posicao != null) {
                    s = s.isEmpty() ? "" : s.replaceFirst(posicao, "");
                } else {
                    sobra = sobra + s;
                    s = "";
                }
            }
            sSize = s.length();
            indice++;
        } while (sSize >= 1);
        return retorno + sobra;
    }

    public static void main(String[] ars) {
        customSortString ts = new customSortString();

        String order = "cba";
        String s = "abcd";
//        String order = "bcafg";
//        String s = "abcd";
//        String order = "kqep";
//        String s = "pekeq";
//        String order = "bcafg";
//        String s = "abcd";

        System.out.println(ts.customSortString(order, s));
    }

}
