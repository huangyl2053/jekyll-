/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.DBD511003.KoshinShinseishaHaakuListProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD511003.DBD511003_KoshinMiShinseishaHaakuParameter;
import jp.co.ndensan.reams.db.dbd.definition.processprm.dbd5110001.KoshinShinseishaHaakuListProcessParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 更新未申請者把握リスト作成のバッチフロークラスです。
 *
 * @reamsid_L DBD-1420-020 wangjie2
 */
public class DBD511003_KoshinMiShinseishaHaaku extends BatchFlowBase<DBD511003_KoshinMiShinseishaHaakuParameter> {

    private static final String 更新未申請者把握リスト情報の取得 = "getUpdateNotApplicantList";

    @Override
    protected void defineFlow() {
        executeStep(更新未申請者把握リスト情報の取得);
    }

    /**
     * システム日時の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(更新未申請者把握リスト情報の取得)
    protected IBatchFlowCommand getUpdateNotApplicantList() {
        return loopBatch(KoshinShinseishaHaakuListProcess.class)
                .arguments(createProcessParameter())
                .define();
    }

    private KoshinShinseishaHaakuListProcessParameter createProcessParameter() {
        DBD511003_KoshinMiShinseishaHaakuParameter parameter = getParameter();
        KoshinShinseishaHaakuListProcessParameter processParameter = new KoshinShinseishaHaakuListProcessParameter();
        processParameter.set印刷範囲指定(parameter.get印刷範囲指定());
        processParameter.set認定有効期間_終了月(parameter.get認定有効期間_終了月());
        processParameter.set認定有効期間_終了月_From(parameter.get認定有効期間_終了月_From());
        processParameter.set認定有効期間_終了月_To(parameter.get認定有効期間_終了月_To());
        return processParameter;
    }

}
