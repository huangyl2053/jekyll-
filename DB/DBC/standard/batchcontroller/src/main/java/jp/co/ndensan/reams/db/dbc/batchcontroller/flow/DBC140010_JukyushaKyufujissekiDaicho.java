/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC140010.KyuuhuZissekiKihonProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC140010.DBC140010_JukyushaKyufujissekiDaichoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 受給者給付実績台帳 のバッチフロークラスです。
 *
 * @reamsid_L DBC-3080-030 dongyabin
 */
public class DBC140010_JukyushaKyufujissekiDaicho extends BatchFlowBase<DBC140010_JukyushaKyufujissekiDaichoParameter> {

    private static final String 給付実績基本 = "KyuuhuZissekiKihonProcess";

    @Override
    protected void defineFlow() {
        executeStep(給付実績基本);
    }

    /**
     * DBのテーブルから情報を取得する
     *
     * @return KyuuhuZissekiKihonProcess
     */
    @Step(給付実績基本)
    protected IBatchFlowCommand callKyuuhuZissekiKihonProcess() {
        return loopBatch(KyuuhuZissekiKihonProcess.class)
                .arguments(getParameter().toJukyushaKyufujissekiDaichoProcessParameter()).define();
    }

}
