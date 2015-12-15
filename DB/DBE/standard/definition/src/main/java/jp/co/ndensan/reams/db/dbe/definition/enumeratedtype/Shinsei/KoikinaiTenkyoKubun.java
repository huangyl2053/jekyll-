package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsei;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 広域内転居区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum KoikinaiTenkyoKubun {

    /**
     * コード:0 名称:対象外 略称:定義なし
     */
    対象外("0", "対象外"),
    /**
     * コード:1 名称:申請中 略称:定義なし
     */
    申請中("1", "申請中"),
    /**
     * コード:2 名称:申請終了 略称:定義なし
     */
    申請終了("2", "申請終了");

    private final RString code;
    private final RString fullName;

    private KoikinaiTenkyoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 広域内転居区分のコードを返します。
     *
     * @return 広域内転居区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 広域内転居区分の名称を返します。
     *
     * @return 広域内転居区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 広域内転居区分のコードと一致する内容を探します。
     *
     * @param code 広域内転居区分のコード
     * @return {@code code} に対応する広域内転居区分
     */
    public static KoikinaiTenkyoKubun toValue(RString code) {

        for (KoikinaiTenkyoKubun koikinaiTenkyoKubun : KoikinaiTenkyoKubun.values()) {
            if (koikinaiTenkyoKubun.code.equals(code)) {
                return koikinaiTenkyoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("広域内転居区分"));
    }
}
