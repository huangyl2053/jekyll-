/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbb.business.report.dbbrp00007.nonyutsuchishohonsanteibook;

import jp.co.ndensan.reams.db.dbb.entity.report.dbbrp00007.nonyutsuchishohonsanteibook.FuriKaeAriCoverToNofushoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 保険料納入通知書（本算定）【ブック（口振依頼あり通知書＋納付書）タイプ】のBuilderクラスです。
 *
 * @reamsid_L DBB-9110-100 xuyue
 */
public class FuriKaeAriCoverToNofushoBuilderImpl implements IFuriKaeAriCoverToNofushoBuilder {

    private final IFuriKaeAriCoverToNofushoEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IFuriKaeAriCoverToNofushoEditor}
     */
    public FuriKaeAriCoverToNofushoBuilderImpl(IFuriKaeAriCoverToNofushoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link JuToGaishaKojinBangoKakuninListReportSource}
     */
    @Override
    public FuriKaeAriCoverToNofushoReportSource build() {
        return ReportEditorJoiner.from(new FuriKaeAriCoverToNofushoReportSource()).join(bodyEditor).buildSource();
    }

}
