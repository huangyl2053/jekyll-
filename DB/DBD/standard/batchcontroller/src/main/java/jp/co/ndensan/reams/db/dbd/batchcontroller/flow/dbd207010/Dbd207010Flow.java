/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow.dbd207010;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd207010.ShiharaiHohoKanriListProcess;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.dbd207010.Dbd207010BatchFlowParameter;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 支払方法変更管理リスト作成_バッチフロークラスです。
 * 
 * @reamsid_L DBD-3630-040  zhulx
 */
public class Dbd207010Flow extends BatchFlowBase<Dbd207010BatchFlowParameter> {

    @Override
    protected void defineFlow() {
        executeStep(支払方法変更管理リスト発行);
    }

    private static final String 支払方法変更管理リスト発行 = "set支払方法変更管理リスト";
    
    /**
     * 支払方法変更管理リスト発行を行います。
     * @return バッチコマンド
     */
    @Step(支払方法変更管理リスト発行)
    protected IBatchFlowCommand set支払方法変更管理リスト() {
        return loopBatch(ShiharaiHohoKanriListProcess.class)
                .arguments(getParameter().toShiharaiHohoKanriListProcessParameter())
                .define();
    }

}
