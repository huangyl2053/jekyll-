/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.gennendoidohakkoichiran;

import jp.co.ndensan.reams.db.dbb.entity.report.nonyutsuchishohonsanteihakkoichiran.NonyuTsuchIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 帳票設計_DBBRP44002_1_保険料納入通知書（本算定現年度異動）発行一覧表 Builderです。
 *
 * 帳票項目定義は帳票設計_DBBRP43002_2_保険料納入通知書（本算定）発行一覧表と同じです。
 *
 * @reamsid_L DBB-0880-050 zhangrui
 */
public class HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranBuilder implements IHonsanteiGennendoIdoNonyutsuchishoHakkoIchiranBuilder {

    private final IHonsanteiGennendoIdoNonyutsuchishoHakkoIchiranEditor headerEditor;
    private final IHonsanteiGennendoIdoNonyutsuchishoHakkoIchiranEditor bodyEditor;

    /**
     * コンストラクタです。
     *
     * @param headerEditor IHonsanteiGennendoIdoNonyutsuchishoHakkoIchiranEditor
     * @param bodyEditor IHonsanteiGennendoIdoNonyutsuchishoHakkoIchiranEditor
     */
    public HonsanteiGennendoIdoNonyutsuchishoHakkoIchiranBuilder(
            IHonsanteiGennendoIdoNonyutsuchishoHakkoIchiranEditor headerEditor,
            IHonsanteiGennendoIdoNonyutsuchishoHakkoIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースビルド
     *
     * @return {@link NonyuTsuchIchiranSource}
     */
    @Override
    public NonyuTsuchIchiranSource build() {
        return ReportEditorJoiner.from(new NonyuTsuchIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }

}
