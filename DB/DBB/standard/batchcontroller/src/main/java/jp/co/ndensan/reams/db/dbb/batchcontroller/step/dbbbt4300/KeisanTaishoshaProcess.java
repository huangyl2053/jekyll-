/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt4300;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt4300.HonsanteiFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.honnsanteifuka.HonnSanteiFuka;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 計算対象者抽出・通知書番号発番クラスです。
 *
 * @reamsid_L DBB-0730-010 yuanzhenxia
 */
public class KeisanTaishoshaProcess extends SimpleBatchProcessBase {

    private HonnSanteiFuka business;
    private HonsanteiFukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        business = HonnSanteiFuka.createInstance();
    }

    @Override
    protected void process() {
        business.selectKeisanTaishosha(processParameter.get調定年度(), processParameter.get賦課年度(), processParameter.get資格基準日());
    }

}
