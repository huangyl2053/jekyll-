package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7035RendoPatternの項目定義クラスです
 *
 */
public enum DbT7035RendoPattern implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    motoShichosonCode(2147483647, 0),
    sakiShichosonCode(2147483647, 0),
    shubetsu(2, 0),
    yukoKaishiYMD(2147483647, 0),
    yukoShuryoYMD(2147483647, 0),
    rendoKeitaiCode(2, 0),
    motoFormatVersion(20, 0),
    motoEncodeKeitai(20, 0),
    sakiFormatVersion(20, 0),
    sakiEncodeKeitai(20, 0),
    codeHenkanKubun(1, 0),
    gaijiHenkanKubun(1, 0),
    zenkenRendoKubun(1, 0),
    rendoKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7035RendoPattern(int maxLength, int scale) {
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
