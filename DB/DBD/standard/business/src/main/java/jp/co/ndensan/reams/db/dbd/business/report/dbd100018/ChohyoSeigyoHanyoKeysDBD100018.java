package jp.co.ndensan.reams.db.dbd.business.report.dbd100018;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 帳票制御汎用キーDBD100018を表す列挙型です。
 *
 * @reamsid_L DBD-9999-023 wangchao
 */
public enum ChohyoSeigyoHanyoKeysDBD100018 {

    /**
     * コード:なし 名称:保険者名表示 略称:定義なし
     */
    保険者名表示("保険者名表示"),
    /**
     * コード:なし 名称:証記載保険者番号印字有無 略称:定義なし
     */
    証記載保険者番号印字有無("証記載保険者番号印字有無"),
    /**
     * コード:なし 名称:減免内容の制限事項１ 略称:定義なし
     */
    減免内容の制限事項１("減免内容の制限事項１"),
    /**
     * コード:なし 名称:減免内容の制限事項２ 略称:定義なし
     */
    減免内容の制限事項２("減免内容の制限事項２"),
    /**
     * コード:なし 名称:減免内容の制限事項３_１ 略称:定義なし
     */
    減免内容の制限事項３_１("減免内容の制限事項３_１"),
    /**
     * コード:なし 名称:減免内容の制限事項３_２ 略称:定義なし
     */
    減免内容の制限事項３_２("減免内容の制限事項３_２"),
    /**
     * コード:なし 名称:減免内容の制限事項３_３ 略称:定義なし
     */
    減免内容の制限事項３_３("減免内容の制限事項３_３"),
    /**
     * コード:なし 名称:減免内容の制限事項３_４ 略称:定義なし
     */
    減免内容の制限事項３_４("減免内容の制限事項３_４"),
    /**
     * コード:なし 名称:減免内容の制限事項３_５ 略称:定義なし
     */
    減免内容の制限事項３_５("減免内容の制限事項３_５");

    private final RString fullName;

    private ChohyoSeigyoHanyoKeysDBD100018(String fullname) {
        this.fullName = new RString(fullname);
    }

    /**
     * 帳票制御汎用キーDBD100018の名称を返します。
     *
     * @return 帳票制御汎用キーDBD100018の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 帳票制御汎用キーDBD100018のコードと一致する内容を探します。
     *
     * @param fullname 帳票制御汎用キーDBD100018のコード
     * @return {@code fullname} に対応する帳票制御汎用キーDBD100018
     */
    public static ChohyoSeigyoHanyoKeysDBD100018 toValue(RString fullname) {
        for (ChohyoSeigyoHanyoKeysDBD100018 value : ChohyoSeigyoHanyoKeysDBD100018.values()) {
            if (value.get名称().equals(fullname)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("帳票制御汎用キーDBD100018"));
    }
}
