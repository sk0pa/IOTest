package com.epam.tal5.khalii.IO;

/**
 * Created by Anhelina_Khalii on 29.04.2015.
 */
class AssertDemo {
    static int val = 3;

    // Return an integer.
    static int getnum() {
        return val--;
    }

    public static void main(String args[])
    {
        int n;

        for(int i=0; i < 10; i++) {
            n = getnum();

            assert n > 0; // ���������� ����, ���� n �

            System.out.println("n is " + n);
        }
    }
}

