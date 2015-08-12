/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5102NinteiKekkaJohoEntity;

/**
 * 要介護認定結果情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5102NinteiKekkaJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5102NinteiKekkaJohoEntityGenerator() {
    }

    public static DbT5102NinteiKekkaJohoEntity createDbT5102NinteiKekkaJohoEntity() {
        DbT5102NinteiKekkaJohoEntity entity = new DbT5102NinteiKekkaJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        return entity;
    }
}
