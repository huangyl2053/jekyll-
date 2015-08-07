/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.db.basic.helper;

import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
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
 * 居宅給付計画自己作成短期入所利用日数エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo();
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYear("1990");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final Decimal DEFAULT_前回迄利用日数 = new Decimal(0);
    public static final Decimal DEFAULT_今回計画利用日数 = new Decimal(0);

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator() {
    }

    public static DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity createDbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity() {
        DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity entity = new DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoYM(DEFAULT_対象年月);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setZenkaiRiyoNissu(DEFAULT_前回迄利用日数);
        entity.setKonkaiKeikakuRiyoNissu(DEFAULT_今回計画利用日数);
        return entity;
    }
}
