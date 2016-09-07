package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 利用者負担割合明細根拠Newestテーブルの項目定義クラスです。
 */
public enum DbV3115RiyoshaFutanWariaiMeisaiKonkyo implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    /**
     * nendo
     */
    nendo(2147483647, 0),
    /**
     * hihokenshaNo
     */
    hihokenshaNo(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(5, 0),
    /**
     * hakoFuyoFlag
     */
    hakoFuyoFlag(1, 0),
    /**
     * shokenFlag
     */
    shokenFlag(1, 0),
    /**
     * hanteiYMD
     */
    hanteiYMD(2147483647, 0),
    /**
     * hanteiKubun
     */
    hanteiKubun(1, 0),
    /**
     * koseiJiyu
     */
    koseiJiyu(2147483647, 0),
    /**
     * hakoKubun
     */
    hakoKubun(1, 0),
    /**
     * hakoYMD
     */
    hakoYMD(2147483647, 0),
    /**
     * kofuYMD
     */
    kofuYMD(2147483647, 0),
    /**
     * logicalDeletedFlag
     */
    logicalDeletedFlag(1, 0),
    /**
     * edaNo
     */
    edaNo(5, 0),
    /**
     * shikakuKubun
     */
    shikakuKubun(2, 0),
    /**
     * futanWariaiKubun
     */
    futanWariaiKubun(2, 0),
    /**
     * yukoKaishiYMD
     */
    yukoKaishiYMD(2147483647, 0),
    /**
     * yukoShuryoYMD
     */
    yukoShuryoYMD(2147483647, 0),
    /**
     * honninGoukeiShotokuGaku
     */
    honninGoukeiShotokuGaku(12, 0),
    /**
     * setaiIchigouHihokenshaSu
     */
    setaiIchigouHihokenshaSu(5, 0),
    /**
     * nenkinShunyuGoukei
     */
    nenkinShunyuGoukei(12, 0),
    /**
     * sonotanoGoukeiShotokuKingakuGoukei
     */
    sonotanoGoukeiShotokuKingakuGoukei(12, 0),
    /**
     * koseiRiyu
     */
    koseiRiyu(2147483647, 0),
    /**
     * setaiCd
     */
    setaiCd(2147483647, 0),
    /**
     * meisailogicalDeletedFlag
     */
    meisailogicalDeletedFlag(1, 0),
    /**
     * setaiinHihokenshaNo
     */
    setaiinHihokenshaNo(2147483647, 0),
    /**
     * setaiinShotokuRirekiNo
     */
    setaiinShotokuRirekiNo(5, 0);

    private final int maxLength;
    private final int scale;

    private DbV3115RiyoshaFutanWariaiMeisaiKonkyo(int maxLength, int scale) {
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
