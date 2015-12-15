package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連携データフォーマットバージョンを表す列挙型です。
 *
 * @author LDNS
 */
public enum RenkeiDataFormatVersion {

    /**
     * コード:1 名称:ＲⅢ介護標準（固定長） 略称:定義なし
     */
    ＲⅢ介護標準_固定長("1", "ＲⅢ介護標準（固定長）"),
    /**
     * コード:2 名称:ＲⅢ介護標準（ＣＳＶ） 略称:定義なし
     */
    ＲⅢ介護標準_ＣＳＶ("2", "ＲⅢ介護標準（ＣＳＶ）"),
    /**
     * コード:3 名称:Ｒ．ＮＥＴ介護標準（固定長） 略称:定義なし
     */
    Ｒ_ＮＥＴ介護標準_固定長("3", "Ｒ．ＮＥＴ介護標準（固定長）"),
    /**
     * コード:4 名称:Ｒ．ＮＥＴ介護標準（ＣＳＶ版） 略称:定義なし
     */
    Ｒ_ＮＥＴ介護標準_ＣＳＶ版("4", "Ｒ．ＮＥＴ介護標準（ＣＳＶ版）"),
    /**
     * コード:5 名称:他社介護標準（固定長） 略称:定義なし
     */
    他社介護標準_固定長("5", "他社介護標準（固定長）"),
    /**
     * コード:6 名称:他社介護標準（ＣＳＶ版） 略称:定義なし
     */
    他社介護標準_ＣＳＶ版("6", "他社介護標準（ＣＳＶ版）"),
    /**
     * コード:7 名称:SBS独自（固定長） 略称:定義なし
     */
    SBS独自_固定長("7", "SBS独自（固定長）"),
    /**
     * コード:8 名称:SBS独自（ＣＳＶ版） 略称:定義なし
     */
    SBS独自_ＣＳＶ版("8", "SBS独自（ＣＳＶ版）"),
    /**
     * コード:9 名称:後期高齢（固定長） 略称:定義なし
     */
    後期高齢_固定長("9", "後期高齢（固定長）"),
    /**
     * コード:10 名称:後期高齢（ＣＳＶ版） 略称:定義なし
     */
    後期高齢_ＣＳＶ版("10", "後期高齢（ＣＳＶ版）"),
    /**
     * コード:11 名称:両毛独自（固定長） 略称:定義なし
     */
    両毛独自_固定長("11", "両毛独自（固定長）"),
    /**
     * コード:12 名称:両毛独自（ＣＳＶ版） 略称:定義なし
     */
    両毛独自_ＣＳＶ版("12", "両毛独自（ＣＳＶ版）"),
    /**
     * コード:13 名称:Ｒｅａｍｓ介護標準（固定長） 略称:定義なし
     */
    Ｒｅａｍｓ介護標準_固定長("13", "Ｒｅａｍｓ介護標準（固定長）"),
    /**
     * コード:14 名称:Ｒｅａｍｓ介護標準（ＣＳＶ版） 略称:定義なし
     */
    Ｒｅａｍｓ介護標準_ＣＳＶ版("14", "Ｒｅａｍｓ介護標準（ＣＳＶ版）");

    private final RString code;
    private final RString fullName;

    private RenkeiDataFormatVersion(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 連携データフォーマットバージョンのコードを返します。
     *
     * @return 連携データフォーマットバージョンのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 連携データフォーマットバージョンの名称を返します。
     *
     * @return 連携データフォーマットバージョンの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 連携データフォーマットバージョンのコードと一致する内容を探します。
     *
     * @param code 連携データフォーマットバージョンのコード
     * @return {@code code} に対応する連携データフォーマットバージョン
     */
    public static RenkeiDataFormatVersion toValue(RString code) {

        for (RenkeiDataFormatVersion renkeiDataFormatVersion : RenkeiDataFormatVersion.values()) {
            if (renkeiDataFormatVersion.code.equals(code)) {
                return renkeiDataFormatVersion;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("連携データフォーマットバージョン"));
    }
}
