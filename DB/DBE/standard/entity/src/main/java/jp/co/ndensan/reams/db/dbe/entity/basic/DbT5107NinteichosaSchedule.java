package jp.co.ndensan.reams.db.dbe.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 要介護認定調査スケジュールテーブルの項目定義クラスです。
 */
public enum DbT5107NinteichosaSchedule implements IColumnDefinition {
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
     * 連番
     */
    remban(5, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 認定調査委託先コード
     */
    chosaItakusakiCode(2147483647, 0),
    /**
     * 認定調査員コード
     */
    chosainCode(8, 0),
    /**
     * 認定調査予定年月日
     */
    ninteichosaYoteiYMD(2147483647, 0),
    /**
     * 認定調査予定開始時間
     */
    ninteichosaYoteiKaishiTime(4, 0),
    /**
     * 認定調査予定終了時間
     */
    ninteichosaYoteiShuryoTime(4, 0),
    /**
     * 一日最大調査件数
     */
    ichinichiMaxKensu(5, 0),
    /**
     * 認定調査開始時間
     */
    ninteichosaKaishiTime(4, 0),
    /**
     * 認定調査終了時間
     */
    ninteichosaShuryoTime(4, 0),
    /**
     * 調査場所コード
     */
    chosaBashoChikuCode(2147483647, 0),
    /**
     * 訪問種類
     */
    visitShurui(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * メモ
     */
    memo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5107NinteichosaSchedule(int maxLength, int scale) {
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
