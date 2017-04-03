package edu.carleton.lyuy;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Finally, Yanhan wrote this print statement!");
        TTT3DMove move1 = new TTT3DMove(1,1,2,'X');
        TTT3DMove move2 = new TTT3DMove(1,1,1,'X');
        System.out.println(move1.equals(move2));
    }
}
