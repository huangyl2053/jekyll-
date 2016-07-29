/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt36001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.karisanteiidokekka.KarisanteiIdoKekkaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.karisanteiidofuka.KariSanteiIdoFukaBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 賦課計算(口座異動のみ反映)クラスです。
 *
 * @reamsid_L DBB-0850-010 zhaowei
 */
public class CaluculateFukaKozaIdoProcess extends SimpleBatchProcessBase {

    private KarisanteiIdoKekkaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        KariSanteiIdoFukaBatch manager = KariSanteiIdoFukaBatch.createInstance();
        manager.caluculateFukaKozaIdo(processParameter.get賦課年度(), new YMDHMS(processParameter.get調定日時()));
    }

    @Override
    protected void afterExecute() {
    }
}
