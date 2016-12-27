/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT4305IkenshoImageJohoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 要介護認定意見書イメージ情報エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT4305IkenshoImageJohoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("900001");
    public static final int DEFAULT_主治医意見書作成依頼履歴番号 = 1;
    public static final Code DEFAULT_帳票ID = new Code("01");
    public static final RString DEFAULT_マスキングデータ区分 = new RString("名称");
    public static final int DEFAULT_取込みページ番号 = 1;
    public static final int DEFAULT_認定申請年 = 1;
    public static final RDateTime DEFAULT_共有ファイルID = RDateTime.of(2014, 9, 1, 10, 20, 30, 123);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT4305IkenshoImageJohoEntityGenerator() {
    }

    public static DbT4305IkenshoImageJohoEntity createDbT4305IkenshoImageJohoEntity() {
        DbT4305IkenshoImageJohoEntity entity = new DbT4305IkenshoImageJohoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setIraiRirekiNo(DEFAULT_主治医意見書作成依頼履歴番号);
        entity.setChoyoID(DEFAULT_帳票ID);
        entity.setGenponMaskKubun(DEFAULT_マスキングデータ区分);
//        entity.setTorikomiPageNo(DEFAULT_取込みページ番号);
//        entity.setNinteiShinseiNen(DEFAULT_認定申請年);
//        entity.setSharedFileId(DEFAULT_共有ファイルID);
        return entity;
    }
}
