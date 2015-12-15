package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 削除事由コードを表す列挙型です。
 *
 * @author LDNS
 */
public enum SakujoJiyuCode {

    /**
     * コード:01 名称:過誤による削除 略称:定義なし
     */
    過誤による削除("01", "過誤による削除"),
    /**
     * コード:02 名称:資格喪失による削除 略称:定義なし
     */
    資格喪失による削除("02", "資格喪失による削除"),
    /**
     * コード:03 名称:変更申請による削除 略称:定義なし
     */
    変更申請による削除("03", "変更申請による削除"),
    /**
     * コード:04 名称:再調査による削除 略称:定義なし
     */
    再調査による削除("04", "再調査による削除"),
    /**
     * コード:05 名称:不服申立による削除 略称:定義なし
     */
    不服申立による削除("05", "不服申立による削除"),
    /**
     * コード:06 名称:認定取下げによる削除 略称:定義なし
     */
    _06認定取下げによる削除("06", "認定取下げによる削除"),
    /**
     * コード:09 名称:認定取下げによる削除 略称:定義なし
     */
    _09認定取下げによる削除("09", "認定取下げによる削除");

    private final RString code;
    private final RString fullName;

    private SakujoJiyuCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 削除事由コードのコードを返します。
     *
     * @return 削除事由コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 削除事由コードの名称を返します。
     *
     * @return 削除事由コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 削除事由コードのコードと一致する内容を探します。
     *
     * @param code 削除事由コードのコード
     * @return {@code code} に対応する削除事由コード
     */
    public static SakujoJiyuCode toValue(RString code) {

        for (SakujoJiyuCode sakujoJiyuCode : SakujoJiyuCode.values()) {
            if (sakujoJiyuCode.code.equals(code)) {
                return sakujoJiyuCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("削除事由コード"));
    }
}
