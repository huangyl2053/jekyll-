/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt32004.KyufuGakuGengakuTainoShaProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbdbt32004.TaishoShaKanriJohoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD209010.DBD209010_KyufuGakuGengakuListParameter;
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
public class DBD209010_KyufuGakuGengakuList extends BatchFlowBase<DBD209010_KyufuGakuGengakuListParameter> {

    private static final String 対象者管理情報の取得 = "KyufuGengakuKanriListTaishoTokutei";
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

        executeStep(対象者管理情報の取得);
        executeStep(給付額減額滞納者把握情報取得);

    }

    /**
     * 対象者管理情報の取得
     *
     * @return バッチコマンド
     */
    @Step(対象者管理情報の取得)
    protected IBatchFlowCommand KyufuGengakuKanriListTaishoTokuteiProcess() {
        return loopBatch(TaishoShaKanriJohoProcess.class)
                .arguments(getParameter().toTaishoshaIchijiTokuteiProcessParameter())
                .define();
    }

    /**
     * 給付額減額滞納者把握情報取得
     *
     * @return バッチコマンド
     */
    @Step(給付額減額滞納者把握情報取得)
    protected IBatchFlowCommand KyufuGengakuKanriListSakuseiProcess() {
        return loopBatch(KyufuGakuGengakuTainoShaProcess.class)
                .arguments(getParameter().toKyufuGakuGengakuTainoShaProcessParameter(rDateTime))
                .define();
    }

}
