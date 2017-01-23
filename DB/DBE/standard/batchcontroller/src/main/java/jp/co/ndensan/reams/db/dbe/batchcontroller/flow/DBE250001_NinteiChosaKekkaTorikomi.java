/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250001.ImportOcrCsvIntoTempTable;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250001.OcrDataReadProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250001.DBE250001_NinteiChosaKekkaTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrDataType;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiUtil;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocr.OcrDataReadProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.cooperation.descriptor.ReadOnlySharedFileEntryDescriptor;
import jp.co.ndensan.reams.uz.uza.io.Directory;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * OCR情報受入＿バッチフロークラスです。
 *
 * @author n8429
 */
public class DBE250001_NinteiChosaKekkaTorikomi extends BatchFlowBase<DBE250001_NinteiChosaKekkaTorikomiParameter> {

    private OcrDataReadProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        final RDate PROCESSING_DATE = RDate.getNowDate();
        final List<RString> FILE_PATHS = readAllOcrDataFileTo(Directory.createTmpDirectory());
        Map<OcrDataType, OcrFiles> map = OcrTorikomiUtil.groupingByType(FILE_PATHS);
        final OcrFiles IMAGE_FILE_PATHS = map.get(OcrDataType.イメージファイル);
        for (OcrDataType type : Arrays.asList(OcrDataType.調査票)) {
            OcrFiles files = map.get(type);
            if (files.isEmpty()) {
                continue;
            }
            this.processParameter = new OcrDataReadProcessParameter(PROCESSING_DATE, files, IMAGE_FILE_PATHS, new RString("TempOcrChosa"));
            executeStep(OCRデータの一時テーブルへの格納_PROCESS);
            executeStep(OCRデータの読み込み_PROCESS);
        }
    }

    private static final String OCRデータの一時テーブルへの格納_PROCESS = "OCRデータの一時テーブルへの格納";

    @Step(OCRデータの一時テーブルへの格納_PROCESS)
    IBatchFlowCommand importCsvToTempTable() {
        return loopBatch(ImportOcrCsvIntoTempTable.class)
                .arguments(processParameter)
                .define();
    }

    private static final String OCRデータの読み込み_PROCESS = "OCRデータの読み込み";

    @Step(OCRデータの読み込み_PROCESS)
    IBatchFlowCommand executeOCRデータの読み込み() {
        return loopBatch(OcrDataReadProcess.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * バッチパラメータの共有ファイルIDから共有ファイルのOCRデータを読み込みます。
     */
    private List<RString> readAllOcrDataFileTo(RString tempDirPath) {
        File tempDir = new File(tempDirPath.toString());
        ReadOnlySharedFileEntryDescriptor entry
                = ReadOnlySharedFileEntryDescriptor.fromString(getParameter().get共有ファイルエントリ情報文字列().toString());
        SharedFile.copyToLocal(entry, new FilesystemPath(tempDirPath));
        return setFilePath(tempDir);
    }

    private List<RString> setFilePath(File directory) {
        List<RString> list = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                try {
                    list.add(new RString(file.getCanonicalPath()));
                } catch (IOException ex) {
                }
            } else {
                list.addAll(setFilePath(file));
            }
        }
        return list;
    }
}
