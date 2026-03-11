package com.fabiodc.cursocm.services.validation.utils;



	public class BR {

	    public static boolean isValidCPF(String cpf) {

	        if (cpf == null) return false;

	        cpf = cpf.replaceAll("[^0-9]", "");

	        if (cpf.length() != 11) return false;

	        if (cpf.matches("(\\d)\\1{10}")) return false;

	        int soma = 0;
	        int peso = 10;

	        for (int i = 0; i < 9; i++) {
	            soma += (cpf.charAt(i) - '0') * peso--;
	        }

	        int dig1 = 11 - (soma % 11);
	        if (dig1 > 9) dig1 = 0;

	        soma = 0;
	        peso = 11;

	        for (int i = 0; i < 10; i++) {
	            soma += (cpf.charAt(i) - '0') * peso--;
	        }

	        int dig2 = 11 - (soma % 11);
	        if (dig2 > 9) dig2 = 0;

	        return dig1 == (cpf.charAt(9) - '0') &&
	               dig2 == (cpf.charAt(10) - '0');
	    }

	    public static boolean isValidCNPJ(String cnpj) {

	        if (cnpj == null) return false;

	        cnpj = cnpj.replaceAll("[^0-9]", "");

	        if (cnpj.length() != 14) return false;

	        if (cnpj.matches("(\\d)\\1{13}")) return false;

	        int[] peso1 = {5,4,3,2,9,8,7,6,5,4,3,2};
	        int[] peso2 = {6,5,4,3,2,9,8,7,6,5,4,3,2};

	        int soma = 0;

	        for(int i=0;i<12;i++){
	            soma += (cnpj.charAt(i)-'0') * peso1[i];
	        }

	        int dig1 = soma % 11;
	        dig1 = (dig1 < 2) ? 0 : 11 - dig1;

	        soma = 0;

	        for(int i=0;i<13;i++){
	            soma += (cnpj.charAt(i)-'0') * peso2[i];
	        }

	        int dig2 = soma % 11;
	        dig2 = (dig2 < 2) ? 0 : 11 - dig2;

	        return dig1 == (cnpj.charAt(12)-'0') &&
	               dig2 == (cnpj.charAt(13)-'0');
	    }
	}

