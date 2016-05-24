package jp.co.ndensan.reams.db.dbd.business.report.dbd100017;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票制御汎用キーDBD100017を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ChohyoSeigyoHanyoKeysDBD100017 {

    /**
     * コード:なし 名称:保険者名表示 略称:定義なし
     */
    保険者名表示("保険者名表示");

    private final RString fullName;

    private ChohyoSeigyoHanyoKeysDBD100017(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 帳票制御汎用キーDBD100017の名称を返します。
     *
     * @return 帳票制御汎用キーDBD100017の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 帳票制御汎用キーDBD100017のコードと一致する内容を探します。
     *
     * @param fullname 帳票制御汎用キーDBD100017のコード
     * @return {@code fullname} に対応する帳票制御汎用キーDBD100017
     */
    public static ChohyoSeigyoHanyoKeysDBD100017 toValue(RString fullname) {
        for (ChohyoSeigyoHanyoKeysDBD100017 value : ChohyoSeigyoHanyoKeysDBD100017.values()) {
            if (value.get名称().equals(fullname)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("帳票制御汎用キーDBD100017"));
    }
}
