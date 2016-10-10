/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD571001.JukyushaDaichoCyouhyoujouhouProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD571001.JukyushaDaichoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD571001.DBD571001_JukyushaDaichoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給者台帳バッチのフロークラスです。
 *
 * @reamsid_L DBD-1760-020 panxiaobo
 */
public class DBD571001_JukyushaDaicho extends BatchFlowBase<DBD571001_JukyushaDaichoParameter> {

    private static final String 受給者台帳処理一時テーブル = "受給者台帳処理一時テーブル";
    private static final String 受給者台帳処理帳票出力用情報 = "受給者台帳処理帳票出力用情報";

    @Override
    protected void defineFlow() {
        RString temptable;
        executeStep(受給者台帳処理一時テーブル);
        temptable = getResult(RString.class, new RString(受給者台帳処理一時テーブル), JukyushaDaichoProcess.OUT_TEMP_TABLE);
        if (temptable.equals(new RString("1"))) {
            executeStep(受給者台帳処理帳票出力用情報);
        }

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
