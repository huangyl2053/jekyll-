/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7028KakushuShinKyuNoHenkanEntity;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 各種新旧番号変換テーブルエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7028KakushuShinKyuNoHenkanEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("02"));
    public static final RString DEFAULT_番号区分 = new RString("1");
    public static final RString DEFAULT_新番号 = new RString("12342");
    public static final RString DEFAULT_旧番号 = new RString("1231");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7028KakushuShinKyuNoHenkanEntityGenerator() {
    }

    public static DbT7028KakushuShinKyuNoHenkanEntity createDbT7028KakushuShinKyuNoHenkanEntity() {
        DbT7028KakushuShinKyuNoHenkanEntity entity = new DbT7028KakushuShinKyuNoHenkanEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setNoKubun(DEFAULT_番号区分);
        entity.setShinNo(DEFAULT_新番号);
        entity.setKyuNo(DEFAULT_旧番号);
        return entity;
    }
}
