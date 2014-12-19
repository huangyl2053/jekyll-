package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3073KogakuGassanShikyugakuKeisanKekkaMeisaiの項目定義クラスです
 *
 */
public enum DbT3073KogakuGassanShikyugakuKeisanKekkaMeisai implements IColumnDefinition {
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
    shoKisaiHokenshaNo(2147483647, 0),
    shikyuShinseishoSeiriNo(17, 0),
    meisanNo(2, 0),
    shoriTimestamp(2147483647, 0),
    hokenSeidoCode(1, 0),
    uchiwakeHokenshaNo(8, 0),
    kokuho_HihokenshaShoKigo(20, 0),
    hiHokenshaShoNo(20, 0),
    uchiwakeHokenshaMei(20, 0),
    jikoFutanSeiriNo(20, 0),
    taishoshaShimei(20, 0),
    over70_Futangaku(10, 0),
    over70_AmbunRitsu(17, 0),
    over70_Shikyugaku(10, 0),
    under70_Futangaku(10, 0),
    futangaku(10, 0),
    ambunRitsu(17, 0),
    under70_Shikyugaku(10, 0),
    shikyugaku(10, 0),
    over70_Biko(10, 0),
    under70_Biko(10, 0),
    dataKubun(1, 0),
    uketoriYM(2147483647, 0),
    sofuYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3073KogakuGassanShikyugakuKeisanKekkaMeisai(int maxLength, int scale) {
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
