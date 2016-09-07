/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb011003;

import jp.co.ndensan.reams.db.dbb.service.core.tokuchokarisanteitsuchishohakko.TokuchoKaishiTsuchishoDataHenshu;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 賦課情報の取得
 *
 * @reamsid_L DBB-0790-030 chenaoqi
 */
public class GetFukaJohoProcess extends SimpleBatchProcessBase {

    private TokuchoKaishiTsuchishoDataHenshu manager;

    @Override
    protected void beforeExecute() {
        manager = TokuchoKaishiTsuchishoDataHenshu.createInstance();
    }

    @Override
    protected void process() {
        manager.getFukaJoho();
    }

    @Override
    protected void afterExecute() {

    }

}
