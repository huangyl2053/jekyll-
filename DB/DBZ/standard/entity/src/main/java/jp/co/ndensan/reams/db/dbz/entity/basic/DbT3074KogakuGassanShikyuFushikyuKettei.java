package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3074KogakuGassanShikyuFushikyuKetteiの項目定義クラスです
 *
 */
public enum DbT3074KogakuGassanShikyuFushikyuKettei implements IColumnDefinition {
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
    shikyuSeiriNo(17, 0),
    shoriTimestamp(2147483647, 0),
    jikoFutanSeiriNo(20, 0),
    hokenSeidoCode(1, 0),
    kokuho_HihokenshaShoKigo(20, 0),
    keisanKaishiYMD(2147483647, 0),
    keisanShuryoYMD(2147483647, 0),
    shinseiYMD(2147483647, 0),
    ketteiYMD(2147483647, 0),
    jikoFutanSogaku(10, 0),
    shikyuKubunCode(1, 0),
    shikyugaku(10, 0),
    kyufuShurui(50, 0),
    fushikyuRiyu(100, 0),
    biko(100, 0),
    shiharaiHohoKubun(1, 0),
    shiharaiBasho(64, 0),
    shiharaiKaishiYMD(2147483647, 0),
    shiharaiShuryoYMD(2147483647, 0),
    heichoNaiyo(50, 0),
    shiharaiKaishiTime(4, 0),
    shiharaiShuryoTime(4, 0),
    shikibetsuCode(2147483647, 0),
    ketteiTsuchiSakuseiYMD(2147483647, 0),
    furikomiTsuchiSakuseiYMD(2147483647, 0),
    uketoriYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3074KogakuGassanShikyuFushikyuKettei(int maxLength, int scale) {
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
