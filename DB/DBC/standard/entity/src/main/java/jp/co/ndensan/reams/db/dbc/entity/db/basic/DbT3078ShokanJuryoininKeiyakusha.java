package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還受領委任契約者テーブルの項目定義クラスです。
 */
public enum DbT3078ShokanJuryoininKeiyakusha implements IColumnDefinition {
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
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 受付年月日
     */
    uketsukeYMD(2147483647, 0),
    /**
     * 契約事業者番号
     * <br/>償還受領委任契約事業者の事業者契約番号
     */
    keiyakuJigyoshaNo(10, 0),
    /**
     * 契約サービス種類
     * <br/>01：福祉用具、02：住宅改修、03：予防福祉用具、04：予防住宅改修、05：償還払支給、06：高額給付支給
     */
    keiyakuServiceShurui(2, 0),
    /**
     * 決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 承認結果区分
     * <br/>0:承認しない,1:承認する
     */
    shoninKekkaKubun(1, 0),
    /**
     * 契約番号
     * <br/>開始年月日が属する西暦年度（4桁）＋契約事業者・年度単位に１からの連番（4桁）
     */
    keiyakuNo(8, 0),
    /**
     * 受領委任払適用開始年月日
     */
    juryoininKaishiYMD(2147483647, 0),
    /**
     * 受領委任払適用終了年月日
     */
    juryoininShuryoYMD(2147483647, 0),
    /**
     * 不承認理由
     */
    fuShoninRiyu(80, 0),
    /**
     * 費用額合計
     * <br/>給付額等
     */
    hiyoGakuGokei(9, 0),
    /**
     * 保険対象費用額
     * <br/>給付額等
     */
    hokenTaishoHiyoGaku(9, 0),
    /**
     * 利用者自己負担額
     * <br/>給付額等
     */
    riyoshaJikoFutanGaku(9, 0),
    /**
     * 保険給付費額
     * <br/>給付額等
     */
    hokenKyufuhiGaku(9, 0),
    /**
     * 承認結果通知書作成日
     */
    shoninKekkaTsuchiSakuseiYMD(2147483647, 0),
    /**
     * 承認結果通知書再発行区分
     */
    shoninKekkaTsuchiSaiHakkoKubun(1, 0),
    /**
     * 支給申請書有無区分
     */
    shikyushinseiUmuKubun(1, 0),
    /**
     * 支給申請サービス提供年月
     */
    shikyushinseiServiceYM(2147483647, 0),
    /**
     * 支給申請償還整理番号
     */
    shikyushinseiSeiriNo(10, 0),
    /**
     * 備考
     */
    biko(50, 0);

    private final int maxLength;
    private final int scale;

    private DbT3078ShokanJuryoininKeiyakusha(int maxLength, int scale) {
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
