package jp.co.ndensan.reams.db.dbc.definition.core.kagomoshitate;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 過誤申立_申立書区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum KagoMoshitate_MoshitateshoKubun {

    /**
     * コード:1 名称:過誤申立書情報
     */
    過誤申立書("1", "過誤申立書情報"),
    /**
     * コード:2 名称:総合事業過誤申立書情報（経過措置）
     */
    総合事業申立書_経過("2", "総合事業過誤申立書情報（経過措置）"),
    /**
     * コード:3 名称:総合事業過誤申立書情報
     */
    総合事業申立書("3", "総合事業過誤申立書情報");

    private final RString code;
    private final RString fullName;

    private KagoMoshitate_MoshitateshoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 過誤申立_申立書区分のコードを返します。
     *
     * @return 過誤申立_申立書区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 過誤申立_申立書区分の名称を返します。
     *
     * @return 過誤申立_申立書区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 過誤申立_申立書区分のコードと一致する内容を探します。
     *
     * @param code 過誤申立_申立書区分のコード
     * @return {@code code} に対応する過誤申立_申立書区分
     */
    public static KagoMoshitate_MoshitateshoKubun toValue(RString code) {
        for (KagoMoshitate_MoshitateshoKubun value : KagoMoshitate_MoshitateshoKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("過誤申立_申立書区分"));
    }
}
