package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 給付実績特定診療費・特別療養費テーブルの項目定義クラスです。
 * <br/> サービス提供年月が平成１５年４月以後の場合
 */
public enum DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo implements IColumnDefinition {
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
     * 交換情報識別番号
     */
    kokanJohoShikibetsuNo(2147483647, 0),
    /**
     * 入力識別番号
     */
    inputShikibetsuNo(2147483647, 0),
    /**
     * レコード種別コード
     */
    recodeShubetsuCode(2, 0),
    /**
     * 証記載保険者番号
     */
    shokisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * 事業所番号
     */
    jigyoshoNo(2147483647, 0),
    /**
     * 通し番号
     */
    toshiNo(10, 0),
    /**
     * 特定診療情報レコード順次番号
     */
    recodeJunjiNo(2, 0),
    /**
     * 傷病名
     */
    shobyoName(50, 0),
    /**
     * 識別番号
     * <br/>介護給付費等の記載要領で示される特定診療費の識別
     * <br/>番号のうち、＠を除く２桁の数字
     */
    shikibetsuNo(2, 0),
    /**
     * 単位数
     */
    tanisu(5, 0),
    /**
     * 保険・回数
     */
    hokenKaisu(5, 0),
    /**
     * 保険・ｻｰﾋﾞｽ単位数
     */
    hokenServiceTanisu(10, 0),
    /**
     * 保険・合計単位数
     */
    hokenTotalTanisu(10, 0),
    /**
     * 公費１・回数
     */
    kohi1Kaisu(5, 0),
    /**
     * 公費１・ｻｰﾋﾞｽ単位数
     */
    kohi1ServiceTanisu(10, 0),
    /**
     * 公費１・合計単位数
     */
    kohi1TotalTanisu(10, 0),
    /**
     * 公費２・回数
     */
    kohi2Kaisu(5, 0),
    /**
     * 公費２・ｻｰﾋﾞｽ単位数
     */
    kohi2ServiceTanisu(10, 0),
    /**
     * 公費２・合計単位数
     */
    kohi2TotalTanisu(10, 0),
    /**
     * 公費３・回数
     */
    kohi3Kaisu(5, 0),
    /**
     * 公費３・ｻｰﾋﾞｽ単位数
     */
    kohi3ServiceTanisu(10, 0),
    /**
     * 公費３・合計単位数
     */
    kohi3TotalTanisu(10, 0),
    /**
     * 摘要
     */
    tekiyo(50, 0),
    /**
     * 後・単位数
     */
    atoTanisu(5, 0),
    /**
     * 後・保険・回数
     */
    atoHokenKaisu(5, 0),
    /**
     * 後・保険・ｻｰﾋﾞｽ単位数
     */
    atoHokenServiceTanisu(10, 0),
    /**
     * 後・保険・合計単位数
     */
    atoHokenTotalTanisu(10, 0),
    /**
     * 後・公費１・回数
     */
    atoKohi1Kaisu(5, 0),
    /**
     * 後・公費１・ｻｰﾋﾞｽ単位数
     */
    atoKohi1ServiceTanisu(10, 0),
    /**
     * 後・公費１・合計単位数
     */
    atoKohi1TotalTanisu(10, 0),
    /**
     * 後・公費２・回数
     */
    atoKohi2Kaisu(5, 0),
    /**
     * 後・公費２・ｻｰﾋﾞｽ単位数
     */
    atoKohi2ServiceTanisu(10, 0),
    /**
     * 後・公費２・合計単位数
     */
    atoKohi2TotalTanisu(10, 0),
    /**
     * 後・公費３・回数
     */
    atoKohi3Kaisu(5, 0),
    /**
     * 後・公費３・ｻｰﾋﾞｽ単位数
     */
    atoKohi3ServiceTanisu(10, 0),
    /**
     * 後・公費３・合計単位数
     */
    atoKohi3TotalTanisu(10, 0),
    /**
     * 再審査回数
     */
    saishinsaKaisu(5, 0),
    /**
     * 過誤回数
     */
    kagoKaisu(5, 0),
    /**
     * 審査年月
     */
    shinsaYM(2147483647, 0),
    /**
     * 整理番号
     */
    seiriNo(10, 0),
    /**
     * 取込年月
     */
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3021KyufujissekiTokuteiSinryoTokubetsuRyoyo(int maxLength, int scale) {
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
