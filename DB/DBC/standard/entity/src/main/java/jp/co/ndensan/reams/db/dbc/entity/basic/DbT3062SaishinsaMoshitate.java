package jp.co.ndensan.reams.db.dbc.entity.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 再審査申立テーブルの項目定義クラスです。
 */
public enum DbT3062SaishinsaMoshitate implements IColumnDefinition {
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
     * 事業所番号
     */
    jigyoshoNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hiHokenshaNo(2147483647, 0),
    /**
     * サービス提供年月
     */
    serviceTeikyoYM(2147483647, 0),
    /**
     * サービス種類コード
     */
    serviceTeikyoShuruiCode(2147483647, 0),
    /**
     * サービス項目コード
     * <br/>特定診療費・特別療養費の場合は識別番号を設定する（上2桁は00)
     */
    serviceKomokuCode(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 申立年月日
     */
    moshitateYMD(2147483647, 0),
    /**
     * 申立者区分コード
     * <br/>1：サービス事業者等申立
     */
    moshitateshaKubunCode(1, 0),
    /**
     * 証記載保険者番号
     */
    shokisaiHokenshaNo(2147483647, 0),
    /**
     * 申立単位数
     */
    moshitateTanisu(10, 0),
    /**
     * 申立事由コード
     */
    moshitateJiyuCode(4, 0),
    /**
     * 国保連送付年月
     */
    kokuhorenSofuYM(2147483647, 0),
    /**
     * 国保連再送付有フラグ
     */
    kokuhirenSaiSofuAriFlag(1, 0),
    /**
     * 備考
     * <br/>沖縄広域のみ使用
     */
    biko(100, 0);

    private final int maxLength;
    private final int scale;

    private DbT3062SaishinsaMoshitate(int maxLength, int scale) {
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
