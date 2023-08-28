package lotes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ManejoLotes {

	public static void main(String[] args) {
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		List<String> listaCodigo = new ArrayList<>();
		for (int i = 0; i < 530; i++) {
			String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength)
					.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
			listaCodigo.add(generatedString);

		}
		System.out.println("cantidad de la lista" + listaCodigo.size());

		final int batch_size = 999;

		int numLotes = (int) Math.ceil((double) listaCodigo.size() / batch_size);
		List<List<String>> batch = new ArrayList<>();

		for (int i = 0; i < numLotes; i++) {
			int desdeIndice = i * batch_size;
			int hastaIndice = Math.min((i + 1) * batch_size, listaCodigo.size());
			List<String> lote = listaCodigo.subList(desdeIndice, hastaIndice);
			batch.add(lote);
		}
		
		for (List<String> list : batch) {
			System.out.println("cantidad de la lote-->" + list.size());
		}

	}

}
