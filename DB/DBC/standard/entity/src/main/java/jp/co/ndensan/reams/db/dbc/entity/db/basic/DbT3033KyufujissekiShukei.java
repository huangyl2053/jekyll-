package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3033KyufujissekiShukeiの項目定義クラスです
 *
 */
public enum DbT3033KyufujissekiShukei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.3">
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
    serviceSyuruiCode(2147483647, 0),
    /**
     * サービス実日数
     */
    serviceJitsunissu(5, 0),
    /**
     * 計画単位数
     */
    planTanisu(10, 0),
    /**
     * 限度額管理対象単位数
     */
    gendogakuKanriTaishoTanisu(10, 0),
    /**
     * 限度額管理対象外単位数
     */
    gendogakuKanritaishogaiTanisu(10, 0),
    /**
     * 短期入所計画日数
     */
    tankiNyushoPlanNissu(5, 0),
    /**
     * 短期入所実日数
     */
    tankiNyushoJitsunissu(5, 0),
    /**
     * 保険・単位数合計
     */
    hokenTanisuTotal(10, 0),
    /**
     * 保険・単位数単価
     */
    hokenTanisuTani(4, 0),
    /**
     * 保険・請求額
     */
    hokenSeikyugaku(9, 0),
    /**
     * 保険・利用者負担額
     */
    hokenRiyoshaFutangaku(10, 0),
    /**
     * 公費１・単位数合計
     */
    kohi1TanisuTotal(10, 0),
    /**
     * 公費１・請求額
     */
    kohi1Seikyugaku(9, 0),
    /**
     * 公費１・本人負担額
     */
    kohi1HonninFutangaku(10, 0),
    /**
     * 公費２・単位数合計
     */
    kohi2TanisuTotal(10, 0),
    /**
     * 公費２・請求額
     */
    kohi2Seikyugaku(9, 0),
    /**
     * 公費２・本人負担額
     */
    kohi2HonninFutangaku(10, 0),
    /**
     * 公費３・単位数合計
     */
    kohi3TanisuTotal(10, 0),
    /**
     * 公費３・請求額
     */
    kohi3Seikyugaku(9, 0),
    /**
     * 公費３・本人負担額
     */
    kohi3HonninFutangaku(10, 0),
    /**
     * 保険・出来高単位数合計
     */
    hokenDekidakaTanisuTotal(10, 0),
    /**
     * 保険・出来高請求額
     */
    hokenDekidakaSeikyugaku(9, 0),
    /**
     * 保険・出来高医療費利用者負担額
     */
    hokenDekidakaIryohiRiyoshaFutangaku(10, 0),
    /**
     * 公費１・出来高単位数合計
     */
    kohi1DekidakaTanisuTotal(10, 0),
    /**
     * 公費１・出来高請求額
     */
    kohi1DekidakaSeikyugaku(9, 0),
    /**
     * 公費１・出来高医療費利用者負担額
     */
    kohi1DekidakaIryohiRiyoshaFutangaku(10, 0),
    /**
     * 公費２・出来高単位数合計
     */
    kohi2DekidakaTanisuTotal(10, 0),
    /**
     * 公費２・出来高請求額
     */
    kohi2DekidakaSeikyugaku(9, 0),
    /**
     * 公費２・出来高医療費本人負担額
     */
    kohi2DekidakaIryohiRiyoshaFutangaku(10, 0),
    /**
     * 公費３・出来高単位数合計
     */
    kohi3DekidakaTanisuTotal(10, 0),
    /**
     * 公費３・出来高請求額
     */
    kohi3DekidakaSeikyugaku(9, 0),
    /**
     * 公費３・出来高医療費本人負担額
     */
    kohi3DekidakaIryohiRiyoshaFutangaku(10, 0),
    /**
     * 後・短期入所実日数
     */
    atoTankiNyushoJitsunissu(10, 0),
    /**
     * 後・単位数合計
     */
    atoHokenTanisuTotal(10, 0),
    /**
     * 後・保険請求分請求額
     */
    atoHokenSeikyugaku(9, 0),
    /**
     * 後・公費１・単位数合計
     */
    atoKohi1TanisuTotal(10, 0),
    /**
     * 後・公費１・請求額
     */
    atoKohi1Seikyugaku(9, 0),
    /**
     * 後・公費２・単位数合計
     */
    atoKohi2TanisuTotal(10, 0),
    /**
     * 後・公費２・請求額
     */
    atoKohi2Seikyugaku(9, 0),
    /**
     * 後・公費３・単位数合計
     */
    atoKohi3TanisuTotal(10, 0),
    /**
     * 後・公費３・請求額
     */
    atoKohi3Seikyugaku(9, 0),
    /**
     * 後・保険・出来高単位数合計
     */
    atoHokenDekidakaTanisuTotal(10, 0),
    /**
     * 後・保険・出来高請求額
     */
    atoHokenDekidakaSeikyugaku(9, 0),
    /**
     * 後・公費１・出来高単位数合計
     */
    atoKohi1DekidakaTanisuTotal(10, 0),
    /**
     * 後・公費１・出来高請求額
     */
    atoKohi1DekidakaSeikyugaku(9, 0),
    /**
     * 後・公費２・出来高単位数合計
     */
    atoKohi2DekidakaTanisuTotal(10, 0),
    /**
     * 後・公費２・出来高請求額
     */
    atoKohi2DekidakaSeikyugaku(9, 0),
    /**
     * 後・公費３・出来高単位数合計
     */
    atoKohi3DekidakaTanisuTotal(10, 0),
    /**
     * 後・公費３・出来高請求額
     */
    atoKohi3DekidakaSeikyugaku(9, 0),
    /**
     * 再審査回数
     */
    saishinsaKaisu(10, 0),
    /**
     * 過誤回数
     */
    kagoKaisu(10, 0),
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

    private DbT3033KyufujissekiShukei(int maxLength, int scale) {
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
