package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請区分（申請時）コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum NinteiShinseiShinseijiKubunCode {

    /**
     * コード:1 名称:新規申請 略称:定義なし
     */
    新規申請("1", "新規申請"),
    /**
     * コード:2 名称:更新申請 略称:定義なし
     */
    更新申請("2", "更新申請"),
    /**
     * コード:3 名称:区分変更申請 略称:定義なし
     */
    区分変更申請("3", "区分変更申請"),
    /**
     * コード:4 名称:職権 略称:定義なし
     */
    職権("4", "職権"),
    /**
     * コード:5 名称:転入申請 略称:定義なし
     */
    転入申請("5", "転入申請"),
    /**
     * コード:6 名称:資格喪失（死亡） 略称:定義なし
     */
    資格喪失_死亡("6", "資格喪失（死亡）"),
    /**
     * コード:A 名称:新規申請（事前） 略称:定義なし
     */
    新規申請_事前("A", "新規申請（事前）"),
    /**
     * コード:B 名称:更新申請（事前） 略称:定義なし
     */
    更新申請_事前("B", "更新申請（事前）");

    private final RString code;
    private final RString fullName;

    private NinteiShinseiShinseijiKubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 申請区分（申請時）コードのコードを返します。
     *
     * @return 申請区分（申請時）コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 申請区分（申請時）コードの名称を返します。
     *
     * @return 申請区分（申請時）コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申請区分（申請時）コードのコードと一致する内容を探します。
     *
     * @param code 申請区分（申請時）コードのコード
     * @return {@code code} に対応する申請区分（申請時）コード
     */
    public static NinteiShinseiShinseijiKubunCode toValue(RString code) {

        for (NinteiShinseiShinseijiKubunCode value : NinteiShinseiShinseijiKubunCode.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請区分（申請時）コード"));
    }
}
