package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座対象者出力を表す列挙型です。
 *
 * @author LDNS
 */
public enum KozaTaishoshaSyutsuryoku {

    /**
     * コード:1 名称:出力する 略称:する
     */
    する("1", "出力する", "する"),
    /**
     * コード:2 名称:出力しない 略称:しない
     */
    しない("2", "出力しない", "しない");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private KozaTaishoshaSyutsuryoku(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 口座対象者出力のコードを返します。
     *
     * @return 口座対象者出力のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 口座対象者出力の名称を返します。
     *
     * @return 口座対象者出力の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 口座対象者出力の略称を返します。
     *
     * @return 口座対象者出力の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 口座対象者出力のコードと一致する内容を探します。
     *
     * @param code 口座対象者出力のコード
     * @return {@code code} に対応する口座対象者出力
     */
    public static KozaTaishoshaSyutsuryoku toValue(RString code) {
        for (KozaTaishoshaSyutsuryoku kozaTaishoshaSyutsuryoku : KozaTaishoshaSyutsuryoku.values()) {
            if (kozaTaishoshaSyutsuryoku.code.equals(code)) {
                return kozaTaishoshaSyutsuryoku;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("口座対象者出力"));
    }
}
