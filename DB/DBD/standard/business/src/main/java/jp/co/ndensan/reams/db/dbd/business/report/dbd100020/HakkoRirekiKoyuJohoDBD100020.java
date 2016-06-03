package jp.co.ndensan.reams.db.dbd.business.report.dbd100020;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 発行履歴固有情報DBD100020を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum HakkoRirekiKoyuJohoDBD100020 {

    /**
     * コード:なし 名称:帳票ID 略称:定義なし
     */
    帳票ID("帳票ID"),
    /**
     * コード:なし 名称:被保番号 略称:定義なし
     */
    被保番号("被保番号"),
    /**
     * コード:なし 名称:減免適用開始日 略称:定義なし
     */
    減免適用開始日("減免適用開始日");

    private final RString fullName;

    private HakkoRirekiKoyuJohoDBD100020(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 発行履歴固有情報DBD100020の名称を返します。
     *
     * @return 発行履歴固有情報DBD100020の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 発行履歴固有情報DBD100020の名称と一致する内容を探します。
     *
     * @param code 発行履歴固有情報DBD100020の名称
     * @return {@code code} に対応する発行履歴固有情報DBD100020
     */
    public static HakkoRirekiKoyuJohoDBD100020 toValue(RString code) {
        for (HakkoRirekiKoyuJohoDBD100020 hakkoRirekiKoyuJohoDBD100020 : HakkoRirekiKoyuJohoDBD100020.values()) {
            if (hakkoRirekiKoyuJohoDBD100020.get名称().equals(code)) {
                return hakkoRirekiKoyuJohoDBD100020;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("発行履歴固有情報DBD100020"));
    }
}
