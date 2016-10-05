/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.dbc200010;

import jp.co.ndensan.reams.db.dbc.entity.report.dbc200010.JukyushaIdorenrakuhyoSofuTaishoshachiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBCMNF1001_1_受給者異動連絡票情報送付対象者リストBuilder
 *
 * @reamsid_L DBC-2720-040 jiangxiaolong
 */
public class JukyushaIdorenrakuhyoSofuTaishoshachiranBuilder
        implements IJukyushaIdorenrakuhyoSofuTaishoshachiranBuilder {

    private final IJukyushaIdorenrakuhyoSofuTaishoshachiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param bodyEditor BodyEditor
     */
    public JukyushaIdorenrakuhyoSofuTaishoshachiranBuilder(
            IJukyushaIdorenrakuhyoSofuTaishoshachiranEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    @Override
    public JukyushaIdorenrakuhyoSofuTaishoshachiranSource build() {
        return ReportEditorJoiner.from(new JukyushaIdorenrakuhyoSofuTaishoshachiranSource())
                .join(bodyEditor).buildSource();
    }

}
