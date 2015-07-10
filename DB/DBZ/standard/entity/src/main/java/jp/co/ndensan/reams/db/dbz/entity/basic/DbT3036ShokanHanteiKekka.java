package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3036ShokanHanteiKekkaの項目定義クラスです
 *
 */
public enum DbT3036ShokanHanteiKekka implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    hiHokenshaNo(2147483647, 0),
    serviceTeikyoYM(2147483647, 0),
    seiriNo(10, 0),
    shoriTimestamp(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    ketteiYMD(2147483647, 0),
    shikyuHushikyuKetteiKubun(1, 0),
    shiharaiKingaku(9, 0),
    shiharaiKingakuUchiwakeRiyoshabun(9, 0),
    shiharaiHohoKubun(1, 0),
    shiharaiBasho(64, 0),
    shiharaiKikanKaishiYMD(2147483647, 0),
    shiharaiKikanShuryoYMD(2147483647, 0),
    kaichoNaiyo(50, 0),
    shiharaiMadoguchiKaishiTime(15, 0),
    shiharaiMadoguchiShuryoTime(15, 0),
    ketteiIchiranTorikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3036ShokanHanteiKekka(int maxLength, int scale) {
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
