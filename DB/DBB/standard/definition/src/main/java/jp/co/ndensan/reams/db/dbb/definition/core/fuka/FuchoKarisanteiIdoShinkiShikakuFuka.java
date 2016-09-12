package jp.co.ndensan.reams.db.dbb.definition.core.fuka;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 普徴仮算定異動新規資格賦課を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 wangchao
 */
public enum FuchoKarisanteiIdoShinkiShikakuFuka {

    /**
     * コード:0 名称:賦課しない 略称:定義なし
     */
    賦課しない("0", "賦課しない"),
    /**
     * コード:1 名称:賦課する 略称:定義なし
     */
    賦課する("1", "賦課する");

    private final RString code;
    private final RString fullName;

    private FuchoKarisanteiIdoShinkiShikakuFuka(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 普徴仮算定異動新規資格賦課のコードを返します。
     *
     * @return 普徴仮算定異動新規資格賦課のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 普徴仮算定異動新規資格賦課の名称を返します。
     *
     * @return 普徴仮算定異動新規資格賦課の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 普徴仮算定異動新規資格賦課のコードと一致する内容を探します。
     *
     * @param code 普徴仮算定異動新規資格賦課のコード
     * @return {@code code} に対応する普徴仮算定異動新規資格賦課
     */
    public static FuchoKarisanteiIdoShinkiShikakuFuka toValue(RString code) {
        for (FuchoKarisanteiIdoShinkiShikakuFuka value : FuchoKarisanteiIdoShinkiShikakuFuka.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("普徴仮算定異動新規資格賦課"));
    }
}
