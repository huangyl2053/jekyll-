/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbx.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntity;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 居宅給付計画自己作成短期入所利用日数エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3010KyotakuKeikakuJikoSakuseiTankiNyushoRiyoNissuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYearMonth DEFAULT_対象年月 = new FlexibleYearMonth("199001");
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
