package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 市町村単独助成金給付決定テーブルの項目定義クラスです。
 */
public enum DbT3097TandokuJoseikinKyufuKettei implements IColumnDefinition {
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
    hihokenshaNo(2147483647, 0),
    /**
     * 受付年月日
     */
    uketsukeYMD(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 決定年月日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 適用開始年月日
     */
    tekiyoKaishiYMD(2147483647, 0),
    /**
     * 有効期限
     */
    yukoKigenYMD(2147483647, 0),
    /**
     * 利用者負担・決定区分
     */
    riyoshaFutan_KetteiKubun(1, 0),
    /**
     * 利用者負担・不承認理由
     */
    riyoshaFutan_FuShoninRiyu(200, 0),
    /**
     * 公費受給者番号
     */
    kohi_JukyushaNo(8, 0),
    /**
     * 公費負担者番号
     */
    kohi_FutanshaNo(8, 0),
    /**
     * 給付率
     */
    kyufuRitsu(2147483647, 0),
    /**
     * 受給者番号
     */
    jukyushaNo(8, 0),
    /**
     * 経過措置
     */
    keikaSochiKubun(1, 0),
    /**
     * 国軽減
     */
    kuniKeigenKubun(1, 0),
    /**
     * 社会福祉法人軽減
     */
    shakaiFukushiHojinKeigenKubun(1, 0),
    /**
     * 特別地域加算
     */
    tokubetsuChiikiKasanKubun(1, 0),
    /**
     * 保留区分・滞納
     */
    taino_HoryuKubun(1, 0),
    /**
     * 保留区分・認定申請中
     */
    ninteiShinseichu_HoryuKubun(1, 0),
    /**
     * 保留区分・認定有効期限切れ
     */
    ninteiKigenGire_HoryuKubun(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3097TandokuJoseikinKyufuKettei(int maxLength, int scale) {
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
