package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 負担限度額一括認定テーブルの項目定義クラスです。
 */
public enum DbT4035FutanGendogakuNinteiBatch implements IColumnDefinition {
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
     * 一括認定バッチ処理日時
     */
    ninteiBatchExecutedTimestamp(2147483647, 0),
    /**
     * 作成年度
     */
    sakuseiNendo(2147483647, 0),
    /**
     * 決定日
     */
    ketteiYmd(2147483647, 0),
    /**
     * テスト処理フラグ
     */
    isTest(1, 0),
    /**
     * 承認済みフラグ
     */
    hadApproved(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT4035FutanGendogakuNinteiBatch(int maxLength, int scale) {
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
