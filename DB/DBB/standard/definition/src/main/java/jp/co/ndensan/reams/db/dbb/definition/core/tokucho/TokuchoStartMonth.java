package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴開始月を表す列挙型です。
 *
 * @author LDNS
 */
public enum TokuchoStartMonth {

    /**
     * コード:04 名称:特徴4月開始 略称:定義なし
     */
    特徴4月開始("04", "特徴4月開始"),
    /**
     * コード:06 名称:特徴6月開始 略称:定義なし
     */
    特徴6月開始("06", "特徴6月開始"),
    /**
     * コード:08 名称:特徴8月開始 略称:定義なし
     */
    特徴8月開始("08", "特徴8月開始"),
    /**
     * コード:10 名称:特徴10月開始 略称:定義なし
     */
    特徴10月開始("10", "特徴10月開始"),
    /**
     * コード:12 名称:特徴12月開始 略称:定義なし
     */
    特徴12月開始("12", "特徴12月開始"),
    /**
     * コード:02 名称:特徴2月開始 略称:定義なし
     */
    特徴2月開始("02", "特徴2月開始");

    private final RString code;
    private final RString fullName;

    private TokuchoStartMonth(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特徴開始月のコードを返します。
     *
     * @return 特徴開始月のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴開始月の名称を返します。
     *
     * @return 特徴開始月の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴開始月のコードと一致する内容を探します。
     *
     * @param code 特徴開始月のコード
     * @return {@code code} に対応する特徴開始月
     */
    public static TokuchoStartMonth toValue(RString code) {
        for (TokuchoStartMonth tokuchoStartMonth : TokuchoStartMonth.values()) {
            if (tokuchoStartMonth.code.equals(code)) {
                return tokuchoStartMonth;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴開始月"));
    }
}
