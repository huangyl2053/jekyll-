package jp.co.ndensan.reams.db.dbe.definition.enumeratedtype.Shinsakai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 合議体精神科医存在フラグを表す列挙型です。
 *
 * @author LDNS
 */
public enum IsGogitaiSeishinkaSonzai {

    /**
     * コード:True 名称:存在 略称:定義なし
     */
    存在(true, "存在"),
    /**
     * コード:False 名称:不在 略称:定義なし
     */
    不在(false, "不在");

    private final boolean code;
    private final RString fullName;

    private IsGogitaiSeishinkaSonzai(boolean code, String fullname) {
        this.code = code;
        this.fullName = new RString(fullname);
    }

    /**
     * 合議体精神科医存在フラグのコードを返します。
     *
     * @return 合議体精神科医存在フラグのコード
     */
    public boolean getコード() {
        return code;
    }

    /**
     * 合議体精神科医存在フラグの名称を返します。
     *
     * @return 合議体精神科医存在フラグの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 合議体精神科医存在フラグのコードと一致する内容を探します。
     *
     * @param code 合議体精神科医存在フラグのコード
     * @return {@code code} に対応する合議体精神科医存在フラグ
     */
    public static IsGogitaiSeishinkaSonzai toValue(boolean code) {
        for (IsGogitaiSeishinkaSonzai isGogitaiSeishinkaSonzai : IsGogitaiSeishinkaSonzai.values()) {
            if (isGogitaiSeishinkaSonzai.code == code) {
                return isGogitaiSeishinkaSonzai;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("合議体精神科医存在フラグ"));
    }
}
