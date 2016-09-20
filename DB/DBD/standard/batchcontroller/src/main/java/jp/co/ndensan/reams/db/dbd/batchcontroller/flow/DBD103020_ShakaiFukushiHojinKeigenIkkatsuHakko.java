/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1200902.ShakaiFukushiHoujinnKeigenListProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1200902.ShakaiFukushiHoujinnKeigenNinnteiProcess;
import jp.co.ndensan.reams.db.dbd.batchcontroller.step.dbd1200902.ShakaiFukushiHoujinnKeigenTsuuchishoProcess;
import jp.co.ndensan.reams.db.dbd.definition.batchprm.DBD103020.DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakkoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 社会福祉法人等利用者負担額軽減確認証・通知書一括発行
 *
 * @reamsid_L DBD-3981-030 x_lilh
 */
public class DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakko extends BatchFlowBase<DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakkoParameter> {

    private static final String 社会福祉法人等軽減の認定証発行 = "社会福祉法人等軽減の認定証発行";
    private static final String 社会福祉法人等軽減の通知書発行 = "社会福祉法人等軽減の通知書発行";
    private static final String 社会福祉法人軽減確認証_決定通知書発行一覧表発行 = "社会福祉法人軽減確認証_決定通知書発行一覧表発行";

    @Override
    protected void defineFlow() {
        DBD103020_ShakaiFukushiHojinKeigenIkkatsuHakkoParameter parameter = getParameter();
        if (parameter.is認定証発行フラグ()) {
            executeStep(社会福祉法人等軽減の認定証発行);
        }
        if (parameter.is通知書発行フラグ()) {
            executeStep(社会福祉法人等軽減の通知書発行);
        }
        executeStep(社会福祉法人軽減確認証_決定通知書発行一覧表発行);
    }

    /**
     * 社会福祉法人等軽減の認定証発行.
     *
     * @return IBatchFlowCommand
     */
    @Step(社会福祉法人等軽減の認定証発行)
    protected IBatchFlowCommand shakaiFukushiHoujinnKeigenNinnteiProcess() {
        return loopBatch(ShakaiFukushiHoujinnKeigenNinnteiProcess.class)
                .arguments(getParameter().toShakaiFukushiHoujinnKeigenNinnteiProcessParameter())
                .define();
    }

    /**
     * 社会福祉法人等軽減の通知書発行.
     *
     * @return IBatchFlowCommand
     */
    @Step(社会福祉法人等軽減の通知書発行)
    protected IBatchFlowCommand shakaiFukushiHoujinnKeigenTsuuchishoProcess() {
        return loopBatch(ShakaiFukushiHoujinnKeigenTsuuchishoProcess.class)
                .arguments(getParameter().toShakaiFukushiHoujinnKeigenTsuuchishoProcessParameter())
                .define();
    }

    /**
     * 社会福祉法人軽減確認証_決定通知書発行一覧表発行.
     *
     * @return IBatchFlowCommand
     */
    @Step(社会福祉法人軽減確認証_決定通知書発行一覧表発行)
    protected IBatchFlowCommand shakaiFukushiHoujinnKeigenListProcess() {
        return loopBatch(ShakaiFukushiHoujinnKeigenListProcess.class)
                .arguments(getParameter().toShakaiFukushiHoujinnKeigenListProcessParameter())
                .define();
    }
}
