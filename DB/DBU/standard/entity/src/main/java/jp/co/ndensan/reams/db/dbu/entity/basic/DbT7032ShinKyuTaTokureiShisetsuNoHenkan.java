package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 新旧他特例施設番号変換テーブルテーブルの項目定義クラスです。
 */
public enum DbT7032ShinKyuTaTokureiShisetsuNoHenkan implements IColumnDefinition {
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
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 新他特例施設番号
     */
    shinTaTokureiShisetsuNo(10, 0),
    /**
     * 旧他特例施設番号
     */
    kyuTaTokureiShisetsuNo(10, 0),
    /**
     * 市町村コード２
     */
    shichosonCode2(2147483647, 0),
    /**
     * 旧他特例施設番号２
     */
    kyuTaTokureiShisetsuNo2(10, 0);

    private final int maxLength;
    private final int scale;

    private DbT7032ShinKyuTaTokureiShisetsuNoHenkan(int maxLength, int scale) {
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
