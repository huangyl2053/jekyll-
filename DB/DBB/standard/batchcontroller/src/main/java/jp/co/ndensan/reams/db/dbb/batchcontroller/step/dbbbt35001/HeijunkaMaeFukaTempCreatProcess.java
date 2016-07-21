/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt35001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001.TokuchoHeinjunka6GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka6batch.KaigoFukaTokuchoHeijunka6Batch;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 平準化前賦課一時テーブル作成するクラスです。
 *
 * @reamsid_L DBB-0810-010 yuanzhenxia
 */
public class HeijunkaMaeFukaTempCreatProcess extends SimpleBatchProcessBase {

    private KaigoFukaTokuchoHeijunka6Batch business;
    private TokuchoHeinjunka6GatsuProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        business = KaigoFukaTokuchoHeijunka6Batch.createInstance();
    }

    @Override
    protected void process() {
        business.getMaeFukaJohoList(processParameter.get調定年度(), processParameter.get賦課年度());
    }

}
