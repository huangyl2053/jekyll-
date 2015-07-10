package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT1002TekiyoJogaishaの項目定義クラスです
 *
 */
public enum DbT1002TekiyoJogaisha implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.1">
    insertDantaiCd(2147483647, 0),
    insertTimestamp(29, 0),
    insertReamsLoginId(2147483647, 0),
    insertContextId(2147483647, 0),
    isDeleted(1, 0),
    updateCount(10, 0),
    lastUpdateTimestamp(29, 0),
    lastUpdateReamsLoginId(2147483647, 0),
    shichosonCode(2147483647, 0),
    shikibetsuCode(2147483647, 0),
    shoriTimestamp(2147483647, 0),
    tekiyoJogaiTekiyoJiyuCode(2, 0),
    tekiyoYMD(2147483647, 0),
    tekiyoTodokedeYMD(2147483647, 0),
    tekiyoUketsukeYMD(2147483647, 0),
    tekiyoJogaikaijokaijoJiyuCode(2, 0),
    kaijoYMD(2147483647, 0),
    kaijoTodokedeYMD(2147483647, 0),
    kaijoUketsukeYMD(2147483647, 0),
    nyushoTsuchiHakkoYMD(2147483647, 0),
    taishoTsuchiHakkoYMD(2147483647, 0),
    henkoTsuchiHakkoYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT1002TekiyoJogaisha(int maxLength, int scale) {
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
