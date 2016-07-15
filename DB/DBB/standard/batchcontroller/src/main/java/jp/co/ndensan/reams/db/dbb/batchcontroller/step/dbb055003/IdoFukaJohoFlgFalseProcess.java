/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003;

import jp.co.ndensan.reams.db.dbb.definition.processprm.honsanteiidokanendofuka.KanendoHonsanteifukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendotsuchishoikkatsuhakko.HonsanteiIdoKanendoTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 異動分賦課情報取得するクラスです。
 *
 * @reamsid_L DBB-0920-030 huzongcheng
 */
public class IdoFukaJohoFlgFalseProcess extends SimpleBatchProcessBase {

    private KanendoHonsanteifukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonsanteiIdoKanendoTsuchishoIkkatsuHakko service = HonsanteiIdoKanendoTsuchishoIkkatsuHakko.createInstance();
        service.getIdoFukaJoho(processParameter.get調定年度(), processParameter.is一括発行起動フラグ());
    }

    @Override
    protected void afterExecute() {
    }
}
