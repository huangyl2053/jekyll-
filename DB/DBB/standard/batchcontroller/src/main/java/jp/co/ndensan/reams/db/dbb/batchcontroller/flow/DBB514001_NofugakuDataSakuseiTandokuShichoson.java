/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.flow;

import java.util.List;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB514001.NofugakuJohoReportProcess;
import jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB514001.NofugakuJohoSakuseiProcess;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB514001.DBB514001_NofugakuDataSakuseiTandokuShichosonParameter;
import jp.co.ndensan.reams.db.dbb.definition.batchprm.DBB514001.NofugakuDataTsushutsuJoken;
import jp.co.ndensan.reams.db.dbb.definition.processprm.nofugakudatasakuseitandokushichoson.NofugakuDataProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納付額データ作成クラスです。
 *
 * @reamsid_L DBB-1890-030 chenaoqi
 */
public class DBB514001_NofugakuDataSakuseiTandokuShichoson
        extends BatchFlowBase<DBB514001_NofugakuDataSakuseiTandokuShichosonParameter> {

    private static final String 納付額情報作成 = "nofugakuJohoSakusei";
    private static final String 納付額一覧表作成 = "nofugakuReportSakusei";

    private NofugakuDataProcessParameter processParameter;

    @Override
    protected void defineFlow() {
        List<NofugakuDataTsushutsuJoken> 抽出条件List = getParameter().get抽出条件List();
        for (NofugakuDataTsushutsuJoken 抽出条件 : 抽出条件List) {
            processParameter = getProcessParameter();
            processParameter.set抽出条件(抽出条件);
            executeStep(納付額情報作成);
            executeStep(納付額一覧表作成);
        }
    }

    /**
     * 納付額情報作成クラスです。
     *
     * @return NofugakuJohoSakuseiProcess
     */
    @Step (納付額情報作成)
    protected IBatchFlowCommand nofugakuJohoSakusei() {
        return loopBatch(NofugakuJohoSakuseiProcess.class).
                arguments(processParameter).define();
    }

    /**
     * 納付額一覧表作成クラスです。
     *
     * @return NofugakuJohoSakuseiProcess
     */
    @Step (納付額一覧表作成)
    protected IBatchFlowCommand nofugakuReportSakusei() {
        return loopBatch(NofugakuJohoReportProcess.class).
                arguments(processParameter).define();
    }

    private NofugakuDataProcessParameter getProcessParameter() {
        processParameter = new NofugakuDataProcessParameter();
        processParameter.set出力順ID(new RString(getParameter().get出力順ID()));
        processParameter.set対象年(getParameter().get対象年());
        processParameter.set非課税年金(getParameter().is非課税年金のみ作成フラグ());
        return processParameter;
    }
}
