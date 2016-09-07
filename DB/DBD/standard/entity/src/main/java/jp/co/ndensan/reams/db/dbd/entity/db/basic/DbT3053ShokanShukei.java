package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払請求集計テーブルの項目定義クラスです。
 */
public enum DbT3053ShokanShukei implements IColumnDefinition {
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
    gendogakuKanriTaishogaiTanisu(10, 0),
    /**
     * 短期入所計画日数
     */
    tankiNyushoPlanNissu(5, 0),
    /**
     * 短期入所実日数
     */
    tankiNyushoJitsunissu(5, 0),
    /**
     * 単位数合計
     */
    tanisuTotal(10, 0),
    /**
     * 単位数単価
     */
    tanisuTanka(6, 0),
    /**
     * 請求額
     */
    seikyugaku(9, 0),
    /**
     * 利用者負担額
     */
    riyoshaFutangaku(10, 0),
    /**
     * 出来高医療費単位数合計
     */
    dekidakaIryohiTanisuTotal(10, 0),
    /**
     * 出来高医療費請求額
     */
    dekidakaIryohiSeikyugaku(9, 0),
    /**
     * 出来高医療費利用者負担額
     */
    dekidakaIryohiRiyoshaFutangaku(9, 0),
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
     * 支払金額
     */
    shikyuKingaku(10, 0),
    /**
     * 増減点
     */
    zougenten(10, 0),
    /**
     * 請求額差額金額
     */
    seikyugakuSagakuKingaku(10, 0),
    /**
     * 出来高請求額差額金額
     */
    dekidakaSeikyugakuSagaku(10, 0),
    /**
     * 増減理由等
     */
    zougenRiyu(20, 0),
    /**
     * 不支給理由等
     */
    hushikyuRiyu(38, 0),
    /**
     * 購入・改修履歴等
     */
    kounyuKaishuRireki(38, 0);

    private final int maxLength;
    private final int scale;

    private DbT3053ShokanShukei(int maxLength, int scale) {
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
