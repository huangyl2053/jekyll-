/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb055001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.kanendoidofuka.KanendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.honsanteiidokanendofuka.HonSanteiIdoKanendoFukaBatch;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 処理日付管理テーブル登録Processdeです。
 *
 * @reamsid_L DBB-0910-010 gongliang
 */
public class InsShoriDateKanriProcess extends SimpleBatchProcessBase {

    private KanendoIdoFukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonSanteiIdoKanendoFukaBatch service = HonSanteiIdoKanendoFukaBatch.createInstance();
        service.insShoriDateKanri(processParameter.toKanendoIdoFukaProcessParameter());
    }

    @Override
    protected void afterExecute() {
    }
}
