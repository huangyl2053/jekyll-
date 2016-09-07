/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055001;

import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendofuka.HonSanteiIdoKanendoFuka;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 世帯員把握Processdeです。
 *
 * @reamsid_L DBB-0910-010 gongliang
 */
public class CollectSetaiinProcess extends SimpleBatchProcessBase {

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonSanteiIdoKanendoFuka service = HonSanteiIdoKanendoFuka.createInstance();
        service.collectSetaiin();
    }

    @Override
    protected void afterExecute() {
    }
}
