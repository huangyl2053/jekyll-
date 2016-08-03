package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 高額介護サービス費支給判定結果・福祉Viewテーブルの項目定義クラスです。
 */
public enum DbV7509KogakuShikyuHanteiKekkaFukushi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    /**
     * hihokenshaNo
     */
    hihokenshaNo(2147483647, 0),
    /**
     * serviceTeikyoYM
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * shoKisaiHokenshaNo
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(5, 0),
    /**
     * ketteiYMD
     */
    ketteiYMD(2147483647, 0),
    /**
     * honninShiharaiGaku
     */
    honninShiharaiGaku(6, 0),
    /**
     * shikyuKubunCode
     */
    shikyuKubunCode(1, 0),
    /**
     * shikyuKingaku
     */
    shikyuKingaku(6, 0),
    /**
     * fushikyuRiyu
     */
    fushikyuRiyu(80, 0),
    /**
     * shinsaHohoKubun
     */
    shinsaHohoKubun(1, 0),
    /**
     * hanteiKekkaSofuYM
     */
    hanteiKekkaSofuYM(2147483647, 0),
    /**
     * saiSofuFlag
     */
    saiSofuFlag(1, 0),
    /**
     * hanteiKekkaSofuFuyoFlag
     */
    hanteiKekkaSofuFuyoFlag(1, 0),
    /**
     * shinsaKekkaHaneiKubun
     */
    shinsaKekkaHaneiKubun(1, 0),
    /**
     * ketteiTsuchishoSakuseiYMD
     */
    ketteiTsuchishoSakuseiYMD(2147483647, 0),
    /**
     * furikomiMeisaishoSakuseiYMD
     */
    furikomiMeisaishoSakuseiYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbV7509KogakuShikyuHanteiKekkaFukushi(int maxLength, int scale) {
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
