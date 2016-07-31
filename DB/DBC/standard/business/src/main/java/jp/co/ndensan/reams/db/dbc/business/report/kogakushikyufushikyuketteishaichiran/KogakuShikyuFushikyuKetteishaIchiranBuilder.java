/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbc.business.report.kogakushikyufushikyuketteishaichiran;

import jp.co.ndensan.reams.db.dbc.entity.report.source.kogakukyufukettei.KogakuShikyuFushikyuKetteishaIchiranSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 高額サービス費支給（不支給）決定者一覧表帳票Builder
 *
 * @reamsid_L DBC-0980-500 surun
 */
public class KogakuShikyuFushikyuKetteishaIchiranBuilder implements IKogakuShikyuFushikyuKetteishaIchiranBuilder {

    private final IKogakuShikyuFushikyuKetteishaIchiranEditor headerEditor;
    private final IKogakuShikyuFushikyuKetteishaIchiranEditor bodyEditor;

    /**
     * コンストラクタです
     *
     * @param headerEditor IKogakuShikyuFushikyuKetteishaIchiranEditor
     * @param bodyEditor IKogakuShikyuFushikyuKetteishaIchiranEditor
     */
    public KogakuShikyuFushikyuKetteishaIchiranBuilder(
            IKogakuShikyuFushikyuKetteishaIchiranEditor headerEditor,
            IKogakuShikyuFushikyuKetteishaIchiranEditor bodyEditor) {
        this.headerEditor = headerEditor;
        this.bodyEditor = bodyEditor;
    }

    @Override
    public KogakuShikyuFushikyuKetteishaIchiranSource build() {
        return ReportEditorJoiner.from(new KogakuShikyuFushikyuKetteishaIchiranSource()).join(headerEditor).join(bodyEditor).buildSource();
    }

}
