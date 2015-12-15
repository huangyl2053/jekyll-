package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認証者電子公印種別コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum NinshoshaDenshikoinshubetsuCode {

    /**
     * コード:0001 名称:保険者印 略称:定義なし
     */
    保険者印("0001", "保険者印"),
    /**
     * コード:0002 名称:印の字 略称:定義なし
     */
    印の字("0002", "印の字");

    private final RString code;
    private final RString fullName;

    private NinshoshaDenshikoinshubetsuCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認証者電子公印種別コードのコードを返します。
     *
     * @return 認証者電子公印種別コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認証者電子公印種別コードの名称を返します。
     *
     * @return 認証者電子公印種別コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認証者電子公印種別コードのコードと一致する内容を探します。
     *
     * @param code 認証者電子公印種別コードのコード
     * @return {@code code} に対応する認証者電子公印種別コード
     */
    public static NinshoshaDenshikoinshubetsuCode toValue(RString code) {

        for (NinshoshaDenshikoinshubetsuCode value : NinshoshaDenshikoinshubetsuCode.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認証者電子公印種別コード"));
    }
}
