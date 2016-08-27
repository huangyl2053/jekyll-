/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.service.report.shokanbaraishikyufushikyuketteitsuhchishochohyo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.core.shokanketteitsuchishoshiharai.ShokanKetteiTsuchiShoShiharai;
import jp.co.ndensan.reams.db.dbc.business.report.shokanketteitsuchishoshiharaiyoteibiyijiari.ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.shokanketteitsuchishosealer.ShokanKetteiTsuchiShoSealerBatchParameter;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shikyufushikyukubun.ShikyuFushikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.reportid.ReportIdDBC;
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
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYear;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 償還払い支給（不支給）決定通知書_バッチPrinterです。
 *
 * @reamsid_L DBC-1000-060 lizhuoxuan
 */
public class ShokanBaraiShikyuFushikyuKetteiTsuchishoBatch {

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
    private static final int 文字数_38 = 38;
    private static final int 文字数_76 = 76;
    private static final RString カンマ = new RString(",");
    private static final RString 記号_星 = new RString("**************");
    private static final RString 帳票制御汎用キー_持ち物内容文言１ = new RString("持ち物内容文言１");
    private static final RString 帳票制御汎用キー_持ち物内容文言２ = new RString("持ち物内容文言２");
    private static final RString 帳票制御汎用キー_持ち物内容文言３ = new RString("持ち物内容文言３");
    private static final RString KARA = new RString("～");
    private static final RString 帳票制御汎用キー_取り消し線 = new RString("取り消し線");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり１ = new RString("帳票タイトル_抹消線あり１");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり２ = new RString("帳票タイトル_抹消線あり２");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり３ = new RString("帳票タイトル_抹消線あり３");
    private static final RString 帳票制御汎用キー_帳票タイトル_抹消線あり４ = new RString("帳票タイトル_抹消線あり４");
    private static final RString 帳票制御汎用キー_帳票タイトル = new RString("帳票タイトル");
    private static final RString 取り消し線を編集しない = new RString("0");
    private static final RString 取り消し線を編集する = new RString("1");
    private static final RString 種別タイトル_口座種別 = new RString("口座種別");
    private static final RString 種別タイトル_店番 = new RString("店番");
    private static final RString 番号タイトル_口座番号 = new RString("口座番号");
    private static final RString 増減の理由タイトル_不支給の理由 = new RString("不支給の理由");
    private static final RString 増減の理由タイトル_増減の理由 = new RString("増減の理由");
    private static final RString 金融機関コード_郵便局 = new RString("9900");
    private static final RString フォント小 = new RString("1");
    private static final RString フォント大 = new RString("2");
    private static final RString フォント混在_上大下小 = new RString("3");
    private static final RString フォント混在_上小下大 = new RString("4");

    /**
     * 帳票データを作成します。
     *
     * @param shiharaiList 償還払支給（不支給）決定通知書情報Entityリスト
     * @param batchPram バッチパラメータ
     * @param reportSourceWriter IReportWriter
     * @return 償還払支給（不支給）決定通知書（受領委任払い・被保険者用）のITEM
     */
    public List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> getShokanHaraiShikyuFushikyuKetteiTsuhchishoChohyoData(
            List<ShokanKetteiTsuchiShoShiharai> shiharaiList, ShokanKetteiTsuchiShoSealerBatchParameter batchPram,
            ReportSourceWriter reportSourceWriter) {

        Collections.sort(shiharaiList, new Comparator<ShokanKetteiTsuchiShoShiharai>() {
            @Override
            public int compare(ShokanKetteiTsuchiShoShiharai o1, ShokanKetteiTsuchiShoShiharai o2) {
                return getSortKey(o1).compareTo(getSortKey(o2));
            }
        });
        return 帳票データ作成(shiharaiList, batchPram, reportSourceWriter);
    }

    private List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> 帳票データ作成(List<ShokanKetteiTsuchiShoShiharai> shiharaiList,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, ReportSourceWriter reportSourceWriter) {

        NinshoshaSource ninshoshaSource = ReportUtil.get認証者情報(
                SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(), batchPram.getHakkoYMD(),
                NinshoshaDenshikoinshubetsuCode.保険者印.getコード(), KenmeiFuyoKubunType.付与なし, reportSourceWriter);
        RString 文書番号 = ReportUtil.get文書番号(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(), batchPram.getHakkoYMD());

        IAtesakiGyomuHanteiKey 宛先業務判定キー = AtesakiGyomuHanteiKeyFactory.createInstace(GyomuCode.DB介護保険, SubGyomuCode.DBC介護給付);
        AtesakiPSMSearchKeyBuilder 宛先builder = new AtesakiPSMSearchKeyBuilder(宛先業務判定キー);
        宛先builder.set業務固有キー利用区分(GyomuKoyuKeyRiyoKubun.利用しない);
        宛先builder.set基準日(batchPram.getHakkoYMD());
        宛先builder.set送付先利用区分(SofusakiRiyoKubun.利用する);
        IAtesaki 宛先 = ShikibetsuTaishoService.getAtesakiFinder().get宛先(宛先builder.build());
        SofubutsuAtesakiSource atesakiSource
                = new SofubutsuAtesakiSourceBuilder(new SofubutsuAtesakiEditorBuilder(宛先).build()).buildSource();

        List<ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem> 帳票ソースデータ = new ArrayList<>();
        ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item = new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem();
        RString key = RString.EMPTY;
        RString serviceCode = RString.EMPTY;
        RString kyufuShu = RString.EMPTY;
        for (ShokanKetteiTsuchiShoShiharai shiharai : shiharaiList) {
            if (key.equals(getJufukuKey(shiharai))) {
                if (serviceCode.equals(shiharai.getサービス種類コード())) {
                    continue;
                } else {
                    kyufuShu = set種類(kyufuShu, shiharai.get種類());
                }
            } else {
                item = new ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem();
                帳票ソースデータ.add(item);
                kyufuShu = shiharai.get種類();
            }
            key = getJufukuKey(shiharai);
            serviceCode = shiharai.getサービス種類コード();
            item.setBunshoNo(文書番号);
            if (kyufuShu.length() <= 文字数_38) {
                item.setKyufuShu1(kyufuShu);
            } else if (kyufuShu.length() <= 文字数_76) {
                item.setKyufuShu1(kyufuShu.substring(ZERO, 文字数_38));
                item.setKyufuShu2(kyufuShu.substring(文字数_38));
            } else {
                item.setKyufuShu1(kyufuShu.substring(ZERO, 文字数_38));
                item.setKyufuShu2(kyufuShu.substring(文字数_38, 文字数_76));
                item.setKyufuShu3(kyufuShu.substring(文字数_76));
            }
            item = create帳票ソースデータ(item, ninshoshaSource, shiharai, batchPram, atesakiSource);
        }
        return 帳票ソースデータ;
    }

    private RString getJufukuKey(ShokanKetteiTsuchiShoShiharai shiharai) {
        RStringBuilder key = new RStringBuilder();
        key.append(shiharai.get被保険者番号().value());
        key.append(shiharai.get提供年月().wareki().toDateString());
        key.append(shiharai.get整理番号().padLeft(new RString(ZERO), TEN));
        return key.toRString();
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

    private ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem create帳票ソースデータ(ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item,
            NinshoshaSource ninshoshaSource, ShokanKetteiTsuchiShoShiharai shiharai,
            ShokanKetteiTsuchiShoSealerBatchParameter batchPram, SofubutsuAtesakiSource atesaki) {

        RString hihokenshaNo = shiharai.get被保険者番号().value().padLeft(RString.HALF_SPACE, TEN);
        item.setHihokenshaName(shiharai.get被保険者氏名());
        item.setHihokenshaNo1(hihokenshaNo.substring(ZERO, ONE));
        item.setHihokenshaNo2(hihokenshaNo.substring(ONE, TWO));
        item.setHihokenshaNo3(hihokenshaNo.substring(TWO, THREE));
        item.setHihokenshaNo4(hihokenshaNo.substring(THREE, FOUR));
        item.setHihokenshaNo5(hihokenshaNo.substring(FOUR, FIVE));
        item.setHihokenshaNo6(hihokenshaNo.substring(FIVE, SIX));
        item.setHihokenshaNo7(hihokenshaNo.substring(SIX, SEVEN));
        item.setHihokenshaNo8(hihokenshaNo.substring(SEVEN, EIGHT));
        item.setHihokenshaNo9(hihokenshaNo.substring(EIGHT, NINE));
        item.setHihokenshaNo10(hihokenshaNo.substring(NINE));
        item.setUketsukeYMD(shiharai.get受付年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        item.setKetteiYMD(shiharai.get決定年月日().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        item.setHonninShiharaiGaku(shiharai.get本人支払額() == null
                ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(shiharai.get本人支払額(), ZERO));
        item.setTaishoYM(shiharai.get提供年月().wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN).
                separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        if (!RString.isNullOrEmpty(shiharai.get支給不支給決定区分())) {
            item.setKekka(ShikyuFushikyuKubun.toValue(shiharai.get支給不支給決定区分()).get名称());
        }
        item.setShikyuGaku(shiharai.get支給額() == null ? RString.EMPTY : DecimalFormatter.toコンマ区切りRString(shiharai.get支給額(), ZERO));
        RString 増減の理由 = shiharai.get増減理由等();
        if (RString.isNullOrEmpty(増減の理由) || 増減の理由.length() <= 文字数_38) {
            item.setRiyu1(増減の理由);
        } else if (増減の理由.length() <= 文字数_76) {
            item.setRiyu1(増減の理由.substring(ZERO, 文字数_38));
            item.setRiyu2(増減の理由.substring(文字数_38));
        } else {
            item.setRiyu1(増減の理由.substring(ZERO, 文字数_38));
            item.setRiyu2(増減の理由.substring(文字数_38, 文字数_76));
            item.setRiyu3(RString.EMPTY);
        }
        if (ShiharaiHohoKubun.窓口払.getコード().equals(shiharai.get支払方法区分コード())) {
            item.setTorikeshi1(RString.EMPTY);
            item.setTorikeshi2(RString.EMPTY);
            item.setTorikeshiMochimono1(RString.EMPTY);
            item.setTorikeshiMochimono2(RString.EMPTY);
            item.setTorikeshiShiharaibasho(RString.EMPTY);
            item.setTorikeshiShiharaikikan(RString.EMPTY);
        } else if (ShiharaiHohoKubun.口座払.getコード().equals(shiharai.get支払方法区分コード())) {
            item.setTorikeshi1(記号_星);
            item.setTorikeshi2(記号_星);
            item.setTorikeshiMochimono1(記号_星);
            item.setTorikeshiMochimono2(記号_星);
            item.setTorikeshiShiharaibasho(記号_星);
            item.setTorikeshiShiharaikikan(記号_星);
        }
        ChohyoSeigyoHanyoManager 帳票制御汎用Manager = new ChohyoSeigyoHanyoManager();
        item.setMochimono1(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_持ち物内容文言１));
        item.setMochimono2(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_持ち物内容文言２));
        item.setMochimono3(get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_持ち物内容文言３));
        item.setShiharaiBasho(batchPram.getShiharaiBasho());
        item.setShiharaiStartYMD(shiharai.get支払期間開始年月日() == null
                ? RString.EMPTY : shiharai.get支払期間開始年月日().wareki().eraType(
                        EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        item.setShiharaiEndYMD(shiharai.get支払期間終了年月日() == null
                ? RString.EMPTY : shiharai.get支払期間終了年月日().wareki().eraType(
                        EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        item.setShiharaiStartHMS(setDataTimeFomart(shiharai.get支払窓口開始時間()));
        item.setShiharaiEndHMS(setDataTimeFomart(shiharai.get支払窓口終了期間()));
        if (!RString.isNullOrEmpty(shiharai.get支払窓口開始時間()) && !RString.isNullOrEmpty(shiharai.get支払窓口終了期間())) {
            item.setKaraFugo(KARA);
        }
        item.setBankName(shiharai.get金融機関名称());
        item.setBranchBankName(shiharai.get支店名称());
        item.setKouzaShu(shiharai.get預金種別名称());
        item.setKouzaNo(shiharai.get口座番号());
        item.setKouzaMeigi(shiharai.get口座名義人漢字());
        item.setSihaYoYmd(batchPram.getHurikomiYMD() == null
                ? RString.EMPTY : batchPram.getHurikomiYMD().wareki().eraType(
                        EraType.KANJI).firstYear(FirstYear.GAN_NEN).separator(
                        Separator.JAPANESE).fillType(FillType.BLANK).toDateString());
        item.setSeirino(shiharai.get整理番号());
        item.setTsuchino(shiharai.get決定通知No());
        RString タイトル = RString.EMPTY;
        RString タイトル2_1 = RString.EMPTY;
        RString タイトル2_2_1 = RString.EMPTY;
        RString タイトル2_2_2 = RString.EMPTY;
        RString タイトル2_3_1 = RString.EMPTY;
        RString タイトル2_3_2 = RString.EMPTY;
        RString タイトル2_4 = RString.EMPTY;
        RString 取り消し線 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_取り消し線);
        if (取り消し線を編集しない.equals(取り消し線)) {
            タイトル = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル);
        } else if (取り消し線を編集する.equals(取り消し線)) {
            タイトル2_1 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり１);
            タイトル2_4 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり４);
            if (ShikyuFushikyuKubun.支給.getコード().equals(shiharai.get支給不支給決定区分())) {
                タイトル2_2_1 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり２);
                タイトル2_3_2 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり３);
            } else {
                タイトル2_2_2 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり２);
                タイトル2_3_1 = get帳票制御汎用(帳票制御汎用Manager, 帳票制御汎用キー_帳票タイトル_抹消線あり３);
            }
        }
        item.setTitle(タイトル);
        item.setTitle2_1(タイトル2_1);
        item.setTitle2_2_1(タイトル2_2_1);
        item.setTitle2_2_2(タイトル2_2_2);
        item.setTitle2_3_1(タイトル2_3_1);
        item.setTitle2_3_2(タイトル2_3_2);
        item.setTitle2_4(タイトル2_4);
        item.setTsuchibun1(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                KamokuCode.EMPTY, ONE, ONE, batchPram.getHakkoYMD()));
        item = set通知文(item, batchPram);
        item.setRemban(RString.EMPTY);
        item = set認証者And宛先(item, ninshoshaSource, atesaki);
        item.setBangoTitle(番号タイトル_口座番号);
        RString 種別タイトル = get種別タイトル(shiharai);
        RString 増減の理由タイトル;
        if (ShikyuFushikyuKubun.不支給.getコード().equals(shiharai.get支給不支給決定区分())) {
            増減の理由タイトル = 増減の理由タイトル_不支給の理由;
        } else {
            増減の理由タイトル = 増減の理由タイトル_増減の理由;
        }
        item.setRiyuTitle(増減の理由タイトル);
        item.setShumokuTitle(種別タイトル);
        item.setBangoTitle(番号タイトル_口座番号);
        return item;
    }

    private RString get帳票制御汎用(ChohyoSeigyoHanyoManager 帳票制御汎用Manager, RString 項目名) {
        RString 設定値 = RString.EMPTY;
        ChohyoSeigyoHanyo chohyoSeigyoHanyo = 帳票制御汎用Manager.get帳票制御汎用(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                FlexibleYear.MIN, 項目名);
        if (chohyoSeigyoHanyo != null) {
            設定値 = chohyoSeigyoHanyo.get設定値();
        }
        return 設定値;
    }

    private RString get種別タイトル(ShokanKetteiTsuchiShoShiharai business) {
        if (!ShikyuFushikyuKubun.不支給.getコード().equals(business.get支給不支給決定区分())) {
            return 種別タイトル_口座種別;
        }
        RString 種別タイトル = RString.EMPTY;
        if (ShiharaiHohoKubun.窓口払.getコード().equals(business.get支払方法区分コード())) {
            種別タイトル = 種別タイトル_口座種別;
        } else if (ShiharaiHohoKubun.口座払.getコード().equals(business.get支払方法区分コード())) {
            if (金融機関コード_郵便局.equals(business.get金融機関コード().value())) {
                種別タイトル = 種別タイトル_店番;
            } else {
                種別タイトル = 種別タイトル_口座種別;
            }
        }
        return 種別タイトル;
    }

    private ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem set認証者And宛先(ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item,
            NinshoshaSource ninshoshaSource, SofubutsuAtesakiSource atesaki) {

        item.setHakkoYMD(ninshoshaSource.hakkoYMD);
        item.setDenshiKoin(ninshoshaSource.denshiKoin);
        item.setNinshoshaYakushokuMei(ninshoshaSource.ninshoshaYakushokuMei);
        item.setNinshoshaYakushokuMei1(ninshoshaSource.ninshoshaYakushokuMei1);
        item.setKoinMojiretsu(ninshoshaSource.koinMojiretsu);
        item.setNinshoshaYakushokuMei2(ninshoshaSource.ninshoshaYakushokuMei2);
        item.setNinshoshaShimeiKakenai(ninshoshaSource.ninshoshaShimeiKakenai);
        item.setNinshoshaShimeiKakeru(ninshoshaSource.ninshoshaShimeiKakeru);
        item.setKoinShoryaku(ninshoshaSource.koinShoryaku);
        item.setYubinNo(atesaki.yubinNo);
        item.setGyoseiku2(atesaki.gyoseiku);
        item.setJusho4(atesaki.jusho1);
        item.setJushoText(atesaki.jushoText);
        item.setJusho5(atesaki.jusho2);
        item.setJusho6(atesaki.jusho3);
        item.setKatagakiText(atesaki.katagakiText);
        item.setKatagaki3(atesaki.katagaki1);
        item.setKatagaki4(atesaki.katagaki2);
        item.setKatagakiSmall2(atesaki.katagakiSmall2);
        item.setKatagakiSmall1(atesaki.katagakiSmall1);
        item.setShimeiSmall2(atesaki.shimeiSmall2);
        item.setShimeiText(atesaki.shimeiText);
        item.setMeishoFuyo2(atesaki.meishoFuyo2);
        item.setShimeiSmall1(atesaki.shimeiSmall1);
        item.setDainoKubunMei(atesaki.dainoKubunMei);
        item.setShimei5(atesaki.shimei1);
        item.setShimei6(atesaki.shimei2);
        item.setMeishoFuyo1(atesaki.meishoFuyo1);
        item.setSamabunShimeiText(atesaki.samabunShimeiText);
        item.setSamaBun2(atesaki.samaBun2);
        item.setKakkoLeft2(atesaki.kakkoLeft2);
        item.setSamabunShimei2(atesaki.samabunShimei2);
        item.setSamabunShimeiSmall2(atesaki.samabunShimeiSmall2);
        item.setKakkoRight2(atesaki.kakkoRight2);
        item.setKakkoLeft1(atesaki.kakkoLeft1);
        item.setSamabunShimei1(atesaki.samabunShimei1);
        item.setSamaBun1(atesaki.samaBun1);
        item.setKakkoRight1(atesaki.kakkoRight1);
        item.setSamabunShimeiSmall1(atesaki.samabunShimeiSmall1);
        item.setCustomerBarCode(atesaki.customerBarCode);
        return item;
    }

    private RString getSortKey(ShokanKetteiTsuchiShoShiharai shiharai) {
        RStringBuilder result = new RStringBuilder();
        result.append(getJufukuKey(shiharai));
        result.append(shiharai.getサービス種類コード());
        return result.toRString();
    }

    private ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem set通知文(
            ShokanKetteiTsuchiShoShiharaiYoteiBiYijiAriItem item, ShokanKetteiTsuchiShoSealerBatchParameter batchPram) {
        RString 定型文文字サイズ = ReportUtil.get定型文文字サイズ(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId());
        if (フォント小.equals(定型文文字サイズ)) {
            item.setTsuchibun２(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                    KamokuCode.EMPTY, ONE, TWO, batchPram.getHakkoYMD()));
        } else if (フォント大.equals(定型文文字サイズ)) {
            item.setTsuchibunLarge(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                    KamokuCode.EMPTY, TWO, TWO, batchPram.getHakkoYMD()));
        } else if (フォント混在_上小下大.equals(定型文文字サイズ)) {
            item.setTsuchibunMix1(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                    KamokuCode.EMPTY, THREE, TWO, batchPram.getHakkoYMD()));
            item.setTsuchibunMix2(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                    KamokuCode.EMPTY, THREE, THREE, batchPram.getHakkoYMD()));
        } else if (フォント混在_上大下小.equals(定型文文字サイズ)) {
            item.setTsuchibunMixtwo1(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                    KamokuCode.EMPTY, FOUR, TWO, batchPram.getHakkoYMD()));
            item.setTsuchibunMixtwo2(ReportUtil.get通知文(SubGyomuCode.DBC介護給付, ReportIdDBC.DBC100002_2.getReportId(),
                    KamokuCode.EMPTY, FOUR, THREE, batchPram.getHakkoYMD()));
        }
        return item;
    }

    private RString setDataTimeFomart(RString time) {
        if (RString.isNullOrEmpty(time)) {
            return RString.EMPTY;
        }
        RStringBuilder 支払窓口終了期間Builder = new RStringBuilder();
        RTime 支払窓口終了期間 = new RTime(time);
        支払窓口終了期間Builder.append(String.format("%02d", 支払窓口終了期間.getHour()));
        支払窓口終了期間Builder.append(new RString("時"));
        支払窓口終了期間Builder.append(String.format("%02d", 支払窓口終了期間.getMinute()));
        支払窓口終了期間Builder.append(new RString("分"));
        支払窓口終了期間Builder.append(String.format("%02d", 支払窓口終了期間.getSecond()));
        支払窓口終了期間Builder.append(new RString("秒"));
        return 支払窓口終了期間Builder.toRString();
    }
}
