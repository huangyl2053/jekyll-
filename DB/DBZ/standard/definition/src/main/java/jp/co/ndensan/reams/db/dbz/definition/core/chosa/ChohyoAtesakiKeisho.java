package jp.co.ndensan.reams.db.dbz.definition.core.chosa;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票宛先敬称を表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 wangchao
 */
public enum ChohyoAtesakiKeisho {

    /**
     * コード:0 名称:"" 略称:定義なし
     */
    なし("0", ""),
    /**
     * コード:1 名称:様 略称:定義なし
     */
    様("1", "様"),
    /**
     * コード:2 名称:殿 略称:定義なし
     */
    殿("2", "殿");

    private final RString code;

    private final RString fullName;

    private ChohyoAtesakiKeisho(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 帳票宛先敬称のコードを返します。
     *
     * @return 帳票宛先敬称
     */
    public RString getコード() {
        return code;
    }

    /**
     * 帳票宛先敬称の名称を返します。
     *
     * @return 帳票宛先敬称の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 帳票宛先敬称のコードと一致する内容を探します。
     *
     * @param code 帳票宛先敬称のコード
     * @return {@code code} に対応する帳票宛先敬称
     */
    public static ChohyoAtesakiKeisho toValue(RString code) {
        for (ChohyoAtesakiKeisho chohyoAtesakiKeisho : ChohyoAtesakiKeisho.values()) {
            if (chohyoAtesakiKeisho.code.equals(code)) {
                return chohyoAtesakiKeisho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("帳票宛先敬称"));
    }
}
