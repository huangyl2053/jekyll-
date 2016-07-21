/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt4300;

import jp.co.ndensan.reams.db.dbb.service.core.honnsanteifuka.HonnSanteiFuka;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 世帯員把握のクラスです。
 *
 * @reamsid_L DBB-0730-010 yuanzhenxia
 */
public class SetaiinProcess extends SimpleBatchProcessBase {

    private HonnSanteiFuka business;

    @Override
    protected void beforeExecute() {
        business = HonnSanteiFuka.createInstance();
    }

    @Override
    protected void process() {
        business.collectSetaiin();
    }
}
