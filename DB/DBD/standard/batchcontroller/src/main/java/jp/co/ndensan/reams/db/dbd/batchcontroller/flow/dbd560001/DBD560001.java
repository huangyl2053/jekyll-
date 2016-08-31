/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd560001;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd560001.NinteidetaikkatsukousinKoukiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd560001.NinteidetaikkatsukousinTanitsuProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd560001.DBD560001Parameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 認定データ一括更新のバッチフロークラスです。
 *
 * @reamsid_L DBD-2120-020 liuwei2
 */
public class DBD560001 extends BatchFlowBase<DBD560001Parameter> {

    private static final String 導入形態コードは211場合 = "update認定データ一括211場合";
    private static final String 導入形態コードは220以外の場合 = "update認定データ一括220以外の場合";

    @Override
    protected void defineFlow() {
//        if (ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定).get導入形態コード().value().
//                equals(DonyuKeitaiCode.認定広域.getCode())) {
        executeStep(導入形態コードは211場合);
//        } else if (ShichosonSecurityJoho.getShichosonSecurityJoho(GyomuBunrui.介護認定).get導入形態コード().value().
//                equals(DonyuKeitaiCode.認定単一.getCode())) {
//            executeStep(導入形態コードは220以外の場合);
//        }
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(導入形態コードは211場合)
    protected IBatchFlowCommand update認定データ一括認定広域() {
        return loopBatch(NinteidetaikkatsukousinKoukiProcess.class)
                .arguments(getParameter().toDBD560001Parameter())
                .define();
    }

    /**
     * batchProcessです。
     *
     * @return IBatchFlowCommand
     */
    @Step(導入形態コードは220以外の場合)
    protected IBatchFlowCommand update認定データ一括認定単一() {
        return loopBatch(NinteidetaikkatsukousinTanitsuProcess.class)
                .arguments(getParameter().toDBD560001Parameter())
                .define();
    }
}
