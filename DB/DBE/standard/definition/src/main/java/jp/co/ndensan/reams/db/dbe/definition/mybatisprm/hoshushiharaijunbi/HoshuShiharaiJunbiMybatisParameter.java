package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hoshushiharaijunbi;

import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDateTime;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 * 報酬支払い通知書請求書・確認書のMybatisパラメータクラスです。
 *
 * @reamsid_L DBE-1980-020 suguangjun
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public final class HoshuShiharaiJunbiMybatisParameter implements IMyBatisParameter {

    private final RDateTime 実績期間From;
    private final RDateTime 実績期間To;
    private final FlexibleDate 振込指定日;
    private final RString 処理状態区分_通常;
    private final RString 処理状態区分_延期;
    private final RString 概況調査イメージ区分;
    private final RString 報酬基準日;
    private final boolean 基準日フラグ;

    /**
     * コンストラクタです。
     *
     * @param 実績期間From 実績期間From
     * @param 実績期間To 実績期間To
     * @param 振込指定日 振込指定日
     * @param 処理状態区分_通常 処理状態区分_通常
     * @param 処理状態区分_延期 処理状態区分_延期
     * @param 概況調査イメージ区分 概況調査イメージ区分
     * @param 報酬基準日 主治医意見書報酬基準日
     * @param 基準日フラグ 基準日フラグ
     */
    protected HoshuShiharaiJunbiMybatisParameter(RDateTime 実績期間From,
            RDateTime 実績期間To,
            FlexibleDate 振込指定日,
            RString 処理状態区分_通常,
            RString 処理状態区分_延期,
            RString 概況調査イメージ区分,
            RString 報酬基準日,
            boolean 基準日フラグ
    ) {
        this.実績期間From = 実績期間From;
        this.実績期間To = 実績期間To;
        this.振込指定日 = 振込指定日;
        this.処理状態区分_通常 = 処理状態区分_通常;
        this.処理状態区分_延期 = 処理状態区分_延期;
        this.概況調査イメージ区分 = 概況調査イメージ区分;
        this.報酬基準日 = 報酬基準日;
        this.基準日フラグ = 基準日フラグ;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param 実績期間From 実績期間From
     * @param 実績期間To 実績期間To
     * @param 振込指定日 振込指定日
     * @param 処理状態区分_通常 処理状態区分_通常
     * @param 処理状態区分_延期 処理状態区分_延期
     * @param 概況調査イメージ区分 概況調査イメージ区分
     * @param 主治医意見書報酬基準日 主治医意見書報酬基準日
     * @param 基準日フラグ 基準日フラグ
     * @return HoshuShiharaiJunbiMybatisParameter
     */
    public static HoshuShiharaiJunbiMybatisParameter creatParameter(RDateTime 実績期間From,
            RDateTime 実績期間To,
            FlexibleDate 振込指定日,
            RString 処理状態区分_通常,
            RString 処理状態区分_延期,
            RString 概況調査イメージ区分,
            RString 主治医意見書報酬基準日,
            boolean 基準日フラグ
    ) {
        return new HoshuShiharaiJunbiMybatisParameter(
                実績期間From,
                実績期間To,
                振込指定日,
                処理状態区分_通常,
                処理状態区分_延期,
                概況調査イメージ区分,
                主治医意見書報酬基準日,
                基準日フラグ);
    }
}
