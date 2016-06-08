package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 帳票制御汎用テーブルの項目定義クラスです。
 * <br/> 帳票制御のために必要な、各帳票独自の項目を管理します。
 */
public enum DbT7067ChohyoSeigyoHanyo implements IColumnDefinition {
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
     * サブ業務コード
     */
    subGyomuCode(2147483647, 0),
    /**
     * 帳票分類ID
     */
    chohyoBunruiID(2147483647, 0),
    /**
     * 管理年度
     */
    kanriNendo(2147483647, 0),
    /**
     * 項目名
     */
    komokuName(2147483647, 0),
    /**
     * 設定値
     */
    komokuValue(2147483647, 0),
    /**
     * 説明
     */
    komokuSetsumei(2147483647, 0),
    /**
     * 変更可否
     */
    henkoKahi(1, 0),
    /**
     * コードマスタサブ業務コード
     */
    codeMasterSubGyomuCode(2147483647, 0),
    /**
     * コードマスタコード種別
     */
    codeMasterCodeShubetsu(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7067ChohyoSeigyoHanyo(int maxLength, int scale) {
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
