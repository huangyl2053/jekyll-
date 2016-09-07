/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd582001;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd582001.ShukihyoHakkouProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd582001.DBD582001Parameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 要介護認定月別受給者数状況表（統計表）のバッチフロークラスです。
 *
 * @reamsid_L DBD-1771-033 chenxin
 */
public class DBD582001 extends BatchFlowBase<DBD582001Parameter> {

    private static final String 集計表の発行 = "shukihyoHakkou";

    @Override
    protected void defineFlow() {
        executeStep(集計表の発行);
    }

    /**
     * 実施状況表の取得を行います。
     *
     * @return バッチコマンド
     */
    @Step(集計表の発行)
    protected IBatchFlowCommand shukihyoHakkou() {
        return loopBatch(ShukihyoHakkouProcess.class)
                .arguments(getParameter().toDBD582001ProcessParameter())
                .define();
    }

}
