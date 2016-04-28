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
	private int pevento1 = 0;
	private int pevento2 = 0;
	private int vez = 1;
	private boolean acabou = false;
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
			if (vez == 1){
				atual2.setHP(atual2.getHP() - atual1.getAtaque(pataque1));
				if (pataque1 == 3) pevento1 = 1;
				if (atual2.getHP() <= 0) pevento1 = 2;
				vez = 0;
			}
			else {
				atual1.setHP(atual1.getHP() - atual2.getAtaque(pataque2));
				if (pataque2 == 3) pevento2 = 1;
				if (atual1.getHP() <= 0) pevento2 = 2;
				vez = 1;
			}
		}
		public String description(){
			if (vez == 1){
				vez = 0;
				return "O pokemon " + atual1.getNomePokemon()+ " do jogador " + jogador1.getNome() + " utilizou o ataque: " + atual1.getNomeAtaque(pataque1);
			}
			else{
				vez = 1;
				return "O pokemon " + atual2.getNomePokemon()+ " do jogador " + jogador2.getNome() + " utilizou o ataque: " + atual2.getNomeAtaque(pataque2);
			}
		}
	}
	
	private class recuperaHP extends Event{
		public recuperaHP (long eventTime) {
			super (eventTime);
		}
		public void action(){
			if (vez == 1){
				atual1.setHP(atual1.getHP() + 50);
				pevento1 = 0;
				pataque1 = 0;
				vez = 0;
			}
			else{
				atual2.setHP(atual2.getHP() + 50);
				pevento2 = 0;
				pataque2 = 0;
				vez = 1;
			}
		}
		public String description(){
			if (vez == 1){
				vez = 0;
				return "O pokemon " + atual1.getNomePokemon()+ " do jogador " + jogador1.getNome() + " recuperou 50 HP";
			}
			else{
				vez = 1;
				return "O pokemon " + atual2.getNomePokemon()+ " do jogador " + jogador2.getNome() + " recuperou 50 HP";
			}
				
		}
	}
	
	private class trocaPokemon extends Event{
		public trocaPokemon (long eventTime) {
			super (eventTime);
		}
		public void action(){
			if (vez == 1){
				if (ppokemon1 <=5){
					ppokemon1++;
					atual1 = jogador1.getPokemon(ppokemon1);
					pevento1 = 0;
					pataque1 = 0;
					vez = 0;
				}
				else{
					acabou = true;
					ganhador = 2;
				}
			}
			else{
				if (ppokemon2 <= 5){
					ppokemon2++;
					atual2 = jogador2.getPokemon(ppokemon2);
					pevento2 = 0;
					pataque2 = 0;
					vez = 1;
				}
				else{
					acabou = true;
					ganhador = 1;
				}
			}
		}
		public String description(){
			if (vez == 1){
				if (ppokemon1 <= 5){
					vez=0;
					return jogador1.getNome() + " trocou o pokemon para: " + atual1.getNomePokemon();
				}	
				else{
					return "A batalha acabou. Ganhador é o jogador 2.";
				}
					
			}
			else{
				if (ppokemon2 <= 5){
					vez=1;
					return jogador2.getNome() + " trocou o pokemon para: " + atual2.getNomePokemon();
				}
					
				else
					return "A batalha acabou.Ganhador é o jogador 1.";
			}
		}
	}
	
	private class fugir extends Event{
		public fugir (long eventTime) {
			super (eventTime);
		}
		public void action(){
			if (vez == 1)
				ganhador = 2;
			else
				ganhador = 1;
			acabou = true;
		}
		public String description() {
			if (vez == 1)
					return "A batalha acabou. Jogador 1 fugiu, logo o ganhador e o jogador 2.";
			else
					return "A batalha acabou. Jogador 2 fugiu, logo o ganhador e o jogador 1.";
		}
	}
	public static void main (String[] args){
		Controller admin = new Controller();
		MestrePokemon jog1 = new MestrePokemon("Ash");
		MestrePokemon jog2 = new MestrePokemon("TrAsh");
		PokemonRed game = new PokemonRed(jog1, jog2);
		for(int i = 0; i < 100; i++){
			admin.addEvent(game.new atacar(1000));
			admin.addEvent(game.new trocaPokemon(1000));
		}
		admin.run();
	}
}
