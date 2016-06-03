/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakukyufutaishoshaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufutaishoshaichiran.KogakuKyufuTaishoshaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額介護サービス費給付対象者一覧表帳票Builder
 *
 * @reamsid_L DBC-0980-490 surun
 */
public class KogakuKyufuTaishoshaIchiranBuilder implements IKogakuKyufuTaishoshaIchiranBuilder {

    private final IKogakuKyufuTaishoshaIchiranEditor headerEditor;
    private final IKogakuKyufuTaishoshaIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IKogakuKyufuTaishoshaIchiranEditor
     * @param bodyEditor IKogakuKyufuTaishoshaIchiranEditor
     */
    public KogakuKyufuTaishoshaIchiranBuilder(
            IKogakuKyufuTaishoshaIchiranEditor headerEditor,
            IKogakuKyufuTaishoshaIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public KogakuKyufuTaishoshaIchiranSource build() {
        return ReportEditorJoiner.from(new KogakuKyufuTaishoshaIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
