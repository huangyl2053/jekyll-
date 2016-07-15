/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt35001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001.TokuchoHeinjunka6GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka6batch.KaigoFukaTokuchoHeijunka6Batch;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 「介護情報の登録」処理クラスです。
 *
 * @reamsid_L DBB-0810-010 yuanzhenxia
 */
public class KaigoJyouhouJyourikuProcess extends SimpleBatchProcessBase {

    private KaigoFukaTokuchoHeijunka6Batch business;
    private TokuchoHeinjunka6GatsuProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        business = new KaigoFukaTokuchoHeijunka6Batch();
    }

    @Override
    protected void process() {
        business.insertKaigoFukaTbl(processParameter.get調定年度(), processParameter.get賦課年度(),
                new YMDHMS(processParameter.get調定日時()));
    }

}
