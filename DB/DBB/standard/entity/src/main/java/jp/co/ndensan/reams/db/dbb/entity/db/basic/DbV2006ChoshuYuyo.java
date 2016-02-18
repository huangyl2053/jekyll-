package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 賦課徴収猶予Newestテーブルの項目定義クラスです。
 */
public enum DbV2006ChoshuYuyo implements IColumnDefinition {
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
     * choteiNendo
     */
    choteiNendo(2147483647, 0),
    /**
     * fukaNendo
     */
    fukaNendo(2147483647, 0),
    /**
     * tsuchishoNo
     */
    tsuchishoNo(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(5, 0),
    /**
     * shinseiYMD
     */
    shinseiYMD(2147483647, 0),
    /**
     * ketteiYMD
     */
    ketteiYMD(2147483647, 0),
    /**
     * torikeshiYMD
     */
    torikeshiYMD(2147483647, 0),
    /**
     * jotaiKubun
     */
    jotaiKubun(1, 0),
    /**
     * sakuseiKubun
     */
    sakuseiKubun(1, 0),
    /**
     * shinseiJiyu
     */
    shinseiJiyu(2147483647, 0),
    /**
     * yuyoJiyuCode
     */
    yuyoJiyuCode(2147483647, 0),
    /**
     * yuyoJiyu
     */
    yuyoJiyu(2147483647, 0),
    /**
     * yuyoTorikeshiJiyuCode
     */
    yuyoTorikeshiJiyuCode(2147483647, 0),
    /**
     * yuyoTorikeshiJiyu
     */
    yuyoTorikeshiJiyu(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbV2006ChoshuYuyo(int maxLength, int scale) {
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
