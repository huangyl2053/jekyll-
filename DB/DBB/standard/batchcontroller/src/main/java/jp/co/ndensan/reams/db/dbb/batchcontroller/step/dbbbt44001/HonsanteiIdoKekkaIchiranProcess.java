/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44001.GennendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.gennendohonsanteiidou.GenNendoHonsanteiIdou;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;

/**
 * 「本算定異動（現年度）結果一覧表出力」処理クラスです。
 *
 * @reamsid_L DBB-0930-010 yuanzhenxia
 */
public class HonsanteiIdoKekkaIchiranProcess extends SimpleBatchProcessBase {

    private GenNendoHonsanteiIdou business;
    private GennendoIdoFukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        business = GenNendoHonsanteiIdou.createInstance();
    }

    @Override
    protected void process() {
        business.spoolHonsanteiIdoKekkaIchiranData(processParameter.get調定年度(), processParameter.get賦課年度(),
                new YMDHMS(processParameter.get調定日時()), Long.parseLong(processParameter.get出力帳票一覧().get出力順ID().toString()));
    }

}
