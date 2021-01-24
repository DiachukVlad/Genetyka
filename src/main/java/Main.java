import helpers.ReadingHelper;
import models.Gen;
import models.Sequence;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    List<Gen> genes;

    public static void main(String[] args) throws IOException {
        new Main();
    }

    public Main() throws IOException {
        genes = ReadingHelper.getGenes("ttt.xlsx");
        genes.forEach(System.out::println);
    }
}
