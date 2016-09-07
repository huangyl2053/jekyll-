package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護所得テーブルの項目定義クラスです。
 */
public enum DbV2502KaigoShotoku implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">

    /**
     * shotokuNendo
     */
    shotokuNendo(2147483647, 0),
    /**
     * shikibetsuCode
     */
    shikibetsuCode(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(19, 0),
    /**
     * kazeiKubun
     */
    kazeiKubun(1, 0),
    /**
     * kazeiKubunGemmenGo
     */
    kazeiKubunGemmenGo(1, 0),
    /**
     * gokeiShotokuGaku
     */
    gokeiShotokuGaku(12, 0),
    /**
     * nenkiniShunyuGaku
     */
    nenkiniShunyuGaku(12, 0),
    /**
     * nenkiniShotokuGaku
     */
    nenkiniShotokuGaku(12, 0),
    /**
     * kazeiShotokuGaku
     */
    kazeiShotokuGaku(12, 0),
    /**
     * gekihenKanwaKubun
     */
    gekihenKanwaKubun(1, 0),
    /**
     * yusenKubun
     */
    yusenKubun(1, 0),
    /**
     * shoriTimeStamp
     */
    shoriTimeStamp(2147483647, 0),
    /**
     * motoRirekiNo
     */
    motoRirekiNo(5, 0),
    /**
     * torokuGyomu
     */
    torokuGyomu(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbV2502KaigoShotoku(int maxLength, int scale) {
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
