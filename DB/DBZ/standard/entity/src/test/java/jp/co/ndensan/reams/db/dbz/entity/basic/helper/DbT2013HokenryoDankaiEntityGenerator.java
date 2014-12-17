/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2013HokenryoDankaiEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 保険料段階エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author N8156 宮本 康
 */
public final class DbT2013HokenryoDankaiEntityGenerator {

    public static final FlexibleYear DEFAULT_賦課年度 = new FlexibleYear("2009");
    public static final RString DEFAULT_段階インデックス = new RString("04");
    public static final RString DEFAULT_ランク区分 = new RString("00");
    public static final RString DEFAULT_段階区分 = new RString("041");
    public static final Decimal DEFAULT_保険料率 = new Decimal(50500);
    public static final RString DEFAULT_特例表記 = new RString("軽減");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2013HokenryoDankaiEntityGenerator() {
    }

    public static DbT2013HokenryoDankaiEntity createDbT2013HokenryoDankaiEntity() {
        DbT2013HokenryoDankaiEntity entity = new DbT2013HokenryoDankaiEntity();
        entity.setFukaNendo(DEFAULT_賦課年度);
        entity.setDankaiIndex(DEFAULT_段階インデックス);
        entity.setRankuKubun(DEFAULT_ランク区分);
        entity.setDankaiKubun(DEFAULT_段階区分);
        entity.setHokenryoRitsu(DEFAULT_保険料率);
        entity.setTokureiHyoki(DEFAULT_特例表記);
        return entity;
    }
}
