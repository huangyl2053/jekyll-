package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯員把握管理識別区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum SetaiinHaakuKanriShikibetsuKubun {

    /**
     * コード:1 名称:賦課 略称:定義なし
     */
    賦課("1", "賦課"),
    /**
     * コード:2 名称:高額介護 略称:定義なし
     */
    高額介護("2", "高額介護"),
    /**
     * コード:3 名称:負担限度額 略称:定義なし
     */
    負担限度額("3", "負担限度額"),
    /**
     * コード:4 名称:社福軽減 略称:定義なし
     */
    社福軽減("4", "社福軽減");

    private final RString code;
    private final RString fullName;

    private SetaiinHaakuKanriShikibetsuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 世帯員把握管理識別区分のコードを返します。
     *
     * @return 世帯員把握管理識別区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 世帯員把握管理識別区分の名称を返します。
     *
     * @return 世帯員把握管理識別区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 世帯員把握管理識別区分のコードと一致する内容を探します。
     *
     * @param code 世帯員把握管理識別区分のコード
     * @return {@code code} に対応する世帯員把握管理識別区分
     */
    public static SetaiinHaakuKanriShikibetsuKubun toValue(RString code) {

        for (SetaiinHaakuKanriShikibetsuKubun value : SetaiinHaakuKanriShikibetsuKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("世帯員把握管理識別区分"));
    }
}
