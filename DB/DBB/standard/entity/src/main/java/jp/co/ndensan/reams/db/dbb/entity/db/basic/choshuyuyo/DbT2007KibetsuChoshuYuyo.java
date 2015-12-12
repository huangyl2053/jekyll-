package jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護期別徴収猶予テーブルの項目定義クラスです。
 */
public enum DbT2007KibetsuChoshuYuyo implements IColumnDefinition {
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
     * 調定年度
     */
    choteiNendo(2147483647, 0),
    /**
     * 賦課年度
     */
    fukaNendo(2147483647, 0),
    /**
     * 通知書番号
     */
    tsuchishoNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 徴収方法
     */
    choshuHoho(1, 0),
    /**
     * 期
     */
    ki(10, 0),
    /**
     * 徴収猶予開始日
     */
    yuyoStartYMD(2147483647, 0),
    /**
     * 徴収猶予終了日
     */
    yuyoEndYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT2007KibetsuChoshuYuyo(int maxLength, int scale) {
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
