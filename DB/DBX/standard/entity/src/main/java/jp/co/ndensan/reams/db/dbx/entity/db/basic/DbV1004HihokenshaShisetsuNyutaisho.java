package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbV1004HihokenshaShisetsuNyutaishoテーブルの項目定義クラスです。
 */
public enum DbV1004HihokenshaShisetsuNyutaisho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">
    /**
     * shikibetsuCode
     */
    shikibetsuCode(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(5, 0),
    /**
     * shichosonCode
     */
    shichosonCode(2147483647, 0),
    /**
     * daichoShubetsu
     */
    daichoShubetsu(1, 0),
    /**
     * nyushoShisetsuShurui
     */
    nyushoShisetsuShurui(2, 0),
    /**
     * nyushoShisetsuCode
     */
    nyushoShisetsuCode(2147483647, 0),
    /**
     * nyushoYMD
     */
    nyushoYMD(2147483647, 0),
    /**
     * taishoYMD
     */
    taishoYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbV1004HihokenshaShisetsuNyutaisho(int maxLength, int scale) {
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
