package jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3006KyotakuKeikakuJigyoshaSakuseiの項目定義クラスです
 *
 */
public enum DbT3006KyotakuKeikakuJigyoshaSakusei implements IColumnDefinition {
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
     * 被保険者番号
     */
    hihokenshano(2147483647, 0),
    /**
     * 対象年月
     */
    taishoYM(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 適用開始年月日
     */
    tekiyoKaishiYMD(2147483647, 0),
    /**
     * 適用終了年月日
     */
    tekiyoShuryoYMD(2147483647, 0),
    /**
     * 作成区分コード
     * <br/>1：指定居宅介護支援事業者作成、2：基準該当居宅介護支援事業者作成、4：介護予防支援事業者作成
     */
    sakuseiKubunCode(1, 0),
    /**
     * 計画事業者番号
     */
    keikakuJigyoshaNo(2147483647, 0),
    /**
     * 委託先事業者番号
     * <br/>地域包括支援センターの委託先
     */
    itakusakiJigyoshaNo(2147483647, 0),
    /**
     * 事業者変更年月日
     */
    jigyoshaHenkoYMD(2147483647, 0),
    /**
     * 事業者変更事由
     */
    jigyoshaHenkoJiyu(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3006KyotakuKeikakuJigyoshaSakusei(int maxLength, int scale) {
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
