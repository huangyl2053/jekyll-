/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.db.basic.DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity;
import jp.co.ndensan.reams.ur.urz.definition.Messages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.LasdecCode;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RYear;
import jp.co.ndensan.reams.uz.uza.lang.RYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 予防給付計画自己作成短期利用日数エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYear("1990");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final Decimal DEFAULT_前回迄利用日数 = new Decimal(0);
    public static final Decimal DEFAULT_今回計画利用日数 = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntityGenerator() {
    }

    public static DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity createDbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity() {
        DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity entity = new DbT3013YoboKeikakuJikoSakuseiTankiRiyoNissuEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setZenkaiRiyoNissu(DEFAULT_前回迄利用日数);
        entity.setKonkaiKeikakuRiyoNissu(DEFAULT_今回計画利用日数);
        return entity;
    }
}
