package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3055KogakuKyufuTaishoshaGokeiの項目定義クラスです
 *
 */
public enum DbT3055KogakuKyufuTaishoshaGokei implements IColumnDefinition {
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
    serviceTeikyoYM(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    serviceHiyoGokeiGakuGokei(9, 0),
    riyoshaFutanGakuGokei(9, 0),
    santeiKijunGaku(9, 0),
    shiharaiSumiKingakuGokei(9, 0),
    KogakuShikyuGaku(9, 0),
    tashoshaUketoriYM(2147483647, 0),
    taishoshaHanteiShinsaYM(2147483647, 0),
    setaiShuyakuNo(10, 0),
    kyokaisoTaishoshaFlag(1, 0),
    hojinKeigenTaishoFlag(1, 0),
    kogakuTaishoGaiFlag(1, 0),
    jidoShokanTaishoFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3055KogakuKyufuTaishoshaGokei(int maxLength, int scale) {
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
