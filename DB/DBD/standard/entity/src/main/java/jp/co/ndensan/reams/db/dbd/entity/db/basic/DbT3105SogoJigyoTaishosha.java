package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 総合事業対象者テーブルの項目定義クラスです。
 */
public enum DbT3105SogoJigyoTaishosha implements IColumnDefinition {
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
     * 適用開始年月日
     */
    tekiyoKaishiYMD(2147483647, 0),
    /**
     * 適用終了年月日
     */
    tekiyoShuryoYMD(2147483647, 0),
    /**
     * 受付年月日
     */
    uketsukeYMD(2147483647, 0),
    /**
     * 決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * チェックリスト実施日
     */
    checklistJisshiYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3105SogoJigyoTaishosha(int maxLength, int scale) {
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
