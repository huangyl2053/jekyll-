/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055001;

import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendofuka.HonSanteiIdoKanendoFukaBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 過年度賦課_計算後情報を削除Processdeです。
 *
 * @reamsid_L DBB-0910-010 gongliang
 */
public class DeleteKeisangoJohoTempProcess extends SimpleBatchProcessBase {

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonSanteiIdoKanendoFukaBatch service = HonSanteiIdoKanendoFukaBatch.createInstance();
        service.deleteKeisangoJohoTemp();
    }
}
