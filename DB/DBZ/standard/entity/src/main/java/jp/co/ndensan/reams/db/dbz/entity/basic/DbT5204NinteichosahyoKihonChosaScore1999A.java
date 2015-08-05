package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査票（基本調査素点）1999Aテーブルの項目定義クラスです。
 */
public enum DbT5204NinteichosahyoKihonChosaScore1999A implements IColumnDefinition {
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
     * 申請書管理番号
     * <br/>要介護認定申請情報
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 要介護認定調査履歴番号
     * <br/>認定調査依頼情報
     */
    ninteichosaRirekiNo(5, 0),
    /**
     * 厚労省IF識別コード
     * <br/>Enum（DBE：厚労省認定ソフトのバージョン）
     */
    koroshoIfShikibetsuCode(2147483647, 0),
    /**
     * 素点合計　第１郡
     */
    tokutenTotal1gun(5, 0),
    /**
     * 素点合計　第２郡
     */
    tokutenTotal2gun(5, 0),
    /**
     * 素点合計　第３郡
     */
    tokutenTotal3gun(5, 0),
    /**
     * 素点合計　第４郡
     */
    tokutenTotal4gun(5, 0),
    /**
     * 素点合計　第５郡
     */
    tokutenTotal5gun(5, 0),
    /**
     * 素点合計　第６郡
     */
    tokutenTotal6gun(5, 0),
    /**
     * 素点合計　第７郡
     */
    tokutenTotal7gun(5, 0);

    private final int maxLength;
    private final int scale;

    private DbT5204NinteichosahyoKihonChosaScore1999A(int maxLength, int scale) {
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
