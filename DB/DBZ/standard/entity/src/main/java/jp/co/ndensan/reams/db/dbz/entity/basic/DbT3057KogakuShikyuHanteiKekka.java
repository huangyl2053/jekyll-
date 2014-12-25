package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3057KogakuShikyuHanteiKekkaの項目定義クラスです
 *
 */
public enum DbT3057KogakuShikyuHanteiKekka implements IColumnDefinition {
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
    serviceTeikyoYM(2147483647, 0),
    shoKisaiHokenshaNo(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    ketteiYMD(2147483647, 0),
    honninShiharaiGaku(6, 0),
    shiharaiKubunCode(1, 0),
    shiharaiKingaku(6, 0),
    fushikyuRiyu(80, 0),
    shiharaiHohoKubunCode(1, 0),
    shiharaiBasho(64, 0),
    shiharaiKaishiYMD(2147483647, 0),
    shiharaiShuryoYMD(2147483647, 0),
    heichoNaiyo(50, 0),
    shiharaiKaishiTime(4, 0),
    shiharaiShuryoTime(4, 0),
    juryoIninKeiyakuNo(8, 0),
    shinsaHohoKubun(1, 0),
    hanteiKekkaSofuYM(2147483647, 0),
    saiSofuFlag(1, 0),
    hanteiKekkaSofuFuyoFlag(1, 0),
    shinsaKekkaHaneiKubun(1, 0),
    ketteiTsuchishoSakuseiYMD(2147483647, 0),
    furikomiMeisaishoSakuseiYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3057KogakuShikyuHanteiKekka(int maxLength, int scale) {
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
