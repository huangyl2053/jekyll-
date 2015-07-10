package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3060KagoKetteiShukeiの項目定義クラスです
 *
 */
public enum DbT3060KagoKetteiShukei implements IColumnDefinition {
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
    kaigoKyufuhiKensu(10, 0),
    kaigoKyufuhiTanisu(13, 0),
    kaigoKyufuhiFutangaku(13, 0),
    kogakuServicehiKensu(10, 0),
    kogakuServicehiTanisu(13, 0),
    kogakuServicehiFutangaku(13, 0),
    tokuteiNyushoshaServicehiKensu(10, 0),
    tokuteiNyushoshaServicehiTanisu(13, 0),
    tokuteiNyushoshaServicehiFutangaku(13, 0),
    kohiFutanshaNo(8, 0),
    sakuseiYMD(2147483647, 0),
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3060KagoKetteiShukei(int maxLength, int scale) {
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
