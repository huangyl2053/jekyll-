/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shikakushogohyojyoho;

import jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif.KokuhorenJoho_TorikomiErrorKubun;
import jp.co.ndensan.reams.db.dbc.entity.csv.kagoketteihokenshain.KagoKetteiHokenshaInControlCsvEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.shikakushogohyojyoho.ShikakuShogohyoJyohoInDataHeadEntity;
import jp.co.ndensan.reams.db.dbc.entity.csv.shikakushogohyojyoho.ShikakuShogohyoJyohoInDataMeisaiEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shikakushogohyojyoho.DbWT1211ShikakuShogohyoTempEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0001HihokenshaEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanshikyuketteiin.DbWT0002KokuhorenTorikomiErrorEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HihokenshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.HokenKyufuRitsu;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.JigyoshaNo;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ServiceShuruiCode;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShoKisaiHokenshaNo;
import jp.co.ndensan.reams.db.dbz.business.core.hokenshainputguide.Hokensha;
import jp.co.ndensan.reams.db.dbz.service.core.hokensha.HokenshaNyuryokuHojoFinder;
import jp.co.ndensan.reams.ur.urz.definition.core.hokenja.HokenjaNo;
import jp.co.ndensan.reams.ur.urz.definition.core.shikibetsutaisho.SeibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 資格照合表情報取込共通処理（CSVファイル取込）Service
 *
 * @reamsid_L DBC-2890-013 wangxue
 */
public class ShikakuShogohyoJyohoReadCsvFileService {

    private static final int INT_0 = 0;

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShikakuShogohyoJyohoReadCsvFileService}のインスタンスを返します。
     *
     * @return KyufuJissekiKoshinReadCsvFileService
     */
    public static ShikakuShogohyoJyohoReadCsvFileService createInstance() {

        return InstanceProvider.create(ShikakuShogohyoJyohoReadCsvFileService.class);
    }

    /**
     * 資格照合表一時テーブル登録を設定する。
     *
     * @param controlCsvEntity KagoKetteiHokenshaInControlCsvEntity
     * @param meisaiCsvEntity ShikakuShogohyoJyohoInDataMeisaiEntity
     * @param 連番 int
     * @return DbWT1211ShikakuShogohyoEntity
     */
    public DbWT1211ShikakuShogohyoTempEntity to資格照合表一時(KagoKetteiHokenshaInControlCsvEntity controlCsvEntity,
            ShikakuShogohyoJyohoInDataMeisaiEntity meisaiCsvEntity, int 連番) {
        DbWT1211ShikakuShogohyoTempEntity tempEntity = new DbWT1211ShikakuShogohyoTempEntity();

        tempEntity.setRenban(連番);
        if (meisaiCsvEntity.getサービス種類コード() != null && !meisaiCsvEntity.getサービス種類コード().isEmpty()) {
            tempEntity.setServiceShuruiCode(new ServiceShuruiCode(meisaiCsvEntity.getサービス種類コード()));
        }
        tempEntity.setServiceShuruiMei(meisaiCsvEntity.getサービス種類名());
        if (meisaiCsvEntity.getサービス提供年月() != null && !meisaiCsvEntity.getサービス提供年月().isEmpty()) {
            tempEntity.setServiceTeikyoYM(new FlexibleYearMonth(meisaiCsvEntity.getサービス提供年月()));
        } else {
            tempEntity.setServiceTeikyoYM(FlexibleYearMonth.EMPTY);
        }
        tempEntity.setShubetsu(meisaiCsvEntity.get種別());
        if (meisaiCsvEntity.get事業所番号() != null && !meisaiCsvEntity.get事業所番号().isEmpty()) {
            tempEntity.setJigyoshoNo(new JigyoshaNo(meisaiCsvEntity.get事業所番号()));
        }
        tempEntity.setJigyoshoMei(meisaiCsvEntity.get事業所名());
        tempEntity.setSeinenYMD(getFlexibleDate(meisaiCsvEntity.get生年月日()));
        if (meisaiCsvEntity.get性別コード() != null && !meisaiCsvEntity.get性別コード().isEmpty()) {
            tempEntity.setSeibetsuCode(new SeibetsuCode(meisaiCsvEntity.get性別コード()));
        }
        if (meisaiCsvEntity.get要介護区分コード() != null && !meisaiCsvEntity.get要介護区分コード().isEmpty()) {
            tempEntity.setYokaigoKubunCode(new Code(meisaiCsvEntity.get要介護区分コード()));
        }
        tempEntity.setKyusochiTokureiCode(meisaiCsvEntity.get旧措置入所者特例コード());
        tempEntity.setNinteiYukoKikanKaishiYMD(getFlexibleDate(meisaiCsvEntity.get認定有効期間_開始年月日()));
        tempEntity.setNinteiYukoKikanShuryoYMD(getFlexibleDate(meisaiCsvEntity.get認定有効期間_終了年月日()));
        tempEntity.setGendoGakuTekiyoKikanKaishiYMD(getFlexibleDate(meisaiCsvEntity.get限度額適用期間_開始年月日()));
        tempEntity.setGendoGakuTekiyoKikanShuryoYMD(getFlexibleDate(meisaiCsvEntity.get限度額適用期間_終了年月日()));
        tempEntity.setShikyuGendoGaku(getDecimal(meisaiCsvEntity.get支給限度額()));
        if (meisaiCsvEntity.get居宅サービス計画作成区分コード() != null
                && !meisaiCsvEntity.get居宅サービス計画作成区分コード().isEmpty()) {
            tempEntity.setKyotakuServicePlanSakuseiKubunCode(new Code(meisaiCsvEntity.get居宅サービス計画作成区分コード()));
        }
        set事業所番号と費用(tempEntity, meisaiCsvEntity);
        if (controlCsvEntity.getHokenshaNo() != null && !controlCsvEntity.getHokenshaNo().isEmpty()) {
            tempEntity.setHokenshaNo(new HihokenshaNo(controlCsvEntity.getHokenshaNo()));
        }
        HokenshaNyuryokuHojoFinder hokenshaNyuryokuHojoFinder = HokenshaNyuryokuHojoFinder.createInstance();
        Hokensha hokensha = hokenshaNyuryokuHojoFinder.getHokensha(new HokenjaNo(controlCsvEntity.getHokenshaNo()));
        if (hokensha != null) {
            tempEntity.setHokenshaName(hokensha.get保険者名());
        } else {
            tempEntity.setHokenshaName(RString.EMPTY);
        }
        tempEntity.setShinsaYM(new FlexibleYearMonth(controlCsvEntity.getShoriYM()));
        return tempEntity;
    }

    /**
     * 被保険者一時テーブル登録を設定する。
     *
     * @param headCsvEntity ShikakuShogohyoJyohoInDataHeadEntity
     * @param meisaiCsvEntity ShikakuShogohyoJyohoInDataMeisaiEntity
     * @param 連番 int
     * @return DbWT0001HihokenshaEntity
     */
    public DbWT0001HihokenshaEntity to被保険者一時(ShikakuShogohyoJyohoInDataHeadEntity headCsvEntity,
            ShikakuShogohyoJyohoInDataMeisaiEntity meisaiCsvEntity, int 連番) {
        DbWT0001HihokenshaEntity tempEntity = new DbWT0001HihokenshaEntity();
        tempEntity.setMeisaiRenban(new Decimal(連番));
        if (headCsvEntity.get証記載保険者番号() != null && !headCsvEntity.get証記載保険者番号().isEmpty()) {
            tempEntity.setShoHokenshaNo(new ShoKisaiHokenshaNo(headCsvEntity.get証記載保険者番号()));
        }
        if (meisaiCsvEntity.get被保険者番号() != null && !meisaiCsvEntity.get被保険者番号().isEmpty()) {
            tempEntity.setOrgHihokenshaNo(new HihokenshaNo(meisaiCsvEntity.get被保険者番号()));
            tempEntity.setHihokenshaNo(new HihokenshaNo(meisaiCsvEntity.get被保険者番号()));
        }
        if (meisaiCsvEntity.getサービス提供年月() != null && !meisaiCsvEntity.getサービス提供年月().isEmpty()) {
            FlexibleYearMonth 年月 = new FlexibleYearMonth(meisaiCsvEntity.getサービス提供年月());
            RString 月末日 = meisaiCsvEntity.getサービス提供年月().concat(new RString(年月.getLastDay()));
            tempEntity.setServiceTeikyoYmd(new FlexibleDate(月末日));
        } else {
            tempEntity.setServiceTeikyoYmd(FlexibleDate.EMPTY);
        }
        tempEntity.setOrgHihokenshaKanaShimei(meisaiCsvEntity.get被保険者氏名());
        tempEntity.setOrgHihokenshaShimei(RString.EMPTY);
        tempEntity.setOldShichosonCode(null);
        tempEntity.setHenkanHihokenshaNo(null);
        tempEntity.setShichosonCode(null);
        tempEntity.setKannaiKangaiKubun(RString.EMPTY);
        tempEntity.setYubinNo(RString.EMPTY);
        tempEntity.setChoikiCode(RString.EMPTY);
        tempEntity.setGyoseikuCode(RString.EMPTY);
        tempEntity.setGyoseikuMei(RString.EMPTY);
        tempEntity.setJusho(RString.EMPTY);
        tempEntity.setBanchi(RString.EMPTY);
        tempEntity.setKatagaki(RString.EMPTY);
        tempEntity.setKanaMeisho(RString.EMPTY);
        tempEntity.setMeisho(RString.EMPTY);
        tempEntity.setShimei50onKana(RString.EMPTY);
        tempEntity.setShikibetsuCode(null);
        tempEntity.setShikakuShutokuYmd(FlexibleDate.EMPTY);
        tempEntity.setShikakuShutokuJiyuCode(RString.EMPTY);
        tempEntity.setShikakuSoshitsuYmd(FlexibleDate.EMPTY);
        tempEntity.setShikakuSoshitsuJiyuCode(RString.EMPTY);
        tempEntity.setSetaiShuyakuNo(null);
        return tempEntity;
    }

    /**
     * 被保険者一時テーブル登録を設定する。
     *
     * @return DbWT0002KokuhorenTorikomiErrorEntity
     */
    public DbWT0002KokuhorenTorikomiErrorEntity to処理結果リスト一時() {
        DbWT0002KokuhorenTorikomiErrorEntity tempEntity = new DbWT0002KokuhorenTorikomiErrorEntity();
        tempEntity.setErrorKubun(KokuhorenJoho_TorikomiErrorKubun.取込対象データなし.getコード());
        tempEntity.setShoHokanehshaNo(null);
        tempEntity.setHihokenshaNo(null);
        tempEntity.setKey1(RString.EMPTY);
        tempEntity.setKey2(RString.EMPTY);
        tempEntity.setKey3(RString.EMPTY);
        tempEntity.setKey4(RString.EMPTY);
        tempEntity.setKey5(RString.EMPTY);
        tempEntity.setHihokenshaKanaShimei(RString.EMPTY);
        tempEntity.setHihokenshaShimei(RString.EMPTY);
        tempEntity.setBiko(RString.EMPTY);

        return tempEntity;
    }

    private void set事業所番号と費用(DbWT1211ShikakuShogohyoTempEntity tempEntity, ShikakuShogohyoJyohoInDataMeisaiEntity meisaiCsvEntity) {

        if (meisaiCsvEntity.get支援事業所番号() != null && !meisaiCsvEntity.get支援事業所番号().isEmpty()) {
            tempEntity.setShienJigyoshoNo(new JigyoshaNo(meisaiCsvEntity.get支援事業所番号()));
        }
        tempEntity.setGetsuGakuShokujiFutanGaku(getDecimal(meisaiCsvEntity.get食事標準負担額_月額()));
        tempEntity.setNichiGakuShokujiFutanGaku(getDecimal(meisaiCsvEntity.get食事標準負担額_日額()));
        tempEntity.setShokuhiFutanGendoGaku(getDecimal(meisaiCsvEntity.get食費負担限度額()));
        tempEntity.setKyojuhiFutanGendoGaku1(getDecimal(meisaiCsvEntity.get居住費_負担限度額_1()));
        tempEntity.setKyojuhiFutanGendoGaku2(getDecimal(meisaiCsvEntity.get居住費_負担限度額_2()));
        tempEntity.setKyojuhiFutanGendoGaku3(getDecimal(meisaiCsvEntity.get居住費_負担限度額_3()));
        tempEntity.setKyojuhiFutanGendoGaku4(getDecimal(meisaiCsvEntity.get居住費_負担限度額_4()));
        tempEntity.setKyojuhiFutanGendoGaku5(getDecimal(meisaiCsvEntity.get居住費_負担限度額_5()));
        tempEntity.setTanisuTanka(getDecimal(meisaiCsvEntity.get単位数単価()));
        tempEntity.setHokenKyufuRitsu(get給付率(meisaiCsvEntity.get保険給付率()));
        tempEntity.setKohi1KyufuRitsu(get給付率(meisaiCsvEntity.get公費給付率_1()));
        tempEntity.setKohi2KyufuRitsu(get給付率(meisaiCsvEntity.get公費給付率_2()));
        tempEntity.setKohi3KyufuRitsu(get給付率(meisaiCsvEntity.get公費給付率_3()));
        if (null == meisaiCsvEntity.getサービス日数_回数() || meisaiCsvEntity.getサービス日数_回数().isEmpty()) {
            tempEntity.setServiceNissuKaisu(INT_0);
        } else {
            tempEntity.setServiceNissuKaisu(Integer.valueOf(meisaiCsvEntity.getサービス日数_回数().toString()));
        }
        tempEntity.setServiceTanisu(getDecimal(meisaiCsvEntity.getサービス単位数()));
        tempEntity.setTokuteiNyushoshaKaigoServiceGaku(getDecimal(meisaiCsvEntity.get特定入所者介護サービス費等()));
        tempEntity.setRiyoshaFutanGaku(getDecimal(meisaiCsvEntity.get利用者負担額()));
        tempEntity.setShokujiFutanGaku(getDecimal(meisaiCsvEntity.get食事標準負担額()));
    }

    private Decimal getDecimal(RString decimal) {

        if (null == decimal || decimal.isEmpty()) {
            return Decimal.ZERO;
        }
        return new Decimal(decimal.toString());
    }

    private HokenKyufuRitsu get給付率(RString 給付率) {
        if (null == 給付率 || 給付率.isEmpty()) {
            return HokenKyufuRitsu.ZERO;
        }
        return new HokenKyufuRitsu(getDecimal(給付率));
    }

    private FlexibleDate getFlexibleDate(RString date) {

        if (date == null || date.isEmpty()) {
            return FlexibleDate.EMPTY;
        }
        return new FlexibleDate(date);
    }

}
