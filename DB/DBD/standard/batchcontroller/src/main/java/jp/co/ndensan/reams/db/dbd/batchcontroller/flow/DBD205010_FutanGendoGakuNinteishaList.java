/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD205010.NinteishaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD205010.TaishoshaIchijiTokuteiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD205010.DBD205010_FutanGendoGakuNinteishaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBDZ00001.DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定者リスト作成バッチクラスです。
 *
 * @reamsid_L DBD-3960-030 x_liuwei
 */
public class DBD205010_FutanGendoGakuNinteishaList extends BatchFlowBase<DBD205010_FutanGendoGakuNinteishaListParameter> {

    private static final String 対象者一次特定 = "対象者一次特定";

    private static final String 減免減額対象者判定用根拠作成 = "減免減額対象者判定用根拠作成";

    private static final String 負担限度額認定者リスト発行 = "負担限度額認定者リスト発行";

    private static final RString 減免減額対象者判定用根拠作成バッチID = new RString("DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakusei");
    private YMDHMS systemTime;
    private RDateTime システム日時;

    @Override
    protected void initialize() {
        systemTime = YMDHMS.now();
        システム日時 = systemTime.getRDateTime();
    }

    @Override
    protected void defineFlow() {
        executeStep(対象者一次特定);
        executeStep(減免減額対象者判定用根拠作成);
        executeStep(負担限度額認定者リスト発行);
    }

    /**
     * 対象者一次特定一時テーブル登録を行います。
     *
     * @return バッチコマンド
     */
    @Step(対象者一次特定)
    protected IBatchFlowCommand createTempTableProcess() {
        return loopBatch(TaishoshaIchijiTokuteiProcess.class)
                .arguments(getParameter().toTaishoshaIchijiTokuteiProcessParameter())
                .define();
    }

    /**
     * 減免減額対象者判定用根拠作成。
     *
     * @return IBatchFlowCommand
     */
    @Step(減免減額対象者判定用根拠作成)
    protected IBatchFlowCommand jissiJyokyohyoHakkou() {
        return otherBatchFlow(減免減額対象者判定用根拠作成バッチID, SubGyomuCode.DBD介護受給,
                createGemmenGengakuTaishoShaHanteiYoukonSakuseiParameter()).define();
    }

    /**
     * 負担限度額認定者リスト発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(負担限度額認定者リスト発行)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(NinteishaListSakuseiProcess.class)
                .arguments(getParameter().toNinteishaListSakuseiProcessParameter(システム日時))
                .define();
    }

    private DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter createGemmenGengakuTaishoShaHanteiYoukonSakuseiParameter() {
        return new DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter(getParameter().get所得年度());
    }
}
