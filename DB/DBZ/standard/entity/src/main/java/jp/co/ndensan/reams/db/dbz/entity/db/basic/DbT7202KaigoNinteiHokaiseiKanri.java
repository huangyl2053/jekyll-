package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護認定法改正管理テーブルの項目定義クラスです。
 */
public enum DbT7202KaigoNinteiHokaiseiKanri implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    /**
     * insertDantaiCd
     */
    insertDantaiCd(2147483647, 0),
    /**
     * insertTimestamp
     */
    insertTimestamp(29, 0),
    /**
     * insertReamsLoginId
     */
    insertReamsLoginId(2147483647, 0),
    /**
     * insertContextId
     */
    insertContextId(2147483647, 0),
    /**
     * isDeleted
     */
    isDeleted(1, 0),
    /**
     * updateCount
     */
    updateCount(10, 0),
    /**
     * lastUpdateTimestamp
     */
    lastUpdateTimestamp(29, 0),
    /**
     * lastUpdateReamsLoginId
     */
    lastUpdateReamsLoginId(2147483647, 0),
    /**
     * 法改正施行年月日
     */
    hokaiseiShikoYMD(2147483647, 0),
    /**
     * 厚労省IF識別コード
     */
    koroshoIfShikibetsuCode(3, 0),
    /**
     * 認定調査概況項目変更フラグ
     */
    chosaGaikyoKomokuChangeFlag(1, 0),
    /**
     * 認定調査基本項目変更フラグ
     */
    chosaKihonKomokuChangeFlag(1, 0),
    /**
     * 主治医意見書項目変更フラグ
     */
    shujiiIkenshoKomokuChangeFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7202KaigoNinteiHokaiseiKanri(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長のgetメソッドです。
     * 
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 小数点以下の桁数のgetメソッドです。
     * 
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
