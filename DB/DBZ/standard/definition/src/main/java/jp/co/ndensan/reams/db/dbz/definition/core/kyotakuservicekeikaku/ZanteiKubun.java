package jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス計画暫定区分を表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 huangh
 */
public enum ZanteiKubun {

    /**
     * コード:0 名称:暫定以外 略称:定義なし
     */
    暫定以外("0", "暫定以外"),
    /**
     * コード:1 名称:暫定 略称:定義なし
     */
    暫定("1", "暫定");

    private final RString code;
    private final RString fullName;

    private ZanteiKubun(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 居宅サービス計画暫定区分のコードを返します。
     *
     * @return 居宅サービス計画暫定区分のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 居宅サービス計画暫定区分の名称を返します。
     *
     * @return 居宅サービス計画暫定区分の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 居宅サービス計画暫定区分のコードと一致する内容を探します。
     *
     * @param code 居宅サービス計画暫定区分のコード
     * @return {@code code} に対応する居宅サービス計画暫定区分
     */
    public static ZanteiKubun toValue(RString code) {

        for (ZanteiKubun zanteiKubun : ZanteiKubun.values()) {
            if (zanteiKubun.code.equals(code)) {
                return zanteiKubun;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("居宅サービス計画暫定区分コード"));
    }
}
