package jp.co.ndensan.reams.db.dbc.entity.db.basic;

import jp.co.ndensan.reams.uz.uza.util.db.IColumnDefinition;

/**
 * 基準収入額適用管理テーブルの項目定義クラスです。
 */
public enum DbT3116KijunShunyugakuTekiyoKanri implements IColumnDefinition {
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
     * 世帯コード
     */
    setaiCode(2147483647, 0),
    /**
     * 年度
     */
    nendo(2147483647, 0),
    /**
     * 履歴番号
     */
    rirekiNo(5, 0),
    /**
     * 被保険者番号
     */
    hihokenshaNo(2147483647, 0),
    /**
     * 公的年金収入額
     */
    kotekiNenkinShunyugaku(12, 0),
    /**
     * 給与収入額
     */
    kyuyoShunyugaku(12, 0),
    /**
     * その他の収入額
     */
    sonotaShunyugaku(12, 0),
    /**
     * 算定基準額
     */
    santeiKijungaku(10, 0),
    /**
     * 適用開始年月
     */
    tekiyoKaishiYMD(2147483647, 0),
    /**
     * 申請日
     */
    shinseiYMD(2147483647, 0),
    /**
     * 決定日
     */
    ketteiYMD(2147483647, 0),
    /**
     * 申請書作成日
     */
    shinseishoSakuseiYMD(2147483647, 0),
    /**
     * 申請書作成の世帯基準日
     */
    shinseishoSakuseiSetaiKijunYMD(2147483647, 0),
    /**
     * 決定通知書発行日
     */
    ketteiTsuchishoHakkoYMD(2147483647, 0),
    /**
     * 宛先印字対象者フラグ
     * <br/>お知らせ通知の宛先に印字した被保険者かどうか
     */
    atesakiInjiTaishoshaFlag(1, 0),
    /**
     * 年少扶養控除（16歳未満）人数
     */
    nenshoFuyokojoUnder16Ninzu(5, 0),
    /**
     * 年少扶養控除（16～18歳未満）人数
     */
    nenshoFuyokojoOver16Ninzu(5, 0),
    /**
     * 世帯員の総収入額
     */
    setaiinSoShunyugaku(12, 0),
    /**
     * 世帯主フラグ
     * <br/>年度の前年12/31時点の世帯主かどうか
     */
    setainushiFlag(1, 0),
    /**
     * 課税所得額
     */
    kazeiShotokugaku(12, 0),
    /**
     * 課税所得額（控除後）
     */
    kazeiShotokugakuKojogo(12, 0);

    private final int maxLength;
    private final int scale;

    private DbT3116KijunShunyugakuTekiyoKanri(int maxLength, int scale) {
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
