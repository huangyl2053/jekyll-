package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 再審査決定集計テーブルの項目定義クラスです。
 */
public enum DbT3063SaishinsaKetteiShukei implements IColumnDefinition {
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
     * 取扱年月
     * <br/>連合会が取扱った年月(ヘッダ情報)
     */
    toriatsukaiYM(2147483647, 0),
    /**
     * 保険者区分
     * <br/>1：保険者　2：公費負担者
     *
     * <br/>3：総合事業費保険者
     *
     * <br/>4：総合事業費公費負担者
     */
    hokenshaKubun(1, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 介護給付費・請求・件数
     */
    kaigoKyufuhiSeikyuKensu(10, 0),
    /**
     * 介護給付費・請求・単位数
     */
    kaigoKyufuhiSeikyuTanisu(12, 0),
    /**
     * 介護給付費・請求・保険者負担額
     * <br/>公費（保険者区分=2,4）の場合、'公費負担額
     */
    kaigoKyufuhiSeikyuFutangaku(12, 0),
    /**
     * 介護給付費・決定・件数
     */
    kaigoKyufuhiKetteiKensu(10, 0),
    /**
     * 介護給付費・決定・単位数
     */
    kaigoKyufuhiKetteiTanisu(12, 0),
    /**
     * 介護給付費・決定・保険者負担額
     * <br/>公費（保険者区分=2,4）の場合、'公費負担額
     */
    kaigoKyufuhiKetteiFutangaku(12, 0),
    /**
     * 介護給付費・調整・件数
     */
    kaigoKyufuhiChoseiKensu(10, 0),
    /**
     * 介護給付費・調整・単位数
     */
    kaigoKyufuhiChoseiTanisu(13, 0),
    /**
     * 介護給付費・調整・保険者負担額
     * <br/>未使用、公費（保険者区分=2,4）の場合、'公費負担額
     */
    kaigoKyufuhiChoseiFutangaku(13, 0),
    /**
     * 高額介護サービス費・請求・件数
     * <br/>未使用
     */
    kogakuKaigoServicehiSeikyuKensu(10, 0),
    /**
     * 高額介護サービス費・請求・単位数
     * <br/>未使用
     */
    kogakuKaigoServicehiSeikyuTanisu(12, 0),
    /**
     * 高額介護サービス費・請求・保険者負担額
     * <br/>未使用、公費（保険者区分=2,4）の場合、'公費負担額
     */
    kogakuKaigoServicehiSeikyuFutangaku(12, 0),
    /**
     * 高額介護サービス費・決定・件数
     * <br/>未使用
     */
    kogakuKaigoServicehiKetteiKensu(10, 0),
    /**
     * 高額介護サービス費・決定・単位数
     * <br/>未使用
     */
    kogakuKaigoServicehiKetteiTanisu(12, 0),
    /**
     * 高額介護サービス費・決定・保険者負担額
     * <br/>未使用、公費（保険者区分=2,4）の場合、'公費負担額
     */
    kogakuKaigoServicehiKetteiFutangaku(12, 0),
    /**
     * 高額介護サービス費・調整・件数
     * <br/>未使用
     */
    kogakuKaigoServicehiChoseiKensu(10, 0),
    /**
     * 高額介護サービス費・調整・単位数
     * <br/>未使用
     */
    kogakuKaigoServicehiChoseiTanisu(13, 0),
    /**
     * 高額介護サービス費・調整・保険者負担額
     * <br/>未使用、公費（保険者区分=2,4）の場合、'公費負担額
     */
    kogakuKaigoServicehiChoseiFutangaku(13, 0),
    /**
     * 公費負担者番号
     * <br/>保険者区分=1のとき：証記載保険者番号（上６桁）
     *
     * <br/>保険者区分=2のとき：公費負担者番号
     *
     * <br/>保険者区分=3のとき：証記載保険者番号（上６桁）
     *
     * <br/>保険者区分=4のとき：公費負担者番号
     */
    kohiFutanshaNo(8, 0),
    /**
     * 作成年月日
     * <br/>ヘッダ情報
     */
    sakuseiYMD(2147483647, 0),
    /**
     * 審査委員会名
     * <br/>ヘッダ情報
     */
    sinsaiinkaiName(15, 0),
    /**
     * 取込年月
     */
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3063SaishinsaKetteiShukei(int maxLength, int scale) {
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
