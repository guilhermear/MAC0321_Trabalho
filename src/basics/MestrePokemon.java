package basics;

public class MestrePokemon {
	private String nome;
	private Pokemon pokemons[] = new Pokemon[6];
	private Pokemon pokemonAtual = new Pokemon("Pikachu");
	
	public MestrePokemon(String nome){
		this.nome = nome;
		if(this.nome == "Ash"){
			pokemons[0] = new Pokemon("Charmander");
			pokemons[1] = new Pokemon("Pikachu");
			pokemons[2] = new Pokemon("Lucario");
			pokemons[3] = new Pokemon("Chikorita");
			pokemons[4] = new Pokemon("Squirtle");
			pokemons[5] = new Pokemon("Hitmonchan");
		}
		if(this.nome == "TrAsh"){
			pokemons[0] = new Pokemon("Abra");
			pokemons[1] = new Pokemon("Sandslash");
			pokemons[2] = new Pokemon("Jigglypuff");
			pokemons[3] = new Pokemon("Gengar");
			pokemons[4] = new Pokemon("Onix");
			pokemons[5] = new Pokemon("Trubbish");
		}
	}
	public Pokemon getPokemon (int indice){
		return pokemons[indice];
	}
	public String getNome(){
		return this.nome;
	}
}
