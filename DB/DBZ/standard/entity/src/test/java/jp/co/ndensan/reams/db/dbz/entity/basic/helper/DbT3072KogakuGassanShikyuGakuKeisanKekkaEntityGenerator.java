/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.TelNo;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算支給額計算結果エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYear DEFAULT_対象年度 = new FlexibleYear("2014");
    public static final HokenshaNo DEFAULT_証記載保険者番号 = new HokenshaNo(new RString("2"));
    public static final RString DEFAULT_支給申請書整理番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_保険制度コード = new RString("1");
    public static final RString DEFAULT_自己負担額証明書整理番号 = new RString("1");
    public static final FlexibleDate DEFAULT_対象計算期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_対象計算期間終了年月日 = new FlexibleDate("20140402");
    public static final Decimal DEFAULT_世帯負担総額 = new Decimal(1);
    public static final Decimal DEFAULT_介護等合算一部負担金等世帯合算額 = new Decimal(1);
    public static final Decimal DEFAULT_70歳以上介護等合算一部負担金等世帯合算額 = new Decimal(1);
    public static final RString DEFAULT_所得区分 = new RString("1");
    public static final RString DEFAULT_70歳以上の者に係る所得区分 = new RString("1");
    public static final Decimal DEFAULT_介護等合算算定基準額 = new Decimal(1);
    public static final Decimal DEFAULT_70歳以上介護等合算算定基準額 = new Decimal(1);
    public static final Decimal DEFAULT_世帯支給総額 = new Decimal(1);
    public static final Decimal DEFAULT_うち70歳以上分世帯支給総額 = new Decimal(1);
    public static final Decimal DEFAULT_按分後支給額 = new Decimal(1);
    public static final Decimal DEFAULT_うち70歳以上分按分後支給額 = new Decimal(1);
    public static final RString DEFAULT_介護低所得者Ⅰ再計算実施の有無 = new RString("1");
    public static final RString DEFAULT_備考 = new RString("1");
    public static final YubinNo DEFAULT_支給額計算結果連絡先郵便番号 = new YubinNo(new RString("123-1234"));
    public static final RString DEFAULT_支給額計算結果連絡先住所 = new RString("1");
    public static final RString DEFAULT_支給額計算結果連絡先名称1 = new RString("1");
    public static final RString DEFAULT_支給額計算結果連絡先名称2 = new RString("1");
    public static final FlexibleDate DEFAULT_通知年月日 = new FlexibleDate("20140402");
    public static final AtenaMeisho DEFAULT_連絡票発行者名 = new AtenaMeisho("電算太郎");
    public static final YubinNo DEFAULT_連絡票発行者郵便番号 = new YubinNo(new RString("123-1234"));
    public static final RString DEFAULT_連絡票発行者住所 = new RString("1");
    public static final YubinNo DEFAULT_問い合わせ先郵便番号 = new YubinNo(new RString("123-1234"));
    public static final RString DEFAULT_問い合わせ先住所 = new RString("1");
    public static final RString DEFAULT_問い合わせ先名称1 = new RString("1");
    public static final RString DEFAULT_問い合わせ先名称2 = new RString("1");
    public static final TelNo DEFAULT_問い合わせ先電話番号 = new TelNo("012-345-6789");
    public static final Decimal DEFAULT_70歳以上負担額合計 = new Decimal(1);
    public static final Decimal DEFAULT_70歳以上支給額合計 = new Decimal(1);
    public static final Decimal DEFAULT_70歳未満負担額合計 = new Decimal(1);
    public static final Decimal DEFAULT_負担額の合計額 = new Decimal(1);
    public static final Decimal DEFAULT_70歳未満支給額合計 = new Decimal(1);
    public static final Decimal DEFAULT_支給額合計額 = new Decimal(1);
    public static final RString DEFAULT_データ区分 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_受取年月 = new FlexibleYearMonth(new RString("201406"));
    public static final FlexibleYearMonth DEFAULT_送付年月 = new FlexibleYearMonth(new RString("201406"));

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3072KogakuGassanShikyuGakuKeisanKekkaEntityGenerator() {
    }

    public static DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity createDbT3072KogakuGassanShikyuGakuKeisanKekkaEntity() {
        DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity entity = new DbT3072KogakuGassanShikyuGakuKeisanKekkaEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoNendo(DEFAULT_対象年度);
        entity.setShoKisaiHokenshaNo(DEFAULT_証記載保険者番号);
        entity.setShikyuShinseishoSeiriNo(DEFAULT_支給申請書整理番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setHokenSeidoCode(DEFAULT_保険制度コード);
        entity.setJikoFutanSeiriNo(DEFAULT_自己負担額証明書整理番号);
        entity.setTaishoKeisanKaishiYMD(DEFAULT_対象計算期間開始年月日);
        entity.setTaishoKeisanShuryoYMD(DEFAULT_対象計算期間終了年月日);
        entity.setSetaiFutanSogaku(DEFAULT_世帯負担総額);
        entity.setSetaiGassanGaku(DEFAULT_介護等合算一部負担金等世帯合算額);
        entity.setOver70_SetaiGassanGaku(DEFAULT_70歳以上介護等合算一部負担金等世帯合算額);
        entity.setShotokuKubun(DEFAULT_所得区分);
        entity.setOver70_ShotokuKubun(DEFAULT_70歳以上の者に係る所得区分);
        entity.setSanteiKijunGaku(DEFAULT_介護等合算算定基準額);
        entity.setOver70_SanteiKijyunGaku(DEFAULT_70歳以上介護等合算算定基準額);
        entity.setSetaiShikyuSogaku(DEFAULT_世帯支給総額);
        entity.setOver70_SetaiShikyuSogaku(DEFAULT_うち70歳以上分世帯支給総額);
        entity.setHonninShikyugaku(DEFAULT_按分後支給額);
        entity.setOver70_honninShikyugaku(DEFAULT_うち70歳以上分按分後支給額);
        entity.setTeiShotoku_1_SaiKeisanUmu(DEFAULT_介護低所得者Ⅰ再計算実施の有無);
        entity.setBiko(DEFAULT_備考);
        entity.setKekkaRenrakusakiYubinNo(DEFAULT_支給額計算結果連絡先郵便番号);
        entity.setKekkaRenrakusakiJusho(DEFAULT_支給額計算結果連絡先住所);
        entity.setKetteRenrakusakiMeisho1(DEFAULT_支給額計算結果連絡先名称1);
        entity.setKekkaRenrakusakiMeisho2(DEFAULT_支給額計算結果連絡先名称2);
        entity.setTsuchiYMD(DEFAULT_通知年月日);
        entity.setRenrakuhyoHakkoshaMei(DEFAULT_連絡票発行者名);
        entity.setRenrakuhyoHakkoshaYubinNo(DEFAULT_連絡票発行者郵便番号);
        entity.setRenrakuhyoHakkoshaJusho(DEFAULT_連絡票発行者住所);
        entity.setToiawasesakiYobinNo(DEFAULT_問い合わせ先郵便番号);
        entity.setToiawasesakiJusho(DEFAULT_問い合わせ先住所);
        entity.setToiawasesakiMeisho1(DEFAULT_問い合わせ先名称1);
        entity.setToiawasesakiMeisho2(DEFAULT_問い合わせ先名称2);
        entity.setToiawasesakiTelNo(DEFAULT_問い合わせ先電話番号);
        entity.setOver70_FutangakuGokei(DEFAULT_70歳以上負担額合計);
        entity.setOver70_ShikyugakuGokei(DEFAULT_70歳以上支給額合計);
        entity.setUnder70_FutangakuGokei(DEFAULT_70歳未満負担額合計);
        entity.setFutangakuGokei(DEFAULT_負担額の合計額);
        entity.setUnder70_ShikyugakuGokei(DEFAULT_70歳未満支給額合計);
        entity.setShikyugakuGokei(DEFAULT_支給額合計額);
        entity.setDataKubun(DEFAULT_データ区分);
        entity.setUketoriYM(DEFAULT_受取年月);
        entity.setSofuYM(DEFAULT_送付年月);
        return entity;
    }
}
