/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査委託先情報を表す列挙型です。
 *
 * @author N1013 松本直樹
 */
public enum DbT7010NinteichosaItakusakiJoho implements IColumnDefinition {
//TODO 証記載保険者番号はILocalGovernmentCodeを使用するか検討する。 2014/02/14 期限

    /**
     * 市町村コード
     */
    shichosonCode(6, 0),
    /**
     * 介護事業者番号
     */
    kaigoJigyoshaNo(10, 0),
    /**
     * 事業者番号
     */
    jigyoshaNo(10, 0),
    /**
     * 介護事業者状況
     */
    kaigoJigyoshaJokyo(1, 0),
    /**
     * 調査委託区分
     */
    chosaItakuKubunCode(8, 0),
    /**
     * 割付定員
     */
    waritsukeTeiin(4, 0),
    /**
     * 割付地区
     */
    waritsukeChiku(8, 0),
    /**
     * 機関の区分
     */
    kikanKubunCode(8, 0);
    private final int maxLength;
    private final int scale;

    private DbT7010NinteichosaItakusakiJoho(int maxLength, int scale) {
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
