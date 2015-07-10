package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3034ShokanShinseiの項目定義クラスです
 *
 */
public enum DbT3034ShokanShinsei implements IColumnDefinition {
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
    seiriNo(10, 0),
    shoriTimestamp(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    uketsukeYMD(2147483647, 0),
    shinseiYMD(2147483647, 0),
    shinseiRiyu(100, 0),
    shinseishaKubun(1, 0),
    shinseishaNameKanji(40, 0),
    shinseishaNameKana(60, 0),
    shinseishaAddress(80, 0),
    shinseishaTelNo(15, 0),
    shinseiJigyoshaCode(10, 0),
    shiharaiKingakuTotal(9, 0),
    hokenKyufuritsu(10, 0),
    riyoshaFutangaku(10, 0),
    shikyuShinseiShinsaKubun(1, 0),
    shinsaHohoKubun(1, 0),
    sofuYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3034ShokanShinsei(int maxLength, int scale) {
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
