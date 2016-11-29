package jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 利用状況統計表_編集仕様を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 sunhaidi
 */
public enum RiyojokyoTokeihyo_EditPattern {

    /**
     * コード:01 名称:介護予防_訪問介護 略称:定義なし
     */
    介護予防_訪問介護("01", "介護予防_訪問介護",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, true, true, false, false, true, false, true, get利用実人員(), get回数(), get単位数(), get費用総額(),
            get介護給付費(), "", get社福軽減額()),
    /**
     * コード:02 名称:介護予防_訪問入浴介護 略称:定義なし
     */
    介護予防_訪問入浴介護("02", "介護予防_訪問入浴介護",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, true, false, false, true, false, false, get利用実人員(), get回数(), get単位数(), get費用総額(),
            get介護給付費(), "", ""),
    /**
     * コード:03 名称:介護予防_訪問看護 略称:定義なし
     */
    介護予防_訪問看護("03", "介護予防_訪問看護",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, true, false, false, true, false, false, get利用実人員(), get回数(), get単位数(), get費用総額(),
            get介護給付費(), "", ""),
    /**
     * コード:04 名称:介護予防_訪問リハビリ 略称:定義なし
     */
    介護予防_訪問リハビリ("04", "介護予防_訪問リハビリ",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, true, false, false, true, false, false, get利用実人員(), get回数(), get単位数(), get費用総額(),
            get介護給付費(), "", ""),
    /**
     * コード:05 名称:介護予防_通所介護 略称:定義なし
     */
    介護予防_通所介護("05", "介護予防_通所介護",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, true, true, false, false, true, false, true, get利用実人員(), get回数(), get単位数(), get費用総額(),
            get介護給付費(), "", get社福軽減額()),
    /**
     * コード:06 名称:介護予防_通所リハビリ 略称:定義なし
     */
    介護予防_通所リハビリ("06", "介護予防_通所リハビリ",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, true, false, false, true, false, false, get利用実人員(), get回数(), " 単位数", get費用総額(),
            get介護給付費(), "", ""),
    /**
     * コード:07 名称:介護予防_福祉用具貸与 略称:定義なし
     */
    介護予防_福祉用具貸与("07", "介護予防_福祉用具貸与",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, true, false, false, true, false, false, get利用実人員(), "件数", get単位数(), get費用総額(),
            get介護給付費(), "", ""),
    /**
     * コード:08 名称:介護予防_短期入所生活介護 略称:定義なし
     */
    介護予防_短期入所生活介護("08", "介護予防_短期入所生活介護",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, true, true, true, false, false, true, true, true, get利用実人員(), "日数", get単位数(), get費用総額(),
            get介護給付費(), get特定入所費(), get社福軽減額()),
    /**
     * コード:09 名称:介護予防_短期入所老健施設 略称:定義なし
     */
    介護予防_短期入所老健施設("09", "介護予防_短期入所老健施設",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, true, false, true, false, false, true, true, false, get利用実人員(), "日数", get単位数(), get費用総額(),
            get介護給付費(), get特定入所費(), ""),
    /**
     * コード:10 名称:介護予防_短期入所医療施設 略称:定義なし
     */
    介護予防_短期入所医療施設("10", "介護予防_短期入所医療施設",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, true, false, true, false, false, true, true, false, get利用実人員(), "日数", get単位数(), get費用総額(),
            get介護給付費(), get特定入所費(), ""),
    /**
     * コード:11 名称:介護予防_居宅療養管理指導 略称:定義なし
     */
    介護予防_居宅療養管理指導("11", "介護予防_居宅療養管理指導",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, true, false, false, true, false, false, get利用実人員(), get回数(), get単位数(), get費用総額(),
            get介護給付費(), "", ""),
    /**
     * コード:12 名称:介護予防_特定施設生活介護_短期以外 略称:定義なし
     */
    介護予防_特定施設生活介護_短期以外("12", "介護予防_特定施設生活介護_短期以外",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, true, false, false, true, false, false, get利用実人員(), get日数外泊(), "単位数 ", get費用総額(),
            get介護給付費(), "", ""),
    /**
     * コード:13 名称:介護予防_特定施設生活介護_短期 略称:定義なし
     */
    介護予防_特定施設生活介護_短期("13", "介護予防_特定施設生活介護_短期",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, true, false, false, true, false, false, get利用実人員(), get日数外泊(), get単位数(),
            get費用総額(), get介護給付費(), "", ""),
    /**
     * コード:14 名称:居宅サービス計 略称:定義なし
     */
    居宅サービス計("14", "居宅サービス計", RiyojokyoTokeihyo_KaisuShukeiPattern.加算対象外,
            false, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.加算対象外,
            false, false, false, false, false, false, false, false, false, get利用実人員(), "", get単位数(),
            get費用総額(), get介護給付費(), get特定入所費(), get社福軽減額()),
    /**
     * コード:15 名称:介護福祉施設 略称:定義なし
     */
    介護福祉施設("15", "介護福祉施設",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, true, true, false, true, false, true, true, true, get利用実人員(), get日数外泊(), get単位数(),
            get費用総額(), get介護給付費(), get特定入所費(), get社福軽減額()),
    /**
     * コード:16 名称:介護老健施設 略称:定義なし
     */
    介護老健施設("16", "介護老健施設",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, true, false, false, true, false, true, true, false, get利用実人員(), get日数外泊(), get単位数(),
            get費用総額(), get介護給付費(), get特定入所費(), ""),
    /**
     * コード:17 名称:介護医療施設 略称:定義なし
     */
    介護医療施設("17", "介護医療施設",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, true, false, false, true, false, true, true, false, get利用実人員(), get日数外泊(), get単位数(),
            get費用総額(), get介護給付費(), get特定入所費(), ""),
    /**
     * コード:18 名称:施設サービス計 略称:定義なし
     */
    施設サービス計("18", "施設サービス計",
            RiyojokyoTokeihyo_KaisuShukeiPattern.加算対象外,
            false, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.加算対象外,
            false, false, false, false, false, false, false, false, false, get利用実人員(), get日数外泊(), get単位数(), get費用総額(),
            get介護給付費(), get特定入所費(), get社福軽減額()),
    /**
     * コード:19 名称:夜間対応型訪問介護 略称:定義なし
     */
    夜間対応型訪問介護("19", "夜間対応型訪問介護",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算なし,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, true, false, false, true, true, false, true, get利用実人員(), get回数(), get単位数(),
            get費用総額(), get介護給付費(), "", get社福軽減額()),
    /**
     * コード:20 名称:介護予防_認知症対応型通所介護 略称:定義なし
     */
    介護予防_認知症対応型通所介護("20", "介護予防_認知症対応型通所介護",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算なし,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, true, false, false, true, true, false, true, get利用実人員(), get回数(), get単位数(),
            get費用総額(), get介護給付費(), "", get社福軽減額()),
    /**
     * コード:21 名称:介護予防_小規模多機能型居宅介護_短期以外 略称:定義なし
     */
    介護予防_小規模多機能型居宅介護_短期以外("21", "介護予防_小規模多機能型居宅介護_短期以外",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算なし,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, true, false, false, true, true, false, true, get利用実人員(), get回数(), get単位数(),
            get費用総額(), get介護給付費(), "", get社福軽減額()),
    /**
     * コード:22 名称:介護予防_小規模多機能型居宅介護_短期 略称:定義なし
     */
    介護予防_小規模多機能型居宅介護_短期("22", "介護予防_小規模多機能型居宅介護_短期",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, true, false, false, true, true, false, true, get利用実人員(), get回数(), get単位数(),
            get費用総額(), get介護給付費(), "", get社福軽減額()),
    /**
     * コード:23 名称:介護予防_認知症対応型共同生活 略称:定義なし
     */
    介護予防_認知症対応型共同生活("23", "介護予防_認知症対応型共同生活",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算なし,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, false, false, true, true, false, false, get利用実人員(), get日数外泊(), get単位数(),
            get費用総額(), get介護給付費(), "", ""),
    /**
     * コード:24 名称:地域密着型特定施設入居者生活_短期以外 略称:定義なし
     */
    地域密着型特定施設入居者生活_短期以外("24", "地域密着型特定施設入居者生活_短期以外",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算なし,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, false, false, true, true, false, false, get利用実人員(), get日数外泊(), get単位数(),
            get費用総額(), get介護給付費(), "", ""),
    /**
     * コード:25 名称:地域密着型特定施設入居者生活_短期 略称:定義なし
     */
    地域密着型特定施設入居者生活_短期("25", "地域密着型特定施設入居者生活_短期",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算なし,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, false, false, true, true, false, false, get利用実人員(), get日数外泊(), get単位数(),
            get費用総額(), get介護給付費(), "", ""),
    /**
     * コード:26 名称:介護予防_認知症対応型共同生活_短期 略称:定義なし
     */
    介護予防_認知症対応型共同生活_短期("26", "介護予防_認知症対応型共同生活_短期",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算なし,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, false, false, true, true, false, false, get利用実人員(), "日数", get単位数(), get費用総額(),
            get介護給付費(), "", ""),
    /**
     * コード:27 名称:地域密着型介護老人福祉施設 略称:定義なし
     */
    地域密着型介護老人福祉施設("27", "地域密着型介護老人福祉施設",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳あり_合計加算なし,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, true, true, false, false, true, true, true, true, get利用実人員(), get日数外泊(), get単位数(), get費用総額(),
            get介護給付費(), get特定入所費(), get社福軽減額()),
    /**
     * コード:28 名称:定期巡回・随時対応型訪問介護看護 略称:定義なし
     */
    定期巡回_随時対応型訪問介護看護("28", "定期巡回・随時対応型訪問介護看護",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算なし,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, true, false, false, true, true, false, true, get利用実人員(), get回数(), get単位数(), get費用総額(),
            get介護給付費(), "", get社福軽減額()),
    /**
     * コード:29 名称:看護小規模多機能型居宅介護_短期以外 略称:定義なし
     */
    看護小規模多機能型居宅介護_短期以外("29", "看護小規模多機能型居宅介護_短期以外",
            RiyojokyoTokeihyo_KaisuShukeiPattern.日数回数_内訳なし_合計加算なし,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, true, false, false, true, true, false, true, get利用実人員(), get回数(), get単位数(), get費用総額(),
            get介護給付費(), "", get社福軽減額()),
    /**
     * コード:30 名称:看護小規模多機能型居宅介護_短期 略称:定義なし
     */
    看護小規模多機能型居宅介護_短期("30", "看護小規模多機能型居宅介護_短期",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, true, false, false, true, true, false, true, get利用実人員(), get回数(), get単位数(), get費用総額(),
            get介護給付費(), "", get社福軽減額()),
    /**
     * コード:31 名称:地域密着型通所介護 略称:定義なし
     */
    地域密着型通所介護("31", "地域密着型通所介護",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算あり,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, true, false, false, true, true, false, true, get利用実人員(), get回数(), get単位数(), get費用総額(),
            get介護給付費(), "", get社福軽減額()),
    /**
     * コード:32 名称:地域密着型施設サービス計 略称:定義なし
     */
    地域密着型施設サービス計("32", "地域密着型施設サービス計",
            RiyojokyoTokeihyo_KaisuShukeiPattern.加算対象外,
            false, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.加算対象外,
            false, false, false, false, false, false, false, false, false, get利用実人員(), "", get単位数(), get費用総額(),
            get介護給付費(), get特定入所費(), get社福軽減額()),
    /**
     * コード:33 名称:居宅介護支援介護要望支援 略称:定義なし
     */
    居宅介護支援介護要望支援("33", "居宅介護支援介護要望支援",
            RiyojokyoTokeihyo_KaisuShukeiPattern.居宅支援_内訳あり_合計加算なし,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.保険請求額,
            true, false, false, false, false, false, true, false, false, get利用実人員(), "回数（件数）", get単位数(),
            get費用総額(), get介護給付費(), "", ""),
    /**
     * コード:34 名称:介護予防_特定福祉用具販売費 略称:定義なし
     */
    介護予防_特定福祉用具販売費("34", "介護予防_特定福祉用具販売費",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算あり,
            false, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.保険請求額_利用者負担額,
            true, false, false, false, false, false, true, false, false, get利用実人員(), "件数", "", get費用総額(), get介護給付費(), "", ""),
    /**
     * コード:35 名称:介護予防_住宅改修費 略称:定義なし
     */
    介護予防_住宅改修費("35", "介護予防_住宅改修費",
            RiyojokyoTokeihyo_KaisuShukeiPattern.短期入所実日数_内訳なし_合計加算あり,
            false, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.保険請求額_利用者負担額,
            true, false, false, false, false, false, true, false, false, get利用実人員(), "件数", "", get費用総額(), get介護給付費(), "", ""),
    /**
     * コード:36 名称:介護給付費計 略称:定義なし
     */
    介護給付費計("36", "介護給付費計",
            RiyojokyoTokeihyo_KaisuShukeiPattern.加算対象外,
            false, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.加算対象外,
            false, false, false, false, false, false, false, false, false, get利用実人員(), "", get単位数(),
            get費用総額(), get介護給付費(), get特定入所費(), get社福軽減額()),
    /**
     * コード:37 名称:特定入所者 略称:定義なし
     */
    特定入所者("37", "特定入所者",
            RiyojokyoTokeihyo_KaisuShukeiPattern.加算対象外,
            false, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.加算対象外,
            false, false, false, false, false, false, false, false, false, get利用実人員(), "食費　　日数",
            "　　費用総額", "　介護給付費", "居住費　日数", "　　費用総額", "　介護給付費"),
    /**
     * コード:38 名称:社福 略称:定義なし
     */
    社福("38", "社福",
            RiyojokyoTokeihyo_KaisuShukeiPattern.加算対象外,
            false, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.加算対象外,
            false, false, false, false, false, false, false, false, false, get利用実人員(), "", "", "利用者負担額", "軽減額", "軽減後負担額", ""),
    /**
     * コード:39 名称:市町村特別給付 略称:定義なし
     */
    市町村特別給付("39", "市町村特別給付",
            RiyojokyoTokeihyo_KaisuShukeiPattern.加算対象外,
            true, RiyojokyoTokeihyo_HiyoSogakuShukeiPattern.計算,
            true, false, false, false, false, false, false, false, false, get利用実人員(), "", get単位数(), get費用総額(), get介護給付費(), "", "");

    private final RString code;
    private final RString fullName;
    private final RiyojokyoTokeihyo_KaisuShukeiPattern kaisuShuukei;
    private final boolean tanisuuShuukeiUmu;
    private final RiyojokyoTokeihyo_HiyoSogakuShukeiPattern hiyoSogakuShukei;
    private final boolean kaigoKyuuhuShuukeiUmu;
    private final boolean tokuteiNyuushohiShuukeiUmu;
    private final boolean shahukuKeigenGakuShuukeiUmu;
    private final boolean kyotakuServiceKasanUmu;
    private final boolean shisetuServiceKasanUmu;
    private final boolean tikiServiceKasanUmu;
    private final boolean kaigoKyuuhuServiceKasanUmu;
    private final boolean tokuteiNyuushKasanUmu;
    private final boolean shahukuKeigenKasanUmu;
    private final RString shuukeiAtaiName1;
    private final RString shuukeiAtaiName2;
    private final RString shuukeiAtaiName3;
    private final RString shuukeiAtaiName4;
    private final RString shuukeiAtaiName5;
    private final RString shuukeiAtaiName6;
    private final RString shuukeiAtaiName7;

    /**
     * 利用実人員を返します。
     *
     * @return 利用実人員
     */
    public static String get利用実人員() {
        RString 利用実人員 = new RString("利用実人員");
        return 利用実人員.toString();
    }

    /**
     * 回数を返します。
     *
     * @return 回数
     */
    public static String get回数() {
        RString 回数 = new RString("回数");
        return 回数.toString();
    }

    /**
     * 単位数を返します。
     *
     * @return 単位数
     */
    public static String get単位数() {
        RString 単位数 = new RString("単位数");
        return 単位数.toString();
    }

    /**
     * 費用総額を返します。
     *
     * @return 費用総額
     */
    public static String get費用総額() {
        RString 費用総額 = new RString("費用総額");
        return 費用総額.toString();
    }

    /**
     * 介護給付費を返します。
     *
     * @return 介護給付費
     */
    public static String get介護給付費() {
        RString 介護給付費 = new RString("介護給付費");
        return 介護給付費.toString();
    }

    /**
     * 社福軽減額を返します。
     *
     * @return 社福軽減額
     */
    public static String get社福軽減額() {
        RString 社福軽減額 = new RString("社福軽減額");
        return 社福軽減額.toString();
    }

    /**
     * 特定入所費を返します。
     *
     * @return 特定入所費
     */
    public static String get特定入所費() {
        RString 特定入所費 = new RString("特定入所費");
        return 特定入所費.toString();
    }

    /**
     * 日数外泊を返します。
     *
     * @return 日数外泊
     */
    public static String get日数外泊() {
        RString 日数外泊 = new RString("日数（外泊）");
        return 日数外泊.toString();
    }

    private RiyojokyoTokeihyo_EditPattern(String code, String fullname,
            RiyojokyoTokeihyo_KaisuShukeiPattern kaisuShuukei, boolean tanisuuShuukeiUmu,
            RiyojokyoTokeihyo_HiyoSogakuShukeiPattern hiyoSogakuShukei, boolean kaigoKyuuhuShuukeiUmu,
            boolean tokuteiNyuushohiShuukeiUmu, boolean shahukuKeigenGakuShuukeiUmu,
            boolean kyotakuServiceKasanUmu, boolean shisetuServiceKasanUmu,
            boolean tikiServiceKasanUmu, boolean kaigoKyuuhuServiceKasanUmu,
            boolean tokuteiNyuushKasanUmu, boolean shahukuKeigenKasanUmu,
            String shuukeiAtaiName1, String shuukeiAtaiName2,
            String shuukeiAtaiName3, String shuukeiAtaiName4,
            String shuukeiAtaiName5, String shuukeiAtaiName6,
            String shuukeiAtaiName7) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.kaisuShuukei = kaisuShuukei;
        this.tanisuuShuukeiUmu = tanisuuShuukeiUmu;
        this.hiyoSogakuShukei = hiyoSogakuShukei;
        this.kaigoKyuuhuShuukeiUmu = kaigoKyuuhuShuukeiUmu;
        this.tokuteiNyuushohiShuukeiUmu = tokuteiNyuushohiShuukeiUmu;
        this.shahukuKeigenGakuShuukeiUmu = shahukuKeigenGakuShuukeiUmu;
        this.kyotakuServiceKasanUmu = kyotakuServiceKasanUmu;
        this.shisetuServiceKasanUmu = shisetuServiceKasanUmu;
        this.tikiServiceKasanUmu = tikiServiceKasanUmu;
        this.kaigoKyuuhuServiceKasanUmu = kaigoKyuuhuServiceKasanUmu;
        this.tokuteiNyuushKasanUmu = tokuteiNyuushKasanUmu;
        this.shahukuKeigenKasanUmu = shahukuKeigenKasanUmu;
        this.shuukeiAtaiName1 = new RString(shuukeiAtaiName1);
        this.shuukeiAtaiName2 = new RString(shuukeiAtaiName2);
        this.shuukeiAtaiName3 = new RString(shuukeiAtaiName3);
        this.shuukeiAtaiName4 = new RString(shuukeiAtaiName4);
        this.shuukeiAtaiName5 = new RString(shuukeiAtaiName5);
        this.shuukeiAtaiName6 = new RString(shuukeiAtaiName6);
        this.shuukeiAtaiName7 = new RString(shuukeiAtaiName7);
    }

    /**
     * 利用状況統計表_編集仕様のコードを返します。
     *
     * @return 利用状況統計表_編集仕様のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 利用状況統計表_編集仕様の名称を返します。
     *
     * @return 利用状況統計表_編集仕様の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 利用状況統計表_編集仕様の回数集計パターンを返します。
     *
     * @return 利用状況統計表_編集仕様の回数集計パターン
     */
    public RiyojokyoTokeihyo_KaisuShukeiPattern get回数集計パターン() {
        return kaisuShuukei;
    }

    /**
     * 利用状況統計表_編集仕様の単位数集計有無を返します。
     *
     * @return 利用状況統計表_編集仕様の単位数集計有無
     */
    public boolean is単位数集計有無() {
        return tanisuuShuukeiUmu;
    }

    /**
     * 利用状況統計表_編集仕様の費用総額集計パターンを返します。
     *
     * @return 利用状況統計表_編集仕様の費用総額集計パターン
     */
    public RiyojokyoTokeihyo_HiyoSogakuShukeiPattern get費用総額集計パターン() {
        return hiyoSogakuShukei;
    }

    /**
     * 利用状況統計表_編集仕様の介護給付費集計有無を返します。
     *
     * @return 利用状況統計表_編集仕様の介護給付費集計有無
     */
    public boolean is介護給付費集計有無() {
        return kaigoKyuuhuShuukeiUmu;
    }

    /**
     * 利用状況統計表_編集仕様の特定入所費集計有無を返します。
     *
     * @return 利用状況統計表_編集仕様の特定入所費集計有無
     */
    public boolean is特定入所費集計有無() {
        return tokuteiNyuushohiShuukeiUmu;
    }

    /**
     * 利用状況統計表_編集仕様の社福軽減額集計有無を返します。
     *
     * @return 利用状況統計表_編集仕様の社福軽減額集計有無
     */
    public boolean is社福軽減額集計有無() {
        return shahukuKeigenGakuShuukeiUmu;
    }

    /**
     * 利用状況統計表_編集仕様の居宅サービス計加算有無を返します。
     *
     * @return 利用状況統計表_編集仕様の居宅サービス計加算有無
     */
    public boolean is居宅サービス計加算有無() {
        return kyotakuServiceKasanUmu;
    }

    /**
     * 利用状況統計表_編集仕様の施設サービス計加算有無を返します。
     *
     * @return 利用状況統計表_編集仕様の施設サービス計加算有無
     */
    public boolean is施設サービス計加算有無() {
        return shisetuServiceKasanUmu;
    }

    /**
     * 利用状況統計表_編集仕様の地域サービス計加算有無を返します。
     *
     * @return 利用状況統計表_編集仕様の地域サービス計加算有無
     */
    public boolean is地域サービス計加算有無() {
        return tikiServiceKasanUmu;
    }

    /**
     * 利用状況統計表_編集仕様の介護給付費計加算有無を返します。
     *
     * @return 利用状況統計表_編集仕様の介護給付費計加算有無
     */
    public boolean is介護給付費計加算有無() {
        return kaigoKyuuhuServiceKasanUmu;
    }

    /**
     * 利用状況統計表_編集仕様の特定入所者計加算有無を返します。
     *
     * @return 利用状況統計表_編集仕様の特定入所者計加算有無
     */
    public boolean is特定入所者計加算有無() {
        return tokuteiNyuushKasanUmu;
    }

    /**
     * 利用状況統計表_編集仕様の社福計加算有無を返します。
     *
     * @return 利用状況統計表_編集仕様の社福計加算有無
     */
    public boolean is社福計加算有無() {
        return shahukuKeigenKasanUmu;
    }

    /**
     * 利用状況統計表_編集仕様の集計項目名1を返します。
     *
     * @return 利用状況統計表_編集仕様の集計項目名1
     */
    public RString get集計項目名1() {
        return shuukeiAtaiName1;
    }

    /**
     * 利用状況統計表_編集仕様の集計項目名2を返します。
     *
     * @return 利用状況統計表_編集仕様の集計項目名2
     */
    public RString get集計項目名2() {
        return shuukeiAtaiName2;
    }

    /**
     * 利用状況統計表_編集仕様の集計項目名3を返します。
     *
     * @return 利用状況統計表_編集仕様の集計項目名3
     */
    public RString get集計項目名3() {
        return shuukeiAtaiName3;
    }

    /**
     * 利用状況統計表_編集仕様の集計項目名4を返します。
     *
     * @return 利用状況統計表_編集仕様の集計項目名4
     */
    public RString get集計項目名4() {
        return shuukeiAtaiName4;
    }

    /**
     * 利用状況統計表_編集仕様の集計項目名5を返します。
     *
     * @return 利用状況統計表_編集仕様の集計項目名5
     */
    public RString get集計項目名5() {
        return shuukeiAtaiName5;
    }

    /**
     * 利用状況統計表_編集仕様の集計項目名6を返します。
     *
     * @return 利用状況統計表_編集仕様の集計項目名6
     */
    public RString get集計項目名6() {
        return shuukeiAtaiName6;
    }

    /**
     * 利用状況統計表_編集仕様の集計項目名7を返します。
     *
     * @return 利用状況統計表_編集仕様の集計項目名7
     */
    public RString get集計項目名7() {
        return shuukeiAtaiName7;
    }

    /**
     * 利用状況統計表_編集仕様のコードと一致する内容を探します。
     *
     * @param code 利用状況統計表_編集仕様のコード
     * @return {@code code} に対応する利用状況統計表_編集仕様
     */
    public static RiyojokyoTokeihyo_EditPattern toValue(RString code) {
        for (RiyojokyoTokeihyo_EditPattern riyojokyoTokeihyo_EditPattern : RiyojokyoTokeihyo_EditPattern.values()) {
            if (riyojokyoTokeihyo_EditPattern.code.equals(code)) {
                return riyojokyoTokeihyo_EditPattern;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
