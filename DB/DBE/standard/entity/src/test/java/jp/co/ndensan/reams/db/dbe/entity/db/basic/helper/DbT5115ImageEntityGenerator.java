/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbe.entity.db.basic.DbT5115ImageEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * イメージ情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5115ImageEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final RDateTime DEFAULT_イメージ共有ファイルID = RDateTime.now();

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5115ImageEntityGenerator() {
    }

    public static DbT5115ImageEntity createDbT5115ImageEntity() {
        DbT5115ImageEntity entity = new DbT5115ImageEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setImageSharedFileId(DEFAULT_イメージ共有ファイルID);
        return entity;
    }
}
