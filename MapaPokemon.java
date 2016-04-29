package events_controller;
import basics.*;

public class MapaPokemon extends Controller{
	private MestrePokemon jogador1;
	private MestrePokemon jogador2;
	private Pokemon atual1;
	private Pokemon atual2;
	private int pataque1 = 0;
	private int pataque2 = 0;
	private int ppokemon1 = 0;
	private int ppokemon2 = 0;
	private int rodada = 0;
	private static boolean aparecer = false;
	private static boolean acabou = false;
	private static boolean fimDeJogo = false;
	private static boolean batalha = false;
	private int posjogador[] = {0,0};
	private int map1[][]= {{0,0,1,1,1,1,0,0,0,0},
			               {0,1,1,1,0,0,0,0,1,1},
			               {0,0,1,1,0,0,0,0,0,0},
			               {0,0,0,1,1,1,1,0,0,1},
			               {1,1,1,0,0,0,0,0,0,0},
			               {1,1,0,0,1,1,0,0,1,1},
			               {0,0,1,1,0,0,0,0,0,0},
			               {0,0,0,1,1,1,1,0,0,1},
			               {0,1,1,1,0,0,0,0,1,1},
			               {0,0,1,1,1,1,1,0,0,0}};
	

	static MestrePokemon jog1 = new MestrePokemon("Ash");
	static MestrePokemon CPU1 = new MestrePokemon("TrAsh");
	static MestrePokemon CPU2 = new MestrePokemon("Pikachu");
	static MestrePokemon CPU3 = new MestrePokemon("Abra");
	static MestrePokemon CPU4 = new MestrePokemon("Onix");
	MestrePokemon jog2;
	
	public MapaPokemon (MestrePokemon jog1){
		jogador1 = jog1;
		atual1 = jogador1.getPokemon(ppokemon1);
	}
	
	private class atacarPokemon extends Event{
		public atacarPokemon (long eventTime) {
			super (eventTime);
		}
		public void action(){
			if (atual2.getNomePokemon() == "Pikachu" && aparecer == true){
				System.out.println("\nUm Pikachu selvagem surgiu!!!");
				aparecer = false;
			}
			else if (atual2.getNomePokemon() == "Abra" & aparecer == true){
				System.out.println("\nUm Abra selvagem surgiu!!!");
				aparecer = false;
			} 
			else {
				if(aparecer == true){
					System.out.println("\nUm Onix selvagem surgiu!!!");
					aparecer = false;
				}
			}
			if (rodada%2 == 0 && getIndex() < 99){
				atual2.setHP(atual2.getHP() - atual1.getAtaque(pataque1));
				if(pataque1 < 3) pataque1++;
				else pataque1 = 0;
				if (atual2.getHP() <= 0){ 
					atual2.setHP(0);
					acabou = true; 
					batalha = false;
				}
			}
			else if (rodada%2 == 1 && getIndex() < 99){
				atual1.setHP(atual1.getHP() - atual2.getAtaque(pataque2));
				if(pataque2 < 3) pataque2++;
				else pataque2 = 0;
				if (atual1.getHP() > 0 && atual1.getHP() < 60) addEvent (new recuperaHP(1000));
				if (atual1.getHP() <= 0){
					atual1.setHP(0);
					addEvent (new trocaPokemon(1000));
				}
			}
			else addEvent (new fugir(1000));
		}
		public String description(){
			if (rodada%2 == 0 && atual2.getHP() > 0){
				rodada ++;
				if (pataque1 > 0){
					return "\nO pokemon " + atual1.getNomePokemon()+ " do jogador " + jogador1.getNome() + " utilizou o ataque: " + atual1.getNomeAtaque(pataque1 - 1) + "(" + atual1.getAtaque(pataque1 - 1) +")\n"
							+ atual1.getNomePokemon() + "\nHP: " + atual1.getHP() + "\n" + atual2.getNomePokemon() + "\nHP: " + atual2.getHP() ;
				}
				else
					return "\nO pokemon " + atual1.getNomePokemon()+ " do jogador " + jogador1.getNome() + " utilizou o ataque: " + atual1.getNomeAtaque(3) + "(" + atual1.getAtaque(3) +")\n"
							+ atual1.getNomePokemon() + "\nHP: " + atual1.getHP() + "\n" + atual2.getNomePokemon() + "\nHP: " + atual2.getHP() ;
				
			}
			else if (rodada%2 == 0 && atual2.getHP() <= 0){
				rodada ++;
				if (pataque1 > 0){
					return "\nO pokemon " + atual1.getNomePokemon()+ " do jogador " + jogador1.getNome() + " utilizou o ataque: " + atual1.getNomeAtaque(pataque1 - 1) + "(" + atual1.getAtaque(pataque1 - 1) +")\n"
							+ atual1.getNomePokemon() + "\nHP: " + atual1.getHP() + "\n" + atual2.getNomePokemon() + "\nHP: " + atual2.getHP()
							+"\nO pokemon " +atual2.getNomePokemon() + " foi derrotado";
				}
				else
					return "\nO pokemon " + atual1.getNomePokemon()+ " do jogador " + jogador1.getNome() + " utilizou o ataque: " + atual1.getNomeAtaque(3) + "(" + atual1.getAtaque(3) +")\n"
							+ atual1.getNomePokemon() + "\nHP: " + atual1.getHP() + "\n" + atual2.getNomePokemon() + "\nHP: " + atual2.getHP()
							+"\nO pokemon " +atual2.getNomePokemon() + " foi derrotado";
				
			}
			else {
				rodada ++;
				if (pataque2 > 0){
					return "\nO pokemon " + atual2.getNomePokemon()+ " utilizou o ataque: " + atual2.getNomeAtaque(pataque2 - 1) + "(" + atual2.getAtaque(pataque2 - 1) +")\n"
							+ atual1.getNomePokemon() + "\nHP: " + atual1.getHP() + "\n" + atual2.getNomePokemon() + "\nHP: " + atual2.getHP() ;
				}
				else
					return "\nO pokemon " + atual2.getNomePokemon()+ " utilizou o ataque: " + atual2.getNomeAtaque(3) + "(" + atual2.getAtaque(3) +")\n"
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
				atual1.setHP(atual1.getHP() + 50);
			}
			else addEvent(new fugir(1000));
		}
		public String description(){
				rodada ++;
				return "\nO pokemon " + atual1.getNomePokemon()+ " do jogador " + jogador1.getNome() + " recuperou 50 HP";
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
					batalha = false;
					acabou = true;
					ppokemon1++;
				}
			}
			else addEvent(new fugir(1000));
		}
		public String description(){
			if (ppokemon1 <= 5){
				rodada ++;
				return "\n" + jogador1.getNome() + " trocou o pokemon para: " + atual1.getNomePokemon();
			}	
			else{
				rodada ++;
				fimDeJogo = true;
				return "\nAcabaram seus pokemons, voce perdeu";
			}
		}
	}
	
	private class fugir extends Event{
		public fugir (long eventTime) {
			super (eventTime);
		}
		public void action(){
			if (rodada%2 == 0){
				acabou = true;
			}
			else{
				acabou = true;
			}
		}
		public String description() {
			if (rodada%2 == 0){
				rodada ++;
				return "\nA batalha acabou. Jogador 1 fugiu, logo o ganhador e o jogador 2.";
			}
			else{
				rodada ++;
				return "\nA batalha acabou. Jogador 2 fugiu, logo o ganhador e o jogador 1.";
			}
		}
	}
	
	private class andar extends Event{
		double decisao = Math.random();
		boolean moveu = false;
		public andar (long eventTime) {
			super (eventTime);
		}
		public void action(){
			
			if (decisao >= 0 && decisao < 0.25){ //NORTE
				if (posjogador[1] > 0){
					posjogador[1]--;
					moveu = true;
				}
			}
			else if (decisao >= 0.25 && decisao < 0.5){ //SUL
				if (posjogador[1] < 9){
					posjogador[1]++;
					moveu = true;
				}
			}
			else if (decisao >= 0.5 && decisao < 0.75){ //LESTE
				if (posjogador[0] < 9){
					posjogador[0]++;
					moveu = true;
				}
			}
			else{ //OESTE
				if (posjogador[0] > 0){
					posjogador[0]--;
					moveu = true;
				}
			}
			
			if (map1[posjogador[0]][posjogador[1]] == 1){
				double decisao2 = Math.random();
				if (decisao2 >= 0 && decisao2 < 0.5/3){
					jog2 = jogador2 = new MestrePokemon("Abra");
					atual2 = jogador2.getPokemon(ppokemon2);
					batalha = true;
					aparecer = true;
				}
				if (decisao2 >= 0.5/3 && decisao2 < 1.0/3){
					jog2 = jogador2 = new MestrePokemon("Pikachu");
					atual2 = jogador2.getPokemon(ppokemon2);
					batalha = true;
					aparecer = true;
				}
				if (decisao2 >= 1.0/3 && decisao2 < 1.5/3){
					jog2 = jogador2 = new MestrePokemon("Onix");
					atual2 = jogador2.getPokemon(ppokemon2);
					batalha = true;
					aparecer = true;
				}
			}
		}
		public String description()	{
			printMap();
			if (decisao >= 0 && decisao < 0.25){ //NORTE
				if (moveu == true)
					return "\nAndou uma casa para o norte";
				else return "\nNao eh possivel andar nessa direcao";
			}
			else if (decisao >= 0.25 && decisao < 0.5) //SUL
				if (moveu == true)
					return "\nAndou uma casa para o sul";
				else return "\nNao eh possivel andar nessa direcao";
			else if (decisao >= 0.5 && decisao < 0.75) //LESTE
				if (moveu == true)
					return "\nAndou uma casa para o leste";
				else return "\nNao eh possivel andar nessa direcao";
			else //OESTE
				if (moveu == true)
					return "\nAndou uma casa para o oeste";
				else return "\nNao eh possivel andar nessa direcao";
		}
	}
	
	public void printMap (){
		for(int i = 0; i < 9; i++){
			System.out.print("\n -----------------------------------------------------------------------\n ");
			for(int j = 0; j < 9; j++){
				if(posjogador[1] == i && posjogador[0] == j){
					System.out.print("**ASH** ");
				}
				else if(map1[i][j] == 0){
					System.out.print("|TERRA| ");
				}
				else if (map1[i][j] == 1){
					System.out.print("|GRAMA| ");
				}
			}
		}
		System.out.print("\n -----------------------------------------------------------------------\n ");
	}
	
	public static void main (String[] args){
		MapaPokemon jogo = new MapaPokemon(jog1);
		long tm = System.currentTimeMillis();
		
		while(jogo.getIndex() < 100 && fimDeJogo == false){
			if (batalha == false)
				jogo.addEvent(jogo.new andar(1000));
			else
				jogo.addEvent(jogo.new atacarPokemon(1000));
				jogo.run();
		}
	}
}

