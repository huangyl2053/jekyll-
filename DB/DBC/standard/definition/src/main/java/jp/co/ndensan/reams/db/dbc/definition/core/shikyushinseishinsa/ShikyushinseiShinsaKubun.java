package jp.co.ndensan.reams.db.dbc.definition.core.shikyushinseishinsa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支給申請審査区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShikyushinseiShinsaKubun {

    /**
     * コード:1 名称:未審査 略称:定義なし
     */
    未審査("1", "未審査"),
    /**
     * コード:2 名称:審査済 略称:定義なし
     */
    審査済("2", "審査済");

    private final RString code;
    private final RString fullName;

    private ShikyushinseiShinsaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支給申請審査区分のコードを返します。
     *
     * @return 支給申請審査区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支給申請審査区分の名称を返します。
     *
     * @return 支給申請審査区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支給申請審査区分のコードと一致する内容を探します。
     *
     * @param code 支給申請審査区分のコード
     * @return {@code code} に対応する支給申請審査区分
     */
    public static ShikyushinseiShinsaKubun toValue(RString code) {

        for (ShikyushinseiShinsaKubun shikyushinseiShinsaKubun : ShikyushinseiShinsaKubun.values()) {
            if (shikyushinseiShinsaKubun.code.equals(code)) {
                return shikyushinseiShinsaKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支給申請審査区分"));
    }
}
