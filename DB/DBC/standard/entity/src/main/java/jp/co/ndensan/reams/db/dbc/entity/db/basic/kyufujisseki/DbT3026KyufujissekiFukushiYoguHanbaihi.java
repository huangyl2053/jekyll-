package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3026KyufujissekiFukushiYoguHanbaihiの項目定義クラスです
 *
 */
public enum DbT3026KyufujissekiFukushiYoguHanbaihi implements IColumnDefinition {
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
     * 交換情報識別番号
     */
    kokanJohoShikibetsuNo(2147483647, 0),
    /**
     * 入力識別番号
     */
    inputShikibetsuNo(2147483647, 0),
    /**
     * レコード種別コード
     */
    recodeShubetsuCode(2, 0),
    /**
     * 証記載保険者番号
     */
    shokisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 事業所番号
     */
    jigyoshoNo(2147483647, 0),
    /**
     * 通し番号
     */
    toshiNo(10, 0),
    /**
     * 明細番号
     */
    meisaiNo(4, 0),
    /**
     * サービスコード
     */
    serviceCode(2147483647, 0),
    /**
     * 福祉用具販売年月日
     */
    fukushiyoguHanbaiYMD(2147483647, 0),
    /**
     * 福祉用具商品名
     */
    fukushiyoguShohinName(30, 0),
    /**
     * 福祉用具種目コード
     */
    fukushiyoguSyumokuCode(2, 0),
    /**
     * 福祉用具製造事業者名
     */
    fukushiyoguSeizoJigyoshaName(20, 0),
    /**
     * 福祉用具販売事業者名
     */
    fukushiyoguHanbaiJigyoshaName(20, 0),
    /**
     * 販売金額
     */
    hanbaiKingaku(10, 0),
    /**
     * 摘要（品目コード）
     */
    tekiyo(20, 0),
    /**
     * 審査年月
     */
    shinsaYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNo(10, 0),
    /**
     * 取込年月
     */
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3026KyufujissekiFukushiYoguHanbaihi(int maxLength, int scale) {
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
