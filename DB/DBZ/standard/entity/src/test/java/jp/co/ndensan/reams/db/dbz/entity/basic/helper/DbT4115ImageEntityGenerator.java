/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4115ImageEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;

/**
 * イメージ情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT4115ImageEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final RDateTime DEFAULT_イメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT4115ImageEntityGenerator() {
    }

    public static DbT4115ImageEntity createDbT4115ImageEntity() {
        DbT4115ImageEntity entity = new DbT4115ImageEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setImageSharedFileId(DEFAULT_イメージ共有ファイルID);
        return entity;
    }
}
