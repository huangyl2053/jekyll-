package jp.co.ndensan.reams.db.dbz.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定計画情報テーブルの項目定義クラスです。
 */
public enum DbT4123NinteiKeikakuJoho implements IColumnDefinition {
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
     * 認定調査依頼予定年月日
     */
    ninteichosaIraiYoteiYMD(2147483647, 0),
    /**
     * 認定調査予定年月日
     */
    ninteichosaYoteiYMD(2147483647, 0),
    /**
     * 主治医意見書作成依頼予定年月日
     */
    ikenshoSakuseiIraiYoteiYMD(2147483647, 0),
    /**
     * 主治医意見書登録予定年月日
     */
    ikenshoTorokuYoteiYMD(2147483647, 0),
    /**
     * 要介護認定一次判定予定年月日
     */
    ichijiHanteiYoteiYMD(2147483647, 0),
    /**
     * 認定審査会割当予定年月日
     */
    ninteiShinsakaiWariateYoteiYMD(2147483647, 0),
    /**
     * 認定審査会予定年月日
     */
    ninteiShinsakaiYoteiYMD(2147483647, 0),
    /**
     * センター送信予定年月日
     */
    centerSoshinYoteiYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT4123NinteiKeikakuJoho(int maxLength, int scale) {
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
