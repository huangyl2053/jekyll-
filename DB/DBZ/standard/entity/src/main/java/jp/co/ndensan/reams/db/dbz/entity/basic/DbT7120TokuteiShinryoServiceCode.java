package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7120TokuteiShinryoServiceCodeの項目定義クラスです
 *
 */
public enum DbT7120TokuteiShinryoServiceCode implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    serviceShuruiCode(2147483647, 0),
    serviceKomokuCode(2147483647, 0),
    tekiyoKaishiYM(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    tekiyoShuryoYM(2147483647, 0),
    serviceMeisho(100, 0),
    taniSu(10, 0),
    taniSuShikibetsu(2, 0),
    santeiTani(2, 0),
    goseiShikibetsuKubun(1, 0),
    tokuteiShinryoKubunCode(2, 0),
    tokuteiShinryoKomokuCode(2, 0),
    santeiSeiyakuKikan(2, 0),
    santeiSeiyakuKaisu(6, 0);

    private final int maxLength;
    private final int scale;

    private DbT7120TokuteiShinryoServiceCode(int maxLength, int scale) {
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
