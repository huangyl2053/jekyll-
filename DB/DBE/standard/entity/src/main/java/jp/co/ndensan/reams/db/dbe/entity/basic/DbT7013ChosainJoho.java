package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7013ChosainJohoの項目定義クラスです
 *
 */
public enum DbT7013ChosainJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shoKisaiHokenshaNo(6, 0),
    kaigoJigyoshaNo(10, 0),
    kaigoChosainNo(10, 0),
    jigyoshaNo(10, 0),
    kaigoChosainJokyo(1, 0),
    chosainShimei(2147483647, 0),
    chosainKanaShimei(2147483647, 0),
    seibetsu(1, 0),
    chosainShikakuCode(2147483647, 0),
    chikuCode(2147483647, 0),
    yubinNo(2147483647, 0),
    jusho(2147483647, 0),
    telNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7013ChosainJoho(int maxLength, int scale) {
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
