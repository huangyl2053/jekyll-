/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.DBE240002;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.iraishoikkatsuhakko.ShujiiIkenshoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranReport;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.processprm.hakkoichiranhyo.ShujiiIkenshoProcessParamter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.hakkoichiranhyo.ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.shujiiikenshoseikyuichiran.ShujiiIkenshoSeikyuIchiranReportSource;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.ikensho.SakuseiryoSeikyuKubun;
import jp.co.ndensan.reams.db.dbz.definition.mybatisprm.ikenshoprint.ShujiiIkenshoHoshuTankaParameter;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.ikenshoprint.ShujiiIkenshoHoshuTankaEntity;
import jp.co.ndensan.reams.db.dbz.service.core.ikenshoprint.ChosaIraishoAndChosahyoAndIkenshoPrintFinder;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchProcessBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ReportId;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * 帳票「主治医意見書作成料請求一覧表」の出力処理クラスです。
 *
 * @reamsid_L DBE-0080-130 duanzhanli
 */
public class ShujiiIkenshoSeikyuIchiranProcess extends BatchProcessBase<ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity> {

    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.hakkoichiranhyo.IShujiiIkenshoTeishutsuIraishoHakkoMapper."
            + "get主治医意見書提出依頼書発行");
    private static final ReportId 帳票ID = ReportIdDBE.DBE013006.getReportId();
    private static final List<RString> PAGE_BREAK_KEYS = Collections
            .unmodifiableList(Arrays.asList(new RString(ShujiiIkenshoSeikyuIchiranReportSource.ReportSourceFields.shichosonName.name())));
    private ShujiiIkenshoProcessParamter processParamter;
    private int index;
    @BatchWriter
    private BatchReportWriter<ShujiiIkenshoSeikyuIchiranReportSource> batchWriter;
    private ReportSourceWriter<ShujiiIkenshoSeikyuIchiranReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        index = 0;
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, processParamter.toShujiiIkenMybatisParameter());
    }

    @Override
    protected void createWriter() {
        batchWriter = BatchReportFactory.createBatchReportWriter(帳票ID.value())
                .addBreak(new BreakerCatalog<ShujiiIkenshoSeikyuIchiranReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .create();
        reportSourceWriter = new ReportSourceWriter<>(batchWriter);
    }

    @Override
    protected void process(ShujiiIkenshoTeishutsuIraishoHakkoRelateEntity entity) {
        RString 在宅施設区分 = RString.EMPTY;
        RString 回数区分 = RString.EMPTY;
        if (new Code(SakuseiryoSeikyuKubun.在宅新規.getコード()).equals(entity.getDbt5301Entity().getSakuseiryoSeikyuKubun())) {
            在宅施設区分 = new RString("1");
            回数区分 = new RString("1");
        } else if (new Code(SakuseiryoSeikyuKubun.施設新規.getコード()).equals(entity.getDbt5301Entity().getSakuseiryoSeikyuKubun())) {
            在宅施設区分 = new RString("2");
            回数区分 = new RString("1");
        } else if (new Code(SakuseiryoSeikyuKubun.在宅継続.getコード()).equals(entity.getDbt5301Entity().getSakuseiryoSeikyuKubun())) {
            在宅施設区分 = new RString("1");
            回数区分 = new RString("2");
        } else if (new Code(SakuseiryoSeikyuKubun.施設継続.getコード()).equals(entity.getDbt5301Entity().getSakuseiryoSeikyuKubun())) {
            在宅施設区分 = new RString("2");
            回数区分 = new RString("2");
        }
        ShujiiIkenshoHoshuTankaParameter param = ShujiiIkenshoHoshuTankaParameter.createParameter(在宅施設区分, 回数区分);
        List<ShujiiIkenshoHoshuTankaEntity> 意見書作成料リスト = ChosaIraishoAndChosahyoAndIkenshoPrintFinder.createInstance().get主治医意見書作成料報酬単価(param);
        ShujiiIkenshoSeikyuIchiranReport report = new ShujiiIkenshoSeikyuIchiranReport(
                new ShujiiIkenshoBusiness(entity, processParamter).setDBE013006Entity(意見書作成料リスト), index++);
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
                        ReportIdDBE.DBE013006.getReportId().value(), ReportIdDBE.DBE013006.getReportName())).print();
    }
}
