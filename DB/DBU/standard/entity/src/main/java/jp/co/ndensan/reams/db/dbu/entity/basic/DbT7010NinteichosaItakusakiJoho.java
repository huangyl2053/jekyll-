package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査委託先情報　継承テーブルの項目定義クラスです。
 */
public enum DbT7010NinteichosaItakusakiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
    /**
     * insertDantaiCd
     */
    insertDantaiCd(2147483647, 0),
    /**
     * insertTimestamp
     */
    insertTimestamp(29, 0),
    /**
     * insertReamsLoginId
     */
    insertReamsLoginId(2147483647, 0),
    /**
     * insertContextId
     */
    insertContextId(2147483647, 0),
    /**
     * isDeleted
     */
    isDeleted(1, 0),
    /**
     * updateCount
     */
    updateCount(10, 0),
    /**
     * lastUpdateTimestamp
     */
    lastUpdateTimestamp(29, 0),
    /**
     * lastUpdateReamsLoginId
     */
    lastUpdateReamsLoginId(2147483647, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
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
     * 事業者名称
     */
    jigyoshaMeisho(120, 0),
    /**
     * 事業者名称カナ
     */
    jigyoshaMeishoKana(120, 0),
    /**
     * 郵便番号
     */
    yubinNo(2147483647, 0),
    /**
     * 住所
     */
    jusho(50, 0),
    /**
     * 住所カナ
     */
    jushoKana(50, 0),
    /**
     * 電話番号
     */
    telNo(2147483647, 0),
    /**
     * 銀行コード
     */
    ginkoCode(2147483647, 0),
    /**
     * 支店コード
     */
    shitenCode(2147483647, 0),
    /**
     * 口座種別
     */
    kozaShubetsu(2147483647, 0),
    /**
     * 口座番号
     */
    kozaNo(2147483647, 0),
    /**
     * 口座名義人
     */
    kozaMeiginin(120, 0),
    /**
     * 口座名義人カナ
     */
    kozaMeigininKana(120, 0),
    /**
     * 調査委託区分コード
     */
    chosaItakuKubunCode(2147483647, 0),
    /**
     * 割付定員
     */
    waritsukeTeiin(5, 0),
    /**
     * 割付地区
     */
    waritsukeChiku(2147483647, 0),
    /**
     * 機関の区分コード
     */
    kikanKubunCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7010NinteichosaItakusakiJoho(int maxLength, int scale) {
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
