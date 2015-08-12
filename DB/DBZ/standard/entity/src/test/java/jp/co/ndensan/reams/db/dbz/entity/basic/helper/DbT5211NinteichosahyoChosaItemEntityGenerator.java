/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票_基本調査_調査項目エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5211NinteichosahyoChosaItemEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("000001");
    public static final int DEFAULT_要介護認定調査履歴番号 = 1;
    public static final int DEFAULT_連番 = 1;
    public static final Code DEFAULT_厚労省IF識別コード = new Code("01");
    public static final RString DEFAULT_調査項目 = new RString("名称");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5211NinteichosahyoChosaItemEntityGenerator() {
    }

    public static DbT5211NinteichosahyoChosaItemEntity createDbT5211NinteichosahyoChosaItemEntity() {
        DbT5211NinteichosahyoChosaItemEntity entity = new DbT5211NinteichosahyoChosaItemEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaRirekiNo(DEFAULT_要介護認定調査履歴番号);
        entity.setRemban(DEFAULT_連番);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setReserchItem(DEFAULT_調査項目);
        return entity;
    }
}
