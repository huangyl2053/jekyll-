/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT5303ShujiiIkenshoKinyuItemEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定主治医意見書記入項目エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5303ShujiiIkenshoKinyuItemEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final int DEFAULT_主治医意見書作成依頼履歴番号 = 1;
    public static final int DEFAULT_連番 = 1;
    public static final Code DEFAULT_厚労省IF識別コード = new Code("01");
    public static final RString DEFAULT_記入項目 = new RString("名称");
    public static final RDateTime DEFAULT_記入項目イメージ共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5303ShujiiIkenshoKinyuItemEntityGenerator() {
    }

    public static DbT5303ShujiiIkenshoKinyuItemEntity createDbT5303ShujiiIkenshoKinyuItemEntity() {
        DbT5303ShujiiIkenshoKinyuItemEntity entity = new DbT5303ShujiiIkenshoKinyuItemEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setIkenshoIraiRirekiNo(DEFAULT_主治医意見書作成依頼履歴番号);
        entity.setRemban(DEFAULT_連番);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setKinyuItem(DEFAULT_記入項目);
        entity.setKinyuItemImageSharedFileId(DEFAULT_記入項目イメージ共有ファイルID);
        return entity;
    }
}
