/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 新旧医療機関主治医番号変換テーブルエンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator {

    public static final LasdecCode DEFAULT_市町村コード = new LasdecCode("202011");
    public static final RString DEFAULT_新医療機関番号 = new RString("1231");
    public static final RString DEFAULT_新主治医番号 = new RString("1231");
    public static final RString DEFAULT_旧医療機関番号 = new RString("1231");
    public static final RString DEFAULT_旧主治医番号 = new RString("1231");
    public static final LasdecCode DEFAULT_市町村コード２ = new LasdecCode("202011");
    public static final RString DEFAULT_旧医療機関番号２ = new RString("1231");
    public static final RString DEFAULT_旧主治医番号２ = new RString("1231");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT7030ShinKyuIryoKikanShujiiNoHenkanEntityGenerator() {
    }

    public static DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity createDbT7030ShinKyuIryoKikanShujiiNoHenkanEntity() {
        DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity entity = new DbT7030ShinKyuIryoKikanShujiiNoHenkanEntity();
        entity.setShichosonCode(DEFAULT_市町村コード);
        entity.setShinIryoKikanNo(DEFAULT_新医療機関番号);
        entity.setShinShujiiNo(DEFAULT_新主治医番号);
        entity.setKyuIryoKikanNo(DEFAULT_旧医療機関番号);
        entity.setKyuShujiiNo(DEFAULT_旧主治医番号);
        entity.setShichosonCode2(DEFAULT_市町村コード２);
        entity.setKyuIryoKikanNo2(DEFAULT_旧医療機関番号２);
        entity.setKyuShujiiNo2(DEFAULT_旧主治医番号２);
        return entity;
    }
}
