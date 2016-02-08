package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 住所編集区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum JushoHenshuKubun {

    /**
     * コード:0 名称:市町村共通 略称:定義なし
     */
    市町村共通("0", "市町村共通"),
    /**
     * コード:1 名称:帳票独自 略称:定義なし
     */
    帳票独自("1", "帳票独自");

    private final RString code;
    private final RString fullName;

    private JushoHenshuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 住所編集区分のコードを返します。
     *
     * @return 住所編集区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 住所編集区分の名称を返します。
     *
     * @return 住所編集区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 住所編集区分のコードと一致する内容を探します。
     *
     * @param code 住所編集区分のコード
     * @return {@code code} に対応する住所編集区分
     */
    public static JushoHenshuKubun toValue(RString code) {

        for (JushoHenshuKubun jushoHenshuKubun : JushoHenshuKubun.values()) {
            if (jushoHenshuKubun.code.equals(code)) {
                return jushoHenshuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("住所編集区分"));
    }
}
