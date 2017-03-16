package jp.co.ndensan.reams.db.dbe.definition.core.shinsakai;

import java.util.Objects;
import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 判定結果初期表示を表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 liangbc
 */
public enum HanteiKekkaShokiHyoji {

    /**
     * コード:1 名称:なし 略称:定義なし
     */
    なし("1", ""),
    /**
     * コード:01 名称:認定 略称:定義なし
     */
    認定("2", "認定");

    private final RString codeValue;
    private final Code aCode;
    private final RString fullName;

    private HanteiKekkaShokiHyoji(String code, String fullname) {
        this.aCode = new Code(code);
        this.codeValue = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 判定結果コードのコードを返します。
     *
     * @return 判定結果コードのコード
     */
    public RString getコード() {
        return codeValue;
    }

    /**
     * 判定結果コードのコードを{@link Code}型で返します。
     *
     * @return 判定結果コードのコード(Code型)
     */
    public Code getCode() {
        return aCode;
    }

    /**
     * 判定結果コードの名称を返します。
     *
     * @return 判定結果コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 判定結果コードのコードと一致する内容を探します。
     *
     * @param code 判定結果コードのコード
     * @return {@code code} に対応する判定結果コード
     */
    public static HanteiKekkaShokiHyoji toValue(RString code) {

        for (HanteiKekkaShokiHyoji hanteiKekkaCode : HanteiKekkaShokiHyoji.values()) {
            if (hanteiKekkaCode.codeValue.equals(code)) {
                return hanteiKekkaCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("判定結果初期表示"));
    }

    /**
     * @param code コード
     * @return 指定のコードが{@link HanteiKekkaCode}へ変換可能な場合、{@code true}.
     */
    public static boolean existsCode(RString code) {
        for (HanteiKekkaShokiHyoji value : values()) {
            if (Objects.equals(value.codeValue, code)) {
                return true;
            }
        }
        return false;
    }
}
