/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc640011.KogakuGassanJikofutangakuShomeishoInProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc640011.KogakuGassanJikofutangakuTempProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoInParamerter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoInProcessParamerter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額合算自己負担額証明書情報または高額合算自己負担額確認情報（CSVファイル）を読み込み、DBに取り込むflowクラスです
 *
 * @reamsid_L DBC-2640-011 qinzhen
 */
public class DBC640011_KogakuGassanJikofutangakuShomeishoIn extends BatchFlowBase<KogakuGassanJikofutangakuShomeishoInParamerter> {

    private static final String CSVファイル取込 = "callReadCsvFileProcess";
    private static final String 処理結果リスト一時登録 = "callErrorTempInsertProcess";
    private static final Integer INDEX_0 = 0;
    private KogakuGassanJikofutangakuShomeishoInProcessParamerter parameter;

    @Override
    protected void defineFlow() {
        parameter = new KogakuGassanJikofutangakuShomeishoInProcessParamerter();
        parameter.setPath(getParameter().get保存先フォルダ());
        List<RString> fileNameList = getParameter().getエントリ情報List();
        if (fileNameList != null && !fileNameList.isEmpty()) {
            for (int i = INDEX_0; i < fileNameList.size(); i++) {
                parameter.setFileName(fileNameList.get(i));
                executeStep(CSVファイル取込);
            }
        }
        executeStep(処理結果リスト一時登録);
    }

    /**
     * CSVファイル取込です。
     *
     * @return KogakuGassanJikofutangakuShomeishoInProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        return loopBatch(KogakuGassanJikofutangakuShomeishoInProcess.class).arguments(parameter).define();
    }

    /**
     * 処理結果リスト一時登録です。
     *
     * @return DbWT0002KokuhorenTorikomiErrorTempProcess
     */
    @Step(処理結果リスト一時登録)
    protected IBatchFlowCommand callErrorTempInsertProcess() {
        return loopBatch(KogakuGassanJikofutangakuTempProcess.class).define();
    }
}
