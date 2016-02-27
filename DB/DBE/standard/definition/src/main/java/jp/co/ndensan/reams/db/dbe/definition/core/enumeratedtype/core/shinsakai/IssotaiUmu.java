package jp.co.ndensan.reams.db.dbe.definition.core.enumeratedtype.core.shinsakai;

//import jp.co.ndensan.reams.dc.dca.definition.enumeratedtype.message.DcErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 委員早退有無を表す列挙型です。
 *
 * @author LDNS 作成者漢字名
 */
public enum IssotaiUmu {

    /**
     * コード:True 名称:早退 略称:定義なし
     */
    早退(true, "早退"),
    /**
     * コード:False 名称:早退なし 略称:定義なし
     */
    早退なし(false, "早退なし");

    private final boolean code;
    private final RString fullName;

    private IssotaiUmu(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 委員早退有無のコードを返します。
     *
     * @return 委員早退有無のコード
     */
    public boolean is早退() {
        return code;
    }

    /**
     * 委員早退有無の名称を返します。
     *
     * @return 委員早退有無の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 委員早退有無のコードと一致する内容を探します。
     *
     * @param code 委員早退有無のコード
     * @return {@code code} に対応する委員早退有無
     */
    public static IssotaiUmu toValue(boolean code) {
        for (IssotaiUmu issotaiUmu : IssotaiUmu.values()) {
            if (issotaiUmu.code == code) {
                return issotaiUmu;
            }
        }
//        throw new IllegalArgumentException(DcErrorMessages.E09002.getMessage().getMessage());
        return null;
    }
}
