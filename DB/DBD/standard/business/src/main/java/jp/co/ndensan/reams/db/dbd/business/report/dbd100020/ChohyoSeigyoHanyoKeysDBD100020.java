package jp.co.ndensan.reams.db.dbd.business.report.dbd100020;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票制御汎用キーDBD100020を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ChohyoSeigyoHanyoKeysDBD100020 {

    /**
     * コード:なし 名称:保険者名表示 略称:定義なし
     */
    保険者名表示("保険者名表示"),
    /**
     * コード:なし 名称:帳票タイプ 略称:定義なし
     */
    帳票タイプ("帳票タイプ");

    private final RString fullName;

    private ChohyoSeigyoHanyoKeysDBD100020(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 帳票制御汎用キーDBD100020の名称を返します。
     *
     * @return 帳票制御汎用キーDBD100020の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 帳票制御汎用キーDBD100020の名称と一致する内容を探します。
     *
     * @param fullName 帳票制御汎用キーDBD100020の名称
     * @return {@code fullName} に対応する帳票制御汎用キーDBD100020
     */
    public static ChohyoSeigyoHanyoKeysDBD100020 toValue(RString fullName) {
        for (ChohyoSeigyoHanyoKeysDBD100020 value : ChohyoSeigyoHanyoKeysDBD100020.values()) {
            if (value.get名称().equals(fullName)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("帳票制御汎用キーDBD100020"));
    }
}
