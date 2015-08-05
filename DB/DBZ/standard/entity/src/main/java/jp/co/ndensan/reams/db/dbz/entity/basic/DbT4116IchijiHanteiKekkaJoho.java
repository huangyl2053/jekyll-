package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定一次判定結果情報テーブルの項目定義クラスです。
 */
public enum DbT4116IchijiHanteiKekkaJoho implements IColumnDefinition {
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
     * 仮一次判定区分
     * <br/>Enum（DBE：仮一次判定区分）
     */
    kariIchijiHanteiKubun(1, 0),
    /**
     * 要介護認定一次判定年月日
     */
    ichijiHanteiYMD(2147483647, 0),
    /**
     * 要介護認定一次判定結果コード
     * <br/>Enum（DBD：要介護認定一次判定結果コード09）
     */
    ichijiHanteiKekkaCode(2147483647, 0),
    /**
     * 要介護認定一次判定結果コード（認知症加算）
     * <br/>Enum（DBD：要介護認定一次判定結果コード09（認知症加算））要介護認定一次判定結果コード（重み）
     */
    ichijiHanteiKekkaNinchishoKasanCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT4116IchijiHanteiKekkaJoho(int maxLength, int scale) {
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
