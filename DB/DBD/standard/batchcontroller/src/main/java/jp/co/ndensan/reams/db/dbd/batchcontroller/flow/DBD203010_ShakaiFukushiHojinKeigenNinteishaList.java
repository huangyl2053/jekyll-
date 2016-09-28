
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD203010.NinteishaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD203010.TaishoshaIchijiTokuteiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD203010.DBD203010_ShakaiFukushiHojinKeigenNinteishaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBDZ00001.DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 社会福祉法人軽減認定者リスト作成のバッチフロークラスです。
 *
 * @reamsid_L DBD-3830-010 tianyh
 */
public class DBD203010_ShakaiFukushiHojinKeigenNinteishaList extends BatchFlowBase<DBD203010_ShakaiFukushiHojinKeigenNinteishaListParameter> {

    private static final String 対象者一次特定 = "TaishoshaIchijiTokuteiProcess";
    private static final String 減免減額対象者判定用根拠作成 = "減免減額対象者判定用根拠作成";
    private static final RString バッチID_DBDBZZ0001 = new RString("DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakusei");
    private static final String 社会福祉法人軽減認定者リスト作成 = "社会福祉法人軽減認定者リスト作成";
    private YMDHMS systemTime;

    @Override
    protected void initialize() {
        systemTime = YMDHMS.now();
    }

    @Override
    protected void defineFlow() {
        executeStep(対象者一次特定);
        executeStep(減免減額対象者判定用根拠作成);
        executeStep(社会福祉法人軽減認定者リスト作成);
    }

    /**
     * 対象者一次特定を取得します。
     *
     * @return バッチコマンド
     */
    @Step(対象者一次特定)
    protected IBatchFlowCommand getUpdateNotApplicantList() {
        return loopBatch(TaishoshaIchijiTokuteiProcess.class)
                .arguments(getParameter().createProcessParameter())
                .define();
    }

    /**
     * 減免減額対象者判定用根拠作成。
     *
     * @return バッチコマンド
     */
    @Step(減免減額対象者判定用根拠作成)
    protected IBatchFlowCommand youkonSakusei() {
        DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter youkonsakuseiparameter
                = new DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter(getParameter().get所得年度());
        return otherBatchFlow(バッチID_DBDBZZ0001, SubGyomuCode.DBD介護受給, youkonsakuseiparameter).define();
    }

    /**
     * 社会福祉法人軽減認定者リスト作成。
     *
     * @return IBatchFlowCommand
     */
    @Step(社会福祉法人軽減認定者リスト作成)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(NinteishaListSakuseiProcess.class)
                .arguments(getParameter().createNinteishaListSakuseiProcessParameter(systemTime))
                .define();
    }
}
