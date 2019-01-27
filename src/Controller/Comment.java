/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.MetodosAcesso;
import java.sql.SQLException;

/**
 *
 * @author Marcos
 */
public class Comment
{
    private String comment;
    private int note;

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the note
     */
    public int getNote() {
        return note;
    }

    /**
     * @param note the note to set
     */
    public void setNote(int note) {
        this.note = note;
    }
    
    public boolean addComment(Comment comment, int hotel_id, int user_id) throws SQLException
    {
        MetodosAcesso mtd = new MetodosAcesso();
        return mtd.addComment(comment, hotel_id, user_id);
    }
}
