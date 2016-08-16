/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 被保険者区分コードを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum HihokenshaKubunCode {

    /**
     * コード:1 名称:第１号被保険者 略称:1号
     */
    第１号被保険者("1", "第１号被保険者", "1号"),
    /**
     * コード:2 名称:第２号被保険者 略称:1号
     */
    第２号被保険者("2", "第２号被保険者", "1号"),
    /**
     * コード:8 名称:生活保護 略称:生保
     */
    生活保護("8", "生活保護", "生保"),
    /**
     * コード:3 名称:その他 略称:他
     */
    その他("9", "その他", "他");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private HihokenshaKubunCode(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 被保険者区分コードのコードを返します。
     *
     * @return 被保険者区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 被保険者区分コードの名称を返します。
     *
     * @return 被保険者区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 被保険者区分コードの略称を返します。
     *
     * @return 被保険者区分コードの略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 被保険者区分コードのコードと一致する内容を探します。
     *
     * @param code 被保険者区分コードのコード
     * @return {@code code} に対応する被保険者区分コード
     */
    public static HihokenshaKubunCode toValue(RString code) {

        for (HihokenshaKubunCode hihokenshaKubunCode : HihokenshaKubunCode.values()) {
            if (hihokenshaKubunCode.code.equals(code)) {
                return hihokenshaKubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("被保険者区分コード"));
    }
}
