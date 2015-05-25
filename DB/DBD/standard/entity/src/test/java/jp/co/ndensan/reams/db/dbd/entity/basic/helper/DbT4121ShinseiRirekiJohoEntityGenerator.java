/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.entity.basic.helper;

import jp.co.ndensan.reams.db.dbd.entity.basic.DbT4121ShinseiRirekiJohoEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請履歴情報エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author n8223 朴義一
 */
public final class DbT4121ShinseiRirekiJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請管理番号 = new ShinseishoKanriNo("12345678901234567");
    public static final ShinseishoKanriNo DEFAULT_前回申請管理番号 = new ShinseishoKanriNo("12345678901234567");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT4121ShinseiRirekiJohoEntityGenerator() {
    }

    public static DbT4121ShinseiRirekiJohoEntity createDbT4121ShinseiRirekiJohoEntity() {
        DbT4121ShinseiRirekiJohoEntity entity = new DbT4121ShinseiRirekiJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請管理番号);
        entity.setZenkaiShinseishoKanriNo(DEFAULT_前回申請管理番号);
        return entity;
    }
}
