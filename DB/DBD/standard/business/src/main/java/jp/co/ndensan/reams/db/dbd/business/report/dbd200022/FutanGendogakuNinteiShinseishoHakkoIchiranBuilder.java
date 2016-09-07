/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200022;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd200022.FutanGendogakuNinteiShinseishoHakkoIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 負担限度額認定申請書発行一覧表Builderクラスです。
 *
 * @reamsid_L DBD-3530-090 b_liuyang2
 */
public class FutanGendogakuNinteiShinseishoHakkoIchiranBuilder implements IFutanGendogakuNinteiShinseishoHakkoIchiranBuilder {

    private final IFutanGendogakuNinteiShinseishoHakkoIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IFutanGendogakuNinteiShinseishoHakkoIchiranEditor}
     */
    FutanGendogakuNinteiShinseishoHakkoIchiranBuilder(IFutanGendogakuNinteiShinseishoHakkoIchiranEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FutanGendogakuNinteiShinseishoHakkoIchiranReportSource}
     */
    @Override
    public FutanGendogakuNinteiShinseishoHakkoIchiranReportSource build() {
        return ReportEditorJoiner.from(new FutanGendogakuNinteiShinseishoHakkoIchiranReportSource()).join(bodyEditor).buildSource();
    }
}
