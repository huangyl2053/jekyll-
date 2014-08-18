package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT5022RenkeiyoDataSofuKirokuの項目定義クラスです
 *
 */
public enum DbT5022RenkeiyoDataSofuKiroku implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.2">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinseishoKanriNo(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    ninteiShinseiShinseijiKubun(2147483647, 0),
    hikiwatashiKubun(1, 0),
    hikiwatashiNichiji(2147483647, 0),
    saiSoufuKubun(2, 0),
    saiChousaSoufuKubun(1, 0),
    saiIkenshoSoufuKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT5022RenkeiyoDataSofuKiroku(int maxLength, int scale) {
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
