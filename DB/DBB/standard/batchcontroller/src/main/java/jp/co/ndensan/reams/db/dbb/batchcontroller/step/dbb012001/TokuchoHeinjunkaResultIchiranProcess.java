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
 * 「特徴平準化結果一覧表出力」処理クラスです。
 *
 * @reamsid_L DBB-0810-010 yuanzhenxia
 */
public class TokuchoHeinjunkaResultIchiranProcess extends SimpleBatchProcessBase {

    private KaigoFukaTokuchoHeijunka6Batch business;
    private TokuchoHeinjunka6GatsuProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        business = KaigoFukaTokuchoHeijunka6Batch.createInstance();
    }

    @Override
    protected void process() {
        business.insertKaigoKibetsuTbl(processParameter.get調定年度(), processParameter.get賦課年度(),
                processParameter.get調定日時(), Long.parseLong(processParameter.get出力帳票一覧().get出力順ID().toString()));
    }
}
