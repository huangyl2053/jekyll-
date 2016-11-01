package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴依頼金額計算方法4月を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum TokuchoIraikingakuKeisanHoho4Gatsu {

    /**
     * コード:1 名称:年額÷12Ｘ仮徴収月数÷年金支給回数 略称:定義なし
     */
    法定計算方法_6で割る("1", "年額÷12Ｘ仮徴収月数÷年金支給回数");

    private final RString code;
    private final RString fullName;

    private TokuchoIraikingakuKeisanHoho4Gatsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特徴依頼金額計算方法4月のコードを返します。
     *
     * @return 特徴依頼金額計算方法4月のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴依頼金額計算方法4月の名称を返します。
     *
     * @return 特徴依頼金額計算方法4月の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴依頼金額計算方法4月のコードと一致する内容を探します。
     *
     * @param code 特徴依頼金額計算方法4月のコード
     * @return {@code code} に対応する特徴依頼金額計算方法4月
     */
    public static TokuchoIraikingakuKeisanHoho4Gatsu toValue(RString code) {
        for (TokuchoIraikingakuKeisanHoho4Gatsu value : TokuchoIraikingakuKeisanHoho4Gatsu.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴依頼金額計算方法4月"));
    }
}
