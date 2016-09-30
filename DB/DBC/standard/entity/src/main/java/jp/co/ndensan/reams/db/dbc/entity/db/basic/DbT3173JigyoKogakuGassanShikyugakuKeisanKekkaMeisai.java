package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 事業高額合算支給額計算結果明細テーブルの項目定義クラスです。
 *
 * @reamsid_L DBC-9999-012 zhujun
 */
public enum DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisai implements IColumnDefinition {
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
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 支給申請書整理番号
     * <br/>IF上は「連絡票整理番号」
     */
    shikyuShinseishoSeiriNo(17, 0),
    /**
     * 明細番号
     */
    meisanNo(2, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 保険制度コード
     */
    hokenSeidoCode(1, 0),
    /**
     * 内訳保険者番号
     */
    uchiwakeHokenshaNo(8, 0),
    /**
     * 国保被保険者証記号
     */
    kokuho_HihokenshaShoKigo(20, 0),
    /**
     * 被保険者（証）番号
     */
    hiHokenshaShoNo(20, 0),
    /**
     * 内訳保険者名
     */
    uchiwakeHokenshaMei(20, 0),
    /**
     * 自己負担額証明書整理番号
     */
    jikoFutanSeiriNo(20, 0),
    /**
     * 対象者氏名（漢字）
     */
    taishoshaShimei(20, 0),
    /**
     * 70歳以上負担額
     * <br/>① 70歳以上負担額
     */
    over70_Futangaku(10, 0),
    /**
     * 70歳以上按分率
     * <br/>② 70歳以上按分率
     */
    over70_AmbunRitsu(17, 0),
    /**
     * 70歳以上支給額
     * <br/>③ ①にかかる支給額
     */
    over70_Shikyugaku(10, 0),
    /**
     * 70歳未満負担額
     * <br/>④ 70歳未満負担額
     */
    under70_Futangaku(10, 0),
    /**
     * 負担額
     * <br/>⑤ ④＋（①－③）
     */
    futangaku(10, 0),
    /**
     * 按分率
     * <br/>⑥ 按分率
     */
    ambunRitsu(17, 0),
    /**
     * 70歳未満支給額
     * <br/>⑦ ⑤に係る支給額
     */
    under70_Shikyugaku(10, 0),
    /**
     * 支給額
     * <br/>⑧ ③＋⑦
     */
    shikyugaku(10, 0),
    /**
     * 備考欄記載70歳以上負担額
     * <br/>（平成20年4月～7月分）
     */
    over70_Biko(10, 0),
    /**
     * 備考欄記載70歳未満負担額
     * <br/>（平成20年4月～7月分）
     */
    under70_Biko(10, 0),
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
    sofuYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3173JigyoKogakuGassanShikyugakuKeisanKekkaMeisai(int maxLength, int scale) {
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
