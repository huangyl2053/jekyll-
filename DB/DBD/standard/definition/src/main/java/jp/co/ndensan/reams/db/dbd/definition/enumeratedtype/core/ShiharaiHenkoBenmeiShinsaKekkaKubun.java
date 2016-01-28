package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更弁明審査結果区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShiharaiHenkoBenmeiShinsaKekkaKubun {

    /**
     * コード:1 名称:申請受理 略称:定義なし
     */
    申請受理("1", "申請受理"),
    /**
     * コード:2 名称:申請却下 略称:定義なし
     */
    申請却下("2", "申請却下");

    private final RString code;
    private final RString fullName;

    private ShiharaiHenkoBenmeiShinsaKekkaKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法変更弁明審査結果区分のコードを返します。
     *
     * @return 支払方法変更弁明審査結果区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法変更弁明審査結果区分の名称を返します。
     *
     * @return 支払方法変更弁明審査結果区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法変更弁明審査結果区分のコードと一致する内容を探します。
     *
     * @param code 支払方法変更弁明審査結果区分のコード
     * @return {@code code} に対応する支払方法変更弁明審査結果区分
     */
    public static ShiharaiHenkoBenmeiShinsaKekkaKubun toValue(RString code) {

        for (ShiharaiHenkoBenmeiShinsaKekkaKubun value : ShiharaiHenkoBenmeiShinsaKekkaKubun.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更弁明審査結果区分"));
    }
}
