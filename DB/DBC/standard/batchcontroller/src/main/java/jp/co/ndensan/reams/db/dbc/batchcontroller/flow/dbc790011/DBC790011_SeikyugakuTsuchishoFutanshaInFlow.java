/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow.dbc790011;

import java.util.List;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc790011.DbWT0002KokuhorenTorikomiErrorTempProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.dbc790011.SeikyugakuTsuchishoFutanshaInProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInParameter;
import jp.co.ndensan.reams.db.dbc.definition.processprm.seikyugakutsuchishofutanshain.SeikyugakuTsuchishoFutanshaInProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 請求額通知書情報取込共通処理（CSVファイル取込・公費負担者分）flowクラスです
 *
 * @reamsid_L DBC-2790-011 hemin
 */
public class DBC790011_SeikyugakuTsuchishoFutanshaInFlow extends BatchFlowBase<SeikyugakuTsuchishoFutanshaInParameter> {

    private static final String CSVファイル取込 = "readCsvFile";
    private static final String 処理結果リスト一時登録 = "errorTempInsert";
    private static final Integer INDEX_0 = 0;

    @Override
    protected void defineFlow() {
        executeStep(CSVファイル取込);
        executeStep(処理結果リスト一時登録);
    }

    /**
     * CSVファイル取込です。
     *
     * @return SeikyugakuTsuchishoFutanshaInProcess
     */
    @Step(CSVファイル取込)
    protected IBatchFlowCommand callReadCsvFileProcess() {
        SeikyugakuTsuchishoFutanshaInProcessParameter parameter = new SeikyugakuTsuchishoFutanshaInProcessParameter();
        parameter.setPath(getParameter().get保存先フォルダ());
        List<RString> fileNameList = getParameter().getエントリ情報List();
        if (fileNameList != null && !fileNameList.isEmpty()) {
            for (int i = INDEX_0; i <= fileNameList.size(); i++) {
                parameter.setFileName(fileNameList.get(i));
                return loopBatch(SeikyugakuTsuchishoFutanshaInProcess.class).arguments(parameter).define();
            }
        }
        return null;
    }

    /**
     * 処理結果リスト一時登録です。
     *
     * @return DbWT0002KokuhorenTorikomiErrorTempProcess
     */
    @Step(処理結果リスト一時登録)
    protected IBatchFlowCommand callErrorTempInsertProcess() {
        return loopBatch(DbWT0002KokuhorenTorikomiErrorTempProcess.class).define();
    }
}
