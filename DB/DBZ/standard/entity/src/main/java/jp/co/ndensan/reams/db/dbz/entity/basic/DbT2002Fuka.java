package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT2002Fukaの項目定義クラスです
 *
 */
public enum DbT2002Fuka implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    choteiNendo(2147483647, 0),
    fukaNendo(2147483647, 0),
    tsuchishoNo(2147483647, 0),
    shoriTimestamp(29, 0),
    hihokenshaNo(2147483647, 0),
    shikibetsuCode(2147483647, 0),
    setaiCode(2147483647, 0),
    setaiInsu(5, 0),
    fukaYMD(2147483647, 0),
    kazeiKubun(1, 0),
    setaikazeiKubun(1, 0),
    gokeiShotokuGaku(12, 0),
    nenkinShunyuGaku(12, 0),
    hokenryoDankai(3, 0),
    hokenryoDankai1(3, 0),
    nengakuHokenryo1(7, 0),
    tsukiwariStartYM1(2147483647, 0),
    tsukiwariEndYM1(2147483647, 0),
    hokenryoDankai2(3, 0),
    nengakuHokenryo2(7, 0),
    tsukiwariStartYM2(2147483647, 0),
    tsukiwariEndYM2(2147483647, 0),
    choteiYMDHM(2147483647, 0),
    choteiJiyu1(2, 0),
    choteiJiyu2(2, 0),
    choteiJiyu3(2, 0),
    choteiJiyu4(2, 0),
    koseiM(2, 0),
    gemmenMaeHokenryo(7, 0),
    gemmenGaku(7, 0),
    kakuteiHokenryo(7, 0),
    hokenryoDankaiKarisanntei(3, 0),
    choshuHohoShoriTimestamp(29, 0),
    idoKijunTimestamp(29, 0);

    private final int maxLength;
    private final int scale;

    private DbT2002Fuka(int maxLength, int scale) {
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
