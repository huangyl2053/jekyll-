package jp.co.ndensan.reams.db.dbe.batchcontroller.flow.hokokushiryosakusei;

import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.CsvKenHokokuShiryoSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.JigyoJyokyoHokokuDataSakuseiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.JigyoJyokyoHokokuProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.JisshiJokyoTokeiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.JotaikubumbetsuhanteiProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.ShinsahanteinoHenkojokyoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.ShinsakaiShukeiGenzainojokyoProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.ShinsakaiShukeihyoShinseiBetsuProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.ShinsakaishukeihyoHanteiBetsuProcess;
import jp.co.ndensan.reams.db.dbe.batchcontroller.step.hokokushiryosakusei.SinsakaiHanteiJyokyoProcess;
import jp.co.ndensan.reams.db.dbe.definition.batchprm.hokokushiryosakusei.HokokuShiryoSakuSeiBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 報告資料作成のバッチフロークラスです。
 *
 * @reamsid_L DBE-1450-020 wangxiaodong
 */
public class HokokuShiryoSakuSeiFlow extends BatchFlowBase<HokokuShiryoSakuSeiBatchParameter> {

    private static final String 事業状況データ作成 = "jigyoJyokyoDataSakuSei";
    private static final String 事業状況報告出力 = "jigyoJyokyoHokoku";
    private static final String 認定実施状況統計 = "jissiJyokyoTokei";
    private static final String 審査判定状況出力 = "sinsaHanteiJyokyo";
    private static final String 状態区分別判定 = "jotaikubumbetsuhantei";
    private static final String 審査判定変更状況 = "shinsahanteinoHenkojokyo";
    private static final String 審査会集計表判定別 = "shinsakaishukeihyoHanteiBetsu";
    private static final String 審査会集計表申請区分別 = "shinsakaiShukeihyoShinseiBetsu";
    private static final String 審査会集計表現在状況別 = "shinsakaiShukeiGenzainojokyo";
    private static final String 県報告用資料情報作成 = "csvKenHokokuShiryoSakusei";

    @Override
    protected void defineFlow() {
        if (getParameter().isJigyoJyokyoHokoku()) {
            executeStep(事業状況データ作成);
            executeStep(事業状況報告出力);
        }
        if (getParameter().isJissiJyokyoTokei()) {
            executeStep(認定実施状況統計);
        }
        if (getParameter().isSinsaHanteiJyokyo()) {
            executeStep(審査判定状況出力);
        }
        if (getParameter().isSinsakaiKanrenTokei()) {
            executeStep(状態区分別判定);
            executeStep(審査判定変更状況);
            executeStep(審査会集計表判定別);
            executeStep(審査会集計表申請区分別);
            executeStep(審査会集計表現在状況別);
        }
        if (getParameter().isCsvShutsuryoku()) {
            executeStep(県報告用資料情報作成);
        }
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
        return loopBatch(JigyoJyokyoHokokuProcess.class)
                .arguments(getParameter().toJigyoJyokyoHokokuProcessParameter()).define();
    }

    /**
     * 要介護認定実施状況統計情報の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(認定実施状況統計)
    protected IBatchFlowCommand selectJisshiJokyoTokei() {
        return loopBatch(JisshiJokyoTokeiProcess.class)
                .arguments(getParameter().toJisshiJokyoTokeiProcessParameter()).define();
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
     * 要介護状態区分別判定件数の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(状態区分別判定)
    protected IBatchFlowCommand selectJotaikubumbetsuhantei() {
        return loopBatch(JotaikubumbetsuhanteiProcess.class)
                .arguments(getParameter().toSinsakaiHanteiJyokyoProcessParameter()).define();
    }

    /**
     * 審査判定の変更状況の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(審査判定変更状況)
    protected IBatchFlowCommand selectShinsahanteinoHenkojokyo() {
        return loopBatch(ShinsahanteinoHenkojokyoProcess.class)
                .arguments(getParameter().toShinsahanteinoHenkojokyoProcessParameter()).define();
    }

    /**
     * 審査判定の変更状況の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(審査会集計表判定別)
    protected IBatchFlowCommand selectShinsakaishukeihyoHanteiBetsu() {
        return loopBatch(ShinsakaishukeihyoHanteiBetsuProcess.class)
                .arguments(getParameter().toSinsakaiHanteiJyokyoProcessParameter()).define();
    }

    /**
     * 介護認定審査会集計表（申請区分別）の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(審査会集計表申請区分別)
    protected IBatchFlowCommand selectShinsakaiShukeihyoShinseiBetsu() {
        return loopBatch(ShinsakaiShukeihyoShinseiBetsuProcess.class)
                .arguments(getParameter().toShinsakaiShukeihyoShinseiBetsuProcessParameter()).define();
    }

    /**
     * 介護認定審査会集計表（申請区分別）の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(審査会集計表現在状況別)
    protected IBatchFlowCommand selectShinsakaiShukeiGenzainojokyo() {
        return loopBatch(ShinsakaiShukeiGenzainojokyoProcess.class)
                .arguments(getParameter().toShinsakaiShukeiGenzainojokyoProcessParameter()).define();
    }

    /**
     * 県報告用資料情報の作成を行います。
     *
     * @return バッチコマンド
     */
    @Step(県報告用資料情報作成)
    protected IBatchFlowCommand selectCsvKenHokokuShiryo() {
        return loopBatch(CsvKenHokokuShiryoSakuseiProcess.class)
                .arguments(getParameter().toCsvKenHokokuShiryoSakuseiProcessParameter()).define();
    }
}
