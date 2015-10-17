package jp.co.ndensan.reams.db.dbe.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定完了情報テーブルの項目定義クラスです。
 */
public enum DbT5105NinteiKanryoJoho implements IColumnDefinition {
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
     * 認定申請情報登録完了年月日
     */
    ninteiShinseiJohoTorokuKanryoYMD(2147483647, 0),
    /**
     * 認定調査依頼完了年月日
     */
    ninteichosaIraiKanryoYMD(2147483647, 0),
    /**
     * 認定調査完了年月日
     */
    ninteichosaKanryoYMD(2147483647, 0),
    /**
     * 主治医意見書作成依頼完了年月日
     */
    ikenshoSakuseiIraiKanryoYMD(2147483647, 0),
    /**
     * 主治医意見書登録完了年月日
     */
    ikenshoTorokuKanryoYMD(2147483647, 0),
    /**
     * 要介護認定一次判定完了年月日
     */
    ichijiHanteiKanryoYMD(2147483647, 0),
    /**
     * マスキング完了年月日
     */
    maskingKanryoYMD(2147483647, 0),
    /**
     * 認定審査会割当完了年月日
     */
    ninteiShinsakaiWariateKanryoYMD(2147483647, 0),
    /**
     * 認定審査会完了年月日
     */
    ninteiShinsakaiKanryoYMD(2147483647, 0),
    /**
     * センター送信年月日
     */
    centerSoshinYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5105NinteiKanryoJoho(int maxLength, int scale) {
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
