package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 申請書発行対象者把握テーブルの項目定義クラスです。
 * <br/> 申請書発行対象者把握処理の内容を保持する。
 */
public enum DbT4030ShinseishoHakkoTaishoshaHaakuBatch implements IColumnDefinition {
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
     * 把握処理ID
     */
    haakuShoriID(2147483647, 0),
    /**
     * バッチ処理日時
     */
    batchExecutedTimestamp(2147483647, 0),
    /**
     * 減免減額種類
     */
    gemmenGengakuShurui(2, 0),
    /**
     * 基準日
     */
    kijunYmd(2147483647, 0),
    /**
     * 所得年度
     */
    shotokuNendo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT4030ShinseishoHakkoTaishoshaHaakuBatch(int maxLength, int scale) {
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
