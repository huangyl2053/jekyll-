/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.entity.basic.helper;

import jp.co.ndensan.reams.db.dbc.entity.basic.DbT3074KogakuGassanShikyuFushikyuKetteiEntity;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算支給不支給決定エンティティのテスト用インスタンスを作成する補助クラスです。
 */
public final class DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo("1");
    public static final FlexibleYear DEFAULT_対象年度 = new FlexibleYear("1990");
    public static final HokenshaNo DEFAULT_保険者番号 = new HokenshaNo("1");
    public static final RString DEFAULT_支給申請書整理番号 = new RString("Data");
    public static final Decimal DEFAULT_履歴番号 = new Decimal(0);
    public static final RString DEFAULT_自己負担額証明書整理番号 = new RString("Data");
    public static final RString DEFAULT_保険制度コード = new RString("Data");
    public static final RString DEFAULT_国保_被保険者証記号 = new RString("Data");
    public static final FlexibleDate DEFAULT_対象計算期間開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_対象計算期間終了年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_決定年月日 = new FlexibleDate("19900101");
    public static final Decimal DEFAULT_自己負担総額 = new Decimal(0);
    public static final RString DEFAULT_支給区分コード = new RString("Data");
    public static final Decimal DEFAULT_支給額 = new Decimal(0);
    public static final RString DEFAULT_給付の種類 = new RString("Data");
    public static final RString DEFAULT_不支給理由 = new RString("Data");
    public static final RString DEFAULT_備考 = new RString("Data");
    public static final RString DEFAULT_支払方法区分 = new RString("Data");
    public static final RString DEFAULT_支払場所 = new RString("Data");
    public static final FlexibleDate DEFAULT_支払期間開始年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_支払期間終了年月日 = new FlexibleDate("19900101");
    public static final RString DEFAULT_閉庁内容 = new RString("Data");
    public static final RString DEFAULT_支払期間開始時間 = new RString("Data");
    public static final RString DEFAULT_支払期間終了時間 = new RString("Data");
    public static final FlexibleDate DEFAULT_決定通知書作成年月日 = new FlexibleDate("19900101");
    public static final FlexibleDate DEFAULT_振込通知書作成年月日 = new FlexibleDate("19900101");
    public static final FlexibleYearMonth DEFAULT_受取年月 = new FlexibleYearMonth("199001");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3074KogakuGassanShikyuFushikyuKetteiEntityGenerator() {
    }

    public static DbT3074KogakuGassanShikyuFushikyuKetteiEntity createDbT3074KogakuGassanShikyuFushikyuKetteiEntity() {
        DbT3074KogakuGassanShikyuFushikyuKetteiEntity entity = new DbT3074KogakuGassanShikyuFushikyuKetteiEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoNendo(DEFAULT_対象年度);
        entity.setHokenshaNo(DEFAULT_保険者番号);
        entity.setShikyuSeiriNo(DEFAULT_支給申請書整理番号);
        entity.setRirekiNo(DEFAULT_履歴番号);
        entity.setJikoFutanSeiriNo(DEFAULT_自己負担額証明書整理番号);
        entity.setHokenSeidoCode(DEFAULT_保険制度コード);
        entity.setKokuho_HihokenshaShoKigo(DEFAULT_国保_被保険者証記号);
        entity.setKeisanKaishiYMD(DEFAULT_対象計算期間開始年月日);
        entity.setKeisanShuryoYMD(DEFAULT_対象計算期間終了年月日);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setKetteiYMD(DEFAULT_決定年月日);
        entity.setJikoFutanSogaku(DEFAULT_自己負担総額);
        entity.setShikyuKubunCode(DEFAULT_支給区分コード);
        entity.setShikyugaku(DEFAULT_支給額);
        entity.setKyufuShurui(DEFAULT_給付の種類);
        entity.setFushikyuRiyu(DEFAULT_不支給理由);
        entity.setBiko(DEFAULT_備考);
        entity.setShiharaiHohoKubun(DEFAULT_支払方法区分);
        entity.setShiharaiBasho(DEFAULT_支払場所);
        entity.setShiharaiKaishiYMD(DEFAULT_支払期間開始年月日);
        entity.setShiharaiShuryoYMD(DEFAULT_支払期間終了年月日);
        entity.setHeichoNaiyo(DEFAULT_閉庁内容);
        entity.setShiharaiKaishiTime(DEFAULT_支払期間開始時間);
        entity.setShiharaiShuryoTime(DEFAULT_支払期間終了時間);
        entity.setKetteiTsuchiSakuseiYMD(DEFAULT_決定通知書作成年月日);
        entity.setFurikomiTsuchiSakuseiYMD(DEFAULT_振込通知書作成年月日);
        entity.setUketoriYM(DEFAULT_受取年月);
        return entity;
    }
}
