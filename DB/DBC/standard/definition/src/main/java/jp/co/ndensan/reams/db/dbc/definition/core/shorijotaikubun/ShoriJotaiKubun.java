package jp.co.ndensan.reams.db.dbc.definition.core.shorijotaikubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理状態区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShoriJotaiKubun {

    /**
     * コード:1 名称:処理前 略称:定義なし
     */
    処理前("1", "処理前"),
    /**
     * コード:2 名称:起動 略称:定義なし
     */
    起動("2", "起動"),
    /**
     * コード:3 名称:終了 略称:定義なし
     */
    終了("3", "終了"),
    /**
     * コード:4 名称:処理なし 略称:定義なし
     */
    処理なし("4", "処理なし");

    private final RString code;
    private final RString fullName;

    private ShoriJotaiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 処理状態区分のコードを返します。
     *
     * @return 処理状態区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 処理状態区分の名称を返します。
     *
     * @return 処理状態区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 処理状態区分のコードと一致する内容を探します。
     *
     * @param code 処理状態区分のコード
     * @return {@code code} に対応する処理状態区分
     */
    public static ShoriJotaiKubun toValue(RString code) {

        for (ShoriJotaiKubun shoriJotaiKubun : ShoriJotaiKubun.values()) {
            if (shoriJotaiKubun.code.equals(code)) {
                return shoriJotaiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("処理状態区分"));
    }
}
