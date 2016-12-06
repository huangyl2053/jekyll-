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
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaiWariateJohoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuShinsakaishiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.core.shiryoshinsakai.JimuSonotashiryoBusiness;
import jp.co.ndensan.reams.db.dbe.business.report.iinshinsakaishiryoa3.IinShinsakaishiryoA3Report;
import jp.co.ndensan.reams.db.dbe.definition.core.reportid.ReportIdDBE;
import jp.co.ndensan.reams.db.dbe.definition.core.shinsakai.ShinsakaiOrderKakuteiFlg;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinShinsakaiIinJohoMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.mybatisprm.shiryoshinsakai.IinTokkiJikouItiziHanteiMyBatisParameter;
import jp.co.ndensan.reams.db.dbe.definition.processprm.shiryoshinsakai.ShinsakaiSiryouKumiawaseA3ProcessParameter;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.ichijihanteikekkahyo.IchijihanteikekkahyoA3Entity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ItiziHanteiEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiIinJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiSiryoKyotsuEntity;
import jp.co.ndensan.reams.db.dbe.entity.db.relate.shiryoshinsakai.ShinsakaiTaiyosyaJohoEntity;
import jp.co.ndensan.reams.db.dbe.entity.report.source.iinshinsakaishiryoa3.IinShinsakaishiryoA3ReportSource;
import jp.co.ndensan.reams.db.dbe.persistence.db.mapper.relate.shiryoshinsakai.IShiryoShinsakaiIinMapper;
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
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5211NinteichosahyoChosaItemEntity;
import jp.co.ndensan.reams.db.dbz.entity.db.basic.DbT5304ShujiiIkenshoIkenItemEntity;
import jp.co.ndensan.reams.ur.urz.business.core.association.Association;
import jp.co.ndensan.reams.ur.urz.business.report.outputjokenhyo.ReportOutputJokenhyoItem;
import jp.co.ndensan.reams.ur.urz.service.core.association.AssociationFinderFactory;
import jp.co.ndensan.reams.ur.urz.service.report.outputjokenhyo.OutputJokenhyoFactory;
import jp.co.ndensan.reams.uz.uza.batch.batchexecutor.util.JobContextHolder;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportFactory;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchReportWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.BatchWriter;
import jp.co.ndensan.reams.uz.uza.batch.process.SimpleBatchProcessBase;
import jp.co.ndensan.reams.uz.uza.biz.AtenaMeisho;
import jp.co.ndensan.reams.uz.uza.biz.SubGyomuCode;
import jp.co.ndensan.reams.uz.uza.lang.FlexibleDate;
import jp.co.ndensan.reams.uz.uza.lang.RDate;
import jp.co.ndensan.reams.uz.uza.lang.RString;
import jp.co.ndensan.reams.uz.uza.lang.RStringBuilder;
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
            new RString(IinShinsakaishiryoA3ReportSource.ReportSourceFields.six_tokkiText1.name()),
            new RString(IinShinsakaishiryoA3ReportSource.ReportSourceFields.six_tokkiImg1.name())));
    private static final RString 印字する = new RString("1");
    private static final RString 両面 = new RString("1");
    private static final int INT_4 = 4;
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
    private int shinsakaiOrder;
    private int 存在ファイルindex;
    @BatchWriter
    private BatchReportWriter<IinShinsakaishiryoA3ReportSource> batchReportWriter;
    private ReportSourceWriter<IinShinsakaishiryoA3ReportSource> reportSourceWriter;

    @Override
    protected void beforeExecute() {
        shinsakaiOrder = -1;
        存在ファイルindex = 0;
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

        get審査対象者一覧表情報();
    }

    @Override
    protected void process() {
        RString reportId;
        RDate 日期 = RDate.getNowDate();
        if (両面.equals(paramter.getPrintHou())
                && 印字する.equals(DbBusinessConfig.get(ConfigNameDBE.特記と意見書の見開き印刷有無, 日期, SubGyomuCode.DBE認定支援))) {
            reportId = ReportIdDBE.DBE517915.getReportId().value();
        } else {
            reportId = ReportIdDBE.DBE517916.getReportId().value();
        }
        batchReportWriter = BatchReportFactory.createBatchReportWriter(reportId)
                .addBreak(new BreakerCatalog<IinShinsakaishiryoA3ReportSource>().simplePageBreaker(PAGE_BREAK_KEYS))
                .addBreak(new BreakerCatalog<IinShinsakaishiryoA3ReportSource>().new SimpleLayoutBreaker(

                    IinShinsakaishiryoA3ReportSource.LAYOUT_BREAK_KEYS) {
                    @Override
                    public ReportLineRecord<IinShinsakaishiryoA3ReportSource> occuredBreak(
                            ReportLineRecord<IinShinsakaishiryoA3ReportSource> currentRecord,
                            ReportLineRecord<IinShinsakaishiryoA3ReportSource> nextRecord,
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
        List<ShinseishoKanriNo> 申請書管理番号List = new ArrayList<>();
        for (ItiziHanteiEntity entity : itiziHanteiEntityList) {
            if (!申請書管理番号List.contains(entity.getShinseishoKanriNo())) {
                申請書管理番号List.add(entity.getShinseishoKanriNo());
            }
        }
        for (ShinsakaiSiryoKyotsuEntity entity : 共通情報) {
            if (!申請書管理番号List.contains(entity.getShinseishoKanriNo())) {
                申請書管理番号List.add(entity.getShinseishoKanriNo());
            }
        }
        for (ShinseishoKanriNo shinseishoKanriNo : 申請書管理番号List) {
            reportSourceWriter = new ReportSourceWriter<>(batchReportWriter);
            IinShinsakaishiryoA3Report report = new IinShinsakaishiryoA3Report(jimuShinsakaishiryoList,
                    get特記事項と一次判定結果票情報(shinseishoKanriNo),
                    get主治医意見書情報(shinseishoKanriNo),
                    getその他資料情報(shinseishoKanriNo), reportId);
            report.writeBy(reportSourceWriter);
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

    private IchijihanteikekkahyoA3Entity get特記事項と一次判定結果票情報(ShinseishoKanriNo shinseishoKanriNo) {
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
                List<DbT5205NinteichosahyoTokkijikoEntity> 特記情報 = new ArrayList<>();
                if (get共通情報(共通情報, entity.getShinseishoKanriNo()) != null) {
                    特記情報 = get特記情報(get共通情報(共通情報, entity.getShinseishoKanriNo()));
                }
                return new IchijihanteikekkahyoItemSetteiA3().set項目(entity, 特記事項,
                        調査票調査項目, 前回調査票調査項目, 主治医意見書,
                        前回主治医意見書, 予防給付サービス利用状況, 介護給付サービス利用状況, サービス状況フラグ, データ件数,
                        get共通情報(共通情報, entity.getShinseishoKanriNo()), 主治医意見書, new RString(paramter.getGogitaiNo()), 特記情報);
            }
        }
        return null;
    }

    private JimuShinsakaiWariateJohoBusiness get主治医意見書情報(ShinseishoKanriNo shinseishoKanriNo) {
        for (ShinsakaiSiryoKyotsuEntity entity : 共通情報) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                entity.setHihokenshaNo(RString.EMPTY);
                entity.setHihokenshaName(AtenaMeisho.EMPTY);
                entity.setShoKisaiHokenshaNo(RString.EMPTY);
                entity.setJimukyoku(false);
                return new JimuShinsakaiWariateJohoBusiness(entity);
            }
        }
        return null;
    }

    private JimuSonotashiryoBusiness getその他資料情報(ShinseishoKanriNo shinseishoKanriNo) {
        JimuSonotashiryoBusiness その他資料 = null;
        for (ShinsakaiSiryoKyotsuEntity entity : 共通情報) {
            if (shinseishoKanriNo.equals(entity.getShinseishoKanriNo())) {
                entity.setHihokenshaNo(RString.EMPTY);
                entity.setHihokenshaName(AtenaMeisho.EMPTY);
                entity.setShoKisaiHokenshaNo(RString.EMPTY);
                entity.setJimukyoku(false);
                if (shinsakaiOrder != entity.getShinsakaiOrder()) {
                    存在ファイルindex = 0;
                }
                その他資料 = new JimuSonotashiryoBusiness(entity, new ArrayList(), 存在ファイルindex);
                存在ファイルindex = その他資料.get存在ファイルIndex();
                shinsakaiOrder = entity.getShinsakaiOrder();
            }
        }
        return その他資料;
    }

    private ShinsakaiSiryoKyotsuEntity get共通情報(List<ShinsakaiSiryoKyotsuEntity> 共通情報,
            ShinseishoKanriNo 申請書管理番号) {
        for (ShinsakaiSiryoKyotsuEntity 共通情報Entity : 共通情報) {
            if (申請書管理番号.equals(共通情報Entity.getShinseishoKanriNo())) {
                return 共通情報Entity;
            }
        }
        return null;
    }

    private List<DbT5205NinteichosahyoTokkijikoEntity> get特記情報(ShinsakaiSiryoKyotsuEntity entity) {
        List<ShinseishoKanriNo> 申請書管理番号リスト = new ArrayList<>();
        List<Integer> 認定調査依頼履歴番号リスト = new ArrayList<>();
        申請書管理番号リスト.add(entity.getShinseishoKanriNo());
        認定調査依頼履歴番号リスト.add(entity.getNinteichosaRirekiNo());
        一次判定myBatisParameter.setGenponMaskKubun(GenponMaskKubun.原本.getコード());
        一次判定myBatisParameter.setShinseishoKanriNoList(申請書管理番号リスト);
        一次判定myBatisParameter.setNinteichosaRirekiNoList(認定調査依頼履歴番号リスト);
        return mapper.getTokkiIranJoho(一次判定myBatisParameter);
    }

    @Override
    protected void afterExecute() {
        outputJokenhyoFactory(ReportIdDBE.DBE517001.getReportId().value(), get帳票名());
        outputJokenhyoFactory(ReportIdDBE.DBE517041.getReportId().value(), new RString("概況調査の特記"));
        outputJokenhyoFactory(ReportIdDBE.DBE517031.getReportId().value(), new RString("特記事項（1枚目）"));
        outputJokenhyoFactory(ReportIdDBE.DBE517085.getReportId().value(), new RString("一次判定結果票"));
        outputJokenhyoFactory(ReportIdDBE.DBE517034.getReportId().value(), new RString("特記事項（2枚目以降）"));
        outputJokenhyoFactory(ReportIdDBE.DBE517005.getReportId().value(), new RString("主治医意見書"));
        outputJokenhyoFactory(ReportIdDBE.DBE517006.getReportId().value(), new RString("その他資料"));
    }

    private RString get帳票名() {
        RString 介護認定審査会開催番号 = paramter.getShinsakaiKaisaiNo();
        RStringBuilder 帳票名 = new RStringBuilder();
        帳票名.append(介護認定審査会開催番号.substring(介護認定審査会開催番号.length() - INT_4));
        帳票名.append(new RString("　審査会"));
        return 帳票名.toRString();
    }

    private void outputJokenhyoFactory(RString id, RString 帳票名) {
        RString 総ページ数 = new RString(batchReportWriter.getPageCount());
        Association association = AssociationFinderFactory.createInstance().getAssociation();
        ReportOutputJokenhyoItem jokenhyoItem = new ReportOutputJokenhyoItem(
                id,
                association.getLasdecCode_().getColumnValue(),
                association.get市町村名(),
                new RString(String.valueOf(JobContextHolder.getJobId())),
                帳票名,
                総ページ数,
                RString.EMPTY,
                RString.EMPTY,
                出力条件());
        OutputJokenhyoFactory.createInstance(jokenhyoItem).print();
    }

    private List<RString> 出力条件() {
        List<RString> list = new ArrayList<>();
        RStringBuilder builder1 = new RStringBuilder();
        builder1.append("【合議体番号】")
                .append(" ")
                .append(paramter.getGogitaiNo());
        RStringBuilder builder2 = new RStringBuilder();
        builder2.append("【介護認定審査会開催予定年月日】")
                .append(" ")
                .append(paramter.getShinsakaiKaisaiYoteiYMD().wareki().toDateString());
        RStringBuilder builder3 = new RStringBuilder();
        builder3.append("【介護認定審査会開催番号】")
                .append(" ")
                .append(paramter.getShinsakaiKaisaiNo());
        list.add(builder1.toRString());
        list.add(builder2.toRString());
        list.add(builder3.toRString());
        return list;
    }

}
