/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbdbt00002;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00002.ChohyoShutsuryokuJohoShutokuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00002.HchiJinoSyouriCreateProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdbt00002.RiyouShiryaFutannGakuGennmennKonntennlyaFlowParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00002.ChohyoShutsuryokuJohoShutokuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt00002.HchiJinoSyouriCreateProcessParamter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 利用者負担額減免認定者リスト作成バッチクラスです．
 *
 * @reamsid_L DBD-3980-030 x_youyj
 */
public class RiyouShiryaFutannGakuGennmennKonntennlyaListFlow extends BatchFlowBase<RiyouShiryaFutannGakuGennmennKonntennlyaFlowParameter> {

    private static final String 対象者一次特定 = "対象者一次特定";

    private static final String 減免減額対象者判定用根拠作成 = "減免減額対象者判定用根拠作成";

    private static final String 利用者負担額減免認定者リスト発行 = "利用者負担額減免認定者リスト発行";

    @Override
    protected void defineFlow() {
        executeStep(対象者一次特定);
        executeStep(減免減額対象者判定用根拠作成);
        executeStep(利用者負担額減免認定者リスト発行);
    }

    /**
     * 対象者一次特定です。
     *
     *
     * @return IBatchFlowCommand
     */
    @Step(対象者一次特定)
    protected IBatchFlowCommand hchiJinoSyouriCreateProcess() {
        return loopBatch(HchiJinoSyouriCreateProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    private HchiJinoSyouriCreateProcessParamter createProcessParameter() {
        RiyouShiryaFutannGakuGennmennKonntennlyaFlowParameter parameter = getParameter();
        return parameter.toHchiJinoSyouriCreateProcessParamter();
    }

    /**
     * 減免減額対象者判定用根拠作成です。
     *
     *
     */
    @Step(減免減額対象者判定用根拠作成)
    protected void gennmennTaisyouSkuse() {
        //TODO
    }

    /**
     * 利用者負担額減免認定者リスト発行です。
     *
     *
     * @return IBatchFlowCommand
     */
    @Step(利用者負担額減免認定者リスト発行)
    protected IBatchFlowCommand riyoushilyaHutannCsvProcess() {
        return loopBatch(ChohyoShutsuryokuJohoShutokuProcess.class)
                .arguments(createCsvProcessParameter())
                .define();
    }

    private ChohyoShutsuryokuJohoShutokuProcessParameter createCsvProcessParameter() {
        RiyouShiryaFutannGakuGennmennKonntennlyaFlowParameter parameter = getParameter();
        return parameter.toChohyoShutsuryokuJohoShutokuProcessParameter();
    }
}
