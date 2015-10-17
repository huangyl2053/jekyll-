package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護認定審査会委員情報テーブルの項目定義クラスです。
 */
public enum DbT5594ShinsakaiIinJoho implements IColumnDefinition {
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
    ShinsakaiIinKanaShimei(2147483647, 0),
    /**
     * 性別
     */
    seibetsu(1, 0),
    /**
     * 介護認定審査員資格コード
     */
    shinsakaiIinShikakuCode(2147483647, 0),
    /**
     * 審査員郵送区分
     */
    shinsainYusoKubun(1, 0),
    /**
     * 担当地区コード
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
     * 金融機関コード
     */
    kinyuKikanCode(2147483647, 0),
    /**
     * 支店コード
     */
    kinyuKikanShitenCode(2147483647, 0),
    /**
     * 口座種別
     */
    kozaShubetsu(1, 0),
    /**
     * 口座名義人
     */
    kozaMeiginin(80, 0),
    /**
     * 口座名義人カナ
     */
    kozaMeigininKana(80, 0),
    /**
     * 口座番号
     */
    kozaNo(7, 0),
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
     */
    haishiFlag(1, 0),
    /**
     * 廃止年月日
     */
    haishiYMD(2147483647, 0);

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
