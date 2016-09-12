package jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申立者区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum KagoMoshitate_MoshitateshaKubun {

    /**
     * コード:1 名称:サービス事業者等申立
     */
    サービス事業者等申立("1", "サービス事業者等申立"),
    /**
     * コード:2 名称:保険者申立
     */
    保険者申立("2", "保険者申立");

    private final RString code;
    private final RString fullName;

    private KagoMoshitate_MoshitateshaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 申立者区分のコードを返します。
     *
     * @return 申立者区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 申立者区分の名称を返します。
     *
     * @return 申立者区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申立者区分のコードと一致する内容を探します。
     *
     * @param code 申立者区分のコード
     * @return {@code code} に対応する申立者区分
     */
    public static KagoMoshitate_MoshitateshaKubun toValue(RString code) {
        for (KagoMoshitate_MoshitateshaKubun value : KagoMoshitate_MoshitateshaKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申立者区分"));
    }
}
