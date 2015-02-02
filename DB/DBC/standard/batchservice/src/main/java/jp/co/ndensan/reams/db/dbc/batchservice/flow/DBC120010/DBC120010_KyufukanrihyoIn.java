/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchservice.flow.DBC120010;

import java.util.HashMap;
import java.util.Map;
import jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010.KokuhorenIFUpdataProcess;
import jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010.KokuhorenIFUpdateCtrlRecordProcess;
import jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010.KyufuKanrihyoDeleteProcess;
import jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010.KyufuKanrihyoInBatchRegistFileReadProcess;
import jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010.KyufuKanrihyoInBatchRegistTempSaveProcess;
import jp.co.ndensan.reams.db.dbc.batchservice.step.DBC120010.SharedFileCopy;
import jp.co.ndensan.reams.db.dbc.batchservice.step.KyufuKanrihyoInBatchRegistCsvOutputProcess;
import jp.co.ndensan.reams.db.dbc.batchservice.step.KyufuKanrihyoInBatchRegistGetEditInfoProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.KokuhorenJohoTorikomiBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.ConfigKeysKokuhorenTorikomi;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.IcchiJoken;
import jp.co.ndensan.reams.db.dbc.definition.enumeratedtype.KokuhorenIFShoriJotaiKubun;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 *
 * @author N2810 久保 里史
 */
public class DBC120010_KyufukanrihyoIn extends BatchFlowBase<KokuhorenJohoTorikomiBatchParameter> {

    // バッチ処理クラス
    private static final String KOKUHORENIFKANRI_UPDATE_START = "kokuhorenIFStartUpdataProcess";
    private static final String KYUFUKANRIHYO_DELETE = "kyufuKanrihyoDeleteProcess";
    private static final String SHAREDFILE_COPY = "sharedFileCopy";
    private static final String TEMP_SAVE_PROCESS = "kyufuKanrihyoInBatchRegistTempSaveProcess";
    private static final String GET_EDIT_INFO = "kyufuKanrihyoInBatchRegistGetEditInfoProcess";
    private static final String FILE_READ_PROCESS = "kyufuKanrihyoInBatchRegistFileReadProcess";
    private static final String CSV_OUTPUT_PROCESS = "kyufuKanrihyoInBatchRegistCsvOutputProcess";
    private static final String KOKUHORENIFKANRI_UPDATE_CTRLRECORD = "kokuhorenIFUpdateCtrlRecordProcess";
    private static final String KOKUHORENIFKANRI_UPDATE_FINISH = "kokuhorenIFFinishUpdataProcess";

    private final RString 再処理 = new RString("1");
    private final RString sharedFileKey = new RString("給付管理票情報");
    private RString runFilePath;

    @Override
    protected void defineFlow() {

        executeStep(new RString(KOKUHORENIFKANRI_UPDATE_START));        //国保連ＩＦ管理の処理状態を"処理中"に変更
        if (getParameter().getSaishoriKubun().contains(再処理)) {
            executeStep(new RString(KYUFUKANRIHYO_DELETE));             //再処理の場合、両給付管理票テーブルの該当処理年月のデータを削除する
        }
        executeStep(new RString(SHAREDFILE_COPY));                      //処理対象の共有ファイルをローカルへコピー

        HashMap<RString, RString> filePathList = getResult(HashMap.class, new RString(SHAREDFILE_COPY), SharedFileCopy.PARAMETER_OUT_FILEPATHLIST);
        for (RString filepath : filePathList.values()) {
            runFilePath = filepath;
            executeStep(new RString(TEMP_SAVE_PROCESS));                //コピーしてきたCSVを一時テーブルに格納
        }

        executeStep(new RString(GET_EDIT_INFO));                        //給付管理票テーブル、取込結果一覧ＣＳＶで必要な情報を一時テーブルに設定する
        executeStep(new RString(FILE_READ_PROCESS));                    //給付管理票テーブルにデータを追加する
        executeStep(new RString(CSV_OUTPUT_PROCESS));                   //給付管理票取込結果一覧表とＣＳＶを出力する
        executeStep(new RString(KOKUHORENIFKANRI_UPDATE_CTRLRECORD));   //コントロールレコードの情報を国保連ＩＦ管理に反映させる
        executeStep(new RString(KOKUHORENIFKANRI_UPDATE_FINISH));       //国保連ＩＦ管理の処理状態を"処理済"に変更

    }

    @Step(KOKUHORENIFKANRI_UPDATE_START)
    IBatchFlowCommand kokuhorenIFStartUpdataProcess() {
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KokuhorenIFUpdataProcess.PARAMETER_SHORIYM, getParameter().getShoriYM());
        processParameter.put(KokuhorenIFUpdataProcess.PARAMETER_KOKANSHIKIBETSUNO, getParameter().getKokanjohoShikibetsuNo());
        processParameter.put(KokuhorenIFUpdataProcess.PARAMETER_SHORIJOTAIKUBUN, KokuhorenIFShoriJotaiKubun.処理中.getKubun());
        return simpleBatch(KokuhorenIFUpdataProcess.class)
                .arguments(processParameter)
                .define();
    }

    @Step(KYUFUKANRIHYO_DELETE)
    IBatchFlowCommand kyufuKanrihyoDeleteProcess() {
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KyufuKanrihyoDeleteProcess.PARAMETER_SHORIYM, getParameter().getShoriYM());
        return simpleBatch(KyufuKanrihyoDeleteProcess.class)
                .arguments(processParameter)
                .define();

    }

    @Step(SHAREDFILE_COPY)
    IBatchFlowCommand sharedFileCopy() {
        Map<RString, Object> processParameter = new HashMap<>();
        // TODO 業務内共通のフォルダが決まっていない
        processParameter.put(SharedFileCopy.PARAMETER_IN_FILEPATH, new RString(System.getenv("USERPROFILE").replace('\\', '/') + "/shared/"));
        processParameter.put(SharedFileCopy.PARAMETER_IN_SHAREDNAME, sharedFileKey);
        processParameter.put(SharedFileCopy.PARAMETER_IN_ICCHIJOKEN, IcchiJoken.前方一致);

        return simpleBatch(SharedFileCopy.class)
                .arguments(processParameter)
                .define();
    }

    @Step(TEMP_SAVE_PROCESS)
    IBatchFlowCommand kyufuKanrihyoInBatchRegistTempSaveProcess() {

        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KyufuKanrihyoInBatchRegistTempSaveProcess.PARAMETER_FILEPATH, runFilePath);

        return loopBatch(KyufuKanrihyoInBatchRegistTempSaveProcess.class)
                .arguments(processParameter)
                .define();
    }

    @Step(GET_EDIT_INFO)
    IBatchFlowCommand kyufuKanrihyoInBatchRegistGetEditInfoProcess() {
        Map<RString, Object> processParameter = new HashMap<>();

        return simpleBatch(KyufuKanrihyoInBatchRegistGetEditInfoProcess.class)
                .arguments(processParameter)
                .define();

    }

    @Step(FILE_READ_PROCESS)
    IBatchFlowCommand kyufuKanrihyoInBatchRegistFileReadProcess() {

        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KyufuKanrihyoInBatchRegistFileReadProcess.PARAMETER_SHORINENGETSU, getParameter().getShoriNichiji());
        return loopBatch(KyufuKanrihyoInBatchRegistFileReadProcess.class)
                .arguments(processParameter)
                .define();
    }

    @Step(CSV_OUTPUT_PROCESS)
    IBatchFlowCommand kyufuKanrihyoInBatchRegistCsvOutputProcess() {
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KyufuKanrihyoInBatchRegistCsvOutputProcess.INPUT_PARAM_KEY_出力順ID, Long.parseLong(getParameter().getShutsuryokujunID().toString()));
        return loopBatch(KyufuKanrihyoInBatchRegistCsvOutputProcess.class)
                .arguments(processParameter)
                .define();
    }

    @Step(KOKUHORENIFKANRI_UPDATE_CTRLRECORD)
    IBatchFlowCommand kokuhorenIFUpdateCtrlRecordProcess() {
        HashMap<RString, RString> filePathList = getResult(HashMap.class, new RString(SHAREDFILE_COPY), SharedFileCopy.PARAMETER_OUT_FILEPATHLIST);
        RString a = filePathList.keySet().iterator().next();
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KokuhorenIFUpdateCtrlRecordProcess.PARAMETER_SHORIYM, getParameter().getShoriYM());
        processParameter.put(KokuhorenIFUpdateCtrlRecordProcess.PARAMETER_KOKANSHIKIBETSUNO, getParameter().getKokanjohoShikibetsuNo());
        processParameter.put(KokuhorenIFUpdateCtrlRecordProcess.PARAMETER_FILENAME, filePathList.keySet().iterator().next());
        processParameter.put(KokuhorenIFUpdateCtrlRecordProcess.PARAMETER_FILENAME, filePathList.keySet().iterator().next());
        processParameter.put(KokuhorenIFUpdateCtrlRecordProcess.PARAMETER_SHORINICHIJI, getParameter().getShoriNichiji());
        return simpleBatch(KokuhorenIFUpdateCtrlRecordProcess.class)
                .arguments(processParameter)
                .define();
    }

    @Step(KOKUHORENIFKANRI_UPDATE_FINISH)
    IBatchFlowCommand kokuhorenIFFinishUpdataProcess() {
        Map<RString, Object> processParameter = new HashMap<>();
        processParameter.put(KokuhorenIFUpdataProcess.PARAMETER_SHORIYM, getParameter().getShoriYM());
        processParameter.put(KokuhorenIFUpdataProcess.PARAMETER_KOKANSHIKIBETSUNO, getParameter().getKokanjohoShikibetsuNo());
        processParameter.put(KokuhorenIFUpdataProcess.PARAMETER_SHORIJOTAIKUBUN, KokuhorenIFShoriJotaiKubun.処理済.getKubun());
        return simpleBatch(KokuhorenIFUpdataProcess.class)
                .arguments(processParameter)
                .define();
    }
}
