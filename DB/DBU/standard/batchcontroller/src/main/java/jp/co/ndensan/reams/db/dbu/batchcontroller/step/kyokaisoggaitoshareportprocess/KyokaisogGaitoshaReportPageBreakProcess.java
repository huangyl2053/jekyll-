/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbu.batchcontroller.step.kyokaisoggaitoshareportprocess;

import java.util.ArrayList;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.ninteichosadataoutput.NinteiChosaDataOutputResult;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListBodyItem;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListHeadItem;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReport;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlistchohyodatasakusei.KyokaisoKanriMasterListBusiness;
import jp.co.ndensan.reams.db.dbu.business.report.kyokaisokanrimasterlistchohyodatasakusei.KyokaisoKanriMasterListChohyoDataSakusei;
import jp.co.ndensan.reams.db.dbu.definition.processprm.kyokaisogaitosha.KyokaisoGaitoshaProcessParameter;
import jp.co.ndensan.reams.db.dbu.definition.reportid.ReportIdDBU;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisoKanriMasterListChohyoDataSakuseiEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaListEntity;
import jp.co.ndensan.reams.db.dbu.entity.db.relate.kyokaisogaitosha.KyokaisogGaitoshaRelateEntity;
import jp.co.ndensan.reams.db.dbu.entity.report.kyokaisokanrimasterlist.KyokaisoKanriMasterListReportSource;
import jp.co.ndensan.reams.db.dbz.business.core.util.report.ChohyoUtil;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.core.association.IAssociation;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.IOutputOrder;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.ISetSortItem;
import jp.co.ndensan.reams.ur.urz.business.core.reportoutputorder.MyBatisOrderByClauseCreator;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.ChohyoShutsuryokujunFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.core.reportoutputorder.IChohyoShutsuryokujunFinder;
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
    private static final int NUM5 = 5;
    private static final RString MYBATIS_SELECT_ID = new RString(
            "jp.co.ndensan.reams.db.dbu.persistence.db.mapper.relate.kyokaisogaitosha.IKkyokaisoGaitoshaMapper.getKyokaisoKanriMasterList");
    private KyokaisoKanriMasterListHeadItem headItem;
    private List<KyokaisoKanriMasterListBodyItem> bodyItemList;
    private KyokaisoKanriMasterListChohyoDataSakusei dataSakusei;
    List<KyokaisogGaitoshaRelateEntity> daichoJohoList = new ArrayList<>();
    private KyokaisogGaitoshaListEntity kyokaisokanrimasterList;
    private KyokaisoGaitoshaProcessParameter parameter;
    private KyokaisoKanriMasterListBusiness business;
    private List<RString> 並び順list;
    private List<RString> 改頁list;
    private int 連番 = 1;
    @BatchWriter
    private BatchReportWriter<KyokaisoKanriMasterListReportSource> batchReportWriter;
    private ReportSourceWriter<KyokaisoKanriMasterListReportSource> reportSourceWriter;

    @Override
    protected void initialize() {
        kyokaisokanrimasterList = new KyokaisogGaitoshaListEntity();
        bodyItemList = new ArrayList<>();
        dataSakusei = new KyokaisoKanriMasterListChohyoDataSakusei();
        並び順list = new ArrayList<>();
        改頁list = new ArrayList<>();
        business = new KyokaisoKanriMasterListBusiness();
    }

    @Override
    protected IBatchReader createReader() {
        return new BatchDbReader(MYBATIS_SELECT_ID, business.createMybatisParameter(get出力順(), parameter));
    }

    @Override
    protected void createWriter() {
        batchReportWriter = BatchReportFactory.createBatchReportWriter(ReportIdDBU.DBA200005.getReportId().value())
                .addBreak(new BreakerCatalog<KyokaisoKanriMasterListReportSource>().simpleLayoutBreaker(改頁list)).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
    }

    @Override
    protected void keyBreakProcess(KyokaisogGaitoshaRelateEntity entity) {
        if (hasBrek(getBefore(), entity)) {
            連番 = 1;
            KyokaisoKanriMasterListReport report = KyokaisoKanriMasterListReport.createFrom(headItem, bodyItemList);
            report.writeBy(reportSourceWriter);
            bodyItemList = new ArrayList<>();
        }
    }

    private boolean hasBrek(KyokaisogGaitoshaRelateEntity before, KyokaisogGaitoshaRelateEntity current) {
        return !before.getHihokenshaNo().equals(current.getHihokenshaNo());
    }

    @Override
    protected void usualProcess(KyokaisogGaitoshaRelateEntity entity) {
        dataSakusei.getcreateNenreiToutatsuYoteishaCheckListChohyo(kyokaisokanrimasterList);
        daichoJohoList.add(entity);
        new NinteiChosaDataOutputResult().getアクセスログ(entity.getSeibetsuCode());
    }

    /**
     * アクセスログを出力するメッソドです。
     *
     * @param 識別コード ShikibetsuCode
     */
    public void getアクセスログ(ShikibetsuCode 識別コード) {
        AccessLogger.log(AccessLogType.照会, toPersonalData(識別コード));
    }

    private PersonalData toPersonalData(ShikibetsuCode 識別コード) {
        ExpandedInformation expandedInfo = new ExpandedInformation(new Code("0003"), new RString("被保険者番号"), RString.EMPTY);
        return PersonalData.of(識別コード, expandedInfo);
    }

    private void paramte() {
        IAssociation association = AssociationFinderFactory.createInstance().getAssociation();
        kyokaisokanrimasterList.set市町村コード(association.get地方公共団体コード().getColumnValue());
        kyokaisokanrimasterList.set市町村名(association.get市町村名());
        kyokaisokanrimasterList.set並び順(並び順list);
        kyokaisokanrimasterList.set改頁(改頁list);
    }

    private void outputJokenhyoFactory(int pageCnt) {
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem item
                = new ReportOutputJokenhyoItem(ReportIdDBU.DBA200005.getReportId().value(),
                        association.getLasdecCode_().value(), association.get市町村名(),
                        new RString(String.valueOf(JobContextHolder.getJobId())),
                        ReportIdDBU.DBA200005.getReportName(),
                        new RString(String.valueOf(pageCnt)),
                        なし,
                        RString.EMPTY,
                        business.contribute(parameter));
        OutputJokenhyoFactory.createInstance(item).print();
    }

    private KyokaisoKanriMasterListBodyItem setBodyItem(KyokaisoKanriMasterListChohyoDataSakuseiEntity entity) {
        return new KyokaisoKanriMasterListBodyItem(entity.get被保険者番号(),
                entity.getカナ氏名(),
                entity.get性別(),
                entity.get種別(),
                entity.get状態(),
                entity.get生年月日(),
                entity.get該当開始日(),
                entity.get給付額減額解除(),
                entity.get居住費軽減後居室種類(),
                entity.get識別コード(),
                entity.get氏名(),
                entity.get世帯コード(),
                entity.get該当申請日(),
                entity.get該当終了日(),
                entity.get標準負担減額後負担額(),
                entity.get居住費軽減後負担額(),
                entity.get食費軽減後負担額(),
                entity.get高額ｻｰﾋﾞｽ費減額後上限額(),
                entity.get保険料納付減額後保険料段階());
    }

    @Override
    protected void afterExecute() {
        paramte();
        kyokaisokanrimasterList.setKyokaisokanrimasterList(daichoJohoList);
        List<KyokaisoKanriMasterListChohyoDataSakuseiEntity> 帳票データ = dataSakusei
                .getcreateNenreiToutatsuYoteishaCheckListChohyo(kyokaisokanrimasterList);
        for (KyokaisoKanriMasterListChohyoDataSakuseiEntity dataSakuseiEntity : 帳票データ) {
            if (dataSakuseiEntity.get被保険者番号() != null) {
                bodyItemList.add(setBodyItem(dataSakuseiEntity));
            }
            headItem = new KyokaisoKanriMasterListHeadItem(
                    dataSakuseiEntity.get印刷日時(),
                    dataSakuseiEntity.get市町村コード(),
                    dataSakuseiEntity.get市町村名(),
                    dataSakuseiEntity.get並び順1(),
                    dataSakuseiEntity.get並び順2(),
                    dataSakuseiEntity.get並び順3(),
                    dataSakuseiEntity.get並び順4(),
                    dataSakuseiEntity.get並び順5(),
                    dataSakuseiEntity.get改頁1(),
                    dataSakuseiEntity.get改頁2(),
                    dataSakuseiEntity.get改頁3(),
                    dataSakuseiEntity.get改頁4(),
                    dataSakuseiEntity.get改頁5());
        }
        if (!bodyItemList.isEmpty() || headItem != null) {
            KyokaisoKanriMasterListReport report = KyokaisoKanriMasterListReport.createFrom(headItem, bodyItemList);
            report.writeBy(reportSourceWriter);
            outputJokenhyoFactory(帳票データ.size());
        }
    }

    private RString get出力順() {
        IChohyoShutsuryokujunFinder finder = ChohyoShutsuryokujunFinderFactory.createInstance();
        IOutputOrder outputOrder = finder.get出力順(SubGyomuCode.DBU介護統計報告, ReportIdDBU.DBA200005.getReportId(),
                Long.valueOf(parameter.getOrder_ID().toString()));
        RString 出力順 = RString.EMPTY;
        if (outputOrder != null) {
            出力順 = ChohyoUtil.get出力順OrderBy(MyBatisOrderByClauseCreator.create(
                    KyokaisoKanriMasterListBusiness.ShutsuryokujunEnum.class, outputOrder), NUM5);
            List<ISetSortItem> 設定項目リスト = outputOrder.get設定項目リスト();
            for (ISetSortItem iSetSortItem : 設定項目リスト) {
                RString 並び順 = iSetSortItem.get項目名();
                並び順list.add(並び順);
                if (iSetSortItem.is改頁項目()) {
                    RString 改頁 = iSetSortItem.get項目名();
                    改頁list.add(改頁);
                }
            }
        }
        return 出力順.replace("order by", "");
    }
}
