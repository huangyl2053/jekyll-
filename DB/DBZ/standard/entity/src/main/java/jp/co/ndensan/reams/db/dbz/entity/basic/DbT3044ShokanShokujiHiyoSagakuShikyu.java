package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3044ShokanShokujiHiyoSagakuShikyuの項目定義クラスです
 *
 */
public enum DbT3044ShokanShokujiHiyoSagakuShikyu implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    seiriNp(10, 0),
    jigyoshaNo(2147483647, 0),
    yoshikiNo(4, 0),
    shoriTimestamp(2147483647, 0),
    sagakuKingaku(10, 0),
    shikyuKubunCode(1, 0),
    tensuKingaku(10, 0),
    shikyuKingaku(10, 0),
    shikyuFushikyuRiyu(76, 0);

    private final int maxLength;
    private final int scale;

    private DbT3044ShokanShokujiHiyoSagakuShikyu(int maxLength, int scale) {
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
