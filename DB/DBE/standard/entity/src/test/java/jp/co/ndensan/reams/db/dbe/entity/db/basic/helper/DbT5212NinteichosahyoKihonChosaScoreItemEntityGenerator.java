/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5212NinteichosahyoKihonChosaScoreItemEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 認定調査票（基本調査素点項目）エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final int DEFAULT_要介護認定調査履歴番号 = 1;
    public static final int DEFAULT_連番 = 1;
    public static final Code DEFAULT_厚労省IF識別コード = new Code("09A");
    public static final int DEFAULT_素点項目 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5212NinteichosahyoKihonChosaScoreItemEntityGenerator() {
    }

    public static DbT5212NinteichosahyoKihonChosaScoreItemEntity createDbT5212NinteichosahyoKihonChosaScoreItemEntity() {
        DbT5212NinteichosahyoKihonChosaScoreItemEntity entity = new DbT5212NinteichosahyoKihonChosaScoreItemEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaRirekiNo(DEFAULT_要介護認定調査履歴番号);
        entity.setRemban(DEFAULT_連番);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setReserchItem01(DEFAULT_素点項目);
        return entity;
    }
}
