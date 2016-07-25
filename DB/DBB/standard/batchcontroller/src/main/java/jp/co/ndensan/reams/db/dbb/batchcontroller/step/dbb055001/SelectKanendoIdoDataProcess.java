/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.kanendoidofuka.KanendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendofuka.HonSanteiIdoKanendoFuka;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 賦課根拠異動抽出Processdeです。
 *
 * @reamsid_L DBB-0910-010 gongliang
 */
public class SelectKanendoIdoDataProcess extends SimpleBatchProcessBase {

    private KanendoIdoFukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonSanteiIdoKanendoFuka service = HonSanteiIdoKanendoFuka.createInstance();
        service.selectKanendoIdoData(processParameter.toKanendoIdoFukaProcessParameter());
    }

    @Override
    protected void afterExecute() {
    }
}
