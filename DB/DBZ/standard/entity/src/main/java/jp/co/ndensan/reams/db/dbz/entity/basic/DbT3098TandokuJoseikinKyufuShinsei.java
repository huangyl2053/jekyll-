package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3098TandokuJoseikinKyufuShinseiの項目定義クラスです
 *
 */
public enum DbT3098TandokuJoseikinKyufuShinsei implements IColumnDefinition {
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
    shinseiYMD(2147483647, 0),
    shinseishaKubun(1, 0),
    daikoJigyoshaNo(2147483647, 0),
    jigyoshaKubun(1, 0),
    shinseishaYubinNo(2147483647, 0),
    shinseishaJusho(100, 0),
    shinseishaTelNo(2147483647, 0),
    shinseiRiyu(200, 0),
    tandokuJoseiShuruiCode(2, 0);

    private final int maxLength;
    private final int scale;

    private DbT3098TandokuJoseikinKyufuShinsei(int maxLength, int scale) {
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
