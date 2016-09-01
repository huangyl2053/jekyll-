/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.batchcontroller.flow;

import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA010010.HihokenshaDaichoKoshinProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA010010.NenreitotatsuJokenUpdateProcess;
import jp.co.ndensan.reams.db.dba.batchcontroller.step.DBA010010.ParameterSetProcess;
import jp.co.ndensan.reams.db.dba.definition.batchprm.DBA010010.DBA010010_NenreitotatsuShikakuIdoParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba010010.HihokenshaDaichoKoshinProcessParameter;
import jp.co.ndensan.reams.db.dba.definition.processprm.dba010010.NenreitotatsuJokenUpdateProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * ６５歳年齢到達資格異動_バッチフロークラスです。
 *
 * @reamsid_L DBA-0330-010 xuyue
 */
public class DBA010010_NenreitotatsuShikakuIdo extends BatchFlowBase<DBA010010_NenreitotatsuShikakuIdoParameter> {

    private static final String バッチ内で抽出条件の生成 = "get開始日And終了日";
    private static final String 被保険者台帳管理の更新 = "updHihokenshaDaicho";
    private static final String 年齢到達条件の更新 = "updNenreitotatsuJoken";

    @Override
    protected void defineFlow() {

        if (getParameter() == null || getParameter().getKaishiYMD().isEmpty() || getParameter().getShuryoYMD().isEmpty()) {
            executeStep(バッチ内で抽出条件の生成);
        }
        executeStep(被保険者台帳管理の更新);
        executeStep(年齢到達条件の更新);
    }

    /**
     * バッチ内で抽出条件の生成を行います。
     *
     * @return バッチコマンド
     */
    @Step(バッチ内で抽出条件の生成)
    protected IBatchFlowCommand get開始日And終了日() {
        return simpleBatch(ParameterSetProcess.class)
                .define();
    }

    /**
     * 資格異動対象者の取得と被保険者台帳の更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(被保険者台帳管理の更新)
    protected IBatchFlowCommand updHihokenshaDaicho() {

        HihokenshaDaichoKoshinProcessParameter parameter;
        if (getParameter() == null || getParameter().getKaishiYMD().isEmpty() || getParameter().getShuryoYMD().isEmpty()) {
            parameter = setBatchParameter();
        } else {
            parameter = getParameter().toShikakuIdoTaishoshaShutokuProcessParameter();
        }
        return simpleBatch(HihokenshaDaichoKoshinProcess.class)
                .arguments(parameter)
                .define();
    }

    /**
     * 年齢到達条件の更新を行います。
     *
     * @return バッチコマンド
     */
    @Step(年齢到達条件の更新)
    protected IBatchFlowCommand updNenreitotatsuJoken() {

        return simpleBatch(NenreitotatsuJokenUpdateProcess.class)
                .arguments(createUpdateParameter())
                .define();
    }

    private HihokenshaDaichoKoshinProcessParameter setBatchParameter() {
        HihokenshaDaichoKoshinProcessParameter param = new HihokenshaDaichoKoshinProcessParameter();
        param.set開始日(getResult(FlexibleDate.class, new RString(バッチ内で抽出条件の生成), ParameterSetProcess.KAISHI_YMD));
        param.set終了日(getResult(FlexibleDate.class, new RString(バッチ内で抽出条件の生成), ParameterSetProcess.SHURYO_YMD));
        return param;
    }

    private NenreitotatsuJokenUpdateProcessParameter createUpdateParameter() {
        NenreitotatsuJokenUpdateProcessParameter parameter = new NenreitotatsuJokenUpdateProcessParameter();
        parameter.setFlowParam(getParameter());
        return parameter;
    }

}
