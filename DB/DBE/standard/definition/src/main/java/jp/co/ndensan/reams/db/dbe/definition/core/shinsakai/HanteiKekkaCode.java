package jp.co.ndensan.reams.db.dbe.definition.core.shinsakai;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 判定結果コードを表す列挙型です。
 *
 * @reamsid_L DBE-9999-023 liangbc
 */
public enum HanteiKekkaCode {

    /**
     * コード:01 名称:認定 略称:定義なし
     */
    認定("01", "認定"),
    /**
     * コード:11 名称:未審査 略称:定義なし
     */
    未審査("11", "未審査"),
    /**
     * コード:21 名称:再審査 略称:定義なし
     */
    再審査("21", "再審査"),
    /**
     * コード:31 名称:再調査（調査・意見書） 略称:定義なし
     */
    再調査_調査_意見書("31", "再調査（調査・意見書）"),
    /**
     * コード:32 名称:再調査（調査のみ） 略称:定義なし
     */
    再調査_調査のみ("32", "再調査（調査のみ）"),
    /**
     * コード:33 名称:再調査（意見書のみ） 略称:定義なし
     */
    再調査_意見書のみ("33", "再調査（意見書のみ）");

    private final RString codeValue;
    private final Code aCode;
    private final RString fullName;

    private HanteiKekkaCode(String code, String fullname) {
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
     * @return 再調査の場合、{@code true}.
     */
    public boolean is再調査() {
        return this == 再調査_調査のみ || this == 再調査_意見書のみ || this == 再調査_調査_意見書;
    }

    /**
     * 判定結果コードのコードと一致する内容を探します。
     *
     * @param code 判定結果コードのコード
     * @return {@code code} に対応する判定結果コード
     */
    public static HanteiKekkaCode toValue(RString code) {

        for (HanteiKekkaCode hanteiKekkaCode : HanteiKekkaCode.values()) {
            if (hanteiKekkaCode.codeValue.equals(code)) {
                return hanteiKekkaCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("判定結果コード"));
    }
}
