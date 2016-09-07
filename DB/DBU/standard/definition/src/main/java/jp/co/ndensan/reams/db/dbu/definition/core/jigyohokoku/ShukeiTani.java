package jp.co.ndensan.reams.db.dbu.definition.core.jigyohokoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 集計単位を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 wangchao
 */
public enum ShukeiTani {

    /**
     * コード:1 名称:処理日[固定] 略称:定義なし
     */
    処理日_固定("1", "処理日[固定]");

    private final RString code;
    private final RString fullName;

    private ShukeiTani(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 集計単位のコードを返します。
     *
     * @return 集計単位のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 集計単位の名称を返します。
     *
     * @return 集計単位の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 集計単位のコードと一致する内容を探します。
     *
     * @param code 集計単位のコード
     * @return {@code code} に対応する集計単位
     */
    public static ShukeiTani toValue(RString code) {
        for (ShukeiTani shukeiTani : ShukeiTani.values()) {
            if (shukeiTani.code.equals(code)) {
                return shukeiTani;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("集計単位"));
    }
}
