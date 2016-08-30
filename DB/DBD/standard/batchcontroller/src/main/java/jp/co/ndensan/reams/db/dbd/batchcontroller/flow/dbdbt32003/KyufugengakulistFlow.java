/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbdbt32003;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt32003.KyufuGengakuHaakuListSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt32003.KyufuGengakuHaakuListTaishoTokuteiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt32003.ShunoJokyoHaakuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt32003.ShunoTainoJokyoHaakuProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbdbt32003.KyufuGengakuHaakuIchiranBatchParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 給付額減額滞納者把握リスト（バッチ）フロークラスです．
 *
 * @reamsid_L DBD-3610-030 x_lilh
 */
public class KyufugengakulistFlow extends BatchFlowBase<KyufuGengakuHaakuIchiranBatchParameter> {

    private static final String 収納状況把握情報の取得 = "shunoJokyoHaaku";
    private static final String 対象者把握情報の取得 = "kyufuGengakuHaakuListTaishoTokutei";
    private static final String 収納滞納状況把握情報の取得 = "shunoTainoJokyoHaaku";
    private static final String 給付額減額滞納者把握情報取得 = "kyufuGengakuHaakuListSakusei";

    @Override
    protected void defineFlow() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Step(収納状況把握情報の取得)
    protected IBatchFlowCommand shunoJokyoHaakuProcess() {
        return loopBatch(ShunoJokyoHaakuProcess.class)
                .arguments(getParameter().toShunoJokyoHaakuProcessParameter()).define();
    }

    @Step(対象者把握情報の取得)
    protected IBatchFlowCommand kyufuGengakuHaakuListTaishoTokuteiProcess() {
        return loopBatch(KyufuGengakuHaakuListTaishoTokuteiProcess.class)
                .arguments(getParameter().toKyufuGengakuHaakuListTaishoTokuteiProcessParameter()).define();
    }

    @Step(収納滞納状況把握情報の取得)
    protected IBatchFlowCommand shunoTainoJokyoHaaku() {
        return loopBatch(ShunoTainoJokyoHaakuProcess.class)
                .arguments(getParameter().toShunoJokyoHaakuProcessParameter()).define();
    }

    @Step(給付額減額滞納者把握情報取得)
    protected IBatchFlowCommand kyufuGengakuHaakuListSakusei() {
        return loopBatch(KyufuGengakuHaakuListSakuseiProcess.class)
                .arguments(getParameter().toKyufuGengakuHaakuListSakuseiProcessParameter()).define();
    }
}
