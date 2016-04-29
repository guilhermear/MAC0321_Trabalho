
class Ataque {
	private int poder;
	private int prioridade;
	private String nome;
	public void criaAtaque(int nivel, Ataque vetor[], String tipoPokemon){
		vetor[0] = new Ataque();
		vetor[1] = new Ataque();
		vetor[2] = new Ataque();
		vetor[3] = new Ataque();
		if (tipoPokemon == "Fire"){
			vetor[0].nome = "Scratch";
			vetor[0].poder = nivel*40/100 + 40;
			
			vetor[1].nome = "Ember";
			vetor[1].poder = nivel*40/100 + 60;
			
			vetor[2].nome = "Flame Burst";
			vetor[2].poder = nivel*40/100 + 100;
			
			vetor[3].nome = "FlameThrower";
			vetor[3].poder = nivel*40/100 + 120;
		}
		
		if (tipoPokemon == "Water"){
			vetor[0].nome = "Water Gun";
			vetor[0].poder = nivel*40/100 + 40;
			
			vetor[1].nome = "Bubble";
			vetor[1].poder = nivel*40/100 + 60;
			
			vetor[2].nome = "Water Pulse";
			vetor[2].poder = nivel*40/100 + 100;
			
			vetor[3].nome = "Hydro Pump";
			vetor[3].poder = nivel*40/100 + 120;
		}
		
		if (tipoPokemon == "Grass"){
			vetor[0].nome = "Razor Leaf";
			vetor[0].poder = nivel*40/100 + 40;
			
			vetor[1].nome = "Tackle";
			vetor[1].poder = nivel*40/100 + 60;
			
			vetor[2].nome = "Body Slam";
			vetor[2].poder = nivel*40/100 + 100;
			
			vetor[3].nome = "Solar Beam";
			vetor[3].poder = nivel*40/100 + 120;
		}
		
		if (tipoPokemon == "Eletric"){
			vetor[0].nome = "Thunder Shock";
			vetor[0].poder = nivel*40/100 + 40;
			
			vetor[1].nome = "Electric Ball";
			vetor[1].poder = nivel*40/100 + 60;
			
			vetor[2].nome = "Spark";
			vetor[2].poder = nivel*40/100 + 100;
			
			vetor[3].nome = "Thunder";
			vetor[3].poder = nivel*40/100 + 120;
		}
		
		if (tipoPokemon == "Psychic"){
			vetor[0].nome = "Psyshock";
			vetor[0].poder = nivel*40/100 + 40;
			
			vetor[1].nome = "Psychic";
			vetor[1].poder = nivel*40/100 + 60;
			
			vetor[2].nome = "Dream Eater";
			vetor[2].poder = nivel*40/100 + 100;
			
			vetor[3].nome = "Shadow Ball";
			vetor[3].poder = nivel*40/100 + 120;
		}
		
		if (tipoPokemon == "Ground"){
			vetor[0].nome = "Scratch";
			vetor[0].poder = nivel*40/100 + 40;
			
			vetor[1].nome = "Magnitude";
			vetor[1].poder = nivel*40/100 + 60;
			
			vetor[2].nome = "Dig";
			vetor[2].poder = nivel*40/100 + 100;
			
			vetor[3].nome = "Earthquake";
			vetor[3].poder = nivel*40/100 + 120;
		}
		
		if (tipoPokemon == "Fairy"){
			vetor[0].nome = "Pound";
			vetor[0].poder = nivel*40/100 + 40;
			
			vetor[1].nome = "Round";
			vetor[1].poder = nivel*40/100 + 60;
			
			vetor[2].nome = "Hyper Voice";
			vetor[2].poder = nivel*40/100 + 100;
			
			vetor[3].nome = "Double-Edge";
			vetor[3].poder = nivel*40/100 + 120;
		}
		
		if (tipoPokemon == "Ghost"){
			vetor[0].nome = "Lick";
			vetor[0].poder = nivel*40/100 + 40;
			
			vetor[1].nome = "Shadow Punch";
			vetor[1].poder = nivel*40/100 + 60;
			
			vetor[2].nome = "Dark Pulse";
			vetor[2].poder = nivel*40/100 + 100;
			
			vetor[3].nome = "Hex";
			vetor[3].poder = nivel*40/100 + 120;
		}
		
		if (tipoPokemon == "Normal"){
			vetor[0].nome = "Dragon Pulse";
			vetor[0].poder = nivel*40/100 + 40;
			
			vetor[1].nome = "Metal Sound";
			vetor[1].poder = nivel*40/100 + 60;
			
			vetor[2].nome = "Power-Up Punch";
			vetor[2].poder = nivel*40/100 + 100;
			
			vetor[3].nome = "Extreme Speed";
			vetor[3].poder = nivel*40/100 + 120;
		}
		
		if (tipoPokemon == "Rock"){
			vetor[0].nome = "Rock Throw";
			vetor[0].poder = nivel*40/100 + 40;
			
			vetor[1].nome = "Rock Tomb";
			vetor[1].poder = nivel*40/100 + 60;
			
			vetor[2].nome = "Smack Down";
			vetor[2].poder = nivel*40/100 + 100;
			
			vetor[3].nome = "Stone Edge";
			vetor[3].poder = nivel*40/100 + 120;
		}
		
		if (tipoPokemon == "Figher"){
			vetor[0].nome = "Focus Punch";
			vetor[0].poder = nivel*40/100 + 40;
			
			vetor[1].nome = "Sky Uppercut";
			vetor[1].poder = nivel*40/100 + 60;
			
			vetor[2].nome = "Close Combat";
			vetor[2].poder = nivel*40/100 + 100;
			
			vetor[3].nome = "Mach Punch";
			vetor[3].poder = nivel*40/100 + 120;
		}
		
		if (tipoPokemon == "Poison"){
			vetor[0].nome = "Acid Spray";
			vetor[0].poder = nivel*40/100 + 40;
			
			vetor[1].nome = "Sludge";
			vetor[1].poder = nivel*40/100 + 60;
			
			vetor[2].nome = "Belch";
			vetor[2].poder = nivel*40/100 + 100;
			
			vetor[3].nome = "Gunk Shot";
			vetor[3].poder = nivel*40/100 + 120;
		}
	}
	public int qualAtaque (){
		return this.poder;
	}
	
	public String qualNomeAtaque (){
		return this.nome;
	}
}
