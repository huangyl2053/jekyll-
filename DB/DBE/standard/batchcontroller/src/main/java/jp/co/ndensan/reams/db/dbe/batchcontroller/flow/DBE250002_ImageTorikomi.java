/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250002.ImageInputProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250002.DBE250002_ImageTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.dbe250002.OcrImageReadProcessParameter;
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
 * イメージ取込み_バッチフロークラスです。
 *
 * @author n2818
 */
public class DBE250002_ImageTorikomi extends BatchFlowBase<DBE250002_ImageTorikomiParameter> {

    private int fileIndex = 0;
    private List<RString> filePathList;
    private static final String OCRイメージの読み込み_PROCESS = "OCRイメージの読み込み_PROCESS";
    private OcrImageReadProcessParameter processParameter;
    private List<RString> filePathListPng;

    @Override
    protected void defineFlow() {
        readAllOcrDataFile();
        filePathListPng = new ArrayList<>();
        while (fileIndex < filePathList.size()) {
            if (filePathList.get(fileIndex).contains(".png")) {
                filePathListPng.add(filePathList.get(fileIndex));
            }
            if (processParameter == null) {
                processParameter = new OcrImageReadProcessParameter(RDate.getNowDate(), filePathList.get(fileIndex), filePathListPng);
            } else {
                processParameter.setファイルPath(filePathList.get(fileIndex));
                processParameter.setファイルPathList(filePathListPng);
            }
            executeStep(OCRイメージの読み込み_PROCESS);
            fileIndex++;
        }
    }

    @Step(OCRイメージの読み込み_PROCESS)
    IBatchFlowCommand executeOCRイメージの読み込み() {
        return loopBatch(ImageInputProcess.class)
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
