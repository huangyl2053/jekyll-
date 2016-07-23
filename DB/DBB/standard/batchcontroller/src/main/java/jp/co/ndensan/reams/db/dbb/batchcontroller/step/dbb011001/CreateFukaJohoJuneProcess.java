/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.tokuchokarisanteifuka.CreateFukaJohoJuneProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteifuka.TokuchoKariSanteiFukaManagerBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 特徴仮算定対象抽出process
 *
 * @reamsid_L DBB-0700-010 xuhao
 */
public class CreateFukaJohoJuneProcess extends SimpleBatchProcessBase {

    private CreateFukaJohoJuneProcessParameter parameter;
    private TokuchoKariSanteiFukaManagerBatch manager;

    @Override
    protected void beforeExecute() {
        manager = TokuchoKariSanteiFukaManagerBatch.createInstance();
    }

    @Override
    protected void process() {
        manager.createFukaJohoJune(parameter.get調定年度(), parameter.get調定日時());
    }

}
