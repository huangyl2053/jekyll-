/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200074;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200074.JukyushaIdoRirekiTeiseiIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMNF1001_1_国保連受給者異動情報履歴訂正リストBuilder
 *
 * @reamsid_L DBC-2720-050 jiangxiaolong
 */
public class JukyushaIdoRirekiTeiseiIchiranBuilder
        implements IJukyushaIdoRirekiTeiseiIchiranBuilder {

    private final IJukyushaIdoRirekiTeiseiIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param bodyEditor BodyEditor
     */
    public JukyushaIdoRirekiTeiseiIchiranBuilder(
            IJukyushaIdoRirekiTeiseiIchiranEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    @Override
    public JukyushaIdoRirekiTeiseiIchiranSource build() {
        return ReportEditorJoiner.from(new JukyushaIdoRirekiTeiseiIchiranSource())
                .join(bodyEditor).buildSource();
    }

}
