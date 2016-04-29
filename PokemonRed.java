package events_controller;
import basics.*;

public class PokemonRed extends Controller{
	private MestrePokemon jogador1;
	private MestrePokemon jogador2;
	private Pokemon atual1;
	private Pokemon atual2;
	private int pataque1 = 0;
	private int pataque2 = 0;
	private int ppokemon1 = 0;
	private int ppokemon2 = 0;
	private int rodada = 0;
	private static boolean acabou = false;
	private int ganhador = 1;
	
	public PokemonRed (MestrePokemon jog1, MestrePokemon jog2){
		jogador1 = jog1;
		jogador2 = jog2;
		atual1 = jogador1.getPokemon(ppokemon1);
		atual2 = jogador2.getPokemon(ppokemon2);
	}
	
	private class atacar extends Event{
		public atacar (long eventTime) {
			super (eventTime);
		}
		public void action(){
			if (rodada%2 == 0 && getIndex() < 99){
				atual2.setHP(atual2.getHP() - atual1.getAtaque(pataque1));
				if(pataque1 < 3) pataque1++;
				else pataque1 = 0;
				if (atual2.getHP() > 0 && atual2.getHP() < 70) addEvent (new recuperaHP(1000));
				if (atual2.getHP() <= 0) addEvent (new trocaPokemon(1000));
			}
			else if (rodada%2 == 1 && getIndex() < 99){
				atual1.setHP(atual1.getHP() - atual2.getAtaque(pataque2));
				if(pataque2 < 3) pataque2++;
				else pataque2 = 0;
				if (atual1.getHP() > 0 && atual1.getHP() < 70) addEvent (new recuperaHP(1000));
				if (atual1.getHP() <= 0) addEvent (new trocaPokemon(1000));
			}
			else addEvent (new fugir(1000));
		}
		public String description(){
			if (rodada%2 == 0){
				rodada ++;
				if (pataque1 > 0){
					return "\nO pokemon " + atual1.getNomePokemon()+ " do jogador " + jogador1.getNome() + " utilizou o ataque: " + atual1.getNomeAtaque(pataque1 - 1) + "(" + atual1.getAtaque(pataque1 - 1) +")\n"
							+ atual1.getNomePokemon() + "\nHP: " + atual1.getHP() + "\n" + atual2.getNomePokemon() + "\nHP: " + atual2.getHP() ;
				}
				else
					return "\nO pokemon " + atual1.getNomePokemon()+ " do jogador " + jogador1.getNome() + " utilizou o ataque: " + atual1.getNomeAtaque(3) + "(" + atual1.getAtaque(3) +")\n"
							+ atual1.getNomePokemon() + "\nHP: " + atual1.getHP() + "\n" + atual2.getNomePokemon() + "\nHP: " + atual2.getHP() ;
				
			}
			else{
				rodada ++;
				if (pataque2 > 0){
					return "\nO pokemon " + atual2.getNomePokemon()+ " do jogador " + jogador2.getNome() + " utilizou o ataque: " + atual2.getNomeAtaque(pataque2 - 1) + "(" + atual2.getAtaque(pataque2 - 1) +")\n"
							+ atual1.getNomePokemon() + "\nHP: " + atual1.getHP() + "\n" + atual2.getNomePokemon() + "\nHP: " + atual2.getHP() ;
				}
				else
					return "\nO pokemon " + atual2.getNomePokemon()+ " do jogador " + jogador2.getNome() + " utilizou o ataque: " + atual2.getNomeAtaque(3) + "(" + atual2.getAtaque(3) +")\n"
							+ atual1.getNomePokemon() + "\nHP: " + atual1.getHP() + "\n" + atual2.getNomePokemon() + "\nHP: " + atual2.getHP() ;
				
			}
		}
	}
	
	private class recuperaHP extends Event{
		public recuperaHP (long eventTime) {
			super (eventTime);
		}
		public void action(){
			if (rodada%2 == 0 && getIndex() < 99){
				atual1.setHP(atual1.getHP() + 100);
			}
			else if (rodada%2 == 1 && getIndex() < 99){
				atual2.setHP(atual2.getHP() + 100);
			}
			else addEvent(new fugir(1000));
		}
		public String description(){
			if (rodada%2 == 0){
				rodada ++;
				return "O pokemon " + atual1.getNomePokemon()+ " do jogador " + jogador1.getNome() + " recuperou 100 HP";
			}
			else{
				rodada ++;
				return "O pokemon " + atual2.getNomePokemon()+ " do jogador " + jogador2.getNome() + " recuperou 100 HP";
			}
				
		}
	}
	
	private class trocaPokemon extends Event{
		public trocaPokemon (long eventTime) {
			super (eventTime);
		}
		public void action(){
			if (rodada%2 == 0 && getIndex() < 99){
				if (ppokemon1 < 5){
					ppokemon1++;
					atual1 = jogador1.getPokemon(ppokemon1);
				}
				else{
					acabou = true;
					ganhador = 2;
					ppokemon1++;
				}
			}
			else if (rodada%2 == 1 && getIndex() < 99){
				if (ppokemon2 < 5){
					ppokemon2++;
					atual2 = jogador2.getPokemon(ppokemon2);
				}
				else{
					acabou = true;
					ganhador = 1;
					ppokemon2++;
				}
			}
			else addEvent(new fugir(1000));
		}
		public String description(){
			if (rodada%2 == 0){
				if (ppokemon1 <= 5){
					rodada ++;
					return jogador1.getNome() + " trocou o pokemon para: " + atual1.getNomePokemon();
				}	
				else{
					rodada ++;
					return "A batalha acabou. O ganhador eh o jogador 2.";
				}
					
			}
			else{
				if (ppokemon2 <= 5){
					rodada ++;
					return jogador2.getNome() + " trocou o pokemon para: " + atual2.getNomePokemon();
				}
					
				else
					rodada ++;
					return "A batalha acabou. O ganhador eh o jogador 1.";
			}
		}
	}
	
	private class fugir extends Event{
		public fugir (long eventTime) {
			super (eventTime);
		}
		public void action(){
			if (rodada%2 == 0){
				ganhador = 2;
				acabou = true;
			}
			else{
				ganhador = 1;
				acabou = true;
			}
		}
		public String description() {
			if (rodada%2 == 0){
				rodada ++;
				return "A batalha acabou. Jogador 1 fugiu, logo o ganhador e o jogador 2.";
			}
			else{
				rodada ++;
				return "A batalha acabou. Jogador 2 fugiu, logo o ganhador e o jogador 1.";
			}
		}
	}
	
	public static void main (String[] args){
		MestrePokemon jog1 = new MestrePokemon("Ash");
		MestrePokemon jog2 = new MestrePokemon("TrAsh");
		PokemonRed jogo = new PokemonRed(jog1,jog2);
		long tm = System.currentTimeMillis();
		while (acabou == false && jogo.getIndex() < 100){	
			jogo.addEvent(jogo.new atacar(tm));
			jogo.run();
		}
	}
}
