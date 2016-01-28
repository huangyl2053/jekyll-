package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7014KaigoSetaiの項目定義クラスです
 *
 */
public enum DbT7014KaigoSetai implements IColumnDefinition {
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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 管理識別区分
     * <br/>1：賦課、2：高額介護、3：負担限度額、4：社福軽減
     */
    kanriShikibetsuKubun(1, 0),
    /**
     * 世帯把握基準年月日
     */
    setaiHaakuKijunYMD(2147483647, 0),
    /**
     * 世帯員管理連番
     */
    setaiInkanriRenban(10, 0),
    /**
     * 世帯員識別コード
     */
    setaiInshikibetsuCode(2147483647, 0),
    /**
     * 本人区分
     * <br/>1：本人、2：世帯構成員
     */
    honninKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7014KaigoSetai(int maxLength, int scale) {
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
