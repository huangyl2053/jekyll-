/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.CreateFukaJohoKeizokuProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka.TokuchoKariSanteiFukaManager;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 賦課計算_継続process
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class CreateFukaJohoKeizokuProcess extends SimpleBatchProcessBase {

    private CreateFukaJohoKeizokuProcessParameter parameter;
    private TokuchoKariSanteiFukaManager manager;

    @Override
    protected void beforeExecute() {
        manager = TokuchoKariSanteiFukaManager.createInstance();
    }

    @Override
    protected void process() {
        manager.createFukaJohoKeizoku(parameter.get調定年度(), parameter.get調定日時());
    }
}
