package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 主治医意見書作成依頼情報・福祉Newestテーブルの項目定義クラスです。
 */
public enum DbV7515ShujiiIkenshoIraiJohoFukushi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    /**
     * shinseishoKanriNo
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * ikenshoIraiRirekiNo
     */
    ikenshoIraiRirekiNo(5, 0),
    /**
     * koroshoIfShikibetsuCode
     */
    koroshoIfShikibetsuCode(2147483647, 0),
    /**
     * shujiiIryokikanCode
     */
    shujiiIryokikanCode(10, 0),
    /**
     * shujiiCode
     */
    shujiiCode(8, 0),
    /**
     * ikenshoIraiKubun
     */
    ikenshoIraiKubun(1, 0),
    /**
     * ikenshoIraiKaisu
     */
    ikenshoIraiKaisu(5, 0),
    /**
     * ishiKubunCode
     */
    ishiKubunCode(2147483647, 0),
    /**
     * ikenshoSakuseiIraiYMD
     */
    ikenshoSakuseiIraiYMD(2147483647, 0),
    /**
     * ikenshoSakuseiKigenYMD
     */
    ikenshoSakuseiKigenYMD(2147483647, 0),
    /**
     * teishutsuIraishoShutsuryokuYMD
     */
    teishutsuIraishoShutsuryokuYMD(2147483647, 0),
    /**
     * ikenshoShutsuryokuYMD
     */
    ikenshoShutsuryokuYMD(2147483647, 0),
    /**
     * seikyushoShutsuryokuYMD
     */
    seikyushoShutsuryokuYMD(2147483647, 0),
    /**
     * sakuseiryoSeikyuKubun
     */
    sakuseiryoSeikyuKubun(2147483647, 0),
    /**
     * ikenshoSakuseiTokusokuYMD
     */
    ikenshoSakuseiTokusokuYMD(2147483647, 0),
    /**
     * ikenshoSakuseiTokusokuHoho
     */
    ikenshoSakuseiTokusokuHoho(1, 0),
    /**
     * ikenshoTokusokuKaisu
     */
    ikenshoTokusokuKaisu(5, 0),
    /**
     * ikenshoTokusokuMemo
     */
    ikenshoTokusokuMemo(2147483647, 0),
    /**
     * ninteiJohoTeikyoKiboFlag
     */
    ninteiJohoTeikyoKiboFlag(1, 0),
    /**
     * ninteiJohoTeikyoYMD
     */
    ninteiJohoTeikyoYMD(2147483647, 0),
    /**
     * logicalDeletedFlag
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbV7515ShujiiIkenshoIraiJohoFukushi(int maxLength, int scale) {
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
