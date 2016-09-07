package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 住宅改修理由書作成手数料請求決定テーブルの項目定義クラスです。
 */
public enum DbT3094JutakuKaishuRiyushoTesuryoKettei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * 介護住宅改修理由書作成事業者番号
     */
    riyushoSakuseiJigyoshaNo(2147483647, 0),
    /**
     * 決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 支給・不支給決定年月日
     */
    shikyu_FushikyuKetteiYMD(2147483647, 0),
    /**
     * 支給・不支給区分
     */
    shikyu_FushikyuKubun(1, 0),
    /**
     * 償還不支給理由等
     */
    fushikyuRiyu(200, 0),
    /**
     * 住宅改修理由書作成手数料支払予定日
     */
    tesuryoShiharaiYoteiYMD(2147483647, 0),
    /**
     * 集計関連付け番号
     * <br/>連番
     */
    shukeiNo(6, 0),
    /**
     * 決定通知書作成年月日
     */
    ketteiTsuchiSakuseiYMD(2147483647, 0),
    /**
     * 振込通知書作成年月日
     */
    furikomiTsuchiSakuseiYMD(2147483647, 0),
    /**
     * 受取年月
     */
    uketoriYM(2147483647, 0),
    /**
     * 口座ID
     */
    kozaID(19, 0);

    private final int maxLength;
    private final int scale;

    private DbT3094JutakuKaishuRiyushoTesuryoKettei(int maxLength, int scale) {
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
