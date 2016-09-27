/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011.ShunoJokyoHaakuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD209011.ShunoTainoJokyoHaakuProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt32004.KyufuGakuGengakuTainoShaProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt32004.TaishoShaKanriJohoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD209012.DBD209012_KyufuGakuGengakuKanriListParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32003.ShunoJokyoHaakuProcessParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbdbt32003.ShunoTainoJokyoHaakuProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * バッチ設計_DBDBT32004_給付額減額管理リストフロークラスです．
 *
 * @reamsid_L DBD-3800-030 x_xuliang
 */
public class DBD209012_KyufuGakuGengakuKanriLis extends BatchFlowBase<DBD209012_KyufuGakuGengakuKanriListParameter> {

    private static final String 収納状況把握情報の取得 = "shunoJokyoHaaku";
    private static final String 対象者管理情報の取得 = "KyufuGengakuKanriListTaishoTokutei";
    private static final String 収納滞納状況把握情報の取得 = "shunoTainoJokyoHaaku";
    private static final String 給付額減額滞納者把握情報取得 = "KyufuGengakuKanriListSakusei";

    private YMDHMS systemTime;
    private RDateTime rDateTime;

    @Override
    protected void initialize() {
        systemTime = YMDHMS.now();
        rDateTime = systemTime.getRDateTime();
    }

    @Override
    protected void defineFlow() {

        executeStep(収納状況把握情報の取得);
        executeStep(対象者管理情報の取得);
        executeStep(収納滞納状況把握情報の取得);
        executeStep(給付額減額滞納者把握情報取得);

    }

    /**
     * 収納状況把握情報の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(収納状況把握情報の取得)
    protected IBatchFlowCommand shunoJokyoHaakuProcess() {
        return loopBatch(ShunoJokyoHaakuProcess.class)
                .arguments(new ShunoJokyoHaakuProcessParameter(getParameter().get基準日())).define();
    }

    /**
     * 対象者管理情報の取得
     *
     * @return バッチコマンド
     */
    @Step(対象者管理情報の取得)
    protected IBatchFlowCommand kyufuGengakuKanriListTaishoTokuteiProcess() {
        return loopBatch(TaishoShaKanriJohoProcess.class)
                .arguments(getParameter().toTaishoshaIchijiTokuteiProcessParameter())
                .define();
    }

    /**
     * 収納滞納状況把握情報の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(収納滞納状況把握情報の取得)
    protected IBatchFlowCommand shunoTainoJokyoHaaku() {
        return loopBatch(ShunoTainoJokyoHaakuProcess.class)
                .arguments(new ShunoTainoJokyoHaakuProcessParameter(getParameter().get基準日())).define();
    }

    /**
     * 給付額減額滞納者把握情報取得
     *
     * @return バッチコマンド
     */
    @Step(給付額減額滞納者把握情報取得)
    protected IBatchFlowCommand kyufuGengakuKanriListSakuseiProcess() {
        return loopBatch(KyufuGakuGengakuTainoShaProcess.class)
                .arguments(getParameter().toKyufuGakuGengakuTainoShaProcessParameter(rDateTime))
                .define();
    }

}
