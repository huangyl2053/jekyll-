package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査報酬実績情報テーブルの項目定義クラスです。
 */
public enum DbT5601NinteiChosaHoshuJissekiJoho implements IColumnDefinition {
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
     * 認定調査委託先コード
     * <br/>認定調査委託先情報
     */
    ninteichosaItakusakiCode(10, 0),
    /**
     * 認定調査員コード
     * <br/>認定調査員情報
     */
    ninteichosainCode(8, 0),
    /**
     * 申請書管理番号
     * <br/>要介護認定申請情報
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 認定調査依頼履歴番号
     * <br/>認定調査依頼情報
     */
    ninteichosaIraiRirekiNo(5, 0),
    /**
     * 認定調査委託料
     */
    chosaItakuryo(10, 0),
    /**
     * 認定調査委託料支払年月日
     */
    chosaItakuryoShiharaiYMD(2147483647, 0),
    /**
     * 認定調査委託料支払メモ
     */
    chosaItakuryoShiharaiMemo(2147483647, 0),
    /**
     * 銀行振込出力フラグ
     * <br/>Enum（DBE：銀行振込出力フラグ）
     */
    isGinkoFurikomiShutsuryoku(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT5601NinteiChosaHoshuJissekiJoho(int maxLength, int scale) {
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
