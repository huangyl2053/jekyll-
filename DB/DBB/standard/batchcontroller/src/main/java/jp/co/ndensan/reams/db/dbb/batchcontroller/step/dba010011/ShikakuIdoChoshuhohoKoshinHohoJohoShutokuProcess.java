/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dba010011;

import jp.co.ndensan.reams.db.dbb.service.core.nenreitotatsushikakuidochoshuhohokoshin.NenreitotatsuShikakuIdoChoshuhohoKoshin;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 被保険者徴収方法情報の取得_バッチフ処理クラスです
 *
 * @reamsid_L DBB-9210-010 xuhao
 */
public class ShikakuIdoChoshuhohoKoshinHohoJohoShutokuProcess extends SimpleBatchProcessBase {

    private NenreitotatsuShikakuIdoChoshuhohoKoshin choshuhohoKoshin;
    

    @Override
    protected void beforeExecute() {
        choshuhohoKoshin = new NenreitotatsuShikakuIdoChoshuhohoKoshin();
    }

    @Override
    protected void process() {
         choshuhohoKoshin.select被保険者徴収方法情報の取得();
    }
}
