package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 介護認定審査会割当情報テーブルの項目定義クラスです。
 */
public enum DbT5502ShinsakaiWariateJoho implements IColumnDefinition {
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
     * 介護認定審査会開催番号
     * <br/>介護認定審査会開催予定情報
     */
    shinsakaiKaisaiNo(8, 0),
    /**
     * 申請書管理番号
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 介護認定審査会開催年月日
     */
    shinsakaiKaisaiYMD(2147483647, 0),
    /**
     * 介護認定審査会割当年月日
     */
    shinsakaiWariateYMD(2147483647, 0),
    /**
     * 介護認定審査会審査順
     */
    shinsakaiOrder(5, 0),
    /**
     * 介護認定審査会審査順確定フラグ
     * <br/>Enum（DBE：介護認定審査会審査順確定フラグ）
     */
    shinsakaiOrderKakuteiFlag(1, 0),
    /**
     * 審査会自動割付フラグ
     * <br/>Enum（DBE：審査会自動割付フラグ）
     */
    shinsakaiJidoWaritsukeFlag(1, 0),
    /**
     * 審査会資料作成年月日
     */
    shinsakaiShiryoSakuseiYMD(2147483647, 0),
    /**
     * 審査会資料送付年月日
     */
    shinsakaiShiryoSofuYMD(2147483647, 0),
    /**
     * 判定結果コード
     * <br/>Enum（DBE：判定結果コード）01：認定、11：未審査、21：再審査、31：再調査（調査票・意見書）、32：再調査（調査のみ）、33：再調査（意見書のみ）
     */
    hanteiKekkaCode(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5502ShinsakaiWariateJoho(int maxLength, int scale) {
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
