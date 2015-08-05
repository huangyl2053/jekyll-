package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 市町村単独助成種類テーブルの項目定義クラスです。
 */
public enum DbT3099TandokuJoseiShurui implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.1">

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
     * 市町村単独助成種類
     */
    tandokuJoseiShuruiCode(2, 0),
    /**
     * 助成サービス種類コード
     */
    joseiServiceShuruiCode(2147483647, 0),
    /**
     * 適用開始年月
     */
    tekiyoKaishiYM(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 適用終了年月
     */
    tekiyoShuryoYM(2147483647, 0),
    /**
     * 助成サービス種類名称
     */
    joseiServiceShuriMeisho(50, 0),
    /**
     * 市町村単独助成単位
     */
    joseiTani(6, 0),
    /**
     * 市町村単独助成内容
     */
    joseiNaiyo(500, 0);

    private final int maxLength;
    private final int scale;

    private DbT3099TandokuJoseiShurui(int maxLength, int scale) {
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
