package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 汎用リスト項目変換テーブルの項目定義クラスです。
 * <br/> 汎用リストの出力項目(列名)とExcelファイル上の項目位置の変換に使用
 */
public enum DbT7401HanyoLisyInverted implements IColumnDefinition {
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
     * 帳票ID
     * <br/>出力項目管理テーブル（UrT0072ShutsuryokuKomokuKanri）、出力項目設定テーブル（UrT0073ShutsuryokuKomokuSettei）へのリンク情報
     */
    reportId(2147483647, 0),
    /**
     * 項目ID
     * <br/>帳票出力項目管理（UrT0171ChohyoShutsuryokuKomokuKanri）、出力項目設定テーブル（UrT0073ShutsuryokuKomokuSettei）へのリンク情報
     */
    komokuId(1, 0),
    /**
     * 項目位置
     * <br/>中間(出力用に編集した)CSVのカラム位置（0オリジン）
     */
    komokuIchi(10, 0),
    /**
     * 帳票表示位置
     * <br/>0:左詰め　1:右詰め
     */
    chohyoHyojiIchi(1, 0),
    /**
     * 金額編集
     * <br/>0:不要　1:必要（Z,ZZ9編集)
     */
    kingakuHenshuHoho(1, 0),
    /**
     * 論理削除フラグ
     */
    logicalDeletedFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT7401HanyoLisyInverted(int maxLength, int scale) {
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
