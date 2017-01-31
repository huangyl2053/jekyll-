/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002;

import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.ShujiiIkenshoBusiness;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbz.business.report.ikenshokinyuyoshi.IkenshokinyuyoshiReport;
import jp.co.ndensan.reams.db.dbz.entity.report.ikenshokinyuyoshi.IkenshokinyuyoshiReportSource;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 主治医意見書記入用紙_片面_OCRの出力処理クラスです。
 */
public class KinyuYoshiUra extends BatchProcessBase<ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoTeishutsuIraishoHakkoMapper."
            + "get主治医意見書提出依頼書発行");
    private ReportId 帳票;
    private ShujiiIkenshoProcessParamter processParamter;
    private ShujiiIkenshoBusiness business;
    @BatchWriter
    private BatchReportWriter<IkenshokinyuyoshiReportSource> batchWriter;
    private ReportSourceWriter<IkenshokinyuyoshiReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        帳票 = new ReportId(DbBusinessConfig.get(
                ConfigNameDBE.主治医意見書_帳票ID_裏, RDate.getNowDate(), SubGyomuCode.DBE認定支援, processParamter.getShichosonCode()));
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShujiiIkenMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(帳票.value())
                .addBreak(new BreakerCatalog<IkenshokinyuyoshiReportSource>().simpleLayoutBreaker(IkenshokinyuyoshiReportSource.LAYOUT_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        business = new ShujiiIkenshoBusiness(entity, processParamter);
        IkenshokinyuyoshiReport report = new IkenshokinyuyoshiReport(business.create記入用紙(), 帳票);
        report.writeBy(reportSourceWriter);
    }

    @Override
    protected void afterExecute() {
        Association 導入団体クラス = AssociationFinderFactory.createInstance().getAssociation();
        RString 導入団体コード = 導入団体クラス.getLasdecCode_().value();
        RString 市町村名 = 導入団体クラス.get市町村名();
        RString 出力ページ数 = new RString(String.valueOf(reportSourceWriter.pageCount().value()));
        OutputJokenhyoFactory.createInstance(new ShujiiIkenshoBusiness(null, processParamter).
                バッチ出力条件リストの出力(市町村名,
                        出力ページ数,
                        導入団体コード,
                        帳票.value(),
                        new RString("主治医意見書記入用紙")))
                .print();
    }
}
