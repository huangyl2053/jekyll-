/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 認定調査票（概況調査）サービスの状況フラグエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final int DEFAULT_認定調査依頼履歴番号 = 1;
    public static final int DEFAULT_連番 = 1;
    public static final Code DEFAULT_厚労省IF識別コード = new Code("09A");
    public static final boolean DEFAULT_サービスの状況フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5208NinteichosahyoServiceJokyoFlagEntityGenerator() {
    }

    public static DbT5208NinteichosahyoServiceJokyoFlagEntity createDbT5208NinteichosahyoServiceJokyoFlagEntity() {
        DbT5208NinteichosahyoServiceJokyoFlagEntity entity = new DbT5208NinteichosahyoServiceJokyoFlagEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaRirekiNo(DEFAULT_認定調査依頼履歴番号);
        entity.setRemban(DEFAULT_連番);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setServiceJokyoFlag(DEFAULT_サービスの状況フラグ);
        return entity;
    }
}
