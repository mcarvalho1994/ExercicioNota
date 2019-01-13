/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Marcos Carvalho
 */
public class ComboMultiData
{
    private int value;
    private String text;
    
    public ComboMultiData(int id, String label) {
        this.value = id;
        this.text = label;
    }
    public int getValue() {
        return value;
    }
    @Override
    public String toString() {
        return text;
    }
}
