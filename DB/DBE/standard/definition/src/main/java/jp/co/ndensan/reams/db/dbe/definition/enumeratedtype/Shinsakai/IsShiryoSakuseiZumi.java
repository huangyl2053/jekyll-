package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 資料作成済区分を表す列挙型です。
 *
 * @author LDNS
 */
public enum IsShiryoSakuseiZumi {

    /**
     * コード:True 名称:作成済 略称:定義なし
     */
    作成済(true, "作成済"),
    /**
     * コード:False 名称:未作成 略称:定義なし
     */
    未作成(false, "未作成");

    private final boolean code;
    private final RString fullName;

    private IsShiryoSakuseiZumi(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 資料作成済区分のコードを返します。
     *
     * @return 資料作成済区分のコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 資料作成済区分の名称を返します。
     *
     * @return 資料作成済区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 資料作成済区分のコードと一致する内容を探します。
     *
     * @param code 資料作成済区分のコード
     * @return {@code code} に対応する資料作成済区分
     */
    public static IsShiryoSakuseiZumi toValue(boolean code) {
        for (IsShiryoSakuseiZumi isShiryoSakuseiZumi : IsShiryoSakuseiZumi.values()) {
            if (isShiryoSakuseiZumi.code == code) {
                return isShiryoSakuseiZumi;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("資料作成済区分"));
    }
}
