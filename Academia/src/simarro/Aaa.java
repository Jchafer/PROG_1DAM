package simarro;

import java.util.ArrayList;
import java.util.Iterator;

public class Aaa {

	public static void main(String[] args) {
		
		ArrayList lugares = new ArrayList();
		
		lugares.add("España");
		lugares.add("Francia");
		lugares.add("Portugal");
		lugares.iterator();
		System.out.println("Lista de Paises: ");
		Iterator itor = lugares.iterator();
		itor.next();
		itor.remove();
		
		while (itor.hasNext()) {
			Object abc = itor.next();
			System.out.println(abc);
		}
		System.out.println(" ");
	}

}
