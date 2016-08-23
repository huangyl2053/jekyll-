/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.sogojigyohisaishinsaketteitsuchisho;

import jp.co.ndensan.reams.db.dbc.entity.report.source.sogojigyohisaishin.SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 総合事業費再審査決定通知書情報取込一覧表（公費）帳票Builder
 *
 * @reamsid_L DBC-4730-040 liuxiaoyu
 */
public class SogojigyohiSaishinsaKetteitsuchishoBuilder implements ISogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiBuilder {

    private final ISogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEditor headEditor;
    private final ISogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param headEditor {@link ISogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEditor}
     * @param bodyEditor {@link ISogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEditor}
     */
    public SogojigyohiSaishinsaKetteitsuchishoBuilder(ISogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEditor headEditor,
            ISogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiEditor bodyEditor) {
        this.headEditor = headEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShokanKetteiTsuchiShoShiharaiYoteiBiYijiNashiReportSource}
     */
    @Override
    public SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource build() {
        return ReportEditorJoiner.from(new SogojigyohiSaishinsaKetteitsuchishoTorikomiIchiranKohiSource())
                .join(headEditor).join(bodyEditor).buildSource();
    }
}
