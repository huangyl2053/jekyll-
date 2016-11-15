package jp.co.ndensan.reams.db.dbc.definition.core.kyusochisha;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 旧措置入所者特例コードを表す列挙型です。
 *
 * @reamsid_L DBC-9999-023 liangbc
 */
public enum KyuSochiNyushoshaTokureiCode {

    /**
     * コード:1 名称:無し 略称:定義なし
     */
    無し("0", "無し"),
    /**
     * コード:2 名称:有り 略称:定義なし
     */
    有り("1", "有り");

    private final RString code;
    private final RString fullName;

    private KyuSochiNyushoshaTokureiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 旧措置入所者特例コードのコードを返します。
     *
     * @return 旧措置入所者特例コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 旧措置入所者特例コードの名称を返します。
     *
     * @return 旧措置入所者特例コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 旧措置入所者特例コードのコードと一致する内容を探します。
     *
     * @param code 旧措置入所者特例コードのコード
     * @return {@code code} に対応する旧措置入所者特例コード
     */
    public static KyuSochiNyushoshaTokureiCode toValue(RString code) {

        for (KyuSochiNyushoshaTokureiCode kyuSochiNyushoshaTokureiCode : KyuSochiNyushoshaTokureiCode.values()) {
            if (kyuSochiNyushoshaTokureiCode.code.equals(code)) {
                return kyuSochiNyushoshaTokureiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("旧措置入所者特例コード"));
    }
}
