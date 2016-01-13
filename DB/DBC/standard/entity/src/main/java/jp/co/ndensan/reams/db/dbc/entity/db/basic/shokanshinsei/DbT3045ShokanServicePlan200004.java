package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 償還払請求サービス計画200004テーブルの項目定義クラスです。
 */
@OnNextSchema("rgdb")
public enum DbT3045ShokanServicePlan200004 implements IColumnDefinition {
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
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNp(10, 0),
    /**
     * 事業者番号
     */
    jigyoshaNo(2147483647, 0),
    /**
     * 様式番号
     */
    yoshikiNo(4, 0),
    /**
     * 明細番号
     */
    meisaiNo(4, 0),
    /**
     * 連番
     */
    renban(2, 0),
    /**
     * 指定／基準該当事業者区分コード
     */
    shiteiKijunGaitoJigyoshaKubunCode(1, 0),
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
    tanisu(10, 0),
    /**
     * 単位数単価
     */
    tanisuTanka(6, 0),
    /**
     * 請求金額
     */
    seikyuKingaku(10, 0),
    /**
     * 審査方法区分コード
     */
    shinsaHohoKubunCode(1, 0),
    /**
     * 審査年月
     */
    shinsaYM(2147483647, 0),
    /**
     * 支給区分コード
     */
    shikyuKubunCode(1, 0),
    /**
     * 点数／金額
     */
    tensuKingaku(10, 0),
    /**
     * 支給金額
     */
    shikyuKingaku(10, 0),
    /**
     * 増減点
     */
    zougenTen(10, 0),
    /**
     * 差額金額
     */
    sagakuKingaku(10, 0),
    /**
     * 増減理由等
     */
    zougenRiyu(40, 0),
    /**
     * 不支給理由等
     */
    fushikyuRiyu(76, 0),
    /**
     * 購入・改修履歴等
     */
    kounyuKaishuRireki(76, 0);

    private final int maxLength;
    private final int scale;

    private DbT3045ShokanServicePlan200004(int maxLength, int scale) {
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
