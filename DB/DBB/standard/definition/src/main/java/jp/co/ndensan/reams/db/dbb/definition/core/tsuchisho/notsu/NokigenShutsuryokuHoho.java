package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納期限出力方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum NokigenShutsuryokuHoho {

    /**
     * コード:0 名称:対象の期 略称:納付書の対象となっている期を全て印字する
     */
    納付書の対象となっている期を全て印字する("0", "対象の期", "納付書の対象となっている期を全て印字する"),
    /**
     * コード:1 名称:全ての期 略称:全ての期分を印字する
     */
    全ての期分を印字する("1", "全ての期", "全ての期分を印字する");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private NokigenShutsuryokuHoho(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
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
     * 納期限出力方法の略称を返します。
     *
     * @return 納期限出力方法の略称
     */
    public RString get略称() {
        return shortName;
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
