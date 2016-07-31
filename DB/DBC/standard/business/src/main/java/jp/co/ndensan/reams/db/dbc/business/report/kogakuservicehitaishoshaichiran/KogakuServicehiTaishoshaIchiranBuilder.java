/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehitaishoshaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kogakuservicehitaishoshaichiran.KogakuServicehiTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額介護サービス費対象者一覧表Builder
 *
 * @reamsid_L DBC-2010-100 surun
 */
public class KogakuServicehiTaishoshaIchiranBuilder implements
        IKogakuServicehiTaishoshaIchiranBuilder {

    private final IKogakuServicehiTaishoshaIchiranEditor editor;

    /**
     * KogakuServicehiTaishoshaIchiranBuilder
     *
     * @param editor IKogakuServicehiTaishoshaIchiranEditor
     */
    public KogakuServicehiTaishoshaIchiranBuilder(IKogakuServicehiTaishoshaIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuServicehiTaishoshaIchiranSource build() {
        return ReportEditorJoiner.from(new KogakuServicehiTaishoshaIchiranSource())
                .join(editor).buildSource();
    }

}
