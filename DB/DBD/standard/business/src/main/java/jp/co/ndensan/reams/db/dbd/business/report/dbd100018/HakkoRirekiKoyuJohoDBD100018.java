package jp.co.ndensan.reams.db.dbd.business.report.dbd100018;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 発行履歴固有情報DBD100018を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum HakkoRirekiKoyuJohoDBD100018 {

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

    private HakkoRirekiKoyuJohoDBD100018(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 発行履歴固有情報DBD100018の名称を返します。
     *
     * @return 発行履歴固有情報DBD100018の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 発行履歴固有情報DBD100018の名称と一致する内容を探します。
     *
     * @param fullname 発行履歴固有情報DBD100018の名称
     * @return {@code fullname} に対応する発行履歴固有情報DBD100018
     */
    public static HakkoRirekiKoyuJohoDBD100018 toValue(RString fullname) {
        for (HakkoRirekiKoyuJohoDBD100018 hakkoRirekiKoyuJohoDBD100018 : HakkoRirekiKoyuJohoDBD100018.values()) {
            if (hakkoRirekiKoyuJohoDBD100018.get名称().equals(fullname)) {
                return hakkoRirekiKoyuJohoDBD100018;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("発行履歴固有情報DBD100018"));
    }
}
