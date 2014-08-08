/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package TenisGame;

/**
 *
 * @author SOLECITO
 */
public class Puntos {
        public int ScoreP1 = 0;
	public int ScoreP2 = 0;
        public Idioma idioma = new Espanol();
        public String jugador1;
        public String jugador2;
        
        //Jugadores player = new Jugadores();
        
    public void puntoP1() {
        ScoreP1++;
    }

    public void puntoP2() {
        ScoreP2++;
    }
    
    public String score() {
                if (ganador()) {
			return getIdioma().getWin()+" "+MarcadorMasAlto();
		}

		if (TieneVentaja()) { 
			return getIdioma().getAdvantage() +" "+MarcadorMasAlto(); 
		}

		if (Empate())
			return getIdioma().getDeuce();

		if(ScoreP1 == ScoreP2) {
			return CambiaScore(ScoreP1) +" "+getIdioma().getAll();
		}
                return CambiaScore(ScoreP1) + " - " + CambiaScore(ScoreP2);
	}
    
       public boolean Empate() {
		return ScoreP1 >= 3 && ScoreP2 == ScoreP1;
	}

	public String MarcadorMasAlto() {
		if (ScoreP1 > ScoreP2) {
			return /*player.jTextField1.getText();//+getIdioma().getPlayer()+ " 1";*/jugador1;
		} else {
			return /*player.jTextField2.getText();//+getIdioma().getPlayer()+ " 2";*/jugador2;
		}
	}

	public boolean ganador() {
		if(ScoreP2 >= 4 && ScoreP2 >= ScoreP1 + 2 )
			return true;
		if(ScoreP1 >= 4 && ScoreP1 >= ScoreP2 + 2)
			return true;
		return false;
	}

	public boolean TieneVentaja() {
		if (ScoreP2 >= 4 && ScoreP2 == ScoreP1 + 1)
			return true;
		if (ScoreP1 >= 4 && ScoreP1 == ScoreP2 + 1)
                    return true;
		return false;
	}
       public String CambiaScore(int score) {
           switch (score) {
		case 3:
			return getIdioma().getForty();
		case 2:
			return getIdioma().getThirty();
		case 1: 
			return getIdioma().getFifteen();
		case 0:
			return getIdioma().getZero();
            }
		throw new IllegalArgumentException("Illegal score: " + score);
        }
       
       public void setIdioma(Idioma idioma){
            this.idioma= idioma;
        }
        public Idioma getIdioma(){
            return idioma;
            
        }    
}