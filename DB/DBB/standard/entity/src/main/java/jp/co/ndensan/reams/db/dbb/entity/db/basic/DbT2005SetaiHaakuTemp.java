package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 世帯員把握テーブルの項目定義クラスです。
 */
public enum DbT2005SetaiHaakuTemp implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    /**
     * hihokenshaNo
     */
    hihokenshaNo(2147483647, 0),
    /**
     * shikibetsuCode
     */
    shikibetsuCode(2147483647, 0),
    /**
     * kijunYMD
     */
    kijunYMD(2147483647, 0),
    /**
     * shotokuNendo
     */
    shotokuNendo(2147483647, 0),
    /**
     * jushochiTokureiFlag
     */
    jushochiTokureiFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT2005SetaiHaakuTemp(int maxLength, int scale) {
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
