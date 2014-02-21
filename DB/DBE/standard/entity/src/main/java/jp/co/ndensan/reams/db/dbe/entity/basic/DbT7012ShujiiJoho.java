package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7012ShujiiJohoの項目定義クラスです
 *
 */
public enum DbT7012ShujiiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shichosonCode(5, 0),
    kaigoIryokikanCode(10, 0),
    kaigoIshiCode(8, 0),
    iryokikanCode(10, 0),
    shujiiCode(8, 0),
    shujiiJokyo(1, 0),
    yubinNo(2147483647, 0),
    jusho(2147483647, 0),
    telNo(2147483647, 0),
    faxNo(16, 0);
    private final int maxLength;
    private final int scale;

    private DbT7012ShujiiJoho(int maxLength, int scale) {
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
