/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidoukekkaichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.kanendoidoukekkaichiran.KanendoIdouKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBRP45001_2_本算定異動（過年度）結果一覧表 Builder実装です。
 *
 * @reamsid_L DBB-0910-030 zhangrui
 *
 */
public class KanendoIdouKekkaIchiranBuilder implements IKanendoIdouKekkaIchiranBuilder {

    private final IKanendoIdouKekkaIchiranEditor headerEditor;
    private final IKanendoIdouKekkaIchiranEditor kanendoIdouKekkaIchiranEditor;

    /**
     * インスタンスを生成します、コンストラクタです。
     *
     * @param headerEditor IKanendoIdouKekkaIchiranEditor
     * @param kanendoIdouKekkaIchiranEditor IKanendoIdouKekkaIchiranEditor
     */
    public KanendoIdouKekkaIchiranBuilder(IKanendoIdouKekkaIchiranEditor headerEditor,
            IKanendoIdouKekkaIchiranEditor kanendoIdouKekkaIchiranEditor) {
        this.headerEditor = headerEditor;
        this.kanendoIdouKekkaIchiranEditor = kanendoIdouKekkaIchiranEditor;
    }

    /**
     * 帳票ソースビルド
     *
     * @return {@link KanendoIdouKekkaIchiranSource}
     */
    @Override
    public KanendoIdouKekkaIchiranSource build() {
        return ReportEditorJoiner.from(new KanendoIdouKekkaIchiranSource()).join(headerEditor).join(kanendoIdouKekkaIchiranEditor).buildSource();
    }

}
