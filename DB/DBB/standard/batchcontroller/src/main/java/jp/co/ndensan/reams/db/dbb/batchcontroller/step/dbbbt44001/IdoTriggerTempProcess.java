/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbbbt44001;

import jp.co.ndensan.reams.db.dbb.definition.processprm.dbbbt44001.GennendoIdoFukaProcessParameter;
import jp.co.ndensan.reams.db.dbb.service.core.gennendohonsanteiidou.GenNendoHonsanteiIdou;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「異動トリガーTemp作成」処理クラスです。
 *
 * @reamsid_L DBB-0930-010 yuanzhenxia
 */
public class IdoTriggerTempProcess extends SimpleBatchProcessBase {

    private GenNendoHonsanteiIdou business;
    private GennendoIdoFukaProcessParameter processParameter;

    @Override
    protected void beforeExecute() {
        business = GenNendoHonsanteiIdou.createInstance();
    }

    @Override
    protected void process() {
        business.createIdoTriggerTemp(processParameter.get異動賦課で同時に計算する特徴捕捉分(), processParameter.get特徴捕捉対象者の依頼金額計算());
    }
}
