/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jp.co.ndensan.reams.db.dbe.batchcontroller.step.shiryoshinsakai;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.IchijihanteikekkahyoA3Business;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.IchijihanteikekkahyoItemSetteiA3;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuTuikaSiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.KumiawaseCommonBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa3.IinShinsakaishiryoA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakaishiryo.IinShinsakaiShiryoA3Layouts;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.ShinsakaiSiryouKumiawaseA3ProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.TokkijikoIchiranJohoRelateEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.db.dbz.service.core.util.report.ReportUtil;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 委員審査会資料組み合わせ一覧A3版のバッチ処理です。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class IinShinsakaiSiryouKumiawaseA3Process extends SimpleBatchProcessBase {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(IinShinsakaishiryoA3ReportSource.ReportSourceFields.tokkiText1.name()),
            new RString(IinShinsakaishiryoA3ReportSource.ReportSourceFields.tokkiImg1.name())));
    private ShinsakaiSiryouKumiawaseA3ProcessParameter paramter;
    private IShiryoShinsakaiIinMapper mapper;
    private IinShinsakaiIinJohoMyBatisParameter 一覧表myBatisParameter;
    private IinTokkiJikouItiziHanteiMyBatisParameter 一次判定myBatisParameter;
    private List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private List<ShinsakaiTaiyosyaJohoEntity> shinsakaiTaiyosyaJohoList;
    private List<JimuShinsakaishiryoBusiness> jimuShinsakaishiryoList;
    private List<ShinsakaiSiryoKyotsuEntity> 共通情報;
    private List<ItiziHanteiEntity> itiziHanteiEntityList;
    private int データ件数;
    private int no;
    private int count;
    private boolean is審査会対象一覧印刷済み;
    private List<ShinsakaiTaiyosyaJohoEntity> 委員審査会追加資料A3リスト;
    private KumiawaseCommonBusiness kumiawaseCommonBusiness;

    @BatchWriter
    private BatchReportWriter<IinShinsakaishiryoA3ReportSource> batchReportWriter;
    private ReportSourceWriter<IinShinsakaishiryoA3ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        shinsakaiIinJohoList = new ArrayList<>();
        shinsakaiTaiyosyaJohoList = new ArrayList<>();
        jimuShinsakaishiryoList = new ArrayList<>();
        共通情報 = new ArrayList<>();
        itiziHanteiEntityList = new ArrayList<>();
        mapper = getMapper(IShiryoShinsakaiIinMapper.class);
        一覧表myBatisParameter = paramter.toIinShinsakaiIinJohoMyBatisParameter();
        一次判定myBatisParameter = paramter.toIinTokkiJikouItiziHanteiMyBatisParameter();
        List<RString> shoriJotaiKubunList = new ArrayList<>();
        shoriJotaiKubunList.add(ShoriJotaiKubun.通常.getコード());
        shoriJotaiKubunList.add(ShoriJotaiKubun.延期.getコード());
        一次判定myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        一次判定myBatisParameter.setShoriJotaiKubunList(shoriJotaiKubunList);
        共通情報 = mapper.getShinsakaiSiryoKyotsu(一次判定myBatisParameter);
        データ件数 = mapper.getTokkiJikouItiziHanteiCount(一次判定myBatisParameter);
        itiziHanteiEntityList = mapper.getTokkiJikouItiziHantei(一次判定myBatisParameter);
        委員審査会追加資料A3リスト = mapper.getShinsakaiTaiyosyaJoho(一覧表myBatisParameter);
        is審査会対象一覧印刷済み = false;
        get審査対象者一覧表情報();
        kumiawaseCommonBusiness = new KumiawaseCommonBusiness(shinsakaiIinJohoList, 共通情報, 委員審査会追加資料A3リスト, count);
    }

    @Override
    protected void process() {
        RString reportId = ReportIdDBE.DBE517904.getReportId().value();
        if (一覧表myBatisParameter.isSakuseiJokenTuika()) {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId)
                    .setStartFormGroup(IinShinsakaiShiryoA3Layouts.委員用追加資料.index())
                    .addBreak(new BreakerCatalog<IinShinsakaishiryoA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                    .addBreak(new BreakerCatalog<IinShinsakaishiryoA3ReportSource>().new SimpleLayoutBreaker(
                        IinShinsakaishiryoA3ReportSource.LAYOUT_BREAK_KEYS) {
                    @Override
                        public ReportLineRecord<IinShinsakaishiryoA3ReportSource> occuredBreak(
                                ReportLineRecord<IinShinsakaishiryoA3ReportSource> currentRecord,
                                ReportLineRecord<IinShinsakaishiryoA3ReportSource> nextRecord,
                                ReportDynamicChart dynamicChart) {
                                    int layout = currentRecord.getSource().layout;
                                    currentRecord.setFormGroupIndex(layout);
                                    if (nextRecord != null && nextRecord.getSource() != null) {
                                        layout = nextRecord.getSource().layout;
                                        nextRecord.setFormGroupIndex(layout);
                                    }
                                    return currentRecord;
                                }
                    }).create();
        } else {
            batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId)
                    .addBreak(new BreakerCatalog<IinShinsakaishiryoA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                    .addBreak(new BreakerCatalog<IinShinsakaishiryoA3ReportSource>().new SimpleLayoutBreaker(
                        IinShinsakaishiryoA3ReportSource.LAYOUT_BREAK_KEYS) {
                    @Override
                        public ReportLineRecord<IinShinsakaishiryoA3ReportSource> occuredBreak(
                                ReportLineRecord<IinShinsakaishiryoA3ReportSource> currentRecord,
                                ReportLineRecord<IinShinsakaishiryoA3ReportSource> nextRecord,
                                ReportDynamicChart dynamicChart) {
                                    int layout = currentRecord.getSource().layout;
                                    currentRecord.setFormGroupIndex(layout);
                                    if (nextRecord != null && nextRecord.getSource() != null) {
                                        layout = nextRecord.getSource().layout;
                                        nextRecord.setFormGroupIndex(layout);
                                    }
                                    return currentRecord;
                                }
                    }).create();
        }
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);

        List<ShinseishoKanriNo> 申請書管理番号List = new ArrayList<>();
        kumiawaseCommonBusiness.set申請書管理番号リスト_一次判定結果(申請書管理番号List, itiziHanteiEntityList);
        kumiawaseCommonBusiness.set申請書管理番号リスト_共通情報(申請書管理番号List);

        List<JimuTuikaSiryoBusiness> 審査追加対象者一覧 = get審査追加対象者一覧表情報(申請書管理番号List);
        int 審査番号 = 1;
        for (ShinseishoKanriNo shinseishoKanriNo : 申請書管理番号List) {
            kumiawaseCommonBusiness.setImageFilePath(shinseishoKanriNo, batchReportWriter.getImageFolderPath());
            IinShinsakaishiryoA3Report report = new IinShinsakaishiryoA3Report(jimuShinsakaishiryoList,
                    get特記事項と一次判定結果票情報(shinseishoKanriNo),
                    kumiawaseCommonBusiness.getOpinionFileInfo(shinseishoKanriNo, false),
                    kumiawaseCommonBusiness.getOtherFileInfo(shinseishoKanriNo, false),
                    審査追加対象者一覧,
                    is審査会対象一覧印刷済み,
                    paramter.getSakuseiJoken(),
                    paramter.getPrintHou(),
                    審査番号);
            report.writeBy(reportSourceWriter);
            is審査会対象一覧印刷済み = true;
            審査番号++;
        }
        batchReportWriter.close();
    }

    private void get審査対象者一覧表情報() {
        一覧表myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        一覧表myBatisParameter.setHaishiFlag_False(IsHaishi.有効.is廃止());
        一覧表myBatisParameter.setHaishiFlag_True(IsHaishi.廃止.is廃止());
        一覧表myBatisParameter.setSisutemuYMD(FlexibleDate.getNowDate());
        shinsakaiIinJohoList = mapper.getShinsakaiIinJoho(一覧表myBatisParameter);
        count = mapper.getShinsakaiTaiyosyaJohoCount(一覧表myBatisParameter);
        shinsakaiTaiyosyaJohoList = mapper.getShinsakaiTaiyosyaJoho(一覧表myBatisParameter);
        no = 0;
        for (ShinsakaiTaiyosyaJohoEntity entity : shinsakaiTaiyosyaJohoList) {
            entity.setShoKisaiHokenshaNo(RString.EMPTY);
            entity.setHihokenshaNo(RString.EMPTY);
            entity.setHihokenshaName(AtenaMeisho.EMPTY);
            entity.setJimukyoku(false);
            jimuShinsakaishiryoList.add(new JimuShinsakaishiryoBusiness(
                    paramter.toIinShinsakaiIinJohoProcessParameter(), entity, shinsakaiIinJohoList, no, count));
            no = no + 1;
        }
    }

    private IchijihanteikekkahyoA3Business get特記事項と一次判定結果票情報(ShinseishoKanriNo shinseishoKanriNo) {
        for (ItiziHanteiEntity entity : itiziHanteiEntityList) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                一次判定myBatisParameter.setShinseishoKanri(entity.getShinseishoKanriNo());
                一次判定myBatisParameter.setNinteichosaRirekiNo(entity.getNinteichosaIraiRirekiNo());
                一次判定myBatisParameter.setShinseishoKanriZ(entity.getZShinseishoKanriNo());
                一次判定myBatisParameter.setIkenshoIraiRirekiNo(entity.getIkenshoIraiRirekiNo());
                List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付サービス利用状況 = new ArrayList<>();
                List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付サービス利用状況 = new ArrayList<>();
                DbT5208NinteichosahyoServiceJokyoFlagEntity サービス状況フラグ = new DbT5208NinteichosahyoServiceJokyoFlagEntity();
                if (ServiceKubunCode.予防給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
                    予防給付サービス利用状況 = mapper.getYoboService(一次判定myBatisParameter);
                } else if (ServiceKubunCode.介護給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
                    介護給付サービス利用状況 = mapper.getKaigoService(一次判定myBatisParameter);
                } else {
                    サービス状況フラグ = mapper.getServiceJokyoFlag(一次判定myBatisParameter);
                }
                List<DbT5205NinteichosahyoTokkijikoEntity> 特記事項 = mapper.getTokkijiko(一次判定myBatisParameter);
                List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書 = mapper.getIkenshoIkenItem(一次判定myBatisParameter);
                List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目 = mapper.getChosahyoChosaItem(一次判定myBatisParameter);
                List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目 = mapper.getZenkaiChosahyoChosaItem(一次判定myBatisParameter);
                List<DbT5304ShujiiIkenshoIkenItemEntity> 前回主治医意見書 = mapper.getZenkaiIkenshoIkenItem(一次判定myBatisParameter);
                ShinsakaiSiryoKyotsuEntity 審査会資料共通Entity = kumiawaseCommonBusiness.getCommonInfo(共通情報, entity.getShinseishoKanriNo(), false);
                List<TokkijikoIchiranJohoRelateEntity> 特記情報 = get特記情報(審査会資料共通Entity);
                IchijihanteikekkahyoItemSetteiA3 一次判定結果票Item = new IchijihanteikekkahyoItemSetteiA3();
                IchijihanteikekkahyoA3Entity 一次判定結果票Entity = 一次判定結果票Item.set項目(entity,
                        調査票調査項目,
                        前回調査票調査項目,
                        主治医意見書,
                        前回主治医意見書,
                        予防給付サービス利用状況,
                        介護給付サービス利用状況,
                        サービス状況フラグ,
                        データ件数,
                        審査会資料共通Entity,
                        主治医意見書,
                        new RString(paramter.getGogitaiNo()),
                        特記情報,
                        batchReportWriter.getImageFolderPath());
                return new IchijihanteikekkahyoA3Business(一次判定結果票Entity, false);
            }
        }
        return null;
    }

    private List<TokkijikoIchiranJohoRelateEntity> get特記情報(ShinsakaiSiryoKyotsuEntity entity) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        List<Integer> 認定調査依頼履歴番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(entity.getShinseishoKanriNo());
        認定調査依頼履歴番号リスト.add(entity.getNinteichosaRirekiNo());
        一次判定myBatisParameter.setShinseishoKanriNoList(申請書管理番号リスト);
        一次判定myBatisParameter.setNinteichosaRirekiNoList(認定調査依頼履歴番号リスト);
        return mapper.getTokkiIranJoho(一次判定myBatisParameter);
    }

    private List<JimuTuikaSiryoBusiness> get審査追加対象者一覧表情報(List<ShinseishoKanriNo> 申請書管理番号リスト) {
        List<JimuTuikaSiryoBusiness> 審査追加対象者一覧 = new ArrayList<>();
        for (ShinseishoKanriNo 申請書管理番号 : 申請書管理番号リスト) {
            審査追加対象者一覧.add(kumiawaseCommonBusiness.getAdditionalFileInfo(申請書管理番号, paramter.toIinShinsakaiIinJohoProcessParameter(),
                    ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517009.getReportId(), KamokuCode.EMPTY, 1, 1, FlexibleDate.getNowDate())));
        }
        return 審査追加対象者一覧;
    }

    @Override
    protected void afterExecute() {
    }

}
