package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 他市町村住所地特例・福祉Viewテーブルの項目定義クラスです。
 */
public enum DbV7503TashichosonJushochiTokureiFukushi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    /**
     * shikibetsuCode
     */
    shikibetsuCode(2147483647, 0),
    /**
     * idoYMD
     */
    idoYMD(2147483647, 0),
    /**
     * edaNo
     */
    edaNo(4, 0),
    /**
     * idoJiyuCode
     */
    idoJiyuCode(2, 0),
    /**
     * shichosonCode
     */
    shichosonCode(2147483647, 0),
    /**
     * tekiyoJiyuCode
     */
    tekiyoJiyuCode(2, 0),
    /**
     * tekiyoYMD
     */
    tekiyoYMD(2147483647, 0),
    /**
     * tekiyoTodokedeYMD
     */
    tekiyoTodokedeYMD(2147483647, 0),
    /**
     * tekiyoUketsukeYMD
     */
    tekiyoUketsukeYMD(2147483647, 0),
    /**
     * kaijoJiyuCode
     */
    kaijoJiyuCode(2, 0),
    /**
     * kaijoYMD
     */
    kaijoYMD(2147483647, 0),
    /**
     * kaijoYMDDCmp
     */
    kaijoYMDDCmp(2147483647, 0),
    /**
     * kaijoTodokedeYMD
     */
    kaijoTodokedeYMD(2147483647, 0),
    /**
     * kaijoUketsukeYMD
     */
    kaijoUketsukeYMD(2147483647, 0),
    /**
     * sochiHokenshaNo
     */
    sochiHokenshaNo(2147483647, 0),
    /**
     * sochiHihokenshaNo
     */
    sochiHihokenshaNo(2147483647, 0),
    /**
     * tatokuRenrakuhyoHakkoYMD
     */
    tatokuRenrakuhyoHakkoYMD(2147483647, 0),
    /**
     * shisetsuTaishoTsuchiHakkoYMD
     */
    shisetsuTaishoTsuchiHakkoYMD(2147483647, 0),
    /**
     * shisetsuHenkoTsuchiHakkoYMD
     */
    shisetsuHenkoTsuchiHakkoYMD(2147483647, 0),
    /**
     * logicalDeletedFlag
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbV7503TashichosonJushochiTokureiFukushi(int maxLength, int scale) {
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
