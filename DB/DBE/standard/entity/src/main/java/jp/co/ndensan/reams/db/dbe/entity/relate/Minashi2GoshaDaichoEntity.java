/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.relate;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT1012Minashi2GoshaDaichoEntity;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT1001HihokenshaDaichoEntity;

/**
 * みなし2号被保険者のエンティティクラスです。
 *
 * @author N8211 田辺 紘一
 */
public class Minashi2GoshaDaichoEntity {

// TODO 田辺 紘一 〆日に間に合わず 2014/07/24

    private DbT1012Minashi2GoshaDaichoEntity dbT1012Minashi2GoshaDaichoEntity = null;
    private DbT1001HihokenshaDaichoEntity dbT1001HihokenshaDaichoEntity = null;

    /**
     * インスタンスを生成します。
     */
    public Minashi2GoshaDaichoEntity() {
    }

    /**
     * みなし2号者台帳エンティティを取得します。
     *
     * @return みなし2号者台帳エンティティ
     */
    public DbT1012Minashi2GoshaDaichoEntity getDbT1012Minashi2GoshaDaichoEntity() {
        return dbT1012Minashi2GoshaDaichoEntity;
    }

    /**
     * みなし2号者台帳エンティティを設定します。
     *
     * @param entity みなし2号者台帳エンティティ
     */
    public void setDbT1012Minashi2GoshaDaichoEntity(DbT1012Minashi2GoshaDaichoEntity entity) {
        this.dbT1012Minashi2GoshaDaichoEntity = entity;
    }

    /**
     * 被保険者台帳エンティティを取得します。
     *
     * @return 被保険者台帳エンティティ
     */
    public DbT1001HihokenshaDaichoEntity getDbT1001HihokenshaDaichoEntity() {
        return dbT1001HihokenshaDaichoEntity;
    }

    /**
     * 被保険者台帳エンティティを設定します。
     *
     * @param entity 被保険者台帳エンティティ
     */
    public void setDbT1001HihokenshaDaichoEntity(DbT1001HihokenshaDaichoEntity entity) {
        this.dbT1001HihokenshaDaichoEntity = entity;
    }
}
