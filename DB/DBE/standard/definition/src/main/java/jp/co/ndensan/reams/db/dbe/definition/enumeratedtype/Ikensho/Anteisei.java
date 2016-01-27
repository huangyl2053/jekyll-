package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Ikensho;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 意見書・症状としての安定性を表す列挙型です。
 *
 * @author LDNS
 */
public enum Anteisei {

    /**
     * コード:1 名称:安定 略称:定義なし
     */
    安定("1", "安定"),
    /**
     * コード:2 名称:不安定 略称:定義なし
     */
    不安定("2", "不安定"),
    /**
     * コード:3 名称:不明 略称:定義なし
     */
    不明("3", "不明");

    private final RString code;
    private final RString fullName;

    private Anteisei(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 意見書・症状としての安定性のコードを返します。
     *
     * @return 意見書・症状としての安定性のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 意見書・症状としての安定性の名称を返します。
     *
     * @return 意見書・症状としての安定性の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 意見書・症状としての安定性のコードと一致する内容を探します。
     *
     * @param code 意見書・症状としての安定性のコード
     * @return {@code code} に対応する意見書・症状としての安定性
     */
    public static Anteisei toValue(RString code) {
        for (Anteisei anteisei : Anteisei.values()) {
            if (anteisei.code.equals(code)) {
                return anteisei;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("意見書・症状としての安定性"));
    }
}
