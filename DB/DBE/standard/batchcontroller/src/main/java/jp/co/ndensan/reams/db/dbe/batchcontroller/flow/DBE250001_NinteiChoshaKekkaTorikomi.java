/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.ocrdataread.OcrDataReadProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250001.DBE250001_NinteiChoshaKekkaTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.ocrdataread.OcrDataReadProcessParameter;
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
public class DBE250001_NinteiChoshaKekkaTorikomi extends BatchFlowBase<DBE250001_NinteiChoshaKekkaTorikomiParameter> {

    private int fileIndex = 0;
    private List<RString> filePathList;
    private static final String OCRデータの読み込み_PROCESS = "OCRデータの読み込み_PROCESS";
    private OcrDataReadProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        readAllOcrDataFile();
        while (fileIndex < filePathList.size()) {
            if (processParameter == null) {
                processParameter = new OcrDataReadProcessParameter(RDate.getNowDate(), filePathList.get(fileIndex));
            } else {
                processParameter.setファイルPath(filePathList.get(fileIndex));
            }
            executeStep(OCRデータの読み込み_PROCESS);
            fileIndex++;
        }
    }

    @Step(OCRデータの読み込み_PROCESS)
    IBatchFlowCommand executeOCRデータの読み込み() {
        return loopBatch(OcrDataReadProcess.class)
                .arguments(processParameter)
                .define();
    }

    /**
     * バッチパラメータの共有ファイルIDから共有ファイルのOCRデータを読み込む
     */
    private void readAllOcrDataFile() {
        RString tempDirPath = Directory.createTmpDirectory();
        File tempDir = new File(tempDirPath.toString());
        ReadOnlySharedFileEntryDescriptor entry
                = ReadOnlySharedFileEntryDescriptor.fromString(getParameter().get共有ファイルエントリ情報文字列().toString());
        SharedFile.copyToLocal(entry, new FilesystemPath(tempDirPath));
        filePathList = new ArrayList<>();
        setFilePath(tempDir);
    }

    private void setFilePath(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                filePathList.add(new RString(file.getAbsolutePath()));
            } else {
                setFilePath(file);
            }
        }
    }
}
