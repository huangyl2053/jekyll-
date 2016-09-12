package jp.co.ndensan.reams.db.dbc.definition.core.kogakukaigoservice;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 高額介護サービス費自動償還を表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 wangchao
 */
public enum JidoShokanTaishoKubun {

    /**
     * コード:0 名称:なし 略称:無
     */
    なし("0", "なし"),
    /**
     * コード:1 名称:あり 略称:無
     */
    あり("1", "あり");

    private final RString code;
    private final RString fullName;

    private JidoShokanTaishoKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 高額介護サービス費自動償還のコードを返します。
     *
     * @return 高額介護サービス費自動償還のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 高額介護サービス費自動償還の名称を返します。
     *
     * @return 高額介護サービス費自動償還の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 高額介護サービス費自動償還のコードと一致する内容を探します。
     *
     * @param code 高額介護サービス費自動償還のコード
     * @return {@code code} に対応する高額介護サービス費自動償還
     */
    public static JidoShokanTaishoKubun toValue(RString code) {
        for (JidoShokanTaishoKubun jidoShokanTaishoKubun : JidoShokanTaishoKubun.values()) {
            if (jidoShokanTaishoKubun.code.equals(code)) {
                return jidoShokanTaishoKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("高額介護サービス費自動償還"));
    }
}
