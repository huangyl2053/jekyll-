/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055003;

import jp.co.ndensan.reams.db.dbb.definition.processprm.honsanteiidokanendofuka.IdoFukaJohoFlgTrueProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendotsuchishoikkatsuhakko.HonsanteiIdoKanendoTsuchishoIkkatsuHakko;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 異動分賦課情報取得するクラスです。
 *
 * @reamsid_L DBB-0920-030 huzongcheng
 */
public class IdoFukaJohoFlgTrueProcess extends SimpleBatchProcessBase {

    private IdoFukaJohoFlgTrueProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonsanteiIdoKanendoTsuchishoIkkatsuHakko service = HonsanteiIdoKanendoTsuchishoIkkatsuHakko.createInstance();
        service.getIdoFukaJohoFlgTrue(processParameter.get調定年度(), processParameter.get回目());
    }

    @Override
    protected void afterExecute() {
    }
}
