package jp.co.ndensan.reams.db.dbu.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 特定個人情報項目版管理テーブルの項目定義クラスです。
 */
public enum DbT7302TokuteiKojinJohoKoumokuHanKanri implements IColumnDefinition {
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
     * 項番
     */
    koban(10, 0),
    /**
     * 特定個人情報項目コード
     */
    tokuteiKojinJohoKomokuCode(16, 0),
    /**
     * 特定個人情報名コード
     */
    tokuteiKojinJohoMeiCode(16, 0),
    /**
     * コード連番
     */
    codeRenban(4, 0),
    /**
     * バージョン情報
     */
    versionJoho(4, 0),
    /**
     * 無効化フラグ
     */
    mukokaFlag(1, 0),
    /**
     * 有効開始日時
     */
    yukoStNichiji(2147483647, 0),
    /**
     * 有効終了日時
     */
    yukoEdNichiji(2147483647, 0),
    /**
     * 特定個人情報の項目名
     */
    tokuteiKojinJohoKomokuMei(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT7302TokuteiKojinJohoKoumokuHanKanri(int maxLength, int scale) {
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
