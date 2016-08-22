
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbdbt00004;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00004.NinteishaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00004.TaishoshaIchijiTokuteiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBDBT00004.DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmenGengakuTaishoShaHanteiYoukonSakusei.GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter;
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
public class DBD200004_ShakaiFukushiHojinKeigenNinteishaListFlow extends BatchFlowBase<DBD200004_ShakaiFukushiHojinKeigenNinteishaBatchParameter> {

    private static final String 対象者一次特定 = "TaishoshaIchijiTokuteiProcess";
    private static final String 減免減額対象者判定用根拠作成 = "GemmmenGengakuTaishoshaHanteiYoKonkyoSakusei";
    private static final RString バッチID_DBDBZZ0001 = new RString("GemmenGengakuTaishoShaHanteiYoukonSakuseiFlow");
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
    protected IBatchFlowCommand 減免減額対象者判定用根拠作成() {
        GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter youkonsakuseiparameter
                = new GemmenGengakuTaishoShaHanteiYoukonSakuseiParameter(getParameter().get所得年度());
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
