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
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.IchijihanteikekkahyoItemSettei;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.TokkiText1A4Business;
import jp.co.ndensan.reams.db.dbe.business.report.jimushinsakaishiryoa4.JimuShinsakaishiryoA4Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.JimuShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.IinShinsakaiIinJohoProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA4Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.jimushinsakaishiryoa4.JimuShinsakaishiryoA4ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IJimuShiryoShinsakaiIinMapper;
import jp.co.ndensan.reams.db.dbx.definition.core.configkeys.ConfigNameDBE;
import jp.co.ndensan.reams.db.dbx.definition.core.dbbusinessconfig.DbBusinessConfig;
import jp.co.ndensan.reams.db.dbx.definition.core.valueobject.domain.ShinseishoKanriNo;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.GenponMaskKubun;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.IsHaishi;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.chosain.ServiceKubunCode;
import jp.co.ndensan.reams.db.dbz.definition.core.yokaigonintei.shinsei.ShoriJotaiKubun;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5205NinteichosahyoTokkijikoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5207NinteichosahyoServiceJokyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5208NinteichosahyoServiceJokyoFlagEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5210NinteichosahyoShisetsuRiyoEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog;
import jp.co.ndensan.reams.uz.uza.report.BreakerCatalog.SimpleLayoutBreaker;
import jp.co.ndensan.reams.uz.uza.report.ReportLineRecord;
import jp.co.ndensan.reams.uz.uza.report.ReportSourceWriter;
import jp.co.ndensan.reams.uz.uza.report.data.chart.ReportDynamicChart;

/**
 * 事務局審査会資料組み合わせ一覧A4版のバッチ処理です。
 *
 * @reamsid_L DBE-0150-200 lishengli
 */
public class JimuShinsakaiSiryouKumiawaseA4Process extends SimpleBatchProcessBase {

    private static final List<RString> PAGE_BREAK_KEYS = Collections.unmodifiableList(Arrays.asList(
            new RString(JimuShinsakaishiryoA4ReportSource.ReportSourceFields.three_tokkiText.name()),
            new RString(JimuShinsakaishiryoA4ReportSource.ReportSourceFields.three_tokkiImg.name())));
    private static final RString 印字する = new RString("1");
    private static final RString 両面 = new RString("2");
    private IinShinsakaiIinJohoProcessParameter paramter;
    private IJimuShiryoShinsakaiIinMapper mapper;
    private JimuShinsakaiIinJohoMyBatisParameter myBatisParameter;
    private List<ShinsakaiIinJohoEntity> shinsakaiIinJohoList;
    private List<ShinsakaiTaiyosyaJohoEntity> shinsakaiTaiyosyaJohoList;
    private List<JimuShinsakaishiryoBusiness> jimuShinsakaishiryoBusinessList;
    private List<ItiziHanteiEntity> itiziHanteiEntityList;
    private List<IchijihanteikekkahyoA4Entity> ichijihanteikekkahyoA4EntityList;
    private List<ShinsakaiSiryoKyotsuEntity> shinsakaiSiryoKyotsuEntityList;
    private List<TokkiText1A4Business> tokkiText1A4BusinessList;
    private List<JimuShinsakaiWariateJohoBusiness> jimuShinsakaiWariateJohoBusinessList;
    private List<JimuSonotashiryoBusiness> jimuSonotashiryoBusinessList;
    private int no;
    private int count;
    private int shinsakaiOrder;
    private int 存在ファイルindex;
    @BatchWriter
    private BatchReportWriter<JimuShinsakaishiryoA4ReportSource> batchReportWriter;
    private ReportSourceWriter<JimuShinsakaishiryoA4ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {

        shinsakaiOrder = -1;
        存在ファイルindex = 0;
        shinsakaiIinJohoList = new ArrayList<>();
        shinsakaiTaiyosyaJohoList = new ArrayList<>();
        jimuShinsakaishiryoBusinessList = new ArrayList<>();
        itiziHanteiEntityList = new ArrayList<>();
        ichijihanteikekkahyoA4EntityList = new ArrayList<>();
        shinsakaiSiryoKyotsuEntityList = new ArrayList<>();
        tokkiText1A4BusinessList = new ArrayList<>();
        jimuShinsakaiWariateJohoBusinessList = new ArrayList<>();
        jimuSonotashiryoBusinessList = new ArrayList<>();
        mapper = getMapper(IJimuShiryoShinsakaiIinMapper.class);
        myBatisParameter = paramter.toJimuShinsakaiIinJohoMyBatisParameter();
        myBatisParameter.setShoriJotaiKubun0(ShoriJotaiKubun.通常.getコード());
        myBatisParameter.setShoriJotaiKubun3(ShoriJotaiKubun.延期.getコード());
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        shinsakaiSiryoKyotsuEntityList = mapper.get共通情報(myBatisParameter);
        get審査対象者一覧表情報();
        get一次判定結果票情報();
        get特記事項情報();
        get主治医意見書情報();
        getその他資料情報();
    }

    @Override
    protected void process() {
        RString reportId;
        RDate 日期 = RDate.getNowDate();
        if (両面.equals(paramter.getPrintHou())
                && 印字する.equals(DbBusinessConfig.get(ConfigNameDBE.特記と意見書の見開き印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
            reportId = ReportIdDBE.DBE517904.getReportId().value();
        } else {
            reportId = ReportIdDBE.DBE517901.getReportId().value();
        }

        batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId)
                .addBreak(new BreakerCatalog<JimuShinsakaishiryoA4ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .addBreak(new BreakerCatalog<JimuShinsakaishiryoA4ReportSource>().new SimpleLayoutBreaker(
                    JimuShinsakaishiryoA4ReportSource.LAYOUT_BREAK_KEYS) {
                    @Override
                    public ReportLineRecord<JimuShinsakaishiryoA4ReportSource> occuredBreak(
                            ReportLineRecord<JimuShinsakaishiryoA4ReportSource> currentRecord,
                            ReportLineRecord<JimuShinsakaishiryoA4ReportSource> nextRecord,
                            ReportDynamicChart dynamicChart) {
                                int layout = currentRecord.getSource().layout.index();
                                currentRecord.setFormGroupIndex(layout);
                                if (nextRecord != null && nextRecord.getSource() != null) {
                                    layout = nextRecord.getSource().layout.index();
                                    nextRecord.setFormGroupIndex(layout);
                                }
                                return currentRecord;
                            }
                }).create();
        reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
        int 件数;
        if (ichijihanteikekkahyoA4EntityList.size() < shinsakaiSiryoKyotsuEntityList.size()) {
            件数 = shinsakaiSiryoKyotsuEntityList.size();
        } else {
            件数 = ichijihanteikekkahyoA4EntityList.size();
        }
        for (int i = 0; i < 件数; i++) {
            IchijihanteikekkahyoA4Entity ichijihanteikekkahyoA4Entity = null;
            TokkiText1A4Business tokkiTextBusiness = null;
            JimuShinsakaiWariateJohoBusiness shinsakaiWariateJoho = null;
            JimuSonotashiryoBusiness sonotashiryoBusiness = null;
            if (i < ichijihanteikekkahyoA4EntityList.size()) {
                ichijihanteikekkahyoA4Entity = ichijihanteikekkahyoA4EntityList.get(i);
            }
            if (i < shinsakaiSiryoKyotsuEntityList.size()) {
                tokkiTextBusiness = tokkiText1A4BusinessList.get(i);
                shinsakaiWariateJoho = jimuShinsakaiWariateJohoBusinessList.get(i);
                sonotashiryoBusiness = jimuSonotashiryoBusinessList.get(i);
            }
            JimuShinsakaishiryoA4Report report = new JimuShinsakaishiryoA4Report(jimuShinsakaishiryoBusinessList,
                    ichijihanteikekkahyoA4Entity,
                    tokkiTextBusiness,
                    shinsakaiWariateJoho,
                    sonotashiryoBusiness,
                    reportId);
            report.writeBy(reportSourceWriter);
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
        jimuShinsakaishiryoBusinessList = new ArrayList<>();
        for (ShinsakaiTaiyosyaJohoEntity entity : shinsakaiTaiyosyaJohoList) {
            entity.setJimukyoku(true);
            jimuShinsakaishiryoBusinessList.add(new JimuShinsakaishiryoBusiness(paramter, entity, shinsakaiIinJohoList, no, count));
        }
    }

    private void get一次判定結果票情報() {
        myBatisParameter.setOrderKakuteiFlg(ShinsakaiOrderKakuteiFlg.確定.is介護認定審査会審査順確定());
        itiziHanteiEntityList = mapper.get事務局一次判定結果(myBatisParameter);
        for (ItiziHanteiEntity entity : itiziHanteiEntityList) {
            ShinseishoKanriNo 申請書管理番号 = entity.getShinseishoKanriNo();
            ShinseishoKanriNo 前申請書管理番号 = entity.getZShinseishoKanriNo();
            int 認定調査依頼履歴番号 = entity.getNinteichosaIraiRirekiNo();
            int 主治医意見履歴番号 = entity.getIkenshoIraiRirekiNo();
            myBatisParameter.setShinseishoKanriNo(申請書管理番号);
            myBatisParameter.setNinteichosaRirekiNo(認定調査依頼履歴番号);
            myBatisParameter.setShinseishoKanriNoZ(前申請書管理番号);
            myBatisParameter.setIkenshoIraiRirekiNo(主治医意見履歴番号);
            List<DbT5207NinteichosahyoServiceJokyoEntity> 予防給付サービス利用状況 = new ArrayList<>();
            List<DbT5207NinteichosahyoServiceJokyoEntity> 介護給付サービス利用状況 = new ArrayList<>();
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
            DbT5210NinteichosahyoShisetsuRiyoEntity 現在状況 = mapper.get現在状況(myBatisParameter);
            List<DbT5304ShujiiIkenshoIkenItemEntity> 前回主治医意見書 = mapper.get前回主治医意見書(myBatisParameter);
            IchijihanteikekkahyoA4Entity item = new IchijihanteikekkahyoItemSettei().set項目(entity, 特記事項,
                    調査票調査項目, 前回調査票調査項目, 主治医意見書,
                    前回主治医意見書, 予防給付サービス利用状況, 介護給付サービス利用状況, サービス状況フラグ, 現在状況,
                    new RString(myBatisParameter.getGogitaiNo()));
            ichijihanteikekkahyoA4EntityList.add(item);
        }
    }

    private void get特記事項情報() {
        for (ShinsakaiSiryoKyotsuEntity kyotsuEntity : shinsakaiSiryoKyotsuEntityList) {
            kyotsuEntity.setJimukyoku(true);
            List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報List = get特記情報(kyotsuEntity);
            tokkiText1A4BusinessList.add(new TokkiText1A4Business(kyotsuEntity, 特記情報List));
        }
    }

    private void get主治医意見書情報() {
        for (ShinsakaiSiryoKyotsuEntity kyotsuEntity : shinsakaiSiryoKyotsuEntityList) {
            kyotsuEntity.setJimukyoku(true);
            jimuShinsakaiWariateJohoBusinessList.add(new JimuShinsakaiWariateJohoBusiness(kyotsuEntity));
        }
    }

    private void getその他資料情報() {
        for (ShinsakaiSiryoKyotsuEntity entity : shinsakaiSiryoKyotsuEntityList) {
            entity.setJimukyoku(true);
            if (shinsakaiOrder != entity.getShinsakaiOrder()) {
                存在ファイルindex = 0;
            }
            JimuSonotashiryoBusiness business = new JimuSonotashiryoBusiness(entity, 存在ファイルindex);
            存在ファイルindex = business.get存在ファイルIndex();
            shinsakaiOrder = entity.getShinsakaiOrder();
            jimuSonotashiryoBusinessList.add(business);
        }
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
}
