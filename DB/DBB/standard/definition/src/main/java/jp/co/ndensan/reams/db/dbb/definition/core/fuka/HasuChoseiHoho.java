package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 端数調整方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum HasuChoseiHoho {

    /**
     * コード:1 名称:切上げ 略称:定義なし
     */
    切上げ("1", "切上げ"),
    /**
     * コード:2 名称:切捨て 略称:定義なし
     */
    切捨て("2", "切捨て"),
    /**
     * コード:3 名称:四捨五入 略称:定義なし
     */
    四捨五入("3", "四捨五入");

    private final RString code;
    private final RString fullName;

    private HasuChoseiHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 端数調整方法のコードを返します。
     *
     * @return 端数調整方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 端数調整方法の名称を返します。
     *
     * @return 端数調整方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 端数調整方法のコードと一致する内容を探します。
     *
     * @param code 端数調整方法のコード
     * @return {@code code} に対応する端数調整方法
     */
    public static HasuChoseiHoho toValue(RString code) {
        for (HasuChoseiHoho hasuChoseiHoho : HasuChoseiHoho.values()) {
            if (hasuChoseiHoho.code.equals(code)) {
                return hasuChoseiHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("端数調整方法"));
    }
}
