package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 端数調整単位を表す列挙型です。
 *
 * @author LDNS
 */
public enum HasuChoseiTani {

    /**
     * コード:1 名称:_1 略称:1
     */
    _1("1", "_1", "1"),
    /**
     * コード:10 名称:_10 略称:10
     */
    _10("10", "_10", "10"),
    /**
     * コード:100 名称:_100 略称:100
     */
    _100("100", "_100", "100"),
    /**
     * コード:1000 名称:_1000 略称:1,000
     */
    _1000("1000", "_1000", "1,000");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private HasuChoseiTani(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 端数調整単位のコードを返します。
     *
     * @return 端数調整単位のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 端数調整単位の名称を返します。
     *
     * @return 端数調整単位の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 端数調整単位の略称を返します。
     *
     * @return 端数調整単位の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 端数調整単位のコードと一致する内容を探します。
     *
     * @param code 端数調整単位のコード
     * @return {@code code} に対応する端数調整単位
     */
    public static HasuChoseiTani toValue(RString code) {
        for (HasuChoseiTani hasuChoseiTani : HasuChoseiTani.values()) {
            if (hasuChoseiTani.code.equals(code)) {
                return hasuChoseiTani;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("端数調整単位"));
    }
}
