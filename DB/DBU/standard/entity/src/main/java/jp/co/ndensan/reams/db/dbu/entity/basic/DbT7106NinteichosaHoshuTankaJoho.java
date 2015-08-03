package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定調査報酬単価情報テーブルの項目定義クラスです。
 */
public enum DbT7106NinteichosaHoshuTankaJoho implements IColumnDefinition {
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
     * 報酬単価適用開始年月日
     */
    hoshuTankaTekiyoKaishiYMD(2147483647, 0),
    /**
     * 報酬単価適用終了年月日
     */
    hoshuTankaTekiyoShuryoYMD(2147483647, 0),
    /**
     * 認定調査区分
     */
    ninteichosaKubunCode(2147483647, 0),
    /**
     * 認定調査実施場所
     */
    chosaJisshiBasho(80, 0),
    /**
     * 認定調査委託料単価
     */
    chosaItakuRyoTanka(10, 0),
    /**
     * 課税非課税区分
     */
    kazeiHikazeiKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7106NinteichosaHoshuTankaJoho(int maxLength, int scale) {
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
