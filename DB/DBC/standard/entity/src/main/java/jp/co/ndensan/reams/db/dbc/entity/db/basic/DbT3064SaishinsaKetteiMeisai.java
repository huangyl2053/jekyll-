package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 再審査決定明細テーブルの項目定義クラスです。
 */
public enum DbT3064SaishinsaKetteiMeisai implements IColumnDefinition {
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
     * <br/>1：保険者　2：公費負担者
     * <br/>3：総合事業費保険者
     * <br/>4：総合事業費公費負担者
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
     * <br/>公費（保険者区分=2,4）の場合のみ設定
     */
    kohiJukyushaNo(7, 0),
    /**
     * 証記載保険者番号
     * <br/>公費（保険者区分=2,4）の場合のみ設定
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
     * 申立事由コード
     */
    moushitateJiyuCode(4, 0),
    /**
     * 申立事由
     */
    moushitateJiyu(12, 0),
    /**
     * 再審査結果コード
     */
    saishinsaResultCode(2, 0),
    /**
     * 当初請求単位数
     */
    toshoSeikyuTanisu(12, 0),
    /**
     * 原審単位数
     */
    genshinSeikyuTanisu(12, 0),
    /**
     * 申立単位数
     */
    moushitateTanisu(12, 0),
    /**
     * 決定単位数
     */
    ketteiTanisu(12, 0),
    /**
     * 調整単位数
     */
    choseiTanisu(13, 0),
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

    private DbT3064SaishinsaKetteiMeisai(int maxLength, int scale) {
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
