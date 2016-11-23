/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishoshiharaiyoteibiyijinashi;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.business.report.util.ReportKomokuEditorUtil;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.shiharaihoho.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijiari.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity;
import jp.co.ndensan.reams.db.dbc.entity.db.relate.kogakuketteitsuchishoshiharaiyoteibiyijinashi.KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource;
import jp.co.ndensan.reams.db.dbz.business.core.basic.ChohyoSeigyoKyotsu;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBCMN43002_高額サービス等支給（不支給）決定通知書のEditorクラスです。
 *
 * @reamsid_L DBC-2000-050 zhengshenlei
 */
public class KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaEditor implements IKogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaEditor {

    private final KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity 帳票情報;
    private final RString テスト印刷 = new RString("テスト印刷");
    private static final int INDEX_ZERO = 0;
    private static final int INDEX_ONE = 1;
    private static final int INDEX_TWO = 2;
    private static final int INDEX_THREE = 3;
    private static final int INDEX_FOUR = 4;
    private static final int INDEX_FIVE = 5;
    private static final int INDEX_SIX = 6;
    private static final int INDEX_SEVEN = 7;
    private static final int INDEX_EIGHT = 8;
    private static final int INDEX_NINE = 9;
    private static final int INDEX_TEN = 10;
    private static final int INDEX_ELEVEN = 11;
    private static final int INDEX_TWELVE = 12;
    private final int 連番;
    private final List<RString> 通知書定型文List;
    private static final RString 増減の理由 = new RString("増減の理由");
    private static final RString 不支給の理由 = new RString("不支給の理由");
    private static final RString 支給 = new RString("1");
    private static final RString 不支給 = new RString("2");
    private static final RString 窓口払い = new RString("1");
    private static final RString 半角アスタリスク = new RString("************");
    private static final RString 半角アスタリスク2 = new RString("**************");
    private static final RString 口座種別 = new RString("口座種別");
    private static final RString 店番 = new RString("店番");
    private static final RString 口座番号 = new RString("口座番号");
    private static final RString 改行 = new RString("\n");
    private final NinshoshaSource 認証者ソースデータ;
    private final ChohyoSeigyoKyotsu 帳票制御共通情報;
    private final List<RString> titleList;
    private final RString 記号 = new RString("～");
    private static final RString SIZE_TWO = new RString("2");
    private static final RString SIZE_THREE = new RString("3");
    private static final RString SIZE_FOUR = new RString("4");
    private static final RString 窓口払い区分 = new RString("1");
    private static final RString 口座払い区分 = new RString("2");
    private static final RString コード_9900 = new RString("9900");
    private final RString 金融機関コード;
    private static final RString 支給金額 = new RString("支給金額");
    private static final RString 決定額 = new RString("決定額");

    /**
     * コンストラクタです。
     *
     * @param 帳票情報 KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity
     * @param 連番 int
     * @param titleList List<RString>
     * @param 通知書定型文List List<RString>
     * @param 認証者ソースデータ NinshoshaSource
     * @param 帳票制御共通情報 ChohyoSeigyoKyotsu
     * @param 金融機関コード RString
     */
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNaEditor(
            KogakuKetteiTsuchiShoShiharaiYoteiBiYijiAriEntity 帳票情報,
            int 連番,
            List<RString> titleList,
            List<RString> 通知書定型文List,
            NinshoshaSource 認証者ソースデータ,
            ChohyoSeigyoKyotsu 帳票制御共通情報,
            RString 金融機関コード) {
        this.帳票情報 = 帳票情報;
        this.連番 = 連番;
        this.titleList = titleList;
        this.通知書定型文List = 通知書定型文List;
        this.認証者ソースデータ = 認証者ソースデータ;
        this.帳票制御共通情報 = 帳票制御共通情報;
        this.金融機関コード = 金融機関コード;
    }

    @Override
    public KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource edit(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        if (帳票情報.get識別コード() != null) {
            source.shikibetsuCode = 帳票情報.get識別コード().value();
        }
        source.bunshoNo = 帳票情報.get文書番号();
        if (帳票情報.isテスト出力フラグ()) {
            source.testPrint = テスト印刷;
        } else {
            source.testPrint = RString.EMPTY;
        }
        source.renban = new RString(連番);
        setタイトル(source);

        if (通知書定型文List.size() > INDEX_ONE) {
            source.tsuchibun1 = 通知書定型文List.get(INDEX_ONE);
        } else {
            source.tsuchibun1 = RString.EMPTY;
            source.tsuchibun2 = RString.EMPTY;
        }
        source.hihokenshaName = 帳票情報.get被保険者氏名();

        if (帳票情報.get被保険者番号() != null) {
            List<RString> 被保険者番号List = new ArrayList<>();
            RString 保険者番号 = 帳票情報.get被保険者番号().value();
            source.hihokenshaNo = 保険者番号;
            for (int i = 0; i < 保険者番号.length(); i++) {
                被保険者番号List.add(保険者番号.substring(i, i + 1));
            }
            source.hihokenshaNo1 = set被保険者番号(被保険者番号List, INDEX_ZERO);
            source.hihokenshaNo2 = set被保険者番号(被保険者番号List, INDEX_ONE);
            source.hihokenshaNo3 = set被保険者番号(被保険者番号List, INDEX_TWO);
            source.hihokenshaNo4 = set被保険者番号(被保険者番号List, INDEX_THREE);
            source.hihokenshaNo5 = set被保険者番号(被保険者番号List, INDEX_FOUR);
            source.hihokenshaNo6 = set被保険者番号(被保険者番号List, INDEX_FIVE);
            source.hihokenshaNo7 = set被保険者番号(被保険者番号List, INDEX_SIX);
            source.hihokenshaNo8 = set被保険者番号(被保険者番号List, INDEX_SEVEN);
            source.hihokenshaNo9 = set被保険者番号(被保険者番号List, INDEX_EIGHT);
            source.hihokenshaNo10 = set被保険者番号(被保険者番号List, INDEX_NINE);
        }

        source.uketsukeYMD = 年月日編集(帳票情報.get受付年月日());
        source.ketteiYMD = 年月日編集(帳票情報.get決定年月日());
        source.honninShiharaiGaku = doカンマ編集(帳票情報.get本人支払額());
        source.taishoYM = 年月編集(帳票情報.get対象年月());
        source.kyufuShurui = 帳票情報.get給付の種類();
        if (帳票情報.get支給_不支給決定区分() != null) {
            source.kekka = ShikyuKubun.toValue(帳票情報.get支給_不支給決定区分()).get名称();
        }
        if (帳票情報.get支給金額() != null) {
            if (Decimal.ZERO.compareTo(帳票情報.get支給金額()) <= 0) {
                source.ketteiGaku = 支給金額;
            } else {
                source.ketteiGaku = 決定額;
            }
            source.shikyuGaku = doカンマ編集(帳票情報.get支給金額());
            if (帳票情報.get支給_不支給決定区分() != null && 支給.equals(帳票情報.get支給_不支給決定区分())) {
                source.riyuTitle = 増減の理由;
            } else if (不支給.equals(帳票情報.get支給_不支給決定区分())) {
                source.riyuTitle = 不支給の理由;
            }
        }
        source.riyu = 帳票情報.get不支給理由();

        set窓口払口座払取り消し持ちもの(source);
        set種別And種別タイトル(source);
        if (支給.equals(帳票情報.get支給_不支給決定区分()) && !窓口払い区分.equals(帳票情報.get支払方法区分())
                && Decimal.ZERO.compareTo(帳票情報.get支給金額()) < 0) {
            source.kouzaShu = 帳票情報.get口座種別();
            source.kouzaNo = 帳票情報.get口座番号();
            source.kouzaMeigi = 帳票情報.get口座名義人();
        }

        source.tsuchino = 帳票情報.get決定通知書番号();
        source.tsuban = new RString(連番);
        set通知文２(source);
        set通知文Large(source);
        set通知文上段Small(source);
        set通知文下段Large(source);
        set通知文上段Small_2(source);
        set通知文下段Large_2(source);
        set雛形部品CompNinshosha(source);
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"),
                ReportKomokuEditorUtil.get非空文字列(source.hihokenshaNo));
        return source;
    }

    private void set種別And種別タイトル(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {

        if (支給.equals(帳票情報.get支給_不支給決定区分()) && !窓口払い区分.equals(帳票情報.get支払方法区分())
                && Decimal.ZERO.compareTo(帳票情報.get支給金額()) < 0) {
            source.bankName = 帳票情報.get金融機関上段();
            source.branchBankName = 帳票情報.get金融機関下段();
        } else {
            source.bankName = RString.EMPTY;
            source.branchBankName = RString.EMPTY;
        }

        source.shumokuTitle = 口座種別;
        source.bangoTitle = 口座番号;
        if (支給.equals(帳票情報.get支給_不支給決定区分()) && Decimal.ZERO.compareTo(帳票情報.get支給金額()) < 0
                && 口座払い区分.equals(帳票情報.get支払方法区分()) && コード_9900.equals(金融機関コード)) {
            source.shumokuTitle = 店番;
        }
    }

    private RString set被保険者番号(List<RString> 被保険者番号List, int index) {
        return index < 被保険者番号List.size() ? 被保険者番号List.get(index) : RString.EMPTY;
    }

    private RString getTitle(List<RString> titleList, int index) {
        return index < titleList.size() ? titleList.get(index) : RString.EMPTY;
    }

    private void setタイトル(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.title = getTitle(titleList, INDEX_ZERO);
        source.title2_1 = getTitle(titleList, INDEX_ONE);
        source.title2_2_1 = getTitle(titleList, INDEX_TWO);
        source.title2_2_2 = getTitle(titleList, INDEX_THREE);
        source.title2_3_1 = getTitle(titleList, INDEX_FOUR);
        source.title2_3_2 = getTitle(titleList, INDEX_FIVE);
        source.title2_4 = getTitle(titleList, INDEX_SIX);
        source.title3_1 = getTitle(titleList, INDEX_SEVEN);
        source.title3_2_1 = getTitle(titleList, INDEX_EIGHT);
        source.title3_2_2 = getTitle(titleList, INDEX_NINE);
        source.title3_3_1 = getTitle(titleList, INDEX_TEN);
        source.title3_3_2 = getTitle(titleList, INDEX_ELEVEN);
        source.title3_4 = getTitle(titleList, INDEX_TWELVE);
    }

    private void set通知文２(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibun2 = get通知書定型文(INDEX_TWO);
    }

    private void set通知文Large(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunLarge = get通知書定型文2(INDEX_TWO, SIZE_TWO);
    }

    private void set通知文上段Small(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunMix1 = get通知書定型文2(INDEX_TWO, SIZE_THREE);
    }

    private void set通知文下段Large(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunMix2 = get通知書定型文2(INDEX_THREE, SIZE_THREE);
    }

    private void set通知文上段Small_2(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunMixTwo1 = get通知書定型文2(INDEX_TWO, SIZE_FOUR);
    }

    private void set通知文下段Large_2(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        source.tsuchibunMixTwo2 = get通知書定型文2(INDEX_THREE, SIZE_FOUR);
    }

    private RString get通知書定型文(int index) {
        return index < 通知書定型文List.size() ? 通知書定型文List.get(index) : RString.EMPTY;
    }

    private RString get通知書定型文2(int index, RString size) {
        if (size.equals(帳票制御共通情報.get定型文文字サイズ())) {
            return index < 通知書定型文List.size() ? 通知書定型文List.get(index) : RString.EMPTY;
        } else {
            return RString.EMPTY;
        }
    }

    private void set雛形部品CompNinshosha(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        if (認証者ソースデータ != null) {
            source.denshiKoin = 認証者ソースデータ.denshiKoin;
            source.hakkoYMD = 認証者ソースデータ.hakkoYMD;
            source.ninshoshaYakushokuMei = 認証者ソースデータ.ninshoshaYakushokuMei;
            source.ninshoshaYakushokuMei1 = 認証者ソースデータ.ninshoshaYakushokuMei1;
            source.koinMojiretsu = 認証者ソースデータ.koinMojiretsu;
            source.ninshoshaYakushokuMei2 = 認証者ソースデータ.ninshoshaYakushokuMei2;
            source.ninshoshaShimeiKakenai = 認証者ソースデータ.ninshoshaShimeiKakenai;
            source.ninshoshaShimeiKakeru = 認証者ソースデータ.ninshoshaShimeiKakeru;
            source.koinShoryaku = 認証者ソースデータ.koinShoryaku;
        }
    }

    private RString 年月日編集(RDate 日付) {
        if (日付 == null) {
            return RString.EMPTY;
        }
        return 日付.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString 年月編集(FlexibleYearMonth 日付) {
        if (日付 == null) {
            return RString.EMPTY;
        }
        return 日付.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private RString get日本語名略称(RDate 日付) {
        if (日付 == null) {
            return RString.EMPTY;
        }
        return new RString(日付.getDayOfWeek().getInFullParentheses());
    }

    private void set窓口払口座払取り消し持ちもの(KogakuKetteiTsuchiShoShiharaiYoteiBiYijiNashiSource source) {
        if (ShiharaiHohoKubun.窓口払 != null && 帳票情報.get支払方法区分() != null) {
            if (ShiharaiHohoKubun.窓口払.getコード().equals(帳票情報.get支払方法区分()) && Decimal.ZERO.compareTo(帳票情報.get支給金額()) < 0) {
                source.torikeshi1 = RString.EMPTY;
            } else {
                source.torikeshi1 = 半角アスタリスク2;
            }
        }
        if (ShiharaiHohoKubun.口座払 != null && 帳票情報.get支払方法区分() != null) {
            if (帳票情報.get支給金額() != null
                    && ShiharaiHohoKubun.口座払.getコード().equals(帳票情報.get支払方法区分()) && Decimal.ZERO.compareTo(帳票情報.get支給金額()) < 0) {
                source.torikeshi2 = RString.EMPTY;
            } else {
                source.torikeshi2 = 半角アスタリスク2;
            }
        }
        if (!(帳票情報.get支給_不支給決定区分() != null && 支給.equals(帳票情報.get支給_不支給決定区分())
                && Decimal.ZERO.compareTo(帳票情報.get支給金額()) < 0)) {
            source.torikeshiMochimono1 = 半角アスタリスク;
            source.torikeshiMochimono2 = 半角アスタリスク;
            source.torikeshiShiharaibasho = 半角アスタリスク;
            source.torikeshiShiharaikikan = 半角アスタリスク;
        }
        if (帳票情報.get支給_不支給決定区分() != null && 支給.equals(帳票情報.get支給_不支給決定区分())
                && 窓口払い区分.equals(帳票情報.get支払方法区分())
                && Decimal.ZERO.compareTo(帳票情報.get支給金額()) < 0) {
            source.mochimono = 帳票情報.getお持ちいただくもの１().
                    concat(改行).concat(帳票情報.getお持ちいただくもの２()).
                    concat(改行).concat(帳票情報.getお持ちいただくもの３());
            source.shiharaiBasho = 帳票情報.get支払場所();
            source.shiharaiStartYMD = 年月日編集(帳票情報.get支払期間開始年月日()).
                    concat(get日本語名略称(帳票情報.get支払期間開始年月日())).concat(記号);
            source.karaFugo = 記号;
            source.shiharaiEndYMD = 年月日編集(帳票情報.get支払期間終了年月日())
                    .concat(get日本語名略称(帳票情報.get支払期間終了年月日()));
            source.shiharaiStartHMS = 帳票情報.get支払窓口開始時間();
            source.shiharaiEndHMS = 帳票情報.get支払窓口終了時間();
        } else {
            source.mochimono = RString.EMPTY;
            source.shiharaiBasho = RString.EMPTY;
            source.shiharaiStartYMD = RString.EMPTY;
            source.karaFugo = RString.EMPTY;
            source.shiharaiEndYMD = RString.EMPTY;
            source.shiharaiStartHMS = RString.EMPTY;
            source.shiharaiEndHMS = RString.EMPTY;
        }
    }
}
