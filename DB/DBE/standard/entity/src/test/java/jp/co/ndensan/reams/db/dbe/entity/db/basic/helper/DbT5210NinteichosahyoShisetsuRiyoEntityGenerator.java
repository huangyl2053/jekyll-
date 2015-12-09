/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;

/**
 * 認定調査票（概況調査）施設利用エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5210NinteichosahyoShisetsuRiyoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final int DEFAULT_認定調査依頼履歴番号 = 1;
    public static final int DEFAULT_連番 = 1;
    public static final Code DEFAULT_厚労省IF識別コード = new Code("09A");
    public static final boolean DEFAULT_施設利用フラグ = false;

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5210NinteichosahyoShisetsuRiyoEntityGenerator() {
    }

    public static DbT5210NinteichosahyoShisetsuRiyoEntity createDbT5210NinteichosahyoShisetsuRiyoEntity() {
        DbT5210NinteichosahyoShisetsuRiyoEntity entity = new DbT5210NinteichosahyoShisetsuRiyoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaRirekiNo(DEFAULT_認定調査依頼履歴番号);
        entity.setRemban(DEFAULT_連番);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setShisetsuRiyoFlag(DEFAULT_施設利用フラグ);
        return entity;
    }
}
