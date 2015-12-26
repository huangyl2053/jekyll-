package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴依頼金額計算方法2月を表す列挙型です。
 *
 * @author LDNS
 */
public enum TokuchoIraikingakuKeisanHoho2Gatsu {

    /**
     * コード:1 名称:特徴開始月以降の普通徴収額 略称:特徴開始月以降の普通徴収額
     */
    特徴開始月以降の普通徴収額("1", "特徴開始月以降の普通徴収額", "特徴開始月以降の普通徴収額"),
    /**
     * コード:3 名称:法定計算方法_6で割る 略称:年額÷12Ｘ本徴収月数÷年金支給回数
     */
    年額除12乗本徴収月数除年金支給回数("3", "法定計算方法_6で割る", "年額÷12Ｘ本徴収月数÷年金支給回数");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private TokuchoIraikingakuKeisanHoho2Gatsu(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 特徴依頼金額計算方法2月のコードを返します。
     *
     * @return 特徴依頼金額計算方法2月のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴依頼金額計算方法2月の名称を返します。
     *
     * @return 特徴依頼金額計算方法2月の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴依頼金額計算方法2月の略称を返します。
     *
     * @return 特徴依頼金額計算方法2月の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 特徴依頼金額計算方法2月のコードと一致する内容を探します。
     *
     * @param code 特徴依頼金額計算方法2月のコード
     * @return {@code code} に対応する特徴依頼金額計算方法2月
     */
    public static TokuchoIraikingakuKeisanHoho2Gatsu toValue(RString code) {
        for (TokuchoIraikingakuKeisanHoho2Gatsu value : TokuchoIraikingakuKeisanHoho2Gatsu.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴依頼金額計算方法2月"));
    }
}
