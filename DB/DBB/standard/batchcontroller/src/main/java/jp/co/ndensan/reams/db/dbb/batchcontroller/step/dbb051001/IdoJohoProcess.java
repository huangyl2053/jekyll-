/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44001.GennendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.gennendohonsanteiidou.GenNendoHonsanteiIdou;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「異動対象者抽出」処理クラスです。
 *
 * @reamsid_L DBB-0930-010 yuanzhenxia
 */
public class IdoJohoProcess extends SimpleBatchProcessBase {

    private GenNendoHonsanteiIdou business;
    private GennendoIdoFukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        business = GenNendoHonsanteiIdou.createInstance();
    }

    @Override
    protected void process() {
        business.selectIdoJoho(processParameter.get調定年度(), processParameter.get賦課年度(), processParameter.get抽出開始日時(),
                processParameter.get抽出終了日時(), processParameter.get調定日時());
    }

}
