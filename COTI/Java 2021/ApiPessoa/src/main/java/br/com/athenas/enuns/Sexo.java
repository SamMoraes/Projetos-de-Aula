package br.com.athenas.enuns;

import java.util.HashMap;
import java.util.Map;

public enum Sexo {

	MASCULINO(0),
	FEMININO(1);
	
	
	private int value;
    private static Map map = new HashMap<>();

    private Sexo(int value) {
        this.value = value;
    }

    static {
        for (Sexo sexo : Sexo.values()) {
            map.put(sexo.value, sexo);
        }
    }

    public static Sexo valueOf(int sexo) {
        return (Sexo) map.get(sexo);
    }

    public int getValue() {
        return value;
    }
}
