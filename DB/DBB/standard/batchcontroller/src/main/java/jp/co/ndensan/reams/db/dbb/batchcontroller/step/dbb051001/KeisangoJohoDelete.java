/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dbb051001;

import jp.co.ndensan.reams.db.dbb.service.core.gennendohonsanteiidou.GenNendoHonsanteiIdou;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 「計算後情報テーブル削除」処理クラスです。
 *
 * @reamsid_L DBB-0930-010 yuanzhenxia
 */
public class KeisangoJohoDelete extends SimpleBatchProcessBase {

    private GenNendoHonsanteiIdou business;

    @Override
    protected void beforeExecute() {
        business = GenNendoHonsanteiIdou.createInstance();
    }

    @Override
    protected void process() {
        business.deleteKeisangoJohoTemp();
    }
}
