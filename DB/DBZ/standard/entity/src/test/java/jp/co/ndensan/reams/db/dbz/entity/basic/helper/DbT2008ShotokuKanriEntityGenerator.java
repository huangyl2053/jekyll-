/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT2008ShotokuKanriEntity;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 介護所得エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT2008ShotokuKanriEntityGenerator {

    public static final FlexibleYear DEFAULT_所得年度 = new FlexibleYear("1990");
    public static final ShikibetsuCode DEFAULT_識別コード = new ShikibetsuCode("012340123400001");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(1);
    public static final RString DEFAULT_非課税区分_住民税減免前 = new RString("Data");
    public static final RString DEFAULT_非課税区分_住民税減免後 = new RString("Data");
    public static final Decimal DEFAULT_合計所得金額 = new Decimal(0);
    public static final Decimal DEFAULT_公的年金収入額 = new Decimal(0);
    public static final RString DEFAULT_激変緩和措置区分 = new RString("Data");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT2008ShotokuKanriEntityGenerator() {
    }

    public static DbT2008ShotokuKanriEntity createDbT2008ShotokuKanriEntity() {
        DbT2008ShotokuKanriEntity entity = new DbT2008ShotokuKanriEntity();
        entity.setShotokuNendo(DEFAULT_所得年度);
        entity.setShikibetsuCode(DEFAULT_識別コード);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setKazeiKubun(DEFAULT_非課税区分_住民税減免前);
        entity.setKazeiKubunGemmenGo(DEFAULT_非課税区分_住民税減免後);
        entity.setGokeiShotokuGaku(DEFAULT_合計所得金額);
        entity.setNenkiniShunyuGaku(DEFAULT_公的年金収入額);
        entity.setGekihenKanwaKubun(DEFAULT_激変緩和措置区分);
        return entity;
    }
}
