package jp.co.ndensan.reams.db.dbz.entity.db.basic;
import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 認定調査スケジュール情報テーブルの項目定義クラスです。
 */
public enum DbT5221NinteichosaSchedule implements IColumnDefinition {
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
     * 認定調査予定年月日
     */
    ninteiChosaYoteiYMD(2147483647, 0),
    /**
     * 認定調査予定開始時間
     */
    ninteiChosaYoteiKaishiTime(4, 0),
    /**
     * 認定調査予定終了時間
     */
    ninteiChosaYoteiShuryoTime(4, 0),
    /**
     * 認定調査時間枠
     */
    ninteiChosaJikanWaku(2147483647, 0),
    /**
     * 調査地区コード
     */
    chosaChikuCode(2147483647, 0),
    /**
     * 認定調査委託先コード
     * <br/>認定調査委託先情報
     */
    ninteiChosaItakusakiCode(10, 0),
    /**
     * 認定調査員コード
     * <br/>認定調査員情報
     */
    ninteiChosainCode(8, 0),
    /**
     * 市町村コード
     * <br/>市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 申請書管理番号
     * <br/>要介護認定申請情報
     */
    shinseishoKanriNo(2147483647, 0),
    /**
     * 予約状況
     * <br/>Enum（DBE：予約状況）
     */
    yoyakuJokyo(2147483647, 0),
    /**
     * 予約可能フラグ
     * <br/>Enum（DBE：予約可能フラグ）
     */
    yoyakuKaoFlag(1, 0),
    /**
     * 備考
     */
    biko(2147483647, 0),
    /**
     * 場所
     */
    basho(2147483647, 0),
    /**
     * 駐車場
     */
    chushajo(2147483647, 0),
    /**
     * 立会人１
     */
    tachiainin1(2147483647, 0),
    /**
     * 連絡先１
     */
    renrakusaki1(2147483647, 0),
    /**
     * 立会人２
     */
    tachiainin2(2147483647, 0),
    /**
     * 連絡先２
     */
    renrakusaki2(2147483647, 0),
    /**
     * 対象者メモ
     */
    taishoshaMemo(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT5221NinteichosaSchedule(int maxLength, int scale) {
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
