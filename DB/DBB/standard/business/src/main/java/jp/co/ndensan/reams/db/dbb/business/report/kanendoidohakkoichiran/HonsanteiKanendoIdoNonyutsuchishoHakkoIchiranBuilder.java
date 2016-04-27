/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.kanendoidohakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBPR45002_保険料納入通知書（本算定過年度異動）発行一覧表 Builderです。
 *
 * Sourceは帳票設計_DBBRP43002_2_保険料納入通知書（本算定）発行一覧表と同じです。
 *
 * @reamsid_L DBB-0920-050 zhangrui
 */
public class HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranBuilder
        implements IHonsanteiKanendoIdoNonyutsuchishoHakkoIchiranBuilder {

    private final IHonsanteiKanendoIdoNonyutsuchishoHakkoIchiranEditor headerEditor;
    private final IHonsanteiKanendoIdoNonyutsuchishoHakkoIchiranEditor bodyEditor;

    /**
     * コンストラクタです。
     *
     * @param headerEditor IHonsanteiKanendoIdoNonyutsuchishoHakkoIchiranEditor
     * @param bodyEditor IHonsanteiKanendoIdoNonyutsuchishoHakkoIchiranEditor
     */
    public HonsanteiKanendoIdoNonyutsuchishoHakkoIchiranBuilder(
            IHonsanteiKanendoIdoNonyutsuchishoHakkoIchiranEditor headerEditor,
            IHonsanteiKanendoIdoNonyutsuchishoHakkoIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースビルドです。
     *
     * @return {@link NonyuTsuchIchiranSource}
     */
    @Override
    public NonyuTsuchIchiranSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }
}
