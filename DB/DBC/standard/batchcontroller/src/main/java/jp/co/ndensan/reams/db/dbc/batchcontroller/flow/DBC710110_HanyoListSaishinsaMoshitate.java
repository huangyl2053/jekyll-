/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710110.SaishinsaMoshitateAriProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC710110.SaishinsaMoshitateNashiProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC710110.DBC710110_HanyoListSaishinsaMoshitateParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;
import jp.co.ndensan.reams.uz.uza.lang.RDate;

/**
 * 汎用リスト 再審査申立情報のバッチ用パラメータフロークラスです。
 *
 * @reamsid_L DBC-3106-020 zhengsongling
 */
public class DBC710110_HanyoListSaishinsaMoshitate extends BatchFlowBase<DBC710110_HanyoListSaishinsaMoshitateParameter> {

    private static final String 再審査申立情報_連番あり = "hanyoListSaishinsaMoshitateAri";
    private static final String 再審査申立情報_連番なし = "hanyoListSaishinsaMoshitateNashi";
    private RDate date;

    @Override
    protected void defineFlow() {
        date = RDate.getNowDate();
        if (getParameter().isRenbanFuka()) {
            executeStep(再審査申立情報_連番あり);
        } else {
            executeStep(再審査申立情報_連番なし);
        }
    }

    @Step(再審査申立情報_連番あり)
    IBatchFlowCommand callKijunShunyugakuTekiyoRebanari() {
        return loopBatch(SaishinsaMoshitateAriProcess.class).arguments(getParameter().toSaishinsamoshitateProcessParameterr(date)).define();
    }

    @Step(再審査申立情報_連番なし)
    IBatchFlowCommand callKijunShunyugakuTekiyoRebannashi() {
        return loopBatch(SaishinsaMoshitateNashiProcess.class).arguments(getParameter().toSaishinsamoshitateProcessParameterr(date)).define();
    }
}
