package helpers;

import models.Gen;
import models.Sequence;
import org.apache.poi.ss.usermodel.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class ReadingHelper {
    public static ArrayList<Gen> getGenes(String filename) throws IOException {
        ArrayList<Gen> genes = new ArrayList<>();

        InputStream file = ReadingHelper.class.getClassLoader().getResourceAsStream(filename);
        Workbook workbook = WorkbookFactory.create(file);
        AtomicInteger codon = new AtomicInteger();

        for (Sheet sheet: workbook){
            Gen gen = new Gen(sheet.getSheetName(), new ArrayList<>());
            sheet.removeRow(sheet.getRow(0));
            sheet.forEach(row -> {
                Sequence sequence = new Sequence();
                row.removeCell(row.getCell(2));
                row.forEach(cell -> {
                    switch (cell.getColumnIndex()){
                        case 0 -> {
                            if (cell.getCellType() == CellType.NUMERIC){
                                codon.set((int) cell.getNumericCellValue());
                            }
                            sequence.setKodon(codon.get());
                        }
                        case 1 -> sequence.setSequence(cell.getStringCellValue());
                        case 3 -> sequence.setMutation(cell.getStringCellValue());
                    }
                });
                gen.sequences.add(sequence);
            });
            genes.add(gen);
        }
        return genes;
    }
}
