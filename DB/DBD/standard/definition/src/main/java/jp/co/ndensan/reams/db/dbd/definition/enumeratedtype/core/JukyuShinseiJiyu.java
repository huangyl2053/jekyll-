package jp.co.ndensan.reams.db.dbd.definition.enumeratedtype.core;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 受給申請事由を表す列挙型です。
 *
 * @author LDNS
 */
public enum JukyuShinseiJiyu {

    /**
     * コード:1 名称:初回申請 略称:定義なし
     */
    初回申請("1", "初回申請"),
    /**
     * コード:2 名称:再申請（有効期限内） 略称:定義なし
     */
    再申請_有効期限内("2", "再申請（有効期限内）"),
    /**
     * コード:3 名称:再申請（有効期限外） 略称:定義なし
     */
    再申請_有効期限外("3", "再申請（有効期限外）"),
    /**
     * コード:4 名称:要介護度変更申請 略称:定義なし
     */
    要介護度変更申請("4", "要介護度変更申請"),
    /**
     * コード:5 名称:指定サービス種類変更申請 略称:定義なし
     */
    指定サービス種類変更申請("5", "指定サービス種類変更申請"),
    /**
     * コード:6 名称:申請（法施行前） 略称:定義なし
     */
    申請_法施行前("6", "申請（法施行前）"),
    /**
     * コード:7 名称:追加（申請なしの追加） 略称:定義なし
     */
    追加_申請なしの追加("7", "追加（申請なしの追加）");

    private final RString code;
    private final RString fullName;

    private JukyuShinseiJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 受給申請事由のコードを返します。
     *
     * @return 受給申請事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 受給申請事由の名称を返します。
     *
     * @return 受給申請事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 受給申請事由のコードと一致する内容を探します。
     *
     * @param code 受給申請事由のコード
     * @return {@code code} に対応する受給申請事由
     */
    public static JukyuShinseiJiyu toValue(RString code) {

        for (JukyuShinseiJiyu jukyuShinseiJiyu : JukyuShinseiJiyu.values()) {
            if (jukyuShinseiJiyu.code.equals(code)) {
                return jukyuShinseiJiyu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("受給申請事由"));
    }
}
