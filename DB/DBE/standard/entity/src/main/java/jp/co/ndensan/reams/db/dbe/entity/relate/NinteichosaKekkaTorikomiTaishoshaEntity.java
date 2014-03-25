/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.relate;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5001NinteiShinseiJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5005NinteiShinchokuJohoEntity;

/**
 * 認定申請情報、認定進捗情報をまとめたエンティティクラスです。
 *
 * @author N8187 久保田 英男
 */
public class NinteichosaKekkaTorikomiTaishoshaEntity {

    private DbT5001NinteiShinseiJohoEntity ninteiShinseiJohoEntity;
    private DbT5005NinteiShinchokuJohoEntity ninteiShinchokuJohoEntity;

    /**
     * 認定申請情報エンティティを取得します。
     *
     * @return ninteiShinseiJohoEntity 認定申請情報エンティティ
     */
    public DbT5001NinteiShinseiJohoEntity getNinteiShinseiJohoEntity() {
        return ninteiShinseiJohoEntity;
    }

    /**
     * 認定申請情報エンティティを設定します。
     *
     * @param ninteiShinseiJohoEntity 認定申請情報エンティティ
     */
    public void setNinteiShinseiJohoEntity(DbT5001NinteiShinseiJohoEntity ninteiShinseiJohoEntity) {
        this.ninteiShinseiJohoEntity = ninteiShinseiJohoEntity;
    }

    /**
     * 認定進捗情報エンティティを取得します。
     *
     * @return ninteiShinchokuJohoEntity 認定進捗情報エンティティ
     */
    public DbT5005NinteiShinchokuJohoEntity getNinteiShinchokuJohoEntity() {
        return ninteiShinchokuJohoEntity;
    }

    /**
     * 認定進捗情報エンティティを設定します。
     *
     * @param ninteiShinchokuJohoEntity 認定進捗情報エンティティ
     */
    public void setNinteiShinchokuJohoEntity(DbT5005NinteiShinchokuJohoEntity ninteiShinchokuJohoEntity) {
        this.ninteiShinchokuJohoEntity = ninteiShinchokuJohoEntity;
    }
}
