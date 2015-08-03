package jp.co.ndensan.reams.db.dbd.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 支払方法変更減額テーブルの項目定義クラスです。
 */
public enum DbT4025ShiharaiHohoHenkoGengaku implements IColumnDefinition {
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
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 管理区分
     * <br/>1：２号差止,2：１号償還払化,3：１号給付額減額
     */
    kanriKubun(1, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 滞納判定年月日
     */
    tainoHanteiYMD(2147483647, 0),
    /**
     * 判定基準年月日
     */
    hanteiKijunYMD(2147483647, 0),
    /**
     * 徴収権消滅期間
     * <br/>年数で管理（1.511等と格納）
     */
    choshukenShometsuKikan(5, 0),
    /**
     * 納付済期間
     * <br/>年数で管理（3.738等と格納）
     */
    nofusumiKikan(5, 0),
    /**
     * 納付済減額期間
     * <br/>月数で管理（2 等と格納）
     */
    nofusumiGengakuKikan(3, 0),
    /**
     * 確定減額期間開始年月日
     */
    kakutei_GengakuKaishiYMD(2147483647, 0),
    /**
     * 確定減額期間終了年月日
     */
    kakutei_GengakuShuryoYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT4025ShiharaiHohoHenkoGengaku(int maxLength, int scale) {
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
