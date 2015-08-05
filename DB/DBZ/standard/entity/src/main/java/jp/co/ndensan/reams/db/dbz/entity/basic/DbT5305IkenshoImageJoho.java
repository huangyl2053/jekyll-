package jp.co.ndensan.reams.db.dbz.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定意見書イメージ情報テーブルの項目定義クラスです。
 */
public enum DbT5305IkenshoImageJoho implements IColumnDefinition {
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
     * 主治医意見書作成依頼履歴番号
     * <br/>主治医意見書作成依頼情報
     */
    iraiRirekiNo(5, 0),
    /**
     * 帳票ID
     */
    ChoyoID(2147483647, 0),
    /**
     * マスキングデータ区分
     * <br/>Enum（DBE：原本マスク区分）
     */
    maskDataKubun(1, 0),
    /**
     * 取込みページ番号
     */
    torikomiPageNo(5, 0),
    /**
     * 認定申請年
     * <br/>パーティション振り分け用
     */
    ninteiShinseiNen(10, 0),
    /**
     * 共有ファイルID
     */
    sharedFileId(29, 0);

    private final int maxLength;
    private final int scale;

    private DbT5305IkenshoImageJoho(int maxLength, int scale) {
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
