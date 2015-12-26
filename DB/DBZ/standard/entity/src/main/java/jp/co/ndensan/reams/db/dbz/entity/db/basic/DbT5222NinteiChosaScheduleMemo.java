package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査スケジュールメモ情報テーブルの項目定義クラスです。
 */
public enum DbT5222NinteiChosaScheduleMemo implements IColumnDefinition {
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
     * メモ年月日
     */
    memoYMD(2147483647, 0),
    /**
     * 調査地区コード
     */
    chosachikucode(2147483647, 0),
    /**
     * メモ区分
     */
    memoKubun(2147483647, 0),
    /**
     * 連番
     */
    remban(5, 0),
    /**
     * メモ指定調査地区コード
     * <br/>Code（DBE：5002）
     */
    memoShiteiChosaChikuCode(2147483647, 0),
    /**
     * 作成者
     */
    sakuseisha(80, 0),
    /**
     * memoPriority
     */
    memoPriority(2147483647, 0),
    /**
     * メモ内容
     */
    memoNaiyo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5222NinteiChosaScheduleMemo(int maxLength, int scale) {
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
