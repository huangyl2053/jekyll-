/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.batchcontroller.step.dba010011;

import jp.co.ndensan.reams.db.dbb.business.core.basic.ChoshuHoho;
import jp.co.ndensan.reams.db.dbb.entity.db.basic.DbV2001ChoshuHohoEntity;
import jp.co.ndensan.reams.db.dbb.service.core.nenreitotatsushikakuidochoshuhohokoshin.NenreitotatsuShikakuIdoChoshuhohoKoshin;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT1001HihokenshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT7022ShoriDateKanriEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;

/**
 * 年齢到達の異動被保険者取得_バッチフ処理クラスです
 *
 * @reamsid_L DBB-9210-010 xuhao
 */
public class ShikakuIdoChoshuhohoKoshinHihokenjaShutokuProcess extends SimpleBatchProcessBase {

    private NenreitotatsuShikakuIdoChoshuhohoKoshin choshuhohoKoshin;

    @Override
    protected void beforeExecute() {
        choshuhohoKoshin = new NenreitotatsuShikakuIdoChoshuhohoKoshin();
    }

    @Override
    protected void process() {
        DbT7022ShoriDateKanriEntity 処理日付管理Entity = choshuhohoKoshin.select年齢到達の異動被保険者取得();
        if (処理日付管理Entity != null) {
            DbT1001HihokenshaDaichoEntity 被保険者台帳Entity = choshuhohoKoshin.select被保険者番号(処理日付管理Entity);
            if (被保険者台帳Entity != null) {
                DbV2001ChoshuHohoEntity 徴収方法Entity = choshuhohoKoshin.select被保険者徴収方法情報の取得(被保険者台帳Entity.getHihokenshaNo());
                ChoshuHoho choshuHoho = choshuhohoKoshin.upd徴収方法更新(徴収方法Entity, 被保険者台帳Entity);
                choshuhohoKoshin.upd徴収方法テーブル更新(choshuHoho);
            }
        }

    }
}
