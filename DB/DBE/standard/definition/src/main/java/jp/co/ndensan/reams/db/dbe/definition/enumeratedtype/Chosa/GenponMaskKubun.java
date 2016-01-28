package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 原本マスク区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum GenponMaskKubun {

    /**
     * コード:1 名称:原本 略称:定義なし
     */
    原本("1", "原本"),
    /**
     * コード:2 名称:マスク 略称:定義なし
     */
    マスク("2", "マスク");

    private final RString code;
    private final RString fullName;

    private GenponMaskKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 原本マスク区分のコードを返します。
     *
     * @return 原本マスク区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 原本マスク区分の名称を返します。
     *
     * @return 原本マスク区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 原本マスク区分のコードと一致する内容を探します。
     *
     * @param code 原本マスク区分のコード
     * @return {@code code} に対応する原本マスク区分
     */
    public static GenponMaskKubun toValue(RString code) {

        for (GenponMaskKubun genponMaskKubun : GenponMaskKubun.values()) {
            if (genponMaskKubun.code.equals(code)) {
                return genponMaskKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("原本マスク区分"));
    }
}
