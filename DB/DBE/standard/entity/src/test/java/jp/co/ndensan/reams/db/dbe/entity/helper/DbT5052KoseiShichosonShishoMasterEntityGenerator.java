/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.helper;

import jp.co.ndensan.reams.db.dbe.entity.basic.DbT5052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;

/**
 * 構成市町村支所マスタエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5052KoseiShichosonShishoMasterEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202010");
    public static final ShishoCode DEFAULT_支所コード = new ShishoCode("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5052KoseiShichosonShishoMasterEntityGenerator() {
    }

    public static DbT5052KoseiShichosonShishoMasterEntity createDbT5052KoseiShichosonShishoMasterEntity() {
        DbT5052KoseiShichosonShishoMasterEntity entity = new DbT5052KoseiShichosonShishoMasterEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShishoCode(DEFAULT_支所コード);
        return entity;
    }
}
