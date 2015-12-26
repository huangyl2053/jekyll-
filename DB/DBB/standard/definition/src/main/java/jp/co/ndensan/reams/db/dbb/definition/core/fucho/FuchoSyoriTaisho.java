package jp.co.ndensan.reams.db.dbb.definition.core.fucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴処理対象を表す列挙型です。
 *
 * @author LDNS
 */
public enum FuchoSyoriTaisho {

    /**
     * コード:1 名称:なし 略称:定義なし
     */
    なし("1", "なし"),
    /**
     * コード:2 名称:全件対象 略称:定義なし
     */
    全件対象("2", "全件対象"),
    /**
     * コード:3 名称:異動分のみ対象 略称:定義なし
     */
    異動分のみ対象("3", "異動分のみ対象");

    private final RString code;
    private final RString fullName;

    private FuchoSyoriTaisho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 普徴処理対象のコードを返します。
     *
     * @return 普徴処理対象のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 普徴処理対象の名称を返します。
     *
     * @return 普徴処理対象の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 普徴処理対象のコードと一致する内容を探します。
     *
     * @param code 普徴処理対象のコード
     * @return {@code code} に対応する普徴処理対象
     */
    public static FuchoSyoriTaisho toValue(RString code) {
        for (FuchoSyoriTaisho fuchoSyoriTaisho : FuchoSyoriTaisho.values()) {
            if (fuchoSyoriTaisho.code.equals(code)) {
                return fuchoSyoriTaisho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("普徴処理対象"));
    }
}
