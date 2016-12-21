package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護認定審査会委員情報テーブルの項目定義クラスです。
 */
public enum DbT5594ShinsakaiIinJoho implements IColumnDefinition {
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
     * 介護認定審査会委員コード
     */
    shinsakaiIinCode(8, 0),
    /**
     * 介護認定審査会委員開始年月日
     */
    shinsakaiIinKaishiYMD(2147483647, 0),
    /**
     * 介護認定審査会委員終了年月日
     */
    shinsakaiIinShuryoYMD(2147483647, 0),
    /**
     * 介護認定審査会委員氏名
     */
    shinsakaiIinShimei(2147483647, 0),
    /**
     * 介護認定審査会委員氏名カナ
     */
    shinsakaiIinKanaShimei(2147483647, 0),
    /**
     * 性別
     * <br/>Enum（DBZ：性別コード）
     */
    seibetsu(1, 0),
    /**
     * 介護認定審査員資格コード
     * <br/>Enum（DBE:資格コード）
     */
    shinsakaiIinShikakuCode(2147483647, 0),
    /**
     * 審査員郵送区分
     * <br/>Enum（DBE:審査員郵送区分）
     */
    shinsainYusoKubun(1, 0),
    /**
     * 担当地区コード
     * <br/>Code（DBE:5001）
     */
    tantoChikuCode(2147483647, 0),
    /**
     * 郵便番号
     */
    yubinNo(2147483647, 0),
    /**
     * 住所
     */
    Jusho(2147483647, 0),
    /**
     * 電話番号
     */
    telNo(2147483647, 0),
    /**
     * FAX番号
     */
    faxNo(2147483647, 0),
    /**
     * 生年月日
     */
    seinengappiYMD(2147483647, 0),
    /**
     * 備考
     */
    biko(2147483647, 0),
    /**
     * 廃止フラグ
     * <br/>Enum（DBE：廃止フラグ）True：有効　False：無効
     */
    haishiFlag(1, 0),
    /**
     * 廃止年月日
     */
    haishiYMD(2147483647, 0),
    /**
     * kinyuKikanCode
     */
    kinyuKikanCode(2147483647, 0),
    /**
     * kinyuKikanShitenCode
     */
    kinyuKikanShitenCode(2147483647, 0),
    /**
     * yokinShubetsu
     */
    yokinShubetsu(1, 0),
    /**
     * kozaNo
     */
    kozaNo(7, 0),
    /**
     * kozaMeigininKana
     */
    kozaMeigininKana(2147483647, 0),
    /**
     * kozaMeiginin
     */
    kozaMeiginin(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5594ShinsakaiIinJoho(int maxLength, int scale) {
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
