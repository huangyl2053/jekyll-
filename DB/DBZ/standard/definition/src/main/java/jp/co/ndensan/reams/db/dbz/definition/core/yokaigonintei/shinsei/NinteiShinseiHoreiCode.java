package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請区分（法令）コードを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum NinteiShinseiHoreiCode {

    /**
     * コード:1 名称:新規申請 略称:新規
     */
    新規申請("1", "新規申請", "新規"),
    /**
     * コード:2 名称:更新申請 略称:更新
     */
    更新申請("2", "更新申請", "更新"),
    /**
     * コード:3 名称:区分変更申請 略称:区変
     */
    区分変更申請("3", "区分変更申請", "区変"),
    /**
     * コード:4 名称:職権 略称:職権
     */
    職権("4", "職権", "職権");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private NinteiShinseiHoreiCode(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
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
     * 申請区分（法令）コードの略称を返します。
     *
     * @return 申請区分（法令）コードの略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 申請区分（法令）コードのコードと一致する内容を探します。
     *
     * @param code 申請区分（法令）コードのコード
     * @return {@code code} に対応する申請区分（法令）コード
     */
    public static NinteiShinseiHoreiCode toValue(RString code) {
        if (code == null || code.isEmpty()) {
            return null;
        }
        for (NinteiShinseiHoreiCode ninteiShinseiHoreiCode : NinteiShinseiHoreiCode.values()) {
            if (ninteiShinseiHoreiCode.code.equals(code)) {
                return ninteiShinseiHoreiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請区分（法令）コード"));
    }
}
