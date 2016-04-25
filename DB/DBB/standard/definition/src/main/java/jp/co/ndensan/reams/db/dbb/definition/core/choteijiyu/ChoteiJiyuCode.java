package jp.co.ndensan.reams.db.dbb.definition.core.choteijiyu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 調定事由を表す列挙型です。
 *
 * @reamsid_L DBB-9999-023 liangbc
 */
public enum ChoteiJiyuCode {

    /**
     * コード:01 名称:転入 略称:定義なし
     */
    転入("01", "転入"),
    /**
     * コード:02 名称:年齢到達 略称:定義なし
     */
    年齢到達("02", "年齢到達"),
    /**
     * コード:03 名称:外国人申請 略称:定義なし
     */
    外国人申請("03", "外国人申請"),
    /**
     * コード:05 名称:自特例適用 略称:定義なし
     */
    自特例適用("05", "自特例適用"),
    /**
     * コード:06 名称:自特例転入 略称:定義なし
     */
    _06自特例転入("06", "自特例転入"),
    /**
     * コード:07 名称:他特例居住 略称:定義なし
     */
    他特例居住("07", "他特例居住"),
    /**
     * コード:08 名称:除外者居住 略称:定義なし
     */
    除外者居住("08", "除外者居住"),
    /**
     * コード:09 名称:帰化取得 略称:定義なし
     */
    帰化取得("09", "帰化取得"),
    /**
     * コード:18 名称:職権取得 略称:定義なし
     */
    職権取得("18", "職権取得"),
    /**
     * コード:46 名称:施行時取得 略称:定義なし
     */
    施行時取得("46", "施行時取得"),
    /**
     * コード:49 名称:その他取得 略称:定義なし
     */
    その他取得("49", "その他取得"),
    /**
     * コード:51 名称:転出 略称:定義なし
     */
    転出("51", "転出"),
    /**
     * コード:52 名称:死亡 略称:定義なし
     */
    死亡("52", "死亡"),
    /**
     * コード:53 名称:除外者 略称:定義なし
     */
    除外者("53", "除外者"),
    /**
     * コード:54 名称:自特例転入 略称:定義なし
     */
    _54自特例転入("54", "自特例転入"),
    /**
     * コード:55 名称:自特例解除 略称:定義なし
     */
    自特例解除("55", "自特例解除"),
    /**
     * コード:56 名称:帰化喪失 略称:定義なし
     */
    帰化喪失("56", "帰化喪失"),
    /**
     * コード:57 名称:国籍喪失 略称:定義なし
     */
    国籍喪失("57", "国籍喪失"),
    /**
     * コード:58 名称:他特例者 略称:定義なし
     */
    他特例者("58", "他特例者"),
    /**
     * コード:68 名称:職権喪失 略称:定義なし
     */
    職権喪失("68", "職権喪失"),
    /**
     * コード:99 名称:その他喪失 略称:定義なし
     */
    その他喪失("99", "その他喪失"),
    /**
     * コード:A1 名称:本算定賦課 略称:定義なし
     */
    本算定賦課("A1", "本算定賦課"),
    /**
     * コード:A2 名称:仮算定賦課 略称:定義なし
     */
    仮算定賦課("A2", "仮算定賦課"),
    /**
     * コード:A3 名称:捕捉により特徴開始 略称:定義なし
     */
    捕捉により特徴開始("A3", "捕捉により特徴開始"),
    /**
     * コード:B1 名称:資格異動による更正 略称:定義なし
     */
    資格異動による更正("B1", "資格異動による更正"),
    /**
     * コード:B2 名称:老齢年金による更正 略称:定義なし
     */
    老齢年金による更正("B2", "老齢年金による更正"),
    /**
     * コード:B3 名称:生活保護による更正 略称:定義なし
     */
    生活保護による更正("B3", "生活保護による更正"),
    /**
     * コード:B9 名称:その他資格異動 略称:定義なし
     */
    その他資格異動("B9", "その他資格異動"),
    /**
     * コード:C1 名称:所得更正による更正 略称:定義なし
     */
    所得更正による更正("C1", "所得更正による更正"),
    /**
     * コード:C2 名称:所得更正による異動 略称:定義なし
     */
    所得更正による異動("C2", "所得更正による異動"),
    /**
     * コード:D1 名称:減免決定による更正 略称:定義なし
     */
    減免決定による更正("D1", "減免決定による更正"),
    /**
     * コード:D2 名称:減免取消による更正 略称:定義なし
     */
    減免取消による更正("D2", "減免取消による更正"),
    /**
     * コード:D3 名称:徴収猶予決定 略称:定義なし
     */
    徴収猶予決定("D3", "徴収猶予決定"),
    /**
     * コード:D4 名称:徴収猶予取消 略称:定義なし
     */
    徴収猶予取消("D4", "徴収猶予取消"),
    /**
     * コード:E1 名称:仮徴収額の変更 略称:定義なし
     */
    仮徴収額の変更("E1", "仮徴収額の変更"),
    /**
     * コード:E2 名称:期別修正による更正 略称:定義なし
     */
    期別修正による更正("E2", "期別修正による更正"),
    /**
     * コード:E3 名称:平準化による変更6月 略称:定義なし
     */
    平準化による変更6月("E3", "平準化による変更6月"),
    /**
     * コード:E4 名称:平準化による変更8月 略称:定義なし
     */
    平準化による変更8月("E4", "平準化による変更8月"),
    /**
     * コード:F1 名称:職権変更 略称:定義なし
     */
    職権変更("F1", "職権変更"),
    /**
     * コード:G1 名称:口座情報変更 略称:定義なし
     */
    口座情報変更("G1", "口座情報変更"),
    /**
     * コード:K1 名称:過年度更正 略称:定義なし
     */
    過年度更正("K1", "過年度更正"),
    /**
     * コード:S1 名称:歳出還付による減額 略称:定義なし
     */
    歳出還付による減額("S1", "歳出還付による減額"),
    /**
     * コード:T1 名称:年金保険者からの通知 略称:定義なし
     */
    年金保険者からの通知("T1", "年金保険者からの通知"),
    /**
     * コード:T2 名称:保険料額の減額変更 略称:定義なし
     */
    保険料額の減額変更("T2", "保険料額の減額変更"),
    /**
     * コード:T3 名称:職権変更特徴中止 略称:定義なし
     */
    職権変更特徴中止("T3", "職権変更特徴中止"),
    /**
     * コード:T4 名称:徴収方法修正 略称:定義なし
     */
    徴収方法修正("T4", "徴収方法修正"),
    /**
     * コード:T5 名称:特別徴収対象者外 略称:定義なし
     */
    特別徴収対象者外("T5", "特別徴収対象者外"),
    /**
     * コード:T6 名称:資格喪失特徴中止 略称:定義なし
     */
    資格喪失特徴中止("T6", "資格喪失特徴中止"),
    /**
     * コード:T7 名称:保険料算定結果で特徴中止 略称:定義なし
     */
    保険料算定結果で特徴中止("T7", "保険料算定結果で特徴中止"),
    /**
     * コード:T8 名称:境界層該当特徴中止 略称:定義なし
     */
    境界層該当特徴中止("T8", "境界層該当特徴中止"),
    /**
     * コード:T9 名称:その他特徴中止 略称:定義なし
     */
    その他特徴中止("T9", "その他特徴中止"),
    /**
     * コード:Y1 名称:境界層該当 略称:定義なし
     */
    境界層該当("Y1", "境界層該当"),
    /**
     * コード:Y2 名称:境界層非該当 略称:定義なし
     */
    境界層非該当("Y2", "境界層非該当");

    private final RString code;
    private final RString fullName;

    private ChoteiJiyuCode(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 調定事由のコードを返します。
     *
     * @return 調定事由のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 調定事由の名称を返します。
     *
     * @return 調定事由の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 調定事由のコードと一致する内容を探します。
     *
     * @param code 調定事由のコード
     * @return {@code code} に対応する調定事由
     */
    public static ChoteiJiyuCode toValue(RString code) {
        for (ChoteiJiyuCode choteiJiyuCode : ChoteiJiyuCode.values()) {
            if (choteiJiyuCode.code.equals(code)) {
                return choteiJiyuCode;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("調定事由"));
    }
}
