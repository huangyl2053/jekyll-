package jp.co.ndensan.reams.db.dbc.definition.core.keikoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 警告区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KeikokuKubun {

    /**
     * コード:1 名称:警告なし 略称:定義なし
     */
    警告なし("1", "警告なし"),
    /**
     * コード:2 名称:警告あり 略称:定義なし
     */
    警告あり("2", "警告あり");

    private final RString code;
    private final RString fullName;

    private KeikokuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 警告区分のコードを返します。
     *
     * @return 警告区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 警告区分の名称を返します。
     *
     * @return 警告区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 警告区分のコードと一致する内容を探します。
     *
     * @param code 警告区分のコード
     * @return {@code code} に対応する警告区分
     */
    public static KeikokuKubun toValue(RString code) {

        for (KeikokuKubun keikokuKubun : KeikokuKubun.values()) {
            if (keikokuKubun.code.equals(code)) {
                return keikokuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("警告区分"));
    }
}
