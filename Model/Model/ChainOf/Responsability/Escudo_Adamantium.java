package Model.ChainOf.Responsability;

public class Escudo_Adamantium extends Escudo{

	@Override
	public int usaEscudo(int poderAtaque) {
		int ataqueReduzido = poderAtaque -= poderAtaque * 15/100;
		
		
		if(ataqueReduzido >= 30 && getSucessor() != null) {
			return poderAtaque;
		}else {
			return ataqueReduzido;
		}
	}

}
