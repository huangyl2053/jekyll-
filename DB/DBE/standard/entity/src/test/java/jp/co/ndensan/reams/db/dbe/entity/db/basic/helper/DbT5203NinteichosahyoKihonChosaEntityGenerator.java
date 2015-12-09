/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5203NinteichosahyoKihonChosaEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 認定調査票（基本調査）エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5203NinteichosahyoKihonChosaEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final int DEFAULT_要介護認定調査履歴番号 = 1;
    public static final Code DEFAULT_厚労省IF識別コード = new Code("09A");
    public static final Code DEFAULT_認定調査_認知症高齢者の日常生活自立度コード = new Code("1");
    public static final Code DEFAULT_認定調査_障害高齢者の日常生活自立度コード = new Code("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5203NinteichosahyoKihonChosaEntityGenerator() {
    }

    public static DbT5203NinteichosahyoKihonChosaEntity createDbT5203NinteichosahyoKihonChosaEntity() {
        DbT5203NinteichosahyoKihonChosaEntity entity = new DbT5203NinteichosahyoKihonChosaEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaRirekiNo(DEFAULT_要介護認定調査履歴番号);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setNinchishoNichijoSeikatsuJiritsudoCode(DEFAULT_認定調査_認知症高齢者の日常生活自立度コード);
        entity.setShogaiNichijoSeikatsuJiritsudoCode(DEFAULT_認定調査_障害高齢者の日常生活自立度コード);
        return entity;
    }
}
