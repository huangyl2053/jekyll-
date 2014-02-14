package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 主治医情報を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum DbT7012ShujiiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    shichosonCode(5, 0),
    kaigoIryokikanCode(10, 0),
    kaigoIshiCode(8, 0),
    iryokikanCode(10, 0),
    shujiiCode(8, 0),
    shujiiJokyo(1, 0),
    yubinNo(7, 0),
    jusho(50, 0),
    telNo(14, 0),
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
