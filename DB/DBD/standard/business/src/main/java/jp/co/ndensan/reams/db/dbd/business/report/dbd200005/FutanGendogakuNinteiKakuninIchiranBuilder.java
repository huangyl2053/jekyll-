/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbd.business.report.dbd200005;

import jp.co.ndensan.reams.db.dbd.entity.report.dbd200005.FutanGendogakuNinteiKakuninIchiranReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 * 負担限度額認定（一括）確認リストBuilderクラスです。
 *
 * @reamsid_L DBD-3710-100 b_liuyang2
 */
public class FutanGendogakuNinteiKakuninIchiranBuilder implements IFutanGendogakuNinteiKakuninIchiranBuilder {

    private final IFutanGendogakuNinteiKakuninIchiranEditor bodyEditor;

    /**
     * インスタンスを生成します。
     *
     * @param bodyEditor {@link IFutanGendogakuNinteiKakuninIchiranEditor}
     */
    FutanGendogakuNinteiKakuninIchiranBuilder(IFutanGendogakuNinteiKakuninIchiranEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link FutanGendogakuNinteiKakuninIchiranReportSource}
     */
    @Override
    public FutanGendogakuNinteiKakuninIchiranReportSource build() {
        return ReportEditorJoiner.from(new FutanGendogakuNinteiKakuninIchiranReportSource()).join(bodyEditor).buildSource();
    }
}
