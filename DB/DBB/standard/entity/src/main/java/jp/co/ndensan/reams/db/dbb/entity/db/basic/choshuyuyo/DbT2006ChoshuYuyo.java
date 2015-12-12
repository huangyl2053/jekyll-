package jp.co.ndensan.reams.db.dbb.entity.db.basic.choshuyuyo;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護賦課徴収猶予テーブルの項目定義クラスです。
 */
public enum DbT2006ChoshuYuyo implements IColumnDefinition {
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
     * 徴収猶予申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 徴収猶予決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 徴収猶予取消年月日
     */
    torikeshiYMD(2147483647, 0),
    /**
     * 徴収猶予状態区分
     */
    jotaiKubun(1, 0),
    /**
     * 徴収猶予作成区分
     */
    sakuseiKubun(1, 0),
    /**
     * 申請事由
     */
    shinseiJiyu(2147483647, 0),
    /**
     * 徴収猶予種類コード
     */
    yuyoJiyuCode(2147483647, 0),
    /**
     * 徴収猶予事由
     */
    yuyoJiyu(2147483647, 0),
    /**
     * 徴収猶予取消種類コード
     */
    yuyoTorikeshiJiyuCode(2147483647, 0),
    /**
     * 徴収猶予取消事由
     */
    yuyoTorikeshiJiyu(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT2006ChoshuYuyo(int maxLength, int scale) {
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
