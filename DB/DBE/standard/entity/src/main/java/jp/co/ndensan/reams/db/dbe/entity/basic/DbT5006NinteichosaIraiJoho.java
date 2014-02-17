package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT5006NinteichosaIraiJohoの項目定義クラスです
 *
 */
public enum DbT5006NinteichosaIraiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Generated Code">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinseishoKanriNo(10, 0),
    ninteichosaIraiRirekiNo(5, 0),
    ninteichosaItakusakiCode(10, 0),
    chousainCode(8, 0),
    ninteichousaIraiKubunCode(2147483647, 0),
    ninteichosaIraiKaisu(5, 0),
    ninteichosaIraiYMD(2147483647, 0),
    ninteichosaKigenYMD(2147483647, 0),
    iraishoShutsuryokuYMD(2147483647, 0),
    chosahyoTouShutsuryokuYMD(2147483647, 0),
    mobileDataShutsuryokuFlag(1, 0),
    ninteichosaTokusokuYMD(2147483647, 0),
    ninteichosaTokusokuHoho(1, 0),
    ninteichosaTokusokuKaisu(5, 0),
    ninteichosaTokusokuMemo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5006NinteichosaIraiJoho(int maxLength, int scale) {
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
