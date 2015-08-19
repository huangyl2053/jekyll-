/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT4115ImageEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * イメージ情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT4115ImageEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final int DEFAULT_取込ページ番号 = 1;
    public static final Code DEFAULT_原本マスク分 = new Code("01");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT4115ImageEntityGenerator() {
    }

    public static DbT4115ImageEntity createDbT4115ImageEntity() {
        DbT4115ImageEntity entity = new DbT4115ImageEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setTorikomiPageNo(DEFAULT_取込ページ番号);
        entity.setGenponMaskKubun(DEFAULT_原本マスク分);
        return entity;
    }
}
