package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 過誤申立テーブルの項目定義クラスです。
 */
public enum DbT3059KagoMoshitate implements IColumnDefinition {
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
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 申立年月日
     */
    moshitateYMD(2147483647, 0),
    /**
     * 申立者区分コード
     * <br/>2固定(2：保険者申立)
     */
    moshitateshaKubunCode(1, 0),
    /**
     * 証記載保険者番号
     */
    shokisaiHokenshaNo(2147483647, 0),
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
     * <br/>0：通常　1：再送付
     */
    kokuhirenSaiSofuAriFlag(1, 0),
    /**
     * 同月審査有フラグ
     * <br/>0：通常　1：同月審査用（同月過誤）
     */
    dogetsuShinsaAriFlag(1, 0),
    /**
     * 申立書区分コード
     * <br/>1：過誤申立書情報
     *
     * <br/>2：総合事業過誤申立書情報（経過措置）
     *
     * <br/>3:総合事業過誤申立書情報
     */
    moshitateshoKubunCode(1, 0);

    private final int maxLength;
    private final int scale;

    private DbT3059KagoMoshitate(int maxLength, int scale) {
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
