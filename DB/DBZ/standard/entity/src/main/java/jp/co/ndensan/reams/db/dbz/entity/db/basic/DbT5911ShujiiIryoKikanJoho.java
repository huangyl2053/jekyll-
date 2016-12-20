package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 主治医医療機関情報テーブルの項目定義クラスです。
 */
public enum DbT5911ShujiiIryoKikanJoho implements IColumnDefinition {
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
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 主治医医療機関コード
     */
    shujiiIryokikanCode(10, 0),
    /**
     * 医療機関コード
     * <br/>URを参照する場合のみ設定
     */
    iryokikanCode(2147483647, 0),
    /**
     * 医療機関名称
     */
    iryoKikanMeisho(512, 0),
    /**
     * 医療機関名称カナ
     */
    iryoKikanMeishoKana(512, 0),
    /**
     * 郵便番号
     */
    yubinNo(2147483647, 0),
    /**
     * 住所
     */
    jusho(512, 0),
    /**
     * 電話番号
     */
    telNo(2147483647, 0),
    /**
     * FAX番号
     */
    faxNo(2147483647, 0),
    /**
     * 代表者名
     */
    daihyoshaName(512, 0),
    /**
     * 代表者名カナ
     */
    daihyoshaNameKana(512, 0),
    /**
     * 状況フラグ
     * <br/>True：有効　False：無効
     */
    jokyoFlag(1, 0),
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

    private DbT5911ShujiiIryoKikanJoho(int maxLength, int scale) {
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
