package jp.co.ndensan.reams.db.dbz.definition.enumeratedtype.kyotsu;

import jp.co.ndensan.reams.ur.urz.definition.message.UrSystemErrorMessages;
import jp.co.ndensan.reams.uz.uza.lang.RString;

/**
 * 連携種別を表す列挙型です。
 *
 * @author LDNS
 */
public enum RenkeiShubetsu {

    /**
     * コード:A1 名称:住民情報連動 略称:定義なし
     */
    住民情報連動("A1", "住民情報連動"),
    /**
     * コード:B1 名称:介護情報連動 略称:定義なし
     */
    介護情報連動("B1", "介護情報連動"),
    /**
     * コード:C1 名称:所得情報連動（当初） 略称:定義なし
     */
    所得情報連動_当初("C1", "所得情報連動（当初）"),
    /**
     * コード:C2 名称:所得情報連動（更正） 略称:定義なし
     */
    所得情報連動_更正("C2", "所得情報連動（更正）"),
    /**
     * コード:D1 名称:納付情報連動 略称:定義なし
     */
    納付情報連動("D1", "納付情報連動"),
    /**
     * コード:E1 名称:特別徴収対象者情報 略称:定義なし
     */
    特別徴収対象者情報("E1", "特別徴収対象者情報"),
    /**
     * コード:E2 名称:特別徴収依頼処理結果情報 略称:定義なし
     */
    特別徴収依頼処理結果情報("E2", "特別徴収依頼処理結果情報"),
    /**
     * コード:E3 名称:特別徴収結果情報 略称:定義なし
     */
    特別徴収結果情報("E3", "特別徴収結果情報"),
    /**
     * コード:F1 名称:特別徴収依頼情報 略称:定義なし
     */
    特別徴収依頼情報("F1", "特別徴収依頼情報"),
    /**
     * コード:F2 名称:特別徴収各種異動情報 略称:定義なし
     */
    特別徴収各種異動情報("F2", "特別徴収各種異動情報"),
    /**
     * コード:F3 名称:特徴依頼データ 略称:定義なし
     */
    特徴依頼データ("F3", "特徴依頼データ"),
    /**
     * コード:G1 名称:後期高齢者情報連動 略称:定義なし
     */
    後期高齢者情報連動("G1", "後期高齢者情報連動"),
    /**
     * コード:H1 名称:国保情報連動 略称:定義なし
     */
    国保情報連動("H1", "国保情報連動"),
    /**
     * コード:I1 名称:介護資格情報連動 略称:定義なし
     */
    介護資格情報連動("I1", "介護資格情報連動");

    private final RString code;
    private final RString fullName;

    private RenkeiShubetsu(String code, String fullname) {
        this.code = new RString(code);
        this.fullName = new RString(fullname);
    }

    /**
     * 連携種別のコードを返します。
     *
     * @return 連携種別のコード
     */
    public RString getコード() {
        return code;
    }

    /**
     * 連携種別の名称を返します。
     *
     * @return 連携種別の名称
     */
    public RString get名称() {
        return fullName;
    }

    /**
     * 連携種別のコードと一致する内容を探します。
     *
     * @param code 連携種別のコード
     * @return {@code code} に対応する連携種別
     */
    public static RenkeiShubetsu toValue(RString code) {

        for (RenkeiShubetsu renkeiShubetsu : RenkeiShubetsu.values()) {
            if (renkeiShubetsu.code.equals(code)) {
                return renkeiShubetsu;
            }
        }
        throw new IllegalArgumentException(UrSystemErrorMessages.変換不可.getReplacedMessage("連携種別"));
    }
}
