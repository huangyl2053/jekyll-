/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb012001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001.TokuchoHeinjunka6GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka6batch.KaigoFukaTokuchoHeijunka6Batch;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「平準化対象者データと平準化対象外データ一時テーブル」処理クラスです。
 *
 * @reamsid_L DBB-0810-010 yuanzhenxia
 */
public class TaisyoushaToTaisyoukaiDataTempProcess extends SimpleBatchProcessBase {

    private KaigoFukaTokuchoHeijunka6Batch business;
    private TokuchoHeinjunka6GatsuProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        business = KaigoFukaTokuchoHeijunka6Batch.createInstance();
    }

    @Override
    protected void process() {
        business.getAtoFukaJohoList();
        business.editAtoFukaJohoList(processParameter.get賦課年度(), processParameter.get調定日時(),
                processParameter.get増額平準化方法(), processParameter.get減額平準化方法());
    }

}
