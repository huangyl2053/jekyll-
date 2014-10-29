/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.model;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurityEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域市町村セキュリティのモデルクラスです。
 *
 * @author N8156 宮本 康
 */
public class KoikiShichosonSecurityModel {

    private final DbT7057KoikiShichosonSecurityEntity entity;

    /**
     * コンストラクタです。
     */
    public KoikiShichosonSecurityModel() {
        this.entity = new DbT7057KoikiShichosonSecurityEntity();
    }

    /**
     * コンストラクタです。
     *
     * @param entity DbT7057KoikiShichosonSecurityEntity
     */
    public KoikiShichosonSecurityModel(DbT7057KoikiShichosonSecurityEntity entity) {
        this.entity = entity;
    }

    /**
     * グループIDを返します。
     *
     * @return グループID
     */
    public RString getグループID() {
        return entity.getGroupID();
    }

    /**
     * 市町村識別IDを返します。
     *
     * @return 市町村識別ID
     */
    public ShichosonShikibetsuID get市町村識別ID() {
        return entity.getShichosonShikibetsuID();
    }

    /**
     * 市町村コードを返します。
     *
     * @return 市町村コード
     */
    public ShichosonCode get市町村コード() {
        return entity.getShichosonCode();
    }

    /**
     * DbT7057KoikiShichosonSecurityEntityを返します。
     *
     * @return DbT7057KoikiShichosonSecurityEntity
     */
    public DbT7057KoikiShichosonSecurityEntity getDbT7057KoikiShichosonSecurity() {
        return entity;
    }
}
