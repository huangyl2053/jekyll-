/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShishoCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7052KoseiShichosonShishoMasterEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 構成市町村支所マスタエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋文娟
 */
public final class DbT7052KoseiShichosonShishoMasterEntityGenerator {

    public static final ShoKisaiHokenshaNo DEFAULT_証記載保険者番号 = new ShoKisaiHokenshaNo(new RString("2"));
    public static final ShishoCode DEFAULT_支所コード = new ShishoCode(new RString("2"));
    public static final RString DEFAULT_支所名 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7052KoseiShichosonShishoMasterEntityGenerator() {
    }

    public static DbT7052KoseiShichosonShishoMasterEntity createDbT7052KoseiShichosonShishoMasterEntity() {
        DbT7052KoseiShichosonShishoMasterEntity entity = new DbT7052KoseiShichosonShishoMasterEntity();
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShishoCode(DEFAULT_支所コード);
        entity.setShishoMei(DEFAULT_支所名);
        return entity;
    }
}
