package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 連携用データ送付記録テーブルの項目定義クラスです。
 */
public enum DbT5191RenkeiyoDataSofuKiroku implements IColumnDefinition {
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
     * 申請書管理番号
     * <br/>要介護認定申請情報
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 資料作成日
     */
    shiryoSakuseiYMD(2147483647, 0),
    /**
     * 引渡し区分
     * <br/>Enum（DBE：引渡し区分）0：引渡し未済、1：引渡し済
     */
    hikiwatashiKubun(1, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 再送付区分
     * <br/>Enum（DBE：再送付区分）01：再送信、02：再送信済
     */
    saiSoufuKubun(2, 0),
    /**
     * 再調査送付区分
     * <br/>Enum（DBE：再調査送付区分）0：未使用、1：再送信、2：再調査、3：再調査送付済　[松本広域でのみ使用：現行]
     */
    saiChousaSofuKubun(1, 0),
    /**
     * 再意見書送付区分
     * <br/>Enum（DBE：再意見書送付区分）0：未使用、1：再送信、2：再意見書、3：再意見書送付済　[松本広域でのみ使用：Always]
     */
    saiIkenshoSofuKubun(1, 0),
    /**
     * 再イメージ送付区分
     * <br/>Enum（DBE：再イメージ送付区分）0：未使用、1：再送信、2：再イメージ、3：再イメージ送信済
     */
    saiImageSofuKubun(1, 0),
    /**
     * 再送信年月日
     */
    saiSoshinYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5191RenkeiyoDataSofuKiroku(int maxLength, int scale) {
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
