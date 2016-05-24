package jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 対象期間を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum TaishoKikan {

    /**
     * コード:1 名称:対象年度 略称:定義なし
     */
    対象年度("1", "対象年度"),
    /**
     * コード:2 名称:基準日 略称:定義なし
     */
    基準日("2", "基準日");

    private final RString code;
    private final RString fullName;

    private TaishoKikan(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 対象期間のコードを返します。
     *
     * @return 対象期間のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 対象期間の名称を返します。
     *
     * @return 対象期間の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 対象期間のコードと一致する内容を探します。
     *
     * @param code 対象期間のコード
     * @return {@code code} に対応する対象期間
     */
    public static TaishoKikan toValue(RString code) {
        for (TaishoKikan taishoKikan : TaishoKikan.values()) {
            if (taishoKikan.code.equals(code)) {
                return taishoKikan;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("対象期間"));
    }
}
