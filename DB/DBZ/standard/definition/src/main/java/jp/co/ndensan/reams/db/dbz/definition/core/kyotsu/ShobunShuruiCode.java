package jp.co.ndensan.reams.db.dbz.definition.core.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 処分種類コードを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 liangbc
 */
public enum ShobunShuruiCode {

    /**
     * コード:01 名称:要介護認定又は要支援認定に関する処分 略称:定義なし
     */
    要介護認定又は要支援認定に関する処分("01", "要介護認定又は要支援認定に関する処分"),
    /**
     * コード:02 名称:被保険者証の交付の請求に関する処分 略称:定義なし
     */
    被保険者証の交付の請求に関する処分("02", "被保険者証の交付の請求に関する処分"),
    /**
     * コード:03 名称:居宅介護サービス費等の支給 略称:定義なし
     */
    居宅介護サービス費等の支給("03", "居宅介護サービス費等の支給"),
    /**
     * コード:04 名称:給付制限に関する処分 略称:定義なし
     */
    給付制限に関する処分("04", "給付制限に関する処分"),
    /**
     * コード:05 名称:保険料に関する処分 略称:定義なし
     */
    保険料に関する処分("05", "保険料に関する処分"),
    /**
     * コード:06 名称:不正利得に関る徴収金等に係る賦課徴収 略称:定義なし
     */
    不正利得に関る徴収金等に係る賦課徴収("06", "不正利得に関る徴収金等に係る賦課徴収");

    private final RString code;
    private final RString fullName;

    private ShobunShuruiCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 処分種類コードのコードを返します。
     *
     * @return 処分種類コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 処分種類コードの名称を返します。
     *
     * @return 処分種類コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 処分種類コードのコードと一致する内容を探します。
     *
     * @param code 処分種類コードのコード
     * @return {@code code} に対応する処分種類コード
     */
    public static ShobunShuruiCode toValue(RString code) {

        for (ShobunShuruiCode shobunShuruiCode : ShobunShuruiCode.values()) {
            if (shobunShuruiCode.code.equals(code)) {
                return shobunShuruiCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("処分種類コード"));
    }
}
