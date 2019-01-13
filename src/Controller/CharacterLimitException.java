/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

/**
 *
 * @author Hélio
 */
public class CharacterLimitException extends Exception
{
    @Override
    public String getMessage()
    {
        return "Limite de caracters excedido!";
    }     
}
