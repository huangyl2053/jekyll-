package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納期限出力方法を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum NokigenShutsuryokuHoho {

    /**
     * コード:0 名称:納付書の対象となっている期を全て印字する 略称:定義なし
     */
    対象の期("0", "納付書の対象となっている期を全て印字する"),
    /**
     * コード:1 名称:全ての期分を印字する 略称:定義なし
     */
    全ての期("1", "全ての期分を印字する");

    private final RString code;
    private final RString fullName;

    private NokigenShutsuryokuHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 納期限出力方法のコードを返します。
     *
     * @return 納期限出力方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 納期限出力方法の名称を返します。
     *
     * @return 納期限出力方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 納期限出力方法のコードと一致する内容を探します。
     *
     * @param code 納期限出力方法のコード
     * @return {@code code} に対応する納期限出力方法
     */
    public static NokigenShutsuryokuHoho toValue(RString code) {
        for (NokigenShutsuryokuHoho nokigenShutsuryokuHoho : NokigenShutsuryokuHoho.values()) {
            if (nokigenShutsuryokuHoho.code.equals(code)) {
                return nokigenShutsuryokuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("納期限出力方法"));
    }
}
