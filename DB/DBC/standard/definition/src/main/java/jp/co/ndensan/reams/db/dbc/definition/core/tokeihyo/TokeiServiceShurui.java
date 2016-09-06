package jp.co.ndensan.reams.db.dbc.definition.core.tokeihyo;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 統計用サービス種類を表す列挙型です。
 *
 * @reamsid_L DBC-9999-022 sunhaidi
 */
public enum TokeiServiceShurui {

    /**
     * コード:01 名称:介護予防_訪問介護 略称:(介護予防)訪問介護
     */
    _介護予防_訪問介護("01", "介護予防_訪問介護", "(介護予防)訪問介護"),

    /**
     * コード:02 名称:介護予防_訪問入浴介護 略称:(介護予防)訪問入浴介護
     */
    _介護予防_訪問入浴介護("02", "介護予防_訪問入浴介護", "(介護予防)訪問入浴介護"),

    /**
     * コード:03 名称:介護予防_訪問看護 略称:(介護予防)訪問看護
     */
    _介護予防_訪問看護("03", "介護予防_訪問看護", "(介護予防)訪問看護"),

    /**
     * コード:04 名称:介護予防_訪問リハビリ 略称:(介護予防)訪問リハビリ
     */
    _介護予防_訪問リハビリ("04", "介護予防_訪問リハビリ", "(介護予防)訪問リハビリ"),

    /**
     * コード:05 名称:介護予防_通所介護 略称:(介護予防)通所介護
     */
    _介護予防_通所介護("05", "介護予防_通所介護", "(介護予防)通所介護"),

    /**
     * コード:06 名称:介護予防_通所リハビリ 略称:(介護予防)通所リハビリ
     */
    _介護予防_通所リハビリ("06", "介護予防_通所リハビリ", "(介護予防)通所リハビリ"),

    /**
     * コード:07 名称:介護予防_福祉用具貸与 略称:(介護予防)福祉用具貸与
     */
    _介護予防_福祉用具貸与("07", "介護予防_福祉用具貸与", "(介護予防)福祉用具貸与"),

    /**
     * コード:08 名称:介護予防_短期入所生活介護 略称:(介護予防)短期入所生活介護
     */
    _介護予防_短期入所生活介護("08", "介護予防_短期入所生活介護", "(介護予防)短期入所生活介護"),

    /**
     * コード:09 名称:介護予防_短期入所老健施設 略称:(介護予防)短期入所老健施設
     */
    _介護予防_短期入所老健施設("09", "介護予防_短期入所老健施設", "(介護予防)短期入所老健施設"),

    /**
     * コード:10 名称:介護予防_短期入所医療施設 略称:(介護予防)短期入所医療施設
     */
    _介護予防_短期入所医療施設("10", "介護予防_短期入所医療施設", "(介護予防)短期入所医療施設"),

    /**
     * コード:11 名称:介護予防_居宅療養管理指導 略称:(介護予防)居宅療養管理指導
     */
    _介護予防_居宅療養管理指導("11", "介護予防_居宅療養管理指導", "(介護予防)居宅療養管理指導"),

    /**
     * コード:12 名称:介護予防_特定施設生活介護_短期以外 略称:(介護予防)特定施設生活介護（短期以外）
     */
    _介護予防_特定施設生活介護_短期以外("12", "介護予防_特定施設生活介護_短期以外", "(介護予防)特定施設生活介護（短期以外）"),

    /**
     * コード:13 名称:介護予防_特定施設生活介護_短期 略称:(介護予防)特定施設生活介護（短期）
     */
    _介護予防_特定施設生活介護_短期("13", "介護予防_特定施設生活介護_短期", "(介護予防)特定施設生活介護（短期）"),

    /**
     * コード:14 名称:居宅サービス計 略称:居宅サービス計（1-13の合計）
     */
    居宅サービス計_1_13の合計("14", "居宅サービス計", "居宅サービス計（1-13の合計）"),

    /**
     * コード:15 名称:介護福祉施設 略称:介護福祉施設
     */
    介護福祉施設("15", "介護福祉施設", "介護福祉施設"),

    /**
     * コード:16 名称:介護老健施設 略称:介護老健施設
     */
    介護老健施設("16", "介護老健施設", "介護老健施設"),

    /**
     * コード:17 名称:介護医療施設 略称:介護医療施設
     */
    介護医療施設("17", "介護医療施設", "介護医療施設"),

    /**
     * コード:18 名称:施設サービス計 略称:施設サービス計（15-17の合計）
     */
    施設サービス計_15_17の合計("18", "施設サービス計", "施設サービス計（15-17の合計）"),

    /**
     * コード:19 名称:夜間対応型訪問介護 略称:夜間対応型訪問介護
     */
    夜間対応型訪問介護("19", "夜間対応型訪問介護", "夜間対応型訪問介護"),

    /**
     * コード:20 名称:介護予防_認知症対応型通所介護 略称:(介護予防)認知症対応型通所介護
     */
    _介護予防_認知症対応型通所介護("20", "介護予防_認知症対応型通所介護", "(介護予防)認知症対応型通所介護"),

    /**
     * コード:21 名称:介護予防_小規模多機能型居宅介護_短期以外 略称:(介護予防)小規模多機能型居宅介護（短期以外）
     */
    _介護予防_小規模多機能型居宅介護_短期以外("21", "介護予防_小規模多機能型居宅介護_短期以外", "(介護予防)小規模多機能型居宅介護（短期以外）"),

    /**
     * コード:22 名称:介護予防_小規模多機能型居宅介護_短期 略称:(介護予防)小規模多機能型居宅介護（短期）
     */
    _介護予防_小規模多機能型居宅介護_短期("22", "介護予防_小規模多機能型居宅介護_短期", "(介護予防)小規模多機能型居宅介護（短期）"),

    /**
     * コード:23 名称:介護予防_認知症対応型共同生活 略称:(介護予防)認知症対応型共同生活
     */
    _介護予防_認知症対応型共同生活("23", "介護予防_認知症対応型共同生活", "(介護予防)認知症対応型共同生活"),

    /**
     * コード:24 名称:地域密着型特定施設入居者生活_短期以外 略称:地域密着型特定施設入居者生活（短期以外）
     */
    地域密着型特定施設入居者生活_短期以外("24", "地域密着型特定施設入居者生活_短期以外", "地域密着型特定施設入居者生活（短期以外）"),

    /**
     * コード:25 名称:地域密着型特定施設入居者生活_短期 略称:地域密着型特定施設入居者生活（短期）
     */
    地域密着型特定施設入居者生活_短期("25", "地域密着型特定施設入居者生活_短期", "地域密着型特定施設入居者生活（短期）"),

    /**
     * コード:26 名称:介護予防_認知症対応型共同生活_短期 略称:(介護予防)認知症対応型共同生活(短期)
     */
    _介護予防_認知症対応型共同生活_短期("26", "介護予防_認知症対応型共同生活_短期", "(介護予防)認知症対応型共同生活(短期)"),

    /**
     * コード:27 名称:地域密着型介護老人福祉施設 略称:地域密着型介護老人福祉施設
     */
    地域密着型介護老人福祉施設("27", "地域密着型介護老人福祉施設", "地域密着型介護老人福祉施設"),

    /**
     * コード:28 名称:定期巡回・随時対応型訪問介護看護 略称:定期巡回・随時対応型訪問介護看護
     */
    定期巡回_随時対応型訪問介護看護("28", "定期巡回・随時対応型訪問介護看護", "定期巡回・随時対応型訪問介護看護"),

    /**
     * コード:29 名称:看護小規模多機能型居宅介護_短期以外 略称:看護小規模多機能型居宅介護（短期以外）
     */
    看護小規模多機能型居宅介護_短期以外("29", "看護小規模多機能型居宅介護_短期以外", "看護小規模多機能型居宅介護（短期以外）"),

    /**
     * コード:30 名称:看護小規模多機能型居宅介護_短期 略称:看護小規模多機能型居宅介護（短期）
     */
    看護小規模多機能型居宅介護_短期("30", "看護小規模多機能型居宅介護_短期", "看護小規模多機能型居宅介護（短期）"),

    /**
     * コード:31 名称:地域密着型通所介護 略称:地域密着型通所介護
     */
    地域密着型通所介護("31", "地域密着型通所介護", "地域密着型通所介護"),

    /**
     * コード:32 名称:地域密着型施設サービス計 略称:地域密着型施設サービス計（19-31の合計）
     */
    地域密着型施設サービス計_19_31の合計("32", "地域密着型施設サービス計", "地域密着型施設サービス計（19-31の合計）"),

    /**
     * コード:33 名称:居宅介護支援介護要望支援 略称:居宅介護支援介護要望支援
     */
    居宅介護支援介護要望支援("33", "居宅介護支援介護要望支援", "居宅介護支援介護要望支援"),

    /**
     * コード:34 名称:介護予防_特定福祉用具販売費 略称:(介護予防)特定福祉用具販売費
     */
    _介護予防_特定福祉用具販売費("34", "介護予防_特定福祉用具販売費", "(介護予防)特定福祉用具販売費"),

    /**
     * コード:35 名称:介護予防_住宅改修費 略称:(介護予防)住宅改修費
     */
    _介護予防_住宅改修費("35", "介護予防_住宅改修費", "(介護予防)住宅改修費"),

    /**
     * コード:36 名称:介護給付費計 略称:介護給付費計
     */
    介護給付費計("36", "介護給付費計", "介護給付費計"),

    /**
     * コード:37 名称:特定入所者 略称:特定入所者
     */
    特定入所者("37", "特定入所者", "特定入所者"),

    /**
     * コード:38 名称:社福 略称:社福
     */
    社福("38", "社福", "社福"),

    /**
     * コード:39 名称:市町村特別給付 略称:市町村特別給付
     */
    市町村特別給付("39", "市町村特別給付", "市町村特別給付");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private TokeiServiceShurui(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 統計用サービス種類のコードを返します。
     *
     * @return 統計用サービス種類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 統計用サービス種類の名称を返します。
     *
     * @return 統計用サービス種類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 統計用サービス種類の略称を返します。
     *
     * @return 統計用サービス種類の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 統計用サービス種類のコードと一致する内容を探します。
     *
     * @param code 統計用サービス種類のコード
     * @return {@code code} に対応する統計用サービス種類
     */
    public static TokeiServiceShurui toValue(RString code) {
        for (TokeiServiceShurui tokeiServiceShurui : TokeiServiceShurui.values()) {
            if (tokeiServiceShurui.code.equals(code)) {
                return tokeiServiceShurui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
