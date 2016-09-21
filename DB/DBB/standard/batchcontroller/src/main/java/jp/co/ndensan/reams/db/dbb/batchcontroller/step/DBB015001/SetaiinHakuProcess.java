/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.DBB015001;

import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka.KariSanteiIdoFukaBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 世帯員把握クラスです。
 *
 * @reamsid_L DBB-0850-010 zhaowei
 */
public class SetaiinHakuProcess extends SimpleBatchProcessBase {

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        KariSanteiIdoFukaBatch manager = KariSanteiIdoFukaBatch.createInstance();
        manager.collectSetaiin();
    }

    @Override
    protected void afterExecute() {

    }
}
