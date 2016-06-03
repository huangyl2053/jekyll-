package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 老人保健受給者番号体系を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum RozinhokenbangotaikeiCheck {

    /**
     * コード:1 名称:住民コード 略称:住民コード
     */
    住民コード("1", "住民コード", "住民コード"),
    /**
     * コード:2 名称:医療給付サブシステム 略称:医療給付サブシステム
     */
    医療給付サブシステム("2", "医療給付サブシステム", "医療給付サブシステム"),
    /**
     * コード:3 名称:市町村独自 略称:市町村独自
     */
    市町村独自("3", "市町村独自", "市町村独自");

    private final RString code;
    private final RString fullName;
    private final RString shortName;

    private RozinhokenbangotaikeiCheck(String code, String fullname, String shortName) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
        this.shortName = new RString(shortName);
    }

    /**
     * 老人保健受給者番号体系のコードを返します。
     *
     * @return 老人保健受給者番号体系のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 老人保健受給者番号体系の名称を返します。
     *
     * @return 老人保健受給者番号体系の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 老人保健受給者番号体系の略称を返します。
     *
     * @return 老人保健受給者番号体系の略称
     */
    public RString get略称() {
        return shortName;
    }

    /**
     * 老人保健受給者番号体系のコードと一致する内容を探します。
     *
     * @param code 老人保健受給者番号体系のコード
     * @return {@code code} に対応する老人保健受給者番号体系
     */
    public static RozinhokenbangotaikeiCheck toValue(RString code) {
        for (RozinhokenbangotaikeiCheck rozinhokenbangotaikeiCheck : RozinhokenbangotaikeiCheck.values()) {
            if (rozinhokenbangotaikeiCheck.code.equals(code)) {
                return rozinhokenbangotaikeiCheck;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("老人保健受給者番号体系"));
    }
}
