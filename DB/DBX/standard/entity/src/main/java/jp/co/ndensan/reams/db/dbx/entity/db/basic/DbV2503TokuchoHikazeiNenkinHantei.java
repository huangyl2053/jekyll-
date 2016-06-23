package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 特徴非課税年金判定テーブルの項目定義クラスです。
 */
public enum DbV2503TokuchoHikazeiNenkinHantei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    /**
     * tsuchishoNo
     */
    tsuchishoNo(2147483647, 0),
    /**
     * choteiNendo
     */
    choteiNendo(2147483647, 0),
    /**
     * kazeiNendo
     */
    kazeiNendo(2147483647, 0),
    /**
     * ki
     */
    ki(10, 0),
    /**
     * isHikazeiNenkin
     */
    isHikazeiNenkin(1, 0);

    private final int maxLength;
    private final int scale;

    private DbV2503TokuchoHikazeiNenkinHantei(int maxLength, int scale) {
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
