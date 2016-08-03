package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 事業高額合算自己負担額テーブルの項目定義クラスです。
 */
public enum DbT3170JigyoKogakuGassanJikoFutanGaku implements IColumnDefinition {
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
     * 保険者番号
     * <br/>証記載保険者番号
     */
    hokenshaNo(2147483647, 0),
    /**
     * 支給申請書整理番号
     */
    shikyuShinseishoSeiriNo(17, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 保険制度コード
     */
    hokenSeidoCode(1, 0),
    /**
     * 保険者名
     */
    hokenshaMei(20, 0),
    /**
     * 国保被保険者証記号
     */
    kokuho_HihokenshaShoKigo(20, 0),
    /**
     * 被保険者氏名カナ
     */
    hihokenshaShimeiKana(2147483647, 0),
    /**
     * 被保険者氏名
     */
    hihokenshaShimei(2147483647, 0),
    /**
     * 生年月日
     */
    umareYMD(2147483647, 0),
    /**
     * 性別
     */
    seibetsuCode(2147483647, 0),
    /**
     * 所得区分
     */
    shotokuKubun(1, 0),
    /**
     * 70歳以上の者に係る所得区分
     */
    over70_ShotokuKubun(1, 0),
    /**
     * 自己負担額証明書整理番号
     */
    jikoFutanSeiriNo(20, 0),
    /**
     * 後期保険者番号
     */
    koki_HokenshaNo(8, 0),
    /**
     * 後期被保険者番号
     */
    koki_HihokenshaNo(8, 0),
    /**
     * 国保保険者番号
     */
    kokuho_HokenshaNo(8, 0),
    /**
     * 国保被保険者証番号
     */
    kokuho_HihokenshaShoNo(20, 0),
    /**
     * 国保個人番号
     */
    kokuho_KojinNo(10, 0),
    /**
     * 異動区分
     */
    idoKubun(1, 0),
    /**
     * 補正済自己負担額送付区分
     */
    hoseiZumiSofuKubun(1, 0),
    /**
     * 対象計算期間開始年月日
     */
    taishoKeisanKaishiYMD(2147483647, 0),
    /**
     * 対象計算期間終了年月日
     */
    taishoKeisanShuryoYMD(2147483647, 0),
    /**
     * 被保険者期間開始年月日
     */
    hihokenshaKaishiYMD(2147483647, 0),
    /**
     * 被保険者期間終了年月日
     */
    hihokenshaShuryoYMD(2147483647, 0),
    /**
     * 申請年月日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 合計・自己負担額
     */
    gokei_JikoFutanGaku(10, 0),
    /**
     * 合計・70-74自己負担額（内訳）
     */
    gokei_70_74JikoFutanGaku(10, 0),
    /**
     * 合計・70未満高額支給額
     */
    gokei_Under70KogakuShikyuGaku(10, 0),
    /**
     * 合計・70-74高額支給額
     */
    gokei_70_74KogakuShikyuGaku(10, 0),
    /**
     * 補正済・合計・自己負担額
     */
    sumi_Gokei_JikoFutanGaku(10, 0),
    /**
     * 補正済・合計・70-74自己負担額（内訳）
     */
    sumi_Gokei_70_74JikoFutanGaku(10, 0),
    /**
     * 補正済・合計・70未満高額支給額
     */
    sumi_Gokei_Under70KogakuShikyuGaku(10, 0),
    /**
     * 補正済・合計・70-74高額支給額
     */
    sumi_Gokei_70_74KogakuShikyuGaku(10, 0),
    /**
     * 宛先氏名
     */
    atesakiShimei(2147483647, 0),
    /**
     * 宛先郵便番号
     */
    atesakiYubinNo(2147483647, 0),
    /**
     * 宛先住所
     */
    atesakiJusho(100, 0),
    /**
     * 窓口払対象者判定コード
     */
    madoguchi_TaishoshaHanteiCode(1, 0),
    /**
     * 支払場所
     */
    shiharaiBasho(64, 0),
    /**
     * 支払期間開始年月日
     */
    shikaraiKaishiYMD(2147483647, 0),
    /**
     * 支払期間終了年月日
     */
    shiharaiShuryoYMD(2147483647, 0),
    /**
     * 閉庁内容
     */
    heichoNaiyo(50, 0),
    /**
     * 支払期間開始時間
     */
    shiharaiKaishiTime(4, 0),
    /**
     * 支払期間終了時間
     */
    shiharaiShuryoTime(4, 0),
    /**
     * 備考
     */
    biko(200, 0),
    /**
     * データ作成区分
     */
    dataSakuseiKubun(1, 0),
    /**
     * 自己負担額確認情報受取年月
     */
    kakunin_UketoriYM(2147483647, 0),
    /**
     * 補正済自己負担額情報送付年月
     */
    hoseiZumi_SofuYM(2147483647, 0),
    /**
     * 自己負担額証明書情報受取年月
     */
    shomeisho_UketoriYM(2147483647, 0),
    /**
     * 再送フラグ
     */
    saisoFlag(1, 0),
    /**
     * 送付対象外フラグ
     */
    sofuTaishoGaiFlag(1, 0),
    /**
     * 自己負担額計算年月日
     */
    jikoFutanKeisanYMD(2147483647, 0),
    /**
     * 自己負担額証明書作成年月日
     */
    shomeiShoSakuseiYMD(2147483647, 0),
    /**
     * 後期・国保処理区分
     */
    koki_KokuhoShoriKubun(1, 0),
    /**
     * 自己負担額証明書リアル発行フラグ
     */
    jikoFutangakuShomeishoRealHakkoFlag(1, 0),
    /**
     * バッチ補正実施年月日
     */
    batchHoseiJissiYMD(2147483647, 0),
    /**
     * リアル補正実施年月日
     */
    realHoseiJissiYMD(2147483647, 0),
    /**
     * 証明書用データ区分
     */
    shoumeishoyouDataKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3170JigyoKogakuGassanJikoFutanGaku(int maxLength, int scale) {
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
