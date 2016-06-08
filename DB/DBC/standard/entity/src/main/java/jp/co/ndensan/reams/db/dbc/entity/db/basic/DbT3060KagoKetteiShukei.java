package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 過誤決定集計テーブルの項目定義クラスです。
 */
public enum DbT3060KagoKetteiShukei implements IColumnDefinition {
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
     * <br/>連合会が取扱った年月
     */
    toriatsukaiYM(2147483647, 0),
    /**
     * 保険者区分
     * <br/>1：保険者
     *
     * <br/>2：公費負担者　     *
     * <br/>3：総合事業費(経過措置)保険者
     *
     * <br/>4：総合事業費保険者
     *
     * <br/>5：総合事業費公費負担者
     */
    hokenshaKubun(1, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 介護給付費件数
     */
    kaigoKyufuhiKensu(10, 0),
    /**
     * 介護給付費単位数
     */
    kaigoKyufuhiTanisu(13, 0),
    /**
     * 介護給付費保険者負担額
     * <br/>公費（保険者区分=2、5）の場合、'公費負担額
     */
    kaigoKyufuhiFutangaku(13, 0),
    /**
     * 高額介護サービス費件数
     */
    kogakuServicehiKensu(10, 0),
    /**
     * 高額介護サービス費単位数
     */
    kogakuServicehiTanisu(13, 0),
    /**
     * 高額介護サービス費保険者負担額
     * <br/>公費（保険者区分=2、5）の場合、'公費負担額
     */
    kogakuServicehiFutangaku(13, 0),
    /**
     * 特定入所者介護サービス費等件数
     */
    tokuteiNyushoshaServicehiKensu(10, 0),
    /**
     * 特定入所者介護サービス費等費用額
     */
    tokuteiNyushoshaServicehiTanisu(13, 0),
    /**
     * 特定入所者介護サービス費等保険者負担額
     * <br/>公費（保険者区分=2、5）の場合、'公費負担額
     */
    tokuteiNyushoshaServicehiFutangaku(13, 0),
    /**
     * 公費負担者番号
     * <br/>保険者区分=1のとき：証記載保険者番号（上６桁）
     *
     * <br/>保険者区分=2のとき：公費負担者番号
     *
     * <br/>保険者区分=3のとき：証記載保険者番号（上６桁）
     *
     * <br/>保険者区分=4のとき：証記載保険者番号（上６桁）
     *
     * <br/>保険者区分=5のとき：公費負担者番号
     */
    kohiFutanshaNo(8, 0),
    /**
     * 作成年月日
     */
    sakuseiYMD(2147483647, 0),
    /**
     * 取込年月
     */
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3060KagoKetteiShukei(int maxLength, int scale) {
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
