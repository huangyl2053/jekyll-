/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.nofugakuichiranshinkokuyo;

import jp.co.ndensan.reams.db.dbb.entity.report.source.nofugakuichiranshinkokuyo.NofugakuIchiranShinkokuyoSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 帳票設計_DBBRP91003-1_納付額一覧表（確定申告用） のBuilderクラスです。
 *
 * @reamsid_L DBB-1890-040 qinzhen
 */
public class NofugakuIchiranShinkokuyoBuilder implements INofugakuIchiranShinkokuyoBuilder {

    private final INofugakuIchiranShinkokuyoEditor editor;

    /**
     * コンストラクタです
     *
     * @param editor INofugakuIchiranShinkokuyoEditor
     */
    public NofugakuIchiranShinkokuyoBuilder(INofugakuIchiranShinkokuyoEditor editor) {
        this.editor = editor;
    }

    @Override
    public NofugakuIchiranShinkokuyoSource build() {
        return ReportEditorJoiner.from(new NofugakuIchiranShinkokuyoSource())
                .join(editor).buildSource();
    }
}
