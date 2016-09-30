/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nofugakuichirancodefumei;

import jp.co.ndensan.reams.db.dbb.business.report.nofugakuichirandaihyo.NofugakuIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBBRP91003-2_納付額一覧表（識別コード不明分） のBuilderクラスです。
 *
 * @reamsid_L DBB-1890-050 qinzhen
 */
public class NofugakuIchiranCodeFumeiBuilder implements INofugakuIchiranCodeFumeiBuilder {

    private final INofugakuIchiranCodeFumeiEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor INofugakuIchiranCodeFumeiEditor
     */
    public NofugakuIchiranCodeFumeiBuilder(INofugakuIchiranCodeFumeiEditor editor) {
        this.editor = editor;
    }

    @Override
    public NofugakuIchiranSource build() {
        return ReportEditorJoiner.from(new NofugakuIchiranSource())
                .join(editor).buildSource();
    }
}
