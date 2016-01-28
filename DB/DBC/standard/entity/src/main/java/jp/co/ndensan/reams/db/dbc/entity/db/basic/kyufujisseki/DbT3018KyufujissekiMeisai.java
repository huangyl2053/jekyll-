package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3018KyufujissekiMeisaiの項目定義クラスです
 *
 */
public enum DbT3018KyufujissekiMeisai implements IColumnDefinition {
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
     * サービス種類コード
     */
    serviceShuruiCode(2147483647, 0),
    /**
     * サービス項目コード
     */
    serviceKomokuCode(2147483647, 0),
    /**
     * 単位数
     */
    tanisu(5, 0),
    /**
     * 日数・回数
     */
    nissuKaisu(5, 0),
    /**
     * 公費１対象日数・回数
     */
    kohi1TaishoNissuKaisu(5, 0),
    /**
     * 公費２対象日数・回数
     */
    kohi2TaishoNissuKaisu(5, 0),
    /**
     * 公費３対象日数・回数
     */
    kohi3TaishoNissuKaisu(5, 0),
    /**
     * サービス単位数
     */
    serviceTanisu(10, 0),
    /**
     * 公費１対象サービス単位数
     */
    kohi1TaishoServiceTanisu(10, 0),
    /**
     * 公費２対象サービス単位数
     */
    kohi2TaishoServiceTanisu(10, 0),
    /**
     * 公費３対象サービス単位数
     */
    kohi3TaishoServiceTanisu(10, 0),
    /**
     * 摘要
     */
    tekiyo(20, 0),
    /**
     * 後・単位数
     */
    atoTanisu(5, 0),
    /**
     * 後・日数・回数
     */
    atoNissuKaisu(5, 0),
    /**
     * 後・公費１対象日数・回数
     */
    atoKohi1TaishoNissuKaisu(5, 0),
    /**
     * 後・公費２対象日数・回数
     */
    atoKohi2TaishoNissukaisu(5, 0),
    /**
     * 後・公費３対象日数・回数
     */
    atoKohi3TaishoNissuKaisu(5, 0),
    /**
     * 後・サービス単位数
     */
    atoServiceTanisu(10, 0),
    /**
     * 後・公費１対象サービス単位数
     */
    atoKohi1TaishoServiceTanisu(10, 0),
    /**
     * 後・公費２対象サービス単位数
     */
    atoKohi2TaishoServiceTanisu(10, 0),
    /**
     * 後・公費３対象サービス単位数
     */
    atoKohi3TaishoServiceTanisu(10, 0),
    /**
     * 再審査回数
     */
    saishinsaKaisu(5, 0),
    /**
     * 過誤回数
     */
    kagoKaisu(5, 0),
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

    private DbT3018KyufujissekiMeisai(int maxLength, int scale) {
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
