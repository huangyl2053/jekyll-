/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.basic.DbT2008ShotokuEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護所得エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 鄭雪双
 */
public final class DbT2008ShotokuEntityGenerator {

    public static final FlexibleYear DEFAULT_所得年度 = new FlexibleYear("2014");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("000001234567890");
    public static final int DEFAULT_履歴番号 = 1;
    public static final RString DEFAULT_非課税区分_住民税減免前 = new RString("1");
    public static final RString DEFAULT_非課税区分_住民税減免後 = new RString("1");
    public static final Decimal DEFAULT_合計所得金額 = new Decimal(1);
    public static final Decimal DEFAULT_公的年金収入額 = new Decimal(1);
    public static final RString DEFAULT_激変緩和措置区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2008ShotokuEntityGenerator() {
    }

    public static DbT2008ShotokuEntity createDbT2008ShotokuEntity() {
        DbT2008ShotokuEntity entity = new DbT2008ShotokuEntity();
        entity.setShotokuNendo(DEFAULT_所得年度);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setHiKazeiKubun(DEFAULT_非課税区分_住民税減免前);
        entity.setHiKazeiKubunGemmenGo(DEFAULT_非課税区分_住民税減免後);
        entity.setGokeiShotokuGaku(DEFAULT_合計所得金額);
        entity.setNenkiniShunyuGaku(DEFAULT_公的年金収入額);
        entity.setGekihenKanwaKubun(DEFAULT_激変緩和措置区分);
        return entity;
    }
}
