/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TenisGame;

/**
 *
 * @author SOLECITO
 */
public class Frances implements Idioma{
    @Override
    public String getZero(){
        return "Zero";
    }

    @Override
    public String getFifteen() {
        return "Quinze";
    }

    @Override
    public String getThirty() {
        return "Trente";
    }

    @Override
    public String getForty() {
        return "Quarente";
    }

    @Override
    public String getAll() {
        return "Á";
    }

    @Override
    public String getDeuce() {
        return "Égalité";
    }

    @Override
    public String getAdvantage() {
        return "Avantage pour";
    }

    @Override
    public String getWin() {
        return "Désir";
    }
    
    @Override
    public String getPlayer() {
        return "Joueur";
    }
}