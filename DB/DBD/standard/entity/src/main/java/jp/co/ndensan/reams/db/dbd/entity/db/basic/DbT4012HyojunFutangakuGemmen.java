package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 標準負担額減免テーブルの項目定義クラスです。
 */
public enum DbT4012HyojunFutangakuGemmen implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">

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
     * shinseiYMD
     */
    shinseiYMD(2147483647, 0),
    /**
     * ketteiYMD
     */
    ketteiYMD(2147483647, 0),
    /**
     * tekiyoKaishiYMD
     */
    tekiyoKaishiYMD(2147483647, 0),
    /**
     * tekiyoShuryoYMD
     */
    tekiyoShuryoYMD(2147483647, 0),
    /**
     * ketteiKubun
     */
    ketteiKubun(1, 0),
    /**
     * hiShoninRiyu
     */
    hiShoninRiyu(200, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     * <br/>新規履歴：0, 以降の申請・決定：最大履歴番号+1
     */
    rirekiNo(5, 0),
    /**
     * 申請事由
     */
    shinseiJiyu(200, 0),
    /**
     * 減額区分
     * <br/>DBDEnum.減額区分
     *
     * <br/>・市町村民税非課税
     *
     * <br/>・老齢福祉年金受給
     *
     * <br/>・その他
     */
    gengakuKubun(2, 0),
    /**
     * 減額後金額
     */
    gengakugoKingaku(5, 0),
    /**
     * 標準負担区分
     * <br/>DBDEnum.標準負担区分
     *
     * <br/>1:標準負担      *
     * <br/>2:特定標準負担
     */
    hyojunFutanKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT4012HyojunFutangakuGemmen(int maxLength, int scale) {
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
