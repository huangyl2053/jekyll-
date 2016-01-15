package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 二次予防基本チェックリストテーブルの項目定義クラスです。
 */
public enum DbT3101NijiYoboKihonCheckList implements IColumnDefinition {
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
     * 受付年月日
     */
    uketsukeYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 記入年月日
     */
    kinyuYMD(2147483647, 0),
    /**
     * 質問事項１
     */
    shitsumonJiko01(5, 0),
    /**
     * 質問事項２
     */
    shitsumonJiko02(5, 0),
    /**
     * 質問事項３
     */
    shitsumonJiko03(5, 0),
    /**
     * 質問事項４
     */
    shitsumonJiko04(5, 0),
    /**
     * 質問事項５
     */
    shitsumonJiko05(5, 0),
    /**
     * 質問事項６
     */
    shitsumonJiko06(5, 0),
    /**
     * 質問事項７
     */
    shitsumonJiko07(5, 0),
    /**
     * 質問事項８
     */
    shitsumonJiko08(5, 0),
    /**
     * 質問事項９
     */
    shitsumonJiko09(5, 0),
    /**
     * 質問事項１０
     */
    shitsumonJiko10(5, 0),
    /**
     * 質問事項１１
     */
    shitsumonJiko11(5, 0),
    /**
     * 質問事項１２身長
     */
    shitsumonJiko12Shincho(3, 0),
    /**
     * 質問事項１２体重
     */
    shitsumonJiko12Taiju(3, 0),
    /**
     * 質問事項１３
     */
    shitsumonJiko13(5, 0),
    /**
     * 質問事項１４
     */
    shitsumonJiko14(5, 0),
    /**
     * 質問事項１５
     */
    shitsumonJiko15(5, 0),
    /**
     * 質問事項１６
     */
    shitsumonJiko16(5, 0),
    /**
     * 質問事項１７
     */
    shitsumonJiko17(5, 0),
    /**
     * 質問事項１８
     */
    shitsumonJiko18(5, 0),
    /**
     * 質問事項１９
     */
    shitsumonJiko19(5, 0),
    /**
     * 質問事項２０
     */
    shitsumonJiko20(5, 0),
    /**
     * 質問事項２１
     */
    shitsumonJiko21(5, 0),
    /**
     * 質問事項２２
     */
    shitsumonJiko22(5, 0),
    /**
     * 質問事項２３
     */
    shitsumonJiko23(5, 0),
    /**
     * 質問事項２４
     */
    shitsumonJiko24(5, 0),
    /**
     * 質問事項２５
     */
    shitsumonJiko25(5, 0);

    private final int maxLength;
    private final int scale;

    private DbT3101NijiYoboKihonCheckList(int maxLength, int scale) {
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
