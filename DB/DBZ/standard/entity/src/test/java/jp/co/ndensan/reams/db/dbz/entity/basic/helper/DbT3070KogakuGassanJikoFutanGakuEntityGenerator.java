/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.entity.basic.helper;

import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbz.definition.valueobject.domain.HokenshaNo;
import jp.co.ndensan.reams.db.dbz.entity.basic.DbT3070KogakuGassanJikoFutanGakuEntity;
import jp.co.ndensan.reams.uz.uza.biz.AtenaKanaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.YMDHMS;
import jp.co.ndensan.reams.uz.uza.biz.YubinNo;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;

/**
 * 高額合算自己負担額エンティティのテスト用インスタンスを作成する補助クラスです。
 *
 * @author LDNS 周杏月
 */
public final class DbT3070KogakuGassanJikoFutanGakuEntityGenerator {

    public static final HihokenshaNo DEFAULT_被保険者番号 = new HihokenshaNo(new RString("2"));
    public static final FlexibleYear DEFAULT_対象年度 = new FlexibleYear("2014");
    public static final HokenshaNo DEFAULT_保険者番号 = new HokenshaNo(new RString("2"));
    public static final RString DEFAULT_支給申請書整理番号 = new RString("1");
    public static final YMDHMS DEFAULT_処理日時 = new YMDHMS(new RString("20140415102030"));
    public static final RString DEFAULT_保険制度コード = new RString("1");
    public static final RString DEFAULT_保険者名 = new RString("1");
    public static final RString DEFAULT_国保被保険者証記号 = new RString("1");
    public static final AtenaKanaMeisho DEFAULT_被保険者氏名カナ = new AtenaKanaMeisho("デンサンタロウ");
    public static final AtenaMeisho DEFAULT_被保険者氏名 = new AtenaMeisho("電算太郎");
    public static final FlexibleDate DEFAULT_生年月日 = new FlexibleDate("20140402");
    public static final Code DEFAULT_性別 = new Code("3");
    public static final RString DEFAULT_所得区分 = new RString("1");
    public static final RString DEFAULT_70歳以上の者に係る所得区分 = new RString("1");
    public static final RString DEFAULT_自己負担額証明書整理番号 = new RString("1");
    public static final RString DEFAULT_後期保険者番号 = new RString("1");
    public static final RString DEFAULT_後期被保険者番号 = new RString("1");
    public static final RString DEFAULT_国保保険者番号 = new RString("1");
    public static final RString DEFAULT_国保被保険者証番号 = new RString("1");
    public static final RString DEFAULT_国保個人番号 = new RString("1");
    public static final RString DEFAULT_異動区分 = new RString("1");
    public static final RString DEFAULT_補正済自己負担額送付区分 = new RString("1");
    public static final FlexibleDate DEFAULT_対象計算期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_対象計算期間終了年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_被保険者期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_被保険者期間終了年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_申請年月日 = new FlexibleDate("20140402");
    public static final Decimal DEFAULT_合計_自己負担額 = new Decimal(1);
    public static final Decimal DEFAULT_合計_70_74自己負担額_内訳 = new Decimal(1);
    public static final Decimal DEFAULT_合計_70未満高額支給額 = new Decimal(1);
    public static final Decimal DEFAULT_合計_70_74高額支給額 = new Decimal(1);
    public static final Decimal DEFAULT_補正済_合計_自己負担額 = new Decimal(1);
    public static final Decimal DEFAULT_補正済_合計_70_74自己負担額_内訳 = new Decimal(1);
    public static final Decimal DEFAULT_補正済_合計_70未満高額支給額 = new Decimal(1);
    public static final Decimal DEFAULT_補正済_合計_70_74高額支給額 = new Decimal(1);
    public static final AtenaMeisho DEFAULT_宛先氏名 = new AtenaMeisho("電算太郎");
    public static final YubinNo DEFAULT_宛先郵便番号 = new YubinNo(new RString("123-1234"));
    public static final RString DEFAULT_宛先住所 = new RString("1");
    public static final RString DEFAULT_窓口払対象者判定コード = new RString("1");
    public static final RString DEFAULT_支払場所 = new RString("1");
    public static final FlexibleDate DEFAULT_支払期間開始年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_支払期間終了年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_閉庁内容 = new RString("1");
    public static final RString DEFAULT_支払期間開始時間 = new RString("1");
    public static final RString DEFAULT_支払期間終了時間 = new RString("1");
    public static final RString DEFAULT_備考 = new RString("1");
    public static final RString DEFAULT_データ作成区分 = new RString("1");
    public static final FlexibleYearMonth DEFAULT_自己負担額確認情報受取年月 = new FlexibleYearMonth(new RString("201406"));
    public static final FlexibleYearMonth DEFAULT_補正済自己負担額情報送付年月 = new FlexibleYearMonth(new RString("201406"));
    public static final FlexibleYearMonth DEFAULT_自己負担額証明書情報受取年月 = new FlexibleYearMonth(new RString("201406"));
    public static final RString DEFAULT_再送フラグ = new RString("1");
    public static final RString DEFAULT_送付対象外フラグ = new RString("1");
    public static final FlexibleDate DEFAULT_自己負担額計算年月日 = new FlexibleDate("20140402");
    public static final FlexibleDate DEFAULT_自己負担額証明書作成年月日 = new FlexibleDate("20140402");
    public static final RString DEFAULT_後期_国保処理区分 = new RString("1");

    /**
     * インスタンス化を防ぐためのプライベートコンストラクタです。
     */
    private DbT3070KogakuGassanJikoFutanGakuEntityGenerator() {
    }

    public static DbT3070KogakuGassanJikoFutanGakuEntity createDbT3070KogakuGassanJikoFutanGakuEntity() {
        DbT3070KogakuGassanJikoFutanGakuEntity entity = new DbT3070KogakuGassanJikoFutanGakuEntity();
        entity.setHihokenshaNo(DEFAULT_被保険者番号);
        entity.setTaishoNendo(DEFAULT_対象年度);
        entity.setHokenshaNo(DEFAULT_保険者番号);
        entity.setShikyuShinseishoSeiriNo(DEFAULT_支給申請書整理番号);
        entity.setShoriTimestamp(DEFAULT_処理日時);
        entity.setHokenSeidoCode(DEFAULT_保険制度コード);
        entity.setHokenshaMei(DEFAULT_保険者名);
        entity.setKokuho_HihokenshaShoKigo(DEFAULT_国保被保険者証記号);
        entity.setHihokenshaShimeiKana(DEFAULT_被保険者氏名カナ);
        entity.setHihokenshaShimei(DEFAULT_被保険者氏名);
        entity.setUmareYMD(DEFAULT_生年月日);
        entity.setSeibetsuCode(DEFAULT_性別);
        entity.setShotokuKubun(DEFAULT_所得区分);
        entity.setOver70_ShotokuKubun(DEFAULT_70歳以上の者に係る所得区分);
        entity.setJikoFutanSeiriNo(DEFAULT_自己負担額証明書整理番号);
        entity.setKoki_HokenshaNo(DEFAULT_後期保険者番号);
        entity.setKoki_HihokenshaNo(DEFAULT_後期被保険者番号);
        entity.setKokuho_HokenshaNo(DEFAULT_国保保険者番号);
        entity.setKokuho_HihokenshaShoNo(DEFAULT_国保被保険者証番号);
        entity.setKokuho_KojinNo(DEFAULT_国保個人番号);
        entity.setIdoKubun(DEFAULT_異動区分);
        entity.setHoseiZumiSofuKubun(DEFAULT_補正済自己負担額送付区分);
        entity.setTaishoKeisanKaishiYMD(DEFAULT_対象計算期間開始年月日);
        entity.setTaishoKeisanShuryoYMD(DEFAULT_対象計算期間終了年月日);
        entity.setHihokenshaKaishiYMD(DEFAULT_被保険者期間開始年月日);
        entity.setHihokenshaShuryoYMD(DEFAULT_被保険者期間終了年月日);
        entity.setShinseiYMD(DEFAULT_申請年月日);
        entity.setGokei_JikoFutanGaku(DEFAULT_合計_自己負担額);
        entity.setGokei_70_74JikoFutanGaku(DEFAULT_合計_70_74自己負担額_内訳);
        entity.setGokei_Under70KogakuShikyuGaku(DEFAULT_合計_70未満高額支給額);
        entity.setGokei_70_74KogakuShikyuGaku(DEFAULT_合計_70_74高額支給額);
        entity.setSumi_Gokei_JikoFutanGaku(DEFAULT_補正済_合計_自己負担額);
        entity.setSumi_Gokei_70_74JikoFutanGaku(DEFAULT_補正済_合計_70_74自己負担額_内訳);
        entity.setSumi_Gokei_Under70KogakuShikyuGaku(DEFAULT_補正済_合計_70未満高額支給額);
        entity.setSumi_Gokei_70_74KogakuShikyuGaku(DEFAULT_補正済_合計_70_74高額支給額);
        entity.setAtesakiShimei(DEFAULT_宛先氏名);
        entity.setAtesakiYubinNo(DEFAULT_宛先郵便番号);
        entity.setAtesakiJusho(DEFAULT_宛先住所);
        entity.setMadoguchi_TaishoshaHanteiCode(DEFAULT_窓口払対象者判定コード);
        entity.setShiharaiBasho(DEFAULT_支払場所);
        entity.setShikaraiKaishiYMD(DEFAULT_支払期間開始年月日);
        entity.setShiharaiShuryoYMD(DEFAULT_支払期間終了年月日);
        entity.setHeichoNaiyo(DEFAULT_閉庁内容);
        entity.setShiharaiKaishiTime(DEFAULT_支払期間開始時間);
        entity.setShiharaiShuryoTime(DEFAULT_支払期間終了時間);
        entity.setBiko(DEFAULT_備考);
        entity.setDataSakuseiKubun(DEFAULT_データ作成区分);
        entity.setKakunin_UketoriYM(DEFAULT_自己負担額確認情報受取年月);
        entity.setHoseiZumi_SofuYM(DEFAULT_補正済自己負担額情報送付年月);
        entity.setShomeisho_UketoriYM(DEFAULT_自己負担額証明書情報受取年月);
        entity.setSaisoFlag(DEFAULT_再送フラグ);
        entity.setSofuTaishoGaiFlag(DEFAULT_送付対象外フラグ);
        entity.setJikoFutanKeisanYMD(DEFAULT_自己負担額計算年月日);
        entity.setShomeiShoSakuseiYMD(DEFAULT_自己負担額証明書作成年月日);
        entity.setKoki_KokuhoShoriKubun(DEFAULT_後期_国保処理区分);
        return entity;
    }
}
