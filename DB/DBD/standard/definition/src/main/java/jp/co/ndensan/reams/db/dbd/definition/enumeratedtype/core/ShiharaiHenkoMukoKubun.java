package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更無効区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShiharaiHenkoMukoKubun {

    /**
     * コード:0 名称:有効 略称:定義なし
     */
    有効("0", "有効"),
    /**
     * コード:1 名称:無効 略称:定義なし
     */
    無効("1", "無効");

    private final RString code;
    private final RString fullName;

    private ShiharaiHenkoMukoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法変更無効区分のコードを返します。
     *
     * @return 支払方法変更無効区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法変更無効区分の名称を返します。
     *
     * @return 支払方法変更無効区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法変更無効区分のコードと一致する内容を探します。
     *
     * @param code 支払方法変更無効区分のコード
     * @return {@code code} に対応する支払方法変更無効区分
     */
    public static ShiharaiHenkoMukoKubun toValue(RString code) {

        for (ShiharaiHenkoMukoKubun shiharaiHenkoMukoKubun : ShiharaiHenkoMukoKubun.values()) {
            if (shiharaiHenkoMukoKubun.code.equals(code)) {
                return shiharaiHenkoMukoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更無効区分"));
    }
}
