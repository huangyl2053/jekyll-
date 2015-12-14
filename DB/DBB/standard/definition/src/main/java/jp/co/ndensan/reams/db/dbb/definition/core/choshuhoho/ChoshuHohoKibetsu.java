package jp.co.ndensan.reams.db.dbb.definition.core.choshuhoho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 徴収方法期別を表す列挙型です。
 *
 * @author LDNS
 */
public enum ChoshuHohoKibetsu {

    /**
     * コード:1 名称:特別徴収 略称:定義なし
     */
    特別徴収("1", "特別徴収"),
    /**
     * コード:2 名称:普通徴収 略称:定義なし
     */
    普通徴収("2", "普通徴収");

    private final RString code;
    private final RString fullName;

    private ChoshuHohoKibetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 徴収方法期別のコードを返します。
     *
     * @return 徴収方法期別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 徴収方法期別の名称を返します。
     *
     * @return 徴収方法期別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 徴収方法期別のコードと一致する内容を探します。
     *
     * @param code 徴収方法期別のコード
     * @return {@code code} に対応する徴収方法期別
     */
    public static ChoshuHohoKibetsu toValue(RString code) {
        for (ChoshuHohoKibetsu choshuHohoKibetsu : ChoshuHohoKibetsu.values()) {
            if (choshuHohoKibetsu.code.equals(code)) {
                return choshuHohoKibetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("徴収方法期別"));
    }
}
