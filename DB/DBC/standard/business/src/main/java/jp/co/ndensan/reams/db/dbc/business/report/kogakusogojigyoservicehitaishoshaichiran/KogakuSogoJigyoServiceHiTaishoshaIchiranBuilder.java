/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakusogojigyoservicehitaishoshaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kogakusogojigyoservicehitaishoshaichiran.KogakuSogoJigyoServiceHiTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額総合事業サービス費対象者一覧表Builder
 *
 * @reamsid_L DBC-2010-120 surun
 */
public class KogakuSogoJigyoServiceHiTaishoshaIchiranBuilder implements
        IKogakuSogoJigyoServiceHiTaishoshaIchiranBuilder {

    private final IKogakuSogoJigyoServiceHiTaishoshaIchiranEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IKogakuSogoJigyoServiceHiTaishoshaIchiranEditor
     */
    public KogakuSogoJigyoServiceHiTaishoshaIchiranBuilder(IKogakuSogoJigyoServiceHiTaishoshaIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuSogoJigyoServiceHiTaishoshaIchiranSource build() {
        return ReportEditorJoiner.from(new KogakuSogoJigyoServiceHiTaishoshaIchiranSource())
                .join(editor).buildSource();
    }

}
