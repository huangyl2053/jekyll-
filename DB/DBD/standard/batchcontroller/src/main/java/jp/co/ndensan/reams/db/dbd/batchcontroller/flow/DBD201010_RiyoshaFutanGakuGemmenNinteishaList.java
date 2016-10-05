/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD201010.ChohyoShutsuryokuJohoShutokuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD201010.HchiJinoSyouriCreateProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD201010.DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBDZ00001.DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用者負担額減免認定者リスト作成バッチクラスです．
 *
 * @reamsid_L DBD-3980-030 x_youyj
 */
public class DBD201010_RiyoshaFutanGakuGemmenNinteishaList extends BatchFlowBase<DBD201010_RiyoshaFutanGakuGemmenNinteishaListParameter> {
    
    /**
     * 非課税年金対象者同定フロー
     */
    private static final RString HIKAIFLOW = new RString("DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakusei");

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
     * @return IBatchFlowCommand
     */
    @Step(対象者一次特定)
    protected IBatchFlowCommand hchiJinoSyouriCreateProcess() {
        return loopBatch(HchiJinoSyouriCreateProcess.class)
                .arguments(getParameter().toHchiJinoSyouriCreateProcessParamter())
                .define();
    }

    /**
     * 減免減額対象者判定用根拠作成です。
     *
     * @return IBatchFlowCommand
     */
    @Step(減免減額対象者判定用根拠作成)
    protected IBatchFlowCommand gennmennTaisyouSkuse() {
       return otherBatchFlow(HIKAIFLOW, SubGyomuCode.DBD介護受給,
               new DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter(getParameter().get所得年度())).define();
    }

    /**
     * 利用者負担額減免認定者リスト発行です。
     *
     * @return IBatchFlowCommand
     */
    @Step(利用者負担額減免認定者リスト発行)
    protected IBatchFlowCommand riyoushilyaHutannCsvProcess() {
        return loopBatch(ChohyoShutsuryokuJohoShutokuProcess.class)
                .arguments(getParameter().toChohyoShutsuryokuJohoShutokuProcessParameter())
                .define();
    }

}
