package jp.co.ndensan.reams.db.dbc.definition.core.keiyakushurui;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受領委任契約種類を表す列挙型です。
 *
 * @author LDNS
 */
public enum JuryoIninKeiyakuShurui {

    /**
     * コード:01 名称:住宅改修 略称:定義なし
     */
    住宅改修("01", "住宅改修"),
    /**
     * コード:02 名称:福祉用具 略称:定義なし
     */
    福祉用具("02", "福祉用具"),
    /**
     * コード:03 名称:住宅改修／福祉用具 略称:定義なし
     */
    住宅改修_福祉用具("03", "住宅改修／福祉用具"),
    /**
     * コード:11 名称:償還払給付 略称:定義なし
     */
    償還払給付("11", "償還払給付"),
    /**
     * コード:21 名称:高額給付費 略称:定義なし
     */
    高額給付費("21", "高額給付費");

    private final RString code;
    private final RString fullName;

    private JuryoIninKeiyakuShurui(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受領委任契約種類のコードを返します。
     *
     * @return 受領委任契約種類のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受領委任契約種類の名称を返します。
     *
     * @return 受領委任契約種類の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受領委任契約種類のコードと一致する内容を探します。
     *
     * @param code 受領委任契約種類のコード
     * @return {@code code} に対応する受領委任契約種類
     */
    public static JuryoIninKeiyakuShurui toValue(RString code) {

        for (JuryoIninKeiyakuShurui juryoIninKeiyakuShurui : JuryoIninKeiyakuShurui.values()) {
            if (juryoIninKeiyakuShurui.code.equals(code)) {
                return juryoIninKeiyakuShurui;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("受領委任契約種類のコード"));
    }
}
