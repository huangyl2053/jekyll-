/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dba.business.report.kogakugassankaigo;

import jp.co.ndensan.reams.db.dba.entity.report.kogakugassankaigo.KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource;
import jp.co.ndensan.reams.uz.uza.report.ReportEditorJoiner;

/**
 *
 * 高額医療合算介護（介護予防）サービス費支給兼自己負担額証明書交付申請書のBuilderクラスです。
 */
public class KogakuGassanKaigoServicehiShikyuKofuShinseishoItemBuilder
        implements IKogakuGassanKaigoServicehiShikyuKofuShinseishoBuilder {

    private final IKogakuGassanKaigoServicehiShikyuKofuShinseishoEditor editor;

    /**
     * インスタンスを生成します。
     *
     * @param editor
     * {@link IKogakuGassanKaigoServicehiShikyuKofuShinseishoEditor}
     */
    public KogakuGassanKaigoServicehiShikyuKofuShinseishoItemBuilder(IKogakuGassanKaigoServicehiShikyuKofuShinseishoEditor editor) {
        this.editor = editor;
    }

    /**
     * 帳票ソースをビルドします。
     *
     * @return
     * {@link KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource}
     */
    @Override
    public KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource build() {
        return ReportEditorJoiner.from(new KogakuGassanKaigoServicehiShikyuKofuShinseishoReportSource()).join(editor).buildSource();
    }
}
