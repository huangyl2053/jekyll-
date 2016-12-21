package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * その他機関情報テーブルの項目定義クラスです。
 */
public enum DbT5914SonotaKikanJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * その他機関コード
     */
    sonotaKikanCode(10, 0),
    /**
     * 機関名称
     */
    kikanMeisho(120, 0),
    /**
     * 機関名称カナ
     */
    kikanMeishoKana(120, 0),
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
     * 調査委託区分
     * <br/>Enum（DBE：調査委託区分）
     */
    chosaItakuKubun(1, 0),
    /**
     * 割付定員
     */
    waritsukeTeiin(5, 0),
    /**
     * 割付地区
     * <br/>Code（DBE：5002）
     */
    waritsukeChiku(2147483647, 0),
    /**
     * 機関の区分
     * <br/>Enum（DBE：機関の区分）
     */
    kikanKubun(1, 0),
    /**
     * 廃止フラグ
     * <br/>Enum（DBE：廃止フラグ）旧「状況フラグ」
     */
    haishiFlag(1, 0),
    /**
     * 金融機関コード
     */
    kinyuKikanCode(2147483647, 0),
    /**
     * 支店コード
     */
    kinyuKikanShitenCode(2147483647, 0),
    /**
     * 預金種別
     */
    yokinShubetsu(1, 0),
    /**
     * 口座番号
     */
    kozaNo(7, 0),
    /**
     * 口座名義人カナ
     */
    kozaMeigininKana(2147483647, 0),
    /**
     * 口座名義人
     */
    kozaMeiginin(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5914SonotaKikanJoho(int maxLength, int scale) {
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
