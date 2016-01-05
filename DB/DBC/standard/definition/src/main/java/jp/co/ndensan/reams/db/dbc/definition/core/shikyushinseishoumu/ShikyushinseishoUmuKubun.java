package jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishoumu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支給申請書有無区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShikyushinseishoUmuKubun {

    /**
     * コード:0 名称:申請無し 略称:定義なし
     */
    申請無し("0", "申請無し"),
    /**
     * コード:1 名称:申請有り 略称:定義なし
     */
    申請有り("1", "申請有り");

    private final RString code;
    private final RString fullName;

    private ShikyushinseishoUmuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支給申請書有無区分のコードを返します。
     *
     * @return 支給申請書有無区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支給申請書有無区分の名称を返します。
     *
     * @return 支給申請書有無区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支給申請書有無区分のコードと一致する内容を探します。
     *
     * @param code 支給申請書有無区分のコード
     * @return {@code code} に対応する支給申請書有無区分
     */
    public static ShikyushinseishoUmuKubun toValue(RString code) {

        for (ShikyushinseishoUmuKubun shikyushinseishoUmuKubun : ShikyushinseishoUmuKubun.values()) {
            if (shikyushinseishoUmuKubun.code.equals(code)) {
                return shikyushinseishoUmuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支給申請書有無区分"));
    }
}
