/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村支所マスタエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7052KoseiShichosonShishoMasterEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");
    public static final ShishoCode DEFAULT_支所コード = new ShishoCode("123456789");
    public static final RString DEFAULT_支所名 = new RString("あいうえおさし");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7052KoseiShichosonShishoMasterEntityGenerator() {
    }

    public static DbT7052KoseiShichosonShishoMasterEntity createDbT7052KoseiShichosonShishoMasterEntity() {
        DbT7052KoseiShichosonShishoMasterEntity entity = new DbT7052KoseiShichosonShishoMasterEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShishoCode(DEFAULT_支所コード);
        entity.setShishoMei(DEFAULT_支所名);
        return entity;
    }
}
