package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3104KokuhorenInterfaceKanriの項目定義クラスです
 *
 */
public enum DbT3104KokuhorenInterfaceKanri implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.7">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shoriYM(2147483647, 0),
    kokanShikibetsuNo(3, 0),
    sofuTorikomiKubun(1, 0),
    shoriJotaiKubun(1, 0),
    shoriJisshiTimestamp(2147483647, 0),
    chushutsuKaishiTimestamp(2147483647, 0),
    chushutsuShuryoTimestamp(2147483647, 0),
    saiShoriKahiKubun(1, 0),
    shoriJikkoKaisu(3, 0),
    fileName1(20, 0),
    fileName2(20, 0),
    fileName3(20, 0),
    fileName4(20, 0),
    fileName5(20, 0),
    fileKensu1(10, 0),
    fileKensu2(10, 0),
    fileKensu3(10, 0),
    fileKensu4(10, 0),
    fileKensu5(10, 0),
    saiShoriFukaKubun(1, 0),
    ctrlRecordKensu(10, 0),
    ctrlShoriYM(2147483647, 0),
    kagoCtrlRecordKensu(10, 0),
    kagoCtrlShoriYM(2147483647, 0),
    jissekiDataShinsaYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3104KokuhorenInterfaceKanri(int maxLength, int scale) {
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
