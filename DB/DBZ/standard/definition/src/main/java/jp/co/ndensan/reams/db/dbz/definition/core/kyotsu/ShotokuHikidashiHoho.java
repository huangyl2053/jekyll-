package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 所得引出方法を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum ShotokuHikidashiHoho {

    /**
     * コード:1 名称:Reams_NET 略称:Reams.NET
     */
    Reams_NET("1", "Reams_NET", "Reams.NET"),
    /**
     * コード:3 名称:Reams以外 略称:Reams以外
     */
    Reams以外("3", "Reams以外", "Reams以外"),
    /**
     * コード:4 名称:更正なし 略称:更正なし
     */
    更正なし("4", "更正なし", "更正なし");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private ShotokuHikidashiHoho(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 所得引出方法のコードを返します。
     *
     * @return 所得引出方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 所得引出方法の名称を返します。
     *
     * @return 所得引出方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 所得引出方法の略称を返します。
     *
     * @return 所得引出方法の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 所得引出方法のコードと一致する内容を探します。
     *
     * @param code 所得引出方法のコード
     * @return {@code code} に対応する所得引出方法
     */
    public static ShotokuHikidashiHoho toValue(RString code) {
        for (ShotokuHikidashiHoho shotokuHikidashiHoho : ShotokuHikidashiHoho.values()) {
            if (shotokuHikidashiHoho.code.equals(code)) {
                return shotokuHikidashiHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("所得引出方法"));
    }
}
