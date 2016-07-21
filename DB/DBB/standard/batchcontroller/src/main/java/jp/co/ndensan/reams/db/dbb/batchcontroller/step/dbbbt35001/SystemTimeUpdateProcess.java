/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt35001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt35001.TokuchoHeinjunka6GatsuProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.kaigofukatokuchoheijunka6batch.KaigoFukaTokuchoHeijunka6Batch;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.ShoriName;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 「処理日付管理テーブル更新」処理クラスです。
 *
 * @reamsid_L DBB-0810-010 yuanzhenxia
 */
public class SystemTimeUpdateProcess extends SimpleBatchProcessBase {

    private KaigoFukaTokuchoHeijunka6Batch business;
    private TokuchoHeinjunka6GatsuProcessParameter processParameter;
    private final RString 枝番 = new RString("0001");

    @Override
    protected void beforeExecute() {
        business = KaigoFukaTokuchoHeijunka6Batch.createInstance();
    }

    @Override
    protected void process() {
        RString 処理名 = new RString(ShoriName.特徴平準化計算_6月分.toString());
        RString 処理枝番 = 枝番;
        RString 年度内連番 = 枝番;
        FlexibleYear 年度 = processParameter.get調定年度();
        YMDHMS システム日時 = processParameter.get調定日時();
        business.update処理日付管理(処理名, 処理枝番, 年度, 年度内連番, システム日時);
    }

}
