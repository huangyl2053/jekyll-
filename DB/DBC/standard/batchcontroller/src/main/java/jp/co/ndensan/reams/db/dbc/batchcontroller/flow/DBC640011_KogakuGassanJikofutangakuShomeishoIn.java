/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC640011.KogakuGassanJikofutangakuShomeishoInProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoInParamerter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoInProcessParamerter;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakugassanjikofutangakushomeishoin.KogakuGassanJikofutangakuShomeishoFlowEntity;
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
    private static final Integer INDEX_0 = 0;
    private int 高額合算自己負担額一時TBL登録件数 = 0;
    private int レコード件数合算 = 0;
    private KogakuGassanJikofutangakuShomeishoFlowEntity flowEntity;
    private KogakuGassanJikofutangakuShomeishoInProcessParamerter parameter;

    @Override
    protected void defineFlow() {
        parameter = new KogakuGassanJikofutangakuShomeishoInProcessParamerter();
        parameter.setPath(getParameter().get保存先フォルダ());
        List<RString> fileNameList = getParameter().getエントリ情報List();
        if (fileNameList != null && !fileNameList.isEmpty()) {
            for (int i = INDEX_0; i < fileNameList.size(); i++) {
                parameter.setFileName(fileNameList.get(i));
                if (i == 0) {
                    parameter.set処理年月(null);
                    parameter.set連番(0);
                } else {
                    parameter.set処理年月(flowEntity.getShoriYM());
                    parameter.set連番(flowEntity.get連番());
                }
                if (i == fileNameList.size() - 1) {
                    parameter.setさいごファイルフラグ(true);
                } else {
                    parameter.setさいごファイルフラグ(false);
                }
                executeStep(CSVファイル取込);
                flowEntity = getResult(KogakuGassanJikofutangakuShomeishoFlowEntity.class, new RString(CSVファイル取込),
                        KogakuGassanJikofutangakuShomeishoInProcess.PARAMETER_OUT_FLOWENTITY);
                レコード件数合算 = レコード件数合算 + flowEntity.getCodeNum();
                parameter.setレコード件数合算(レコード件数合算);
                if (高額合算自己負担額一時TBL登録件数 == INDEX_0) {
                    高額合算自己負担額一時TBL登録件数 = 高額合算自己負担額一時TBL登録件数 + flowEntity.get高額合算自己負担額一時TBL登録件数();
                } else {
                    高額合算自己負担額一時TBL登録件数 = flowEntity.get高額合算自己負担額一時TBL登録件数();
                }
            }
        }
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
}
