package jp.co.ndensan.reams.db.dbx.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT7022ShoriDateKanriの項目定義クラスです
 *
 */
public enum DbT7022ShoriDateKanri implements IColumnDefinition {
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
     * サブ業務コード
     */
    subGyomuCode(2147483647, 0),
    /**
     * 市町村コード
     */
    shichosonCode(2147483647, 0),
    /**
     * 処理名
     */
    shoriName(100, 0),
    /**
     * 処理枝番
     * <br/>01から連番
     */
    shoriEdaban(4, 0),
    /**
     * 年度
     * <br/>使用しない場合は「0000」固定
     */
    nendo(2147483647, 0),
    /**
     * 年度内連番
     * <br/>01から連番
     */
    nendoNaiRenban(4, 0),
    /**
     * 基準年月日
     */
    kijunYMD(2147483647, 0),
    /**
     * 基準日時
     */
    kijunTimestamp(2147483647, 0),
    /**
     * 対象開始年月日
     */
    taishoKaishiYMD(2147483647, 0),
    /**
     * 対象終了年月日
     */
    taishoShuryoYMD(2147483647, 0),
    /**
     * 対象開始日時
     */
    taishoKaishiTimestamp(2147483647, 0),
    /**
     * 対象終了日時
     */
    taishoShuryoTimestamp(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7022ShoriDateKanri(int maxLength, int scale) {
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
