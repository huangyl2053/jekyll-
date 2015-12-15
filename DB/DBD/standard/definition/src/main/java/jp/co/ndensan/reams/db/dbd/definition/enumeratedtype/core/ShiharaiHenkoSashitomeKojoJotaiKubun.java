package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更差止控除状態区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShiharaiHenkoSashitomeKojoJotaiKubun {

    /**
     * コード:01 名称:登録 略称:定義なし
     */
    登録("01", "登録"),
    /**
     * コード:99 名称:解除 略称:定義なし
     */
    解除("99", "解除");

    private final RString code;
    private final RString fullName;

    private ShiharaiHenkoSashitomeKojoJotaiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法変更差止控除状態区分のコードを返します。
     *
     * @return 支払方法変更差止控除状態区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法変更差止控除状態区分の名称を返します。
     *
     * @return 支払方法変更差止控除状態区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法変更差止控除状態区分のコードと一致する内容を探します。
     *
     * @param code 支払方法変更差止控除状態区分のコード
     * @return {@code code} に対応する支払方法変更差止控除状態区分
     */
    public static ShiharaiHenkoSashitomeKojoJotaiKubun toValue(RString code) {

        for (ShiharaiHenkoSashitomeKojoJotaiKubun value : ShiharaiHenkoSashitomeKojoJotaiKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更差止控除状態区分"));
    }
}
