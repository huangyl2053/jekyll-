package jp.co.ndensan.reams.db.dbz.business.report.hakkorireki;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 業務固有情報を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum GyomuKoyuJoho {

    /**
     * コード:DBZ001 名称:被保番号 略称:定義なし
     */
    被保番号("DBZ001", "被保番号"),
    /**
     * コード:DBD002 名称:減免適用開始日 略称:定義なし
     */
    減免適用開始日("DBD002", "減免適用開始日");

    private final RString code;
    private final RString fullName;

    private GyomuKoyuJoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 業務固有情報のコードを返します。
     *
     * @return 業務固有情報のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 業務固有情報の名称を返します。
     *
     * @return 業務固有情報の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 業務固有情報のコードと一致する内容を探します。
     *
     * @param code 業務固有情報のコード
     * @return {@code code} に対応する業務固有情報
     */
    public static GyomuKoyuJoho toValue(RString code) {
        for (GyomuKoyuJoho gyomuKoyuJoho : GyomuKoyuJoho.values()) {
            if (gyomuKoyuJoho.code.equals(code)) {
                return gyomuKoyuJoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("業務固有情報"));
    }
}
