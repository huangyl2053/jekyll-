package jp.co.ndensan.reams.db.dbz.definition.core.chohyo.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 文字切れ分離制御を表す列挙型です。
 *
 * @author LDNS
 */
public enum MojigireBunriSeigyo {

    /**
     * コード:0 名称:山分けしない 略称:分けない
     */
    分けない("0", "山分けしない", "分けない"),
    /**
     * コード:1 名称:山分けする 略称:分ける
     */
    分ける("1", "山分けする", "分ける");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private MojigireBunriSeigyo(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 文字切れ分離制御のコードを返します。
     *
     * @return 文字切れ分離制御のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 文字切れ分離制御の名称を返します。
     *
     * @return 文字切れ分離制御の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 文字切れ分離制御の略称を返します。
     *
     * @return 文字切れ分離制御の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 文字切れ分離制御のコードと一致する内容を探します。
     *
     * @param code 文字切れ分離制御のコード
     * @return {@code code} に対応する文字切れ分離制御
     */
    public static MojigireBunriSeigyo toValue(RString code) {

        for (MojigireBunriSeigyo mojigireBunriSeigyo : MojigireBunriSeigyo.values()) {
            if (mojigireBunriSeigyo.code.equals(code)) {
                return mojigireBunriSeigyo;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("文字切れ分離制御"));
    }
}
