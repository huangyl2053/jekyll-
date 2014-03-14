/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.relate;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7010NinteichosaItakusakiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT7013ChosainJohoEntity;

/**
 * 調査員、認定調査委託先の情報をまとめた介護認定調査員のエンティティクラスです。
 *
 * @author N8187 久保田 英男
 */
public class KaigoNinteichosainEntity {

    private DbT7013ChosainJohoEntity chosainJohoEntity;
    private DbT7010NinteichosaItakusakiJohoEntity itakusakiJohoEntity;

    /**
     * 調査員情報エンティティを取得します。
     *
     * @return 調査員情報エンティティ
     */
    public DbT7013ChosainJohoEntity getDbT7013ChosainJohoEntity() {
        return chosainJohoEntity;
    }

    /**
     * 調査員情報エンティティを設定します。
     *
     * @param entity 調査員情報エンティティ
     */
    public void setDbT7013ChosainJohoEntity(DbT7013ChosainJohoEntity entity) {
        this.chosainJohoEntity = entity;
    }

    /**
     * 認定調査委託先情報エンティティを取得します。
     *
     * @return 認定調査委託先情報エンティティ
     */
    public DbT7010NinteichosaItakusakiJohoEntity getDbT7010NinteichosaItakusakiJohoEntity() {
        return itakusakiJohoEntity;
    }

    /**
     * 認定調査委託先情報エンティティを設定します。
     *
     * @param entity 認定調査委託先情報エンティティ
     */
    public void setDbT7010NinteichosaItakusakiJohoEntity(DbT7010NinteichosaItakusakiJohoEntity entity) {
        this.itakusakiJohoEntity = entity;
    }
}
