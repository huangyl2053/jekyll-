package jp.co.ndensan.reams.db.dbz.definition.core.kyotakuservicekeikaku;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 居宅サービス計画作成区分コードを表す列挙型です。
 *
 * @reamsid_L DBZ-9999-023 wangchao
 */
public enum KyotakuservicekeikakuSakuseikubunCode {

    /**
     * コード:1 名称:指定居宅介護支援事業者作成 略称:定義なし
     */
    指定居宅介護支援事業者作成("1", "指定居宅介護支援事業者作成"),
    /**
     * コード:2 名称:基準該当居宅介護支援事業者作成 略称:定義なし
     */
    基準該当居宅介護支援事業者作成("2", "基準該当居宅介護支援事業者作成"),
    /**
     * コード:3 名称:自己作成 略称:定義なし
     */
    自己作成("3", "自己作成"),
    /**
     * コード:4 名称:介護予防支援事業者作成 略称:定義なし
     */
    介護予防支援事業者作成("4", "介護予防支援事業者作成");

    private final RString code;
    private final RString fullName;

    private KyotakuservicekeikakuSakuseikubunCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 居宅サービス計画作成区分コードのコードを返します。
     *
     * @return 居宅サービス計画作成区分コードのコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 居宅サービス計画作成区分コードの名称を返します。
     *
     * @return 居宅サービス計画作成区分コードの名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 居宅サービス計画作成区分コードのコードと一致する内容を探します。
     *
     * @param code 居宅サービス計画作成区分コードのコード
     * @return {@code code} に対応する居宅サービス計画作成区分コード
     */
    public static KyotakuservicekeikakuSakuseikubunCode toValue(RString code) {

        for (KyotakuservicekeikakuSakuseikubunCode kubunCode : KyotakuservicekeikakuSakuseikubunCode.values()) {
            if (kubunCode.code.equals(code)) {
                return kubunCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("居宅サービス計画作成区分コード"));
    }
}
