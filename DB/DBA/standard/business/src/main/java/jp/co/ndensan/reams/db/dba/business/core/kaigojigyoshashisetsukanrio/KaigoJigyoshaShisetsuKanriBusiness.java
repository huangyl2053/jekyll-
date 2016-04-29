/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.core.kaigojigyoshashisetsukanrio;

import jp.co.ndensan.reams.db.dba.entity.db.relate.kaigojigyoshashisetsukanrio.KaigoJigyoshaShisetsuKanriRelateEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7060KaigoJigyoshaEntity;
import jp.co.ndensan.reams.db.dbx.entity.db.basic.DbT7062KaigoJigyoshaDaihyoshaEntity;

/**
 *
 * 介護事業者・施設管理のBusinessクラスです。
 *
 * @reamsid_L DBA-0340-010 wanghui
 */
public class KaigoJigyoshaShisetsuKanriBusiness {

    private final KaigoJigyoshaShisetsuKanriRelateEntity entity;

    /**
     * コンストラクタです.
     *
     * @param entity 調査委託先＆調査員ガイドEntity
     */
    public KaigoJigyoshaShisetsuKanriBusiness(KaigoJigyoshaShisetsuKanriRelateEntity entity) {
        this.entity = entity;
    }

    /**
     * 介護事業者を取得します。
     *
     * @return 介護事業者のEntity
     */
    public DbT7060KaigoJigyoshaEntity get介護事業者() {
        return entity.getDbT7060KaigoJigyoshaEntity();
    }

    /**
     * 介護事業者代表者を取得します。
     *
     * @return 介護事業者代表者のEntity
     */
    public DbT7062KaigoJigyoshaDaihyoshaEntity get介護事業者代表者() {
        return entity.getDbT7062KaigoJigyoshaDaihyoshaEntity();
    }
}
