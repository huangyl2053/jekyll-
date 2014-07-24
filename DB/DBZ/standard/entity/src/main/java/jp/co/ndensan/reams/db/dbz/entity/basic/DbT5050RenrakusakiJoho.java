package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT5050RenrakusakiJohoの項目定義クラスです
 *
 */
public enum DbT5050RenrakusakiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    renrakusakiKubunNo(8, 0),
    shishoCode(2147483647, 0),
    renrakusakiYubinNo(2147483647, 0),
    renrakusakiTelNo(2147483647, 0),
    renrakusakiJusho(2147483647, 0),
    renrakusakiShimei(2147483647, 0),
    renrakusakiKanaSimei(2147483647, 0),
    renrakusakiTuzukigara(32, 0),
    renrakusakiKeitaiTelNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5050RenrakusakiJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
