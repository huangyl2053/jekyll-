package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3089KyufuhiKashitsukekinShokanKigenHenkoの項目定義クラスです
 *
 */
public enum DbT3089KyufuhiKashitsukekinShokanKigenHenko implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hihokenshaNo(2147483647, 0),
    kashitsukeKanriNo(10, 0),
    shokanKigenEnchoUketsukeYMD(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    shokanKigenEnchoShinseiYMD(2147483647, 0),
    kariukeninYubinNo(2147483647, 0),
    kariukeninJusho(100, 0),
    kariukeninShimeiKana(2147483647, 0),
    kariukeninShimei(2147483647, 0),
    kariukeninTelNo(2147483647, 0),
    miShokanKingaku(10, 0),
    enchoKiboKaishiYMD(2147483647, 0),
    enchoKiboShuryoYMD(2147483647, 0),
    enchoRiyu(200, 0),
    henkoKetteiYMD(2147483647, 0),
    henkoShonin_FuShoninKubun(1, 0),
    henkoGoShokanKigenYMD(2147483647, 0),
    henkoFuShoninRiyu(100, 0);

    private final int maxLength;
    private final int scale;

    private DbT3089KyufuhiKashitsukekinShokanKigenHenko(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }

// </editor-fold>
}
