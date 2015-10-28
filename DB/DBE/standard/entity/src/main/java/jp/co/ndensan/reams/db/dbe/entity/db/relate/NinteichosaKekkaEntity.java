/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.relate;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5008NinteichosaKekkaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5009NinteichosahyoJohoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 要介護認定調査結果のエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class NinteichosaKekkaEntity implements IDbAccessable {

    private DbT5008NinteichosaKekkaJohoEntity dbT5008Entity = null;
    private DbT5009NinteichosahyoJohoEntity dbT5009Entity = null;

    /**
     * インスタンスを生成します。
     */
    public NinteichosaKekkaEntity() {
    }

    /**
     * 要介護認定調査結果情報エンティティを取得します。
     *
     * @return 要介護認定調査結果情報エンティティ
     */
    public DbT5008NinteichosaKekkaJohoEntity getDbT5008NinteichosaKekkaJohoEntity() {
        return dbT5008Entity;
    }

    /**
     * 要介護認定調査結果情報エンティティを設定します。
     *
     * @param entity 要介護認定調査結果情報エンティティ
     */
    public void setDbT5008NinteichosaKekkaJohoEntity(DbT5008NinteichosaKekkaJohoEntity entity) {
        this.dbT5008Entity = entity;
    }

    /**
     * 要介護認定調査票情報エンティティを取得します。
     *
     * @return 要介護認定調査票情報エンティティ
     */
    public DbT5009NinteichosahyoJohoEntity getDbT5009NinteichosahyoJohoEntity() {
        return dbT5009Entity;
    }

    /**
     * 要介護認定調査票情報エンティティを設定します。
     *
     * @param entity 要介護認定調査票情報エンティティ
     */
    public void setDbT5009NinteichosahyoJohoEntity(DbT5009NinteichosahyoJohoEntity entity) {
        this.dbT5009Entity = entity;
    }
}
