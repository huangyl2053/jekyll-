package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護所得管理テーブルの項目定義クラスです。
 * <br/> 住民税課税対象者以外の所得情報を管理します。
 */
public enum DbT2008ShotokuKanri implements IColumnDefinition {
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
     * 所得年度
     */
    shotokuNendo(2147483647, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 課税区分（住民税減免前）
     * <br/>1：課税　2：非課税　3：未申告　4：調査中　5：課税取消　
     * <br/>※保険料賦課の際に参照する
     */
    kazeiKubun(1, 0),
    /**
     * 課税区分（住民税減免後）
     * <br/>1：課税　2：非課税　3：未申告　4：調査中　5：課税取消　
     * <br/>※給付（高額等）で参照する
     */
    kazeiKubunGemmenGo(1, 0),
    /**
     * 合計所得金額
     */
    gokeiShotokuGaku(12, 0),
    /**
     * 公的年金収入額
     */
    nenkiniShunyuGaku(12, 0),
    /**
     * 公的年金所得額
     */
    nenkiniShotokuGaku(12, 0),
    /**
     * 課税所得額
     */
    kazeiShotokuGaku(12, 0),
    /**
     * 激変緩和措置区分
     */
    gekihenKanwaKubun(1, 0),
    /**
     * 優先区分
     */
    yusebKubun(1, 0),
    /**
     * 処理日
     */
    shoriYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT2008ShotokuKanri(int maxLength, int scale) {
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
