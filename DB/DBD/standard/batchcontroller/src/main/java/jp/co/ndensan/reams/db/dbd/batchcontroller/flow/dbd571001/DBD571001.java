/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd571001;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd571001.JukyushaDaichoCyouhyoujouhouProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd571001.JukyushaDaichoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd571001.DBD571001Parameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 受給者台帳バッチのフロークラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
public class DBD571001 extends BatchFlowBase<DBD571001Parameter> {

    private static final String 受給者台帳処理一時テーブル = "受給者台帳処理一時テーブル";
    private static final String 受給者台帳処理帳票出力用情報 = "受給者台帳処理帳票出力用情報";

    @Override
    protected void defineFlow() {
        executeStep(受給者台帳処理一時テーブル);
        executeStep(受給者台帳処理帳票出力用情報);
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(受給者台帳処理一時テーブル)
    protected IBatchFlowCommand callHanyoListShisetsuNyutaishoFlow() {
        return loopBatch(JukyushaDaichoProcess.class).
                arguments(getParameter().toIdoChushutsuDaichoProcessParameter()).define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(受給者台帳処理帳票出力用情報)
    protected IBatchFlowCommand callHanyoListShisetsuNyutaishonewFlow() {
        return loopBatch(JukyushaDaichoCyouhyoujouhouProcess.class).
                arguments(getParameter().toIdoChushutsuDaichoProcessParameter()).define();
    }
}
