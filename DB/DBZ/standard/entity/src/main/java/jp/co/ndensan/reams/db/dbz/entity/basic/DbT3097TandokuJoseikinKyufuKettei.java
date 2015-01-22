package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3097TandokuJoseikinKyufuKetteiの項目定義クラスです
 *
 */
public enum DbT3097TandokuJoseikinKyufuKettei implements IColumnDefinition {
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
    uketsukeYMD(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    ketteiYMD(2147483647, 0),
    tekiyoKaishiYMD(2147483647, 0),
    yukoKigenYMD(2147483647, 0),
    riyoshaFutan_KetteiKubun(1, 0),
    riyoshaFutan_FuShoninRiyu(200, 0),
    kohi_JukyushaNo(8, 0),
    kohi_FutanshaNo(8, 0),
    kyufuRitsu(2147483647, 0),
    jukyushaNo(8, 0),
    keikaSochiKubun(1, 0),
    kuniKeigenKubun(1, 0),
    shakaiFukushiHojinKeigenKubun(1, 0),
    tokubetsuChiikiKasanKubun(1, 0),
    taino_HoryuKubun(1, 0),
    ninteiShinseichu_HoryuKubun(1, 0),
    ninteiKigenGire_HoryuKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3097TandokuJoseikinKyufuKettei(int maxLength, int scale) {
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
