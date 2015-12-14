package jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 徴収方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum ChoshuHoho {

    /**
     * コード:0 名称:資格なし 略称:定義なし
     */
    資格なし("0", "資格なし"),
    /**
     * コード:1 名称:特別徴収_厚生労働省 略称:定義なし
     */
    特別徴収_厚生労働省("1", "特別徴収_厚生労働省"),
    /**
     * コード:2 名称:特別徴収_地共済 略称:定義なし
     */
    特別徴収_地共済("2", "特別徴収_地共済"),
    /**
     * コード:3 名称:普通徴収 略称:定義なし
     */
    普通徴収("3", "普通徴収");

    private final RString code;
    private final RString fullName;

    private ChoshuHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 徴収方法のコードを返します。
     *
     * @return 徴収方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 徴収方法の名称を返します。
     *
     * @return 徴収方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 徴収方法のコードと一致する内容を探します。
     *
     * @param code 徴収方法のコード
     * @return {@code code} に対応する徴収方法
     */
    public static ChoshuHoho toValue(RString code) {
        for (ChoshuHoho choshuHoho : ChoshuHoho.values()) {
            if (choshuHoho.code.equals(code)) {
                return choshuHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("徴収方法"));
    }
}
