/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.DBU060010;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReport;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlistchohyodatasakusei.KyokaisoKanriMasterListBusiness;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlistchohyodatasakusei.KyokaisoKanriMasterListChohyoDataSakusei;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kyokaisogaitosha.KyokaisoGaitoshaProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoKanriMasterListChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaListEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;
import jp.co.ndensan.reams.db.dbz.entity.db.relate.shutsuryokujun.ShutsuryokujunRelateEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.association.IAssociation;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchDbReader;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchKeyBreakBase;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.IBatchReader;
import jp.co.ndensan.reams.uz.uza.biz.Code;
import jp.co.ndensan.reams.uz.uza.biz.ShikibetsuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogType;
import jp.co.ndensan.reams.uz.uza.log.accesslog.AccessLogger;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.ExpandedInformation;
import jp.co.ndensan.reams.uz.uza.log.accesslog.core.PersonalData;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;

/**
 * バッチ設計_DBUMN52001_境界層管理マスタリストのバッチ処理クラスです。
 *
 * @reamsid_L DBU-1050-020 wanghui
 *
 */
public class KyokaisogGaitoshaReportPageBreakProcess extends BatchKeyBreakBase<KyokaisogGaitoshaRelateEntity> {

    private static final RString なし = new RString("なし");
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kyokaisogaitosha.IKkyokaisoGaitoshaMapper.getKyokaisoKanriMasterList");
    private KyokaisoKanriMasterListChohyoDataSakusei dataSakusei;
    List<KyokaisogGaitoshaRelateEntity> daichoJohoList = new ArrayList<>();
    private KyokaisogGaitoshaListEntity kyokaisokanrimasterList;
    private KyokaisoGaitoshaProcessParameter parameter;
    private KyokaisoKanriMasterListBusiness business;
    private KyokaisoKanriMasterListChohyoDataSakuseiEntity sakuseiEntity;
    private List<RString> pageBreakKeys;
    private ShutsuryokujunRelateEntity 出力順Entity;
    private boolean 出力;
    @BatchWriter
    private BatchReportWriter<KyokaisoKanriMasterListReportSource> batchReportWriter;
    private ReportSourceWriter<KyokaisoKanriMasterListReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        出力 = false;
        kyokaisokanrimasterList = new KyokaisogGaitoshaListEntity();
        dataSakusei = new KyokaisoKanriMasterListChohyoDataSakusei();
        business = new KyokaisoKanriMasterListBusiness();
        pageBreakKeys = new ArrayList<>();
        出力順Entity = get出力順項目();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, business.createMybatisParameter(出力順Entity.get出力順OrderBy(),
                parameter));
    }

    @Override
    protected void createWriter() {
        if (出力順Entity != null && 出力順Entity.getPageBreakKeys() != null) {
            pageBreakKeys = Collections.unmodifiableList(出力順Entity.getPageBreakKeys());
        }
        if (pageBreakKeys != null && !pageBreakKeys.isEmpty()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBA200005.getReportId().value())
                    .addBreak(new BreakerCatalog<KyokaisoKanriMasterListReportSource>().simplePageBreaker(pageBreakKeys)).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBA200005.getReportId().value()).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(KyokaisogGaitoshaRelateEntity entity) {

    }

    @Override
    protected void usualProcess(KyokaisogGaitoshaRelateEntity entity) {
        paramte();
        sakuseiEntity = dataSakusei.getcreateNenreiToutatsuYoteishaCheckListChohyo(kyokaisokanrimasterList, entity);
        KyokaisoKanriMasterListReport report = new KyokaisoKanriMasterListReport(sakuseiEntity);
        report.writeBy(reportSourceWriter);
        出力 = true;
        getアクセスログ(entity.getSeibetsuCode());

    }

    /**
     * アクセスログを出力するメッソドです。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void getアクセスログ(RString 識別コード) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード));
    }

    private PersonalData toPersonalData(RString 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("識別コード"), 識別コード);
        return PersonalData.of(new ShikibetsuCode(識別コード), expandedInfo);
    }

    private void paramte() {
        IAssociation association = AssociationFinderFactory.createInstance().getAssociation();
        kyokaisokanrimasterList.set市町村コード(association.get地方公共団体コード().getColumnValue());
        kyokaisokanrimasterList.set市町村名(association.get市町村名());
        kyokaisokanrimasterList.set並び順(出力順Entity.get出力順項目());
        kyokaisokanrimasterList.set改頁(出力順Entity.get改頁項目());
    }

    private void outputJokenhyoFactory() {
        RString 出力ページ数 = new RString(reportSourceWriter.pageCount().value());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item
                = new ReportOutputJokenhyoItem(ReportIdDBU.DBA200005.getReportId().value(),
                        association.getLasdecCode_().value(), association.get市町村名(),
                        new RString(String.valueOf(JobContextHolder.getJobId())),
                        ReportIdDBU.DBA200005.getReportName(),
                        出力ページ数,
                        なし,
                        RString.EMPTY,
                        business.contribute(parameter));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    @Override
    protected void afterExecute() {
        if (!出力) {
            paramte();
            sakuseiEntity = dataSakusei.getcreateNenreiToutatsuYoteishaCheckListChohyo(kyokaisokanrimasterList, null);
            KyokaisoKanriMasterListReport report = new KyokaisoKanriMasterListReport(sakuseiEntity);
            report.writeBy(reportSourceWriter);
        }
        outputJokenhyoFactory();
    }

    private ShutsuryokujunRelateEntity get出力順項目() {
        if (!parameter.getOrder_ID().isNull() && !parameter.getOrder_ID().isEmpty()) {
            return ReportUtil.get出力順情報(KyokaisoKanriMasterListBusiness.ShutsuryokujunEnum.class, SubGyomuCode.DBU介護統計報告,
                    ReportIdDBU.DBA200005.getReportId(),
                    Long.valueOf(parameter.getOrder_ID().toString()));
        }
        return new ShutsuryokujunRelateEntity();
    }
}
