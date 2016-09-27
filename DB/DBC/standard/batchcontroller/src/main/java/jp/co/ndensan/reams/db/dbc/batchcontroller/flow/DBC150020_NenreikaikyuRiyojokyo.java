/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150020.KyufujissekiKyotakuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150020.KyufujissekiShukeiProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150020.NenreikaikyuRiyojokyoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150020.SyorikekkaCyouHyouProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150020.DBC150020_NenreikaikyuRiyojokyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 *
 * 年齢階級別利用状況作成flowクラスです。
 *
 * @reamsid_L DBC-3470-030 xuyongchao
 */
public class DBC150020_NenreikaikyuRiyojokyo extends BatchFlowBase<DBC150020_NenreikaikyuRiyojokyoParameter> {

    private static final String KYUFUJISSEKIKYOTAKU_PROCESS = "KyufujissekiKyotakuProcess";
    private static final String KYUFUJISSEKISHUKEI_PROCESS = "KyufujissekiShukeiProcess";
    private static final String 処理結果確認リストCSV出力 = "SyorikekkaCyouHyouProcess";
    private static final String 年齢階級別利用状況 = "NenreikaikyuRiyojokyoProcess";

    @Override
    protected void defineFlow() {
        executeStep(KYUFUJISSEKIKYOTAKU_PROCESS);
        executeStep(KYUFUJISSEKISHUKEI_PROCESS);
        executeStep(年齢階級別利用状況);
        executeStep(処理結果確認リストCSV出力);

    }

    /**
     * 給付実績居宅サービス計画費データ取得、「給付実績データ一時TBL」に登録する。
     *
     * @return IBatchFlowCommand
     */
    @Step(KYUFUJISSEKIKYOTAKU_PROCESS)
    protected IBatchFlowCommand createKyufujissekiKyotaku() {
        return loopBatch(KyufujissekiKyotakuProcess.class).arguments(
                getParameter().toNenreikaikyuRiyojokyoProcessParameter()).define();
    }

    /**
     * 給付実績集計データ取得、「給付実績データ一時TBL」に登録する。
     *
     * @return IBatchFlowCommand
     */
    @Step(KYUFUJISSEKISHUKEI_PROCESS)
    protected IBatchFlowCommand createKyufujissekiShukei() {
        return loopBatch(KyufujissekiShukeiProcess.class).arguments(
                getParameter().toNenreikaikyuRiyojokyoProcessParameter()).define();
    }

    /**
     * 年齢階級別利用状況帳票作成
     *
     * @return IBatchFlowCommand
     */
    @Step(年齢階級別利用状況)
    protected IBatchFlowCommand nenreikaikyuRiyojokyo() {
        return loopBatch(NenreikaikyuRiyojokyoProcess.class).arguments(
                getParameter().toNenreikaikyuRiyojokyoProcessParameter()).define();
    }

    /**
     * 処理結果確認リスト帳票作成
     *
     * @return バッチコマンド
     */
    @Step(処理結果確認リストCSV出力)
    protected IBatchFlowCommand syorikekkaCyouHyouProcess() {
        return loopBatch(SyorikekkaCyouHyouProcess.class).arguments(getParameter().
                toNenreikaikyuRiyojokyoProcessParameter()).define();
    }

}
