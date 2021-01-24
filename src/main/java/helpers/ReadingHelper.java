package helpers;

import models.Gen;
import models.Sequence;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ReadingHelper {
    public static List<Gen> getGenes(String filename) throws IOException {
        ArrayList<Gen> genes = new ArrayList<>();

        InputStream iss = ReadingHelper.class.getClassLoader().getResourceAsStream(filename);
        XSSFWorkbook wb = new XSSFWorkbook(iss);
        Iterator<Sheet> iter = wb.sheetIterator();
        while (iter.hasNext()) {
            Sheet sheet = iter.next();
            Gen gen = new Gen(sheet.getSheetName(), new ArrayList<>());
            int rowi = -1;
            int celli = -1;

            int lastKodonNum = 0;

            for (Row row : sheet)     //iteration over row using for each loop
            {
                rowi++;
                celli = -1;
                if (rowi == 0) continue;

                Sequence sequence = new Sequence();

                for (Cell cell : row)    //iteration over cell using for each loop
                {
                    celli++;
                    switch (celli) {
                        case 0 -> {
                            CellType type = cell.getCellType();
                            if (type == CellType.NUMERIC) {
                                lastKodonNum = (int) cell.getNumericCellValue();
                            }
                            sequence.setKodon(lastKodonNum);
                        }
                        case 1 -> sequence.setSequence(cell.getStringCellValue());
                        case 3 -> sequence.setMutation(cell.getStringCellValue());
                    }
                }
                gen.sequences.add(sequence);
            }
            genes.add(gen);
        }

        return genes;
    }
}
