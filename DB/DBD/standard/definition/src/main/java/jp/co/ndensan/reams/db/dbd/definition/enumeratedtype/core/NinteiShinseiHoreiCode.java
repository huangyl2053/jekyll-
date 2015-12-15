package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請区分（法令）コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum NinteiShinseiHoreiCode {

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
    職権("4", "職権");

    private final RString code;
    private final RString fullName;

    private NinteiShinseiHoreiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 申請区分（法令）コードのコードを返します。
     *
     * @return 申請区分（法令）コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 申請区分（法令）コードの名称を返します。
     *
     * @return 申請区分（法令）コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申請区分（法令）コードのコードと一致する内容を探します。
     *
     * @param code 申請区分（法令）コードのコード
     * @return {@code code} に対応する申請区分（法令）コード
     */
    public static NinteiShinseiHoreiCode toValue(RString code) {

        for (NinteiShinseiHoreiCode ninteiShinseiHoreiCode : NinteiShinseiHoreiCode.values()) {
            if (ninteiShinseiHoreiCode.code.equals(code)) {
                return ninteiShinseiHoreiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請区分（法令）コード"));
    }
}
