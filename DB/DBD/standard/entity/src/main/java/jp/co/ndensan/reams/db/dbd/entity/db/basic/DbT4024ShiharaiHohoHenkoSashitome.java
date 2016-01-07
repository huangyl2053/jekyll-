package jp.co.ndensan.reams.db.dbd.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;
import jp.co.ndensan.reams.uz.uza.util.db.OnNextSchema;

/**
 * 支払方法変更差止テーブルの項目定義クラスです。
 */
@OnNextSchema("rgdb")
public enum DbT4024ShiharaiHohoHenkoSashitome implements IColumnDefinition {
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
     * 証記載保険者番号
     */
    shoKisaiHokenshaNo(2147483647, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 管理区分
     * <br/>1：２号差止
     * <br/>2：１号償還払い化
     * <br/>3：１号給付額減額
     */
    kanriKubun(1, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 情報分類区分
     * <br/>1：差止情報、2：保険料控除情報
     */
    johoBunruiKubun(1, 0),
    /**
     * 連番
     */
    renNo(5, 0),
    /**
     * 差止控除状態区分
     * <br/>01：登録,99：解除
     */
    sashitomeKojoJotaiKubun(2, 0),
    /**
     * 差止決定年月日
     */
    sashitome_KetteiYMD(2147483647, 0),
    /**
     * 差止通知書発行年月日
     */
    sashitome_TsuchiHakkoYMD(2147483647, 0),
    /**
     * 差止通知書再発行フラグ
     * <br/>1：再発行対象,0：再発行対象外
     */
    sashitome_TsuchiSaiHakkoFlag(1, 0),
    /**
     * 差止控除番号
     */
    sashitomeKojoNo(2, 0),
    /**
     * 差止納付期限
     */
    sashitome_NofuYMD(2147483647, 0),
    /**
     * 差止解除年月日
     */
    sashitome_KaijoYMD(2147483647, 0),
    /**
     * 差止サービス提供年月
     */
    sashitome_ServiceTeikyoYM(2147483647, 0),
    /**
     * 差止償還整理番号
     */
    sashitome_ShokanSeiriNo(10, 0),
    /**
     * 控除決定年月日
     */
    kojo_KetteiYMD(2147483647, 0),
    /**
     * 控除通知書発行年月日
     */
    kojo_TsuchiHakkoYMD(2147483647, 0),
    /**
     * 控除通知書再発行フラグ
     * <br/>1：再発行対象,0：再発行対象外
     */
    kojo_TsuchiSaiHakkoYMD(1, 0),
    /**
     * 控除被保険者証提出期限
     */
    kojo_ShoTeishutsuYMD(2147483647, 0);

    private final int maxLength;
    private final int scale;

    private DbT4024ShiharaiHohoHenkoSashitome(int maxLength, int scale) {
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
