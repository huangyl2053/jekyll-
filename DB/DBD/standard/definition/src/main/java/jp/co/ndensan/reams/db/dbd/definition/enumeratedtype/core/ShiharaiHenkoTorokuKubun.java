package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更登録区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShiharaiHenkoTorokuKubun {

    /**
     * コード:01 名称:２号予告登録者 略称:定義なし
     */
    _２号予告登録者("01", "２号予告登録者"),
    /**
     * コード:02 名称:２号差止登録 略称:定義なし
     */
    _２号差止登録("02", "２号差止登録"),
    /**
     * コード:11 名称:１号予告登録者 略称:定義なし
     */
    _１号予告登録者("11", "１号予告登録者"),
    /**
     * コード:12 名称:１号償還払い化登録 略称:定義なし
     */
    _１号償還払い化登録("12", "１号償還払い化登録"),
    /**
     * コード:21 名称:１号給付額減額登録 略称:定義なし
     */
    _１号給付額減額登録("21", "１号給付額減額登録");

    private final RString code;
    private final RString fullName;

    private ShiharaiHenkoTorokuKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法変更登録区分のコードを返します。
     *
     * @return 支払方法変更登録区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法変更登録区分の名称を返します。
     *
     * @return 支払方法変更登録区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法変更登録区分のコードと一致する内容を探します。
     *
     * @param code 支払方法変更登録区分のコード
     * @return {@code code} に対応する支払方法変更登録区分
     */
    public static ShiharaiHenkoTorokuKubun toValue(RString code) {

        for (ShiharaiHenkoTorokuKubun shiharaiHenkoTorokuKubun : ShiharaiHenkoTorokuKubun.values()) {
            if (shiharaiHenkoTorokuKubun.code.equals(code)) {
                return shiharaiHenkoTorokuKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更登録区分"));
    }
}
