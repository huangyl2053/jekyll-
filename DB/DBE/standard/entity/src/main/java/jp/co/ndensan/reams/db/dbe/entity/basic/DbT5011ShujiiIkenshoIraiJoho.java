package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 主治医意見書作成依頼情報を表す列挙型です。
 *
 * @author N8156 宮本 康
 */
public enum DbT5011ShujiiIkenshoIraiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Generated Code">

    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shinseishoKanriNo(2147483647, 0),
    ikenshoIraiRirekiNo(5, 0),
    kaigoIryokikanCode(10, 0),
    kaigoIshiCode(8, 0),
    ikenshoIraiKubun(1, 0),
    ikenshoIraiKaisu(5, 0),
    ishiKubunCode(2147483647, 0),
    ikenshoSakuseiIraiYMD(2147483647, 0),
    ikenshoSakuseiKigenYMD(2147483647, 0),
    iraishoShutsuryokuYMD(2147483647, 0),
    ikenshoShutsuryokuYMD(2147483647, 0),
    seikyushoShutsuryokuYMD(2147483647, 0),
    sakuseiryoSeikyuKubun(2147483647, 0),
    ikenshoSakuseiTokusokuYMD(2147483647, 0),
    ikenshoSakuseiTokusokuHoho(1, 0),
    ikenshoTokusokuKaisu(5, 0),
    ikenshoTokusokuMemo(2147483647, 0);
    private final int maxLength;
    private final int scale;

    private DbT5011ShujiiIkenshoIraiJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * getMaxLength
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * getScale
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }
// </editor-fold>
}
