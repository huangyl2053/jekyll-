package jp.co.ndensan.reams.db.dbz.entity.db.basic.kyotakukeikaku;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3007KyotakuKeikakuJikoSakuseiの項目定義クラスです
 *
 */
public enum DbT3007KyotakuKeikakuJikoSakusei implements IColumnDefinition {
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
    hihokenshaNo(2147483647, 0),
    /**
     * 対象年月
     */
    taishoYM(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 居宅・総合事業区分
     * <br/>1:居宅サービス計画,2:総合事業費計画
     */
    kyotaku_SogoJigyoKubun(1, 0),
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
     * <br/>3：自己作成（固定）
     */
    sakuseiKubunCode(1, 0),
    /**
     * 計画作成年月日
     */
    keikakuSakuseiYMD(2147483647, 0),
    /**
     * 計画変更年月日
     */
    keikakuHenkoYMD(2147483647, 0),
    /**
     * 計画変更事由
     */
    keikakuHenkoJiyu(100, 0);

    private final int maxLength;
    private final int scale;

    private DbT3007KyotakuKeikakuJikoSakusei(int maxLength, int scale) {
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
