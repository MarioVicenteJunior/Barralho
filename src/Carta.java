enum Naipes {
	ESPADA, OURO, COPAS, PAUS, JOKER
}

enum Valores {
	A, DOIS, TRES, QUATRO, CINCO, SEIS, SETE, OITO, NOVE, DEZ, J, Q, K
}

public class Carta {
	private final Naipes NAIPE;
	private final Valores VALOR;

	public Carta() {
		NAIPE=Naipes.JOKER;
		VALOR=null;
	}
	public Carta(String naipe, String valor) {
		if (naipe.equalsIgnoreCase(Naipes.COPAS.toString())) {
			NAIPE = Naipes.COPAS;
		} else if (naipe.equalsIgnoreCase(Naipes.ESPADA.toString())) {
			this.NAIPE = Naipes.ESPADA;
		} else if (naipe.equalsIgnoreCase(Naipes.JOKER.toString())) {
			this.NAIPE = Naipes.JOKER;
		} else if (naipe.equalsIgnoreCase(Naipes.OURO.toString())) {
			this.NAIPE = Naipes.OURO;
		} else if (naipe.equalsIgnoreCase(Naipes.PAUS.toString())) {
			this.NAIPE = Naipes.PAUS;
		} else {
			throw new IllegalArgumentException("O valor do naipe é invalido!!!");
		}


		if (valor.equalsIgnoreCase(Valores.A.toString())) {
			VALOR = Valores.A;
		} else if (valor.equalsIgnoreCase(Valores.DOIS.toString())) {
			this.VALOR = Valores.DOIS;
		} else if (valor.equalsIgnoreCase(Valores.TRES.toString())) {
			this.VALOR = Valores.TRES;
		} else if (valor.equalsIgnoreCase(Valores.QUATRO.toString())) {
			this.VALOR = Valores.QUATRO;
		} else if (valor.equalsIgnoreCase(Valores.CINCO.toString())) {
			this.VALOR = Valores.CINCO;
		} else if (valor.equalsIgnoreCase(Valores.SEIS.toString())) {
			this.VALOR = Valores.SEIS;
		} else if (valor.equalsIgnoreCase(Valores.OITO.toString())) {
			this.VALOR = Valores.OITO;
		} else if (valor.equalsIgnoreCase(Valores.NOVE.toString())) {
			this.VALOR = Valores.NOVE;
		} else if (valor.equalsIgnoreCase(Valores.DEZ.toString())) {
			this.VALOR = Valores.DEZ;
		} else if (valor.equalsIgnoreCase(Valores.J.toString())) {
			this.VALOR = Valores.J;
		} else if (valor.equalsIgnoreCase(Valores.Q.toString())) {
			this.VALOR = Valores.Q;
		} else if (valor.equalsIgnoreCase(Valores.K.toString())) {
			this.VALOR = Valores.K;
		} else
			throw new IllegalArgumentException("O valor da carta é invalido!!!");
	}

	public Carta(int naipe, int valor) {
		switch (naipe) {
		case 0:
			this.NAIPE = Naipes.JOKER;
			break;
		case 1:
			this.NAIPE = Naipes.COPAS;
			break;
		case 2:
			this.NAIPE = Naipes.ESPADA;
			break;
		case 3:
			this.NAIPE = Naipes.OURO;
			break;
		case 4:
			this.NAIPE = Naipes.PAUS;
			break;
		default:
			throw new IllegalArgumentException("O valor do naipe é invalido!!!");
		}
		

		switch (valor) {
		case 1:
			this.VALOR = Valores.A;
			break;
		case 2:
			this.VALOR = Valores.DOIS;
			break;
		case 3:
			this.VALOR = Valores.TRES;
			break;
		case 4:
			this.VALOR = Valores.QUATRO;
			break;
		case 5:
			this.VALOR = Valores.CINCO;
			break;
		case 6:
			this.VALOR = Valores.SEIS;
			break;
		case 7:
			this.VALOR = Valores.SETE;
			break;
		case 8:
			this.VALOR = Valores.OITO;
			break;
		case 9:
			this.VALOR = Valores.NOVE;
			break;
		case 10:
			this.VALOR = Valores.DEZ;
			break;
		case 11:
			this.VALOR = Valores.J;
			break;
		case 12:
			this.VALOR = Valores.Q;
			break;
		case 13:
			this.VALOR = Valores.K;
			break;
		default:
			throw new IllegalArgumentException("O valor da carta é invalido");
		}
	}
	
	public Carta (String naipe, int valor) {
		if (naipe.equalsIgnoreCase(Naipes.COPAS.toString())) {
			NAIPE = Naipes.COPAS;
		} else if (naipe.equalsIgnoreCase(Naipes.ESPADA.toString())) {
			this.NAIPE = Naipes.ESPADA;
		} else if (naipe.equalsIgnoreCase(Naipes.JOKER.toString())) {
			this.NAIPE = Naipes.JOKER;
		} else if (naipe.equalsIgnoreCase(Naipes.OURO.toString())) {
			this.NAIPE = Naipes.OURO;
		} else if (naipe.equalsIgnoreCase(Naipes.PAUS.toString())) {
			this.NAIPE = Naipes.PAUS;
		} else {
			throw new IllegalArgumentException("O valor do naipe é invalido!!!");
		}
		
		switch (valor) {
		case 1:
			this.VALOR = Valores.A;
			break;
		case 2:
			this.VALOR = Valores.DOIS;
			break;
		case 3:
			this.VALOR = Valores.TRES;
			break;
		case 4:
			this.VALOR = Valores.QUATRO;
			break;
		case 5:
			this.VALOR = Valores.CINCO;
			break;
		case 6:
			this.VALOR = Valores.SEIS;
			break;
		case 7:
			this.VALOR = Valores.SETE;
			break;
		case 8:
			this.VALOR = Valores.OITO;
			break;
		case 9:
			this.VALOR = Valores.NOVE;
			break;
		case 10:
			this.VALOR = Valores.DEZ;
			break;
		case 11:
			this.VALOR = Valores.J;
			break;
		case 12:
			this.VALOR = Valores.Q;
			break;
		case 13:
			this.VALOR = Valores.K;
			break;
		default:
			throw new IllegalArgumentException("O valor da carta é invalido");
		}
	}
	
	public Carta (int naipe, String valor) {
		switch (naipe) {
		case 0:
			this.NAIPE = Naipes.JOKER;
			break;
		case 1:
			this.NAIPE = Naipes.COPAS;
			break;
		case 2:
			this.NAIPE = Naipes.ESPADA;
			break;
		case 3:
			this.NAIPE = Naipes.OURO;
			break;
		case 4:
			this.NAIPE = Naipes.PAUS;
			break;
		default:
			throw new IllegalArgumentException("O valor do naipe é invalido!!!");
		}
		
		if (valor.equalsIgnoreCase(Valores.A.toString())) {
			VALOR = Valores.A;
		} else if (valor.equalsIgnoreCase(Valores.DOIS.toString())) {
			this.VALOR = Valores.DOIS;
		} else if (valor.equalsIgnoreCase(Valores.TRES.toString())) {
			this.VALOR = Valores.TRES;
		} else if (valor.equalsIgnoreCase(Valores.QUATRO.toString())) {
			this.VALOR = Valores.QUATRO;
		} else if (valor.equalsIgnoreCase(Valores.CINCO.toString())) {
			this.VALOR = Valores.CINCO;
		} else if (valor.equalsIgnoreCase(Valores.SEIS.toString())) {
			this.VALOR = Valores.SEIS;
		} else if (valor.equalsIgnoreCase(Valores.OITO.toString())) {
			this.VALOR = Valores.OITO;
		} else if (valor.equalsIgnoreCase(Valores.NOVE.toString())) {
			this.VALOR = Valores.NOVE;
		} else if (valor.equalsIgnoreCase(Valores.DEZ.toString())) {
			this.VALOR = Valores.DEZ;
		} else if (valor.equalsIgnoreCase(Valores.J.toString())) {
			this.VALOR = Valores.J;
		} else if (valor.equalsIgnoreCase(Valores.Q.toString())) {
			this.VALOR = Valores.Q;
		} else if (valor.equalsIgnoreCase(Valores.K.toString())) {
			this.VALOR = Valores.K;
		} else
			throw new IllegalArgumentException("O valor da carta é invalido!!!");
	}
	
	public String getNaipeSting() {
		return NAIPE.toString();
	}
	
	public int getNaipeInt() {
		if (NAIPE.toString().equalsIgnoreCase("JOKER")) {
			return 0;
		}else if (NAIPE.toString().equalsIgnoreCase("PAUS")) {//COPAS
			return 1;
		}else if (NAIPE.toString().equalsIgnoreCase("COPAS")) {//ESPADA
			return 2;
		}else if (NAIPE.toString().equalsIgnoreCase("ESPADA")) {//OURO	PAUS
			return 3;
		}else {
			return 4;
		}
	}
	
	public String getValorString() {
		return VALOR.toString();
	}
	
	public int getValorInt() {
		if (VALOR.toString().equalsIgnoreCase("A")) {
			return 1;
		}else if (VALOR.toString().equalsIgnoreCase("DOIS")) {
			return 2;
		}else if (VALOR.toString().equalsIgnoreCase("TRES")) {
			return 3;
		}else if (VALOR.toString().equalsIgnoreCase("QUATRO")) {
			return 4;
		}else if (VALOR.toString().equalsIgnoreCase("CINCO")) {
			return 5;
		}else if (VALOR.toString().equalsIgnoreCase("SEIS")) {
			return 6;
		}else if (VALOR.toString().equalsIgnoreCase("SETE")) {
			return 7;
		}else if (VALOR.toString().equalsIgnoreCase("OITO")) {
			return 8;
		}else if (VALOR.toString().equalsIgnoreCase("NOVE")) {
			return 9;
		}else if (VALOR.toString().equalsIgnoreCase("DEZ")) {
			return 10;
		}else if (VALOR.toString().equalsIgnoreCase("J")) {
			return 11;
		}else if (VALOR.toString().equalsIgnoreCase("Q")) {
			return 12;
		}else {
			return 13;
		}
	}
	
	public String toString() {
		if(NAIPE.toString().equalsIgnoreCase("Joker")) {
			return NAIPE.toString();
		}else {
			return VALOR.toString()+" de "+NAIPE.toString();
		}
	}

}
