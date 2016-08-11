/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.definition.mybatisprm.hoshushiharaijunbipanel;

import jp.co.ndensan.reams.db.dbe.definition.core.hoshu.IsGinkoFurikomiShutsuryoku;
import jp.co.ndensan.reams.uz.uza.batch.parameter.IMyBatisParameter;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import lombok.Getter;

/**
 *
 * 支払いデータ作成のMybatisパラメータクラスです。
 *
 * @reamsid_L DBE-1990-020 lizhuoxuan
 */
@SuppressWarnings("PMD.UnusedPrivateField")
@Getter
public class HoshushiharaiJumbiPanelBatchMybitisParameter implements IMyBatisParameter {

    private final FlexibleDate 実績期間From;
    private final FlexibleDate 実績期間To;
    private final FlexibleDate 振込指定日;
    private final RString 処理状態区分_通常;
    private final RString 処理状態区分_延期;
    private final RString 報酬基準日;
    private final boolean 基準日フラグ;
    private final boolean 銀行振込出力フラグ;

    /**
     * コンストラクタです。
     *
     * @param 実績期間From 実績期間From
     * @param 実績期間To 実績期間To
     * @param 振込指定日 振込指定日
     * @param 処理状態区分_通常 処理状態区分_通常
     * @param 処理状態区分_延期 処理状態区分_延期
     * @param 報酬基準日 主治医意見書報酬基準日
     * @param 基準日フラグ 基準日フラグ
     * @param 銀行振込出力フラグ 銀行振込出力フラグ
     */
    protected HoshushiharaiJumbiPanelBatchMybitisParameter(FlexibleDate 実績期間From,
            FlexibleDate 実績期間To,
            FlexibleDate 振込指定日,
            RString 処理状態区分_通常,
            RString 処理状態区分_延期,
            RString 報酬基準日,
            boolean 基準日フラグ,
            boolean 銀行振込出力フラグ) {
        this.実績期間From = 実績期間From;
        this.実績期間To = 実績期間To;
        this.振込指定日 = 振込指定日;
        this.処理状態区分_通常 = 処理状態区分_通常;
        this.処理状態区分_延期 = 処理状態区分_延期;
        this.報酬基準日 = 報酬基準日;
        this.基準日フラグ = 基準日フラグ;
        this.銀行振込出力フラグ = 銀行振込出力フラグ;
    }

    /**
     * Mybatisのパラメータを作成します。
     *
     * @param 実績期間From 実績期間From
     * @param 実績期間To 実績期間To
     * @param 振込指定日 振込指定日
     * @param 処理状態区分_通常 処理状態区分_通常
     * @param 処理状態区分_延期 処理状態区分_延期
     * @param 主治医意見書報酬基準日 主治医意見書報酬基準日
     * @param 基準日フラグ 基準日フラグ
     * @return HoshushiharaiJumbiPanelBatchMybitisParameter
     */
    public static HoshushiharaiJumbiPanelBatchMybitisParameter creatParameter(FlexibleDate 実績期間From,
            FlexibleDate 実績期間To,
            FlexibleDate 振込指定日,
            RString 処理状態区分_通常,
            RString 処理状態区分_延期,
            RString 主治医意見書報酬基準日,
            boolean 基準日フラグ) {
        return new HoshushiharaiJumbiPanelBatchMybitisParameter(実績期間From,
                実績期間To,
                振込指定日,
                処理状態区分_通常,
                処理状態区分_延期,
                主治医意見書報酬基準日,
                基準日フラグ,
                IsGinkoFurikomiShutsuryoku.出力未.is出力済());
    }
}
