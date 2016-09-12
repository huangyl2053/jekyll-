package jp.co.ndensan.reams.db.dbc.definition.core.kokuhorenif;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資格照合表警告種別を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum ShikakuShogohyoKeikokuShubetsu {

    /**
     * コード:サ 名称:サービス計画費請求明細書 略称:定義なし
     */
    サービス計画費請求明細書("サ", "サービス計画費請求明細書"),
    /**
     * コード:請 名称:請求明細書 略称:定義なし
     */
    請求明細書("請", "請求明細書"),
    /**
     * コード:給 名称:給付管理票 略称:定義なし
     */
    給付管理票("給", "給付管理票"),
    /**
     * コード:ケ 名称:介護予防ケアマネジメント費請求明細書 略称:定義なし
     */
    介護予防ケアマネジメント費請求明細書("ケ", "介護予防ケアマネジメント費請求明細書");

    private final RString code;
    private final RString fullName;

    private ShikakuShogohyoKeikokuShubetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 資格照合表警告種別のコードを返します。
     *
     * @return 資格照合表警告種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 資格照合表警告種別の名称を返します。
     *
     * @return 資格照合表警告種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資格照合表警告種別のコードと一致する内容を探します。
     *
     * @param code 資格照合表警告種別のコード
     * @return {@code code} に対応する資格照合表警告種別
     */
    public static ShikakuShogohyoKeikokuShubetsu toValue(RString code) {
        for (ShikakuShogohyoKeikokuShubetsu value : ShikakuShogohyoKeikokuShubetsu.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資格照合表警告種別"));
    }
}
