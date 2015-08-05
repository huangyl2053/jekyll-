package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 特定診療サービスコードテーブルの項目定義クラスです。
 */
public enum DbT7120TokuteiShinryoServiceCode implements IColumnDefinition {
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
     * サービス種類コード
     */
    serviceShuruiCode(2147483647, 0),
    /**
     * サービス項目コード
     */
    serviceKomokuCode(2147483647, 0),
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
     * サービス名称
     */
    serviceMeisho(100, 0),
    /**
     * 単位数
     */
    taniSu(10, 0),
    /**
     * 単位数識別
     */
    taniSuShikibetsu(2, 0),
    /**
     * 算定単位
     */
    santeiTani(2, 0),
    /**
     * 合成識別区分
     */
    goseiShikibetsuKubun(1, 0),
    /**
     * 特定診療区分コード
     */
    tokuteiShinryoKubunCode(2, 0),
    /**
     * 特定診療項目コード
     * <br/>回数（日数）
     */
    tokuteiShinryoKomokuCode(2, 0),
    /**
     * 算定制約期間
     */
    santeiSeiyakuKikan(2, 0),
    /**
     * 算定制約回数
     */
    santeiSeiyakuKaisu(6, 0);

    private final int maxLength;
    private final int scale;

    private DbT7120TokuteiShinryoServiceCode(int maxLength, int scale) {
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
