/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査票（特記情報）エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT5205NinteichosahyoTokkijikoEntityGenerator {

    public static final ShinseishoKanriNo DEFAULT_申請書管理番号 = new ShinseishoKanriNo("1");
    public static final int DEFAULT_認定調査依頼履歴番号 = 1;
    public static final RString DEFAULT_認定調査特記事項番号 = new RString("001");
    public static final RString DEFAULT_認定調査特記事項連番 = new RString("1");
    public static final RString DEFAULT_特記事項テキスト_イメージ区分 = new RString("1");
    public static final Code DEFAULT_原本マスク区分 = new Code("1");
    public static final RString DEFAULT_特記事項 = new RString("特記事項");
    public static final RDateTime DEFAULT_特記事項イメージ共有ファイルID = RDateTime.of(2014, 04, 02, 10, 00, 00);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT5205NinteichosahyoTokkijikoEntityGenerator() {
    }

    public static DbT5205NinteichosahyoTokkijikoEntity createDbT5205NinteichosahyoTokkijikoEntity() {
        DbT5205NinteichosahyoTokkijikoEntity entity = new DbT5205NinteichosahyoTokkijikoEntity();
        entity.setShinseishoKanriNo(DEFAULT_申請書管理番号);
        entity.setNinteichosaRirekiNo(DEFAULT_認定調査依頼履歴番号);
        entity.setNinteichosaTokkijikoNo(DEFAULT_認定調査特記事項番号);
        entity.setNinteichosaTokkijikoRenban(DEFAULT_認定調査特記事項連番);
        entity.setTokkijikoTextImageKubun(DEFAULT_特記事項テキスト_イメージ区分);
        entity.setGenponMaskKubun(DEFAULT_原本マスク区分);
        entity.setTokkiJiko(DEFAULT_特記事項);
        entity.setTokkiJikoImageSharedFileId(DEFAULT_特記事項イメージ共有ファイルID);
        return entity;
    }
}
