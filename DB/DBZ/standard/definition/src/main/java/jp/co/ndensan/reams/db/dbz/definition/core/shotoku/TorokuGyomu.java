package jp.co.ndensan.reams.db.dbz.definition.core.shotoku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 登録業務を表す列挙型です。
 *
 * @author LDNS
 */
public enum TorokuGyomu {

    /**
     * コード:1 名称:住民税 略称:定義なし
     */
    住民税("1", "住民税"),
    /**
     * コード:2 名称:介護保険 略称:定義なし
     */
    介護保険("2", "介護保険");

    private final RString code;
    private final RString fullName;

    private TorokuGyomu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 登録業務のコードを返します。
     *
     * @return 登録業務のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 登録業務の名称を返します。
     *
     * @return 登録業務の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 登録業務のコードと一致する内容を探します。
     *
     * @param code 登録業務のコード
     * @return {@code code} に対応する登録業務
     */
    public static TorokuGyomu toValue(RString code) {

        for (TorokuGyomu torokuGyomu : TorokuGyomu.values()) {
            if (torokuGyomu.code.equals(code)) {
                return torokuGyomu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("登録業務"));
    }
}
