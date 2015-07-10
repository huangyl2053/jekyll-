package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7024KoikiShichosonCodeHenkanPatternの項目定義クラスです
 *
 */
public enum DbT7024KoikiShichosonCodeHenkanPattern implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    koikiShichosonNo(2, 0),
    shichosonCode(2147483647, 0),
    codeKubun(1, 0),
    codeHenkanTableShiyoUmu(1, 0),
    jidoSaibanKubun(1, 0),
    shichosonCodeKetasu(5, 0),
    shichosonCodeKaishiIchi(5, 0),
    shichosonCodeShiyoKetasu(5, 0),
    shichosonNinshoNoUmu(1, 0),
    koikiCodeKetasu(5, 0),
    koikiCodeKaishiIchi(5, 0),
    koikiCodeShiyoKetasu(5, 0),
    koikiNinshoNoUmu(1, 0),
    shichosonNoFukaKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7024KoikiShichosonCodeHenkanPattern(int maxLength, int scale) {
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
