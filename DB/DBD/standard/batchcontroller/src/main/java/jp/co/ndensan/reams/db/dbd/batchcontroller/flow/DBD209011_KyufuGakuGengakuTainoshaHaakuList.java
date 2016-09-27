/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011.KyufuGengakuHaakuListSakuseiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011.KyufuGengakuHaakuListTaishoTokuteiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011.ShunoJokyoHaakuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011.ShunoTainoJokyoHaakuProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD209011.DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * 給付額減額滞納者把握リスト（バッチ）フロークラスです．
 *
 * @reamsid_L DBD-3610-030 x_lilh
 */
public class DBD209011_KyufuGakuGengakuTainoshaHaakuList extends BatchFlowBase<DBD209011_KyufuGakuGengakuTainoshaHaakuListParameter> {

    private static final String 収納状況把握情報の取得 = "shunoJokyoHaaku";
    private static final String 対象者把握情報の取得 = "kyufuGengakuHaakuListTaishoTokutei";
    private static final String 収納滞納状況把握情報の取得 = "shunoTainoJokyoHaaku";
    private static final String 給付額減額滞納者把握情報取得 = "kyufuGengakuHaakuListSakusei";
//    private RDateTime バッチ起動時処理日時;

    @Override
    protected void prepareConfigData() {
//        バッチ起動時処理日時 = RDate.getNowDateTime();
    }

    @Override
    protected void defineFlow() {
        executeStep(収納状況把握情報の取得);
        //        executeStep(対象者把握情報の取得);
//        executeStep(収納滞納状況把握情報test);
//        executeStep(収納滞納状況把握情報の取得);
//        executeStep(給付額減額滞納者把握情報取得);
    }

    /**
     * 収納状況把握情報の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(収納状況把握情報の取得)
    protected IBatchFlowCommand shunoJokyoHaakuProcess() {
        return loopBatch(ShunoJokyoHaakuProcess.class)
                .arguments(getParameter().toShunoJokyoHaakuProcessParameter()).define();
    }

    /**
     * 対象者把握情報の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(対象者把握情報の取得)
    protected IBatchFlowCommand kyufuGengakuHaakuListTaishoTokuteiProcess() {
        return loopBatch(KyufuGengakuHaakuListTaishoTokuteiProcess.class)
                .arguments(getParameter().toKyufuGengakuHaakuListTaishoTokuteiProcessParameter()).define();
    }

    /**
     * 収納滞納状況把握情報の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(収納滞納状況把握情報の取得)
    protected IBatchFlowCommand shunoTainoJokyoHaaku() {
        return loopBatch(ShunoTainoJokyoHaakuProcess.class)
                .arguments(getParameter().toShunoTainoJokyoHaakuProcessParameter()).define();
    }

    /**
     * 給付額減額滞納者把握情報取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(給付額減額滞納者把握情報取得)
    protected IBatchFlowCommand kyufuGengakuHaakuListSakusei() {
        return loopBatch(KyufuGengakuHaakuListSakuseiProcess.class)
                .arguments(getParameter().toKyufuGengakuHaakuListSakuseiProcessParameter(RDateTime.MAX)).define();
    }
}
