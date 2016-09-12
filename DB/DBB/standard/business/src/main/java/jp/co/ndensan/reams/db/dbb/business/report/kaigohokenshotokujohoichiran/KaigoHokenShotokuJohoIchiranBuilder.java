/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kaigohokenshotokujohoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.kaigohokenshotokujohoichiran.KaigoHokenShotokuJohoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBPR51003_介護保険所得情報一覧表のBuilder
 *
 * @reamsid_L DBB-1650-060 lijunjun
 */
public class KaigoHokenShotokuJohoIchiranBuilder implements IKaigoHokenShotokuJohoIchiranBuilder {

    private final IKaigoHokenShotokuJohoIchiranEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IKaigoHokenShotokuJohoIchiranEditor
     */
    public KaigoHokenShotokuJohoIchiranBuilder(IKaigoHokenShotokuJohoIchiranEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースビルドです。
     *
     * @return {@link KaigoHokenShotokuJohoIchiranSource}
     */
    @Override
    public KaigoHokenShotokuJohoIchiranSource build() {
        return ReportEditorJoiner.from(new KaigoHokenShotokuJohoIchiranSource()).join(editor).buildSource();
    }
}
