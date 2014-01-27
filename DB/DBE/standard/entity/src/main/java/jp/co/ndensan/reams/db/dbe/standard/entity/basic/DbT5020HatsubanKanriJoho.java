/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.standard.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 発番管理情報を表す列挙型です。
 *
 * @author N1013 松本直樹
 */
public enum DbT5020HatsubanKanriJoho implements IColumnDefinition {
//TODO 介護事業者番号の発番については、発番管理は共通の発番クラスを利用するか検討する　2014/02/28期限

    /**
     * 項目区分
     */
    KOMOKU_KUBUN(1, 0),
    /**
     * 年度
     */
    NENDO(4, 0),
    /**
     * 発番番号
     */
    HATSUBAN(10, 0);
    private final int maxLength;
    private final int scale;

    private DbT5020HatsubanKanriJoho(int maxLength, int scale) {
        this.maxLength = maxLength;
        this.scale = scale;
    }

    /**
     * 項目の最大長を返します。
     *
     * @return 項目の最大長
     */
    public int getMaxLength() {
        return maxLength;
    }

    /**
     * 項目の小数点以下の桁数を返します。
     *
     * @return 小数点以下の桁数
     */
    public int getScale() {
        return scale;
    }
}
