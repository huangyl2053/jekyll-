package jp.co.ndensan.reams.db.dbd.definition.batchprm.gemmen.niteishalist;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 世帯表示を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum SetaiHyoji {

    /**
     * コード:1 名称:表示する 略称:定義なし
     */
    表示する("1", "表示する"),
    /**
     * コード:2 名称:表示しない 略称:定義なし
     */
    表示しない("2", "表示しない");

    private final RString code;
    private final RString fullName;

    private SetaiHyoji(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 世帯表示のコードを返します。
     *
     * @return 世帯表示のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 世帯表示の名称を返します。
     *
     * @return 世帯表示の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 世帯表示のコードと一致する内容を探します。
     *
     * @param code 世帯表示のコード
     * @return {@code code} に対応する世帯表示
     */
    public static SetaiHyoji toValue(RString code) {
        for (SetaiHyoji setaiHyoji : SetaiHyoji.values()) {
            if (setaiHyoji.code.equals(code)) {
                return setaiHyoji;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("世帯表示"));
    }
}
