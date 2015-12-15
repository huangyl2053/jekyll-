package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 審査継続区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsShinsaKeizoku {

    /**
     * コード:True 名称:継続する 略称:定義なし
     */
    継続する(true, "継続する"),
    /**
     * コード:False 名称:継続しない 略称:定義なし
     */
    継続しない(false, "継続しない");

    private final boolean code;
    private final RString fullName;

    private IsShinsaKeizoku(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 審査継続区分のコードを返します。
     *
     * @return 審査継続区分のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 審査継続区分の名称を返します。
     *
     * @return 審査継続区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 審査継続区分のコードと一致する内容を探します。
     *
     * @param code 審査継続区分のコード
     * @return {@code code} に対応する審査継続区分
     */
    public static IsShinsaKeizoku toValue(boolean code) {
        for (IsShinsaKeizoku isShinsaKeizoku : IsShinsaKeizoku.values()) {
            if (isShinsaKeizoku.code == code) {
                return isShinsaKeizoku;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("審査継続区分"));
    }
}
