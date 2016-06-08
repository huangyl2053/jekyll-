package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 高額介護サービス費給付対象者合計テーブルの項目定義クラスです。
 */
public enum DbT3055KogakuKyufuTaishoshaGokei implements IColumnDefinition {
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
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * サービス費用合計額合計
     */
    serviceHiyoGokeiGakuGokei(9, 0),
    /**
     * 利用者負担額合計
     */
    riyoshaFutanGakuGokei(9, 0),
    /**
     * 算定基準額
     */
    santeiKijunGaku(9, 0),
    /**
     * 支払済金額合計
     */
    shiharaiSumiKingakuGokei(9, 0),
    /**
     * 高額支給額
     */
    KogakuShikyuGaku(9, 0),
    /**
     * 対象者受取年月
     */
    tashoshaUketoriYM(2147483647, 0),
    /**
     * 対象者判定審査年月
     */
    taishoshaHanteiShinsaYM(2147483647, 0),
    /**
     * 世帯集約番号
     */
    setaiShuyakuNo(10, 0),
    /**
     * 境界層対象者フラグ
     * <br/>True:対象,False:対象外
     */
    kyokaisoTaishoshaFlag(1, 0),
    /**
     * 社会福祉法人軽減対象フラグ
     * <br/>True:対象,False:対象外
     */
    hojinKeigenTaishoFlag(1, 0),
    /**
     * 高額対象外フラグ
     * <br/>True:対象外,False:対象
     */
    kogakuTaishoGaiFlag(1, 0),
    /**
     * 自動償還対象フラグ
     * <br/>True:対象,False:対象外
     */
    jidoShokanTaishoFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3055KogakuKyufuTaishoshaGokei(int maxLength, int scale) {
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
