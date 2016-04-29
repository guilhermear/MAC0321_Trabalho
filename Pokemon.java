
public class Pokemon extends Ataque{
	private String nome;
	private String tipoPokemon;
	private int nivel;
	private int HP;
	private Ataque ataques[] = new Ataque[4];
	
	public Pokemon(String nome){
		this.nome = nome;
		if (this.nome == "Charmander"){
			this.HP = 310;
			this.tipoPokemon = "Fire";
			this.nivel = 0;
			criaAtaque(this.nivel, this.ataques, this.tipoPokemon);
		}
		if (this.nome == "Squirtle"){
			this.HP = 290;
			this.tipoPokemon = "Water";
			this.nivel = 0;
			criaAtaque(this.nivel, this.ataques, this.tipoPokemon);
		}
		if (this.nome == "Chikorita"){
			this.HP = 250;
			this.tipoPokemon = "Grass";
			this.nivel = 0;
			criaAtaque(this.nivel, this.ataques, this.tipoPokemon);
		}
		if (this.nome == "Pikachu"){
			this.HP = 310;
			this.tipoPokemon = "Eletric";
			this.nivel = 0;
			criaAtaque(this.nivel, this.ataques, this.tipoPokemon);
		}
		if (this.nome == "Abra"){
			this.HP = 230;
			this.tipoPokemon = "Psychic";
			this.nivel = 0;
			criaAtaque(this.nivel, this.ataques, this.tipoPokemon);
		}
		if(this.nome == "Sandslash"){
			this.HP = 270;
			this.tipoPokemon = "Ground";
			this.nivel = 0;
			criaAtaque(this.nivel, this.ataques, this.tipoPokemon);
		}
		if (this.nome == "Jigglypuff"){
			this.HP = 180;
			this.tipoPokemon = "Fairy";
			this.nivel = 0;
			criaAtaque(this.nivel, this.ataques, this.tipoPokemon);
		}
		if (this.nome == "Gengar"){
			this.HP = 230;
			this.tipoPokemon = "Ghost";
			this.nivel = 0;
			criaAtaque(this.nivel, this.ataques, this.tipoPokemon);
		}
		if (this.nome == "Lucario"){
			this.HP = 300;
			this.tipoPokemon = "Normal";
			this.nivel = 0;
			criaAtaque(this.nivel, this.ataques, this.tipoPokemon);
		}
		if (this.nome == "Onix"){
			this.HP = 420;
			this.tipoPokemon = "Rock";
			this.nivel = 0;
			criaAtaque(this.nivel, this.ataques, this.tipoPokemon);
		}
		if (this.nome == "Hitmonchan"){
			this.HP = 320;
			this.tipoPokemon = "Figher";
			this.nivel = 0;
			criaAtaque(this.nivel, this.ataques, this.tipoPokemon);
		}
		if(this.nome == "Trubbish"){
			this.HP = 190;
			this.tipoPokemon = "Poison";
			this.nivel = 0;
			criaAtaque(this.nivel, this.ataques, this.tipoPokemon);
		}
	}
	
	public void setHP (int newHP){
		this.HP = newHP;
	}
	
	public int getHP (){
		return this.HP;
	}
	
	public int getAtaque (int indice){
		return this.ataques[indice].qualAtaque();
	}
	
	public String getNomeAtaque (int indice){
		return this.ataques[indice].qualNomeAtaque();
	}
	
	public String getNomePokemon(){
		return this.nome;
	}
	
	
}
