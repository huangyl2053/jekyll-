/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5204NinteichosahyoKihonChosaScoreEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 認定調査票（基本調査素点）エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5204NinteichosahyoKihonChosaScoreEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final int DEFAULT_要介護認定調査履歴番号 = 1;
    public static final Code DEFAULT_厚労省IF識別コード = new Code("09A");
    public static final int DEFAULT_素点合計_第１郡 = 1;
    public static final int DEFAULT_素点合計_第２郡 = 1;
    public static final int DEFAULT_素点合計_第３郡 = 1;
    public static final int DEFAULT_素点合計_第４郡 = 1;
    public static final int DEFAULT_素点合計_第５郡 = 1;
    public static final int DEFAULT_素点合計_第６郡 = 1;
    public static final int DEFAULT_素点合計_第７郡 = 1;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5204NinteichosahyoKihonChosaScoreEntityGenerator() {
    }

    public static DbT5204NinteichosahyoKihonChosaScoreEntity createDbT5204NinteichosahyoKihonChosaScoreEntity() {
        DbT5204NinteichosahyoKihonChosaScoreEntity entity = new DbT5204NinteichosahyoKihonChosaScoreEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaRirekiNo(DEFAULT_要介護認定調査履歴番号);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setTokutenTotal1gun(DEFAULT_素点合計_第１郡);
        entity.setTokutenTotal2gun(DEFAULT_素点合計_第２郡);
        entity.setTokutenTotal3gun(DEFAULT_素点合計_第３郡);
        entity.setTokutenTotal4gun(DEFAULT_素点合計_第４郡);
        entity.setTokutenTotal5gun(DEFAULT_素点合計_第５郡);
        entity.setTokutenTotal6gun(DEFAULT_素点合計_第６郡);
        entity.setTokutenTotal7gun(DEFAULT_素点合計_第７郡);
        return entity;
    }
}
