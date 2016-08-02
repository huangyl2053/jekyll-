package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 居宅給付計画・福祉Viewテーブルの項目定義クラスです。
 */
public enum DbV7507KyotakuKeikakuFukushi implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
    /**
     * hihokenshaNo
     */
    hihokenshaNo(2147483647, 0),
    /**
     * taishoYM
     */
    taishoYM(2147483647, 0),
    /**
     * rirekiNo
     */
    rirekiNo(5, 0),
    /**
     * kyotaku_SogoJigyoKubun
     */
    kyotaku_SogoJigyoKubun(2147483647, 0),
    /**
     * todokedeKubun
     */
    todokedeKubun(1, 0),
    /**
     * sakuseiKubunCode
     */
    sakuseiKubunCode(1, 0),
    /**
     * keikakuJigyoshaNo
     */
    keikakuJigyoshaNo(2147483647, 0),
    /**
     * tekiyoKaishiYMD
     */
    tekiyoKaishiYMD(2147483647, 0),
    /**
     * tekiyoShuryoYMD
     */
    tekiyoShuryoYMD(2147483647, 0),
    /**
     * sakuseiYMD
     */
    sakuseiYMD(2147483647, 0),
    /**
     * todokedeYMD
     */
    todokedeYMD(2147483647, 0),
    /**
     * henkoYMD
     */
    henkoYMD(2147483647, 0),
    /**
     * henkoJiyu
     */
    henkoJiyu(2147483647, 0),
    /**
     * zanteiKubun
     */
    zanteiKubun(1, 0),
    /**
     * itakusakiJigyoshaNo
     */
    itakusakiJigyoshaNo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbV7507KyotakuKeikakuFukushi(int maxLength, int scale) {
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
