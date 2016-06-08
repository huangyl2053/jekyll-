package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護連絡先情報（子）テーブルの項目定義クラスです。
 */
public enum DbT4150RenrakusakiJoho implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
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
     * 申請書管理番号
     * <br/>要介護認定申請情報
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 連番
     */
    renban(5, 0),
    /**
     * 連絡先区分
     */
    renrakusakiKubunNo(8, 0),
    /**
     * 支所コード
     */
    shishoCode(2147483647, 0),
    /**
     * 連絡先氏名
     */
    renrakusakiShimei(2147483647, 0),
    /**
     * 連絡先氏名カナ
     */
    renrakusakiKanaSimei(2147483647, 0),
    /**
     * 連絡先続柄
     * <br/>Enum（DBD：連絡先続柄コード）
     */
    renrakusakiTuzukigara(32, 0),
    /**
     * 連絡先郵便番号
     */
    renrakusakiYubinNo(2147483647, 0),
    /**
     * 連絡先住所
     */
    renrakusakiJusho(2147483647, 0),
    /**
     * 連絡先電話番号
     */
    renrakusakiTelNo(2147483647, 0),
    /**
     * 連絡先携帯番号
     */
    renrakusakiKeitaiTelNo(2147483647, 0),
    /**
     * 優先順位
     */
    priority(5, 0);

    private final int maxLength;
    private final int scale;

    private DbT4150RenrakusakiJoho(int maxLength, int scale) {
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
