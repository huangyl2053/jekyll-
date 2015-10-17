package jp.co.ndensan.reams.db.dbu.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 主治医医療機関情報　継承テーブルの項目定義クラスです。
 */
public enum DbT7011ShujiiIryoKikanJoho implements IColumnDefinition {
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
     * 介護医療機関コード
     */
    kaigoIryokikanCode(10, 0),
    /**
     * 医療機関コード
     */
    iryokikanCode(10, 0),
    /**
     * 医療機関の状況
     */
    iryokikanJokyo(1, 0),
    /**
     * 医療機関名称
     */
    iryoKikanMeisho(120, 0),
    /**
     * 医療機関名称カナ
     */
    iryoKikanMeishoKana(120, 0),
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
     * 機関の区分コード
     */
    kikanKubunCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7011ShujiiIryoKikanJoho(int maxLength, int scale) {
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
