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
 * 本算定異動（過年度）結果一覧表出力Processdeです。
 *
 * @reamsid_L DBB-0910-010 gongliang
 */
public class SpoolKanendoIdoKekkaIchiranProcess extends SimpleBatchProcessBase {

    private KanendoIdoFukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
    }

    @Override
    protected void process() {
        HonSanteiIdoKanendoFuka service = HonSanteiIdoKanendoFuka.createInstance();
        service.spoolKanendoIdoKekkaIchiran(processParameter.toKanendoIdoFukaProcessParameter());
    }

    @Override
    protected void afterExecute() {
    }

}
