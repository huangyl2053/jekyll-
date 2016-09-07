package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 総合事業対象者・福祉Viewテーブルの項目定義クラスです。
 */
public enum DbV7510SogoJigyoTaishoshaFukushi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    /**
     * hihokenshaNo
     */
    hihokenshaNo(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(5, 0),
    /**
     * tekiyoKaishiYMD
     */
    tekiyoKaishiYMD(2147483647, 0),
    /**
     * tekiyoShuryoYMD
     */
    tekiyoShuryoYMD(2147483647, 0),
    /**
     * uketsukeYMD
     */
    uketsukeYMD(2147483647, 0),
    /**
     * ketteiYMD
     */
    ketteiYMD(2147483647, 0),
    /**
     * checklistJisshiYMD
     */
    checklistJisshiYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbV7510SogoJigyoTaishoshaFukushi(int maxLength, int scale) {
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
