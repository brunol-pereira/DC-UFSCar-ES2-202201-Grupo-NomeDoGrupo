// -------------------------------------------------------
// Original code from Name of group from SE2 from UFSCar.
//                       👉👈                            
// -------------------------------------------------------

package net.sf.jabref.importer.fileformat;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.util.List;

import net.sf.jabref.model.entry.BibEntry;
import net.sf.jabref.importer.ImportFormatReader;
import net.sf.jabref.importer.OutputPrinter;

public class CSV_Importer extends ImportFormat {

    @Override
    public String getFormatName() {
        return "CSV";
    }

    @Override
    public String getCLIId() {
        return "csv";
    }

    @Override
    public boolean isRecognizedFormat(InputStream stream) throws IOException {
        return true;
    }

    @Override
    public List<BibEntry> importEntries(InputStream stream, OutputPrinter status) throws IOException {
        ArrayList<BibEntry> bibitems = new ArrayList<>();
        BufferedReader in = new BufferedReader(ImportFormatReader.getReaderDefaultEncoding(stream));
        String line = in.readLine();
        while (line != null) {
            if (!"".equals(line.trim())) {
                String[] fields = line.split(",");
                BibEntry be = new BibEntry();
                be.setType("TechReport");
                be.setField("year", fields[0]);
                be.setField("author", fields[1]);
                be.setField("title", fields[2]);
                bibitems.add(be);
                line = in.readLine();
            }
        }
        return bibitems;
    }

}