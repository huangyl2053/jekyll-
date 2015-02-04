/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShichosonCode;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.hokensha.ShichosonShikibetsuID;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7057KoikiShichosonSecurityEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域市町村セキュリティエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author N8187 久保田 英男
 */
public final class DbT7057KoikiShichosonSecurityEntityGenerator {

    public static final RString DEFAULT_グループID = new RString("1234567890");
    public static final ShichosonShikibetsuID DEFAULT_市町村識別ID = new ShichosonShikibetsuID("01");
    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("123456");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7057KoikiShichosonSecurityEntityGenerator() {
    }

    public static DbT7057KoikiShichosonSecurityEntity createDbT7057KoikiShichosonSecurityEntity() {
        DbT7057KoikiShichosonSecurityEntity entity = new DbT7057KoikiShichosonSecurityEntity();
        entity.setGroupID(DEFAULT_グループID);
        entity.setShichosonShikibetsuID(DEFAULT_市町村識別ID);
        entity.setShichosonCode(DEFAULT_市町村コード);
        return entity;
    }

}
