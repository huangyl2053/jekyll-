/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.core.ikenshoirai.koudemashite;

import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shinsataishodataoutput.ShinsaTaishoDataOutPutResult;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shinsataishodataoutput.CodeMasterEucCsvEntity;
import jp.co.ndensan.reams.uz.uza.io.Encode;
import jp.co.ndensan.reams.uz.uza.io.NewLine;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.io.csv.CsvWriter;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * コードマスタ取得Businessクラスです。
 *
 * @reamsid_L DBA-1230-010 yaoyahui
 */
public class KoueMashite {

    private static final RString FILENAME = new RString("コードマスタ.CSV");
    private static final RString CSV_WRITER_DELIMITER = new RString(",");

    /**
     * codeMasterのＣＳＶ出力
     *
     */
    public void codeMasterEucCsv() {
        List<CodeMasterEucCsvEntity> codeMasterEucCsvEntityList = new ShinsaTaishoDataOutPutResult().getCodeMasterEucCsvEntityList();
        RString filePath = Path.combinePath(Path.getTmpDirectoryPath(), FILENAME);
        CsvWriter<CodeMasterEucCsvEntity> csvWriter
                = new CsvWriter.InstanceBuilder(filePath).canAppend(false).setDelimiter(CSV_WRITER_DELIMITER).setEncode(Encode.SJIS).
                setEnclosure(RString.EMPTY).setNewLine(NewLine.CRLF).hasHeader(true).build();
        for (CodeMasterEucCsvEntity codeMasterEucCsvEntity : codeMasterEucCsvEntityList) {
            csvWriter.writeLine(codeMasterEucCsvEntity);
        }

    }
}
