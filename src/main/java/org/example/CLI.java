package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class CLI {
    public static void main(String[] args) {
        PlayerRole current = PlayerRole.SERVER;
        System.out.println("Actual: " + current);

        current = PlayerRole.nextRole(current);
        System.out.println("Siguiente: " + current);

        current = PlayerRole.nextRole(current);
        System.out.println("Siguiente: " + current); // Debe volver a SERVER
    }
}