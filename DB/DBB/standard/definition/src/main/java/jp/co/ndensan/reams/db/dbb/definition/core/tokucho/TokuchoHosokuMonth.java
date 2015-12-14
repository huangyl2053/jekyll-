package jp.co.ndensan.reams.db.dbb.definition.core.tokucho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 特徴捕捉月を表す列挙型です。
 *
 * @author LDNS
 */
public enum TokuchoHosokuMonth {

    /**
     * コード:04 名称:特徴4月捕捉 略称:定義なし
     */
    特徴4月捕捉("04", "特徴4月捕捉"),
    /**
     * コード:06 名称:特徴6月捕捉 略称:定義なし
     */
    特徴6月捕捉("06", "特徴6月捕捉"),
    /**
     * コード:08 名称:特徴8月捕捉 略称:定義なし
     */
    特徴8月捕捉("08", "特徴8月捕捉"),
    /**
     * コード:10 名称:特徴10月捕捉 略称:定義なし
     */
    特徴10月捕捉("10", "特徴10月捕捉"),
    /**
     * コード:12 名称:特徴12月捕捉 略称:定義なし
     */
    特徴12月捕捉("12", "特徴12月捕捉"),
    /**
     * コード:02 名称:特徴2月捕捉 略称:定義なし
     */
    特徴2月捕捉("02", "特徴2月捕捉");

    private final RString code;
    private final RString fullName;

    private TokuchoHosokuMonth(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 特徴捕捉月のコードを返します。
     *
     * @return 特徴捕捉月のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 特徴捕捉月の名称を返します。
     *
     * @return 特徴捕捉月の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 特徴捕捉月のコードと一致する内容を探します。
     *
     * @param code 特徴捕捉月のコード
     * @return {@code code} に対応する特徴捕捉月
     */
    public static TokuchoHosokuMonth toValue(RString code) {
        for (TokuchoHosokuMonth tokuchoHosokuMonth : TokuchoHosokuMonth.values()) {
            if (tokuchoHosokuMonth.code.equals(code)) {
                return tokuchoHosokuMonth;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("特徴捕捉月"));
    }
}
