package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 申請状況区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShinseiJokyoKubun {

    /**
     * コード:0 名称:申請中 略称:定義なし
     */
    申請中("0", "申請中"),
    /**
     * コード:1 名称:認定完了 略称:定義なし
     */
    認定完了("1", "認定完了");

    private final RString code;
    private final RString fullName;

    private ShinseiJokyoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 申請状況区分のコードを返します。
     *
     * @return 申請状況区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 申請状況区分の名称を返します。
     *
     * @return 申請状況区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 申請状況区分のコードと一致する内容を探します。
     *
     * @param code 申請状況区分のコード
     * @return {@code code} に対応する申請状況区分
     */
    public static ShinseiJokyoKubun toValue(RString code) {

        for (ShinseiJokyoKubun shinseiJokyoKubun : ShinseiJokyoKubun.values()) {
            if (shinseiJokyoKubun.code.equals(code)) {
                return shinseiJokyoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("申請状況区分"));
    }
}
