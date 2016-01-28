package jp.co.ndensan.reams.db.dbc.entity.db.basic.kyufujisseki;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 給付実績特定診療費テーブルの項目定義クラスです。
 * <br/> サービス提供年月が平成１５年３月以前の場合
 */
public enum DbT3020KyufujissekiTokuteiSinryohi implements IColumnDefinition {
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
    shobyoName(20, 0),
    /**
     * 保険・指導管理料等
     */
    hokenShidoKanriryo(10, 0),
    /**
     * 保険・単純エックス線
     */
    hokenTanjunXsen(10, 0),
    /**
     * 保険・リハビリテーション
     */
    hokenRehabilitation(10, 0),
    /**
     * 保険・精神科専門療法
     */
    hokenSeishinkaSemmonRyoho(10, 0),
    /**
     * 保険・合計単位数
     */
    hokenTotalTanisu(10, 0),
    /**
     * 公費１・指導管理料等
     */
    kohi1ShidoKanriryo(10, 0),
    /**
     * 公費１・単純エックス線
     */
    kohi1TanjunXsen(10, 0),
    /**
     * 公費１・リハビリテーション
     */
    kohi1Rehabilitation(10, 0),
    /**
     * 公費１・精神科専門療法
     */
    kohi1SeishinkaSemmonRyoho(10, 0),
    /**
     * 公費１・合計単位数
     */
    kohi1TotalTanisu(10, 0),
    /**
     * 公費２・指導管理料等
     */
    kohi2ShidoKanriryo(10, 0),
    /**
     * 公費２・単純エックス線
     */
    kohi2TanjunXsen(10, 0),
    /**
     * 公費２・リハビリテーション
     */
    kohi2Rehabilitation(10, 0),
    /**
     * 公費２・精神科専門療法
     */
    kohi2SeishinkaSemmonRyoho(10, 0),
    /**
     * 公費２・合計単位数
     */
    kohi2TotalTanisu(10, 0),
    /**
     * 公費３・指導管理料等
     */
    kohi3ShidoKanriryo(10, 0),
    /**
     * 公費３・単純エックス線
     */
    kohi3TanjunXsen(10, 0),
    /**
     * 公費３・リハビリテーション
     */
    kohi3Rehabilitation(10, 0),
    /**
     * 公費３・精神科専門療法
     */
    kohi3SeishinkaSemmonRyoho(10, 0),
    /**
     * 公費３・合計単位数
     */
    kohi3TotalTanisu(10, 0),
    /**
     * 摘要１
     */
    tekiyo1(32, 0),
    /**
     * 摘要２
     */
    tekiyo2(32, 0),
    /**
     * 摘要３
     */
    tekiyo3(32, 0),
    /**
     * 摘要４
     */
    tekiyo4(32, 0),
    /**
     * 摘要５
     */
    tekiyo5(32, 0),
    /**
     * 摘要６
     */
    tekiyo6(32, 0),
    /**
     * 摘要７
     */
    tekiyo7(32, 0),
    /**
     * 摘要８
     */
    tekiyo8(32, 0),
    /**
     * 摘要９
     */
    tekiyo9(32, 0),
    /**
     * 摘要１０
     */
    tekiyo10(32, 0),
    /**
     * 摘要１１
     */
    tekiyo11(32, 0),
    /**
     * 摘要１２
     */
    tekiyo12(32, 0),
    /**
     * 摘要１３
     */
    tekiyo13(32, 0),
    /**
     * 摘要１４
     */
    tekiyo14(32, 0),
    /**
     * 摘要１５
     */
    tekiyo15(32, 0),
    /**
     * 摘要１６
     */
    tekiyo16(32, 0),
    /**
     * 摘要１７
     */
    tekiyo17(32, 0),
    /**
     * 摘要１８
     */
    tekiyo18(32, 0),
    /**
     * 摘要１９
     */
    tekiyo19(32, 0),
    /**
     * 摘要２０
     */
    tekiyo20(32, 0),
    /**
     * 後・保険・指導管理料等
     */
    atoHokenShidoKanriryo(10, 0),
    /**
     * 後・保険・単純エックス線
     */
    atoHokenTanjunXsen(10, 0),
    /**
     * 後・保険・リハビリテーション
     */
    atoHokenRehabilitation(10, 0),
    /**
     * 後・保険・精神科専門療法
     */
    atoHokenSeishinkaSemmonRyoho(10, 0),
    /**
     * 後・公費１・指導管理料等
     */
    atoKohi1ShidoKanriryo(10, 0),
    /**
     * 後・公費１・単純エックス線
     */
    atoKohi1TanjunXsen(10, 0),
    /**
     * 後・公費１・リハビリテーション
     */
    atoKohi1Rehabilitation(10, 0),
    /**
     * 後・公費１・精神科専門療法
     */
    atoKohi1SeishinkaSemmonRyoho(10, 0),
    /**
     * 後・公費２・指導管理料等
     */
    atoKohi2ShidoKanriryo(10, 0),
    /**
     * 後・公費２・単純エックス線
     */
    atoKohi2TanjunXsen(10, 0),
    /**
     * 後・公費２・リハビリテーション
     */
    atoKohi2Rehabilitation(10, 0),
    /**
     * 後・公費２・精神科専門療法
     */
    atoKohi2SeishinkaSemmonRyoho(10, 0),
    /**
     * 後・公費３・指導管理料等
     */
    atoKohi3ShidoKanriryo(10, 0),
    /**
     * 後・公費３・単純エックス線
     */
    atoKohi3TanjunXsen(10, 0),
    /**
     * 後・公費３・リハビリテーション
     */
    atoKohi3Rehabilitation(10, 0),
    /**
     * 後・公費３・精神科専門療法
     */
    atoKohi3SeishinkaSemmonRyoho(10, 0),
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

    private DbT3020KyufujissekiTokuteiSinryohi(int maxLength, int scale) {
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
