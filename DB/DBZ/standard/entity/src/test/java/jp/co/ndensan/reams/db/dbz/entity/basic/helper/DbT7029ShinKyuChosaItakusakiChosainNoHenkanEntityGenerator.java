/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新旧調査委託先調査員番号変換テーブルエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_新調査委託先番号 = new RString("1231");
    public static final RString DEFAULT_新調査員番号 = new RString("1232");
    public static final RString DEFAULT_旧調査委託先番号 = new RString("1231");
    public static final RString DEFAULT_旧調査員番号 = new RString("1230");
    public static final LasdecCode DEFAULT_市町村コード２ = new LasdecCode("202011");
    public static final RString DEFAULT_旧調査委託先番号２ = new RString("1523");
    public static final RString DEFAULT_旧調査員番号２ = new RString("1263");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntityGenerator() {
    }

    public static DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity createDbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity() {
        DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity entity = new DbT7029ShinKyuChosaItakusakiChosainNoHenkanEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShinChosaItakusakiNo(DEFAULT_新調査委託先番号);
        entity.setShinChosainNo(DEFAULT_新調査員番号);
        entity.setKyuChosaItakusakiNo(DEFAULT_旧調査委託先番号);
        entity.setKyuChosainNo(DEFAULT_旧調査員番号);
        entity.setShichosonCode2(DEFAULT_市町村コード２);
        entity.setKyuChosaItakusakiNo2(DEFAULT_旧調査委託先番号２);
        entity.setKyuChosainNo2(DEFAULT_旧調査員番号２);
        return entity;
    }
}
