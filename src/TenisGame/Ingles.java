/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TenisGame;

/**
 *
 * @author SOLECITO
 */
public class Ingles implements Idioma{
    @Override
    public String getZero(){
        return "Love";
    }

    @Override
    public String getFifteen() {
        return "Fifteen";
    }

    @Override
    public String getThirty() {
        return "Thirty";
    }

    @Override
    public String getForty() {
        return "Forty";
    }

    @Override
    public String getAll() {
        return "All";
    }

    @Override
    public String getDeuce() {
        return "Deuce";
    }

    @Override
    public String getAdvantage() {
        return "Advantage for";
    }

    @Override
    public String getWin() {
        return "Wins";
    }
    
    @Override
    public String getPlayer() {
        return "Player";
    }
}