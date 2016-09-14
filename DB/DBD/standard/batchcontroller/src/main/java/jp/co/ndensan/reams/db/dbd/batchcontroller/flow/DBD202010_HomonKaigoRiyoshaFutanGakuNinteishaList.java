/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00003.NinteishaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00003.TaishoshaIchijiTokuteiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD202010.DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaListParameter;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBDZ00001.DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 訪問介護利用者負担額減額認定者リスト作成
 *
 * @reamsid_L DBD-3970-030 x_xuliang
 */
public class DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaList
        extends BatchFlowBase<DBD202010_HomonKaigoRiyoshaFutanGakuNinteishaListParameter> {

    private static final String 対象者一次特定一時テーブル登録 = "TaishoshaIchijiTokutei";
    private static final String 減免減額対象者判定用根拠作成バッチ = "GemmenGengakuTaishoshaHanteiYoKonkyoSakusei";
    private static final String 訪問介護利用者負担額減額認定者リスト発行 = "NinteishaListSakusei";

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
        executeStep(対象者一次特定一時テーブル登録);
        executeStep(減免減額対象者判定用根拠作成バッチ);
        executeStep(訪問介護利用者負担額減額認定者リスト発行);
    }

    /**
     * 対象者一次特定一時テーブル登録を行います。
     *
     * @return バッチコマンド
     */
    @Step(対象者一次特定一時テーブル登録)
    protected IBatchFlowCommand createTempTableProcess() {
        return loopBatch(TaishoshaIchijiTokuteiProcess.class)
                .arguments(getParameter().toTaishoshaIchijiTokuteiProcessParameter())
                .define();
    }

    @Step(減免減額対象者判定用根拠作成バッチ)
    protected IBatchFlowCommand jissiJyokyohyoHakkou() {
        return otherBatchFlow(減免減額対象者判定用根拠作成バッチID, SubGyomuCode.DBD介護受給,
                createGemmenGengakuTaishoShaHanteiYoukonSakuseiParameter()).define();
    }

    /**
     * 訪問介護利用者負担額減額認定者リスト発行を行います。
     *
     * @return バッチコマンド
     */
    @Step(訪問介護利用者負担額減額認定者リスト発行)
    protected IBatchFlowCommand reportProcess() {
        return loopBatch(NinteishaListSakuseiProcess.class)
                .arguments(getParameter().toNinteishaListSakuseiProcessParameter(システム日時))
                .define();
    }

    private DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter createGemmenGengakuTaishoShaHanteiYoukonSakuseiParameter() {
        return new DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakuseiParameter(getParameter().get所得年度());
    }
}
