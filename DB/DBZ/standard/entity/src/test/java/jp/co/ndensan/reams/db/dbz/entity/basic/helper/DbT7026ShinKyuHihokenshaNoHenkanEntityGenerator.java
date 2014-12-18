/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7026ShinKyuHihokenshaNoHenkanEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新旧被保険者番号変換テーブルエンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 宋昕沢
 */
public final class DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_新番号 = new RString("123");
    public static final RString DEFAULT_旧番号 = new RString("123");
    public static final LasdecCode DEFAULT_旧市町村コード２ = new LasdecCode("202010");
    public static final RString DEFAULT_旧番号２ = new RString("123");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7026ShinKyuHihokenshaNoHenkanEntityGenerator() {
    }

    public static DbT7026ShinKyuHihokenshaNoHenkanEntity createDbT7026ShinKyuHihokenshaNoHenkanEntity() {
        DbT7026ShinKyuHihokenshaNoHenkanEntity entity = new DbT7026ShinKyuHihokenshaNoHenkanEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShinNo(DEFAULT_新番号);
        entity.setKyuNo(DEFAULT_旧番号);
        entity.setKyuShichosonCode(DEFAULT_旧市町村コード２);
        entity.setKyuNo2(DEFAULT_旧番号２);
        return entity;
    }
}
