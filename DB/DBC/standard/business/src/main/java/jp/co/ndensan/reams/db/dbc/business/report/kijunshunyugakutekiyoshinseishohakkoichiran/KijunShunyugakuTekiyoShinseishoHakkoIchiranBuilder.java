/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kijunshunyugakutekiyoshinseishohakkoichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.kijunshunyugakutekiyoshinseishohakkoichiran.KijunShunyugakuTekiyoShinseishoHakkoIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBC200088_基準収入額適用申請書一覧表 Builderするクラスです。
 *
 * @reamsid_L DBC-4640-060 lijian
 */
public class KijunShunyugakuTekiyoShinseishoHakkoIchiranBuilder implements IKijunShunyugakuTekiyoShinseishoHakkoIchiranBuilder {

    private final IKijunShunyugakuTekiyoShinseishoHakkoIchiranEditor editor;

    /**
     * コンストラクタです。
     *
     * @param editor IKijunShunyugakuTekiyoShinseishoHakkoIchiranEditor
     */
    public KijunShunyugakuTekiyoShinseishoHakkoIchiranBuilder(IKijunShunyugakuTekiyoShinseishoHakkoIchiranEditor editor) {
        this.editor = editor;
    }

    @Override
    public KijunShunyugakuTekiyoShinseishoHakkoIchiranSource build() {
        return ReportEditorJoiner.from(new KijunShunyugakuTekiyoShinseishoHakkoIchiranSource()).join(editor).buildSource();
    }
}
