/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.batchcontroller.flow;

import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100020.DBUpdateProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100020.KetteiTsuchishoIchiranhyoPrintProcess;
import jp.co.ndensan.reams.db.dbc.batchcontroller.step.DBC100020.KetteiTsuchishoPrintProcess;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.DBC100020.DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter;
import jp.co.ndensan.reams.uz.uza.batch.Step;
import jp.co.ndensan.reams.uz.uza.batch.flow.BatchFlowBase;
import jp.co.ndensan.reams.uz.uza.batch.flow.IBatchFlowCommand;

/**
 * 住宅改修理由書作成手数料支給（不支給）決定通知書作成バッチフロークラスです．
 *
 * @reamsid_L DBC-2850-030 zuotao
 */
public class DBC100020_KaishuriyushoShikyuKetteitsuchisho extends BatchFlowBase<DBC100020_KaishuriyushoShikyuKetteitsuchishoParameter> {

    private static final String 決定通知書発行 = "KetteiTsuchishoPrint";
    private static final String 決定通知書一覧表発行 = "KetteiTsuchishoIchiranhyoPrint";
    private static final String DB更新 = "DBUpdate";

    @Override
    protected void defineFlow() {
        executeStep(決定通知書発行);
        executeStep(決定通知書一覧表発行);
        executeStep(DB更新);
    }

    @Step(決定通知書発行)
    IBatchFlowCommand printKetteiTsuchisho() {
        return loopBatch(KetteiTsuchishoPrintProcess.class)
                .arguments(getParameter().toKaishuriyushoShikyuKetteitsuchishoProcessParameter()).define();
    }

    @Step(決定通知書一覧表発行)
    IBatchFlowCommand printKetteiTsuchishoIchiranhyo() {
        return loopBatch(KetteiTsuchishoIchiranhyoPrintProcess.class)
                .arguments(getParameter().toKaishuriyushoShikyuKetteitsuchishoProcessParameter()).define();
    }

    @Step(DB更新)
    IBatchFlowCommand updateDB() {
        return loopBatch(DBUpdateProcess.class)
                .arguments(getParameter().toKaishuriyushoShikyuKetteitsuchishoProcessParameter()).define();
    }
}
