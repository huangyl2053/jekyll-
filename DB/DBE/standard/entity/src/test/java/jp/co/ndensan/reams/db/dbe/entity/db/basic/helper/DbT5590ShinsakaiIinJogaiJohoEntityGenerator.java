/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5590ShinsakaiIinJogaiJohoEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査会委員除外情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5590ShinsakaiIinJogaiJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final int DEFAULT_連番 = 1;
    public static final RString DEFAULT_除外対象審査会委員コード = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5590ShinsakaiIinJogaiJohoEntityGenerator() {
    }

    public static DbT5590ShinsakaiIinJogaiJohoEntity createDbT5590ShinsakaiIinJogaiJohoEntity() {
        DbT5590ShinsakaiIinJogaiJohoEntity entity = new DbT5590ShinsakaiIinJogaiJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setRenban(DEFAULT_連番);
        entity.setJogaiTaishoShinsakaiIinCode(DEFAULT_除外対象審査会委員コード);
        return entity;
    }
}
