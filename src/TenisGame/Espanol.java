/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TenisGame;

/**
 *
 * @author SOLECITO
 */
public class Espanol implements Idioma{
    @Override
    public String getZero(){
        return "Cero";
    }

    @Override
    public String getFifteen() {
        return "Quince";
    }

    @Override
    public String getThirty() {
        return "Treinta";
    }

    @Override
    public String getForty() {
        return "Cuarenta";
    }

    @Override
    public String getAll() {
        return "Iguales";
    }

    @Override
    public String getDeuce() {
        return "Empate";
    }

    @Override
    public String getAdvantage() {
        return "Ventaja para";
    }

    @Override
    public String getWin() {
        return "Gana";
    }
    
    @Override
    public String getPlayer() {
        return "Jugador";
    }
}