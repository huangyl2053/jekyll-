/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakuservicehisofuichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakuservicehisofuichiran.KogakuServicehiSofuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBC200019_高額介護サービス費給付判定結果送付一覧表 のBuilderクラスです。
 *
 * @reamsid_L DBC-2610-040 qinzhen
 */
public class KogakuServicehiSofuIchiranBuilder implements IKogakuServicehiSofuIchiranBuilder {

    private final IKogakuServicehiSofuIchiranEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor IKogakuServicehiSofuIchiranEditor
     */
    public KogakuServicehiSofuIchiranBuilder(IKogakuServicehiSofuIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public KogakuServicehiSofuIchiranSource build() {
        return ReportEditorJoiner.from(new KogakuServicehiSofuIchiranSource())
                .join(editor).buildSource();
    }
}
