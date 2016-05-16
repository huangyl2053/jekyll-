package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hokokushiryosakusei;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.JigyoJyokyoHokokuDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.JigyoJyokyoHokokuProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.SinsakaiHanteiJyokyoProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.hokokushiryosakusei.HokokuShiryoSakuSeiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 報告資料作成のバッチフロークラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class HokokuShiryoSakuSeiFlow extends BatchFlowBase<HokokuShiryoSakuSeiBatchParameter> {

    private static final String 事業状況データ作成 = "jigyoJyokyoDataSakuSei";
    private static final String 事業状況報告出力 = "jigyoJyokyoHokoku";
    private static final String 審査判定状況出力 = "sinsaHanteiJyokyo";

    @Override
    protected void defineFlow() {
        if (getParameter().isJigyoJyokyoHokoku()) {
            executeStep(事業状況データ作成);
            executeStep(事業状況報告出力);
        }
        if (getParameter().isSinsaHanteiJyokyo()) {
            executeStep(審査判定状況出力);
        }
    }

    /**
     * 介護認定審査会判定状況表の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(審査判定状況出力)
    protected IBatchFlowCommand selectTaisyosyaByShinsakaiKaisaiNo() {
        return loopBatch(SinsakaiHanteiJyokyoProcess.class)
                .arguments(getParameter().toSinsakaiHanteiJyokyoProcessParameter()).define();
    }

    /**
     * 要介護認定事業状況データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事業状況データ作成)
    protected IBatchFlowCommand createJigyoJyokyoHokokuData() {
        return loopBatch(JigyoJyokyoHokokuDataSakuseiProcess.class)
                .arguments(getParameter().toJigyoJyokyoHokokuProcessParameter()).define();
    }

    /**
     * 要介護認定事業状況データの作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(事業状況報告出力)
    protected IBatchFlowCommand selectJigyoJyokyoHokoku() {
        return loopBatch(JigyoJyokyoHokokuProcess.class).define();
    }
}
