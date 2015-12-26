package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyoの項目定義クラスです
 *
 */
public enum DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyo implements IColumnDefinition {
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
     * 特定入所者介護サービス費用情報レコード順次番号
     */
    recodeJunjiNo(2, 0),
    /**
     * サービス種類コード
     */
    serviceSyuruiCode(2147483647, 0),
    /**
     * サービス項目コード
     */
    serviceKomokuCode(2147483647, 0),
    /**
     * 費用単価
     */
    hiyoTanka(5, 0),
    /**
     * 負担限度額
     */
    futanGendogaku(5, 0),
    /**
     * 日数
     */
    nissu(5, 0),
    /**
     * 公費１日数
     */
    kohi1Nissu(5, 0),
    /**
     * 公費２日数
     */
    kohi2Nissu(5, 0),
    /**
     * 公費３日数
     */
    kohi3Nissu(5, 0),
    /**
     * 費用額
     */
    hiyogaku(10, 0),
    /**
     * 保険分請求額
     */
    hokenbunSeikyugaku(10, 0),
    /**
     * 公費１負担額（明細）
     */
    kohi1Futangaku(10, 0),
    /**
     * 公費２負担額（明細）
     */
    kohi2Futangaku(10, 0),
    /**
     * 公費３負担額（明細）
     */
    kohi3Futangaku(10, 0),
    /**
     * 利用者負担額
     */
    riyoshaFutangaku(10, 0),
    /**
     * 費用額合計
     */
    hiyogakuTotal(10, 0),
    /**
     * 保険分請求額合計
     */
    hokenbunSeikyugakuTotal(10, 0),
    /**
     * 利用者負担額合計
     */
    riyoshaFutangakuTotal(10, 0),
    /**
     * 公費１・負担額合計
     */
    kohi1FutangakuTotal(10, 0),
    /**
     * 公費１・請求額
     */
    kohi1Seikyugaku(10, 0),
    /**
     * 公費１・本人負担月額
     */
    kohi1HonninFutanGetsugaku(10, 0),
    /**
     * 公費２・負担額合計
     */
    kohi2FutangakuTotal(10, 0),
    /**
     * 公費２・請求額
     */
    kohi2Seikyugaku(10, 0),
    /**
     * 公費２・本人負担月額
     */
    kohi2HonninFutanGetsugaku(10, 0),
    /**
     * 公費３・負担額合計
     */
    kohi3FutangakuTotal(10, 0),
    /**
     * 公費３・請求額
     */
    kohi3Seikyugaku(10, 0),
    /**
     * 公費３・本人負担月額
     */
    kohi3HonninFutanGetsugaku(10, 0),
    /**
     * 後・費用単価
     */
    atoHiyoTanka(5, 0),
    /**
     * 後・日数
     */
    atoNissu(5, 0),
    /**
     * 後・公費１日数
     */
    atoKohi1Nissu(5, 0),
    /**
     * 後・公費２日数
     */
    atoKohi2Nissu(5, 0),
    /**
     * 後・公費３日数
     */
    atoKohi3Nissu(5, 0),
    /**
     * 後・費用額
     */
    atoHiyogaku(10, 0),
    /**
     * 後・保険分請求額
     */
    atoHokenbunSeikyugaku(10, 0),
    /**
     * 後・公費１負担額（明細）
     */
    atoKohi1Futangaku(10, 0),
    /**
     * 後・公費２負担額（明細）
     */
    atoKohi2Futangaku(10, 0),
    /**
     * 後・公費３負担額（明細）
     */
    atoKohi3Futangaku(10, 0),
    /**
     * 後・利用者負担額
     */
    atoRiyoshaFutangaku(10, 0),
    /**
     * 後・費用額合計
     */
    atoHiyogakuTotal(10, 0),
    /**
     * 後・保険分請求額合計
     */
    atoHokenbunSeikyugakuTotal(10, 0),
    /**
     * 後・利用者負担額合計
     */
    atoRiyoshaFutangakuTotal(10, 0),
    /**
     * 後・公費１・負担額合計
     */
    atoKohi1FutangakuTotal(10, 0),
    /**
     * 後・公費１・請求額
     */
    atoKohi1Seikyugaku(10, 0),
    /**
     * 後・公費１・本人負担月額
     */
    atoKohi1HonninFutanGetsugaku(10, 0),
    /**
     * 後・公費２・負担額合計
     */
    atoKohi2FutangakuTotal(10, 0),
    /**
     * 後・公費２・請求額
     */
    atoKohi2Seikyugaku(10, 0),
    /**
     * 後・公費２・本人負担月額
     */
    atoKohi2HonninFutanGetsugaku(10, 0),
    /**
     * 後・公費３・負担額合計
     */
    atoKohi3FutangakuTotal(10, 0),
    /**
     * 後・公費３・請求額
     */
    atoKohi3Seikyugaku(10, 0),
    /**
     * 後・公費３・本人負担月額
     */
    atoKohi3HonninFutanGetsugaku(10, 0),
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

    private DbT3029KyufujissekiTokuteiNyushosyaKaigoServiceHiyo(int maxLength, int scale) {
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
