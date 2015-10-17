package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払請求住宅改修テーブルの項目定義クラスです。
 */
public enum DbT3049ShokanJutakuKaishu implements IColumnDefinition {
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
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNo(10, 0),
    /**
     * 事業者番号
     */
    jigyoshaNo(2147483647, 0),
    /**
     * 様式番号
     */
    yoshikiNo(4, 0),
    /**
     * 順次番号
     * <br/>複数レコード対応のため
     */
    junjiNo(4, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * サービスコード
     */
    serviceCode(2147483647, 0),
    /**
     * 住宅改修着工年月日
     */
    jutakuKaishuChakkoYMD(2147483647, 0),
    /**
     * 住宅改修事業者名
     */
    jutakuKaishuJigyoshaName(20, 0),
    /**
     * 住宅改修住宅住所
     */
    jutakuKaishuJutakuAddress(64, 0),
    /**
     * 改修金額
     */
    kaishuKingaku(10, 0),
    /**
     * 審査方法区分コード
     */
    shinsaHohoKubunCode(1, 0),
    /**
     * 住宅改修完成年月日
     */
    jutakuKaishuKanseiYMD(2147483647, 0),
    /**
     * 差額金額
     */
    sagakuKingaku(10, 0);

    private final int maxLength;
    private final int scale;

    private DbT3049ShokanJutakuKaishu(int maxLength, int scale) {
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
