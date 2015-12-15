package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 認定調査依頼区分コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum NinteiChousaIraiKubunCode {

    /**
     * コード:0 名称:初回 略称:定義なし
     */
    初回("0", "初回"),
    /**
     * コード:1 名称:再依頼 略称:定義なし
     */
    再依頼("1", "再依頼"),
    /**
     * コード:2 名称:再調査 略称:定義なし
     */
    再調査("2", "再調査");

    private final RString code;
    private final RString fullName;

    private NinteiChousaIraiKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 認定調査依頼区分コードのコードを返します。
     *
     * @return 認定調査依頼区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 認定調査依頼区分コードの名称を返します。
     *
     * @return 認定調査依頼区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 認定調査依頼区分コードのコードと一致する内容を探します。
     *
     * @param code 認定調査依頼区分コードのコード
     * @return {@code code} に対応する認定調査依頼区分コード
     */
    public static NinteiChousaIraiKubunCode toValue(RString code) {

        for (NinteiChousaIraiKubunCode ninteiChousaIraiKubunCode : NinteiChousaIraiKubunCode.values()) {
            if (ninteiChousaIraiKubunCode.code.equals(code)) {
                return ninteiChousaIraiKubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("認定調査依頼区分コード"));
    }
}
