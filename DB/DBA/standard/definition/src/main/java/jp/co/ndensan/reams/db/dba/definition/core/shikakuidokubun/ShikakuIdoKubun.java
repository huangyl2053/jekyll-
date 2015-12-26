package jp.co.ndensan.reams.db.dba.definition.core.shikakuidokubun;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格異動区分を表す列挙型です。
 *
 */
public enum ShikakuIdoKubun {

    /**
     * コード:1 名称:資格取得 略称:定義なし
     */
    資格取得("1", "資格取得"),
    /**
     * コード:2 名称:資格変更 略称:定義なし
     */
    資格変更("2", "資格変更"),
    /**
     * コード:3 名称:資格喪失 略称:定義なし
     */
    資格喪失("3", "資格喪失");

    private final RString code;
    private final RString fullName;

    private ShikakuIdoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 資格異動区分のコードを返します。
     *
     * @return 資格異動区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格異動区分の名称を返します。
     *
     * @return 資格異動区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格異動区分のコードと一致する内容を探します。
     *
     * @param code 資格異動区分のコード
     * @return {@code code} に対応する資格異動区分
     */
    public static ShikakuIdoKubun toValue(RString code) {
        for (ShikakuIdoKubun shikakuIdoKubun : ShikakuIdoKubun.values()) {
            if (shikakuIdoKubun.code.equals(code)) {
                return shikakuIdoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格異動区分"));
    }
}
