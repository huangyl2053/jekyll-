package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 償還払支給住宅改修事前申請テーブルの項目定義クラスです。
 */
public enum DbT3035ShokanJutakuKaishuJizenShinsei implements IColumnDefinition {
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
     * 申請者郵便番号
     */
    shinseishaYubinNo(2147483647, 0),
    /**
     * 申請者住所
     */
    shinseishaJusho(80, 0),
    /**
     * 申請者電話番号
     */
    shinseishaTelNo(2147483647, 0),
    /**
     * 申請事業者番号
     */
    shinseiJigyoshaNo(2147483647, 0),
    /**
     * 理由書作成日
     */
    riyushoSakuseiYMD(2147483647, 0),
    /**
     * 理由書作成者
     */
    riyushoSakuseishaName(60, 0),
    /**
     * 理由書作成者カナ
     */
    riyushoSakuseishaKanaName(40, 0),
    /**
     * 理由書作成事業者番号
     */
    riyushoSakuseiJigyoshaNo(2147483647, 0),
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
     * 支払窓口開始時間
     */
    shiharaiKaishiTime(4, 0),
    /**
     * 支払窓口終了時間
     */
    shiharaiShuryoTime(4, 0),
    /**
     * 口座ID
     */
    kozaID(19, 0),
    /**
     * 受領委任契約番号
     */
    juryoininKeiyakuNo(8, 0),
    /**
     * サービス種類コード
     */
    serviceShuruiCode(2147483647, 0),
    /**
     * 住宅所有者
     */
    jutakuShoyusha(60, 0),
    /**
     * 被保険者との関係
     */
    hihokenshaKankei(30, 0),
    /**
     * 要介護状態３段階変更
     * <br/>True：変更する、False：変更無し
     */
    yokaigo3DankaiHenko(1, 0),
    /**
     * 住宅住所変更
     * <br/>True：変更する、False：変更無し
     */
    jutakuJushoHenko(1, 0),
    /**
     * 判定決定年月日
     */
    hanteiKetteiYMD(2147483647, 0),
    /**
     * 判定区分
     */
    hanteiKubun(1, 0),
    /**
     * 承認条件
     */
    shoninJoken(45, 0),
    /**
     * 不承認理由
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
     * 事前申請決定通知発行日
     */
    ketteitsuchishoHakkoYMD(2147483647, 0),
    /**
     * 住宅改修申請区分
     * <br/>(DBC)Enum住宅改修申請区分
     */
    kaishushinseiKubun(1, 0),
    /**
     * 住宅改修申請取消事由コード
     * <br/>(DBC)コードマスタ：0028
     */
    kaishuShinseiTorikeshijiyuCode(2, 0),
    /**
     * 保険給付率
     */
    hokenKyufuritsu(2147483647, 0),
    /**
     * 施工完了予定年月日
     */
    sekoKanryoYoteiYMD(2147483647, 0);

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
