/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jp.co.ndensan.reams.db.dba.business.report.shikakushasho;

import jp.co.ndensan.reams.db.dba.entity.report.shikakushasho.ShikakushashoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 介護保険資格者証Builderクラスです。
 */
public class ShikakushashoBuilderImpl implements IShikakushashoBuilder {
    
    private final IShikakushashoEditor bodyEditor;
    
    /**
     * インスタンスを生成します。
     * 
     * @param bodyEditor {@link IShikakushashoEditor}
     */
    ShikakushashoBuilderImpl(IShikakushashoEditor bodyEditor) {
        this.bodyEditor = bodyEditor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return {@link ShikakushashoReportSource}
     */
    @Override
    public ShikakushashoReportSource build() {
        return ReportEditorJoiner.from(new ShikakushashoReportSource())
                .join(bodyEditor).buildSource();
    }
    
}
