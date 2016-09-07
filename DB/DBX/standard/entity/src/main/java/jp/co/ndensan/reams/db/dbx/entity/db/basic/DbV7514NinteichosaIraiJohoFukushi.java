package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査依頼情報・福祉Newestテーブルの項目定義クラスです。
 */
public enum DbV7514NinteichosaIraiJohoFukushi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    /**
     * shinseishoKanriNo
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * ninteichosaIraiRirekiNo
     */
    ninteichosaIraiRirekiNo(5, 0),
    /**
     * koroshoIfShikibetsuCode
     */
    koroshoIfShikibetsuCode(2147483647, 0),
    /**
     * ninteichosaItakusakiCode
     */
    ninteichosaItakusakiCode(2147483647, 0),
    /**
     * ninteiChosainCode
     */
    ninteiChosainCode(8, 0),
    /**
     * ninteichosaIraiKubunCode
     */
    ninteichosaIraiKubunCode(2147483647, 0),
    /**
     * ninteichosaIraiKaisu
     */
    ninteichosaIraiKaisu(5, 0),
    /**
     * ninteichosaIraiYMD
     */
    ninteichosaIraiYMD(2147483647, 0),
    /**
     * ninteichosaKigenYMD
     */
    ninteichosaKigenYMD(2147483647, 0),
    /**
     * chosaIraishoShutsuryokuYMD
     */
    chosaIraishoShutsuryokuYMD(2147483647, 0),
    /**
     * chosahyoTouShutsuryokuYMD
     */
    chosahyoTouShutsuryokuYMD(2147483647, 0),
    /**
     * mobileDataShutsuryokuZumiFlag
     */
    mobileDataShutsuryokuZumiFlag(1, 0),
    /**
     * jizenChosaFlag
     */
    jizenChosaFlag(1, 0),
    /**
     * ninteichosaTokusokuYMD
     */
    ninteichosaTokusokuYMD(2147483647, 0),
    /**
     * ninteichosaTokusokuHoho
     */
    ninteichosaTokusokuHoho(1, 0),
    /**
     * ninteichosaTokusokuKaisu
     */
    ninteichosaTokusokuKaisu(5, 0),
    /**
     * ninteichosaTokusokuMemo
     */
    ninteichosaTokusokuMemo(2147483647, 0),
    /**
     * logicalDeletedFlag
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbV7514NinteichosaIraiJohoFukushi(int maxLength, int scale) {
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
