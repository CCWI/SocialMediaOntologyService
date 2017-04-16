package de.hm.mpi.twitterDataParser.relational;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import net.sf.jsefa.Deserializer;
import net.sf.jsefa.csv.CsvIOFactory;

public class RelationalParser {

	/**
	 * Parse CSV-input of URL.
	 * @param resourceUrl
	 * @return
	 */
	public List<RelationalEntry> parseRelationalExportedData(String resourceUrl) {

		final File file = new File(resourceUrl);
		Reader reader = null;
		try {
			reader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Deserializer deserializer = CsvIOFactory.createFactory(RelationalEntry.class).createDeserializer();
		deserializer.open(reader);

		List<RelationalEntry> relationalEntryList = new ArrayList<RelationalEntry>();

		while (deserializer.hasNext()) {
			RelationalEntry entry = deserializer.next();
			relationalEntryList.add(entry);
		}
		deserializer.close(true);

		return relationalEntryList;
	}
}
