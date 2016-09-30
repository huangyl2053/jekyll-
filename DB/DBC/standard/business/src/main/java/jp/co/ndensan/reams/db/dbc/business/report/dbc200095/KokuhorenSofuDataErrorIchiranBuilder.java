/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200095;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200095.KokuhorenSofuDataErrorIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMNF1001_1_国保連送付データエラーリストBuilder
 *
 * @reamsid_L DBC-2720-060 jiangxiaolong
 */
public class KokuhorenSofuDataErrorIchiranBuilder
        implements IKokuhorenSofuDataErrorIchiranBuilder {

    private final IKokuhorenSofuDataErrorIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param bodyEditor BodyEditor
     */
    public KokuhorenSofuDataErrorIchiranBuilder(
            IKokuhorenSofuDataErrorIchiranEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    @Override
    public KokuhorenSofuDataErrorIchiranSource build() {
        return ReportEditorJoiner.from(new KokuhorenSofuDataErrorIchiranSource())
                .join(bodyEditor).buildSource();
    }

}
