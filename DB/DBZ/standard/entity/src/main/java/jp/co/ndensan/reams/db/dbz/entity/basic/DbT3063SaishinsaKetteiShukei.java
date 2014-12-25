package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3063SaishinsaKetteiShukeiの項目定義クラスです
 *
 */
public enum DbT3063SaishinsaKetteiShukei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    toriatsukaiYM(2147483647, 0),
    hokenshaKubun(1, 0),
    shoriTimestamp(2147483647, 0),
    kaigoKyufuhiSeikyuKensu(10, 0),
    kaigoKyufuhiSeikyuTanisu(12, 0),
    kaigoKyufuhiSeikyuFutangaku(12, 0),
    kaigoKyufuhiKetteiKensu(10, 0),
    kaigoKyufuhiKetteiTanisu(12, 0),
    kaigoKyufuhiKetteiFutangaku(12, 0),
    kaigoKyufuhiChoseiKensu(10, 0),
    kaigoKyufuhiChoseiTanisu(13, 0),
    kaigoKyufuhiChoseiFutangaku(13, 0),
    kogakuKaigoServicehiSeikyuKensu(10, 0),
    kogakuKaigoServicehiSeikyuTanisu(12, 0),
    kogakuKaigoServicehiSeikyuFutangaku(12, 0),
    kogakuKaigoServicehiKetteiKensu(10, 0),
    kogakuKaigoServicehiKetteiTanisu(12, 0),
    kogakuKaigoServicehiKetteiFutangaku(12, 0),
    kogakuKaigoServicehiChoseiKensu(10, 0),
    kogakuKaigoServicehiChoseiTanisu(13, 0),
    kogakuKaigoServicehiChoseiFutangaku(13, 0),
    kohiFutanshaNo(8, 0),
    sakuseiYMD(2147483647, 0),
    sinsaiinkaiName(15, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3063SaishinsaKetteiShukei(int maxLength, int scale) {
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
