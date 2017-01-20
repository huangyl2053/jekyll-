package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定外部データ出力履歴テーブルの項目定義クラスです。
 */
public enum DbT7204YokaigoNinteiGaibuDataOutputHistory implements IColumnDefinition {
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
     * 外部出力データ区分
     * <br/>Enum（DBE：外部出力データ区分）1:申請情報、2:４マスタ、3:資格喪失(死亡)情報
     */
    dataKubun(2147483647, 0),
    /**
     * データ出力開始年月日時分秒
     */
    dataOutputKaishiYMDHMS(2147483647, 0),
    /**
     * データ出力終了年月日時分秒
     */
    dataOutputShuryoYMDHMS(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7204YokaigoNinteiGaibuDataOutputHistory(int maxLength, int scale) {
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
