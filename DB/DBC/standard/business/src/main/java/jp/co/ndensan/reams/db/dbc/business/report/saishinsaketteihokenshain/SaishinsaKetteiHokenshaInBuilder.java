/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.saishinsaketteihokenshain;

import jp.co.ndensan.reams.db.dbc.entity.report.source.saishinsaketteihokenshain.SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 再審査決定通知書情報取込一覧表（保険者分）Builderクラスです。
 *
 * @reamsid_L DBC-2520-040 chenaoqi
 */
public class SaishinsaKetteiHokenshaInBuilder implements ISaishinsaKetteiHokenshaInBuilder {

    private final ISaishinsaKetteiHokenshaInEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor {@link ISaishinsaKetteiHokenshaInEditor}
     */
    public SaishinsaKetteiHokenshaInBuilder(ISaishinsaKetteiHokenshaInEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource}
     */
    @Override
    public SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource build() {
        return ReportEditorJoiner.from(new SaishinsaKetteitsuchishoTorikomiIchiranHokenshaBunSource()).join(editor).buildSource();
    }
}
