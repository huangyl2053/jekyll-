package jp.co.ndensan.reams.db.dbb.definition.core.tsuchisho.notsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 口座振替者出力様式を表す列挙型です。
 *
 * @author LDNS
 */
public enum KozaFurikaeOutputType {

    /**
     * コード:0 名称:現金用 略称:定義なし
     */
    現金用("0", "現金用"),
    /**
     * コード:1 名称:口座用 略称:定義なし
     */
    口座用("1", "口座用");

    private final RString code;
    private final RString fullName;

    private KozaFurikaeOutputType(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 口座振替者出力様式のコードを返します。
     *
     * @return 口座振替者出力様式のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 口座振替者出力様式の名称を返します。
     *
     * @return 口座振替者出力様式の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 口座振替者出力様式のコードと一致する内容を探します。
     *
     * @param code 口座振替者出力様式のコード
     * @return {@code code} に対応する口座振替者出力様式
     */
    public static KozaFurikaeOutputType toValue(RString code) {
        for (KozaFurikaeOutputType kozaFurikaeOutputType : KozaFurikaeOutputType.values()) {
            if (kozaFurikaeOutputType.code.equals(code)) {
                return kozaFurikaeOutputType;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("口座振替者出力様式"));
    }
}
