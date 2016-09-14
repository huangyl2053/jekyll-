package jp.co.ndensan.reams.db.dbu.definition.core.bangoseido;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 中間標準レイアウト仕様要介護異動事由を表す列挙型です。
 *
 * @reamsid_L DBU-9999-023 sunhaidi
 */
public enum ChukanHyojunLayoutKaigoIdoJiyu {

    /**
     * コード:001 名称:転入 略称:定義なし
     */
    転入("001", "転入"),
    /**
     * コード:002 名称:年齢到達 略称:定義なし
     */
    年齢到達("002", "年齢到達"),
    /**
     * コード:006 名称:その他取得 略称:定義なし
     */
    その他取得("006", "その他取得"),
    /**
     * コード:053 名称:入国 略称:定義なし
     */
    入国("053", "入国"),
    /**
     * コード:054 名称:職権取得 略称:定義なし
     */
    職権取得("054", "職権取得"),
    /**
     * コード:055 名称:帰化（資格取得） 略称:定義なし
     */
    帰化_資格取得("055", "帰化（資格取得）"),
    /**
     * コード:059 名称:2号仮申請 略称:定義なし
     */
    _2号仮申請("059", "2号仮申請"),
    /**
     * コード:155 名称:住所地特例解除 略称:定義なし
     */
    住所地特例解除("155", "住所地特例解除"),
    /**
     * コード:160 名称:１号被保険者変更 略称:定義なし
     */
    _1号被保険者変更("160", "１号被保険者変更"),
    /**
     * コード:202 名称:死亡 略称:定義なし
     */
    死亡("202", "死亡"),
    /**
     * コード:203 名称:国籍喪失 略称:定義なし
     */
    国籍喪失("203", "国籍喪失"),
    /**
     * コード:209 名称:転出 略称:定義なし
     */
    転出("209", "転出"),
    /**
     * コード:253 名称:その他喪失 略称:定義なし
     */
    その他喪失("253", "その他喪失"),
    /**
     * コード:254 名称:適用除外 略称:定義なし
     */
    適用除外("254", "適用除外"),
    /**
     * コード:255 名称:職権喪失 略称:定義なし
     */
    職権喪失("255", "職権喪失");

    private final RString code;
    private final RString fullName;

    private ChukanHyojunLayoutKaigoIdoJiyu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 中間標準レイアウト仕様要介護異動事由のコードを返します。
     *
     * @return 中間標準レイアウト仕様要介護異動事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 中間標準レイアウト仕様要介護異動事由の名称を返します。
     *
     * @return 中間標準レイアウト仕様要介護異動事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 中間標準レイアウト仕様要介護異動事由のコードと一致する内容を探します。
     *
     * @param code 中間標準レイアウト仕様要介護異動事由のコード
     * @return {@code code} に対応する中間標準レイアウト仕様要介護異動事由
     */
    public static ChukanHyojunLayoutKaigoIdoJiyu toValue(RString code) {
        for (ChukanHyojunLayoutKaigoIdoJiyu value : ChukanHyojunLayoutKaigoIdoJiyu.values()) {
            if (value.code.equals(code)) {
                return value;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getMessage());
    }
}
