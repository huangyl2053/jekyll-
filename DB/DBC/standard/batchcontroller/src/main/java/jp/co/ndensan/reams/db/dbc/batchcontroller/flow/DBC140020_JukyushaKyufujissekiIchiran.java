/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140020.SelectKyuhuZissekiKihonJoukenChushutuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140020.SelectKyuhuZissekiKougakuKaigoHiJoukenChushutuProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140020.TyouhyouSakuseiProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC140020.DBC140020_JukyushaKyufujissekiIchiranParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 受給者給付実績一覧表 のパラメータ
 *
 * @reamsid_L DBC-3070-030 dangjingjing
 */
public class DBC140020_JukyushaKyufujissekiIchiran extends BatchFlowBase<DBC140020_JukyushaKyufujissekiIchiranParameter> {

    private static final String 給付実績基本条件抽出 = "selectKyuhuZissekiKihonJoukenChushutuProcess";
    private static final String 給付実績高額介護費条件抽出 = "selectKyuhuZissekiKougakuKaigoHiJoukenChushutuProcess";
    private static final String 帳票作成条件抽出 = "tyouhyouSakuseiProcess";

    @Override
    protected void defineFlow() {
        executeStep(給付実績基本条件抽出);
        executeStep(給付実績高額介護費条件抽出);
        executeStep(帳票作成条件抽出);
    }

    /**
     * 給付実績基本条件抽出
     *
     * @return SelectKyuhuZissekiKihonJoukenChushutuProcess
     */
    @Step(給付実績基本条件抽出)
    protected IBatchFlowCommand selectKyuhuZissekiKihonJoukenChushutuProcess() {
        return loopBatch(SelectKyuhuZissekiKihonJoukenChushutuProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiIchiranProcessParameter()).define();
    }

    /**
     * 給付実績高額介護費条件抽出
     *
     * @return SelectKyuhuZissekiKougakuKaigoHiJoukenChushutuProcess
     */
    @Step(給付実績高額介護費条件抽出)
    protected IBatchFlowCommand selectKyuhuZissekiKougakuKaigoHiJoukenChushutuProcess() {
        return loopBatch(SelectKyuhuZissekiKougakuKaigoHiJoukenChushutuProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiIchiranProcessParameter()).define();
    }

    /**
     * 帳票作成
     *
     * @return TyouhyouSakuseiProcess
     */
    @Step(帳票作成条件抽出)
    protected IBatchFlowCommand tyouhyouSakuseiProcess() {
        return loopBatch(TyouhyouSakuseiProcess.class).define();
    }

}
