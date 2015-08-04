package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 老齢福祉年金受給者テーブルの項目定義クラスです。
 * <br/> 老齢福祉年金受給者	 老齢福祉年金受給者を管理する
 */
public enum DbT7006RoreiFukushiNenkinJukyusha implements IColumnDefinition {
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
     * 識別コード
     * <br/>識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 受給開始年月日
     * <br/>受給開始年月日
     */
    jukyuKaishiYMD(2147483647, 0),
    /**
     * 受給終了年月日
     * <br/>受給終了年月日
     */
    jukyuShuryoYMD(2147483647, 0),
    /**
     * 被保険者番号
     * <br/>被保険者番号
     */
    hihokenshaNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7006RoreiFukushiNenkinJukyusha(int maxLength, int scale) {
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
