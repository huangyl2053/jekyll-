package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3087KyufuhiKashitsukeKinKetteiの項目定義クラスです
 *
 */
public enum DbT3087KyufuhiKashitsukeKinKettei implements IColumnDefinition {
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
    kariireShinseiYMD(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    kashitsukeShinsaKetteiYMD(2147483647, 0),
    kashitsukeShonin_FuShoninKubun(1, 0),
    kashitsukeKanriNo(10, 0),
    kashitsukeKingaku(10, 0),
    shokanHoho(1, 0),
    shokanKigenYMD(2147483647, 0),
    kashitsukeYMD(2147483647, 0),
    kashitsukeShiharaiHoho(1, 0),
    kashitsukeMadoguchiShiharaiBasho(64, 0),
    kashitsukeMadoguchiKaishiYMD(2147483647, 0),
    kashitsukeMadoguchiShuryoYMD(2147483647, 0),
    kashitsukeMadoguchiHeichoNaiyo(50, 0),
    kashitsukeMadoguchiKaishiTime(4, 0),
    kashitsukeMadoguchiShuryoTime(4, 0),
    kashitsukeFuShoninRiyu(100, 0),
    shikibetsuCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3087KyufuhiKashitsukeKinKettei(int maxLength, int scale) {
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
