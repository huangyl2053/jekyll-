package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3071KogakuGassanJikoFutanGakuMeisaiの項目定義クラスです
 *
 */
public enum DbT3071KogakuGassanJikoFutanGakuMeisai implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    taishoNendo(2147483647, 0),
    hokenshaNo(2147483647, 0),
    shikyuShinseishoSeiriNo(17, 0),
    taishoM(3, 0),
    shoriTimestamp(2147483647, 0),
    jikoFutanGaku(10, 0),
    uchisu_70_74JikoFutanGaku(10, 0),
    under_70KogakuShikyuGaku(10, 0),
    over_70_74KogakuShikyuGaku(10, 0),
    tekiyo(20, 0),
    sumi_JikoFutanGaku(10, 0),
    sumi_70_74JikoFutanGaku(10, 0),
    sumi_under_70KogakuShikyuGaku(10, 0),
    sumi_70_74KogakuShikyuGaku(10, 0),
    sumi_Tekiyo(20, 0);

    private final int maxLength;
    private final int scale;

    private DbT3071KogakuGassanJikoFutanGakuMeisai(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
