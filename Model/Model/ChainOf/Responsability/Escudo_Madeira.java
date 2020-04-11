package Model.ChainOf.Responsability;

public class Escudo_Madeira extends Escudo{

	@Override
	public int usaEscudo(int poderAtaque) {
		int ataqueReduzido = poderAtaque -= poderAtaque * 5 /100;
	
	
		if(ataqueReduzido >= 30 && getSucessor() != null) {
			getSucessor().usaEscudo(ataqueReduzido);
			return poderAtaque;
		}else {
			return ataqueReduzido;
		}
	}
}
