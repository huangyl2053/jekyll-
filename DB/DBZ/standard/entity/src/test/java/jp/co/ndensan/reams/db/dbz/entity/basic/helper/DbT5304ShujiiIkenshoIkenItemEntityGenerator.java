/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定主治医意見書意見項目エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5304ShujiiIkenshoIkenItemEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final int DEFAULT_主治医意見書作成依頼履歴番号 = 1;
    public static final int DEFAULT_連番 = 1;
    public static final Code DEFAULT_厚労省IF識別コード = new Code("1");
    public static final RString DEFAULT_意見項目 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5304ShujiiIkenshoIkenItemEntityGenerator() {
    }

    public static DbT5304ShujiiIkenshoIkenItemEntity createDbT5304ShujiiIkenshoIkenItemEntity() {
        DbT5304ShujiiIkenshoIkenItemEntity entity = new DbT5304ShujiiIkenshoIkenItemEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setIkenshoIraiRirekiNo(DEFAULT_主治医意見書作成依頼履歴番号);
        entity.setRemban(DEFAULT_連番);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setIkenItem(DEFAULT_意見項目);
        return entity;
    }
}
