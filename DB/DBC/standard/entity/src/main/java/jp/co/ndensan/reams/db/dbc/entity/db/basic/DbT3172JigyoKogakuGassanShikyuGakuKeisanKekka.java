package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 事業高額合算支給額計算結果テーブルの項目定義クラスです。
 */
public enum DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka implements IColumnDefinition {
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
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 対象年度
     */
    taishoNendo(2147483647, 0),
    /**
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 支給申請書整理番号
     * <br/>IF上は「連絡票整理番号」
     */
    shikyuShinseishoSeiriNo(17, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 保険制度コード
     * <br/>1:国保,2:後期,3:介護
     */
    hokenSeidoCode(1, 0),
    /**
     * 自己負担額証明書整理番号
     */
    jikoFutanSeiriNo(20, 0),
    /**
     * 対象計算期間開始年月日
     */
    taishoKeisanKaishiYMD(2147483647, 0),
    /**
     * 対象計算期間終了年月日
     */
    taishoKeisanShuryoYMD(2147483647, 0),
    /**
     * 世帯負担総額
     */
    setaiFutanSogaku(10, 0),
    /**
     * 介護等合算一部負担金等世帯合算額
     */
    setaiGassanGaku(10, 0),
    /**
     * 70歳以上介護等合算一部負担金等世帯合算額
     */
    over70_SetaiGassanGaku(10, 0),
    /**
     * 所得区分
     */
    shotokuKubun(1, 0),
    /**
     * 70歳以上の者に係る所得区分
     */
    over70_ShotokuKubun(1, 0),
    /**
     * 介護等合算算定基準額
     */
    santeiKijunGaku(7, 0),
    /**
     * 70歳以上介護等合算算定基準額
     */
    over70_SanteiKijyunGaku(6, 0),
    /**
     * 世帯支給総額
     */
    setaiShikyuSogaku(10, 0),
    /**
     * うち70歳以上分世帯支給総額
     */
    over70_SetaiShikyuSogaku(10, 0),
    /**
     * 按分後支給額
     */
    honninShikyugaku(10, 0),
    /**
     * うち70歳以上分按分後支給額
     */
    over70_honninShikyugaku(10, 0),
    /**
     * 介護低所得者Ⅰ再計算実施の有無
     */
    teiShotoku_1_SaiKeisanUmu(1, 0),
    /**
     * 備考
     */
    biko(500, 0),
    /**
     * 支給額計算結果連絡先郵便番号
     */
    kekkaRenrakusakiYubinNo(2147483647, 0),
    /**
     * 支給額計算結果連絡先住所
     */
    kekkaRenrakusakiJusho(100, 0),
    /**
     * 支給額計算結果連絡先名称1
     */
    ketteRenrakusakiMeisho1(60, 0),
    /**
     * 支給額計算結果連絡先名称2
     */
    kekkaRenrakusakiMeisho2(60, 0),
    /**
     * 通知年月日
     */
    tsuchiYMD(2147483647, 0),
    /**
     * 連絡票発行者名
     */
    renrakuhyoHakkoshaMei(2147483647, 0),
    /**
     * 連絡票発行者郵便番号
     */
    renrakuhyoHakkoshaYubinNo(2147483647, 0),
    /**
     * 連絡票発行者住所
     */
    renrakuhyoHakkoshaJusho(100, 0),
    /**
     * 問い合わせ先郵便番号
     */
    toiawasesakiYobinNo(2147483647, 0),
    /**
     * 問い合わせ先住所
     */
    toiawasesakiJusho(100, 0),
    /**
     * 問い合わせ先名称1
     */
    toiawasesakiMeisho1(60, 0),
    /**
     * 問い合わせ先名称2
     */
    toiawasesakiMeisho2(60, 0),
    /**
     * 問い合わせ先電話番号
     */
    toiawasesakiTelNo(2147483647, 0),
    /**
     * 70歳以上負担額合計
     * <br/>① 70歳以上負担額合計
     */
    over70_FutangakuGokei(10, 0),
    /**
     * 70歳以上支給額合計
     * <br/>③ ①にかかる支給額合計
     */
    over70_ShikyugakuGokei(10, 0),
    /**
     * 70歳未満負担額合計
     * <br/>④ 70歳未満負担額合計
     */
    under70_FutangakuGokei(10, 0),
    /**
     * 負担額の合計額
     * <br/>⑤ ④＋（①－③）の合計額
     */
    futangakuGokei(10, 0),
    /**
     * 70歳未満支給額合計
     * <br/>⑦ ⑤に係る支給額合計
     */
    under70_ShikyugakuGokei(10, 0),
    /**
     * 支給額合計額
     * <br/>⑧ ③＋⑦の合計額
     */
    shikyugakuGokei(10, 0),
    /**
     * データ区分
     */
    dataKubun(1, 0),
    /**
     * 受取年月
     */
    uketoriYM(2147483647, 0),
    /**
     * 送付年月
     */
    sofuYM(2147483647, 0),
    /**
     * 再送フラグ
     */
    saisoFG(1, 0),
    /**
     * 支給額計算結果連絡票作成年月日
     */
    sikyugakuKeisanKekkaRenrakuhyoSakuseiYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3172JigyoKogakuGassanShikyuGakuKeisanKekka(int maxLength, int scale) {
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
