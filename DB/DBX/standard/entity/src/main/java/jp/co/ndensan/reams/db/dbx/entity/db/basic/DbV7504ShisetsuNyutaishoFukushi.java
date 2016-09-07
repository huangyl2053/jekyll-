package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護保険施設入退所・福祉Viewテーブルの項目定義クラスです。
 */
public enum DbV7504ShisetsuNyutaishoFukushi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * nyushoShoriYMD
     */
    nyushoShoriYMD(2147483647, 0),
    /**
     * nyushoYMD
     */
    nyushoYMD(2147483647, 0),
    /**
     * taishoShoriYMD
     */
    taishoShoriYMD(2147483647, 0),
    /**
     * taishoYMD
     */
    taishoYMD(2147483647, 0),
    /**
     * roomKigoNo
     */
    roomKigoNo(20, 0);

    private final int maxLength;
    private final int scale;

    private DbV7504ShisetsuNyutaishoFukushi(int maxLength, int scale) {
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
