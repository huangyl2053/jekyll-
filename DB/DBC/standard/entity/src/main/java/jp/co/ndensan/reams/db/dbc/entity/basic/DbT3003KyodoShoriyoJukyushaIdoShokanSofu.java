package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 共同処理用受給者異動償還送付テーブルの項目定義クラスです。
 */
public enum DbT3003KyodoShoriyoJukyushaIdoShokanSofu implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">
    /**
     * insertDantaiCd
     */
    insertDantaiCd(2147483647, 0),
    /**
     * insertTimestamp
     */
    insertTimestamp(29, 0),
    /**
     * insertReamsLoginId
     */
    insertReamsLoginId(2147483647, 0),
    /**
     * insertContextId
     */
    insertContextId(2147483647, 0),
    /**
     * isDeleted
     */
    isDeleted(1, 0),
    /**
     * updateCount
     */
    updateCount(10, 0),
    /**
     * lastUpdateTimestamp
     */
    lastUpdateTimestamp(29, 0),
    /**
     * lastUpdateReamsLoginId
     */
    lastUpdateReamsLoginId(2147483647, 0),
    /**
     * 異動年月日
     */
    idoYMD(2147483647, 0),
    /**
     * 異動区分コード
     * <br/>1:新規,2:変更,3:終了
     */
    idoKubunCode(1, 0),
    /**
     * 受給者異動事由
     * <br/>01:受給資格取得,02:受給資格喪失,03広域連合市町村間異動（政令市区間異動）,04:合併による新規,99:その他異動
     */
    jukyushaIdoJiyu(2, 0),
    /**
     * 証記載保険者番号
     * <br/>Not（地方公共団体コード（導入団体）⇒保険者番号）
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 保険給付支払一時差止開始年月日
     */
    hokenKyufuIchijiSashitomeKaishiYMD(2147483647, 0),
    /**
     * 保険給付支払一時差止終了年月日
     */
    hokenKyufuIchijiSashitomeShuryoYMD(2147483647, 0),
    /**
     * 保険給付支払一時差止区分コード
     * <br/>1:一部差止,2:全部差止
     */
    hokenkyufuIchijiSashitomeKubunCode(1, 0),
    /**
     * 保険給付支払一時差止金額
     * <br/>保険給付支払一時差止区分コードが「1」の場合、必須
     */
    hokenkyufuIchijiSashitomeKingaku(9, 0),
    /**
     * 訂正連絡票フラグ
     * <br/>異動or訂正 訂正ならtrue
     */
    teiseiRenrakuhyoFlag(1, 0),
    /**
     * 送付年月
     */
    sofuYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3003KyodoShoriyoJukyushaIdoShokanSofu(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     * 
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     * 
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
