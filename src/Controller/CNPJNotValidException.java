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
public class CNPJNotValidException extends Exception
{
    @Override
    public String getMessage()
    {
        return "O CNPJ informado não é um CNPJ válido!";
    }
    
}
