/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB233001.TokuchoSeidokanIFRenkeiProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB233001.DBB233001_TokuchoSeidokanIFRenkeiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemName;
import jp.co.ndensan.reams.uz.uza.cooperation.FilesystemPath;
import jp.co.ndensan.reams.uz.uza.cooperation.SharedFile;
import jp.co.ndensan.reams.uz.uza.externalcharacter.batch.BatchTextFileConvert;
import jp.co.ndensan.reams.uz.uza.externalcharacter.batch.BatchTextFileConvertBatchParameter;
import jp.co.ndensan.reams.uz.uza.io.Path;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * バッチ設計_DBB233001_特徴制度間Ｉ／Ｆ連携　の作成です。
 *
 * @reamsid_L DBB-1810-040 dengjiajia
 */
public class DBB233001_TokuchoSeidokanIFRenkei extends BatchFlowBase<DBB233001_TokuchoSeidokanIFRenkeiParameter> {

    private static final String TOKUCHOUSEIDOKANIFRENKEI_PRO = "tokuchouSeidoKanIFRenkeiProcess";
    private static final String 文字コード変換 = "batchTextFileConvert";
    private List<RString> 入力ファイルパス;
    private RString ファイルパス_IN;
    private RString ファイルパス_OUT;
    private List<RString> 出力ファイルパス;
    private static final RString JIS = new RString("Jis");

    @Override
    protected void defineFlow() {
        executeStep(TOKUCHOUSEIDOKANIFRENKEI_PRO);
        do文字コード変換();
    }

    @Step(TOKUCHOUSEIDOKANIFRENKEI_PRO)
    IBatchFlowCommand tokuchouSeidoKanIFRenkeiProcess() {
        List<RString> 市町村コードリスト = new ArrayList<>();
        return loopBatch(TokuchoSeidokanIFRenkeiProcess.class).arguments(
                new DBB233001_TokuchoSeidokanIFRenkeiParameter().
                toTokuchouSeidoKanIFRenkeiProcessParameter(FlexibleYear.EMPTY, 市町村コードリスト)).define();
    }

    /**
     * 文字コード変換操作です。
     *
     * @return IBatchFlowCommand
     */
    @Step(文字コード変換)
    protected IBatchFlowCommand callBatchTextFileConvertProcess() {
        HashMap<RString, Object> parameter = new HashMap();
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_READ_FILE_PATH), ファイルパス_IN);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_WRITE_FILE_PATH), ファイルパス_OUT);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_CONVERT_TABLE_NAME), JIS);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_CONVERT_TYPE), BatchTextFileConvert.CONVERTTYPE_TO);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_READ_ROW_DELIMITER), BatchTextFileConvert.ROWDELIMITER_LF);
        parameter.put(new RString(BatchTextFileConvertBatchParameter.KEY_WRITE_ROW_DELIMITER), BatchTextFileConvert.ROWDELIMITER_CRLF);
        return simpleBatch(BatchTextFileConvert.class)
                .arguments(parameter)
                .define();
    }

    private void do文字コード変換() {
        出力ファイルパス = getResult(
                List.class, new RString(TOKUCHOUSEIDOKANIFRENKEI_PRO), TokuchoSeidokanIFRenkeiProcess.PARAMETER_OUT_OUTPUTPATH);
        入力ファイルパス = getResult(
                List.class, new RString(TOKUCHOUSEIDOKANIFRENKEI_PRO), TokuchoSeidokanIFRenkeiProcess.PARAMETER_IN_INPUTPATH);
        for (int i = 0; i < 入力ファイルパス.size(); i++) {
            ファイルパス_OUT = 出力ファイルパス.get(i);
            ファイルパス_IN = 入力ファイルパス.get(i);
            executeStep(文字コード変換);
            deleteEmptyFile(ファイルパス_IN);
            FilesystemName sharedFileName = new FilesystemName(ファイルパス_OUT);
            SharedFile.defineSharedFile(sharedFileName);
            FilesystemPath 絶対パス = new FilesystemPath(Path.getTmpDirectoryPath());
            SharedFile.copyToSharedFile(絶対パス, sharedFileName);
        }
    }

    private void deleteEmptyFile(RString filePath) {
        if (RString.isNullOrEmpty(filePath)) {
            return;
        }
        File file = new File(filePath.toString());
        if (file.exists()) {
            file.getAbsoluteFile().deleteOnExit();
        }
    }

}
