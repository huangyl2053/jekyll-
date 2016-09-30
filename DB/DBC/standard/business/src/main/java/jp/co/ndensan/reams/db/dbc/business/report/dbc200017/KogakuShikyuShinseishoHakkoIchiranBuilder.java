/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200017;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200017.KogakuShikyuShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200017_高額介護サービス費支給申請書発行一覧表Builder
 *
 * @reamsid_L DBC-4770-130 jiangxiaolong
 */
public class KogakuShikyuShinseishoHakkoIchiranBuilder
        implements IKogakuShikyuShinseishoHakkoIchiranBuilder {

    private final IKogakuShikyuShinseishoHakkoIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param bodyEditor BodyEditor
     */
    public KogakuShikyuShinseishoHakkoIchiranBuilder(
            IKogakuShikyuShinseishoHakkoIchiranEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    @Override
    public KogakuShikyuShinseishoHakkoIchiranSource build() {
        return ReportEditorJoiner.from(new KogakuShikyuShinseishoHakkoIchiranSource())
                .join(bodyEditor).buildSource();
    }

}
