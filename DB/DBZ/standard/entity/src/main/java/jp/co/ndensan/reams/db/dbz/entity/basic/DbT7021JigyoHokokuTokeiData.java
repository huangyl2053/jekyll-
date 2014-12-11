package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7021JigyoHokokuTokeiDataの項目定義クラスです
 *
 */
public enum DbT7021JigyoHokokuTokeiData implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hokokuYSeireki(2147483647, 0),
    hokokuM(2, 0),
    shukeiTaishoYSeireki(2147483647, 0),
    shukeiTaishoM(2, 0),
    toukeiTaishoKubun(1, 0),
    shichosonCode(2147483647, 0),
    hyoNo(2147483647, 0),
    shukeiNo(2147483647, 0),
    shukeiTani(2147483647, 0),
    tateNo(4, 0),
    yokoNo(4, 0),
    shoriTimestamp(29, 0),
    shukeiKekkaAtai(14, 0),
    tateKomokuCode(2147483647, 0),
    yokoKomokuCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7021JigyoHokokuTokeiData(int maxLength, int scale) {
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
