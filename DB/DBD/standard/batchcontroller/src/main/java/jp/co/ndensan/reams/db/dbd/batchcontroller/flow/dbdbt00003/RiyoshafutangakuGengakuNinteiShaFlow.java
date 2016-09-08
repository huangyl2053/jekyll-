/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbdbt00003;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00003.NinteishaListSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt00003.TaishoshaIchijiTokuteiProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdbt00003.RiyoshafutangakuGengakuNinteiShaParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
;

/**
 * 訪問介護利用者負担額減額認定者リスト作成
 *
 * @reamsid_L DBD-3970-030 x_xuliang
 */
public class RiyoshafutangakuGengakuNinteiShaFlow extends BatchFlowBase<RiyoshafutangakuGengakuNinteiShaParameter> {

    private static final String 対象者一次特定一時テーブル登録 = "TaishoshaIchijiTokutei";
    private static final String 訪問介護利用者負担額減額認定者リスト発行 = "NinteishaListSakusei";
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
}
