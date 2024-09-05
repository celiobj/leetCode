/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RocketLawer;

import java.util.ArrayList;

/**
 *
 * @author celio.junior
 */
public class MovingTotal {

    /**
     * Adds/appends list of integers at the end of internal list.
     */
    ArrayList<Integer> totals = new ArrayList();
    ArrayList<Integer> container = new ArrayList();

    public void append(int[] list) {

        for (int i = 0; i < list.length; i++) {
            int size = list.length;
            boolean times = size - 3 > 0;
            if (times) {
                int one = list[i];
                int two = list[i + 1];
                int three = list[i + 2];
                totals.add(one + two + three);
                size = size -1;
            }
        }
        for (int i = 0; i < list.length; i++) {
            container.add(list[i]);
        }
    }

    /**
     * Returns boolean representing if any three consecutive integers in the
     * internal list have given total.
     */
    public boolean contains(int total) {
        for (int i = 0; i < totals.size(); i++) {
            if (totals.get(i).equals(total)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        MovingTotal movingTotal = new MovingTotal();

        movingTotal.append(new int[]{1, 2, 3, 4});

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));

        movingTotal.append(new int[]{5});

        System.out.println(movingTotal.contains(6));
        System.out.println(movingTotal.contains(9));
        System.out.println(movingTotal.contains(12));
        System.out.println(movingTotal.contains(7));
    }
}
