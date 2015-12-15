package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 取下区分コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum TorisageKubunCode {

    /**
     * コード:1 名称:認定申請有効 略称:定義なし
     */
    認定申請有効("1", "認定申請有効"),
    /**
     * コード:2 名称:却下 略称:定義なし
     */
    却下("2", "却下"),
    /**
     * コード:3 名称:取り下げ 略称:定義なし
     */
    取り下げ("3", "取り下げ"),
    /**
     * コード:4 名称:区分変更却下 略称:定義なし
     */
    区分変更却下("4", "区分変更却下");

    private final RString code;
    private final RString fullName;

    private TorisageKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 取下区分コードのコードを返します。
     *
     * @return 取下区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 取下区分コードの名称を返します。
     *
     * @return 取下区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 取下区分コードのコードと一致する内容を探します。
     *
     * @param code 取下区分コードのコード
     * @return {@code code} に対応する取下区分コード
     */
    public static TorisageKubunCode toValue(RString code) {

        for (TorisageKubunCode torisageKubunCode : TorisageKubunCode.values()) {
            if (torisageKubunCode.code.equals(code)) {
                return torisageKubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("取下区分コード"));
    }
}
