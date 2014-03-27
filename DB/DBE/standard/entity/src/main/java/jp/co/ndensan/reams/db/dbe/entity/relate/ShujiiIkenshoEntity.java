/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.relate;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5012ShujiiIkenshoJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5013ShujiiIkenshoShosaiJohoEntity;
import jp.co.ndensan.reams.uz.uza.util.db.IDbAccessable;

/**
 * 主治医意見書のエンティティクラスです。
 *
 * @author N8156 宮本 康
 */
public class ShujiiIkenshoEntity implements IDbAccessable {

    private DbT5012ShujiiIkenshoJohoEntity dbT5012ShujiiIkenshoJohoEntity = null;
    private DbT5013ShujiiIkenshoShosaiJohoEntity dbT5013ShujiiIkenshoShosaiJohoEntity = null;

    /**
     * インスタンスを生成します。
     */
    public ShujiiIkenshoEntity() {
    }

    /**
     * 主治医意見書情報エンティティを取得します。
     *
     * @return 主治医意見書情報エンティティ
     */
    public DbT5012ShujiiIkenshoJohoEntity getDbT5012ShujiiIkenshoJohoEntity() {
        return dbT5012ShujiiIkenshoJohoEntity;
    }

    /**
     * 主治医意見書情報エンティティを設定します。
     *
     * @param entity 主治医意見書情報エンティティ
     */
    public void setDbT5012ShujiiIkenshoJohoEntity(DbT5012ShujiiIkenshoJohoEntity entity) {
        this.dbT5012ShujiiIkenshoJohoEntity = entity;
    }

    /**
     * 主治医意見書詳細情報エンティティを取得します。
     *
     * @return 主治医意見書詳細情報エンティティ
     */
    public DbT5013ShujiiIkenshoShosaiJohoEntity getDbT5013ShujiiIkenshoShosaiJohoEntity() {
        return dbT5013ShujiiIkenshoShosaiJohoEntity;
    }

    /**
     * 主治医意見書詳細情報エンティティを設定します。
     *
     * @param entity 主治医意見書詳細情報エンティティ
     */
    public void setDbT5013ShujiiIkenshoShosaiJohoEntity(DbT5013ShujiiIkenshoShosaiJohoEntity entity) {
        this.dbT5013ShujiiIkenshoShosaiJohoEntity = entity;
    }
}
