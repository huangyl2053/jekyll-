package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7034KoikiGaijiHenkanErrorLogの項目定義クラスです
 *
 */
public enum DbT7034KoikiGaijiHenkanErrorLog implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shoriNo(18, 0),
    renNo(8, 0),
    shichosonCode(2147483647, 0),
    shubetsu(2, 0),
    shoriTimestamp(29, 0),
    motoShichosonCode(2147483647, 0),
    motoShichosonMeisho(20, 0),
    sakiShichosonCode(2147483647, 0),
    sakiShichosonMeisho(20, 0),
    jukiShikibetsuCode(2147483647, 0),
    kakuninKubun(1, 0),
    shikibetsuCode(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    recoadNo(6, 0),
    errorKomokuMeisho(20, 0),
    errorKomokuNo(4, 0),
    errorCode(4, 0),
    errorHyojiRenban(2, 0),
    errorHyojiKomokuMeisho(20, 0),
    errorHyojiKomoku(50, 0);

    private final int maxLength;
    private final int scale;

    private DbT7034KoikiGaijiHenkanErrorLog(int maxLength, int scale) {
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
