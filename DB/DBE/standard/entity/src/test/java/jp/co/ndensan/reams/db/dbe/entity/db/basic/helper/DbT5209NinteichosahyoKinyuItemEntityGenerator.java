/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5209NinteichosahyoKinyuItemEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票（概況調査）記入項目エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5209NinteichosahyoKinyuItemEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final int DEFAULT_認定調査依頼履歴番号 = 1;
    public static final int DEFAULT_連番 = 1;
    public static final Code DEFAULT_厚労省IF識別コード = new Code("09A");
    public static final RString DEFAULT_サービスの状況記入 = new RString("1");
    public static final RDateTime DEFAULT_サービスの状況イメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5209NinteichosahyoKinyuItemEntityGenerator() {
    }

    public static DbT5209NinteichosahyoKinyuItemEntity createDbT5209NinteichosahyoKinyuItemEntity() {
        DbT5209NinteichosahyoKinyuItemEntity entity = new DbT5209NinteichosahyoKinyuItemEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaRirekiNo(DEFAULT_認定調査依頼履歴番号);
        entity.setRemban(DEFAULT_連番);
        entity.setKoroshoIfShikibetsuCode(DEFAULT_厚労省IF識別コード);
        entity.setServiceJokyoKinyu(DEFAULT_サービスの状況記入);
        entity.setServiceJokyoImageSharedFileId(DEFAULT_サービスの状況イメージ共有ファイルID);
        return entity;
    }
}
