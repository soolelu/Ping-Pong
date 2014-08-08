/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TenisGame;

/**
 *
 * @author SOLECITO
 */
public class Aleman implements Idioma{
    @Override
    public String getZero(){
        return "Liebe";
    }

    @Override
    public String getFifteen() {
        return "Vierzig";
    }

    @Override
    public String getThirty() {
        return "Dreibig";
    }

    @Override
    public String getForty() {
        return "Fünfzehn";
    }

    @Override
    public String getAll() {
        return "Alle";
    }

    @Override
    public String getDeuce() {
        return "Ziehen";
    }

    @Override
    public String getAdvantage() {
        return "Vorteil für";
    }

    @Override
    public String getWin() {
        return "Gewinnt";
    }
    
    @Override
    public String getPlayer() {
        return "Spieler";
    }
}
