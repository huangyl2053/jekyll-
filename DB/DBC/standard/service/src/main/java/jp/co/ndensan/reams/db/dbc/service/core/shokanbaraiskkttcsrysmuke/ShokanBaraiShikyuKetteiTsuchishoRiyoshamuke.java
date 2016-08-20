/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.core.shokanbaraiskkttcsrysmuke;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishohihokenshabun.ShokanKetteiTsuchiShoHihokenshabunItem;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.mybatisprm.shokanbaraiskkttcsrysmuke.ShokanBaraiSkKtTcsRysmukeParameter;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.shokanbaraiskkttcsrysmuke.ShokanBaraiSkKtTcsRysmukeEntity;
import jp.co.ndensan.reams.db.dbc.persistence.db.mapper.relate.shokanbaraiskkttcsrysmuke.IShokanBaraiSkKtTcsRysmukeMapper;
import jp.co.ndensan.reams.db.dbc.service.core.MapperProvider;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoHanyo;
import jp.co.ndensan.reams.db.dbz.definition.core.kyotsu.NinshoshaDenshikoinshubetsuCode;
import jp.co.ndensan.reams.db.dbz.service.core.basic.ChohyoSeigyoHanyoManager;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ua.uax.business.core.atesaki.IAtesaki;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiGyomuHanteiKeyFactory;
import jp.co.ndensan.reams.ua.uax.business.core.shikibetsutaisho.search.AtesakiPSMSearchKeyBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiEditorBuilder;
import jp.co.ndensan.reams.ua.uax.business.report.parts.sofubutsuatesaki.SofubutsuAtesakiSourceBuilder;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.GyomuKoyuKeyRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.core.enumeratedtype.SofusakiRiyoKubun;
import jp.co.ndensan.reams.ua.uax.definition.mybatisprm.atesaki.IAtesakiGyomuHanteiKey;
import jp.co.ndensan.reams.ua.uax.service.core.shikibetsutaisho.ShikibetsuTaishoService;
import jp.co.ndensan.reams.ur.urz.definition.core.ninshosha.KenmeiFuyoKubunType;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.ur.urz.entity.report.sofubutsuatesaki.SofubutsuAtesakiSource;
import jp.co.ndensan.reams.uz.uza.biz.GyomuCode;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.di.InstanceProvider;

/**
 * 償還払い支給（不支給）決定通知書（利用者向け）クラスです。
 *
 * @reamsid_L DBC-1000-050 chengsanyuan
 */
public class ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int SEVEN = 7;
    private static final int EIGHT = 8;
    private static final int NINE = 9;
    private static final int TEN = 10;
    private static final RString カンマ = new RString(",");
    private static final int パターン番号_1 = 1;
    private static final int パターン番号_2 = 2;
    private static final int パターン番号_3 = 3;
    private static final int パターン番号_4 = 4;
    private static final RString 帳票制御汎用キー_取り消し線 = new RString("取り消し線");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり１ = new RString("帳票タイトル_抹消線あり１");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり２ = new RString("帳票タイトル_抹消線あり２");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり３ = new RString("帳票タイトル_抹消線あり３");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり４ = new RString("帳票タイトル_抹消線あり４");
    private static final RString 帳票制御汎用キー_帳票タイトル = new RString("帳票タイトル");
    private static final RString 取り消し線を編集しない = new RString("0");
    private static final RString 取り消し線を編集する = new RString("1");
    private static final RString 増減の理由タイトル_支給 = new RString("増減の理由");
    private static final RString 増減の理由タイトル_不支給 = new RString("不支給の理由");
    private static final RString フォント小 = new RString("1");
    private static final RString フォント大 = new RString("2");
    private static final RString フォント混在_上大下小 = new RString("3");
    private static final RString フォント混在_上小下大 = new RString("4");
    private static final int 文字数_38 = 38;
    private static final int 文字数_76 = 76;

    private final MapperProvider mapper;

    /**
     * コンストラクタです。
     *
     * @param mapper マッパーインタフェース
     */
    ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke() {
        this.mapper = InstanceProvider.create(MapperProvider.class);
    }

    /**
     * テスト用コンストラクタです。
     *
     * @param mapper MapperProvider
     */
    ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke(MapperProvider mapper) {
        this.mapper = mapper;
    }

    /**
     * {@link InstanceProvider#create}にて生成した{@link ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke}のインスタンスを返します。
     *
     * @return {@link InstanceProvider#create}にて生成した{@link ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke}のインスタンス
     */
    public static ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke createInstance() {
        return InstanceProvider.create(ShokanBaraiShikyuKetteiTsuchishoRiyoshamuke.class);
    }

    /**
     * 償還払い支給（不支給）決定通知書バッチから取った入力パラメータにより、帳票データを作成します。
     *
     * @param businessList 償還払支給（不支給）決定通知書情報Entityリスト
     * @param batchPram バッチパラメータ
     * @param reportSourceWriter ReportSourceWriter
     * @return List<ShokanKetteiTsuchiShoHihokenshabunItem>
     */
    public List<ShokanKetteiTsuchiShoHihokenshabunItem> shokanBaraiShikyuKetteiTsuchishoRiyoshamuke(
            List<ShokanKetteiTsuchiShoShiharai> businessList,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, ReportSourceWriter reportSourceWriter) {

        List<ShokanKetteiTsuchiShoHihokenshabunItem> retList = new ArrayList<>();

        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(
                SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100005.getReportId(),
                batchPram.getHakkoYMD(), NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        RString 文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100005.getReportId(), batchPram.getHakkoYMD());

        RString 通知文１ = ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                ReportIdDBC.DBC100002_2.getReportId(), KamokuCode.EMPTY, パターン番号_1, ONE, batchPram.getHakkoYMD());
        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder 宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set基準日(batchPram.getHakkoYMD());
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        IAtesaki 宛先s = ShikibetsuTaishoService.getAtesakiFinder().get宛先(宛先builder.build());
        SofubutsuAtesakiSource atesakiSource
                = new SofubutsuAtesakiSourceBuilder(new SofubutsuAtesakiEditorBuilder(宛先s).build()).buildSource();
        RString key = RString.EMPTY;
        Decimal 支給金額 = Decimal.ZERO;
        RString 給付の種類 = RString.EMPTY;
        RString 増減理由等 = RString.EMPTY;
        RString サービス種類コード = RString.EMPTY;
        ShokanKetteiTsuchiShoHihokenshabunItem item = new ShokanKetteiTsuchiShoHihokenshabunItem();
        for (ShokanKetteiTsuchiShoShiharai shoShiharai : businessList) {
            if (key.equals(getKey(shoShiharai))) {
                支給金額 = 支給金額.add(shoShiharai.get支給額());
                if (サービス種類コード.equals(shoShiharai.getサービス種類コード())) {
                    continue;
                } else {
                    給付の種類 = set種類(給付の種類, shoShiharai.get種類());
                }
            } else {
                item = new ShokanKetteiTsuchiShoHihokenshabunItem();
                key = getKey(shoShiharai);
                支給金額 = shoShiharai.get支給額();
                給付の種類 = shoShiharai.get種類();
                増減理由等 = shoShiharai.get増減理由等();
                サービス種類コード = shoShiharai.getサービス種類コード();
            }
            if (給付の種類.length() <= 文字数_38) {
                item.setKyufuShu1(給付の種類);
            } else if (給付の種類.length() <= 文字数_76) {
                item.setKyufuShu1(給付の種類.substring(ZERO, 文字数_38));
                item.setKyufuShu2(給付の種類.substring(文字数_38));
            } else {
                item.setKyufuShu1(給付の種類.substring(ZERO, 文字数_38));
                item.setKyufuShu2(給付の種類.substring(文字数_38, 文字数_76));
                item.setKyufuShu3(給付の種類.substring(文字数_76));
            }
            if (増減理由等.length() <= 文字数_38) {
                item.setRiyu1(増減理由等);
            } else {
                item.setRiyu1(増減理由等.substring(ZERO, 文字数_38));
                item.setRiyu2(増減理由等.substring(文字数_38));
            }
            item.setBunshoNo(文書番号);
            item.setHihokenshaName(shoShiharai.get被保険者氏名());
            RString temp_被保険者番号 = shoShiharai.get被保険者番号().value();
            temp_被保険者番号 = temp_被保険者番号.padRight(TEN);
            item.setHihokenshaNo1(temp_被保険者番号.substring(ZERO, ONE));
            item.setHihokenshaNo2(temp_被保険者番号.substring(ONE, TWO));
            item.setHihokenshaNo3(temp_被保険者番号.substring(TWO, THREE));
            item.setHihokenshaNo4(temp_被保険者番号.substring(THREE, FOUR));
            item.setHihokenshaNo5(temp_被保険者番号.substring(FOUR, FIVE));
            item.setHihokenshaNo6(temp_被保険者番号.substring(FIVE, SIX));
            item.setHihokenshaNo7(temp_被保険者番号.substring(SIX, SEVEN));
            item.setHihokenshaNo8(temp_被保険者番号.substring(SEVEN, EIGHT));
            item.setHihokenshaNo9(temp_被保険者番号.substring(EIGHT, NINE));
            item.setHihokenshaNo10(temp_被保険者番号.substring(NINE));
            item.setUketsukeYMD(shoShiharai.get受付年月日() == null ? RString.EMPTY : shoShiharai.get受付年月日().wareki().toDateString());
            item.setKetteiYMD(shoShiharai.get決定年月日() == null ? RString.EMPTY : shoShiharai.get決定年月日().wareki().toDateString());
            item.setHonninShiharaiGaku(shoShiharai.get本人支払額() == null ? RString.EMPTY : new RString(shoShiharai.get本人支払額().toString()));
            item.setTaishoYM(shoShiharai.get提供年月() == null ? RString.EMPTY : shoShiharai.get提供年月().wareki().toDateString());
            if (!RString.isNullOrEmpty(shoShiharai.get支払方法区分コード())) {
                item.setKekka(ShikyuFushikyuKubun.toValue(shoShiharai.get支払方法区分コード()).get名称());
            }
            item.setShikyuGaku(new RString(支給金額.toString()));
            if (ShikyuFushikyuKubun.不支給.getコード().equals(shoShiharai.get支払方法区分コード())) {
                item.setRiyuTitle(増減の理由タイトル_不支給);
            } else {
                item.setRiyuTitle(増減の理由タイトル_支給);
            }
            item.setSeirino(shoShiharai.get整理番号());
            item.setTsuchino(shoShiharai.get決定通知No());
            setTitle(item, shoShiharai);
            item.setTsuchibun1(通知文１);
            item = set通知文(item, batchPram);
            setJigyoshoJoho(item, shoShiharai);
            setNinshosha(item, ninshoshaSource);
            setSofubutsuAtesaki(item, atesakiSource);
            retList.add(item);
        }
        return retList;
    }

    private RString set種類(RString kyufuShu, RString 種類) {
        if (RString.isNullOrEmpty(kyufuShu)) {
            return 種類;
        }
        RStringBuilder builder = new RStringBuilder(kyufuShu);
        if (!RString.isNullOrEmpty(種類)) {
            builder.append(カンマ);
            builder.append(種類);
        }
        return builder.toRString();
    }

    private void setTitle(ShokanKetteiTsuchiShoHihokenshabunItem item, ShokanKetteiTsuchiShoShiharai shoShiharai) {
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        if (取り消し線を編集しない.equals(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_取り消し線))) {
            item.setTitle(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル));
        }
        if (取り消し線を編集する.equals(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_取り消し線))) {
            item.setTitle2_1(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり１));
            if (ShikyuFushikyuKubun.不支給.getコード().equals(shoShiharai.get支払方法区分コード())) {
                item.setTitle2_2_1(RString.EMPTY);
                item.setTitle2_2_2(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり２));
                item.setTitle2_3_1(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり３));
                item.setTitle2_3_2(RString.EMPTY);
            } else {
                item.setTitle2_2_1(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり２));
                item.setTitle2_2_2(RString.EMPTY);
                item.setTitle2_3_1(RString.EMPTY);
                item.setTitle2_3_2(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり３));
            }
            item.setTitle2_4(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり４));
        }
    }

    private void setJigyoshoJoho(ShokanKetteiTsuchiShoHihokenshabunItem item, ShokanKetteiTsuchiShoShiharai shoShiharai) {
        ShokanBaraiSkKtTcsRysmukeEntity entity = mapper.create(IShokanBaraiSkKtTcsRysmukeMapper.class).get受任者情報(
                ShokanBaraiSkKtTcsRysmukeParameter.createParameter(shoShiharai.get被保険者番号(),
                        shoShiharai.get整理番号(), shoShiharai.get提供年月()));
        if (entity != null) {
            item.setJigyoshoName(entity.getKeiyakuJigyoshaName().value());
            item.setDaihyoshaName(entity.getKeiyakuDaihyoshaName().value());
            item.setJigyoshoYubinNo(entity.getKeiyakuJigyoshaYubinNo().getEditedYubinNo());
            item.setJigyoshoJusho(entity.getKeiyakuJigyoshaJusho().value());
            item.setJigyoshoTelNo(entity.getKeiyakuJigyoshaTelNo().value());
        }
    }

    private void setNinshosha(ShokanKetteiTsuchiShoHihokenshabunItem item, NinshoshaSource ninshoshaSource) {
        if (ninshoshaSource != null) {
            item.setHakkoYMD(ninshoshaSource.hakkoYMD);
            item.setDenshiKoin(ninshoshaSource.denshiKoin);
            item.setNinshoshaYakushokuMei(ninshoshaSource.ninshoshaYakushokuMei);
            item.setNinshoshaYakushokuMei1(ninshoshaSource.ninshoshaYakushokuMei1);
            item.setKoinMojiretsu(ninshoshaSource.koinMojiretsu);
            item.setNinshoshaYakushokuMei2(ninshoshaSource.ninshoshaYakushokuMei2);
            item.setNinshoshaShimeiKakenai(ninshoshaSource.ninshoshaShimeiKakenai);
            item.setNinshoshaShimeiKakeru(ninshoshaSource.ninshoshaShimeiKakeru);
            item.setKoinShoryaku(ninshoshaSource.koinShoryaku);
        }
    }

    private void setSofubutsuAtesaki(ShokanKetteiTsuchiShoHihokenshabunItem item, SofubutsuAtesakiSource atesakiSource) {
        if (atesakiSource != null) {
            item.setYubinNo(atesakiSource.yubinNo);
            item.setGyoseiku2(atesakiSource.gyoseiku);
            item.setJusho4(atesakiSource.jusho1);
            item.setJushoText(atesakiSource.jushoText);
            item.setJusho5(atesakiSource.jusho2);
            item.setJusho6(atesakiSource.jusho3);
            item.setKatagakiText(atesakiSource.katagakiText);
            item.setKatagaki3(atesakiSource.katagaki1);
            item.setKatagakiSmall2(atesakiSource.katagakiSmall2);
            item.setKatagaki4(atesakiSource.katagaki2);
            item.setKatagakiSmall1(atesakiSource.katagakiSmall1);
            item.setShimei5(atesakiSource.shimei1);
            item.setShimeiSmall2(atesakiSource.shimeiSmall2);
            item.setShimeiText(atesakiSource.shimeiText);
            item.setMeishoFuyo2(atesakiSource.meishoFuyo2);
            item.setShimeiSmall1(atesakiSource.shimeiSmall1);
            item.setDainoKubunMei(atesakiSource.dainoKubunMei);
            item.setShimei6(atesakiSource.shimei2);
            item.setMeishoFuyo1(atesakiSource.meishoFuyo1);
            item.setSamabunShimeiText(atesakiSource.samabunShimeiText);
            item.setKakkoLeft2(atesakiSource.kakkoLeft2);
            item.setSamabunShimei2(atesakiSource.samabunShimei2);
            item.setSamabunShimeiSmall2(atesakiSource.samabunShimeiSmall2);
            item.setSamaBun2(atesakiSource.samaBun2);
            item.setKakkoRight2(atesakiSource.kakkoRight2);
            item.setKakkoLeft1(atesakiSource.kakkoLeft1);
            item.setSamabunShimei1(atesakiSource.samabunShimei1);
            item.setSamaBun1(atesakiSource.samaBun1);
            item.setKakkoRight1(atesakiSource.kakkoRight1);
            item.setSamabunShimeiSmall1(atesakiSource.samabunShimeiSmall1);
            item.setCustomerBarCode(atesakiSource.customerBarCode);
        }
    }

    private RString get帳票制御汎用(ChohyoSeigyoHanyoManager 帳票制御汎用Manager, RString 項目名) {
        RString 設定値 = RString.EMPTY;
        ChohyoSeigyoHanyo chohyoSeigyoHanyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                FlexibleDate.getNowDate().getYear(), 項目名);
        if (chohyoSeigyoHanyo != null) {
            設定値 = chohyoSeigyoHanyo.get設定値();
        }
        return 設定値;
    }

    private RString getKey(ShokanKetteiTsuchiShoShiharai shoShiharai) {
        RStringBuilder rsb = new RStringBuilder();
        rsb.append(shoShiharai.get被保険者番号().value());
        rsb.append(shoShiharai.get提供年月() == null ? RString.EMPTY : shoShiharai.get提供年月().toDateString());
        rsb.append(shoShiharai.get整理番号());
        return rsb.toRString();
    }

    private ShokanKetteiTsuchiShoHihokenshabunItem set通知文(
            ShokanKetteiTsuchiShoHihokenshabunItem item, ShokanKetteiTsuchiShoSealerBatchParameter batchPram) {
        RString 定型文文字サイズ = ReportUtil.get定型文文字サイズ(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId());
        if (フォント小.equals(定型文文字サイズ)) {
            item.setTsuchibun2(ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100002_2.getReportId(), KamokuCode.EMPTY, パターン番号_1, TWO, batchPram.getHakkoYMD()));
        } else if (フォント大.equals(定型文文字サイズ)) {
            item.setTsuchibunLarge3(ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100002_2.getReportId(), KamokuCode.EMPTY, パターン番号_2, TWO, batchPram.getHakkoYMD()));
        } else if (フォント混在_上小下大.equals(定型文文字サイズ)) {
            item.setTsuchibunMix1(ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100002_2.getReportId(), KamokuCode.EMPTY, パターン番号_3, TWO, batchPram.getHakkoYMD()));
            item.setTsuchibunMix2(ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100002_2.getReportId(), KamokuCode.EMPTY, パターン番号_3, THREE, batchPram.getHakkoYMD()));
        } else if (フォント混在_上大下小.equals(定型文文字サイズ)) {
            item.setTsuchibunMixtwo1(ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100002_2.getReportId(), KamokuCode.EMPTY, パターン番号_4, TWO, batchPram.getHakkoYMD()));
            item.setTsuchibunMixtwo2(ReportUtil.get通知文(SubGyomuCode.DBC介護給付,
                    ReportIdDBC.DBC100002_2.getReportId(), KamokuCode.EMPTY, パターン番号_4, THREE, batchPram.getHakkoYMD()));
        }
        return item;
    }
}
