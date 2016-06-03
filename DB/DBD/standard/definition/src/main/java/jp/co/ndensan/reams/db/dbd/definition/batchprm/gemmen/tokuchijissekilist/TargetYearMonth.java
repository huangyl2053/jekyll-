package jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.tokuchijissekilist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象年月を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum TargetYearMonth {

    /**
     * コード:1 名称:サービス提供年月 略称:定義なし
     */
    サービス提供年月("1", "サービス提供年月"),
    /**
     * コード:2 名称:審査年月 略称:定義なし
     */
    審査年月("2", "審査年月");

    private final RString code;
    private final RString fullName;

    private TargetYearMonth(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 対象年月のコードを返します。
     *
     * @return 対象年月のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 対象年月の名称を返します。
     *
     * @return 対象年月の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 対象年月のコードと一致する内容を探します。
     *
     * @param code 対象年月のコード
     * @return {@code code} に対応する対象年月
     */
    public static TargetYearMonth toValue(RString code) {
        for (TargetYearMonth targetYearMonth : TargetYearMonth.values()) {
            if (targetYearMonth.code.equals(code)) {
                return targetYearMonth;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対象年月"));
    }
}
