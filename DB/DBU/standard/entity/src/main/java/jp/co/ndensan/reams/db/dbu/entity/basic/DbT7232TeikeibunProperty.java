package jp.co.ndensan.reams.db.dbu.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 定型文属性テーブルの項目定義クラスです。
 */
public enum DbT7232TeikeibunProperty implements IColumnDefinition {
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
     * 定型文属性ID
     * <br/>内部的なPK
     */
    teikeibunZokuseiID(131089, 0),
    /**
     * 定型文属性コード
     * <br/>101：認定理由、102：サ変理由、103：取消理由、104：却下理由、105：延期理由、109：サービス種類、201：調査票住宅改修、202：調査票主訴、203：調査票家族状況、204：調査票居住環境、205：機器器械、210：特記事項、501：審査会意見、502：審査会メモ、503：審査会メモ情報
     */
    teikeibunZokuseiCode(4, 0),
    /**
     * 属性名称
     */
    teikeibunZokuseiName(30, 0),
    /**
     * 定型文コード
     */
    teikeibunCode(10, 0);

    private final int maxLength;
    private final int scale;

    private DbT7232TeikeibunProperty(int maxLength, int scale) {
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
