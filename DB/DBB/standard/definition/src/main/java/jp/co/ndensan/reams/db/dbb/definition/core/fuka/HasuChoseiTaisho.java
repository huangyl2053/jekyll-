package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 端数調整対象を表す列挙型です。
 *
 * @author LDNS
 */
public enum HasuChoseiTaisho {

    /**
     * コード:1 名称:標準 略称:定義なし
     */
    標準("1", "標準"),
    /**
     * コード:2 名称:全件 略称:定義なし
     */
    全件("2", "全件");

    private final RString code;
    private final RString fullName;

    private HasuChoseiTaisho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 端数調整対象のコードを返します。
     *
     * @return 端数調整対象のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 端数調整対象の名称を返します。
     *
     * @return 端数調整対象の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 端数調整対象のコードと一致する内容を探します。
     *
     * @param code 端数調整対象のコード
     * @return {@code code} に対応する端数調整対象
     */
    public static HasuChoseiTaisho toValue(RString code) {
        for (HasuChoseiTaisho hasuChoseiTaisho : HasuChoseiTaisho.values()) {
            if (hasuChoseiTaisho.code.equals(code)) {
                return hasuChoseiTaisho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("端数調整対象"));
    }
}
