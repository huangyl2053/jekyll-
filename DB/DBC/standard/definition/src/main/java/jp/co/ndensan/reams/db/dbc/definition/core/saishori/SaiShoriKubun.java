package jp.co.ndensan.reams.db.dbc.definition.core.saishori;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 再処理区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum SaiShoriKubun {

    /**
     * コード:0 名称:空白 略称:定義なし
     */
    空白("0", " "),
    /**
     * コード:1 名称:再処理 略称:定義なし
     */
    再処理("1", "再処理");

    private final RString code;
    private final RString fullName;

    private SaiShoriKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 再処理区分のコードを返します。
     *
     * @return 再処理区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 再処理区分の名称を返します。
     *
     * @return 再処理区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 再処理区分のコードと一致する内容を探します。
     *
     * @param code 再処理区分のコード
     * @return {@code code} に対応する再処理区分
     */
    public static SaiShoriKubun toValue(RString code) {

        for (SaiShoriKubun saiShoriKubun : SaiShoriKubun.values()) {
            if (saiShoriKubun.code.equals(code)) {
                return saiShoriKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("再処理区分"));
    }
}
