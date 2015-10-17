package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 外部連携データ抽出情報テーブルの項目定義クラスです。
 */
public enum DbT7211GaibuRenkeiDataoutputJoho implements IColumnDefinition {
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
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 認定申請情報抽出年月日
     */
    ninteiShinseiJohoChushutsuYMD(2147483647, 0),
    /**
     * 認定調査結果情報抽出年月日
     */
    ninteiChosaKekkaJohoChushutsuYMD(2147483647, 0),
    /**
     * 認定調査・意見書結果情報抽出年月日
     */
    ninteiChosaIkenshoKekkaJohoChushutsuYMD(2147483647, 0),
    /**
     * 一次判定情報抽出年月日
     * <br/>一次判定結果連携時、市町村から広域連合に渡すデータを作成した日付
     */
    ichijihanteiChushutsuYMD(2147483647, 0),
    /**
     * 審査会結果情報抽出年月日
     */
    shinsakaiKekkaJohoChushutsuYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7211GaibuRenkeiDataoutputJoho(int maxLength, int scale) {
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
