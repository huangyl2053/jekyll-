package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * DbT3025KyufujissekiKyotakuServiceの項目定義クラスです
 *
 */
public enum DbT3025KyufujissekiKyotakuService implements IColumnDefinition {
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
     * サービス計画費明細行番号
     * <br/>サービス提供年月が平成２１年４月以降の場合
     */
    servicePlanhiMeisaiLineNo(2, 0),
    /**
     * 指定／基準該当等事業所区分コード
     */
    shiteiKijunGaitoJigyoshaKubunCode(1, 0),
    /**
     * 単位数単価
     */
    tanisuTanka(4, 0),
    /**
     * 居宅サービス計画作成依頼届出年月日
     */
    kyotakuServiceSakuseiIraiYMD(2147483647, 0),
    /**
     * サービスコード
     */
    serviceCode(2147483647, 0),
    /**
     * 単位数
     */
    tanisu(5, 0),
    /**
     * 回数
     * <br/>サービス提供年月が平成２１年４月以降の場合
     */
    kaisu(5, 0),
    /**
     * サービス単位数
     */
    serviceTanisu(10, 0),
    /**
     * サービス単位数合計
     */
    serviceTanisuTotal(10, 0),
    /**
     * 請求金額
     */
    seikyuKingaku(10, 0),
    /**
     * 担当介護支援専門員番号
     * <br/>サービス提供年月が平成１８年４月以降、平成２１年３月以前の場合
     */
    tantouKaigoShienSemmoninNo(8, 0),
    /**
     * 摘要
     * <br/>サービス提供年月が平成１８年４月以降、平成２１年３月以前の場合
     */
    tekiyo(20, 0),
    /**
     * 後・単位数
     */
    atoTanisu(5, 0),
    /**
     * 後・回数
     * <br/>サービス提供年月が平成２１年４月以降の場合
     */
    atoKaisu(5, 0),
    /**
     * 後・サービス単位数
     * <br/>サービス提供年月が平成２１年４月以降の場合
     */
    atoServiceTanisu(10, 0),
    /**
     * 後・サービス単位数合計
     * <br/>サービス提供年月が平成２１年４月以降の場合
     */
    atoServiceTanisuTotal(10, 0),
    /**
     * 後・請求金額
     */
    atoSeikyuKingaku(10, 0),
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

    private DbT3025KyufujissekiKyotakuService(int maxLength, int scale) {
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
