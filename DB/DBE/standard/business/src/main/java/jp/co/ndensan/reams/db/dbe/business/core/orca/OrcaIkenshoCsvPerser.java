/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.orca;

import jp.co.ndensan.reams.db.dbe.entity.core.orca.OrcaIkenshoCsvEntity;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvReader;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * オルカ医見書のCSVを解析します。
 */
public final class OrcaIkenshoCsvPerser {

    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    private OrcaIkenshoCsvPerser() {
    }

    /**
     * @param filePaths ファイルパス
     * @return {@link OrcaIkenshoCsvData}
     */
    public static OrcaIkenshoCsvData parseCSVs(Iterable<? extends RString> filePaths) {
        List<OrcaIkenshoCsv> list = new ArrayList<>();
        for (RString filePath : filePaths) {
            list.addAll(parseCSV(filePath));
        }
        return new OrcaIkenshoCsvData(list);
    }

    private static List<OrcaIkenshoCsv> parseCSV(RString filePath) {
        List<OrcaIkenshoCsv> list = new ArrayList<>();
        try (CsvReader<OrcaIkenshoCsvEntity> csvReader = createCsvReader(filePath)) {
            while (true) {
                OrcaIkenshoCsvEntity entity = csvReader.readLine();
                if (entity == null) {
                    break;
                }
                list.add(new OrcaIkenshoCsv(entity));
            }
        }
        return list;
    }

    private static CsvReader<OrcaIkenshoCsvEntity> createCsvReader(RString filePath) {
        return new CsvReader.InstanceBuilder(filePath, OrcaIkenshoCsvEntity.class)
                .setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS)
                .hasHeader(false).setNewLine(NewLine.LF).build();
    }

}
