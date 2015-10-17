package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 給付実績高額介護サービス費テーブルの項目定義クラスです。
 */
public enum DbT3028KyufujissekiKogakuKaigoServicehi implements IColumnDefinition {
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
     * 通し番号
     */
    toshiNo(10, 0),
    /**
     * 給付実績情報作成区分コード
     */
    kyufuSakuseiKubunCode(1, 0),
    /**
     * 給付実績区分コード
     */
    kyufuJissekiKubunCode(1, 0),
    /**
     * 受付年月日
     */
    uketsukeYMD(2147483647, 0),
    /**
     * 決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 公費１負担番号
     */
    kohi1FutanNo(8, 0),
    /**
     * 公費２負担番号
     */
    kohi2FutanNo(8, 0),
    /**
     * 公費３負担番号
     */
    kohi3FutanNo(8, 0),
    /**
     * 利用者負担額
     */
    riyoshaFutangaku(10, 0),
    /**
     * 公費１負担額
     */
    kohi1Futangaku(10, 0),
    /**
     * 公費２負担額
     */
    kohi2Futangaku(10, 0),
    /**
     * 公費３負担額
     */
    kohi3Futangaku(10, 0),
    /**
     * 支給額
     */
    shikyugaku(10, 0),
    /**
     * 公費１支給額
     */
    kohi1Shikyugaku(10, 0),
    /**
     * 公費２支給額
     */
    kohi2Shikyugaku(10, 0),
    /**
     * 公費３支給額
     */
    kohi3Shikyugaku(10, 0),
    /**
     * 審査年月
     */
    shinsaYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNo(10, 0),
    /**
     * 送付年月
     */
    sofuYM(2147483647, 0),
    /**
     * 取込年月
     */
    torikomiYM(2147483647, 0),
    /**
     * 作成区分
     * <br/>0：国保連受取　1：独自作成
     */
    sakuseiKubun(1, 0),
    /**
     * 管理番号
     * <br/>高額申請管理ﾏｽﾀの"管理番号"とﾘﾝｸ
     * <br/>高額支給申請書更新時のみ設定される
     */
    kanriNo(4, 0),
    /**
     * 保険者保有給付実績情報削除済フラグ
     */
    hokenshaHoyuKyufujissekiJohoSakujoZumiFlag(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3028KyufujissekiKogakuKaigoServicehi(int maxLength, int scale) {
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
