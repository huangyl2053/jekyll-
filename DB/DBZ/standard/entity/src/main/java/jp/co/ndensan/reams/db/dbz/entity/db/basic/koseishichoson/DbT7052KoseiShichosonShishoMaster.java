package jp.co.ndensan.reams.db.dbz.entity.db.basic.koseishichoson;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 構成市町村支所マスタテーブルの項目定義クラスです。
 * <br/> 構成・単独市町村単位の支所を管理する
 */
public enum DbT7052KoseiShichosonShishoMaster implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

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
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 支所コード
     */
    shishoCode(2147483647, 0),
    /**
     * 支所名
     */
    shishoMei(80, 0);

    private final int maxLength;
    private final int scale;

    private DbT7052KoseiShichosonShishoMaster(int maxLength, int scale) {
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
