package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3075KogakuGassanKyufuJissekiの項目定義クラスです
 *
 */
public enum DbT3075KogakuGassanKyufuJisseki implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    kokanJohoShikibetsuNo(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    shikyuShinseiSeiriNo(17, 0),
    seiriNo(10, 0),
    shoriTimestamp(2147483647, 0),
    jikoFutanSeiriNo(20, 0),
    hokenSeidoCode(1, 0),
    kyufuJissekiSakuseiKubunCode(1, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    kokuho_HihokenshaShoKigo(20, 0),
    shinseiYMD(2147483647, 0),
    ketteiYMD(2147483647, 0),
    jikoFutanSogaku(10, 0),
    shikyuGaku(10, 0),
    shoriYM(2147483647, 0),
    uketoriYM(2147483647, 0),
    sofuYM(2147483647, 0),
    dataKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3075KogakuGassanKyufuJisseki(int maxLength, int scale) {
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
