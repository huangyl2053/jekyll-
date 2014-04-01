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
     * 証記載保険者番号
     */
    SHICHOSON_CD(6, 0),
    /**
     * 介護事業者番号
     */
    KAIGO_JIGYOSHA_NO(10, 0),
    /**
     * 事業者番号
     */
    JIGYOSHA_NO(10, 0),
    /**
     * 介護事業者状況
     */
    KAIGO_JIGYOSHA_JOKYO(1, 0),
    /**
     * 調査委託区分
     */
    CHOSA_ITAKU_KUBUN(8, 0),
    /**
     * 割付定員
     */
    WARITSUKE_TEIIN(4, 0),
    /**
     * 割付地区
     */
    WARITSUKE_TIKU(8, 0),
    /**
     * 機関の区分
     */
    KIKAN_KUBUN(8, 0);
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
