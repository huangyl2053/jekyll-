package jp.co.ndensan.reams.db.dbc.definition.batchprm.hanyolist.kogaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請区分を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum ShinseiKubun {

    /**
     * コード:0 名称:すべて 略称:定義なし
     */
    すべて("0", "すべて"),
    /**
     * コード:1 名称:申請請求分 略称:定義なし
     */
    申請請求分("1", "申請請求分"),
    /**
     * コード:2 名称:自動償還分 略称:定義なし
     */
    自動償還分("2", "自動償還分");

    private final RString code;
    private final RString fullName;

    private ShinseiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 申請区分のコードを返します。
     *
     * @return 申請区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 申請区分の名称を返します。
     *
     * @return 申請区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申請区分のコードと一致する内容を探します。
     *
     * @param code 申請区分のコード
     * @return {@code code} に対応する申請区分
     */
    public static ShinseiKubun toValue(RString code) {
        for (ShinseiKubun shinseiKubun : ShinseiKubun.values()) {
            if (shinseiKubun.code.equals(code)) {
                return shinseiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請区分"));
    }
}
