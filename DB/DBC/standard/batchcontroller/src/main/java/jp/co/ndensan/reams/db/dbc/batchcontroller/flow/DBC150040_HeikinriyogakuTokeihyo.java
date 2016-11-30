/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150040.HeikinRiyoGakuTokeihyoCyouHyouProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150040.HeikinriyogakuTokeihyoProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150040.KyufujissekiTempTblUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC150040.SyorikekkaCyouHyouProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC150040.DBC150040_HeikinriyogakuTokeihyoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 平均利用額統計表作成のバッチ処理クラスです。
 *
 * @reamsid_L DBC-3490-030 yaoyahui
 */
public class DBC150040_HeikinriyogakuTokeihyo extends BatchFlowBase<DBC150040_HeikinriyogakuTokeihyoParameter> {

    private static final String 平均利用額統計表一時TBL作成 = "HeikinriyogakuTokeihyoProcess";
    private static final String 給付実績データ一時TBL更新 = "KyufujissekiTempTblUpdateProcess";
    private static final String 平均利用額統計帳票作成 = "HeikinRiyoGakuTokeihyoCyouHyouProcess";
    private static final String 処理結果確認リストCSV出力 = "SyorikekkaCyouHyouProcess";

    @Override
    protected void defineFlow() {
        executeStep(平均利用額統計表一時TBL作成);
        executeStep(給付実績データ一時TBL更新);
        executeStep(平均利用額統計帳票作成);
        executeStep(処理結果確認リストCSV出力);
    }

    /**
     * 均利用額統計表一時TBL作成
     *
     * @return バッチコマンド
     */
    @Step(平均利用額統計表一時TBL作成)
    protected IBatchFlowCommand callHeikinriyogakuTokeihyoProcess() {
        return loopBatch(HeikinriyogakuTokeihyoProcess.class).arguments(getParameter().
                toHeikinriyogakuTokeihyoProcessParameter()).define();
    }

    /**
     * 給付実績データ一時TBL更新
     *
     * @return バッチコマンド
     */
    @Step(給付実績データ一時TBL更新)
    protected IBatchFlowCommand callKyufujissekiTempTblUpdateProcess() {
        return loopBatch(KyufujissekiTempTblUpdateProcess.class).define();
    }

    /**
     * 平均利用額統計帳票作成
     *
     * @return バッチコマンド
     */
    @Step(平均利用額統計帳票作成)
    protected IBatchFlowCommand callHeikinRiyoGakuTokeihyoCyouHyouProcess() {
        return loopBatch(HeikinRiyoGakuTokeihyoCyouHyouProcess.class).arguments(getParameter()
                .toHeikinriyogakuTokeihyoProcessParameter()).define();
    }

    /**
     * 処理結果確認リスト帳票作成
     *
     * @return バッチコマンド
     */
    @Step(処理結果確認リストCSV出力)
    protected IBatchFlowCommand callSyorikekkaCyouHyouProcess() {
        return loopBatch(SyorikekkaCyouHyouProcess.class).arguments(getParameter().
                toHeikinriyogakuTokeihyoProcessParameter()).define();
    }
}
