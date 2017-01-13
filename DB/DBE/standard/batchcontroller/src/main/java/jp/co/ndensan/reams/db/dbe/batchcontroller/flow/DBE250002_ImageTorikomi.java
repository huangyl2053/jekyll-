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
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250002.ImageInputProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE250002.ImageInputSonotaProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.DBE250002.DBE250002_ImageTorikomiParameter;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrDataType;
import jp.co.ndensan.reams.db.dbe.definition.core.ocr.OcrFiles;
import jp.co.ndensan.reams.db.dbe.business.core.ocr.OcrTorikomiUtil;
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

    OcrImageReadProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        final RDate PROCESSING_DATE = RDate.getNowDate();
        final List<RString> FILE_PATHS = readAllOcrDataFileTo(Directory.createTmpDirectory());
        Map<OcrDataType, OcrFiles> map = OcrTorikomiUtil.groupingByType(FILE_PATHS);
        final OcrFiles IMAGE_FILE_PATHS = map.get(OcrDataType.イメージファイル);
        for (OcrDataType type : Arrays.asList(OcrDataType.意見書, OcrDataType.その他資料)) {
            OcrFiles files = map.get(type);
            if (files.isEmpty()) {
                continue;
            }
            processParameter = new OcrImageReadProcessParameter(PROCESSING_DATE, files, IMAGE_FILE_PATHS);
            switch (type) {
                case 意見書:
                    executeStep(主治医意見書イメージの読み込み);
                    continue;
                case その他資料:
                    executeStep(その他資料の読み込み);
                default:
            }
        }
    }

    private static final String 主治医意見書イメージの読み込み = "主治医意見書イメージの読み込み";

    @Step(主治医意見書イメージの読み込み)
    IBatchFlowCommand executeOCRイメージの読み込み() {
        return loopBatch(ImageInputProcess.class)
                .arguments(processParameter)
                .define();
    }

    private static final String その他資料の読み込み = "その他資料の読み込み";

    @Step(その他資料の読み込み)
    IBatchFlowCommand executeOCRその他イメージの読み込み() {
        return loopBatch(ImageInputSonotaProcess.class)
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
                    //TODO 例外処理。エラーリスト出力等が必要か…。
                }
            } else {
                list.addAll(setFilePath(file));
            }
        }
        return list;
    }
}
