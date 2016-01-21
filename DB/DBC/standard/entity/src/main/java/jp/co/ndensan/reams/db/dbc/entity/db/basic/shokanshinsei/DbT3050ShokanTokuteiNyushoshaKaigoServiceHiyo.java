package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払請求特定入所者介護サービス費用テーブルの項目定義クラスです。
 */
public enum DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo implements IColumnDefinition {
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
     * 明細番号
     * <br/>複数レコード対応のため
     */
    meisaiNo(4, 0),
    /**
     * 連番
     */
    renban(2, 0),
    /**
     * サービス種類コード
     */
    serviceShuruiCode(2147483647, 0),
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
     * 費用額
     */
    hiyogaku(10, 0),
    /**
     * 保険分請求額
     */
    hokenbunSeikyugaku(10, 0),
    /**
     * 利用者負担額
     */
    riyoshaFutangaku(10, 0),
    /**
     * 費用額合計
     * <br/>順次番号が最大の情報にのみ設定
     */
    hiyogakuTotal(10, 0),
    /**
     * 保険分請求額合計
     * <br/>順次番号が最大の情報にのみ設定
     */
    hokenbunSeikyugakuTotal(10, 0),
    /**
     * 利用者負担額合計
     * <br/>順次番号が最大の情報にのみ設定
     */
    riyoshaFutangakuTotal(10, 0),
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
    zougenten(10, 0),
    /**
     * 差額金額
     */
    sagakuKingaku(10, 0);

    private final int maxLength;
    private final int scale;

    private DbT3050ShokanTokuteiNyushoshaKaigoServiceHiyo(int maxLength, int scale) {
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
