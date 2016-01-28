package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 仮算定併徴者普徴分徴収有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum ZanteiHeichoshaFuchobunChoshuUmu {

    /**
     * コード:0 名称:徴収しない 略称:定義なし
     */
    徴収しない("0", "徴収しない"),
    /**
     * コード:1 名称:徴収する 略称:定義なし
     */
    徴収する("1", "徴収する");

    private final RString code;
    private final RString fullName;

    private ZanteiHeichoshaFuchobunChoshuUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 仮算定併徴者普徴分徴収有無のコードを返します。
     *
     * @return 仮算定併徴者普徴分徴収有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 仮算定併徴者普徴分徴収有無の名称を返します。
     *
     * @return 仮算定併徴者普徴分徴収有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 仮算定併徴者普徴分徴収有無のコードと一致する内容を探します。
     *
     * @param code 仮算定併徴者普徴分徴収有無のコード
     * @return {@code code} に対応する仮算定併徴者普徴分徴収有無
     */
    public static ZanteiHeichoshaFuchobunChoshuUmu toValue(RString code) {
        for (ZanteiHeichoshaFuchobunChoshuUmu value : ZanteiHeichoshaFuchobunChoshuUmu.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("仮算定併徴者普徴分徴収有無"));
    }
}
