package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払支給判定結果テーブルの項目定義クラスです。
 */
public enum DbT3036ShokanHanteiKekka implements IColumnDefinition {
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
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNo(10, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 支給・不支給決定区分
     */
    shikyuHushikyuKetteiKubun(1, 0),
    /**
     * 支払金額
     */
    shiharaiKingaku(9, 0),
    /**
     * 支払金額内訳・利用者分
     */
    shiharaiKingakuUchiwakeRiyoshabun(9, 0),
    /**
     * 決定一覧取込年月
     */
    ketteiIchiranTorikomiYM(2147483647, 0),
    /**
     * 前回支払金額
     */
    zenkaiShiharaiKingaku(10, 0),
    /**
     * 差額金額合計
     */
    sagakuKingakuGokei(10, 0),
    /**
     * 決定通知書作成年月日
     */
    ketteiTsuchishoSakuseiYMD(2147483647, 0),
    /**
     * 決定通知No
     */
    ketteiTsuchiNo(6, 0),
    /**
     * 振込明細書作成年月日
     */
    furikomiMeisaishoSakuseiYMD(2147483647, 0),
    /**
     * 決定通知リアル発行区分
     * <br/>0:未発行、1:発行済
     */
    ketteiTsuchiHakkoKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3036ShokanHanteiKekka(int maxLength, int scale) {
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
