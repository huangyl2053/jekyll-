package jp.co.ndensan.reams.db.dbb.definition.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShoriKubun {

    /**
     * コード:1 名称:リアル 略称:定義なし
     */
    リアル("1", "リアル"),
    /**
     * コード:2 名称:バッチ 略称:定義なし
     */
    バッチ("2", "バッチ");

    private final RString code;
    private final RString fullName;

    private ShoriKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 処理区分のコードを返します。
     *
     * @return 処理区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 処理区分の名称を返します。
     *
     * @return 処理区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 処理区分のコードと一致する内容を探します。
     *
     * @param code 処理区分のコード
     * @return {@code code} に対応する処理区分
     */
    public static ShoriKubun toValue(RString code) {
        for (ShoriKubun shoriKubun : ShoriKubun.values()) {
            if (shoriKubun.code.equals(code)) {
                return shoriKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("処理区分"));
    }
}
