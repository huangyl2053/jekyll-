package jp.co.ndensan.reams.db.dbb.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 世帯員所得情報一時テーブルの項目定義クラスです。
 */
public enum DbT2019SetaiSudeTemp implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 識別コード
     */
    shikibetsuCode(2147483647, 0),
    /**
     * 基準年月日
     */
    kijunYMD(2147483647, 0),
    /**
     * 所得年度
     */
    shotokuNendo(2147483647, 0),
    /**
     * 住所地特例該当
     */
    jushochiTokureiFlag(1, 0),
    /**
     * 世帯コード
     */
    setaiCode(2147483647, 0),
    /**
     * 本人区分
     */
    honninKubun(1, 0),
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
     * 激変緩和措置区分
     */
    gekihenKanwaKubun(1, 0),
    /**
     * 合計所得金額
     */
    gokeiShotokuGaku(12, 0),
    /**
     * 年金収入額
     */
    nenkiniShunyuGaku(12, 0),
    /**
     * 年金所得額
     */
    nenkiniShotokuGaku(12, 0),
    /**
     * 課税所得額
     */
    kazeiShotokuGaku(12, 0),
    /**
     * 登録業務
     */
    torokuGyomu(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT2019SetaiSudeTemp(int maxLength, int scale) {
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
