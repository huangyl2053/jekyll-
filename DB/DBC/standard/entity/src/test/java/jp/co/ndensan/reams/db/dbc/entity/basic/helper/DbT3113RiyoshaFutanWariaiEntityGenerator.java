/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3113RiyoshaFutanWariaiEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 利用者負担割合エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3113RiyoshaFutanWariaiEntityGenerator {

    public static final FlexibleYear DEFAULT_年度 = new FlexibleYear("1990");
    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final boolean DEFAULT_発行不要フラグ = false;
    public static final boolean DEFAULT_職権変更フラグ = false;
    public static final FlexibleDate DEFAULT_判定日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_判定区分 = new RString("Data");
    public static final Code DEFAULT_更正事由 = new Code();
    public static final RString DEFAULT_発行区分 = new RString("Data");
    public static final FlexibleDate DEFAULT_発行日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_交付日 = new FlexibleDate("19900101");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3113RiyoshaFutanWariaiEntityGenerator() {
    }

    public static DbT3113RiyoshaFutanWariaiEntity createDbT3113RiyoshaFutanWariaiEntity() {
        DbT3113RiyoshaFutanWariaiEntity entity = new DbT3113RiyoshaFutanWariaiEntity();
        entity.setNendo(DEFAULT_年度);
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setHakoFuyoFlag(DEFAULT_発行不要フラグ);
        entity.setShokenFlag(DEFAULT_職権変更フラグ);
        entity.setHanteiYMD(DEFAULT_判定日);
        entity.setHanteiKubun(DEFAULT_判定区分);
        entity.setKoseiJiyu(DEFAULT_更正事由);
        entity.setHakoKubun(DEFAULT_発行区分);
        entity.setHakoYMD(DEFAULT_発行日);
        entity.setKofuYMD(DEFAULT_交付日);
        return entity;
    }
}
