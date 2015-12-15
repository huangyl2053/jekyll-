package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格取得前申請区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShikakuShutokuMaeShinseiKubun {

    /**
     * コード:True 名称:資格取得前申請 略称:定義なし
     */
    資格取得前申請(true, "資格取得前申請"),
    /**
     * コード:False 名称:資格取得前申請以外 略称:定義なし
     */
    資格取得前申請以外(false, "資格取得前申請以外");

    private final boolean code;
    private final RString fullName;

    private ShikakuShutokuMaeShinseiKubun(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 資格取得前申請区分のコードを返します。
     *
     * @return 資格取得前申請区分のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 資格取得前申請区分の名称を返します。
     *
     * @return 資格取得前申請区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格取得前申請区分のコードと一致する内容を探します。
     *
     * @param code 資格取得前申請区分のコード
     * @return {@code code} に対応する資格取得前申請区分
     */
    public static ShikakuShutokuMaeShinseiKubun toValue(boolean code) {

        for (ShikakuShutokuMaeShinseiKubun shikakuShutokuMaeShinseiKubun : ShikakuShutokuMaeShinseiKubun.values()) {
            if (shikakuShutokuMaeShinseiKubun.code == code) {
                return shikakuShutokuMaeShinseiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格取得前申請区分"));
    }
}
