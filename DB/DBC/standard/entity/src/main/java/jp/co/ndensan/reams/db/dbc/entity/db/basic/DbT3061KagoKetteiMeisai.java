package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 過誤決定明細テーブルの項目定義クラスです。
 */
public enum DbT3061KagoKetteiMeisai implements IColumnDefinition {
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
     * 取扱年月
     * <br/>連合会が取扱った年月
     */
    toriatsukaiYM(2147483647, 0),
    /**
     * 保険者区分
     * <br/>1：保険者
     * <br/>2：公費負担者　
     * <br/>3：総合事業費(経過措置)保険者
     * <br/>4：総合事業費保険者
     * <br/>5：総合事業費公費負担者
     */
    hokenshaKubun(1, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 事業所番号
     */
    jigyoshoNo(2147483647, 0),
    /**
     * 事業所名
     */
    jigyoshoName(20, 0),
    /**
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * 公費受給者番号
     * <br/>公費（保険者区分=2、5）の場合
     */
    kohiJukyushaNo(7, 0),
    /**
     * 証記載保険者番号
     * <br/>公費（保険者区分=2、5）の場合
     */
    shokisaiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * サービス種類コード
     */
    serviceShuruiCode(2147483647, 0),
    /**
     * サービス種類名
     */
    serviceShuruiName(12, 0),
    /**
     * 過誤申立事由コード
     */
    kagomoushitateJiyuCode(2147483647, 0),
    /**
     * 過誤申立事由
     */
    kagomoushitateJiyu(14, 0),
    /**
     * 単位数（特定入所者介護費等）
     */
    tanisu(13, 0),
    /**
     * 保険者負担額
     */
    hokenshaFutangaku(13, 0),
    /**
     * 取込年月
     */
    torikomiYM(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT3061KagoKetteiMeisai(int maxLength, int scale) {
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
