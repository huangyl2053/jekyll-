package jp.co.ndensan.reams.db.dbc.entity.db.basic.shokanshinsei;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払支給申請テーブルの項目定義クラスです。
 */
public enum DbT3034ShokanShinsei implements IColumnDefinition {
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
     * 申請理由
     */
    shinseiRiyu(100, 0),
    /**
     * 申請者区分
     */
    shinseishaKubun(1, 0),
    /**
     * 申請者氏名
     */
    shinseishaNameKanji(40, 0),
    /**
     * 申請者氏名カナ
     */
    shinseishaNameKana(60, 0),
    /**
     * 申請者住所
     */
    shinseishaAddress(80, 0),
    /**
     * 申請者電話番号
     */
    shinseishaTelNo(15, 0),
    /**
     * 申請事業者コード
     */
    shinseiJigyoshaCode(10, 0),
    /**
     * 支払金額合計
     */
    shiharaiKingakuTotal(9, 0),
    /**
     * 保険給付額
     */
    hokenKyufuritsu(10, 0),
    /**
     * 利用者負担額
     */
    riyoshaFutangaku(10, 0),
    /**
     * 支給申請審査区分
     * <br/>1:未審査、2:審査済み
     */
    shikyuShinseiShinsaKubun(1, 0),
    /**
     * 審査方法区分
     * <br/>1:審査依頼,2:審査済み
     */
    shinsaHohoKubun(1, 0),
    /**
     * 送付年月
     */
    sofuYM(2147483647, 0),
    /**
     * 支払方法区分コード
     */
    shiharaiHohoKubunCode(1, 0),
    /**
     * 支払場所
     */
    shiharaiBasho(64, 0),
    /**
     * 支払期間開始年月日
     */
    shiharaiKaishiYMD(2147483647, 0),
    /**
     * 支払期間終了年月日
     */
    shiharaiShuryoYMD(2147483647, 0),
    /**
     * 閉庁内容
     */
    heichoNaiyo(50, 0),
    /**
     * 支払窓口開始時間
     */
    shiharaiKaishiTime(4, 0),
    /**
     * 支払窓口終了期間
     */
    shiharaiShuryoTime(4, 0),
    /**
     * 口座ID
     */
    kozaID(19, 0),
    /**
     * 受領委任契約番号
     */
    juryoininKeiyakuNo(8, 0);

    private final int maxLength;
    private final int scale;

    private DbT3034ShokanShinsei(int maxLength, int scale) {
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
