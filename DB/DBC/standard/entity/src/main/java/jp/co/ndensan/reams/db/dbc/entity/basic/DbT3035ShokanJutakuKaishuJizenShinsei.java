package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払支給住宅改修事前申請テーブルの項目定義クラスです。
 */
public enum DbT3035ShokanJutakuKaishuJizenShinsei implements IColumnDefinition {
// <editor-fold defaultstate="collapsed" desc="Created By POJO Tool ver 1.3.9">
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
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 受付年月日
     */
    uketsukeYMD(2147483647, 0),
    /**
     * 申請年月日
     * <br/>1:本人,2:代理人,3:受領委任事業者
     */
    shinseiYMD(2147483647, 0),
    /**
     * 事業者番号
     */
    jigyoshaNo(2147483647, 0),
    /**
     * 事業者名称
     */
    jigyoshaNameKanji(40, 0),
    /**
     * 事業者名称カナ
     */
    jigyoshaNameKana(40, 0),
    /**
     * 事業者郵便番号
     */
    jigyoshaYubunNo(2147483647, 0),
    /**
     * 事業者住所
     */
    jigyoshaAddress(60, 0),
    /**
     * 事業者電話番号
     */
    jigyoshaTelNo(14, 0),
    /**
     * 事業者ＦＡＸ番号
     */
    jigyoshaFaxNo(14, 0),
    /**
     * 理由書作成者
     */
    riyushoSakuseishaKanji(60, 0),
    /**
     * 理由書作成者カナ
     */
    riyushoSakuseishaKana(40, 0),
    /**
     * サービス種類コード
     */
    serviceShuruiCode(2147483647, 0),
    /**
     * 契約決定年月日
     */
    keiyakuKetteiYMD(2147483647, 0),
    /**
     * 承認区分
     */
    shoninKubun(1, 0),
    /**
     * 不承認の理由
     */
    fushoninRiyu(45, 0),
    /**
     * 給付額等・費用額合計
     */
    kyufugakuHiyogakuTotal(10, 0),
    /**
     * 給付額等・保険対象費用額
     */
    kyufugakuHokenTaishoHiyogaku(10, 0),
    /**
     * 給付額等・利用者自己負担額
     */
    kyufugakuRiyoshaJikofutangaku(10, 0),
    /**
     * 給付額等・保険給付費額
     */
    kyufugakuHokenkyufuhigaku(10, 0),
    /**
     * 施工完了予定年月日
     */
    sekoKanryoYoteiYMD(2147483647, 0),
    /**
     * 申請取消事由コード
     */
    shinseiTorikeshiJiyuCode(2, 0),
    /**
     * 備考
     */
    biko(50, 0);

    private final int maxLength;
    private final int scale;

    private DbT3035ShokanJutakuKaishuJizenShinsei(int maxLength, int scale) {
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
