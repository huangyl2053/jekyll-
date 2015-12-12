package jp.co.ndensan.reams.db.dbb.entity.db.basic.rentainofugimusha;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 連帯納付義務者テーブルの項目定義クラスです。
 */
public enum DbT2009RentaiGimusha implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
     * 識別コード
     * <br/>連帯納付義務者の識別コード
     */
    shikibetuCode(2147483647, 0),
    /**
     * 開始年月日
     */
    startYMD(2147483647, 0),
    /**
     * 終了年月日
     */
    endYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT2009RentaiGimusha(int maxLength, int scale) {
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
