package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 居宅給付計画自己作成管理テーブルの項目定義クラスです。
 */
public enum DbT3119KyotakuKeikakuJikosakuseiKanri implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.4.2">
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
     * 利用年月
     */
    riyoYM(2147483647, 0),
    /**
     * 居宅サービス区分
     * <br/>1:訪問通所,2:短期入所,3:居宅サービス
     */
    kyotakuServiceKubun(1, 0),
    /**
     * 明細番号
     */
    meisaiNo(5, 0),
    /**
     * サービス提供事業者番号
     */
    serviceTeikyoJigyoshaNo(2147483647, 0),
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
    taniSu(6, 0),
    /**
     * 回数・日数
     */
    kaisu_Nissu(6, 0),
    /**
     * 割引後適用率
     * <br/>居宅サービス区分が「1:訪問通所」又は「3:居宅サービス」の場合に設定　％
     */
    waribikiGoTekiyoRitsu(2147483647, 0),
    /**
     * 割引後適用単位数
     * <br/>居宅サービス区分が「1:訪問通所」又は「3:居宅サービス」の場合に設定
     */
    waribikiGoTekiyoTaniSu(6, 0),
    /**
     * 給付対象日数
     * <br/>居宅サービス区分が「2:短期入所」の場合に設定
     */
    kyufuTaishoNissu(3, 0),
    /**
     * 合計明細フラグ
     */
    goukeiFlag(1, 0),
    /**
     * 種類限度内単位数・日数
     * <br/>合計フラグ＝True の場合に設定
     */
    shuruiGendoNaiTaniSu_Nissu(6, 0),
    /**
     * 種類限度超過単位数・日数
     * <br/>合計フラグ＝True の場合に設定
     */
    shuruiGendoChokaTaniSu_Nissu(6, 0),
    /**
     * 区分限度内単位数・日数
     * <br/>合計フラグ＝True の場合に設定
     */
    kubunGendoNaiTaniSu_Nissu(6, 0),
    /**
     * 区分限度超過単位数・日数
     * <br/>合計フラグ＝True の場合に設定
     */
    kubunGendoChokaTaniSu_Nissu(6, 0),
    /**
     * 単位数単価
     * <br/>小数点第２位まで管理する　合計フラグ＝True の場合に設定
     */
    taniSuTanka(4, 0),
    /**
     * 給付率
     * <br/>％　合計フラグ＝True の場合に設定
     */
    kyufuRitsu(2147483647, 0),
    /**
     * 給付計画単位数
     * <br/>合計フラグ＝True の場合に設定
     */
    kyufuKeikakuTaniSu(8, 0);

    private final int maxLength;
    private final int scale;

    private DbT3119KyotakuKeikakuJikosakuseiKanri(int maxLength, int scale) {
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
