/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011.ShunoJokyoHaakuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD210010.KyufuSeikentaishoshaCsvProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD210010.ShiharaiHouhouKanriHitotokiOutput;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD210010.TainouJokyoHitotokiOutput;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD210010.DBD210010_KyufuSeigenTaishoshaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd209011.ShunoJokyoHaakuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd210010.DBD210010ProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;

/**
 * 給付制限対象者一覧CSVのbatchクラスです。
 *
 * @reamsid_L DBD-4300-030 liuwei2
 */
public class DBD210010_KyufuSeigenTaishoshaList extends BatchFlowBase<DBD210010_KyufuSeigenTaishoshaListParameter> {

    private static final String 支払方法管理一時DBを作成する = "set支払方法管理一時";
    private static final String 滞納状況一時DBを作成する = "set滞納状況一時";
    private static final String 収納状況一時DBを作成する = "set収納状況一時DB";
    private static final String 給付制限対象者CSVを作成する = "set給付制限対象者CSV";

    @Override
    protected void defineFlow() {
        executeStep(支払方法管理一時DBを作成する);
        executeStep(滞納状況一時DBを作成する);
        executeStep(収納状況一時DBを作成する);
        executeStep(給付制限対象者CSVを作成する);
    }

    /**
     * set支払方法管理一時のProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(支払方法管理一時DBを作成する)
    protected IBatchFlowCommand set支払方法管理一時() {
        return loopBatch(ShiharaiHouhouKanriHitotokiOutput.class)
                .arguments(createProcessParameter())
                .define();
    }

    /**
     * set滞納状況一時のProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(滞納状況一時DBを作成する)
    protected IBatchFlowCommand set滞納状況一時() {
        return loopBatch(TainouJokyoHitotokiOutput.class)
                .arguments(createProcessParameter())
                .define();
    }

    /**
     * set収納状況一時DBのProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(収納状況一時DBを作成する)
    protected IBatchFlowCommand set収納状況一時DB() {
        return loopBatch(ShunoJokyoHaakuProcess.class)
                .arguments(createShunoJokyoHaakuProcessParameter()).define();
    }

    /**
     * set給付制限対象者CSVのProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(給付制限対象者CSVを作成する)
    protected IBatchFlowCommand set給付制限対象者CSV() {
        return loopBatch(KyufuSeikentaishoshaCsvProcess.class)
                .arguments(createProcessParameter()).define();
    }

    private DBD210010ProcessParameter createProcessParameter() {
        DBD210010_KyufuSeigenTaishoshaListParameter parameter = getParameter();
        DBD210010ProcessParameter processParameter = new DBD210010ProcessParameter();
        processParameter.set一号償還予告登録者(parameter.is一号償還予告登録者());
        processParameter.set一号償還決定登録者(parameter.is一号償還決定登録者());
        processParameter.set一号償還決定登録者_保険料控除あり(parameter.is一号償還決定登録者_保険料控除あり());
        processParameter.set一号償還決定登録者_差止中あり(parameter.is一号償還決定登録者_差止中あり());
        processParameter.set一号給付制限登録者(parameter.is一号給付制限登録者());
        processParameter.set二号差止予告登録者(parameter.is二号差止予告登録者());
        processParameter.set二号差止登録者(parameter.is二号差止登録者());
        processParameter.set全登録者(parameter.is全登録者());
        processParameter.set出力順ID(parameter.get出力順設定リスト());
        processParameter.set給付制限状態(parameter.get給付制限状態());
        return processParameter;
    }

    private ShunoJokyoHaakuProcessParameter createShunoJokyoHaakuProcessParameter() {
        ShunoJokyoHaakuProcessParameter processParameter = new ShunoJokyoHaakuProcessParameter(FlexibleDate.getNowDate());
        return processParameter;
    }
}
