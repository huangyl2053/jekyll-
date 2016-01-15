package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 高額受領委任契約事業者テーブルの項目定義クラスです。
 */
public enum DbT3076KogakuJuryoininKeiyakuJigyosha implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 受付年月日
     */
    uketsukeYMD(2147483647, 0),
    /**
     * 事業者番号
     * <br/>受領委任対象の事業者番号
     */
    jigyoshaNo(2147483647, 0),
    /**
     * 決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 承認結果区分
     * <br/>0:承認しない,1:承認する
     */
    shoninKekkaKubun(1, 0),
    /**
     * 受領委任払適用開始年月日
     */
    juryoininKaishiYMD(2147483647, 0),
    /**
     * 受領委任払適用終了年月日
     */
    juryoininShuryoYMD(2147483647, 0),
    /**
     * 契約番号
     * <br/>開始年月日が属する西暦年度（4桁）＋契約事業者・年度単位に１からの連番（4桁）
     */
    keiyakuNo(8, 0),
    /**
     * 不承認理由
     */
    fuShoninRiyu(100, 0),
    /**
     * 利用者負担上限額
     */
    riyoshaFutanJogenGaku(9, 0),
    /**
     * 承認結果通知書作成日
     */
    shoninKekkaTsuchiSakuseiYMD(2147483647, 0),
    /**
     * 承認結果通知書再発行区分
     */
    shoninKekkaTsuchiSaiHakkoKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3076KogakuJuryoininKeiyakuJigyosha(int maxLength, int scale) {
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
