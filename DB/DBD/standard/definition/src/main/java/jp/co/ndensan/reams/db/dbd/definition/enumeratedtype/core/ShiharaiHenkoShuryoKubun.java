package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 支払方法変更終了区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum ShiharaiHenkoShuryoKubun {

    /**
     * コード:01 名称:差止措置終了依頼書受理 略称:定義なし
     */
    差止措置終了依頼書受理("01", "差止措置終了依頼書受理"),
    /**
     * コード:02 名称:弁明書受理 略称:定義なし
     */
    弁明書受理("02", "弁明書受理"),
    /**
     * コード:03 名称:終了申請書受理 略称:定義なし
     */
    終了申請書受理("03", "終了申請書受理"),
    /**
     * コード:04 名称:減額免除申請書受理 略称:定義なし
     */
    減額免除申請書受理("04", "減額免除申請書受理"),
    /**
     * コード:98 名称:職権 略称:定義なし
     */
    職権("98", "職権"),
    /**
     * コード:99 名称:その他 略称:定義なし
     */
    その他("99", "その他");

    private final RString code;
    private final RString fullName;

    private ShiharaiHenkoShuryoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 支払方法変更終了区分のコードを返します。
     *
     * @return 支払方法変更終了区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 支払方法変更終了区分の名称を返します。
     *
     * @return 支払方法変更終了区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 支払方法変更終了区分のコードと一致する内容を探します。
     *
     * @param code 支払方法変更終了区分のコード
     * @return {@code code} に対応する支払方法変更終了区分
     */
    public static ShiharaiHenkoShuryoKubun toValue(RString code) {

        for (ShiharaiHenkoShuryoKubun shiharaiHenkoShuryoKubun : ShiharaiHenkoShuryoKubun.values()) {
            if (shiharaiHenkoShuryoKubun.code.equals(code)) {
                return shiharaiHenkoShuryoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("支払方法変更終了区分"));
    }
}
