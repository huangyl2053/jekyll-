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
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.IchijihanteikekkahyoItemSetteiA3;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.KumiawaseCommonBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa3.JimuShinsakaishiryoA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa3.JimuShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
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
import jp.co.ndensan.reams.uz.uza.biz.KamokuCode;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 事務局審査会資料組み合わせ一覧A4版のバッチ処理です。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class JimuShinsakaiSiryouKumiawaseA3Process extends SimpleBatchProcessBase {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(JimuShinsakaishiryoA3ReportSource.ReportSourceFields.tokkiText1.name()),
            new RString(JimuShinsakaishiryoA3ReportSource.ReportSourceFields.tokkiImg1.name())));
    private IinShinsakaiIinJohoProcessParameter paramter;
    private IJimuShiryoShinsakaiIinMapper mapper;
    private JimuShinsakaiIinJohoMyBatisParameter myBatisParameter;
    private List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private List<ShinsakaiTaiyosyaJohoEntity> shinsakaiTaiyosyaJohoList;
    private List<JimuShinsakaishiryoBusiness> businessList;
    private List<ShinsakaiSiryoKyotsuEntity> 共通情報;
    private List<ItiziHanteiEntity> itiziHanteiEntityList;
    private int データ件数 = 0;
    private int no;
    private int count;
    private boolean is審査会対象一覧印刷済み;
    private List<ShinsakaiTaiyosyaJohoEntity> 事務局審査会追加資料A3リスト;
    private KumiawaseCommonBusiness kumiawaseCommonBusiness;

    @BatchWriter
    private BatchReportWriter<JimuShinsakaishiryoA3ReportSource> batchReportWriter;
    private ReportSourceWriter<JimuShinsakaishiryoA3ReportSource> reportSourceWriter;

    static {
        System.setProperty("java.awt.headless", "true");
    }

    @Override
    protected void beforeExecute() {
        shinsakaiIinJohoList = new ArrayList<>();
        shinsakaiTaiyosyaJohoList = new ArrayList<>();
        businessList = new ArrayList<>();
        共通情報 = new ArrayList<>();
        itiziHanteiEntityList = new ArrayList<>();
        mapper = getMapper(IJimuShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toJimuShinsakaiIinJohoMyBatisParameter();
        myBatisParameter.setShoriJotaiKubun0(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setShoriJotaiKubun3(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        共通情報 = mapper.get共通情報(myBatisParameter);
        データ件数 = mapper.get事務局一次判定件数(myBatisParameter);
        itiziHanteiEntityList = mapper.get事務局一次判定(myBatisParameter);
        get審査対象者一覧表情報();
        is審査会対象一覧印刷済み = false;
        事務局審査会追加資料A3リスト = mapper.get審査会追加分(myBatisParameter);
        kumiawaseCommonBusiness = new KumiawaseCommonBusiness(shinsakaiIinJohoList, 共通情報, 事務局審査会追加資料A3リスト, count);
    }

    @Override
    protected void process() {
        RString reportId = ReportIdDBE.DBE517902.getReportId().value();
        batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId)
                .addBreak(new BreakerCatalog<JimuShinsakaishiryoA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .addBreak(new BreakerCatalog<JimuShinsakaishiryoA3ReportSource>().new SimpleLayoutBreaker(
                    JimuShinsakaishiryoA3ReportSource.LAYOUT_BREAK_KEYS) {
                    @Override
                    public ReportLineRecord<JimuShinsakaishiryoA3ReportSource> occuredBreak(
                            ReportLineRecord<JimuShinsakaishiryoA3ReportSource> currentRecord,
                            ReportLineRecord<JimuShinsakaishiryoA3ReportSource> nextRecord,
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
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        
        List<ShinseishoKanriNo> 申請書管理番号List = new ArrayList<>();
        kumiawaseCommonBusiness.set申請書管理番号リスト_一次判定結果(申請書管理番号List, itiziHanteiEntityList);
        kumiawaseCommonBusiness.set申請書管理番号リスト_共通情報(申請書管理番号List);
        
        int 審査番号 = 1;
        for (ShinseishoKanriNo shinseishoKanriNo : 申請書管理番号List) {
            kumiawaseCommonBusiness.setImageFilePath(shinseishoKanriNo, batchReportWriter.getImageFolderPath());
            JimuShinsakaishiryoA3Report report = new JimuShinsakaishiryoA3Report(businessList,
                    get一次判定結果票(shinseishoKanriNo),
                    kumiawaseCommonBusiness.getOpinionFileInfo(shinseishoKanriNo, true),
                    kumiawaseCommonBusiness.getOtherFileInfo(shinseishoKanriNo, true), 
                    kumiawaseCommonBusiness.getAdditionalFileInfo(shinseishoKanriNo, paramter,
                            ReportUtil.get通知文(SubGyomuCode.DBE認定支援, ReportIdDBE.DBE517009.getReportId(),
                                KamokuCode.EMPTY, 1, 1, FlexibleDate.getNowDate())),
                    reportId, 
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
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        myBatisParameter.setHaishiFlag_False(IsHaishi.有効.is廃止());
        myBatisParameter.setHaishiFlag_True(IsHaishi.廃止.is廃止());
        myBatisParameter.setShoriJotaiKubun0(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setShoriJotaiKubun3(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setSisutemuYMD(FlexibleDate.getNowDate());
        shinsakaiIinJohoList = mapper.get事務局委員氏名(myBatisParameter);
        count = mapper.get事務局情報件数(myBatisParameter);
        shinsakaiTaiyosyaJohoList = mapper.get事務局情報(myBatisParameter);
        no = 0;
        for (ShinsakaiTaiyosyaJohoEntity entity : shinsakaiTaiyosyaJohoList) {
            entity.setJimukyoku(true);
            JimuShinsakaishiryoBusiness business = new JimuShinsakaishiryoBusiness(paramter, entity, shinsakaiIinJohoList, no, count);
            businessList.add(business);
            no = no + 1;
        }
    }

    private IchijihanteikekkahyoA3Entity get一次判定結果票(ShinseishoKanriNo shinseishoKanriNo) {
        for (ItiziHanteiEntity entity : itiziHanteiEntityList) {
            ShinseishoKanriNo 申請書管理番号 = entity.getShinseishoKanriNo();
            if (shinseishoKanriNo.equals(申請書管理番号)) {
                ShinseishoKanriNo 前申請書管理番号 = entity.getZShinseishoKanriNo();
                int 認定調査依頼履歴番号 = entity.getNinteichosaIraiRirekiNo();
                int 主治医意見履歴番号 = entity.getIkenshoIraiRirekiNo();
                myBatisParameter.setShinseishoKanriNo(申請書管理番号);
                myBatisParameter.setNinteichosaRirekiNo(認定調査依頼履歴番号);
                myBatisParameter.setShinseishoKanriNoZ(前申請書管理番号);
                myBatisParameter.setIkenshoIraiRirekiNo(主治医意見履歴番号);
                List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付サービス利用状況 = new ArrayList<>();
                List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付サービス利用状況 = new ArrayList<>();
                List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書情報 = new ArrayList<>();
                DbT5208NinteichosahyoServiceJokyoFlagEntity サービス状況フラグ = new DbT5208NinteichosahyoServiceJokyoFlagEntity();
                if (ServiceKubunCode.予防給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
                    予防給付サービス利用状況 = mapper.get予防給付(myBatisParameter);
                } else if (ServiceKubunCode.介護給付サービス.getコード().equals(entity.getServiceKubunCode().getColumnValue())) {
                    介護給付サービス利用状況 = mapper.get介護給付(myBatisParameter);
                } else {
                    サービス状況フラグ = mapper.get状況フラグ(myBatisParameter);
                }
                List<DbT5205NinteichosahyoTokkijikoEntity> 特記事項 = mapper.get特記事項(myBatisParameter);
                List<DbT5304ShujiiIkenshoIkenItemEntity> 主治医意見書 = mapper.get主治医意見書(myBatisParameter);
                List<DbT5211NinteichosahyoChosaItemEntity> 調査票調査項目 = mapper.get調査票項目(myBatisParameter);
                List<DbT5211NinteichosahyoChosaItemEntity> 前回調査票調査項目 = mapper.get前回調査票項目(myBatisParameter);
                List<DbT5304ShujiiIkenshoIkenItemEntity> 前回主治医意見書 = mapper.get前回主治医意見書(myBatisParameter);
                ShinsakaiSiryoKyotsuEntity  審査会資料共通Entity = kumiawaseCommonBusiness.getCommonInfo(共通情報, entity.getShinseishoKanriNo(), true);
                List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報 = new ArrayList<>();
                if (審査会資料共通Entity != null) {
                    特記情報 = get特記情報(審査会資料共通Entity);
                }
                主治医意見書情報.addAll(主治医意見書);
                return new IchijihanteikekkahyoItemSetteiA3().set項目(entity, 特記事項,
                        調査票調査項目, 前回調査票調査項目, 主治医意見書情報,
                        前回主治医意見書, 予防給付サービス利用状況, 介護給付サービス利用状況, サービス状況フラグ, データ件数,
                        審査会資料共通Entity, 主治医意見書,
                        new RString(myBatisParameter.getGogitaiNo()), 特記情報, batchReportWriter.getImageFolderPath());
            }
        }
        return null;
    }

    private List<DbT5205NinteichosahyoTokkijikoEntity> get特記情報(ShinsakaiSiryoKyotsuEntity entity) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        List<Integer> 認定調査依頼履歴番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(entity.getShinseishoKanriNo());
        認定調査依頼履歴番号リスト.add(entity.getNinteichosaRirekiNo());
        myBatisParameter.setGenponMaskKubun(GenponMaskKubun.原本.getコード());
        myBatisParameter.setShinseishoKanriNoList(申請書管理番号リスト);
        myBatisParameter.setNinteichosaRirekiNoList(認定調査依頼履歴番号リスト);
        return mapper.get事務局特記情報(myBatisParameter);
    }

    @Override
    protected void afterExecute() {
    }
}
