package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普通徴収切替計算方法を表す列挙型です。
 *
 * @author LDNS
 */
public enum FutsuChoshuKirikaeKeisanHoho {

    /**
     * コード:00 名称:重複させない 略称:定義なし
     */
    重複させない("00", "重複させない"),
    /**
     * コード:01 名称:重複させる 略称:定義なし
     */
    重複させる("01", "重複させる"),
    /**
     * コード:99 名称:指定期以降重複させる 略称:定義なし
     */
    指定期以降重複させる("99", "指定期以降重複させる");

    private final RString code;
    private final RString fullName;

    private FutsuChoshuKirikaeKeisanHoho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 普通徴収切替計算方法のコードを返します。
     *
     * @return 普通徴収切替計算方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 普通徴収切替計算方法の名称を返します。
     *
     * @return 普通徴収切替計算方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 普通徴収切替計算方法のコードと一致する内容を探します。
     *
     * @param code 普通徴収切替計算方法のコード
     * @return {@code code} に対応する普通徴収切替計算方法
     */
    public static FutsuChoshuKirikaeKeisanHoho toValue(RString code) {
        for (FutsuChoshuKirikaeKeisanHoho futsuChoshuKirikaeKeisanHoho : FutsuChoshuKirikaeKeisanHoho.values()) {
            if (futsuChoshuKirikaeKeisanHoho.code.equals(code)) {
                return futsuChoshuKirikaeKeisanHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("普通徴収切替計算方法"));
    }
}
