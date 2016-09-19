/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.futangendogaku.nintei.NinteiBatchKekkaHantei;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.futangendogaku.nintei.NinteiBatchKekkaListShutsuryoku;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.futangendogaku.nintei.NinteiBatchMain;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.gemmen.futangendogaku.nintei.NinteiBatchTaishoTokutei;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD101010.DBD101010_FutanGendogakuNinteiShinseiIkkatsuShoninParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 負担限度額認定申請一括承認のバッチフロークラスです。
 *
 * @reamsid_L DBD-3710-040 chenxin
 */
public class DBD101010_FutanGendogakuNinteiShinseiIkkatsuShonin extends BatchFlowBase<DBD101010_FutanGendogakuNinteiShinseiIkkatsuShoninParameter> {

    private static final String 処理対象の特定 = "ninteiBatchTaishoTokutei";
    private static final String 減免減額対象者判定用根拠作成 = "gemmmenGengakuTaishoshaHanteiYoKonkyoSakusei";
    private static final String 承認処理 = "ninteiBatchMain";
    private static final String 結果一覧出力 = "ninteiBatchKekkaListShutsuryoku";
    private static final String 一括認定結果反映 = "ninteiBatchKekkaHantei";
    private static final YMDHMS バッチ処理日時 = YMDHMS.now();
    private static final RString OTHER_BATCH_ID = new RString("DBDZ00001_GemmenGengakuTaishoshaHanteiYoKonkyoSakusei");

    @Override
    protected void defineFlow() {
        executeStep(処理対象の特定);
        executeStep(減免減額対象者判定用根拠作成);
        executeStep(承認処理);
        if (getParameter().is確認リスト出力()) {
            executeStep(結果一覧出力);
        }
        executeStep(一括認定結果反映);
    }

    /**
     * 処理対象の特定を行います。
     *
     * @return バッチコマンド
     */
    @Step(処理対象の特定)
    protected IBatchFlowCommand ninteiBatchJizenShori() {
        return loopBatch(NinteiBatchTaishoTokutei.class)
                .arguments(getParameter().toNinteiBatchTaishoTokuteiProcessParameter(バッチ処理日時))
                .define();
    }

    /**
     * 減免減額対象者判定用根拠作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(減免減額対象者判定用根拠作成)
    protected IBatchFlowCommand gemmmenGengakuTaishoshaHanteiYoKonkyoSakusei() {
        return otherBatchFlow(OTHER_BATCH_ID,
                SubGyomuCode.DBD介護受給,
                getParameter().toGemmenGengakuTaishoShaHanteiYoukonSakuseiParameter())
                .define();
    }

    /**
     * 承認処理を行います。
     *
     * @return バッチコマンド
     */
    @Step(承認処理)
    protected IBatchFlowCommand ninteiBatchMain() {
        return loopBatch(NinteiBatchMain.class)
                .arguments(getParameter().toNinteiBatchMainProcessParameter(バッチ処理日時))
                .define();
    }

    /**
     * 結果一覧出力を行います。
     *
     * @return バッチコマンド
     */
    @Step(結果一覧出力)
    protected IBatchFlowCommand ninteiBatchKekkaListShutsuryoku() {
        return loopBatch(NinteiBatchKekkaListShutsuryoku.class)
                .arguments(getParameter().toNinteiBatchKekkaListShutsuryokuProcessParameter(バッチ処理日時))
                .define();
    }

    /**
     * 一括認定結果反映を行います。
     *
     * @return バッチコマンド
     */
    @Step(一括認定結果反映)
    protected IBatchFlowCommand ninteiBatchKekkaHantei() {
        return loopBatch(NinteiBatchKekkaHantei.class)
                .arguments(getParameter().toNinteiBatchKekkaHanteiProcessParameter())
                .define();
    }

}
