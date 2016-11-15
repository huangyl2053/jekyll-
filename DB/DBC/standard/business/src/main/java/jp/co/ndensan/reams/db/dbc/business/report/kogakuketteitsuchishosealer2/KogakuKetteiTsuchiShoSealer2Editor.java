/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuketteitsuchishosealer2;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.jigyobunkogakugassanshikyukettei.ShiharaiHohoKubun;
import jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice.ShikyuKubun;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer21.KogakuKetteiTsuchiShoSealer2Source;
import jp.co.ndensan.reams.db.dbc.entity.report.kogakuketteitsuchishosealer2.KogakuKetteiTsuchiShoEntity;
import jp.co.ndensan.reams.ur.urz.entity.report.parts.ninshosha.NinshoshaSource;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.EraType;
import jp.co.ndensan.reams.uz.uza.lang.FillType;
import jp.co.ndensan.reams.uz.uza.lang.FirstYear;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleYearMonth;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RTime;
import jp.co.ndensan.reams.uz.uza.lang.Separator;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.math.Decimal;
import jp.co.ndensan.reams.uz.uza.ui.binding.propertyenum.DisplayTimeFormat;
import jp.co.ndensan.reams.uz.uza.util.editor.DecimalFormatter;

/**
 * 帳票設計_DBCMN43002_高額介護（予防）サービス費支給（不支給）決定通知書（ｼｰﾗﾀｲﾌﾟ2）Editorするクラスです。
 *
 * @reamsid_L DBC-2000-070 lijian
 */
public class KogakuKetteiTsuchiShoSealer2Editor implements IKogakuKetteiTsuchiShoSealer2Editor {

    private final List<RString> titleList;
    private final KogakuKetteiTsuchiShoEntity 帳票情報;
    private final NinshoshaSource 認証者ソースデータ;
    private final RString 文書番号;
    private final int 連番;
    private static final RString テスト印刷 = new RString("テスト印刷");
    private static final RString 支給 = new RString("1");
    private static final RString 不支給 = new RString("2");
    private static final RString 増減の理由 = new RString("増減の理由");
    private static final RString 不支給の理由 = new RString("不支給の理由");
    private static final RString 窓口払い値 = new RString("1");
    private static final RString 口座払い値 = new RString("2");
    private static final RString 金融機関コード = new RString("9900");
    private static final RString 半角アスタリスク = new RString("************");
    private static final RString 半角アスタリスク2 = new RString("**************");
    private static final RString 口座種別 = new RString("口座種別");
    private static final RString 通帳記号 = new RString("通帳記号");
    private static final RString 口座番号 = new RString("口座番号");
    private static final RString 通帳番号 = new RString("通帳番号");
    private static final RString 対象 = new RString("A");
    private static final RString 対象外 = new RString("B");
    private static final RString 接続文字 = new RString("～");
    private static final RString 支払方法区分コードONE = new RString("1");
    private static final RString 支払方法区分コードTWO = new RString("2");
    private static final RString 支払方法区分ONE = new RString("1");
    private static final RString 支給金額 = new RString("支給金額");
    private static final RString 決定額 = new RString("決定額");
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

    /**
     * コンストラクタです。
     *
     * @param titleList List<RString>
     * @param 帳票情報 KogakuKetteiTsuchiShoEntity
     * @param 認証者ソースデータ NinshoshaSource
     * @param 文書番号 RString
     * @param 連番 int
     */
    public KogakuKetteiTsuchiShoSealer2Editor(
            List<RString> titleList,
            KogakuKetteiTsuchiShoEntity 帳票情報,
            NinshoshaSource 認証者ソースデータ,
            RString 文書番号,
            int 連番) {

        this.titleList = titleList;
        this.帳票情報 = 帳票情報;
        this.認証者ソースデータ = 認証者ソースデータ;
        this.文書番号 = 文書番号;
        this.連番 = 連番;
    }

    @Override
    public KogakuKetteiTsuchiShoSealer2Source edit(KogakuKetteiTsuchiShoSealer2Source source) {
        if (帳票情報.get識別コード() != null) {
            source.shikibetsuCode = 帳票情報.get識別コード().value();
        }
        source.bunshoNo = 文書番号;
        source.tsuban = new RString(連番);

        if (帳票情報.isテスト出力フラグ()) {
            source.testPrint = テスト印刷;
        } else {
            source.testPrint = RString.EMPTY;
        }
        setValueFrom帳票情報(source);
        setタイトル(source);
        set雛形部品CompNinshosha(source);
        source.拡張情報 = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), get非空文字列(source.hihokenshaNo));
        return source;
    }

    private void setValueFrom帳票情報(KogakuKetteiTsuchiShoSealer2Source source) {
        source.hihokenshaName = 帳票情報.get被保険者氏名();

        source.uketsukeYMD = 年月日編集(帳票情報.get受付年月日());
        source.ketteiYMD = 年月日編集(帳票情報.get決定年月日());
        source.shiharaiGaku = doカンマ編集(帳票情報.get本人支払額());
        source.taishoYM = 年月編集(帳票情報.get対象年月());
        source.kyufuShurui = 帳票情報.get給付の種類();

        if (帳票情報.get支給不支給決定区分() != null) {
            source.kekka = ShikyuKubun.toValue(帳票情報.get支給不支給決定区分()).get名称();
        }

        if (帳票情報.get支給金額() != null && 0 <= 帳票情報.get支給金額().compareTo(Decimal.ZERO)) {
            source.ketteiGaku = 支給金額;
        } else {
            source.ketteiGaku = 決定額;
        }

        source.shikyuGaku = doカンマ編集(帳票情報.get支給金額());

        if (支給.equals(帳票情報.get支給不支給決定区分())) {
            source.riyuTitle = 増減の理由;
        } else if (不支給.equals(帳票情報.get支給不支給決定区分())) {
            source.riyuTitle = 不支給の理由;
        }

        source.riyu = 帳票情報.get不支給理由();

        set窓口払と口座払(source);

        if (!(支給.equals(帳票情報.get支給不支給決定区分()) && 窓口払い値.equals(帳票情報.get支払方法区分())
                && 帳票情報.get支給金額() != null && (Decimal.ZERO.compareTo(帳票情報.get支給金額())) < 0)) {
            source.torikeshiMochimono1 = 半角アスタリスク;
            source.torikeshiMochimono2 = 半角アスタリスク;
            source.torikeshiShiharaibasho = 半角アスタリスク;
            source.torikeshiShiharaikikan = 半角アスタリスク;
        }

        set持ちものと支払場所と期間(source);
        set金融機関(source);
        setTitle(source);
        set種別と番号と口座名義(source);

        if (帳票情報.get証記載保険者番号() != null) {
            source.shokisaiHokenshaNo = 帳票情報.get証記載保険者番号().value();
        }
        if (帳票情報.get被保険者番号() != null) {
            source.hihokenshaNo = 帳票情報.get被保険者番号().value();
        }
        if (帳票情報.get提供年月() != null) {
            source.serviceYM = 帳票情報.get提供年月().toDateString();
        }

        if (帳票情報.is自動償還対象フラグ()) {
            source.jidoshokanfg = 対象;
        } else {
            source.jidoshokanfg = 対象外;
        }

        if (帳票情報.get被保険者番号() != null) {
            List<RString> 被保険者番号List = new ArrayList<>();
            RString 保険者番号 = 帳票情報.get被保険者番号().value();

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
    }

    private void set種別と番号と口座名義(KogakuKetteiTsuchiShoSealer2Source source) {

        if (支給.equals(帳票情報.get支給不支給決定区分()) && !窓口払い値.equals(帳票情報.get支払方法区分())
                && 帳票情報.get支給金額() != null && 0 < 帳票情報.get支給金額().compareTo(Decimal.ZERO)) {

            source.kouzaMeigi = 帳票情報.get口座名義人();

            if (!帳票情報.isゆうちょ銀行フラグ()) {
                source.kouzaShu = 帳票情報.get口座種別();
                source.kouzaNo = 帳票情報.get口座番号();
            } else {
                source.kouzaShu = 帳票情報.get通帳記号();
                source.kouzaNo = 帳票情報.get通帳番号();
            }
        }

    }

    private void set金融機関(KogakuKetteiTsuchiShoSealer2Source source) {
        if (支給.equals(帳票情報.get支給不支給決定区分()) && !支払方法区分ONE.equals(帳票情報.get支払方法区分())
                && 帳票情報.get支給金額() != null && 0 < 帳票情報.get支給金額().compareTo(Decimal.ZERO)) {
            source.bankName = 帳票情報.get金融機関上段();
            source.branchBankName = 帳票情報.get金融機関下段();
        }
    }

    private void setTitle(KogakuKetteiTsuchiShoSealer2Source source) {
        if (支給.equals(帳票情報.get支給不支給決定区分())) {
            if (窓口払い値.equals(帳票情報.get支払方法区分())
                    && 帳票情報.get支給金額() != null && 0 < 帳票情報.get支給金額().compareTo(Decimal.ZERO)) {
                source.shumokuTitle = 口座種別;
                source.bangoTitle = 口座番号;
            } else if (口座払い値.equals(帳票情報.get支払方法区分()) && 金融機関コード.equals(帳票情報.get金融機関コード())
                    && 帳票情報.get支給金額() != null && 0 < 帳票情報.get支給金額().compareTo(Decimal.ZERO)) {
                source.shumokuTitle = 通帳記号;
                source.bangoTitle = 通帳番号;
            } else if (口座払い値.equals(帳票情報.get支払方法区分()) && !金融機関コード.equals(帳票情報.get金融機関コード())
                    && 帳票情報.get支給金額() != null && 0 < 帳票情報.get支給金額().compareTo(Decimal.ZERO)) {
                source.shumokuTitle = 口座種別;
                source.bangoTitle = 口座番号;
            }
        }

        if (支給.equals(帳票情報.get支給不支給決定区分()) && 帳票情報.get支給金額() != null && 帳票情報.get支給金額().compareTo(Decimal.ZERO) < 0
                || 不支給.equals(帳票情報.get支給不支給決定区分())) {
            source.shumokuTitle = 口座種別;
            source.bangoTitle = 口座番号;
        }
    }

    private void set持ちものと支払場所と期間(KogakuKetteiTsuchiShoSealer2Source source) {
        if (支給.equals(帳票情報.get支給不支給決定区分()) && 支払方法区分ONE.equals(帳票情報.get支払方法区分())
                && 帳票情報.get支給金額() != null && 0 < 帳票情報.get支給金額().compareTo(Decimal.ZERO)) {
            source.mochimono = 帳票情報.get持ちもの();
            source.shiharaiBasho = 帳票情報.get支払場所();
            RString 開始週間 = 週間編集(帳票情報.get支払期間開始年月日());
            RString 終了週間 = 週間編集(帳票情報.get支払期間終了年月日());
            source.shiharaiStartYMD = 年月日編集(帳票情報.get支払期間開始年月日()).concat(開始週間).concat(接続文字);
            source.karaFugo = 接続文字;
            source.shiharaiEndYMD = 年月日編集(帳票情報.get支払期間終了年月日()).concat(終了週間);
            if (帳票情報.get支払窓口開始時間() != null) {
                source.shiharaiStartHMS = new RTime(帳票情報.get支払窓口開始時間()).toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            }
            if (帳票情報.get支払窓口終了時間() != null) {
                source.shiharaiEndHMS = new RTime(帳票情報.get支払窓口終了時間()).toFormattedTimeString(DisplayTimeFormat.HH時mm分ss秒);
            }
        }
    }

    private void set窓口払と口座払(KogakuKetteiTsuchiShoSealer2Source source) {

        if (帳票情報.get支払方法区分() != null) {

            if (支払方法区分コードONE.equals(ShiharaiHohoKubun.toValue(帳票情報.get支払方法区分()).getコード())
                    && 帳票情報.get支給金額() != null && 0 < 帳票情報.get支給金額().compareTo(Decimal.ZERO)) {
                source.torikeshi1 = RString.EMPTY;
            } else {
                source.torikeshi1 = 半角アスタリスク2;
            }
            if (支払方法区分コードTWO.equals(ShiharaiHohoKubun.toValue(帳票情報.get支払方法区分()).getコード())
                    && 帳票情報.get支給金額() != null && 0 < 帳票情報.get支給金額().compareTo(Decimal.ZERO)) {
                source.torikeshi2 = RString.EMPTY;
            } else {
                source.torikeshi2 = 半角アスタリスク2;
            }
        }

    }

    private RString 年月日編集(FlexibleDate 年月日) {
        if (年月日 != null) {
            return 年月日.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString 週間編集(FlexibleDate 年月日) {
        if (年月日 != null) {
            return new RString(年月日.getDayOfWeek().getInFullParentheses());
        }
        return RString.EMPTY;
    }

    private RString 年月編集(FlexibleYearMonth 年月) {
        if (年月 != null) {
            return 年月.wareki().eraType(EraType.KANJI).firstYear(FirstYear.GAN_NEN)
                    .separator(Separator.JAPANESE).fillType(FillType.BLANK).toDateString();
        }
        return RString.EMPTY;
    }

    private RString doカンマ編集(Decimal decimal) {
        if (null != decimal) {
            return DecimalFormatter.toコンマ区切りRString(decimal, 0);
        }
        return RString.EMPTY;
    }

    private RString set被保険者番号(List<RString> 被保険者番号List, int index) {
        return index < 被保険者番号List.size() ? 被保険者番号List.get(index) : RString.EMPTY;
    }

    private RString fetchTitle(List<RString> titleList, int index) {
        return index < titleList.size() ? titleList.get(index) : RString.EMPTY;
    }

    private void setタイトル(KogakuKetteiTsuchiShoSealer2Source source) {
        source.title = fetchTitle(titleList, INDEX_ZERO);
        source.title2_1 = fetchTitle(titleList, INDEX_ONE);
        source.title2_2_1 = fetchTitle(titleList, INDEX_TWO);
        source.title2_2_2 = fetchTitle(titleList, INDEX_THREE);
        source.title2_3_1 = fetchTitle(titleList, INDEX_FOUR);
        source.title2_3_2 = fetchTitle(titleList, INDEX_FIVE);
        source.title2_4 = fetchTitle(titleList, INDEX_SIX);
        source.title3_1 = fetchTitle(titleList, INDEX_SEVEN);
        source.title3_2_1 = fetchTitle(titleList, INDEX_EIGHT);
        source.title3_2_2 = fetchTitle(titleList, INDEX_NINE);
        source.title3_3_1 = fetchTitle(titleList, INDEX_TEN);
        source.title3_3_2 = fetchTitle(titleList, INDEX_ELEVEN);
        source.title3_4 = fetchTitle(titleList, INDEX_TWELVE);

    }

    private void set雛形部品CompNinshosha(KogakuKetteiTsuchiShoSealer2Source source) {
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

    private RString get非空文字列(RString 文字列) {
        if (RString.isNullOrEmpty(文字列)) {
            return RString.EMPTY;
        }
        return 文字列;
    }

}
