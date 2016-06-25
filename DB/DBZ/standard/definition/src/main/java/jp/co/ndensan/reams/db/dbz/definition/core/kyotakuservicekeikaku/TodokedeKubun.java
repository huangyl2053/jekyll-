package jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス計画届出区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 huangh
 */
public enum TodokedeKubun {

    /**
     * コード:1 名称:新規 略称:定義なし
     */
    新規("1", "新規"),
    /**
     * コード:2 名称:変更 略称:定義なし
     */
    変更("2", "変更"),
    /**
     * コード:3 名称:暫定 略称:定義なし
     */
    暫定("3", "暫定");

    private final RString code;
    private final RString fullName;

    private TodokedeKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 居宅サービス計画届出区分のコードを返します。
     *
     * @return 居宅サービス計画届出区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 居宅サービス計画届出区分の名称を返します。
     *
     * @return 居宅サービス計画届出区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 居宅サービス計画届出区分のコードと一致する内容を探します。
     *
     * @param code 居宅サービス計画届出区分のコード
     * @return {@code code} に対応する居宅サービス計画届出区分
     */
    public static TodokedeKubun toValue(RString code) {

        for (TodokedeKubun todokedeKubun : TodokedeKubun.values()) {
            if (todokedeKubun.code.equals(code)) {
                return todokedeKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("居宅サービス計画届出区分コード"));
    }
}
