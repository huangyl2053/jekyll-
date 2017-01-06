/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.flow;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
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
import jp.co.ndensan.reams.uz.uza.util.Comparators;

/**
 * イメージ取込み_バッチフロークラスです。
 *
 * @author n2818
 */
public class DBE250002_ImageTorikomi extends BatchFlowBase<DBE250002_ImageTorikomiParameter> {

    private List<RString> filePathList;
    OcrImageReadProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        final RDate PROCESSING_DATE = RDate.getNowDate();
        final List<RString> FILE_PATHS = readAllOcrDataFileTo(Directory.createTmpDirectory());
        final List<RString> IMAGE_FILE_PATHS = new ArrayList<>();

        /* PNGファイルだけ先に処理して、IMAGE_FILE_PATHSにセットする */
        Collections.sort(filePathList, new PNGsFirstComparator());
        for (RString currentFilePath : FILE_PATHS) {
            if (isPNGFile(currentFilePath)) {
                IMAGE_FILE_PATHS.add(currentFilePath);
                continue;
            }
            processParameter = new OcrImageReadProcessParameter(PROCESSING_DATE, currentFilePath, IMAGE_FILE_PATHS);
            executeStep(OCRイメージの読み込み_PROCESS);
        }
    }

    private static final String OCRイメージの読み込み_PROCESS = "OCRイメージの読み込み_PROCESS";

    @Step(OCRイメージの読み込み_PROCESS)
    IBatchFlowCommand executeOCRイメージの読み込み() {
        return loopBatch(ImageInputProcess.class)
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
                list.add(new RString(file.getAbsolutePath()));
            } else {
                list.addAll(setFilePath(file));
            }
        }
        return list;
    }

    private static class PNGsFirstComparator implements Comparator<RString> {

        @Override
        public int compare(RString o1, RString o2) {
            if (isPNGFile(o1)) {
                return -1;
            }
            if (isPNGFile(o2)) {
                return -1;
            }
            return Objects.compare(o1, o2, Comparators.naturalOrder());
        }
    }

    private static boolean isPNGFile(RString text) {
        return text.endsWith(".png") || text.endsWith(".PNG");
    }
}
