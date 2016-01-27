package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処理状態区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShoriJotaiKubun {

    /**
     * コード:0 名称:通常 略称:定義なし
     */
    通常("0", "通常"),
    /**
     * コード:1 名称:取下 略称:定義なし
     */
    取下("1", "取下"),
    /**
     * コード:2 名称:却下 略称:定義なし
     */
    却下("2", "却下"),
    /**
     * コード:3 名称:延期 略称:定義なし
     */
    延期("3", "延期");

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
