/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.business.report.ikenshoshujiiichiran;

import jp.co.ndensan.reams.db.dbe.entity.db.relate.ikenshoshujiiichiran.IkenshoShujiiIchiranRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.ShujiiIryokikanShujiiIchiranhyoReportSource;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.Report;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医医療機関・主治医一覧表のReportです。
 *
 * @reamsid_L DBE-0260-020 zuotao
 */
public class IkenshoShujiiIchiranReport extends Report<ShujiiIryokikanShujiiIchiranhyoReportSource> {

    private final IkenshoShujiiIchiranRelateEntity bodyItem;
    private final IkenshoShujiiIchiranHeadItem headItem;
    private final RString 市町村コード;
    private final RString 市町村名称;

    /**
     * インスタンスを生成します。
     *
     * @param 市町村コード RString
     * @param 市町村名称 RString
     * @param headItem 主治医医療機関・主治医一覧表ヘッダのITEM
     * @param bodyItem 主治医医療機関・主治医一覧表のITEM
     */
    public IkenshoShujiiIchiranReport(
            RString 市町村コード,
            RString 市町村名称,
            IkenshoShujiiIchiranHeadItem headItem,
            IkenshoShujiiIchiranRelateEntity bodyItem) {
        this.市町村コード = 市町村コード;
        this.市町村名称 = 市町村名称;
        this.headItem = headItem;
        this.bodyItem = bodyItem;
    }

    @Override
    public void writeBy(ReportSourceWriter<ShujiiIryokikanShujiiIchiranhyoReportSource> reportSourceWriter) {
        IkenshoShujiiIchiranEditor headerEditor = new IkenshoShujiiIchiranHeaderEditor(headItem);
        IkenshoShujiiIchiranEditor bodyEditor = new IkenshoShujiiIchiranBodyEditor(bodyItem);
        IkenshoShujiiIchiranBuilder builder = new IkenshoShujiiIchiranBuilderImpl(headerEditor, bodyEditor);
        reportSourceWriter.writeLine(builder);
    }
}
