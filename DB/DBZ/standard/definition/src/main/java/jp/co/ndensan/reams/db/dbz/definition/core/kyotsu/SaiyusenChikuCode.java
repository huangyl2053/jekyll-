package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 最優先地区コードを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum SaiyusenChikuCode {

    /**
     * コード:1 名称:地区コード１ 略称:定義なし
     */
    地区コード１("1", "地区コード１"),
    /**
     * コード:2 名称:地区コード２ 略称:定義なし
     */
    地区コード２("2", "地区コード２"),
    /**
     * コード:3 名称:地区コード３ 略称:定義なし
     */
    地区コード３("3", "地区コード３"),
    /**
     * コード:4 名称:未使用 略称:定義なし
     */
    未使用("4", "未使用");

    private final RString code;
    private final RString fullName;

    private SaiyusenChikuCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 最優先地区コードのコードを返します。
     *
     * @return 最優先地区コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 最優先地区コードの名称を返します。
     *
     * @return 最優先地区コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 最優先地区コードのコードと一致する内容を探します。
     *
     * @param code 最優先地区コードのコード
     * @return {@code code} に対応する最優先地区コード
     */
    public static SaiyusenChikuCode toValue(RString code) {
        for (SaiyusenChikuCode saiyusenChikuCode : SaiyusenChikuCode.values()) {
            if (saiyusenChikuCode.code.equals(code)) {
                return saiyusenChikuCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("最優先地区コード"));
    }
}
