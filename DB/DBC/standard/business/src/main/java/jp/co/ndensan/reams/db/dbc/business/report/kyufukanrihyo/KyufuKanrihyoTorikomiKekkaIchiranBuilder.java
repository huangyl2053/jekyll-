/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kyufukanrihyo;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kyufukanrihyo.KyufuKanrihyoTorikomiKekkaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 給付管理票取込結果一覧表帳票Builder
 *
 * @reamsid_L DBC-2450-040 zhangrui
 */
public class KyufuKanrihyoTorikomiKekkaIchiranBuilder implements
        IKyufuKanrihyoTorikomiKekkaIchiranBuilder {

    private final IKyufuKanrihyoTorikomiKekkaIchiranEditor headerEditor;
    private final IKyufuKanrihyoTorikomiKekkaIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IKyufuKanrihyoTorikomiKekkaIchiranEditor
     * @param bodyEditor IKyufuKanrihyoTorikomiKekkaIchiranEditor
     */
    public KyufuKanrihyoTorikomiKekkaIchiranBuilder(
            IKyufuKanrihyoTorikomiKekkaIchiranEditor headerEditor,
            IKyufuKanrihyoTorikomiKekkaIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public KyufuKanrihyoTorikomiKekkaIchiranSource build() {
        return ReportEditorJoiner.from(new KyufuKanrihyoTorikomiKekkaIchiranSource())
                .join(headerEditor).join(bodyEditor).buildSource();
    }
}
