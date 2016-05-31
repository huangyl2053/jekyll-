package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 納付額データ連携方法を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum NofugakuDataRenkeiHoho {

    /**
     * コード:1 名称:Reams_NET 略称:Reams.NET
     */
    Reams_NET("1", "Reams_NET", "Reams.NET"),
    /**
     * コード:2 名称:Reams以外 略称:Reams以外
     */
    Reams以外("2", "Reams以外", "Reams以外"),
    /**
     * コード:3 名称:Reams以外_拡張ﾌｧｲﾙ 略称:Reams以外（拡張ﾌｧｲﾙ）
     */
    Reams以外_拡張ﾌｧｲﾙ("3", "Reams以外_拡張ﾌｧｲﾙ", "Reams以外（拡張ﾌｧｲﾙ）");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private NofugakuDataRenkeiHoho(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 納付額データ連携方法のコードを返します。
     *
     * @return 納付額データ連携方法のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 納付額データ連携方法の名称を返します。
     *
     * @return 納付額データ連携方法の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 納付額データ連携方法の略称を返します。
     *
     * @return 納付額データ連携方法の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 納付額データ連携方法のコードと一致する内容を探します。
     *
     * @param code 納付額データ連携方法のコード
     * @return {@code code} に対応する納付額データ連携方法
     */
    public static NofugakuDataRenkeiHoho toValue(RString code) {
        for (NofugakuDataRenkeiHoho nofugakuDataRenkeiHoho : NofugakuDataRenkeiHoho.values()) {
            if (nofugakuDataRenkeiHoho.code.equals(code)) {
                return nofugakuDataRenkeiHoho;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("納付額データ連携方法"));
    }
}
