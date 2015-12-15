package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * カスタマバーコード使用有無を表す列挙型です。
 *
 * @author LDNS
 */
public enum CustomerBarcodeShiyoUmu {

    /**
     * コード:0 名称:使用しない 略称:定義なし
     */
    使用しない("0", "使用しない"),
    /**
     * コード:1 名称:使用する 略称:定義なし
     */
    使用する("1", "使用する");

    private final RString code;
    private final RString fullName;

    private CustomerBarcodeShiyoUmu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * カスタマバーコード使用有無のコードを返します。
     *
     * @return カスタマバーコード使用有無のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * カスタマバーコード使用有無の名称を返します。
     *
     * @return カスタマバーコード使用有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * カスタマバーコード使用有無のコードと一致する内容を探します。
     *
     * @param code カスタマバーコード使用有無のコード
     * @return {@code code} に対応するカスタマバーコード使用有無
     */
    public static CustomerBarcodeShiyoUmu toValue(RString code) {

        for (CustomerBarcodeShiyoUmu customerBarcodeShiyoUmu : CustomerBarcodeShiyoUmu.values()) {
            if (customerBarcodeShiyoUmu.code.equals(code)) {
                return customerBarcodeShiyoUmu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("カスタマバーコード使用有無"));
    }
}
