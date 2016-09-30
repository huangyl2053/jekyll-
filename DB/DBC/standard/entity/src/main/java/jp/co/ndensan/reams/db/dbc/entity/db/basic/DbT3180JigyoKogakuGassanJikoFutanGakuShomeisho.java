package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 事業高額合算自己負担額証明書テーブルの項目定義クラスです。
 *
 * @reamsid_L DBC-9999-012 zhujun
 */
public enum DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho implements IColumnDefinition {
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
     * 対象年度
     */
    taishoNendo(2147483647, 0),
    /**
     * 証記載保険者番号
     * <br/>証記載保険者番号
     */
    shokisaiHokenshaNo(2147483647, 0),
    /**
     * 支給申請書整理番号
     */
    shikyuShinseishoSeiriNo(17, 0),
    /**
     * 転入前保険者番号
     * <br/>転入前の証記載保険者番号
     */
    tennyumaeHokenshaNo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 自己負担額証明書整理番号
     */
    jikoFutanSeiriNo(20, 0),
    /**
     * 転入前保険者名
     */
    tennyumaeHokenshaMei(20, 0),
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
     * 発行年月日
     */
    hakkoDate(2147483647, 0),
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
     * 支給額計算結果連絡先郵便番号
     */
    atesakiYubinNo(2147483647, 0),
    /**
     * 支給額計算結果連絡先住所
     */
    atesakiShimei(100, 0),
    /**
     * 支給額計算結果連絡先名称1
     */
    atesakiJusho(20, 0),
    /**
     * 支給額計算結果連絡先名称2
     */
    madoguchi_TaishoshaHanteiCode(20, 0),
    /**
     * 備考
     */
    biko(400, 0),
    /**
     * 受付年月日
     */
    uketsukeDate(2147483647, 0),
    /**
     * 支給額計算年月日
     */
    shikyugakuKeisanDate(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3180JigyoKogakuGassanJikoFutanGakuShomeisho(int maxLength, int scale) {
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
